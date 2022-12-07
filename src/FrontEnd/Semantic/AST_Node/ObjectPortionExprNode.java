package FrontEnd.Semantic.AST_Node;

import Utils.Position;

/*
expression DOT IDENTIFIER  #objPortion
 */
public class ObjectPortionExprNode extends ExprNode {
    public ExprNode baseObject;
    public String member;

    public boolean forFunc;//判断是否是调用函数;
    public FuncDefNode funcInfo;

    public ObjectPortionExprNode(ExprNode _base, String _member, Position _pos){
        super(_pos);
        this.baseObject = _base;
        this.member = _member;

        forFunc = false;
        funcInfo = null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
