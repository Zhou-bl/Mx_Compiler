package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;

public class LaInstruction extends ASM_Instruction{
    //load address
    public LaInstruction(ASMBlock _block){
        super(_block, "la");
    }

    @Override
    public void renameUse(String origin, VirtualRegister newVirtualReg){}

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
            throw new RuntimeException("[Bug] In LaInst is not 2 length operands.");
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
