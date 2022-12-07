package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class BinaryExprNode extends ExprNode {
    //+, -, *, /, %, <<, >>, >, <, >=, <=, ==, !=, &&, ||, ^, &, |, =;
    public enum BinaryOpType {ADD, SUB, MUL, DIV, MOD, SHL, SHR, GT, LT, GE, LE, EQ, NE, AND, OR, XOR, LAND, LOR, ASSIGN}
    public BinaryOpType opSymbol;
    public ExprNode leftOperand;
    public ExprNode rightOperand;

    public BinaryExprNode(BinaryOpType _op, ExprNode _left, ExprNode _right, Position _pos){
        super(_pos);
        this.opSymbol = _op;
        this.leftOperand = _left;
        this.rightOperand = _right;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
