package MiddleEnd.BasicClass;

import MiddleEnd.TypePackage.IRType;

import java.util.ArrayList;

public class Value {
    //参考llvm官方定义, Value表示一个具有类型的值
    //llvm::Value 有一个 llvm::Type* 成员和一个 User list 跟踪哪些Value使用了自己
    public String name;
    public IRType type;
    public ArrayList<User> userList;

    public Value(String _name, IRType _type){
        this.name = _name;
        this.type = _type;
        this.userList = new ArrayList<>();
    }

    public void addUser(User _user){
        this.userList.add(_user);
    }

    public String getName(){
        //返回%xxx
        return "%" + this.name;
    }
}
