package FrontEnd.LLVM_IR.Operand;

import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IntegerType;

public class IntConstant extends IRConstant{
    public int value;

    public IntConstant(int _value){
        super("_int_constant", new IntegerType(32));
        this.value = _value;
    }

    @Override
    public String getName(){
        return String.valueOf(this.value);
    }
    @Override
    public String toString(){
        throw new RuntimeException("ToString in IntConstant.");
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
