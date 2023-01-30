package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;

public class PseudoInstruction extends ASM_Instruction{
    public PseudoInstruction (ASMBlock _block, String _op){
        super(_block, _op);
    }

    @Override
    public void renameUse(String origin, VirtualRegister newVirtualReg){
        if(rs1.getName().equals(origin)){
            useArrayList.remove(origin);
            useArrayList.add(newVirtualReg.getName());
            rs1 = newVirtualReg;
        }
    }

    @Override
    public void renameDef(String origin, VirtualRegister newVirtualReg){
        if(rd.getName().equals(origin)){
            defArrayList.remove(origin);
            defArrayList.add(newVirtualReg.getName());
            rd = newVirtualReg;
        }
    }

    @Override
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 2){
            throw new RuntimeException("[Bug] In PseudoInst not 2 length operands.");
        }
        rd = operands[0];
        defArrayList.add(rd.getName());
        rs1 = operands[1];
        useArrayList.add(rs1.getName());
        rs2 = null;
        return this;
    }

    @Override
    public String printCode(){
        return op + "\t" + rd.getName() + ", " + rs1.getName();
    }
}
