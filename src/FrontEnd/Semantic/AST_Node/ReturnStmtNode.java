package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class ReturnStmtNode extends StmtNode{
    public ExprNode resValue;

    public ReturnStmtNode(ExprNode _res, Position _pos){
        super(_pos);
        this.resValue = _res;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
