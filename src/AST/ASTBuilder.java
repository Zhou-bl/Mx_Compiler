package AST;

import Parser.MxBaseVisitor;
import Parser.MxParser;
import Utils.Position;
import Utils.SyntaxError;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
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
            //这里重新改写g4文件中的parameterList部分，使得下面的遍历更方便;
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
            if(!isBlank){//有非空语句
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

        VarDefStmtNode initDecl;
        if(ctx.initDecl == null) initDecl = null;
        else initDecl = (VarDefStmtNode) visit(ctx.initDecl);

        ExprNode initExpr;
        if(ctx.initExpr == null) initExpr = null;
        else initExpr = (ExprNode) visit(ctx.initExpr);

        ExprNode forCondition;
        if(ctx.condition == null) forCondition = null;
        else forCondition = (ExprNode) visit(ctx.condition);

        ExprNode incrExpr;
        if(ctx.incrExpr == null) incrExpr = null;
        else incrExpr = (ExprNode) visit(ctx.incrExpr);

        StmtNode loopBody = (StmtNode) visit(ctx.loopBody);

        return new ForStmtNode(initDecl, initExpr, forCondition, incrExpr, loopBody,_pos);
    }

    @Override
    public ASTNode visitBaseType(MxParser.BaseTypeContext ctx){
        //todo
    }
}
