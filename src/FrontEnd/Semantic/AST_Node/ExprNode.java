package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public abstract class ExprNode extends ASTNode{
    public TypeNode exprType;
    public boolean isAssignment;

    public ExprNode(Position _pos){
        super(_pos);
        this.exprType = null;
        this.isAssignment = false;
    }
}
