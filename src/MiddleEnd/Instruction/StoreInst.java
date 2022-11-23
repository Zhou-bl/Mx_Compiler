package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.VoidType;

public class StoreInst extends IRInstruction {
    public StoreInst(IRBasicBlock _paraBlock, Value _value, Value _address){
        super("_store", new VoidType());
        this.setBlock(_paraBlock);
        this.addOperand(_value);
        this.addOperand(_address);
    }

    @Override
    public String generateIRCode(){
        return "store " + this.operands.get(0).getTypeAndName() + ", "
                + this.operands.get(1).getTypeAndName() + ", align "
                + this.operands.get(0).type.typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
