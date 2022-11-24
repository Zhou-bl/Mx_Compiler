package MiddleEnd;

import AST.*;
import MiddleEnd.Compound.IRModule;
import Utils.GlobalScope;

public class IRBuilder implements ASTVisitor {
    public GlobalScope globalScope;
    public IRModule targetModule;
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
