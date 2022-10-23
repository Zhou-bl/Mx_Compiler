package AST;

import Utils.Position;

/*
expression DOT IDENTIFIER  #objPortion
 */
public class ObjectPortionExprNode extends ExprNode {
    public ExprNode baseObject;
    public String member;

    public boolean forFunc;//判断调用的是否为成员函数还是成员变量;
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
