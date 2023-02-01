package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.VoidType;

public class StoreInst extends IRInstruction {
    public StoreInst(IRBasicBlock _paraBlock, Value _value, Value _address){
        super("_store", new VoidType());
        this.setBlock(_paraBlock);
        this.addOperand(_value);
        this.addOperand(_address);
    }

    @Override
    public String toString(){
        return "store " + this.operands.get(0).getTypeAndName() + ", "
                + this.operands.get(1).getTypeAndName() + ", align "
                + this.operands.get(0).type.typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
