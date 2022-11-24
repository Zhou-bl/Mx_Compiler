package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;

public class TruncInst extends IRInstruction{
    public TruncInst(IRBasicBlock _paraBlock, Value _oriValue, IRType _targetType){
        super("trunc_", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_oriValue);
    }

    @Override
    public String generateIRCode(){
        return this.getName() + " = trunc " + this.getOperand(0).getTypeAndName() + " to " + this.type.typeName();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
