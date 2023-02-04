import BackEnd.ASMBuilder;
import BackEnd.RegAlloc.GraphColor;
import BackEnd.RegAlloc.GraphColor1;
import BackEnd.RegAlloc.StackAlloc;
import FrontEnd.Semantic.AST_Node.ASTBuilder;
import FrontEnd.Semantic.AST_Node.RootNode;
import FrontEnd.Semantic.SymbolCollector;
import FrontEnd.Semantic.SemChecker;
import FrontEnd.Semantic.SetBuiltIn;
import FrontEnd.LLVM_IR.Compound.IRModule;
import FrontEnd.LLVM_IR.IRBuilder;
import Parser.MxLexer;
import Parser.MxParser;
import Utils.BuiltinPrinter;
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
        boolean file_output_flag = true;
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

            //output.println(module);


            if(file_output_flag) {
                output = new PrintStream("output.ll");
                output.println(module);
            } else {
                output.println(module);//print ir
            }




            //module.printAllFunc();


            ASMBuilder ASMbuilder = new ASMBuilder();
            ASMbuilder.visit(module);
            GraphColor1 regAlloc = new GraphColor1(ASMbuilder.targetModule);


            if(file_output_flag) {
                //文件输出:
                output = new PrintStream("output.s");
                output.println(regAlloc.ripe.printCode());
                BuiltinPrinter builtinPrinter = new BuiltinPrinter();
                output = new PrintStream("builtin.s");
                output.println(builtinPrinter.builtinCode);
            } else {
                System.out.println(ASMbuilder.targetModule.printCode());
            }



        } catch (RuntimeException RuntimeError){
            System.err.println(RuntimeError.getMessage());
            throw new RuntimeException();
        }
    }
}