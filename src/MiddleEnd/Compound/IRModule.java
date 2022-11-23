package MiddleEnd.Compound;

import MiddleEnd.Operand.StringConstant;
import MiddleEnd.TypePackage.StructType;

import java.util.ArrayList;

public class IRModule {
    public ArrayList<IRFunction> functionArrayList;
    public ArrayList<StringConstant> stringConstantArrayList;
    //public ArrayList<GlobalDef> globalDefArrayList;
    public ArrayList<StructType> classArrayList;
    public ArrayList<IRFunction> globalInitList;//todo:for what?

    public IRModule(){
        functionArrayList = new ArrayList<>();
        stringConstantArrayList = new ArrayList<>();
        //globalDefArrayList = new ArrayList<>();
        classArrayList = new ArrayList<>();
        globalInitList = new ArrayList<>();
    }
}
