package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.VirtualRegister;


import java.util.ArrayList;

public abstract class ASM_Instruction {
    public String op;
    public BasicOperand rs1, rs2, rd;

    public ArrayList<String> defArrayList, useArrayList;

    public ASM_Instruction(ASMBlock _block, String _op){
        defArrayList = new ArrayList<>();
        useArrayList = new ArrayList<>();
        op = _op;
        if(_block != null) _block.addInstruction(this);
    }

    public abstract ASM_Instruction addOperand(BasicOperand ... args);
    public abstract void renameUse(String origin, VirtualRegister newVirtualReg);
    public abstract void renameDef(String origin, VirtualRegister newVirtualReg);
    public abstract String printCode();
}
