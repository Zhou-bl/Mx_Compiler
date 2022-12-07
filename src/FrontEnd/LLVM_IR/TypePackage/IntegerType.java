package FrontEnd.LLVM_IR.TypePackage;

public class IntegerType extends IRType{
    public int bitWidth;

    public IntegerType(int _bitWidth){
        this.bitWidth = _bitWidth;
    }

    @Override
    public int typeSize(){//字节数
        return this.bitWidth / 8;
    }

    @Override
    public String toString(){
        return "i" + this.bitWidth;
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof IntegerType) && (((IntegerType) other).bitWidth == this.bitWidth);
    }
}
