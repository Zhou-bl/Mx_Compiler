package AST;

import Utils.Position;

/*
FOR '(' (initDecl=variableDecl | initExpr=expression)? ';' condition=expression? ';' incrExp=expression? ')' loopBody=statement
 */
public class ForStmtNode extends StmtNode{
    public StmtNode init;
    public ExprNode condition;
    public ExprNode incrExpr;
    public BlockStmtNode loopBody;

    public ForStmtNode(StmtNode _init, ExprNode _condition, ExprNode _incr, BlockStmtNode _body, Position _pos){
        super(_pos);
        this.init = _init;
        this.condition = _condition;
        this.incrExpr = _incr;
        this.loopBody = _body;
    }
}
