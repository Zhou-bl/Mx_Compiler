package AST;

import Utils.Position;

public class MonocularOpExpr extends ExprNode{
    //!, ~, ++, --, ++(AFTER), --(AFTER), +, -;
    public enum MonocularOpType {LOGIC_NOT, BIT_NOT, SINC, SDER, SINC_AFT, SDER_AFT, POS, NEG}
    MonocularOpExpr opSymbol;
    public ExprNode operand;

    public MonocularOpExpr(ExprNode _operand, MonocularOpExpr _op, Position _pos){
        super(_pos);
        this.opSymbol = _op;
        this.operand = _operand;
    }
}
