package FrontEnd.Semantic.AST_Node;

/*
NEW allocFormat;

allocFormat
    : baseType ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+   #allocErrorType
    | baseType ('[' expression ']')+ ('[' ']')*                         #allocArrayType
    | baseType ('(' ')')?                                               #allocBaseType
    ;
 */

import Utils.Position;

import java.util.ArrayList;

public class AllocExprNode extends ExprNode {
    public TypeNode allocType;
    public int dimSize;
    public ArrayList<ExprNode> sizeList;

    public AllocExprNode(TypeNode _type, int _dim, ArrayList<ExprNode> _list, Position _pos){
        super(_pos);
        this.allocType = _type;
        this.dimSize = _dim;
        this.sizeList = _list;
    }

    public boolean isArray(){
        return this.dimSize > 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
