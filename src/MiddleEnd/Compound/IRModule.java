package MiddleEnd.Compound;

import MiddleEnd.Instruction.GlobalDefInst;
import MiddleEnd.Operand.StringConstant;
import MiddleEnd.TypePackage.IRType;
import MiddleEnd.TypePackage.StructType;

import java.util.ArrayList;
import java.util.Map;

public class IRModule {
    public ArrayList<IRFunction> functionArrayList;
    public ArrayList<StringConstant> stringConstantArrayList;
    public ArrayList<GlobalDefInst> globalDefArrayList;
    public ArrayList<StructType> classArrayList;
    public ArrayList<IRFunction> globalInitList;

    public IRModule(){
        functionArrayList = new ArrayList<>();
        stringConstantArrayList = new ArrayList<>();
        globalDefArrayList = new ArrayList<>();
        classArrayList = new ArrayList<>();
        globalInitList = new ArrayList<>();
    }

    public void addClass(StructType _newClass){
        this.classArrayList.add(_newClass);
    }

    public void addFunction(IRFunction _newFunction){
        this.functionArrayList.add(_newFunction);
    }

    public void addGlobalDef(GlobalDefInst _newGlobalDef){
        this.globalDefArrayList.add(_newGlobalDef);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        //class define:
        for(int i = 0; i < classArrayList.size(); ++i){
            StructType curi = classArrayList.get(i);
            res.append(curi.toString()).append(" = type { ");
            curi.typeTable.forEach((id, ty)->res.append(ty.toString()).append(", "));
            if(!curi.typeTable.isEmpty()){
                res.delete(res.length() - 2, res.length());
            }
            res.append(" }\n");
        }
        //string const:
        for(int i = 0; i < stringConstantArrayList.size(); ++i){
            StringConstant curi = stringConstantArrayList.get(i);
            res.append(curi.toString()).append("\n");
        }
        //global def:
        for(int i = 0; i < globalDefArrayList.size(); ++i){
            GlobalDefInst curi = globalDefArrayList.get(i);
            res.append(curi.toString()).append("\n");
        }
        //global init
        for(int i = 0; i < globalInitList.size(); ++i){
            //todo
        }
        //function def:
        for(int i = 0; i < functionArrayList.size(); ++i){
            IRFunction curi = functionArrayList.get(i);
            res.append(curi.toString()).append("\n");
        }
        return res.toString();
    }
}
