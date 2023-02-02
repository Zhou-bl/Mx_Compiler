package BackEnd.RegAlloc;

import BackEnd.Compound.ASMBlock;
import BackEnd.Compound.ASMFunction;
import BackEnd.Compound.ASMModule;
import BackEnd.Instruction.*;
import BackEnd.Operand.Imm;
import BackEnd.Operand.PhysicalRegister;
import BackEnd.Operand.VirtualRegister;

import java.util.HashMap;
import java.util.ListIterator;

public class StackAlloc {
    public ASMModule targetModule;
    public HashMap<String, Integer> regTable;
    public StackAlloc(ASMModule _targetModule){
        targetModule = _targetModule;
        regTable = new HashMap<>();
    }

    private void defineVirtualRegOffset(ASMFunction curFunc, String regName){
        //确定virtualReg在栈中的偏移量:
        if(!regTable.containsKey(regName)){
            int offset = curFunc.allocStack().value;
            regTable.put(regName, offset);
        }
    }

    private int getVirtualRegOffset(String regName){
        Integer res = regTable.get(regName);
        if(res == null){
            throw new RuntimeException("[Bug] unknown reg offset.");
        }
        return res;
    }

    private void preProcess(ASMFunction curFunc){
        curFunc.blockArrayList.forEach(curBlock ->
            curBlock.instructionList.forEach(curInst -> {
                if(curInst.rd instanceof VirtualRegister rd){
                    if(rd.color == 32){
                        defineVirtualRegOffset(curFunc, rd.getName());
                    }
                }
                if(curInst.rs1 instanceof VirtualRegister rs1){
                    if(rs1.color == 32){
                        defineVirtualRegOffset(curFunc, rs1.getName());
                    }
                }
                if(curInst.rs2 instanceof VirtualRegister rs2){
                    if(rs2.color == 32){
                        defineVirtualRegOffset(curFunc, rs2.getName());
                    }
                }
            })
        );
    }

