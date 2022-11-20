package MiddleEnd;

import AST.*;
import Utils.GlobalScope;

public class IRBuilder extends ASTVisitor {
    GlobalScope globalScope;
    public IRBuilder(GlobalScope _globalScope){
        globalScope = _globalScope;
    }

    @Override
    public void visit(RootNode node){
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
