package AST;

import Utils.Position;

import java.util.ArrayList;

/*
functionDecl : functionType? IDENTIFIER '(' parameterList? ')' block;
 */
public class FuncDefNode extends ASTNode{
    /*
    functionType
    : variableType
    | VOID
    ;
     */
    public TypeNode functionType;
    public String functionID;
    public ArrayList<VarDefNode> parameterList;
    public BlockStmtNode functionBody;

    public FuncDefNode(TypeNode _type, String _id, ArrayList<VarDefNode> _parameterList, BlockStmtNode _body, Position _pos){
        super(_pos);
        this.functionType = _type;
        this.functionID = _id;
        this.parameterList = _parameterList;
        this.functionBody = _body;
    }
}
