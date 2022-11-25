package MiddleEnd;

import AST.*;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.Compound.IRFunction;
import MiddleEnd.Compound.IRModule;
import MiddleEnd.Operand.StringConstant;
import MiddleEnd.Tools.IRScope;
import MiddleEnd.TypePackage.*;
import Utils.GlobalScope;
import Utils.Scope;

import java.util.*;

public class IRBuilder implements ASTVisitor {
    //name space:
    public GlobalScope globalScope;
    public IRScope curScope;
    //current position:
    public IRModule targetModule;
    public IRFunction curFunction;
    public IRBasicBlock curBlock;
    public StructType curClass;

    //some hash maps:
    public HashMap<String, IRType> typeTable;
    public HashMap<String, IRFunction> funcTable;
    public HashMap<String, StringConstant> stringTable;

    //global def linked_list:
    public LinkedList<VarDefNode> globalDefNodeList;

    //stack for loops:
    private Stack<IRBasicBlock> loopContinue;
    private Stack<IRBasicBlock> loopBreak;

    private IRType getType(TypeNode node){//通过node返回IRType,如果是arrayType那么type应该是pointerType
        if(node == null) return typeTable.get("void");
        IRType res = typeTable.get(node.typeID);
        if(node instanceof ArrayTypeNode){
            res = new PointerType(res, ((ArrayTypeNode) node).dimSize);
        }
        return res;
    }

    public IRBuilder(GlobalScope _globalScope, IRModule _module){
        this.globalScope = _globalScope;
        this.curScope = new IRScope(null, IRScope.scopeType.Global);
        this.targetModule = _module;
        this.curBlock = null;
        this.curClass = null;
        this.curFunction = null;
        this.typeTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.stringTable = new HashMap<>();
        this.globalDefNodeList = new LinkedList<>();
        this.loopBreak = new Stack<>();
        this.loopContinue = new Stack<>();
    }

    @Override
    public void visit(RootNode node){//add class function in
        typeTable.put("void", new VoidType());
        for(Map.Entry<String, GlobalScope> iter : globalScope.ClassTable.entrySet()){//add class.
            String className = iter.getKey();
            if(className.equals("int")) typeTable.put("int", new IntegerType(32));
            else if(className.equals("bool")) typeTable.put("bool", new BoolType());
            else if(className.equals("string")) typeTable.put("string", new PointerType(new IntegerType(8)));
            else {
                StructType newClass = new StructType(className);
                typeTable.put(className, new PointerType(newClass));
                targetModule.addClass(newClass);
            }
        }
        for(Map.Entry<String, FuncDefNode> iter : globalScope.FunctionTable.entrySet()){//add non-member functions.
            String funcName = iter.getKey();
            FuncDefNode funcNode = iter.getValue();
            FunctionType funcType = new FunctionType(getType(funcNode.functionType));
            if(funcNode.parameterList != null){
                for(int i = 0; i < funcNode.parameterList.size(); ++i){
                    IRType paraType = getType(funcNode.parameterList.get(i).variableType);
                    String paraID = funcNode.parameterList.get(i).variableID;
                    funcType.addParameter(paraType, paraID);
                }
            }
            IRFunction newFunction = new IRFunction("_f_" + funcName, funcType);
            newFunction.isBuiltin = funcNode.isBuildIn;
            targetModule.addFunction(newFunction);
            funcTable.put(funcName, newFunction);
        }
        for(Map.Entry<String, GlobalScope> iter : globalScope.ClassTable.entrySet()){//add member variables , functions and construction functions.
            String className = iter.getKey();
            if(className.equals("int") || className.equals("bool")) continue;
            IRType curType = typeTable.get(className).deReference();
            if(!className.equals("string")){

            }
        }
        node.elements.forEach(_ele -> _ele.accept(this));
    }

    @Override
    public void visit(ClassDefNode node){

    }

    @Override
    public void visit(FuncDefNode node){

    }

    @Override
    public void visit(VarDefStmtNode node){

    }
}
