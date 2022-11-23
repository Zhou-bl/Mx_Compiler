package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.User;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.TypePackage.IRType;

public abstract class IRInstruction extends User {
    public IRBasicBlock parentBlock;

    public IRInstruction(String _name, IRType _type){
        super(_name, _type);
    }

    public void setBlock(IRBasicBlock _block){
        this.parentBlock = _block;
        if(_block != null) _block.addInstruction(this);
    }
}
