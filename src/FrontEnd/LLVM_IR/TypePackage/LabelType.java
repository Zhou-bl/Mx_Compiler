package FrontEnd.LLVM_IR.TypePackage;

public class LabelType extends IRType{
    @Override
    public int typeSize(){
        throw new RuntimeException("Try to get size of label type.");
    }

    @Override
    public String toString(){
        return "label";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof LabelType);
    }
}
