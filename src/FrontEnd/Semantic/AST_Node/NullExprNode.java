package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class NullExprNode extends ExprNode {
    public NullExprNode(Position _pos){
        super(_pos);
        this.exprType = new ClassTypeNode("null", _pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
