package FrontEnd.LLVM_IR.TypePackage;

public class ArrayType extends IRType{
    public IRType baseType;
    public int size;

    public ArrayType(IRType _baseType, int _size){
        this.baseType = _baseType;
        this.size = _size;
    }

    @Override
    public int typeSize(){
        return this.size * this.baseType.typeSize();
    }

    @Override
    public String toString(){
        return "[" + Integer.toString(this.size) + " x " + this.baseType.toString() + "]";
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof ArrayType) &&
                (((ArrayType) other).baseType.isEqual(this.baseType)) &&
                (((ArrayType) other).size == this.size);
    }
}
