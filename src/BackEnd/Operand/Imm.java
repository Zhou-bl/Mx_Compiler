package BackEnd.Operand;


public class Imm extends BasicOperand{
    //立即数类型
    public int value;

    public Imm(int _value){
        super(String.valueOf(_value));
        value = _value;
    }

    public Imm getReverse(){
        return new Imm(-value);
    }

    public String toString(){
        return String.valueOf(value);
    }
}
