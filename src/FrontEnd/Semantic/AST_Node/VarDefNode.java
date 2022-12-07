package FrontEnd.Semantic.AST_Node;

import Utils.Position;

/*
baseVariableDecl : IDENTIFIER ('=' expression)? ;
 */
//for a single variable declare.
public class VarDefNode extends ASTNode{
    public TypeNode variableType;
    public String variableID;
    public ExprNode initValue;

    public VarDefNode(TypeNode _type, String _id, ExprNode _init, Position _pos){
        super(_pos);
        this.variableType = _type;
        this.variableID = _id;
        this.initValue = _init;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
