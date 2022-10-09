package AST;

import Utils.Position;

/*
expression DOT IDENTIFIER  #objPortion
 */
public class ObjectPortionExprNode extends ExprNode {
    public ExprNode baseObject;
    public String member;

    //TODO: I don't understand what the following member for.
    public boolean forFunc;
    public FuncDefNode funcInfo;

    public ObjectPortionExprNode(ExprNode _base, String _member, Position _pos){
        super(_pos);
        this.baseObject = _base;
        this.member = _member;

        forFunc = false;
        funcInfo = null;
    }
}
