package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;

public class ZextInst extends IRInstruction{
    public ZextInst(IRBasicBlock _paraBlock, Value _oriValue, IRType _targetType){
        super("zext_", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_oriValue);
    }

    @Override
    public String toString(){
        return this.getName() + " = zext " + this.getOperand(0).getTypeAndName() + " to " + this.type.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
