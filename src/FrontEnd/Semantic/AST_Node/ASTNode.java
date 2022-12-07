package FrontEnd.Semantic.AST_Node;

import FrontEnd.LLVM_IR.BasicClass.Value;
import Utils.Position;

abstract public class ASTNode {
    public Position pos;
    public Value IROperand;

    public ASTNode(Position pos) {
        this.pos = pos;
        this.IROperand = null;
    }
    abstract public void accept(ASTVisitor visitor);
}
