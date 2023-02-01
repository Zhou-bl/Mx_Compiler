package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;
import FrontEnd.LLVM_IR.TypePackage.PointerType;

public class AllocInst extends IRInstruction{
    public AllocInst(IRBasicBlock _paraBlock, IRType _type, String _name){
        super(_name + ".alloc", new PointerType(_type));
        this.setBlock(_paraBlock);
    }

    @Override
    public String toString(){
        return this.getName() + " = alloca " + this.type.deReference().toString() + ", align " + this.type.typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
