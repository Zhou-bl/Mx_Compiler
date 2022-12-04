package MiddleEnd.Compound;

import MiddleEnd.BasicClass.User;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.FunctionType;
import MiddleEnd.TypePackage.IRType;

import java.util.ArrayList;

public class IRFunction extends User {
    public ArrayList<IRBasicBlock> basicBlockArrayList;
    public Value resAddress = null;
    public boolean isBuiltin = false;
    public boolean isUsed = false; //for optimize

    public IRFunction(String _functionName, IRType _resType){
        super(_functionName, _resType);
        basicBlockArrayList = new ArrayList<>();
    }

    public void addBasicBlock(IRBasicBlock _block){
        this.basicBlockArrayList.add(_block);
    }

    public IRBasicBlock getEntryBlock(){
        return this.basicBlockArrayList.get(0);
    }

    public IRBasicBlock getReturnBlock(){
        return this.basicBlockArrayList.get(1);
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }

    @Override
    public String toString(){
        //内置函数和非内置函数的形式不一样
        //内置函数仅需要声明，非内置函数需要给出定义
        StringBuilder res = new StringBuilder();
        if(isBuiltin){
            res.append("declare ").append(this.type.toString() + " ").append(this.getName() + "(");
            for(int i = 0; i < ((FunctionType) this.type).parameterTypeList.size(); ++i){
                IRType curi = ((FunctionType) this.type).parameterTypeList.get(i);
                res.append(curi.toString()).append(", ");
            }
            if(((FunctionType) this.type).parameterTypeList.size() > 0) res.delete(res.length() - 2, res.length());
            res.append(")\n");
        } else {
            res.append("define ").append(this.type.toString() + " ").append(this.getName() + "(");
            for(int i = 0; i < operands.size(); ++i){
                res.append(operands.get(i).getTypeAndName()).append(", ");
            }
            if(!operands.isEmpty()) res.delete(res.length() - 2, res.length());
            res.append(") {\n");
            basicBlockArrayList.forEach(ele -> res.append(ele.toString()));
            res.append("}\n");
        }
        return res.toString();
    }
}
