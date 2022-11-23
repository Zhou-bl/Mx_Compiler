package MiddleEnd.Instruction;

import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;
import MiddleEnd.TypePackage.PointerType;

public class GlobalDefInst extends IRInstruction{
    public GlobalDefInst(IRType _type, String _name){
        super(_name + "_global", new PointerType(_type));
    }

    @Override
    public String getName(){
        return "@" + this.name;
    }

    @Override
    public String generateIRCode(){
        return this.getName() + " = dso_local global " + this.type.deReference().typeName()
                + " zeroinitializer, align" + this.type.deReference().typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
