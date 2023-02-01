package FrontEnd.LLVM_IR.Compound;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.Instruction.BranchInst;
import FrontEnd.LLVM_IR.Instruction.IRInstruction;
import FrontEnd.LLVM_IR.Instruction.RetInst;
import FrontEnd.LLVM_IR.TypePackage.LabelType;

import java.util.LinkedList;

public class IRBasicBlock extends Value {
    public LinkedList<IRInstruction> instructionLinkedList;
    public IRInstruction terminator = null;
    public IRFunction parentFunc;

    private void setTerminatorInst(IRInstruction _ins){
        if(terminator == null) terminator = _ins;
    }

    public IRBasicBlock(String _name, IRFunction _parent){
        super(_name + "_bb", new LabelType());
        this.parentFunc = _parent;
        this.instructionLinkedList = new LinkedList<>();
        this.parentFunc.addBasicBlock(this);
    }

    public void addInstruction(IRInstruction _ins){
        if(_ins instanceof BranchInst || _ins instanceof RetInst){
            setTerminatorInst(_ins);
        }
        else this.instructionLinkedList.add(_ins);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(this.name).append(":");
        if(!userList.isEmpty()){
            res.append("\t\t\t\t\t ;preds = ");
            userList.forEach(ele -> res.append(((BranchInst) ele).parentBlock.getName()).append(", "));
            res.delete(res.length() - 2, res.length());
        }
        res.append("\n");
        instructionLinkedList.forEach(ele-> res.append("\t").append(ele.toString()).append("\n"));
        res.append("\t").append(terminator.toString()).append("\n");
        return res.toString();
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
