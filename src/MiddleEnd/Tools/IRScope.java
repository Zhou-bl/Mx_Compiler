package MiddleEnd.Tools;

import MiddleEnd.BasicClass.Value;

import java.util.HashMap;

public class IRScope {
    public enum scopeType{Global, Flow, Func, Common, Class}
    public scopeType type;
    public IRScope parentScope;
    public HashMap<String, Value> valueTable;
    public boolean isValid;

    private void initValid(){
        if(this.parentScope == null){
            this.isValid = true;
        } else {
            this.isValid = this.parentScope.isValid;
        }
    }

    public IRScope(IRScope _para, scopeType _type){
        this.parentScope = _para;
        this.type = _type;
        this.valueTable = new HashMap<>();
        initValid();
    }

    public Value getValue(String _id){
        if(this.valueTable.containsKey(_id)){
            return this.valueTable.get(_id);
        } else {
            if(this.parentScope == null) return null;
            else return this.parentScope.getValue(_id);
        }
    }

    public boolean isClass(String _id){
        if(this.valueTable.containsKey(_id)){
            return this.type == scopeType.Class;
        } else {
            if(this.parentScope == null) return false;
            else return this.parentScope.isClass(_id);
        }
    }

    public void putValue(String _id, Value _op){
        this.valueTable.put(_id, _op);
    }
}