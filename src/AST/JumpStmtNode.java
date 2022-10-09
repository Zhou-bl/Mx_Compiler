package AST;

import Utils.Position;

/*
jumpStmt
    : RETURN expression? ';'    #returnStatement
    | BREAK ';'                 #breakStatement
    | CONTINUE ';'              #continueStatement
    ;
 */
public class JumpStmtNode extends StmtNode{
    public boolean isReturn;
    public boolean isBreak;
    public boolean isContinue;

    public ExprNode returnValue;
    public JumpStmtNode(boolean _isReturn, boolean _isBreak, boolean _isContinue, ExprNode _re, Position _pos){
        super(_pos);
        this.isReturn = _isReturn;
        this.isBreak = _isBreak;
        this.isContinue = _isContinue;

        this.returnValue = _re;
    }
}
