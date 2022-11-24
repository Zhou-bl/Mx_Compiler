package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;

public class ZextInst extends IRInstruction{
    public ZextInst(IRBasicBlock _paraBlock, Value _oriValue, IRType _targetType){
        super("zext_", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_oriValue);
    }

    @Override
    public String generateIRCode(){
        return this.getName() + " = zext " + this.getOperand(0).getTypeAndName() + " to " + this.type.typeName();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
