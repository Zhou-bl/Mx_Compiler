// Generated from D:/coding/Mx_Compiler/src/Parser\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MxParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#declType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclType(MxParser.DeclTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(MxParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclStatement(MxParser.VariableDeclStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankStatement(MxParser.BlankStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MxParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MxParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objPointer}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjPointer(MxParser.ObjPointerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocErrorType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocErrorType(MxParser.AllocErrorTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocArrayType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocArrayType(MxParser.AllocArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocBaseType}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocBaseType(MxParser.AllocBaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(MxParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#baseVariableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseVariableDecl(MxParser.BaseVariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MxParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(MxParser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterListForCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListForCall(MxParser.ParameterListForCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(MxParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constantValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantValue(MxParser.ConstantValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseVariableType}
	 * labeled alternative in {@link MxParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseVariableType(MxParser.BaseVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(MxParser.FunctionTypeContext ctx);
}