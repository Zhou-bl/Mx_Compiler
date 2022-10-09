package AST;

import Utils.Position;

import java.util.ArrayList;

public class ClassDefNode extends ASTNode{
    public String classID;
    public ArrayList<FuncDefNode> memberFunctions;
    public ArrayList<VarDefStmtNode> memberVariable;

    public ClassDefNode(String _id, ArrayList<FuncDefNode> _func, ArrayList<VarDefStmtNode> _var, Position _pos){
        super(_pos);
        this.classID = _id;
        this.memberFunctions = _func;
        this.memberVariable = _var;
    }
}