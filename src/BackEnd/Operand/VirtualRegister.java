package BackEnd.Operand;

public class VirtualRegister extends Register{
    public VirtualRegister(int _cnt){
        super("virtual_reg" + _cnt);
        offset = new Imm(0);
    }

    public VirtualRegister(VirtualRegister _other){
        super(_other.name);
        color = _other.color;
        offset = new Imm(_other.offset.value);
    }

    public VirtualRegister(int _cnt, int _color){
        super("virtual_reg" + _cnt);
        color = _color;
        offset = new Imm(0);
    }

    public VirtualRegister(int _cnt, int _color, Imm _offset){
        super("virtual_reg" + _cnt);
        color = _color;
        offset = _offset;
    }

    @Override
    public String getName(){
        if(color == 32) return this.name;
        else return PhysicalRegister.regName.get(color);
    }
}
