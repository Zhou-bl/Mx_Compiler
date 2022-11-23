package MiddleEnd.Instruction;

import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;
import MiddleEnd.TypePackage.PointerType;

public class AllocInst extends IRInstruction{
    public AllocInst(IRBasicBlock _paraBlock, IRType _type, String _name){
        super(_name + ".alloc", new PointerType(_type));
        this.setBlock(_paraBlock);
    }

    @Override
    public String generateIRCode(){
        return this.getName() + " = alloc " + this.type.deReference().typeName() + ", align " + this.type.typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
