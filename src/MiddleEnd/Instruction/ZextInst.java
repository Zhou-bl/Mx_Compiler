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
    public String toString(){
        return this.getName() + " = zext " + this.getOperand(0).getTypeAndName() + " to " + this.type.toString();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
