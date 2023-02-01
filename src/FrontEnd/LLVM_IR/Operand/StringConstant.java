package FrontEnd.LLVM_IR.Operand;

import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.ArrayType;
import FrontEnd.LLVM_IR.TypePackage.IntegerType;
import FrontEnd.LLVM_IR.TypePackage.PointerType;

public class StringConstant extends IRConstant {
    public String value;

    public StringConstant(String _value){
        super("_str_constant", new PointerType(new ArrayType(new IntegerType(8), _value.length())));
        //System.out.println("length is : " + _value.length());
        this.value = _value;
    }

    public String RePlace(String str){
        return str.replace("\\", "\\5C")
                .replace("\n", "\\0A")
                .replace("\"", "\\22")
                .replace("\t", "\\09")
                .replace("\0","\\00");
    }
    @Override
    public String getName(){
        return "@" + this.name;
    }

    @Override
    public String toString(){
        return this.getName() + " = private unnamed_addr constant " + ((PointerType)this.type).baseType.toString() + " c\"" + RePlace(this.value) + "\", align 1";
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
