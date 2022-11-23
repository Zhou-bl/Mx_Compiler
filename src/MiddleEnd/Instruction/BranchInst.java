package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypePackage.IntegerType;
import MiddleEnd.TypePackage.VoidType;

public class BranchInst extends IRInstruction{
    public BranchInst(IRBasicBlock _paraBlock, Value _tag, IRBasicBlock _trueLabel, IRBasicBlock _falseLabel){
        super("_branch", new VoidType());
        if(!_tag.type.isEqual(new IntegerType(1))){
            throw new RuntimeException("Condition in branchInst is not i1.");
        }
        this.setBlock(_paraBlock);
        this.addOperand(_tag);
        this.addOperand(_trueLabel);
        this.addOperand(_falseLabel);
    }
    public BranchInst(IRBasicBlock _paraBlock, IRBasicBlock _targetLabel){
        super("_branch", new VoidType());
        this.setBlock(_paraBlock);
        this.addOperand(_targetLabel);
    }

    @Override
    public String generateIRCode(){
        if(this.operands.size() == 1){
            return "br " + this.operands.get(0).getTypeAndName();
        } else {
            return "br " + this.operands.get(0).getTypeAndName() + ", "
                    + this.operands.get(1).getTypeAndName() + ", "
                    + this.operands.get(2).getTypeAndName();
        }
    }
    @Override
    public void accept(IRVisitor visitor){
        //todo;
    }
}
