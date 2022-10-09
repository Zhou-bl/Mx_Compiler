package Utils;

public class SemanticError extends RuntimeException{
    private Position pos;
    public SemanticError(String msg, Position info){
        super(msg);
        this.pos = info;
    }

    @Override
    public String getMessage(){
        return "[Semantic Error]: in " + pos.printPosition() + " because " + super.getMessage();
    }
}
