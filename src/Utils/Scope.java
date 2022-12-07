package Utils;

import FrontEnd.Semantic.AST_Node.TypeNode;

import java.util.HashMap;

public class Scope {
    public HashMap<String, TypeNode> VariableTable;
    public Scope parent;

    public Scope(Scope _parent){
        this.VariableTable = new HashMap<>();
        this.parent = _parent;
    }

    public boolean containsVariable(String _id){
        return this.VariableTable.containsKey(_id);
    }

    public void defineVariable(String _id, TypeNode _type){
        this.VariableTable.put(_id, _type);
    }

    public TypeNode getVariableType(String _id){
        if(this.VariableTable.containsKey(_id)){
            return this.VariableTable.get(_id);
        }else if(this.parent != null){
            return this.parent.getVariableType(_id);
        }
        return null;
    }
}
