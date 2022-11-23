package MiddleEnd.Compound;

import MiddleEnd.BasicClass.User;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IRType;

import java.util.ArrayList;

public class IRFunction extends User {
    public ArrayList<IRBasicBlock> basicBlockArrayList;
    public Value resAddress = null;
    public boolean isBuiltin = false;
    public boolean isUsed = false; //for optimize

    public IRFunction(String _functionName, IRType _resType){
        super(_functionName, _resType);
        basicBlockArrayList = new ArrayList<>();
    }

    @Override
    public void accept(IRVisitor visitor){
        //todo
    }
}
