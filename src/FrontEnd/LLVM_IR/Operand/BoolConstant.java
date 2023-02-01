package FrontEnd.LLVM_IR.Operand;

import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.BoolType;

public class BoolConstant extends IRConstant{
    public boolean value;

    public BoolConstant(boolean _value){
        super("_bool_const", new BoolType());
        this.value = _value;
    }

    @Override
    public String getName(){
        return value ? String.valueOf(1) : String.valueOf(0);
    }

    @Override
    public String toString(){
        throw new RuntimeException("ToString in BoolConstant.");
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
