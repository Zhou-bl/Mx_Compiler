package AST;

import Utils.Position;

public abstract class ExprNode extends ASTNode{
    public TypeNode exprNode;
    public boolean isAssignment;

    public ExprNode(Position _pos){
        super(_pos);
        this.exprNode = null;
        this.isAssignment = false;
    }
}
