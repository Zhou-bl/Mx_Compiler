package MiddleEnd.Operand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.BoolType;

public class BoolConstant extends IRConstant{
    public boolean value;

    public BoolConstant(boolean _value){
        super("bool_const", new BoolType());
        this.value = _value;
    }

    @Override
    public String getName(){
        return value ? String.valueOf(1) : String.valueOf(0);
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
