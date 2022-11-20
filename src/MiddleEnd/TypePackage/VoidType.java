package MiddleEnd.TypePackage;

public class VoidType extends IRType {
    @Override
    public int typeSize(){
        throw new RuntimeException("Try to get size of void type.");
    }

    @Override
    public String typeName(){
        return "void";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof VoidType);
    }
}
