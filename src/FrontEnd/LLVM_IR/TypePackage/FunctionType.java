package FrontEnd.LLVM_IR.TypePackage;

import java.util.ArrayList;

public class FunctionType extends IRType{
    public IRType resType;
    public ArrayList<IRType> parameterTypeList;
    public ArrayList<String> parameterNameList;

    public FunctionType(IRType _resType){
        if(_resType instanceof LabelType){
            throw new RuntimeException("\"resType\"" + " of function type can't be label type.");
        }
        this.resType = _resType;
        this.parameterTypeList = new ArrayList<>();
        this.parameterNameList = new ArrayList<>();
    }

    public void addParameter(IRType _para, String _name){
        this.parameterTypeList.add(_para);
        this.parameterNameList.add(_name);
    }

    @Override
    public String toString(){
        return resType.toString();
    }

    @Override
    public int typeSize(){
        throw new RuntimeException("Try to get size of function type.");
    }


    @Override
    public boolean isEqual(IRType other){
        throw new RuntimeException("isEqual() does not apply to function type.");
    }
}
