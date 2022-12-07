package FrontEnd.Semantic.AST_Node;

import Parser.MxBaseVisitor;
import Parser.MxParser;
import Utils.Position;
import Utils.SyntaxError;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProg(MxParser.ProgContext ctx){
        ArrayList<ASTNode> _ele = new ArrayList<>();
        for(MxParser.DeclTypeContext _sub : ctx.declType()){
            if(_sub.classDecl() != null){
                _ele.add(visit(_sub.classDecl()));
            }
            if(_sub.functionDecl() != null){
                _ele.add(visit(_sub.functionDecl()));
            }
            if(_sub.variableDecl() != null){
                _ele.add(visit(_sub.variableDecl()));
            }
        }
        return new RootNode(_ele, new Position(ctx));
    }

    @Override
    public ASTNode visitClassDecl(MxParser.ClassDeclContext ctx){
        /*
        classDecl : CLASS className=IDENTIFIER '{' ( (variableDecl ';') | functionDecl )* '}' ';' ;

        variableDecl : variableType baseVariableDecl (',' baseVariableDecl)* ;
         */
        Position _pos = new Position(ctx);
        String classID = ctx.className.getText();
        ArrayList<VarDefStmtNode> memberVar = new ArrayList<>();
        ArrayList<FuncDefNode> memberFunc = new ArrayList<>();
        boolean flagVar = false, flagFunc = false;
        if(ctx.variableDecl() != null){
            flagVar = true;
            for(MxParser.VariableDeclContext _var : ctx.variableDecl()){
                memberVar.add((VarDefStmtNode) visit(_var));
            }
        }
        if(ctx.functionDecl() != null) {
            flagFunc = true;
            for(MxParser.FunctionDeclContext _func : ctx.functionDecl()){
                memberFunc.add((FuncDefNode) visit(_func));
            }
        }
        return new ClassDefNode(classID, flagFunc ? memberFunc : null, flagVar ? memberVar : null, _pos);
    }

    @Override
    public ASTNode visitFunctionDecl(MxParser.FunctionDeclContext ctx){
        /*
        functionDecl : functionType? IDENTIFIER '(' parameterList? ')' block;
        parameterList : variableType IDENTIFIER (',' variableType IDENTIFIER)* ;
         */
        Position _pos = new Position(ctx);
        TypeNode resType;
        if(ctx.functionType() == null) resType = null;
        else resType = (TypeNode) visit(ctx.functionType());
        String funcName = ctx.IDENTIFIER().getText();
        BlockStmtNode funcBody = (BlockStmtNode) visit(ctx.block());
        ArrayList<VarDefNode> funcParameterList;
        if(ctx.parameterList() == null) funcParameterList = null;
        else {
            funcParameterList = new ArrayList<>();
            List<MxParser.VariableTypeContext> varTypeAry = ctx.parameterList().variableType();
            List<TerminalNode> varIDAry = ctx.parameterList().IDENTIFIER();
            for(int i = 0; i < varTypeAry.size(); ++i){
                Position varPos = new Position(varTypeAry.get(i));
                funcParameterList.add(new VarDefNode((TypeNode) visit(varTypeAry.get(i)), varIDAry.get(i).getText(), null, varPos));
            }
        }
        return new FuncDefNode(resType, funcName, funcParameterList, funcBody, _pos);
    }

    @Override
    public ASTNode visitVariableDecl(MxParser.VariableDeclContext ctx){
        /*
        variableDecl : variableType baseVariableDecl (',' baseVariableDecl)* ;
        baseVariableDecl : IDENTIFIER ('=' expression)? ;
         */
        Position _pos = new Position(ctx);
        TypeNode varType = (TypeNode) visit(ctx.variableType());
        ArrayList<VarDefNode> varDefAry = new ArrayList<>();
        for(MxParser.BaseVariableDeclContext _tmp : ctx.baseVariableDecl()){
            Position varPos = new Position(_tmp);
            String varID = _tmp.IDENTIFIER().getText();
            ExprNode varInitValue;
            if(_tmp.expression() == null) varInitValue = null;
            else varInitValue = (ExprNode) visit(_tmp.expression());
            varDefAry.add(new VarDefNode(varType, varID, varInitValue, varPos));
        }
        return new VarDefStmtNode(varType, varDefAry, _pos);
    }

    @Override
    public ASTNode visitCodeBlock(MxParser.CodeBlockContext ctx){
        /*
        : block  #codeBlock
         */
        return visit(ctx.block());
    }

    @Override
    public ASTNode visitBlock(MxParser.BlockContext ctx){
        /*
        block : '{' statement* '}';
         */
        Position _pos = new Position(ctx);
        ArrayList<StmtNode> stmtArt;
        boolean isBlank = true;
        if(ctx.statement() == null) stmtArt = null;
        else{
            for(MxParser.StatementContext _tmp : ctx.statement()){
                if(!(_tmp instanceof MxParser.BlankStatementContext)){
                    isBlank = false;
                    break;
                }
            }
            if(!isBlank){//
                stmtArt = new ArrayList<>();
                for(MxParser.StatementContext _tmp : ctx.statement()){
                    if(!(_tmp instanceof MxParser.BlankStatementContext)){
                        stmtArt.add((StmtNode) visit(_tmp));
                    }
                }
            }
            else stmtArt = null;
        }
        return new BlockStmtNode(stmtArt, _pos);
    }

    @Override
    public ASTNode visitIfStatement(MxParser.IfStatementContext ctx){
        return visit(ctx.ifStmt());
    }

    @Override
    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx){
        /*
        ifStmt : IF '(' condition=expression ')' thenStatement=statement (ELSE elseStatement=statement)?;
         */
        Position _pos = new Position(ctx);
        ExprNode ifCondition = (ExprNode) visit(ctx.condition);
        StmtNode tStatement = (StmtNode) visit(ctx.thenStatement);
        StmtNode eStatement;
        if(ctx.elseStatement == null) eStatement = null;
        else eStatement = (StmtNode) visit(ctx.elseStatement);
        return new IfStmtNode(ifCondition, tStatement, eStatement, _pos);
    }

    @Override
    public ASTNode visitWhileStatement(MxParser.WhileStatementContext ctx){
        /*
        WHILE '(' condition=expression ')' loopBody=statement
         */
        Position _pos = new Position(ctx);
        ExprNode whileCondition = (ExprNode) visit(ctx.condition);
        StmtNode loopBody = (StmtNode) visit(ctx.loopBody);
        return new WhileStmtNode(whileCondition, loopBody, _pos);
    }

    @Override
    public ASTNode visitForStatement(MxParser.ForStatementContext ctx){
        /*
        FOR '(' (initDecl=variableDecl | initExpr=expression)? ';' condition=expression? ';' incrExpr=expression? ')' loopBody=statement
         */
        Position _pos = new Position(ctx);

        StmtNode init = null;
        if(ctx.initDecl != null) init = (StmtNode) visit(ctx.initDecl);
        else if(ctx.initExpr != null) init = new ExprStmtNode((ExprNode) visit(ctx.initExpr),new Position(ctx.initExpr));

        ExprNode forCondition;
        if(ctx.condition == null) forCondition = null;
        else forCondition = (ExprNode) visit(ctx.condition);

        ExprNode incrExpr;
        if(ctx.incrExpr == null) incrExpr = null;
        else incrExpr = (ExprNode) visit(ctx.incrExpr);

        StmtNode loopBody = (StmtNode) visit(ctx.loopBody);

        return new ForStmtNode(init, forCondition, incrExpr, loopBody,_pos);
    }

    @Override
    public ASTNode visitJumpStatement(MxParser.JumpStatementContext ctx){
        return visit(ctx.jumpStmt());
    }

    /*
    jumpStmt
    : RETURN expression? ';'    #returnStatement
    | BREAK ';'                 #breakStatement
    | CONTINUE ';'              #continueStatement
    ;
     */
    @Override
    public ASTNode visitReturnStatement(MxParser.ReturnStatementContext ctx){
        Position _pos = new Position(ctx);
        ExprNode resValue;
        if(ctx.expression() == null) resValue = null;
        else resValue = (ExprNode) visit(ctx.expression());
        return new ReturnStmtNode(resValue, _pos);
    }

    @Override
    public ASTNode visitBreakStatement(MxParser.BreakStatementContext ctx){
        Position _pos = new Position(ctx);
        return new BreakStmtNode(_pos);
    }

    @Override
    public ASTNode visitContinueStatement(MxParser.ContinueStatementContext ctx){
        Position _pos = new Position(ctx);
        return new ContinueStmtNode(_pos);
    }

    @Override
    public ASTNode visitExprStatement(MxParser.ExprStatementContext ctx){
        /*
        expression ';'   #exprStatement
         */
        Position _pos = new Position(ctx);
        ExprNode expr = (ExprNode) visit(ctx.expression());
        return new ExprStmtNode(expr, _pos);
    }

    @Override
    public ASTNode visitVariableDeclStatement(MxParser.VariableDeclStatementContext ctx){
        return visit(ctx.variableDecl());
    }

    //There is no need for BlankStatement.

    @Override
    public ASTNode visitIdentifier(MxParser.IdentifierContext ctx){
        Position _pos = new Position(ctx);
        String _id = ctx.IDENTIFIER().getText();
        return new IdentifierExprNode(_id, _pos);
    }

    @Override
    public ASTNode visitConstant(MxParser.ConstantContext ctx){
        return visit(ctx.constantValue());
    }

    @Override
    public ASTNode visitConstantValue(MxParser.ConstantValueContext ctx){
        Position _pos = new Position(ctx);
        if(ctx.BOOL_CONSTANT() != null){
            boolean value = ctx.BOOL_CONSTANT().getText().equals("true");
            return new BoolConstantExprNode(value, _pos);
        }
        if(ctx.INTERGER_CONSTANT() != null){
            int value = Integer.parseInt(ctx.INTERGER_CONSTANT().getText());
            return new IntConstantExprNode(value, _pos);
        }
        if(ctx.STRING_CONSTANT() != null){
            String value = ctx.STRING_CONSTANT().getText();
            return new StringConstantExprNode(value, _pos);
        }
        if(ctx.NULL_CONSTANT() != null){
            return new NullExprNode(_pos);
        }
        throw new RuntimeException("[Error] Unexpected constantValue!");
    }

    @Override
    public ASTNode visitObjPortion(MxParser.ObjPortionContext ctx){
        // expression DOT IDENTIFIER
        Position _pos = new Position(ctx);
        ExprNode _expr = (ExprNode) visit(ctx.expression());
        String _mem = ctx.IDENTIFIER().getText();
        return new ObjectPortionExprNode(_expr, _mem, _pos);
    }

    @Override
    public ASTNode visitAllocExpr(MxParser.AllocExprContext ctx){
        return visit(ctx.allocFormat());
    }

    @Override
    public ASTNode visitAllocErrorType(MxParser.AllocErrorTypeContext ctx){
        Position _pos = new Position(ctx);
        throw new SyntaxError("Alloc Format error occur.", _pos);
    }

    @Override
    public ASTNode visitAllocArrayType(MxParser.AllocArrayTypeContext ctx){
        Position _pos = new Position(ctx);
        ArrayList<ExprNode> _dimList = new ArrayList<>();
        for(MxParser.ExpressionContext _tmp : ctx.expression()){
            _dimList.add((ExprNode) visit(_tmp));
        }
        int _dimSize = (ctx.getChildCount() - 1 - _dimList.size()) / 2;
        TypeNode _allocType = (TypeNode) visit(ctx.baseType());
        return new AllocExprNode(_allocType, _dimSize, _dimList, _pos);
    }

    @Override
    public ASTNode visitAllocBaseType(MxParser.AllocBaseTypeContext ctx){
        Position _pos = new Position(ctx);
        TypeNode _allocType = (TypeNode) visit(ctx.baseType());
        return new AllocExprNode(_allocType, 0, null, _pos);
    }

    @Override
    public ASTNode visitFunctionCall(MxParser.FunctionCallContext ctx){
        Position _pos = new Position(ctx);
        ExprNode _func = (ExprNode) visit(ctx.expression());
        ArrayList<ExprNode> _paraList = new ArrayList<>();
        if(ctx.parameterListForCall() == null) _paraList = null;
        else{
            for(MxParser.ExpressionContext _tmp : ctx.parameterListForCall().expression()){
                _paraList.add((ExprNode) visit(_tmp));
            }
        }
        return new FuncCallExprNode(_func, _paraList, _pos);
    }

    @Override
    public ASTNode visitCompoundExpr(MxParser.CompoundExprContext ctx){
        return visit(ctx.expression());
    }

    @Override
    public ASTNode visitArrayAccess(MxParser.ArrayAccessContext ctx){
        Position _pos = new Position(ctx);
        ExprNode _array = (ExprNode) visit(ctx.array);
        ExprNode _index = (ExprNode) visit(ctx.index);
        return new ArrayAccessNode(_array, _index, _pos);
    }

    @Override
    public ASTNode visitAftermonocularOp(MxParser.AftermonocularOpContext ctx){
        Position _pos = new Position(ctx);
        MonocularOpExprNode.MonocularOpType _op = ctx.op.getText().equals("++") ?
                MonocularOpExprNode.MonocularOpType.SINC_AFT : MonocularOpExprNode.MonocularOpType.SDER_AFT;
        ExprNode _operand = (ExprNode) visit(ctx.operand);
        return new MonocularOpExprNode(_operand, _op, _pos);
    }

    @Override
    public ASTNode visitMonocularOp(MxParser.MonocularOpContext ctx){
        Position _pos = new Position(ctx);
        String _opString = ctx.op.getText();
        ExprNode _operand = (ExprNode) visit(ctx.operand);
        MonocularOpExprNode.MonocularOpType _op = switch (_opString){
            case "++" -> MonocularOpExprNode.MonocularOpType.SINC;
            case "--" -> MonocularOpExprNode.MonocularOpType.SDER;
            case "!" -> MonocularOpExprNode.MonocularOpType.LOGIC_NOT;
            case "~" -> MonocularOpExprNode.MonocularOpType.BIT_NOT;
            case "+" -> MonocularOpExprNode.MonocularOpType.POS;
            case "-" -> MonocularOpExprNode.MonocularOpType.NEG;
            default -> throw new SyntaxError("Unexpected monocular operator symbol.", new Position(ctx.op));
        };
        return new MonocularOpExprNode(_operand, _op, _pos);
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx){
        Position _pos = new Position(ctx);
        String _opString = ctx.op.getText();
        ExprNode _operand1 = (ExprNode) visit(ctx.operand1);
        ExprNode _operand2 = (ExprNode) visit(ctx.operand2);
        //+, -, *, /, %, <<, >>, >, <, >=, <=, ==, !=, &&, ||, ^, &, |, =;
        //ADD, SUB, MUL, DIV, MOD, SHL, SHR, GT, LT, GE, LE, EQ, NE, AND, OR, XOR, LAND, LOR, ASSIGN
        BinaryExprNode.BinaryOpType _op = switch (_opString) {
            case "+" -> BinaryExprNode.BinaryOpType.ADD;
            case "-" -> BinaryExprNode.BinaryOpType.SUB;
            case "*" -> BinaryExprNode.BinaryOpType.MUL;
            case "/" -> BinaryExprNode.BinaryOpType.DIV;
            case "%" -> BinaryExprNode.BinaryOpType.MOD;
            case "<<" -> BinaryExprNode.BinaryOpType.SHL;
            case ">>" -> BinaryExprNode.BinaryOpType.SHR;
            case ">" -> BinaryExprNode.BinaryOpType.GT;
            case "<" -> BinaryExprNode.BinaryOpType.LT;
            case ">=" -> BinaryExprNode.BinaryOpType.GE;
            case "<=" -> BinaryExprNode.BinaryOpType.LE;
            case "==" -> BinaryExprNode.BinaryOpType.EQ;
            case "!=" -> BinaryExprNode.BinaryOpType.NE;
            case "&&" -> BinaryExprNode.BinaryOpType.LAND;
            case "||" -> BinaryExprNode.BinaryOpType.LOR;
            case "^" -> BinaryExprNode.BinaryOpType.XOR;
            case "&" -> BinaryExprNode.BinaryOpType.AND;
            case "|" -> BinaryExprNode.BinaryOpType.OR;
            case "=" -> BinaryExprNode.BinaryOpType.ASSIGN;
            default -> throw new SyntaxError("Unexpected binary operator symbol.", new Position(ctx.op));
        };
        return new BinaryExprNode(_op, _operand1, _operand2, _pos);
    }

    @Override
    public ASTNode visitObjPointer(MxParser.ObjPointerContext ctx){
        Position _pos = new Position(ctx);
        return new ThisExprNode(_pos);
    }

    @Override
    public ASTNode visitLambdaExpr(MxParser.LambdaExprContext ctx){
        //LAMBDAS1 lambdaParameterList? LAMBDAS2 block '(' parameterListForCall? ')'
        Position _pos = new Position(ctx);
        ArrayList<VarDefNode> _parameter = null;
        boolean _isGlobal = ctx.children.get(1).getText().equals("&");
        if(ctx.lambdaParameterList() != null && ctx.lambdaParameterList().parameterList() != null){
            _parameter = new ArrayList<>();
            List<MxParser.VariableTypeContext> _parameterTypeList = ctx.lambdaParameterList().parameterList().variableType();
            List<TerminalNode> _parameterID = ctx.lambdaParameterList().parameterList().IDENTIFIER();
            for(int i = 0; i < _parameterTypeList.size(); ++i){
                _parameter.add(new VarDefNode((TypeNode) visit(_parameterTypeList.get(i)), _parameterID.get(i).getText(), null, new Position(_parameterTypeList.get(i))));
            }
        }
        ArrayList<ExprNode> _list = null;
        if(ctx.parameterListForCall() != null){
            _list = new ArrayList<>();
            for(MxParser.ExpressionContext _tmp : ctx.parameterListForCall().expression()){
                _list.add((ExprNode) visit(_tmp));
            }
        }
        return new LambdaExprNode(_parameter, _list, (BlockStmtNode) visit(ctx.block()),_isGlobal , _pos);
    }
    @Override
    public ASTNode visitBaseType(MxParser.BaseTypeContext ctx){
        Position _pos = new Position(ctx);
        return new ClassTypeNode(ctx.getText(), _pos);
    }

    @Override
    public ASTNode visitBaseVariableType(MxParser.BaseVariableTypeContext ctx){
        Position _pos = new Position(ctx);
        return visit(ctx.baseType());
    }

    @Override
    public ASTNode visitArrayType(MxParser.ArrayTypeContext ctx){
        Position _pos = new Position(ctx);
        return new ArrayTypeNode((TypeNode) visit(ctx.variableType()), _pos);
    }

    @Override
    public ASTNode visitFunctionType(MxParser.FunctionTypeContext ctx){
        Position _pos = new Position(ctx);
        if(ctx.VOID() == null) return visit(ctx.variableType());
        else return new VoidTypeNode(_pos);
    }
}
