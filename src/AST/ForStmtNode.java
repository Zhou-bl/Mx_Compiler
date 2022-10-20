package AST;

import Utils.Position;

/*
FOR '(' (initDecl=variableDecl | initExpr=expression)? ';' condition=expression? ';' incrExp=expression? ')' loopBody=statement
 */
public class ForStmtNode extends StmtNode{
    public VarDefStmtNode initDecl;
    public ExprNode initExpr;
    public ExprNode condition;
    public ExprNode incrExpr;
    public StmtNode loopBody;

    public ForStmtNode(VarDefStmtNode _decl, ExprNode _expr, ExprNode _condition, ExprNode _incr, StmtNode _body, Position _pos){
        super(_pos);
        this.initDecl = _decl;
        this.initExpr = _expr;
        this.condition = _condition;
        this.incrExpr = _incr;
        this.loopBody = _body;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
