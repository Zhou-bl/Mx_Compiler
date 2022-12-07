package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class ClassTypeNode extends TypeNode{
    //This class is use specially to instantiate.
    public ClassTypeNode(String _classID, Position _pos){
        super(_classID, _pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
