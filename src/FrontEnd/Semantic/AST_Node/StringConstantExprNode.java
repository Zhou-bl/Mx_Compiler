package FrontEnd.Semantic.AST_Node;

import Utils.Position;

public class StringConstantExprNode extends ExprNode{
    public String value;

    public StringConstantExprNode(String _value, Position _pos){
        super(_pos);
        this.value = _value.substring(1, _value.length() - 1).replace("\\\\", "\\")
                .replace("\\n", "\n").replace("\\t", "\t").replace("\\\"", "\"") + "\0";
        this.exprType = new ClassTypeNode("string", _pos);
    }

    public String getValue(){
        return this.value;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
