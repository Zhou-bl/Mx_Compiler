package Utils;

public class SyntaxError extends RuntimeException{
    private Position pos;

    public SyntaxError(String msg, Position info){
        //super 关键字可以让子类调用父类的构造方法;
        super(msg);
        this.pos = info;
    }

    @Override
    public String getMessage(){
        return "[Syntax Error]: in " + pos.printPosition() + " because " + super.getMessage();
    }
}
