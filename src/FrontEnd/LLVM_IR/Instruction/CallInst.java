package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.Compound.IRFunction;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.FunctionType;
import FrontEnd.LLVM_IR.TypePackage.VoidType;

public class CallInst extends IRInstruction{
    public CallInst(IRBasicBlock _paraBlock, IRFunction _func){
        super("_call" + _func.name, ((FunctionType)_func.type).resType);
        this.setBlock(_paraBlock);
        this.addOperand(_func);
    }

    public CallInst addArg(Value _arg){
        this.addOperand(_arg);
        return this;
    }

    @Override
    public String toString(){
        StringBuilder resStr = new StringBuilder();
        if(!(this.type instanceof VoidType)){
            resStr.append(this.getName()).append(" = ");
        }
        resStr.append("call ").append(this.getOperand(0).getTypeAndName()).append('(');
        int size = operands.size();
        if(size > 1){//non-empty parameterList
            for(int i = 1; i < size - 1; ++i){
                resStr.append(this.getOperand(i).getTypeAndName()).append(", ");
            }
            resStr.append(this.getOperand(size - 1).getTypeAndName());
        }
        resStr.append(')');
        return resStr.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
