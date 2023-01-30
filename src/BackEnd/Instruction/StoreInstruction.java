package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.Register;
import BackEnd.Operand.VirtualRegister;

public class StoreInstruction extends ASM_Instruction {
    public StoreInstruction(ASMBlock _block, String _op){
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
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 2){
            throw new RuntimeException("[Bug] In StoreInst operands is not 2 length.");
        }
        rd = null;
        rs1 = operands[1];
        useArrayList.add(rs1.getName());
        rs2 = operands[0];
        useArrayList.add(rs2.getName());
        return this;
    }

    @Override
    public String printCode(){
        return op + "\t" + rs2.getName() + ", " + ((Register)rs1).offset + "(" + rs1.getName() + ")";
    }

    @Override
    public void renameDef(String origin, VirtualRegister newVirtualReg){}
}
