package Utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Position {
    private int row, column;

    public Position(int r, int c){
        this.row = r;
        this.column = c;
    }

    public Position(Token token){//通过token获得位置信息
        this.row = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    public Position(ParserRuleContext ctx) {
        this(ctx.getStart());
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public String printPosition(){
        return "[ row: " + this.row + "; column: " + this.column + "]";
    }
}
