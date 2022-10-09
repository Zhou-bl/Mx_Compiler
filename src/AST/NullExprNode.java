package AST;

import Utils.Position;

public class NullExprNode extends ExprNode {
    public NullExprNode(Position _pos){
        super(_pos);
        this.exprType = new ClassTypeNode("null", _pos);
    }
}
