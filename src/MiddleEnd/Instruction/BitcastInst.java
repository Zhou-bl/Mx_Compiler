package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;

public class BitcastInst extends IRInstruction{
    public BitcastInst(IRBasicBlock _paraBlock, Value _base, IRType _targetType){
        super(_base.name + "_BC", _targetType);
        this.setBlock(_paraBlock);
        this.addOperand(_base);
    }

    @Override
    public String generateIRCode(){
        return this.getName() + " = bitcast " + this.operands.get(0).getTypeAndName() + " to " +this.type.typeName();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo;
    }
}
