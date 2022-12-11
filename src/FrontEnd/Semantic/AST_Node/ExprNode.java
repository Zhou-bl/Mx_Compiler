package FrontEnd.Semantic.AST_Node;

import FrontEnd.LLVM_IR.Operand.IRConstant;
import Utils.Position;

public abstract class ExprNode extends ASTNode{
    public TypeNode exprType;
    public boolean isAssignment;
    public IRConstant forConstant;

    public ExprNode(Position _pos){
        super(_pos);
        this.exprType = null;
        this.isAssignment = false;
    }
}
