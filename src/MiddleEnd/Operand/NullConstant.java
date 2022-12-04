package MiddleEnd.Operand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;
import MiddleEnd.TypePackage.PointerType;
import MiddleEnd.TypePackage.VoidType;

public class NullConstant extends IRConstant{
    public NullConstant(){
        super("null", new PointerType(new VoidType()));
    }

    public NullConstant(PointerType p){
        super("null", p);
    }

    public void setType(IRType _type){
        //null constant也必须指明是哪个类型的null指针
        this.type = _type;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        throw new RuntimeException("ToString in NullConstant.");
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
