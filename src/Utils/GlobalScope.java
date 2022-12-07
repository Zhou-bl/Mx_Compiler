package Utils;

import FrontEnd.Semantic.AST_Node.FuncDefNode;

import java.util.HashMap;

public class GlobalScope extends Scope{
    public HashMap<String, FuncDefNode> FunctionTable;
    public HashMap<String, GlobalScope> ClassTable; //in the class we can declare function

    public GlobalScope(Scope _parent){
        super(_parent);
        this.FunctionTable = new HashMap<>();
        this.ClassTable = new HashMap<>();
    }

    public boolean containsFunction(String _funcID){
        return this.FunctionTable.containsKey(_funcID);
    }

    public boolean containsClass(String _classID){
        return this.ClassTable.containsKey(_classID);
    }

    public void defineFunction(String _funcID, FuncDefNode _funcDef){
        this.FunctionTable.put(_funcID, _funcDef);
    }

    public void defineClass(String _classID, GlobalScope _scope){
        this.ClassTable.put(_classID, _scope);
    }

    public FuncDefNode getFunctionDef(String _funcID){
        if(this.FunctionTable.containsKey(_funcID)){
            return this.FunctionTable.get(_funcID);
        }
        return null;
    }
}
