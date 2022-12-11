package Utils;

import FrontEnd.LLVM_IR.BasicClass.Value;

import java.util.HashMap;

public class IRScope {
    public enum scopeType{Global, Flow, Func, Block, Class}
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

    public boolean isClassId(String _id){
        Value tmp = valueTable.get(_id);
        if(tmp != null){
            return this.type == scopeType.Class;
        } else {
            return this.parentScope.isClassId(_id);
        }
    }

    public void putValue(String _id, Value _op){
        this.valueTable.put(_id, _op);
    }

    public void setInvalid(){
        switch (this.type){
            case Flow, Global, Class -> {}
            default -> this.isValid = false;
        }
    }

    public IRScope upRoot(){
        if(!this.isValid) this.parentScope.setInvalid();
        return this.parentScope;
    }
}
