package FrontEnd.Semantic;

import FrontEnd.Semantic.AST_Node.*;
import Utils.GlobalScope;
import Utils.Position;
import Utils.SemanticError;

public class SymbolCollector implements ASTVisitor {
    private final TypeNode TypeInt;
    GlobalScope globalScope;
    public SymbolCollector(GlobalScope _globalScope){
        this.globalScope = _globalScope;
        TypeInt = new ClassTypeNode("int", new Position(-1, -1));
    }

    @Override
    public void visit(RootNode node){
        node.elements.forEach(ele -> ele.accept(this));
        if(!globalScope.containsFunction("main")){
            throw new SemanticError("There is no function main in the progamme.", node.pos);
        }
        if(!globalScope.getFunctionDef("main").functionType.isEqual(TypeInt)){
            throw new SemanticError("The return value of the \"main\" function should be \"int\".", node.pos);
        }
        if(globalScope.getFunctionDef("main").parameterList != null){
            throw new SemanticError("The parameter list of the \"main\" function should be empty.", node.pos);
        }
    }

    public void visit(ClassDefNode node){
        if(globalScope.containsClass(node.classID)){
            throw new SemanticError("Duplicate declare class: " + "\"" + node.classID + "\".", node.pos);
        }
        if(globalScope.containsFunction(node.classID)){
            throw new SemanticError("\"" + node.classID + "\"" + " is a function identifier.", node.pos);
        }
        GlobalScope ClassScope = new GlobalScope(globalScope);
        //define class members:
        for(VarDefStmtNode memberVar : node.memberVariable){
            for(VarDefNode singleVarDef : memberVar.baseDecl){
                if(ClassScope.containsVariable(singleVarDef.variableID)){
                    throw new SemanticError("Duplicate declare variable in class " + node.classID, singleVarDef.pos);
                }
                ClassScope.defineVariable(singleVarDef.variableID, singleVarDef.variableType);
            }
        }
        //define class functions:
        for(FuncDefNode memFunc : node.memberFunctions){
            if((memFunc.functionID.equals(node.classID) && memFunc.functionType != null)
                    || (!memFunc.functionID.equals(node.classID) && memFunc.functionType == null)){
                throw new SemanticError("Invalid construct function.", memFunc.pos);
            }
            if(ClassScope.containsFunction(memFunc.functionID)){
                throw new SemanticError("Duplicate declare function in class " + node.classID, memFunc.pos);
            }
            ClassScope.defineFunction(memFunc.functionID, memFunc);
        }
        globalScope.defineClass(node.classID, ClassScope);
    }

    @Override
    public void visit(FuncDefNode node){
        if(globalScope.containsFunction(node.functionID)){
            throw new SemanticError("Duplicate declare function: "+ "\"" + node.functionID + "\".", node.pos);
        }
        if(globalScope.containsClass(node.functionID)){
            throw new SemanticError("\"" + node.functionID + "\"" + " is a class identifier.", node.pos);
        }
        if(node.functionType == null){
            throw new SemanticError("No return type.", node.pos);
        }
        globalScope.defineFunction(node.functionID, node);
    }

    @Override public void visit(ArrayAccessNode node){}

    @Override public void visit(ArrayTypeNode node){}

    @Override public void visit(BinaryExprNode node){}

    @Override public void visit(BlockStmtNode node){}

    @Override public void visit(BoolConstantExprNode node){}

    @Override public void visit(BreakStmtNode Node){}

    @Override public void visit(ClassTypeNode node){}

    @Override public void visit(ContinueStmtNode node){}

    @Override public void visit(ExprStmtNode node){}

    @Override public void visit(ForStmtNode node){}

    @Override public void visit(FuncCallExprNode node){}

    @Override public void visit(IdentifierExprNode node){}

    @Override public void visit(IfStmtNode node){}

    @Override public void visit(IntConstantExprNode node){}

    @Override public void visit(MonocularOpExprNode node){}

    @Override public void visit(AllocExprNode node){}

    @Override public void visit(NullExprNode node){}

    @Override public void visit(ObjectPortionExprNode node){}

    @Override public void visit(ReturnStmtNode node){}

    @Override public void visit(StringConstantExprNode node){}

    @Override public void visit(ThisExprNode node){}

    @Override public void visit(VarDefStmtNode node){}

    @Override public void visit(VarDefNode node){}

    @Override public void visit(VoidTypeNode node){}

    @Override public void visit(WhileStmtNode node){}

    @Override public void visit(LambdaExprNode node){}
}