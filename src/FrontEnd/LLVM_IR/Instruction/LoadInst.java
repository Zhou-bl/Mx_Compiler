package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;

public class LoadInst extends IRInstruction{
    public LoadInst(IRBasicBlock _paraBlock, String _name, Value _address){
        super(_name + ".load", _address.type.deReference());
        this.setBlock(_paraBlock);
        this.addOperand(_address);
    }

    @Override
    public String toString(){
        return this.getName() + " = load " + this.type.toString() + ", "
                + this.operands.get(0).getTypeAndName() + ", align " + this.type.typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
