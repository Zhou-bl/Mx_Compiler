package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class ArrayTypeNode extends TypeNode {
    public int dimSize;

    public ArrayTypeNode(TypeNode _base, Position _pos){
        super(_base.typeID, _pos);
        if(_base instanceof ArrayTypeNode){
            this.dimSize = ((ArrayTypeNode) _base).dimSize + 1;
        }
        else {
            this.dimSize = 1;
        }
    }

    public ArrayTypeNode(String _baseTypeID, int _dim, Position _pos){
        super(_baseTypeID, _pos);
        this.dimSize = _dim;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}