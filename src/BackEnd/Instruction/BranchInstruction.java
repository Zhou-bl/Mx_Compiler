package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;

public class BranchInstruction extends ASM_Instruction{
    public BranchInstruction(ASMBlock _block, String _op){
        super(_block, _op);
    }

    @Override
    public void renameUse(String origin, VirtualRegister newVirtualReg){
        if(rs1.getName().equals(origin)){
            useArrayList.remove(origin);
            useArrayList.add(newVirtualReg.getName());
            rs1 = newVirtualReg;
        }
        if(rs2.getName().equals(origin)){
            useArrayList.remove(origin);
            useArrayList.add(newVirtualReg.getName());
            rs2 = newVirtualReg;
        }
    }

    @Override
    public void renameDef(String origin, VirtualRegister newVirtualReg){}

    @Override
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 3){
            throw new RuntimeException("[Bug] In BranchInst not 3 length.");
        }
        rd = operands[0];
        rs1 = operands[1];
        rs2 = operands[2];
        useArrayList.add(rs1.getName());
        useArrayList.add(rs2.getName());
        return this;
    }

    @Override
    public String printCode(){
        return op + "\t" + rs1.getName() + ", " + rs2.getName() + ", " + rd.getName();
    }
}
