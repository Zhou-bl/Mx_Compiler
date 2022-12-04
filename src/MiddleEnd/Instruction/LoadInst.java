package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;

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
        //todo
    }
}
