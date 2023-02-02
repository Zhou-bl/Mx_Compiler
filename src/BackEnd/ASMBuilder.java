package BackEnd;

import BackEnd.Compound.ASMBlock;
import BackEnd.Compound.ASMFunction;
import BackEnd.Compound.ASMModule;
import BackEnd.Instruction.*;
import BackEnd.Operand.*;
import FrontEnd.LLVM_IR.BasicClass.User;
import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.Compound.IRFunction;
import FrontEnd.LLVM_IR.Compound.IRModule;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.Instruction.*;
import FrontEnd.LLVM_IR.Operand.BoolConstant;
import FrontEnd.LLVM_IR.Operand.IntConstant;
import FrontEnd.LLVM_IR.Operand.NullConstant;
import FrontEnd.LLVM_IR.Operand.StringConstant;
import FrontEnd.LLVM_IR.TypePackage.*;

public class ASMBuilder implements IRVisitor {
    public ASMModule targetModule;
    public ASMFunction curFunction;
    public ASMBlock curBlock;

    private boolean checkRange(String op, int offset){
        if(op.equals("sub") || op.equals("mul") || op.equals("div") || op.equals("rem")){
            return false;
        } else {
            return offset >= -2048 && offset < 2048;
        }
    }

    private void recurDown(Value node){
        if(node instanceof IRBasicBlock){
            if(node.ASMOperand == null) ((IRBasicBlock) node).accept(this);
        }else{
            assert node instanceof User;
            if(node.ASMOperand == null) ((User) node).accept(this);
        }
    }

    private void generateArithInst(String op, Register dest, BasicOperand rs1, BasicOperand rs2){
        if(rs1 instanceof Imm){
            Register immReg = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstruction(curBlock).addOperand(immReg, rs1);
            rs1 = immReg;
        }
        if(rs2 instanceof Imm){
            if(checkRange(op, ((Imm) rs2).value)){
                //在 -2048 ~ 2048 之间: 直接操作
                new ArithInstruction(curBlock, op).addOperand(dest, rs1, rs2);
            } else {
                Register immReg = new VirtualRegister(curFunction.virtualIndex++);
                new LiInstruction(curBlock).addOperand(immReg, rs2);
                new ArithInstruction(curBlock, op).addOperand(dest, rs1, immReg);
            }
        } else {
            new ArithInstruction(curBlock, op).addOperand(dest, rs1, rs2);
        }
    }

    @Override
    public void visit(IRModule node){
        targetModule = new ASMModule();
        //String const:
        for(int i = 0; i < node.stringConstantArrayList.size(); ++i){
            StringConstant cur = node.stringConstantArrayList.get(i);
            cur.ASMOperand = new GlobalVar(cur.name, cur.value);
            targetModule.globalVarArrayList.add((GlobalVar) cur.ASMOperand);
        }

        //global variables:
        for(int i = 0; i < node.globalDefArrayList.size(); ++i){
            GlobalDefInst cur = node.globalDefArrayList.get(i);
            cur.ASMOperand = new GlobalVar(cur.name);
            targetModule.globalVarArrayList.add((GlobalVar) cur.ASMOperand);
        }

        //functions:
        for(int i = 0; i < node.functionArrayList.size(); ++i){
            IRFunction cur = node.functionArrayList.get(i);
            cur.ASMOperand = new ASMFunction(cur.name);
            ((ASMFunction) cur.ASMOperand).isBuiltin = cur.isBuiltin;
            int parameterSize = ((FunctionType) cur.type).parameterTypeList.size();
            for(int j = 0; j < parameterSize && j <= 7; ++j){
                ((ASMFunction) cur.ASMOperand).arguments.add(new VirtualRegister(((ASMFunction)cur.ASMOperand).virtualIndex++, 10 + j));
            }
            for(int j = 8; j < parameterSize; ++j){
                Imm offset = ((ASMFunction) cur.ASMOperand).allocStack().getReverse();
                Register parameter = new VirtualRegister(((ASMFunction) cur.ASMOperand).virtualIndex++, 8, offset);
                parameter.inMem = true;
                //暂时放在内存中
                ((ASMFunction) cur.ASMOperand).arguments.add(parameter);
            }
            for(int j = 0; j < cur.operands.size(); ++j){
                cur.getOperand(j).ASMOperand = ((ASMFunction) cur.ASMOperand).arguments.get(j);
            }
            for(int j = 0; j < cur.basicBlockArrayList.size(); ++j){
                IRBasicBlock curBlock = cur.basicBlockArrayList.get(j);
                curBlock.ASMOperand = new ASMBlock((ASMFunction) cur.ASMOperand, curBlock.name);
            }
            targetModule.ASMFunctionArrayList.add((ASMFunction) cur.ASMOperand);
        }

        //global init:
        for(int i = 0; i < node.globalInitList.size(); ++i){
            IRFunction cur = node.globalInitList.get(i);
            cur.ASMOperand = new ASMFunction(cur.name);
            for(int j = 0; j < cur.basicBlockArrayList.size(); ++j){
                IRBasicBlock curBlock = cur.basicBlockArrayList.get(j);
                curBlock.ASMOperand = new ASMBlock((ASMFunction) cur.ASMOperand, curBlock.name);
            }
            targetModule.ASMFunctionArrayList.add((ASMFunction) cur.ASMOperand);
        }
        IRFunction tmp = null;
        for(int i = 0; i < node.globalInitList.size(); ++i){
            node.globalInitList.get(i).accept(this);
        }
        if(node.globalInitList.size() != 0){
            for(IRFunction func : node.globalInitList){
                if(func.name.equals("Global_init0")) tmp = func;
            }
            assert tmp != null;
            for(IRFunction func : node.functionArrayList){
                if(func.name.equals("main")){
                    func.getEntryBlock().instructionLinkedList.addFirst(new CallInst(null, tmp));
                }
            }
        }
        node.functionArrayList.forEach(func -> func.accept(this));
    }


