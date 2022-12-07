package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class MonocularOpExprNode extends ExprNode{
    //!, ~, ++, --, ++(AFTER), --(AFTER), +, -;
    public enum MonocularOpType {LOGIC_NOT, BIT_NOT, SINC, SDER, SINC_AFT, SDER_AFT, POS, NEG}
    public MonocularOpType opSymbol;
    public ExprNode operand;

    public MonocularOpExprNode(ExprNode _operand, MonocularOpType _op, Position _pos){
        super(_pos);
        this.opSymbol = _op;
        this.operand = _operand;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
