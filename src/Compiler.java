import AST.ASTBuilder;
import AST.RootNode;
import FrontEnd.PreWork;
import FrontEnd.SemChecker;
import FrontEnd.SetBuiltIn;
import Parser.MxLexer;
import Parser.MxParser;
import Utils.GlobalScope;
import Utils.MxErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;

public class Compiler {
    public static void main(String[] args) throws Exception{
        InputStream input = System.in;
        try{
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.prog();

            //build AST:
            ASTBuilder builder = new ASTBuilder();
            RootNode ASTRoot = (RootNode) builder.visit(parseTreeRoot);

            //set builtIn function and class:
            GlobalScope globalScope = new GlobalScope(null);
            SetBuiltIn init = new SetBuiltIn();
            globalScope = init.init(globalScope);

            //semantic check:
            PreWork symbolCollector = new PreWork(globalScope);
            symbolCollector.visit(ASTRoot);
            SemChecker semChecker = new SemChecker(globalScope);
            semChecker.visit(ASTRoot);

        } catch (RuntimeException RuntimeError){
            System.err.println(RuntimeError.getMessage());
            throw new RuntimeException();
        }
    }
}