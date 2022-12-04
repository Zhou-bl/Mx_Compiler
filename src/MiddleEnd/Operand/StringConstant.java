package MiddleEnd.Operand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.ArrayType;
import MiddleEnd.TypePackage.IntegerType;
import MiddleEnd.TypePackage.PointerType;

public class StringConstant extends IRConstant {
    public String value;

    public StringConstant(String _value){
        super("_str_constant", new PointerType(new ArrayType(new IntegerType(8), _value.length())));
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
        //todo
    }
}
