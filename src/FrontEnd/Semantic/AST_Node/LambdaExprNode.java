package FrontEnd.Semantic.AST_Node;

/*
LAMBDAS1 lambdaParameterList? LAMBDAS2 block '(' parameterListForCall? ')'    #lambdaExp

lambdaParameterList : '(' parameterList? ')';

parameterListForCall : expression (',' expression)* ;

parameterList : variableType IDENTIFIER (',' variableType IDENTIFIER)* ;
 */

import Utils.Position;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode {
    public boolean isGlobal;
    public TypeNode returnType;
    public ArrayList<VarDefNode> lambdaParameter;
    public BlockStmtNode funcBody;
    public ArrayList<ExprNode> parameterForCall;

    public LambdaExprNode(ArrayList<VarDefNode> _lambdaPara, ArrayList<ExprNode> _para, BlockStmtNode _body, boolean _isGlobal, Position _pos){
        super(_pos);
        this.returnType = null;
        this.lambdaParameter = _lambdaPara;
        this.funcBody = _body;
        this.parameterForCall = _para;
        this.isGlobal = _isGlobal;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
