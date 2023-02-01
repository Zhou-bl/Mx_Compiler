package FrontEnd.LLVM_IR.Instruction;

import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.IRVisitor;

public class BinaryInst extends IRInstruction{
    public enum IRBinaryOpType{add, sub, mul, sdiv, srem, shl, ashr, and, or, xor, logic_and, logic_or, eq, ne, sgt, sge, slt, sle, assign}
    //+,-,*,/,%,<<,>>,&,|,^,&&,||,==,!=,>,>=,<,<=,=
    public IRBinaryOpType opType;

    public BinaryInst(IRBasicBlock _paraBlock, IRBinaryOpType _op, Value _lop, Value _rop){
        super(_op.name(), _lop.type);
        if(!_lop.type.isEqual(_rop.type)){
            throw new RuntimeException("Unequal type in BinaryInst.");
        }
        this.setBlock(_paraBlock);
        this.opType = _op;
        this.addOperand(_lop);
        this.addOperand(_rop);
    }

    @Override
    public String toString(){
        return this.getName() + " = " + opType.name() + " " + this.type.toString() + " " + this.getOperand(0).getName() + ", " + this.getOperand(1).getName();
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
