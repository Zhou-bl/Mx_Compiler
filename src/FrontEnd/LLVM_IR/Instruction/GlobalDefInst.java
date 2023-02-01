package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.IRVisitor;
import FrontEnd.LLVM_IR.TypePackage.IRType;
import FrontEnd.LLVM_IR.TypePackage.PointerType;

public class GlobalDefInst extends IRInstruction{
    public GlobalDefInst(IRType _type, String _name){
        super(_name + "_global", new PointerType(_type));
    }

    @Override
    public String getName(){
        return "@" + this.name;
    }

    @Override
    public String toString(){
        return this.getName() + " = dso_local global " + this.type.deReference().toString()
                + " zeroinitializer, align " + this.type.deReference().typeSize();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
