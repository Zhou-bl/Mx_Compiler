package FrontEnd.LLVM_IR.Compound;

import FrontEnd.LLVM_IR.Instruction.GlobalDefInst;
import FrontEnd.LLVM_IR.Operand.StringConstant;
import FrontEnd.LLVM_IR.TypePackage.StructType;

import java.util.ArrayList;

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

    public void addGlobalInit(IRFunction _ele){
        this.globalInitList.add(_ele);
    }

    public void printAllFunc(){
        for(int i = 0; i < functionArrayList.size() - 1; ++i){
            String funcName = functionArrayList.get(i).name;
            System.out.println(funcName);
        }
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
        if(globalInitList.size() > 0)
            res.append("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]").append("\n");
        for(int i = 0; i < globalInitList.size(); ++i){
            res.append(globalInitList.get(i).toString());
        }
        //function def:
        for(int i = 0; i < functionArrayList.size(); ++i){
            IRFunction curi = functionArrayList.get(i);
            res.append(curi.toString());
        }
        return res.toString();
    }
}
