package FrontEnd.Semantic.AST_Node;

public interface ASTVisitor{
    void visit(ArrayAccessNode node);

    void visit(ArrayTypeNode node);

    void visit(BinaryExprNode node);

    void visit(BlockStmtNode node);

    void visit(BoolConstantExprNode node);

    void visit(BreakStmtNode Node);

    void visit(ClassDefNode Node);

    void visit(ClassTypeNode node);

    void visit(ContinueStmtNode node);

    void visit(ExprStmtNode node);

    void visit(ForStmtNode node);

    void visit(FuncCallExprNode node);

    void visit(FuncDefNode node);

    void visit(IdentifierExprNode node);

    void visit(IfStmtNode node);

    void visit(IntConstantExprNode node);

    void visit(MonocularOpExprNode node);

    void visit(AllocExprNode node);

    void visit(NullExprNode node);

    void visit(ObjectPortionExprNode node);

    void visit(ReturnStmtNode node);

    void visit(RootNode node);

    void visit(StringConstantExprNode node);

    void visit(ThisExprNode node);

    void visit(VarDefStmtNode node);

    void visit(VarDefNode node);

    void visit(VoidTypeNode node);

    void visit(WhileStmtNode node);

    void visit(LambdaExprNode node);
}