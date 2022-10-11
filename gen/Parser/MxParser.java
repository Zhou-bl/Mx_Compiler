// Generated from D:/ÖÜ±üÁØ/coding/Mx_Compiler/src/Parser\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		DOT=32, LAMBDAS1=33, LAMBDAS2=34, INT=35, BOOL=36, STRING=37, VOID=38, 
		IF=39, ELSE=40, FOR=41, WHILE=42, BREAK=43, CONTINUE=44, RETURN=45, NEW=46, 
		CLASS=47, THIS=48, NULL_CONSTANT=49, BOOL_CONSTANT=50, INTERGER_CONSTANT=51, 
		STRING_CONSTANT=52, IDENTIFIER=53, WS=54, LINE_COMMENT=55, BLOCK_COMMENT=56;
	public static final int
		RULE_prog = 0, RULE_declType = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_expression = 4, RULE_allocFormat = 5, RULE_ifStmt = 6, RULE_jumpStmt = 7, 
		RULE_variableDecl = 8, RULE_baseVariableDecl = 9, RULE_functionDecl = 10, 
		RULE_parameterList = 11, RULE_lambdaParameterList = 12, RULE_parameterListForCall = 13, 
		RULE_classDecl = 14, RULE_constantValue = 15, RULE_baseType = 16, RULE_variableType = 17, 
		RULE_functionType = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declType", "statement", "block", "expression", "allocFormat", 
			"ifStmt", "jumpStmt", "variableDecl", "baseVariableDecl", "functionDecl", 
			"parameterList", "lambdaParameterList", "parameterListForCall", "classDecl", 
			"constantValue", "baseType", "variableType", "functionType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'++'", "'--'", 
			"'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'>>'", "'<<'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", 
			"'='", "','", "'.'", "'[&]'", "'->'", "'int'", "'bool'", "'string'", 
			"'void'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", "'new'", "'class'", "'this'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "DOT", "LAMBDAS1", "LAMBDAS2", 
			"INT", "BOOL", "STRING", "VOID", "IF", "ELSE", "FOR", "WHILE", "BREAK", 
			"CONTINUE", "RETURN", "NEW", "CLASS", "THIS", "NULL_CONSTANT", "BOOL_CONSTANT", 
			"INTERGER_CONSTANT", "STRING_CONSTANT", "IDENTIFIER", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<DeclTypeContext> declType() {
			return getRuleContexts(DeclTypeContext.class);
		}
		public DeclTypeContext declType(int i) {
			return getRuleContext(DeclTypeContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(38);
				declType();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclTypeContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public DeclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclTypeContext declType() throws RecognitionException {
		DeclTypeContext _localctx = new DeclTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declType);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				classDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				variableDecl();
				setState(47);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementContext extends StatementContext {
		public ExpressionContext condition;
		public StatementContext loopBody;
		public TerminalNode WHILE() { return getToken(MxParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclStatementContext extends StatementContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public VariableDeclStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableDeclStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableDeclStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableDeclStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CodeBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CodeBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankStatementContext extends StatementContext {
		public BlankStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlankStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlankStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlankStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExprStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatementContext extends StatementContext {
		public VariableDeclContext initDecl;
		public ExpressionContext initExpr;
		public ExpressionContext condition;
		public ExpressionContext incrExpr;
		public StatementContext loopBody;
		public TerminalNode FOR() { return getToken(MxParser.FOR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatementContext extends StatementContext {
		public JumpStmtContext jumpStmt() {
			return getRuleContext(JumpStmtContext.class,0);
		}
		public JumpStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CodeBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				block();
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				ifStmt();
				}
				break;
			case 3:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				match(WHILE);
				setState(54);
				match(T__1);
				setState(55);
				((WhileStatementContext)_localctx).condition = expression(0);
				setState(56);
				match(T__2);
				setState(57);
				((WhileStatementContext)_localctx).loopBody = statement();
				}
				break;
			case 4:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				match(FOR);
				setState(60);
				match(T__1);
				setState(63);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(61);
					((ForStatementContext)_localctx).initDecl = variableDecl();
					}
					break;
				case 2:
					{
					setState(62);
					((ForStatementContext)_localctx).initExpr = expression(0);
					}
					break;
				}
				setState(65);
				match(T__0);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(66);
					((ForStatementContext)_localctx).condition = expression(0);
					}
				}

				setState(69);
				match(T__0);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(70);
					((ForStatementContext)_localctx).incrExpr = expression(0);
					}
				}

				setState(73);
				match(T__2);
				setState(74);
				((ForStatementContext)_localctx).loopBody = statement();
				}
				break;
			case 5:
				_localctx = new JumpStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				jumpStmt();
				}
				break;
			case 6:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				expression(0);
				setState(77);
				match(T__0);
				}
				break;
			case 7:
				_localctx = new VariableDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				variableDecl();
				setState(80);
				match(T__0);
				}
				break;
			case 8:
				_localctx = new BlankStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__3);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(86);
				statement();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ObjPortionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MxParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public ObjPortionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterObjPortion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitObjPortion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitObjPortion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AftermonocularOpContext extends ExpressionContext {
		public ExpressionContext operand;
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AftermonocularOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAftermonocularOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAftermonocularOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAftermonocularOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompoundExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompoundExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompoundExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompoundExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExpressionContext {
		public TerminalNode LAMBDAS1() { return getToken(MxParser.LAMBDAS1, 0); }
		public TerminalNode LAMBDAS2() { return getToken(MxParser.LAMBDAS2, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaParameterListContext lambdaParameterList() {
			return getRuleContext(LambdaParameterListContext.class,0);
		}
		public ParameterListForCallContext parameterListForCall() {
			return getRuleContext(ParameterListForCallContext.class,0);
		}
		public LambdaExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocExprContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(MxParser.NEW, 0); }
		public AllocFormatContext allocFormat() {
			return getRuleContext(AllocFormatContext.class,0);
		}
		public AllocExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListForCallContext parameterListForCall() {
			return getRuleContext(ParameterListForCallContext.class,0);
		}
		public FunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MonocularOpContext extends ExpressionContext {
		public Token op;
		public ExpressionContext operand;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MonocularOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMonocularOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMonocularOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMonocularOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjPointerContext extends ExpressionContext {
		public TerminalNode THIS() { return getToken(MxParser.THIS, 0); }
		public ObjPointerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterObjPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitObjPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitObjPointer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public ExpressionContext operand1;
		public Token op;
		public ExpressionContext operand2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessContext extends ExpressionContext {
		public ExpressionContext array;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(95);
				match(IDENTIFIER);
				}
				break;
			case NULL_CONSTANT:
			case BOOL_CONSTANT:
			case INTERGER_CONSTANT:
			case STRING_CONSTANT:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				constantValue();
				}
				break;
			case NEW:
				{
				_localctx = new AllocExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(NEW);
				setState(98);
				allocFormat();
				}
				break;
			case T__1:
				{
				_localctx = new CompoundExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(T__1);
				setState(100);
				expression(0);
				setState(101);
				match(T__2);
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				{
				_localctx = new MonocularOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				((MonocularOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
					((MonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(104);
				((MonocularOpContext)_localctx).operand = expression(15);
				}
				break;
			case T__14:
			case T__15:
				{
				_localctx = new MonocularOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				((MonocularOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
					((MonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(106);
				((MonocularOpContext)_localctx).operand = expression(12);
				}
				break;
			case THIS:
				{
				_localctx = new ObjPointerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(THIS);
				}
				break;
			case LAMBDAS1:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(LAMBDAS1);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(109);
					lambdaParameterList();
					}
				}

				setState(112);
				match(LAMBDAS2);
				setState(113);
				block();
				setState(114);
				match(T__1);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(115);
					parameterListForCall();
					}
				}

				setState(118);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(123);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						((BinaryExprContext)_localctx).operand2 = expression(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(126);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__15) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						((BinaryExprContext)_localctx).operand2 = expression(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(129);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						((BinaryExprContext)_localctx).operand2 = expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(131);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(132);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						((BinaryExprContext)_localctx).operand2 = expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(135);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						((BinaryExprContext)_localctx).operand2 = expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(138);
						((BinaryExprContext)_localctx).op = match(T__24);
						setState(139);
						((BinaryExprContext)_localctx).operand2 = expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(141);
						((BinaryExprContext)_localctx).op = match(T__25);
						setState(142);
						((BinaryExprContext)_localctx).operand2 = expression(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(144);
						((BinaryExprContext)_localctx).op = match(T__26);
						setState(145);
						((BinaryExprContext)_localctx).operand2 = expression(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(147);
						((BinaryExprContext)_localctx).op = match(T__27);
						setState(148);
						((BinaryExprContext)_localctx).operand2 = expression(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						((BinaryExprContext)_localctx).op = match(T__28);
						setState(151);
						((BinaryExprContext)_localctx).operand2 = expression(5);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						((BinaryExprContext)_localctx).op = match(T__29);
						setState(154);
						((BinaryExprContext)_localctx).operand2 = expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ObjPortionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(156);
						match(DOT);
						setState(157);
						match(IDENTIFIER);
						}
						break;
					case 13:
						{
						_localctx = new FunctionCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(159);
						match(T__1);
						setState(161);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
							{
							setState(160);
							parameterListForCall();
							}
						}

						setState(163);
						match(T__2);
						}
						break;
					case 14:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						((ArrayAccessContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(165);
						match(T__5);
						setState(166);
						((ArrayAccessContext)_localctx).index = expression(0);
						setState(167);
						match(T__6);
						}
						break;
					case 15:
						{
						_localctx = new AftermonocularOpContext(new ExpressionContext(_parentctx, _parentState));
						((AftermonocularOpContext)_localctx).operand = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(170);
						((AftermonocularOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__8) ) {
							((AftermonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AllocFormatContext extends ParserRuleContext {
		public AllocFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocFormat; }
	 
		public AllocFormatContext() { }
		public void copyFrom(AllocFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllocBaseTypeContext extends AllocFormatContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public AllocBaseTypeContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocBaseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocErrorTypeContext extends AllocFormatContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AllocErrorTypeContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocErrorType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocErrorType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocErrorType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocArrayTypeContext extends AllocFormatContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AllocArrayTypeContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllocFormatContext allocFormat() throws RecognitionException {
		AllocFormatContext _localctx = new AllocFormatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_allocFormat);
		try {
			int _alt;
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new AllocErrorTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				baseType();
				setState(181); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(177);
						match(T__5);
						setState(178);
						expression(0);
						setState(179);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(183); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(187); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(185);
						match(T__5);
						setState(186);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(189); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(195); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(191);
						match(T__5);
						setState(192);
						expression(0);
						setState(193);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(197); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new AllocArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				baseType();
				setState(204); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(200);
						match(T__5);
						setState(201);
						expression(0);
						setState(202);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(206); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(208);
						match(T__5);
						setState(209);
						match(T__6);
						}
						} 
					}
					setState(214);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new AllocBaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				baseType();
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(216);
					match(T__1);
					setState(217);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StatementContext thenStatement;
		public StatementContext elseStatement;
		public TerminalNode IF() { return getToken(MxParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MxParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(IF);
			setState(223);
			match(T__1);
			setState(224);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(225);
			match(T__2);
			setState(226);
			((IfStmtContext)_localctx).thenStatement = statement();
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(227);
				match(ELSE);
				setState(228);
				((IfStmtContext)_localctx).elseStatement = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStmtContext extends ParserRuleContext {
		public JumpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStmt; }
	 
		public JumpStmtContext() { }
		public void copyFrom(JumpStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakStatementContext extends JumpStmtContext {
		public TerminalNode BREAK() { return getToken(MxParser.BREAK, 0); }
		public BreakStatementContext(JumpStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatementContext extends JumpStmtContext {
		public TerminalNode CONTINUE() { return getToken(MxParser.CONTINUE, 0); }
		public ContinueStatementContext(JumpStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends JumpStmtContext {
		public TerminalNode RETURN() { return getToken(MxParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(JumpStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_jumpStmt);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(RETURN);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << LAMBDAS1) | (1L << NEW) | (1L << THIS) | (1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(232);
					expression(0);
					}
				}

				setState(235);
				match(T__0);
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(BREAK);
				setState(237);
				match(T__0);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(CONTINUE);
				setState(239);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public List<BaseVariableDeclContext> baseVariableDecl() {
			return getRuleContexts(BaseVariableDeclContext.class);
		}
		public BaseVariableDeclContext baseVariableDecl(int i) {
			return getRuleContext(BaseVariableDeclContext.class,i);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			variableType(0);
			setState(243);
			baseVariableDecl();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(244);
				match(T__30);
				setState(245);
				baseVariableDecl();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseVariableDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BaseVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseVariableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBaseVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBaseVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBaseVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseVariableDeclContext baseVariableDecl() throws RecognitionException {
		BaseVariableDeclContext _localctx = new BaseVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_baseVariableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(IDENTIFIER);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(252);
				match(T__29);
				setState(253);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(256);
				functionType();
				}
				break;
			}
			setState(259);
			match(IDENTIFIER);
			setState(260);
			match(T__1);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(261);
				parameterList();
				}
			}

			setState(264);
			match(T__2);
			setState(265);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<VariableTypeContext> variableType() {
			return getRuleContexts(VariableTypeContext.class);
		}
		public VariableTypeContext variableType(int i) {
			return getRuleContext(VariableTypeContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(MxParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MxParser.IDENTIFIER, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			variableType(0);
			setState(268);
			match(IDENTIFIER);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(269);
				match(T__30);
				setState(270);
				variableType(0);
				setState(271);
				match(IDENTIFIER);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaParameterListContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public LambdaParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParameterListContext lambdaParameterList() throws RecognitionException {
		LambdaParameterListContext _localctx = new LambdaParameterListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lambdaParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__1);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(279);
				parameterList();
				}
			}

			setState(282);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListForCallContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParameterListForCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterListForCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterListForCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterListForCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterListForCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListForCallContext parameterListForCall() throws RecognitionException {
		ParameterListForCallContext _localctx = new ParameterListForCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameterListForCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			expression(0);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(285);
				match(T__30);
				setState(286);
				expression(0);
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public Token className;
		public TerminalNode CLASS() { return getToken(MxParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(CLASS);
			setState(293);
			((ClassDeclContext)_localctx).className = match(IDENTIFIER);
			setState(294);
			match(T__3);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					{
					setState(295);
					variableDecl();
					setState(296);
					match(T__0);
					}
					}
					break;
				case 2:
					{
					setState(298);
					functionDecl();
					}
					break;
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
			match(T__4);
			setState(305);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantValueContext extends ParserRuleContext {
		public TerminalNode BOOL_CONSTANT() { return getToken(MxParser.BOOL_CONSTANT, 0); }
		public TerminalNode INTERGER_CONSTANT() { return getToken(MxParser.INTERGER_CONSTANT, 0); }
		public TerminalNode STRING_CONSTANT() { return getToken(MxParser.STRING_CONSTANT, 0); }
		public TerminalNode NULL_CONSTANT() { return getToken(MxParser.NULL_CONSTANT, 0); }
		public ConstantValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstantValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstantValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstantValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantValueContext constantValue() throws RecognitionException {
		ConstantValueContext _localctx = new ConstantValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constantValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL_CONSTANT) | (1L << BOOL_CONSTANT) | (1L << INTERGER_CONSTANT) | (1L << STRING_CONSTANT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MxParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(MxParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(MxParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MxParser.IDENTIFIER, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTypeContext extends ParserRuleContext {
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
	 
		public VariableTypeContext() { }
		public void copyFrom(VariableTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends VariableTypeContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public ArrayTypeContext(VariableTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseVariableTypeContext extends VariableTypeContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public BaseVariableTypeContext(VariableTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBaseVariableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBaseVariableType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBaseVariableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		return variableType(0);
	}

	private VariableTypeContext variableType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, _parentState);
		VariableTypeContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_variableType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BaseVariableTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(312);
			baseType();
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new VariableTypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variableType);
					setState(314);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(315);
					match(T__5);
					setState(316);
					match(T__6);
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionTypeContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MxParser.VOID, 0); }
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionType);
		try {
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				variableType(0);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 17:
			return variableType_sempred((VariableTypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 21);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		}
		return true;
	}
	private boolean variableType_sempred(VariableTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0147\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002@\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002T\b\u0002\u0001\u0003\u0001\u0003\u0005"+
		"\u0003X\b\u0003\n\u0003\f\u0003[\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004o\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004u\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004y\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u00a2\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00ac"+
		"\b\u0004\n\u0004\f\u0004\u00af\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005\u00b6\b\u0005\u000b\u0005\f\u0005"+
		"\u00b7\u0001\u0005\u0001\u0005\u0004\u0005\u00bc\b\u0005\u000b\u0005\f"+
		"\u0005\u00bd\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"\u00c4\b\u0005\u000b\u0005\f\u0005\u00c5\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00cd\b\u0005\u000b\u0005\f"+
		"\u0005\u00ce\u0001\u0005\u0001\u0005\u0005\u0005\u00d3\b\u0005\n\u0005"+
		"\f\u0005\u00d6\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00db\b\u0005\u0003\u0005\u00dd\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00e6"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00ea\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00f1\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00f7\b\b\n\b\f\b\u00fa\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00ff\b\t\u0001\n\u0003\n\u0102\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u0107\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0112\b\u000b\n\u000b\f\u000b\u0115\t\u000b\u0001\f\u0001\f\u0003\f\u0119"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u0120\b\r\n\r\f\r"+
		"\u0123\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u012c\b\u000e\n\u000e\f\u000e\u012f"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u013e\b\u0011\n\u0011\f\u0011\u0141\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0145\b\u0012\u0001\u0012\u0000\u0002"+
		"\b\"\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$\u0000\t\u0001\u0000\b\u000b\u0001\u0000\u000f"+
		"\u0010\u0001\u0000\f\u000e\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0016"+
		"\u0001\u0000\u0017\u0018\u0001\u0000\b\t\u0001\u000014\u0002\u0000#%5"+
		"5\u0172\u0000)\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000"+
		"\u0004S\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\bx\u0001"+
		"\u0000\u0000\u0000\n\u00dc\u0001\u0000\u0000\u0000\f\u00de\u0001\u0000"+
		"\u0000\u0000\u000e\u00f0\u0001\u0000\u0000\u0000\u0010\u00f2\u0001\u0000"+
		"\u0000\u0000\u0012\u00fb\u0001\u0000\u0000\u0000\u0014\u0101\u0001\u0000"+
		"\u0000\u0000\u0016\u010b\u0001\u0000\u0000\u0000\u0018\u0116\u0001\u0000"+
		"\u0000\u0000\u001a\u011c\u0001\u0000\u0000\u0000\u001c\u0124\u0001\u0000"+
		"\u0000\u0000\u001e\u0133\u0001\u0000\u0000\u0000 \u0135\u0001\u0000\u0000"+
		"\u0000\"\u0137\u0001\u0000\u0000\u0000$\u0144\u0001\u0000\u0000\u0000"+
		"&(\u0003\u0002\u0001\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*\u0001\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,2\u0003\u0014\n\u0000-2\u0003"+
		"\u001c\u000e\u0000./\u0003\u0010\b\u0000/0\u0005\u0001\u0000\u000002\u0001"+
		"\u0000\u0000\u00001,\u0001\u0000\u0000\u00001-\u0001\u0000\u0000\u0000"+
		"1.\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000\u00003T\u0003\u0006"+
		"\u0003\u00004T\u0003\f\u0006\u000056\u0005*\u0000\u000067\u0005\u0002"+
		"\u0000\u000078\u0003\b\u0004\u000089\u0005\u0003\u0000\u00009:\u0003\u0004"+
		"\u0002\u0000:T\u0001\u0000\u0000\u0000;<\u0005)\u0000\u0000<?\u0005\u0002"+
		"\u0000\u0000=@\u0003\u0010\b\u0000>@\u0003\b\u0004\u0000?=\u0001\u0000"+
		"\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AC\u0005\u0001\u0000\u0000BD\u0003\b\u0004\u0000CB\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EG\u0005\u0001\u0000\u0000FH\u0003\b\u0004\u0000GF\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\u0003\u0000"+
		"\u0000JT\u0003\u0004\u0002\u0000KT\u0003\u000e\u0007\u0000LM\u0003\b\u0004"+
		"\u0000MN\u0005\u0001\u0000\u0000NT\u0001\u0000\u0000\u0000OP\u0003\u0010"+
		"\b\u0000PQ\u0005\u0001\u0000\u0000QT\u0001\u0000\u0000\u0000RT\u0005\u0001"+
		"\u0000\u0000S3\u0001\u0000\u0000\u0000S4\u0001\u0000\u0000\u0000S5\u0001"+
		"\u0000\u0000\u0000S;\u0001\u0000\u0000\u0000SK\u0001\u0000\u0000\u0000"+
		"SL\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000T\u0005\u0001\u0000\u0000\u0000UY\u0005\u0004\u0000\u0000VX\u0003"+
		"\u0004\u0002\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0005\u0000\u0000]\u0007\u0001"+
		"\u0000\u0000\u0000^_\u0006\u0004\uffff\uffff\u0000_y\u00055\u0000\u0000"+
		"`y\u0003\u001e\u000f\u0000ab\u0005.\u0000\u0000by\u0003\n\u0005\u0000"+
		"cd\u0005\u0002\u0000\u0000de\u0003\b\u0004\u0000ef\u0005\u0003\u0000\u0000"+
		"fy\u0001\u0000\u0000\u0000gh\u0007\u0000\u0000\u0000hy\u0003\b\u0004\u000f"+
		"ij\u0007\u0001\u0000\u0000jy\u0003\b\u0004\fky\u00050\u0000\u0000ln\u0005"+
		"!\u0000\u0000mo\u0003\u0018\f\u0000nm\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005\"\u0000\u0000qr\u0003"+
		"\u0006\u0003\u0000rt\u0005\u0002\u0000\u0000su\u0003\u001a\r\u0000ts\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vw\u0005\u0003\u0000\u0000wy\u0001\u0000\u0000\u0000x^\u0001\u0000\u0000"+
		"\u0000x`\u0001\u0000\u0000\u0000xa\u0001\u0000\u0000\u0000xc\u0001\u0000"+
		"\u0000\u0000xg\u0001\u0000\u0000\u0000xi\u0001\u0000\u0000\u0000xk\u0001"+
		"\u0000\u0000\u0000xl\u0001\u0000\u0000\u0000y\u00ad\u0001\u0000\u0000"+
		"\u0000z{\n\u000e\u0000\u0000{|\u0007\u0002\u0000\u0000|\u00ac\u0003\b"+
		"\u0004\u000f}~\n\r\u0000\u0000~\u007f\u0007\u0001\u0000\u0000\u007f\u00ac"+
		"\u0003\b\u0004\u000e\u0080\u0081\n\u000b\u0000\u0000\u0081\u0082\u0007"+
		"\u0003\u0000\u0000\u0082\u00ac\u0003\b\u0004\f\u0083\u0084\n\n\u0000\u0000"+
		"\u0084\u0085\u0007\u0004\u0000\u0000\u0085\u00ac\u0003\b\u0004\u000b\u0086"+
		"\u0087\n\t\u0000\u0000\u0087\u0088\u0007\u0005\u0000\u0000\u0088\u00ac"+
		"\u0003\b\u0004\n\u0089\u008a\n\b\u0000\u0000\u008a\u008b\u0005\u0019\u0000"+
		"\u0000\u008b\u00ac\u0003\b\u0004\t\u008c\u008d\n\u0007\u0000\u0000\u008d"+
		"\u008e\u0005\u001a\u0000\u0000\u008e\u00ac\u0003\b\u0004\b\u008f\u0090"+
		"\n\u0006\u0000\u0000\u0090\u0091\u0005\u001b\u0000\u0000\u0091\u00ac\u0003"+
		"\b\u0004\u0007\u0092\u0093\n\u0005\u0000\u0000\u0093\u0094\u0005\u001c"+
		"\u0000\u0000\u0094\u00ac\u0003\b\u0004\u0006\u0095\u0096\n\u0004\u0000"+
		"\u0000\u0096\u0097\u0005\u001d\u0000\u0000\u0097\u00ac\u0003\b\u0004\u0005"+
		"\u0098\u0099\n\u0003\u0000\u0000\u0099\u009a\u0005\u001e\u0000\u0000\u009a"+
		"\u00ac\u0003\b\u0004\u0003\u009b\u009c\n\u0015\u0000\u0000\u009c\u009d"+
		"\u0005 \u0000\u0000\u009d\u00ac\u00055\u0000\u0000\u009e\u009f\n\u0013"+
		"\u0000\u0000\u009f\u00a1\u0005\u0002\u0000\u0000\u00a0\u00a2\u0003\u001a"+
		"\r\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00ac\u0005\u0003\u0000"+
		"\u0000\u00a4\u00a5\n\u0011\u0000\u0000\u00a5\u00a6\u0005\u0006\u0000\u0000"+
		"\u00a6\u00a7\u0003\b\u0004\u0000\u00a7\u00a8\u0005\u0007\u0000\u0000\u00a8"+
		"\u00ac\u0001\u0000\u0000\u0000\u00a9\u00aa\n\u0010\u0000\u0000\u00aa\u00ac"+
		"\u0007\u0006\u0000\u0000\u00abz\u0001\u0000\u0000\u0000\u00ab}\u0001\u0000"+
		"\u0000\u0000\u00ab\u0080\u0001\u0000\u0000\u0000\u00ab\u0083\u0001\u0000"+
		"\u0000\u0000\u00ab\u0086\u0001\u0000\u0000\u0000\u00ab\u0089\u0001\u0000"+
		"\u0000\u0000\u00ab\u008c\u0001\u0000\u0000\u0000\u00ab\u008f\u0001\u0000"+
		"\u0000\u0000\u00ab\u0092\u0001\u0000\u0000\u0000\u00ab\u0095\u0001\u0000"+
		"\u0000\u0000\u00ab\u0098\u0001\u0000\u0000\u0000\u00ab\u009b\u0001\u0000"+
		"\u0000\u0000\u00ab\u009e\u0001\u0000\u0000\u0000\u00ab\u00a4\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\t\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b5\u0003 \u0010\u0000\u00b1\u00b2\u0005\u0006\u0000\u0000"+
		"\u00b2\u00b3\u0003\b\u0004\u0000\u00b3\u00b4\u0005\u0007\u0000\u0000\u00b4"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0005\u0006\u0000\u0000\u00ba\u00bc\u0005\u0007\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u00c3\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0006\u0000\u0000\u00c0"+
		"\u00c1\u0003\b\u0004\u0000\u00c1\u00c2\u0005\u0007\u0000\u0000\u00c2\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c6\u00dd\u0001\u0000\u0000\u0000\u00c7\u00cc"+
		"\u0003 \u0010\u0000\u00c8\u00c9\u0005\u0006\u0000\u0000\u00c9\u00ca\u0003"+
		"\b\u0004\u0000\u00ca\u00cb\u0005\u0007\u0000\u0000\u00cb\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cc\u00c8\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d4\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0006"+
		"\u0000\u0000\u00d1\u00d3\u0005\u0007\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00dd\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00da\u0003 \u0010"+
		"\u0000\u00d8\u00d9\u0005\u0002\u0000\u0000\u00d9\u00db\u0005\u0003\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00b0\u0001\u0000\u0000"+
		"\u0000\u00dc\u00c7\u0001\u0000\u0000\u0000\u00dc\u00d7\u0001\u0000\u0000"+
		"\u0000\u00dd\u000b\u0001\u0000\u0000\u0000\u00de\u00df\u0005\'\u0000\u0000"+
		"\u00df\u00e0\u0005\u0002\u0000\u0000\u00e0\u00e1\u0003\b\u0004\u0000\u00e1"+
		"\u00e2\u0005\u0003\u0000\u0000\u00e2\u00e5\u0003\u0004\u0002\u0000\u00e3"+
		"\u00e4\u0005(\u0000\u0000\u00e4\u00e6\u0003\u0004\u0002\u0000\u00e5\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\r\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e9\u0005-\u0000\u0000\u00e8\u00ea\u0003\b"+
		"\u0004\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00f1\u0005\u0001"+
		"\u0000\u0000\u00ec\u00ed\u0005+\u0000\u0000\u00ed\u00f1\u0005\u0001\u0000"+
		"\u0000\u00ee\u00ef\u0005,\u0000\u0000\u00ef\u00f1\u0005\u0001\u0000\u0000"+
		"\u00f0\u00e7\u0001\u0000\u0000\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000"+
		"\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u000f\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0003\"\u0011\u0000\u00f3\u00f8\u0003\u0012\t\u0000\u00f4"+
		"\u00f5\u0005\u001f\u0000\u0000\u00f5\u00f7\u0003\u0012\t\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u0011"+
		"\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fe"+
		"\u00055\u0000\u0000\u00fc\u00fd\u0005\u001e\u0000\u0000\u00fd\u00ff\u0003"+
		"\b\u0004\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000"+
		"\u0000\u0000\u00ff\u0013\u0001\u0000\u0000\u0000\u0100\u0102\u0003$\u0012"+
		"\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0104\u00055\u0000\u0000"+
		"\u0104\u0106\u0005\u0002\u0000\u0000\u0105\u0107\u0003\u0016\u000b\u0000"+
		"\u0106\u0105\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0003\u0000\u0000"+
		"\u0109\u010a\u0003\u0006\u0003\u0000\u010a\u0015\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0003\"\u0011\u0000\u010c\u0113\u00055\u0000\u0000\u010d"+
		"\u010e\u0005\u001f\u0000\u0000\u010e\u010f\u0003\"\u0011\u0000\u010f\u0110"+
		"\u00055\u0000\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u010d\u0001"+
		"\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0017\u0001"+
		"\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0118\u0005"+
		"\u0002\u0000\u0000\u0117\u0119\u0003\u0016\u000b\u0000\u0118\u0117\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0005\u0003\u0000\u0000\u011b\u0019\u0001"+
		"\u0000\u0000\u0000\u011c\u0121\u0003\b\u0004\u0000\u011d\u011e\u0005\u001f"+
		"\u0000\u0000\u011e\u0120\u0003\b\u0004\u0000\u011f\u011d\u0001\u0000\u0000"+
		"\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u001b\u0001\u0000\u0000"+
		"\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0125\u0005/\u0000\u0000"+
		"\u0125\u0126\u00055\u0000\u0000\u0126\u012d\u0005\u0004\u0000\u0000\u0127"+
		"\u0128\u0003\u0010\b\u0000\u0128\u0129\u0005\u0001\u0000\u0000\u0129\u012c"+
		"\u0001\u0000\u0000\u0000\u012a\u012c\u0003\u0014\n\u0000\u012b\u0127\u0001"+
		"\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0005\u0005\u0000\u0000\u0131\u0132\u0005"+
		"\u0001\u0000\u0000\u0132\u001d\u0001\u0000\u0000\u0000\u0133\u0134\u0007"+
		"\u0007\u0000\u0000\u0134\u001f\u0001\u0000\u0000\u0000\u0135\u0136\u0007"+
		"\b\u0000\u0000\u0136!\u0001\u0000\u0000\u0000\u0137\u0138\u0006\u0011"+
		"\uffff\uffff\u0000\u0138\u0139\u0003 \u0010\u0000\u0139\u013f\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\n\u0001\u0000\u0000\u013b\u013c\u0005\u0006\u0000"+
		"\u0000\u013c\u013e\u0005\u0007\u0000\u0000\u013d\u013a\u0001\u0000\u0000"+
		"\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140#\u0001\u0000\u0000\u0000"+
		"\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u0145\u0003\"\u0011\u0000\u0143"+
		"\u0145\u0005&\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0143"+
		"\u0001\u0000\u0000\u0000\u0145%\u0001\u0000\u0000\u0000\")1?CGSYntx\u00a1"+
		"\u00ab\u00ad\u00b7\u00bd\u00c5\u00ce\u00d4\u00da\u00dc\u00e5\u00e9\u00f0"+
		"\u00f8\u00fe\u0101\u0106\u0113\u0118\u0121\u012b\u012d\u013f\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}