package BackEnd.Instruction;

import BackEnd.Compound.ASMBlock;
import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.Imm;
import BackEnd.Operand.Register;
import BackEnd.Operand.VirtualRegister;

public class ArithInstruction extends ASM_Instruction{
    public ArithInstruction(ASMBlock _block, String _op){
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
    public void renameDef(String origin, VirtualRegister newVirtualReg){
        if(rd.getName().equals(origin)){
            defArrayList.remove(origin);
            defArrayList.add(newVirtualReg.getName());
            rd = newVirtualReg;
        }
    }

    @Override
    public ASM_Instruction addOperand(BasicOperand... operands){
        if(operands.length != 3){
            throw new RuntimeException("[Bug] In ArithInst not 3 length operands");
        }
        rd = operands[0];
        rs1 = operands[1];
        rs2 = operands[2];
        defArrayList.add(rd.getName());
        useArrayList.add(rs1.getName());
        if(rs2 instanceof Register) useArrayList.add(rs2.getName());
        return this;
    }

    @Override
    public String printCode(){
        String printOp = op, res = "";
        if(rs2 instanceof Imm) printOp += "i";
        res = printOp + "\t" + rd.getName() + ", "+ rs1.getName() + ", ";
        if(rs2 instanceof Imm) res += rs2;
        else res += rs2.getName();
        return res;
    }
}
