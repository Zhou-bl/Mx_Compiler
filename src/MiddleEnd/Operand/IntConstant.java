package MiddleEnd.Operand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IntegerType;

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
    public String generateIRCode(){
        throw new RuntimeException("ToString in IntConstant.");
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
