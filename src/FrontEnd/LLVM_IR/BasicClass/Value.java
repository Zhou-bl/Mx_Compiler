package FrontEnd.LLVM_IR.BasicClass;

import BackEnd.Operand.BasicOperand;
import FrontEnd.LLVM_IR.TypePackage.IRType;

import java.util.ArrayList;
import java.util.HashMap;

public class Value {
    //参考llvm官方定义, Value表示一个具有类型的值
    //llvm::Value 有一个 llvm::Type* 成员和一个 User list 跟踪哪些Value使用了自己
    public String name;
    public IRType type;
    public BasicOperand ASMOperand;
    public ArrayList<User> userList;
    public static HashMap<String, Integer> renamingTable = new HashMap<>();

    private String renaming(String _name){
        if(_name.equals("null")) return "null";
        String _resStr;
        if(_name.equals("_f_main")){
            _resStr = "main";
            return _resStr;
        }
        Integer cnt = renamingTable.get(_name);
        if (cnt == null){
            cnt = 0;
        } else cnt++;
        renamingTable.put(_name, cnt);
        _resStr = _name + cnt;
        return _resStr;
    }

    public Value(String _name, IRType _type){
        this.name = renaming(_name);
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

    public String getTypeAndName(){
        return this.type.toString() + " " + this.getName();
    }

}
