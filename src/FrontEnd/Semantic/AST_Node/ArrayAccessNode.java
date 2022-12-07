package FrontEnd.Semantic.AST_Node;

import Utils.Position;

/*
array=expression '[' index=expression ']'
 */
public class ArrayAccessNode extends ExprNode {
    public ExprNode array;
    public ExprNode index;

    public ArrayAccessNode(ExprNode _array, ExprNode _index, Position _pos){
        super(_pos);
        this.array = _array;
        this.index = _index;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
