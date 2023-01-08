package BackEnd.Operand;

public abstract class BasicOperand {
    public String name;

    public BasicOperand(String _name){
        name = _name;
    }

    public String getName(){
        return this.name;
    }
}
