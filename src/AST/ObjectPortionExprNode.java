package AST;

import Utils.Position;

/*
expression DOT IDENTIFIER  #objPortion
 */
public class ObjectPortionExprNode extends ExprNode {
    public ExprNode baseObject;
    public String member;

    public boolean forFunc;//�жϵ��õ��Ƿ�Ϊ��Ա�������ǳ�Ա����;
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
