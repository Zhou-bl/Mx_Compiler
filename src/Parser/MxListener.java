// Generated from D:/coding/Mx_Compiler/src/Parser\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MxParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MxParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declType}.
	 * @param ctx the parse tree
	 */
	void enterDeclType(MxParser.DeclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declType}.
	 * @param ctx the parse tree
	 */
	void exitDeclType(MxParser.DeclTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(MxParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(MxParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclStatement(MxParser.VariableDeclStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclStatement(MxParser.VariableDeclStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blankStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlankStatement(MxParser.BlankStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blankStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlankStatement(MxParser.BlankStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MxParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MxParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MxParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MxParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objPointer}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjPointer(MxParser.ObjPointerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objPointer}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjPointer(MxParser.ObjPointerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocErrorType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocErrorType(MxParser.AllocErrorTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocErrorType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocErrorType(MxParser.AllocErrorTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocArrayType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocArrayType(MxParser.AllocArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocArrayType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocArrayType(MxParser.AllocArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocBaseType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocBaseType(MxParser.AllocBaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocBaseType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocBaseType(MxParser.AllocBaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(MxParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(MxParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#baseVariableDecl}.
	 * @param ctx the parse tree
	 */
	void enterBaseVariableDecl(MxParser.BaseVariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseVariableDecl}.
	 * @param ctx the parse tree
	 */
	void exitBaseVariableDecl(MxParser.BaseVariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MxParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MxParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(MxParser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(MxParser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterListForCall}.
	 * @param ctx the parse tree
	 */
	void enterParameterListForCall(MxParser.ParameterListForCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterListForCall}.
	 * @param ctx the parse tree
	 */
	void exitParameterListForCall(MxParser.ParameterListForCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(MxParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(MxParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void enterConstantValue(MxParser.ConstantValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void exitConstantValue(MxParser.ConstantValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseVariableType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterBaseVariableType(MxParser.BaseVariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseVariableType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitBaseVariableType(MxParser.BaseVariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(MxParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(MxParser.FunctionTypeContext ctx);
}