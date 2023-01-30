package BackEnd.Compound;

import BackEnd.Instruction.ASM_Instruction;
import BackEnd.Operand.BasicOperand;

import java.util.ArrayList;
import java.util.LinkedList;

public class ASMBlock extends BasicOperand {
    public LinkedList<ASM_Instruction> instructionList;
    public ArrayList<ASMBlock> successorArrayList;
    public ASMBlock(ASMFunction _function, String _blockName){
        super("." + _blockName);
        instructionList = new LinkedList<>();
        successorArrayList = new ArrayList<>();
        if(_function == null){
            throw new RuntimeException("[Bug] In backend null function.");
        } else {
            _function.addBlock(this);
        }
    }
    public void addInstruction(ASM_Instruction _inst){
        instructionList.add(_inst);
    }

    public String printCode(){
        StringBuilder res = new StringBuilder();
        res.append(getName()).append(":\n");
        for(int i = 0; i < instructionList.size(); ++i){
            res.append('\t').append(instructionList.get(i).printCode()).append('\n');
        }
        return res.toString();
    }
}
