package MiddleEnd.Operand;

import MiddleEnd.BasicClass.User;
import MiddleEnd.TypePackage.IRType;

public abstract class IRConstant extends User {
    public IRConstant(String _name, IRType _type){
        super(_name, _type);
    }
}
