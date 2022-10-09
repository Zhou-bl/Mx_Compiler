package AST;

import Parser.MxBaseVisitor;
import Parser.MxParser;
import Utils.Position;
import Utils.SyntaxError;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

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

    }

    @Override
    public ASTNode visitBaseType(MxParser.BaseTypeContext ctx){
        //todo
    }
}
