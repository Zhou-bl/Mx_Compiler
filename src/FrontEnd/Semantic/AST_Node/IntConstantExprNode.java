package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class IntConstantExprNode extends ExprNode{
    public int value;

    public IntConstantExprNode(int _value, Position _pos){
        super(_pos);
        this.value = _value;
        this.exprType = new ClassTypeNode("int", _pos);
    }

    public int getValue(){
        return this.value;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
