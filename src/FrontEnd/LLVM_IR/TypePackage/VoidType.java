package FrontEnd.LLVM_IR.TypePackage;

public class VoidType extends IRType {
    @Override
    public int typeSize(){
        throw new RuntimeException("Try to get size of void type.");
    }

    @Override
    public String toString(){
        return "void";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof VoidType);
    }
}
