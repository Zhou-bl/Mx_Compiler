package FrontEnd.LLVM_IR.TypePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class StructType extends IRType{
    int typeSize;
    public Integer cnt;
    public String name;
    public ArrayList<IRType> typeList;
    public HashMap<String, Integer> indexTable;
    public HashMap<String, IRType> typeTable;

    public StructType(String _name){//先确定ID再添加成员
        this.typeSize = 0;
        this.cnt = 0;
        this.name = "class_" + _name;
        this.typeList = new ArrayList<>();
        this.typeTable = new HashMap<>();
        this.indexTable = new HashMap<>();
    }

    public void addMember(String _key, IRType _value){
        typeTable.put(_key, _value);
        typeList.add(_value);
        indexTable.put(_key, cnt++);
        this.typeSize += _value.typeSize();
    }

    public int getOffset(int index){
        int ans = 0;
        for(int i = 0;i < index;++i){
            ans += typeList.get(i).typeSize();
        }
        return ans;
    }

    @Override
    public int typeSize(){
        return typeSize;
    }

    @Override
    public String toString(){
        return "%" + this.name;
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof StructType) &&
                (other.toString().equals(this.toString()));
    }
}
