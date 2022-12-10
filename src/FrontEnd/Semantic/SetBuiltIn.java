package FrontEnd.Semantic;

import FrontEnd.Semantic.AST_Node.ClassTypeNode;
import FrontEnd.Semantic.AST_Node.FuncDefNode;
import FrontEnd.Semantic.AST_Node.VarDefNode;
import FrontEnd.Semantic.AST_Node.VoidTypeNode;
import Utils.GlobalScope;
import Utils.Position;

import java.util.ArrayList;

public class SetBuiltIn {
    public GlobalScope init(GlobalScope nameSpace){
        //builtIn function:
        //void print(string str):
        ArrayList<VarDefNode> funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("string", new Position(-1, -1)), "str", null, new Position(-1, -1)));
        FuncDefNode tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "print0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("print", tmpFuncNode);

        //void println(string str):
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "println0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("println", tmpFuncNode);

        //void printInt(int n):
        funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "n", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "printInt0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("printInt", tmpFuncNode);

        //void printlnInt(int n):
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "printlnInt0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("printlnInt", tmpFuncNode);

        //string getString():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "getString0", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("getString", tmpFuncNode);

        //int getInt():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "getInt0", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("getInt", tmpFuncNode);

        //string toString(int n);
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "toString0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("toString", tmpFuncNode);

        //void _malloc
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "_malloc0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("_malloc", tmpFuncNode);

        //builtIn class:
        //bool:
        nameSpace.defineClass("bool", new GlobalScope(nameSpace));

        //int:
        nameSpace.defineClass("int", new GlobalScope(nameSpace));

        //string:
        GlobalScope stringFuncScope = new GlobalScope(nameSpace);
        funcParameterList = new ArrayList<>();

        //int length():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "length0", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("length", tmpFuncNode);

        //string substring(int left, int right):
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "left", null, new Position(-1 ,-1)));
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1 ,-1)), "right", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "substring0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("substring", tmpFuncNode);

        //define string_operators:
        funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("string", new Position(-1, -1)), "str1", null, new Position(-1, -1)));
        funcParameterList.add(new VarDefNode(new ClassTypeNode("string", new Position(-1, -1)), "str2", null, new Position(-1, -1)));

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "_str_splice0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_splice", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_eq0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_eq", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_ne0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_ne", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_lt0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_lt", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_le0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_le", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_gt0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_gt", tmpFuncNode);

        tmpFuncNode = new FuncDefNode(new ClassTypeNode("bool", new Position(-1, -1)), "_str_ge0", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true; nameSpace.defineFunction("_str_ge", tmpFuncNode);

        //int parseInt():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1 ,-1)), "parseInt0", null, null, new Position(-1,-1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("parseInt", tmpFuncNode);

        //int ord(int pos):
        funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "pos", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "ord0", funcParameterList, null, new Position(-1, -1));
        stringFuncScope.defineFunction("ord", tmpFuncNode);
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineClass("string", stringFuncScope);
        return nameSpace;
    }
}
