package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;

public class GepInst extends IRInstruction{
    public GepInst(IRBasicBlock _paraBlock, IRType _targetType, Value _targetPointer){
        super("gep", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_targetPointer);
    }

    public GepInst addIndex(Value _value){
        this.addOperand(_value);
        return this;
    }

    @Override
    public String toString(){
        StringBuilder resStr = new StringBuilder();
        resStr.append(this.getName()).append(" = getelementptr inbounds ").
                append(getOperand(0).type.deReference().toString()).append(", ").append(getOperand(0).getTypeAndName());
        if(this.operands.size() <= 1){
            throw new RuntimeException("In GepInst too less operand.");
        }
        for(int i = 1; i < operands.size(); ++i){
            resStr.append(", ").append(getOperand(i).getTypeAndName());
        }
        return resStr.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
