package FrontEnd.LLVM_IR.TypePackage;

public class BoolType extends IRType{
    //计算机最小的存取单元是一字节,所以bool是8bit
    @Override
    public int typeSize(){
        return 1;
    }

    @Override
    public String toString(){
        return "i8";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof BoolType);
    }
}
