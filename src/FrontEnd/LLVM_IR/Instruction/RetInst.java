package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.VoidType;

public class RetInst extends IRInstruction {
    public RetInst(IRBasicBlock _paraBlock, Value _resValue){
        super("_ret", _resValue.type);
        this.setBlock(_paraBlock);
        this.addOperand(_resValue);
    }

    @Override
    public String toString(){
        String res;
        if(this.type instanceof VoidType){
            res = "void";
        } else {
            res = this.operands.get(0).getTypeAndName();
        }
        return "ret " + res;
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
