package BackEnd.Compound;

import BackEnd.Operand.GlobalVar;

import java.util.ArrayList;

public class ASMModule {
    public ArrayList<GlobalVar> globalVarArrayList;
    public ArrayList<ASMFunction> ASMFunctionArrayList;

    public ASMModule(){
        globalVarArrayList = new ArrayList<>();
        ASMFunctionArrayList = new ArrayList<>();
    }

    public String printCode(){
        StringBuilder res = new StringBuilder();
        res.append('\t').append(".text\n");
        for(int i = 0; i < ASMFunctionArrayList.size(); ++i){
            ASMFunction cur = ASMFunctionArrayList.get(i);
            if(cur.isBuiltin) continue;
            res.append(cur.printCode()).append('\n');
        }
        for(int i = 0; i < globalVarArrayList.size(); ++i){
            GlobalVar cur = globalVarArrayList.get(i);
            res.append(cur.printCode()).append('\n');
        }
        return res.toString();
    }
}
