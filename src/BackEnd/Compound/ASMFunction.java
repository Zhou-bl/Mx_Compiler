package BackEnd.Compound;

import BackEnd.Operand.BasicOperand;
import BackEnd.Operand.Imm;
import BackEnd.Operand.Register;
import BackEnd.Operand.VirtualRegister;

import java.util.ArrayList;

public class ASMFunction extends BasicOperand {
    public ArrayList<ASMBlock> blockArrayList;
    public ArrayList<Register> arguments;
    public ArrayList<VirtualRegister> calleeSaved;

    public boolean isBuiltin;
    public int stackSize; //当前Function的活动记录的大小;
    public int virtualIndex;

    public ASMFunction(String _name){
        super(_name);
        blockArrayList = new ArrayList<>();
        arguments = new ArrayList<>();
        calleeSaved = new ArrayList<>();
        stackSize = 0;
        virtualIndex = 0;
    }

    public void addBlock(ASMBlock _block){
        blockArrayList.add(_block);
    }

    public Imm allocStack(){
        stackSize += 4;
        return new Imm(stackSize);
    }

    public ASMBlock getEntryBlock(){
        return blockArrayList.get(0);
    }

    public ASMBlock getExitBlock(){
        if(blockArrayList.size() == 1) return blockArrayList.get(0);
        else return blockArrayList.get(1);
    }

    public String printCode(){
        StringBuilder res = new StringBuilder();
        res.append('\t').append(".globl").append('\t').append(getName()).append('\n');
        res.append('\t').append(".p2align").append('\t').append('\t').append(1).append('\n');
        res.append('\t').append(".type").append('\t').append(getName()).append(",@function\n");
        res.append(getName()).append(':').append('\n');
        for(int i = 0; i < blockArrayList.size(); ++i){
            res.append(blockArrayList.get(i).printCode()).append('\n');
        }
        res.append('\t').append(".size").append('\t').append(getName()).append(", .-").append(getName()).append('\n');
        res.append("\t\t\t # -- End function");
        return res.toString();
    }
}