    @Override
    public void visit(IRFunction node){
        if(node.isBuiltin ) return;
        curFunction = (ASMFunction) node.ASMOperand;
        curBlock = curFunction.getEntryBlock();
        new MoveInstruction(curBlock).addOperand(new VirtualRegister(curFunction.virtualIndex++, 9),new VirtualRegister(curFunction.virtualIndex++, 8));
        Register tmpReg = new VirtualRegister(curFunction.virtualIndex++);
        new MoveInstruction(curBlock).addOperand(tmpReg, new VirtualRegister(curFunction.virtualIndex++, 9));
        node.basicBlockArrayList.forEach(ele -> ele.accept(this));
        curBlock = curFunction.getExitBlock();
        new MoveInstruction(curBlock).addOperand(new VirtualRegister(curFunction.virtualIndex++, 8), tmpReg);
    }

    @Override
    public void visit(IRBasicBlock node){
        curBlock = (ASMBlock) node.ASMOperand;
        node.instructionLinkedList.forEach(ele -> ele.accept(this));
        node.terminator.accept(this);
    }

    @Override
    public void visit(BinaryInst node){
        for(int i = 0; i < node.operands.size(); ++i){
            recurDown(node.operands.get(i));
        }
        String op;
        switch (node.opType){
            case sdiv -> op = "div";
            case srem -> op = "rem";
            case shl -> op = "sll";
            case ashr -> op = "sra";
            default -> op = node.opType.toString();
        }
        Register newOperand = new VirtualRegister(curFunction.virtualIndex++);
        generateArithInst(op, newOperand, node.getOperand(0).ASMOperand, node.getOperand(1).ASMOperand);
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(AllocInst node){
        //pointer is 4 byte:
        node.ASMOperand = new VirtualRegister(curFunction.virtualIndex++, 8, curFunction.allocStack().getReverse());
    }

    @Override
    public void visit(BitcastInst node){
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    @Override
    public void visit(IcmpInst node){
        Register newOperand = new VirtualRegister(curFunction.virtualIndex++);
        node.operands.forEach(ele -> recurDown(ele));
        BasicOperand rs1, rs2;
        rs1 = node.getOperand(0).ASMOperand;
        rs2 = node.getOperand(1).ASMOperand;
        Imm tmpImm = null;
        //处理立即数:
        if(rs1 instanceof Imm){
            tmpImm = (Imm) rs1;
            rs1 = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstruction(curBlock).addOperand(rs1, tmpImm);
        }
        if(rs2 instanceof Imm){
            tmpImm = (Imm) rs2;
            rs2 = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstruction(curBlock).addOperand(rs2, tmpImm);
        }
        switch (node.opType){
            case sgt -> new ArithInstruction(curBlock, "slt").addOperand(newOperand, rs2, rs1);
            case slt -> new ArithInstruction(curBlock, "slt").addOperand(newOperand, rs1, rs2);
            case sge -> {
                new ArithInstruction(curBlock, "slt").addOperand(newOperand, rs1, rs2);
                new ArithInstruction(curBlock, "xor").addOperand(newOperand, newOperand, new Imm(1));
            }
            case sle -> {
                new ArithInstruction(curBlock, "slt").addOperand(newOperand, rs2, rs1);
                new ArithInstruction(curBlock, "xor").addOperand(newOperand, newOperand, new Imm(1));
            }
            case eq -> {
                new ArithInstruction(curBlock, "xor").addOperand(newOperand, rs1, rs2);
                new PseudoInstruction(curBlock, "seqz").addOperand(newOperand, newOperand);
                //seqz rd, rs1: if(rs1 == 0) rd = 1; else rd = 0;
            }
            case ne -> {
                new ArithInstruction(curBlock, "xor").addOperand(newOperand, rs1, rs2);
                new PseudoInstruction(curBlock, "snez").addOperand(newOperand, newOperand);
                //snez rd, rs1: if(rs1 != 0) rd = 1; else rd = 0;
            }
            default -> throw new RuntimeException("[Bug] unknown icmp opType.");
        }
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(TruncInst node){
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    @Override
    public void visit(ZextInst node) {
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    @Override
    public void visit(BranchInst node){
        node.ASMOperand = null;
        node.operands.forEach(this::recurDown);
        if(node.operands.size() != 1){
            //多分支
            //br flag block1 block2
            //转化为如下ASM代码:
            //bne flag zero block1
            //j block2
            BasicOperand flag = node.getOperand(0).ASMOperand;
            if(flag instanceof Imm){
                Imm tmpImm = new Imm(((Imm) flag).value);
                flag = new VirtualRegister(curFunction.virtualIndex++);
                new LiInstruction(curBlock).addOperand(flag, tmpImm);
            }
            new BranchInstruction(curBlock, "bne").addOperand(node.getOperand(1).ASMOperand, flag, PhysicalRegister.getPhyReg(0));
            new JumpInstruction(curBlock).addOperand(node.getOperand(2).ASMOperand);
            curBlock.successorArrayList.add((ASMBlock) node.getOperand(1).ASMOperand);
            curBlock.successorArrayList.add((ASMBlock) node.getOperand(2).ASMOperand);
        } else {
            //j targetBlock:
            new JumpInstruction(curBlock).addOperand(node.getOperand(0).ASMOperand);
            curBlock.successorArrayList.add((ASMBlock) node.getOperand(0).ASMOperand);
        }
    }

    @Override
    public void visit(CallInst node){
        ASMFunction targetFunc = (ASMFunction) node.operands.get(0).ASMOperand;
        node.operands.forEach(this::recurDown);
        for(int i = 0; i <= 7 && i < node.operands.size() - 1; ++i){
            BasicOperand src = node.getOperand(i + 1).ASMOperand;
            if(src instanceof Imm){
                new LiInstruction(curBlock).addOperand(targetFunc.arguments.get(i), src);
            } else {
                new MoveInstruction(curBlock).addOperand(targetFunc.arguments.get(i), src);
            }
        }
        for(int i = 8; i < node.operands.size() - 1; ++i){
            //将参数暂时放到内存中:
            BasicOperand src = node.getOperand(i + 1).ASMOperand;
            Register curArgReg = null;
            if(src instanceof Imm){
                //立即数作为参数,先load imm 再store到内存中:
                curArgReg = new VirtualRegister(curFunction.virtualIndex);
                new LiInstruction(curBlock).addOperand(curArgReg, src);
            } else {
                //src instance of register:
                curArgReg = (Register) src;
            }
            new StoreInstruction(curBlock,"sw").addOperand(curArgReg,new VirtualRegister(curFunction.virtualIndex++, 2, targetFunc.arguments.get(i).offset.getReverse()));
        }
        Register backReg = new VirtualRegister(curFunction.virtualIndex++);
        new MoveInstruction(curBlock).addOperand(backReg,new VirtualRegister(curFunction.virtualIndex++, 1));
        new CallInstruction(curBlock).addOperand(targetFunc);
        new MoveInstruction(curBlock).addOperand(new VirtualRegister(curFunction.virtualIndex++, 1),backReg);
        //处理返回值:
        if(!(node.type instanceof VoidType)){
            Register resValueReg = new VirtualRegister(curFunction.virtualIndex++);
            new MoveInstruction(curBlock).addOperand(resValueReg, new VirtualRegister(curFunction.virtualIndex++, 10));
            node.ASMOperand = resValueReg;
        }
    }

    @Override
    public void visit(LoadInst node){
        Register nodeOperand = new VirtualRegister(curFunction.virtualIndex++);
        recurDown(node.getOperand(0));
        BasicOperand pointerOperand = node.getOperand(0).ASMOperand;
        if(pointerOperand instanceof GlobalVar){
            //address 是二级指针, 需要先把address load出来
            Register address = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstruction(curBlock).addOperand(address, pointerOperand);
            address.offset = new Imm(0);
            new LoadInstruction(curBlock, "lw").addOperand(nodeOperand, address);
        } else {
            //pointer 应存在 register 中:
            new LoadInstruction(curBlock, "lw").addOperand(nodeOperand, pointerOperand);
        }
        node.ASMOperand = nodeOperand;
    }

    @Override
    public void visit(StoreInst node){
        recurDown(node.getOperand(0)); recurDown(node.getOperand(1));
        BasicOperand value, address, tmpValue;
        value = node.getOperand(0).ASMOperand; address = node.getOperand(1).ASMOperand;
        tmpValue = value;
        if(value instanceof Imm){
            tmpValue = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstruction(curBlock).addOperand(tmpValue, value);
        } else {
            //tmpValue is Register
            if(((Register) tmpValue).inMem){
                Register tmpReg = new VirtualRegister(curFunction.virtualIndex++);
                new LoadInstruction(curBlock, "lw").addOperand(tmpReg, value);
                tmpValue = tmpReg;
            }
        }

        if(address instanceof Register){
            new StoreInstruction(curBlock, "sw").addOperand(tmpValue, address);
        } else {
            //GlobalVar:
            //记录地址到tmpReg 中:
            Register tmpReg = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstruction(curBlock).addOperand(tmpReg, address);
            tmpReg.offset = new Imm(0);
            new StoreInstruction(curBlock, "sw").addOperand(tmpValue, tmpReg);
        }
        node.ASMOperand = null;
    }

    @Override
    public void visit(RetInst node){
        if(!(node.type instanceof VoidType)){
            recurDown(node.getOperand(0));
            BasicOperand resValue = node.getOperand(0).ASMOperand;
            Register x10 = new VirtualRegister(curFunction.virtualIndex++, 10);
            new MoveInstruction(curBlock).addOperand(x10, resValue);
        }
        node.ASMOperand = null;
    }

    @Override
    public void visit(GepInst node){
        BasicOperand nodeOperand = null;
        node.operands.forEach(this::recurDown);
        BasicOperand basePointer = node.getOperand(0).ASMOperand;
        IRType baseType = node.getOperand(0).type.deReference();
        if(baseType instanceof ArrayType){
            //string:
            //二级指针:load address:
            nodeOperand = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstruction(curBlock).addOperand(nodeOperand, basePointer);
        } else if(baseType instanceof StructType){
            //class:
            //计算offset:
            basePointer = new VirtualRegister((VirtualRegister) basePointer);
            int offset;
            offset = ((StructType) baseType).getOffset(((IntConstant) node.getOperand(2)).value);
            nodeOperand = basePointer;
            ((Register) nodeOperand).offset = new Imm(offset);
        } else {
            //array
            //ir 已经处理成了一维的情况，高维数组不用担心:
            basePointer = new VirtualRegister((VirtualRegister) basePointer);
            Value index = node.getOperand(1);
            //imm or register:
            if(index instanceof IntConstant){
                int offset;
                offset = ((IntConstant) index).value * baseType.typeSize();
                nodeOperand = new VirtualRegister(curFunction.virtualIndex++);
                generateArithInst("add", (Register) nodeOperand, basePointer, new Imm(offset));
            } else {
                //计算index:
                Register indexReg = new VirtualRegister(curFunction.virtualIndex++);
                generateArithInst("mul", indexReg , index.ASMOperand, new Imm(baseType.typeSize()));
                nodeOperand = new VirtualRegister(curFunction.virtualIndex++);
                generateArithInst("add", (Register) nodeOperand, basePointer, indexReg);
                ((Register) nodeOperand).offset = new Imm(0);
            }
        }
        node.ASMOperand = nodeOperand;
    }

    @Override
    public void visit(BoolConstant node){
        node.ASMOperand = new Imm(node.value ? 1 : 0);
    }

    @Override
    public void visit(IntConstant node){
        node.ASMOperand = new Imm(node.value);
    }

    @Override
    public void visit(NullConstant node){
        node.ASMOperand = new Imm(0);
    }

    @Override
    public void visit(StringConstant node){
        node.ASMOperand = new GlobalVar(node.name, node.value);
    }

    @Override
    public void visit(GlobalDefInst node){
        node.ASMOperand = new GlobalVar(node.name);
    }
}
