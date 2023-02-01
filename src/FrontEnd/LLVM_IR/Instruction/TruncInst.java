package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;

public class TruncInst extends IRInstruction{
    public TruncInst(IRBasicBlock _paraBlock, Value _oriValue, IRType _targetType){
        super("trunc_", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_oriValue);
    }

    @Override
    public String toString(){
        return this.getName() + " = trunc " + this.getOperand(0).getTypeAndName() + " to " + this.type.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
