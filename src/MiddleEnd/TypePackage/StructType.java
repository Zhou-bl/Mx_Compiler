package MiddleEnd.TypePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class StructType extends IRType{
    int typeSize;
    public String name;
    public ArrayList<IRType> typeList;
    public HashMap<String, IRType> typeTable;

    public StructType(String _name){
        this.typeSize = 0;
        this.name = "class." + _name;
        this.typeList = new ArrayList<>();
        this.typeTable = new HashMap<>();
    }

    public void addMember(String _key, IRType _value){
        typeTable.put(_key, _value);
        typeList.add(_value);
        this.typeSize += _value.typeSize();
    }

    @Override
    public int typeSize(){
        return typeSize;
    }

    @Override
    public String typeName(){
        return "%" + this.name;
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof StructType) &&
                (other.typeName().equals(this.typeName()));
    }
}
