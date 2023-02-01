package FrontEnd.LLVM_IR;

import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.Compound.IRFunction;
import FrontEnd.LLVM_IR.Compound.IRModule;
import FrontEnd.LLVM_IR.Instruction.*;
import FrontEnd.LLVM_IR.Operand.BoolConstant;
import FrontEnd.LLVM_IR.Operand.IntConstant;
import FrontEnd.LLVM_IR.Operand.NullConstant;
import FrontEnd.LLVM_IR.Operand.StringConstant;

public interface IRVisitor {
    void visit(IRModule node);
    void visit(IRFunction node);
    void visit(IRBasicBlock node);
    void visit(AllocInst node);
    void visit(BinaryInst node);
    void visit(BitcastInst node);
    void visit(BranchInst node);
    void visit(CallInst node);
    void visit(GepInst node);
    void visit(GlobalDefInst node);
    void visit(IcmpInst node);
    void visit(LoadInst node);
    void visit(RetInst node);
    void visit(StoreInst node);
    void visit(TruncInst node);
    void visit(ZextInst node);
    void visit(BoolConstant node);
    void visit(IntConstant node);
    void visit(NullConstant node);
    void visit(StringConstant node);
}
