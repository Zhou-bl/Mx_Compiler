package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;

public class BitcastInst extends IRInstruction{
    public BitcastInst(IRBasicBlock _paraBlock, Value _base, IRType _targetType){
        super(_base.name + "_BC", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_base);
    }

    @Override
    public String toString(){
        return this.getName() + " = bitcast " + this.operands.get(0).getTypeAndName() + " to " +this.type.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
