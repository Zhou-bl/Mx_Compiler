package MiddleEnd.TypePackage;

public abstract class IRType {
    //类型基类
    public abstract int typeSize(); //返回此type占用的字节数
    public abstract String typeName(); //返回此type的id
    public abstract boolean isEqual(IRType other); //比较是否为同一类型
}