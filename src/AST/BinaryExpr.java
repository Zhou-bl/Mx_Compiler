package AST;

import Utils.Position;

public class BinaryExpr extends ExprNode {
    //+, -, *, /, %, <<, >>, >, <, >=, <=, ==, !=, &&, ||, ^, &, |, =;
    public enum BinaryOpType {ADD, SUB, MUL, DIV, MOD, SHL, SHR, GT, LT, GE, LE, EQ, NE, AND, OR, XOR, LAND, LOR, ASSIGN}
    BinaryOpType opSymbol;
    public ExprNode leftOperand;
    public ExprNode rightOperand;

    public BinaryExpr(BinaryOpType _op, ExprNode _left, ExprNode _right, Position _pos){
        super(_pos);
        this.opSymbol = _op;
        this.leftOperand = _left;
        this.rightOperand = _right;
    }
}
