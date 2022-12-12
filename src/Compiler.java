import FrontEnd.Semantic.AST_Node.ASTBuilder;
import FrontEnd.Semantic.AST_Node.RootNode;
import FrontEnd.Semantic.SymbolCollector;
import FrontEnd.Semantic.SemChecker;
import FrontEnd.Semantic.SetBuiltIn;
import FrontEnd.LLVM_IR.Compound.IRModule;
import FrontEnd.LLVM_IR.IRBuilder;
import Parser.MxLexer;
import Parser.MxParser;
import Utils.GlobalScope;
import Utils.MxErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Compiler {
    public static void main(String[] args) throws Exception{
        InputStream input = System.in;
        PrintStream output = System.out;
        //String destFile = "debug/test.ll";
        //FileOutputStream fos = new FileOutputStream(destFile);
        boolean file_output_flag = false;
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
            SymbolCollector symbolCollector = new SymbolCollector(globalScope);
            symbolCollector.visit(ASTRoot);
            SemChecker semChecker = new SemChecker(globalScope);
            semChecker.visit(ASTRoot);

            //codegen:
            IRModule module = new IRModule();
            IRBuilder IRbuilder = new IRBuilder(globalScope, module);
            IRbuilder.visit(ASTRoot);
            if(file_output_flag) {
                byte[] moduleText = module.toString().getBytes();
                //fos.write(moduleText);
            } else {
                output.println(module);//print ir
            }
            //module.printAllFunc();
        } catch (RuntimeException RuntimeError){
            System.err.println(RuntimeError.getMessage());
            throw new RuntimeException();
        }
    }
}