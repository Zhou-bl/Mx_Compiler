package FrontEnd;

import AST.ClassTypeNode;
import AST.FuncDefNode;
import AST.VarDefNode;
import AST.VoidTypeNode;
import Utils.GlobalScope;
import Utils.Position;

import java.util.ArrayList;

public class SetBuiltIn {
    public GlobalScope init(GlobalScope nameSpace){
        //builtIn function:
        //void print(string str):
        ArrayList<VarDefNode> funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("string", new Position(-1, -1)), "str", null, new Position(-1, -1)));
        FuncDefNode tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "print", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("print", tmpFuncNode);

        //void println(string str):
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "println", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("println", tmpFuncNode);

        //void printInt(int n):
        funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "n", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "printInt", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("printInt", tmpFuncNode);

        //void printlnInt(int n):
        tmpFuncNode = new FuncDefNode(new VoidTypeNode(new Position(-1, -1)), "printlnInt", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("printlnInt", tmpFuncNode);

        //string getString():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "getString", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("getString", tmpFuncNode);

        //int getInt():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "getInt", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("getInt", tmpFuncNode);

        //string toString(int n);
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "toString", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineFunction("toString", tmpFuncNode);


        //builtIn class:
        //bool:
        nameSpace.defineClass("bool", new GlobalScope(nameSpace));

        //int:
        nameSpace.defineClass("int", new GlobalScope(nameSpace));

        //string:
        GlobalScope stringFuncScope = new GlobalScope(nameSpace);
        funcParameterList = new ArrayList<>();

        //int length():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "length", null, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("length", tmpFuncNode);

        //string substring(int left, int right):
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "left", null, new Position(-1 ,-1)));
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1 ,-1)), "right", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("string", new Position(-1, -1)), "substring", funcParameterList, null, new Position(-1, -1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("substring", tmpFuncNode);

        //int parseInt():
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1 ,-1)), "parseInt", null, null, new Position(-1,-1));
        tmpFuncNode.isBuildIn = true;
        stringFuncScope.defineFunction("parseInt", tmpFuncNode);

        //int ord(int pos):
        funcParameterList = new ArrayList<>();
        funcParameterList.add(new VarDefNode(new ClassTypeNode("int", new Position(-1, -1)), "pos", null, new Position(-1, -1)));
        tmpFuncNode = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)), "ord", funcParameterList, null, new Position(-1, -1));
        stringFuncScope.defineFunction("ord", tmpFuncNode);
        tmpFuncNode.isBuildIn = true;
        nameSpace.defineClass("string", stringFuncScope);
        return nameSpace;
    }
}
