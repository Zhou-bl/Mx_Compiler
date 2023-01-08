package BackEnd.Operand;

import java.util.ArrayList;
import java.util.Arrays;

public class PhysicalRegister extends Register {
    public static final ArrayList<String> regName = new ArrayList<>(Arrays.asList("zero", "ra", "sp", "gp", "tp",
            "t0", "t1", "t2", "s0", "s1", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "t3", "t4", "t5", "t6"));

    public static final ArrayList<String> callerSavedRegName = new ArrayList<>(Arrays.asList("ra",
            "t0", "t1", "t2", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "t3", "t4", "t5", "t6"));

    public static final ArrayList<PhysicalRegister> callerSavedReg = new ArrayList<>(){
        {
            for(int i = 0; i < callerSavedRegName.size(); ++i) add(new PhysicalRegister(callerSavedRegName.get(i)));
        }
    };

    public static final ArrayList<String> calleeSavedRegName = new ArrayList<>(Arrays.asList("sp", "s0", "s1",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11"));

    public static final ArrayList<PhysicalRegister> calleeSavedReg = new ArrayList<>(){
        {
            for(int i = 0; i < calleeSavedRegName.size(); ++i) add(new PhysicalRegister(calleeSavedRegName.get(i)));
        }
    };



    public PhysicalRegister(String _name){
        super(_name);
    }

    public PhysicalRegister(String _name, Imm _offset){
        super(_name);
        offset = _offset;
    }

    public PhysicalRegister(VirtualRegister _virReg){
        super(regName.get(_virReg.color));
        color = _virReg.color;
        offset = new Imm(_virReg.offset.value);
    }

    public PhysicalRegister(VirtualRegister _virReg, int _color){
        super(regName.get(_color));
        color = _color;
        offset = new Imm(_virReg.offset.value);
    }
}
