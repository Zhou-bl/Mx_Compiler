package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.PhysicalRegister;
import BackEnd.Operand.VirtualRegister;

public class CallInstruction extends ASM_Instruction{
    public CallInstruction(ASMBlock _block){
        super(_block, "call");
    }

    @Override
    public void renameUse(String origin, VirtualRegister newVirtualReg){}

    @Override
    public void renameDef(String origin, VirtualRegister newVirtualReg){}

    @Override
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 1){
            throw new RuntimeException("[Bug] In CallInst not 1 length operands.");
        }
        rd = operands[0];
        rs1 = rs2 = null;
        defArrayList.addAll(PhysicalRegister.callerSavedRegName);
        return this;
    }

    @Override
    public String printCode(){
        return op + "\t" + rd.getName();
    }

}
