package MiddleEnd.TypePackage;

public class LabelType extends IRType{
    @Override
    public int typeSize(){
        throw new RuntimeException("Try to get size of label type.");
    }

    @Override
    public String typeName(){
        return "label";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof LabelType);
    }
}