    private void loadRsReg(ListIterator<ASM_Instruction> _iter, String _name, int _offset){
        _iter.previous();
        if(_offset < 2048){
            ASM_Instruction loadForInst = new LoadInstruction(null, "lw").addOperand(new PhysicalRegister(_name), new PhysicalRegister("s0", new Imm(-_offset)));
            _iter.add(loadForInst);
        } else {
            //load imm:
            ASM_Instruction loadImm = new LiInstruction(null).addOperand(new PhysicalRegister("t3"), new Imm(-_offset));
            ASM_Instruction calculateAddress = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("t3"), new PhysicalRegister("s0"), new PhysicalRegister("t3"));
            ASM_Instruction loadForInst = new LoadInstruction(null, "lw").addOperand(new PhysicalRegister(_name), new PhysicalRegister("t3"));
            _iter.add(loadImm);
            _iter.add(calculateAddress);
            _iter.add(loadForInst);
        }
        _iter.next();
    }

    private void storeRdValue(ListIterator<ASM_Instruction> _iter, String _name, int _offset){
        if(_offset < 2048){
            ASM_Instruction storeForInst = new StoreInstruction(null, "sw").addOperand(new PhysicalRegister(_name), new PhysicalRegister("s0", new Imm(-_offset)));
            _iter.add(storeForInst);
        } else {
            ASM_Instruction loadImm = new LiInstruction(null).addOperand(new PhysicalRegister("t3"), new Imm(-_offset));
            ASM_Instruction calculateAddress = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("t3"), new PhysicalRegister("s0"), new PhysicalRegister("t3"));
            ASM_Instruction storeForInst = new StoreInstruction(null, "sw").addOperand(new PhysicalRegister(_name), new PhysicalRegister("t3"));
            _iter.add(loadImm);
            _iter.add(calculateAddress);
            _iter.add(storeForInst);
        }
    }

    private void regAlloc(ASMFunction curFunc){
        for(int i = 0; i < curFunc.blockArrayList.size(); ++i){
            ASMBlock curBlock = curFunc.blockArrayList.get(i);
            ListIterator<ASM_Instruction> curInstIter = curBlock.instructionList.listIterator();
            //注意这里不能写这样的循环，因为有插入指令的过程导致size会一直变化:
            /*
            for(int j = 0; j < curBlock.instructionList.size(); ++j){
                ASM_Instruction curInstruction = curBlock.instructionList.get(j);
                curInstIter.next(); //指向当前元素
                //先把 rs1, rs2 从内存中load出来
                if(curInstruction.rs1 instanceof VirtualRegister rs1){
                    if(rs1.color != 32){
                        curInstruction.rs1 = new PhysicalRegister(rs1);
                    } else {
                        int regOffset = getVirtualRegOffset(rs1.getName());
                        curInstruction.rs1 = new PhysicalRegister(rs1, 6);
                        loadRsReg(curInstIter, "t1", regOffset);
                    }
                }
                if(curInstruction.rs2 instanceof VirtualRegister rs2){
                    if(rs2.color != 32){
                        curInstruction.rs2 = new PhysicalRegister(rs2);
                    } else {
                        int regOffset = getVirtualRegOffset(rs2.getName());
                        curInstruction.rs2 = new PhysicalRegister(rs2, 7);
                        loadRsReg(curInstIter, "t2", regOffset);
                    }
                }
                //在当前指令后面添加把 rd 寄存器的值重新写回 内存 的指令
                if(curInstruction.rd instanceof VirtualRegister rd){
                    if(rd.color != 32){
                        curInstruction.rd = new PhysicalRegister(rd);
                    } else {
                        int regOffset = getVirtualRegOffset(rd.getName());
                        curInstruction.rd = new PhysicalRegister(rd, 5);
                        storeRdValue(curInstIter, "t0", regOffset);
                    }
                }
            }
             */
            while(curInstIter.hasNext()){
                ASM_Instruction curInstruction = curInstIter.next();
                //先把 rs1, rs2 从内存中load出来
                if(curInstruction.rs1 instanceof VirtualRegister rs1){
                    if(rs1.color != 32){
                        curInstruction.rs1 = new PhysicalRegister(rs1);
                    } else {
                        int regOffset = getVirtualRegOffset(rs1.getName());
                        curInstruction.rs1 = new PhysicalRegister(rs1, 6);
                        loadRsReg(curInstIter, "t1", regOffset);
                    }
                }
                if(curInstruction.rs2 instanceof VirtualRegister rs2){
                    if(rs2.color != 32){
                        curInstruction.rs2 = new PhysicalRegister(rs2);
                    } else {
                        int regOffset = getVirtualRegOffset(rs2.getName());
                        curInstruction.rs2 = new PhysicalRegister(rs2, 7);
                        loadRsReg(curInstIter, "t2", regOffset);
                    }
                }
                //在当前指令后面添加把 rd 寄存器的值重新写回 内存 的指令
                if(curInstruction.rd instanceof VirtualRegister rd){
                    if(rd.color != 32){
                        curInstruction.rd = new PhysicalRegister(rd);
                    } else {
                        int regOffset = getVirtualRegOffset(rd.getName());
                        curInstruction.rd = new PhysicalRegister(rd, 5);
                        storeRdValue(curInstIter, "t0", regOffset);
                    }
                }
            }
        }
    }

    public void process(){
        targetModule.ASMFunctionArrayList.forEach(curFunc -> {
            if(curFunc.isBuiltin) return;
            regTable.clear();
            preProcess(curFunc);
            int stackFrameSize = curFunc.stackSize;
            ASMBlock entryBlock, exitBlock;
            entryBlock = curFunc.getEntryBlock();
            exitBlock = curFunc.getExitBlock();
            //set sp and s0
            //sp: 在栈帧底部(小地址), s0: 在栈帧顶部(大地址)
            if(stackFrameSize < 2048){
                //不需要 load imm:
                ASM_Instruction setSp = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("sp"), new PhysicalRegister("sp"), new Imm(-stackFrameSize));
                ASM_Instruction recoverSp = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("sp"), new PhysicalRegister("sp"), new Imm(stackFrameSize));
                ASM_Instruction setS0 = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("s0"), new PhysicalRegister("sp"), new Imm(stackFrameSize));
                entryBlock.instructionList.addFirst(setSp);
                exitBlock.instructionList.addLast(recoverSp);
                ListIterator<ASM_Instruction> instIter = entryBlock.instructionList.listIterator();
                instIter.next();
                instIter.next();
                instIter.add(setS0);
            } else {
                //需要先load imm:
                ASM_Instruction loadImmForSetSp = new LiInstruction(null).addOperand(new PhysicalRegister("t4"), new Imm(-stackFrameSize));
                ASM_Instruction loadImmForRecoverSp = new LiInstruction(null).addOperand(new PhysicalRegister("t4"), new Imm(stackFrameSize));
                ASM_Instruction setSp = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("sp"), new PhysicalRegister("sp"), new PhysicalRegister("t4"));
                ASM_Instruction recoverSp = new ArithInstruction(null, "add").addOperand(new PhysicalRegister("sp"), new PhysicalRegister("sp"), new PhysicalRegister("t4"));
                ASM_Instruction setS0 = new ArithInstruction(null, "sub").addOperand(new PhysicalRegister("s0"), new PhysicalRegister("sp"), new PhysicalRegister("t4"));
                entryBlock.instructionList.addFirst(setSp);
                entryBlock.instructionList.addFirst(loadImmForSetSp);
                exitBlock.instructionList.addLast(loadImmForRecoverSp);
                exitBlock.instructionList.addLast(recoverSp);
                ListIterator<ASM_Instruction> instIter = entryBlock.instructionList.listIterator();
                instIter.next();
                instIter.next();
                instIter.next();
                instIter.add(setS0);
            }
            //add Ret instruction:
            exitBlock.instructionList.addLast(new RetInstruction(null));
            regAlloc(curFunc);
        });
    }
}
