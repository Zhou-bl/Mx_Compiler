package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;

public class LiInstruction extends ASM_Instruction {
    //load imm
    public LiInstruction(ASMBlock _block){
        super(_block, "li");
    }

    @Override
    public void renameUse(String origin, VirtualRegister newVirtualReg){}

    @Override
    public void renameDef(String origin, VirtualRegister newVirtualReg){
        if(rd.getName().equals(origin)){
            defArrayList.remove(rd.getName());
            defArrayList.add(newVirtualReg.getName());
            rd = newVirtualReg;
        }
    }

    @Override
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 2){
            throw new RuntimeException("[Bug] In LiInst operands is not 2.");
        }
        rd = operands[0];
        rs1 = operands[1];
        rs2 = null;
        defArrayList.add(rd.getName());
        return this;
    }

    @Override
    public String printCode(){
        return op + "\t" + rd.getName() + ", " + rs1.getName();
    }
}
