package FrontEnd.Semantic.AST_Node;

import Utils.Position;

/*
WHILE '(' condition=expression ')' loopBody=statement
 */
public class WhileStmtNode extends StmtNode{
    public ExprNode condition;
    public StmtNode loopBody;

    public WhileStmtNode(ExprNode _condition, StmtNode _body, Position _pos){
        super(_pos);
        this.condition = _condition;
        this.loopBody = _body;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
