package FrontEnd.Semantic.AST_Node;

import Utils.Position;

import java.util.ArrayList;

/*
expression '(' parameterListForCall? ')'
 */
public class FuncCallExprNode extends ExprNode{
    public ExprNode func;
    public ArrayList<ExprNode> parameterListForCall;

    public FuncCallExprNode(ExprNode _func, ArrayList<ExprNode> _parameter, Position _pos){
        super(_pos);
        this.func = _func;
        this.parameterListForCall = _parameter;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
