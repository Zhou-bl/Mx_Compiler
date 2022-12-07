package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public abstract class TypeNode extends ASTNode {
    public String typeID;

    public TypeNode(String _id, Position _pos){
        super(_pos);
        this.typeID = _id;
    }

    public boolean isEqual(TypeNode other){
        if(this instanceof ArrayTypeNode && other instanceof ArrayTypeNode){
            return this.typeID.equals(other.typeID) &&
                    ((ArrayTypeNode) this).dimSize == ((ArrayTypeNode) other).dimSize;
        }
        if(this instanceof ClassTypeNode && other instanceof ClassTypeNode){
            return this.typeID.equals(other.typeID);
        }
        if(this instanceof VoidTypeNode && other instanceof VoidTypeNode){
            return true;
        }
        return false;
    }
}
