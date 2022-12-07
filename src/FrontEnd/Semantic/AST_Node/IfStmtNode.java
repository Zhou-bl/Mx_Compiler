package FrontEnd.Semantic.AST_Node;

import Utils.Position;

/*
ifStmt
ifStmt : IF '(' condition=expression ')' thenStatement=statement (ELSE elseStament=statement)?;
 */
public class IfStmtNode extends StmtNode{
    public ExprNode condition;
    public StmtNode thenStmt;
    public StmtNode elseStmt;

    public IfStmtNode(ExprNode _condition, StmtNode _then, StmtNode _else, Position _pos){
        super(_pos);
        this.condition = _condition;
        this.thenStmt = _then;
        this.elseStmt = _else;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
