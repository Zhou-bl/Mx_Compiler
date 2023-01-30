package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;

public class RetInstruction extends ASM_Instruction{
    public RetInstruction(ASMBlock _block){
        super(_block, "ret");
        rd = rs1 = rs2 = null;
    }

    @Override
    public String printCode(){
        return op;
    }

    //useless function:
    @Override public void renameUse(String origin, VirtualRegister newVirtualReg){}
    @Override public void renameDef(String origin, VirtualRegister newVirtualReg){}
    @Override public ASM_Instruction addOperand(BasicOperand... operands){return this;}
}
