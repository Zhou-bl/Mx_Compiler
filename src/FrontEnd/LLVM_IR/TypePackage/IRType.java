package FrontEnd.LLVM_IR.TypePackage;

public abstract class IRType {
    //类型基类
    public abstract int typeSize(); //返回此type占用的字节数
    public abstract String toString(); //返回此type的id
    public abstract boolean isEqual(IRType other); //比较是否为同一类型
    public IRType deReference(){//指针解引用
        if(this instanceof PointerType){
            if(((PointerType) this).dim == 1) return ((PointerType) this).baseType;
            else return new PointerType(((PointerType) this).baseType, ((PointerType) this).dim - 1);
        } else {
            throw new RuntimeException("Can't dereference non-pointer type.");
        }
    }
}