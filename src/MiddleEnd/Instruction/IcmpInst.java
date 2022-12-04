package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IntegerType;

public class IcmpInst extends IRInstruction{
    public BinaryInst.IRBinaryOpType opType;
    public IcmpInst(IRBasicBlock _paraBlock, BinaryInst.IRBinaryOpType _opType, Value _lop, Value _rop){
        super(_opType.name(), new IntegerType(1));
        if(!_lop.type.isEqual(_rop.type)){
            throw new RuntimeException("Unequal type in IcmpInst.");
        }
        this.setBlock(_paraBlock);
        this.addOperand(_lop);
        this.addOperand(_rop);
    }

    @Override
    public String toString(){
        return this.getName() + " = " + this.opType.name() +
                this.operands.get(0).getTypeAndName() + ", " + this.operands.get(1).getName();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
