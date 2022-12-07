package FrontEnd.LLVM_IR.BasicClass;

import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;

import java.util.ArrayList;

public abstract class User extends Value{
    //忽略llvm官方定义中的 use 类, 直接指向value即可。
    public ArrayList<Value> operands; //use-def relations

    public User(String _name, IRType _type){
        super(_name, _type);
        this.operands = new ArrayList<>();
    }

    public void addOperand(Value _value){
        this.operands.add(_value);
        _value.addUser(this);
    }

    public Value getOperand(int _index){
        return this.operands.get(_index);
    }

    public abstract void accept(IRVisitor visitor);
}
