package BackEnd.Operand;

public abstract class Register extends BasicOperand {
    public Imm offset;
    public boolean inMem;
    public int color;

    public Register(String _name){
        super(_name);
        this.offset = new Imm(0);
        this.inMem = false;
        this.color = 32;
    }
    public void setOffset(Imm _offset){
        this.offset = _offset;
    }

    public void setColor(int _color){
        this.color = _color;
    }
}
