package MiddleEnd.Compound;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRVisitor;
import MiddleEnd.Instruction.IRInstruction;
import MiddleEnd.TypePackage.LabelType;

import java.util.LinkedList;

public class IRBasicBlock extends Value {
    public LinkedList<IRInstruction> instructionLinkedList;
    public IRInstruction terminator = null;
    public IRFunction parentFunc;

    public IRBasicBlock(String _name, IRFunction _parent){
        super(_name + "_bb", new LabelType());
        this.parentFunc = _parent;
        this.instructionLinkedList = new LinkedList<>();
    }

    public void addInstruction(IRInstruction _ins){
        this.instructionLinkedList.add(_ins);
    }

    public void accept(IRVisitor visitor){
        //todo
    }
}
