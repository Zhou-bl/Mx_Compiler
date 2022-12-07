package FrontEnd.Semantic.AST_Node;

import Utils.Position;

import java.util.ArrayList;

/*
variableDecl : variableType baseVariableDecl (',' baseVariableDecl)* ;
 */
public class VarDefStmtNode extends StmtNode{
    public TypeNode varType;
    public ArrayList<VarDefNode> baseDecl;

    public VarDefStmtNode(TypeNode _type, ArrayList<VarDefNode> _base, Position _pos){
        super(_pos);
        this.varType = _type;
        this.baseDecl = _base;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
