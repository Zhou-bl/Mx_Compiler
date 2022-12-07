package FrontEnd.LLVM_IR.Operand;

import FrontEnd.LLVM_IR.BasicClass.User;
import FrontEnd.LLVM_IR.TypePackage.IRType;

public abstract class IRConstant extends User {
    public IRConstant(String _name, IRType _type){
        super(_name, _type);
    }
}
