package FrontEnd;

import AST.*;
import Utils.GlobalScope;
import Utils.Position;
import Utils.Scope;
import Utils.SemanticError;

import java.util.ArrayList;
import java.util.Stack;

public class SemChecker implements ASTVisitor {
    public GlobalScope globalScope;
    public Scope curScope;
    public String curClass;
    public Stack<ASTNode> FuncStation;
    private final TypeNode TypeNull,TypeVoid,TypeInt,TypeBool,TypeString;

    public SemChecker(GlobalScope _globalScope){
        this.globalScope = _globalScope;
        this.curScope = _globalScope;
        this.TypeNull = new ClassTypeNode("null", new Position(-1, -1));
        this.TypeVoid = new VoidTypeNode(new Position(-1, -1));
        this.TypeInt = new ClassTypeNode("int", new Position(-1, -1));
        this.TypeBool = new ClassTypeNode("bool", new Position(-1, -1));
        this.TypeString = new ClassTypeNode("string", new Position(-1, -1));
        this.FuncStation = new Stack<>();
        curClass = null;
    }

    @Override
    public void visit(RootNode node){
        node.elements.forEach(ele -> ele.accept(this));
    }

    @Override
    public void visit(ClassDefNode node){
        curClass = node.classID;
        curScope = globalScope.ClassTable.get(curClass);
        for(VarDefStmtNode varStmt : node.memberVariable){
            for(VarDefNode singleVarDecl : varStmt.baseDecl){
                if(!globalScope.containsClass(singleVarDecl.variableType.typeID)){
                    throw new SemanticError("Undefined type.", singleVarDecl.pos);
                }
                if(singleVarDecl.initValue != null){
                    singleVarDecl.initValue.accept(this);
                    if(!singleVarDecl.initValue.exprType.isEqual(TypeNull) && !singleVarDecl.initValue.exprType.isEqual(varStmt.varType)){
                        throw new SemanticError("Unmatched type in variable declare.", singleVarDecl.pos);
                    }
                }
            }
        }
        node.memberFunctions.forEach(tmp -> tmp.accept(this));
        curClass = null;
        curScope = curScope.parent;
    }

    @Override
    public void visit(VarDefStmtNode node){
        node.baseDecl.forEach(tmp->tmp.accept(this));
    }

    @Override
    public void visit(VarDefNode node){
        if(curScope.containsVariable(node.variableID)){
            throw new SemanticError("Duplicate declare variable.", node.pos);
        }
        if(globalScope.containsClass(node.variableID)){
            throw new SemanticError("\"" + node.variableID + "\" is a identifier of class.", node.pos);
        }
        if(globalScope.containsClass(node.variableType.typeID)){
            throw new SemanticError("Undefined variable type " + "\"" + node.variableType.typeID + "\"", node.pos);
        }
        if(node.initValue != null){
            node.initValue.accept(this);
            if(!node.initValue.exprType.isEqual(TypeNull) && !node.initValue.exprType.isEqual(node.variableType)){
                throw new SemanticError("Unmatched type in variable declare.", node.pos);
            }
        }
        curScope.defineVariable(node.variableID, node.variableType);
    }

    @Override
    public void visit(FuncDefNode node){

    }

}
