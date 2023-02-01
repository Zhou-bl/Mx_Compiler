package BackEnd.Operand;

public class GlobalVar extends BasicOperand{
    public String val;

    public GlobalVar(String _name, String _val){
        super(_name);
        val = _val;
    }

    public GlobalVar(String _name){
        super(_name);
        val = null;
    }

    public String printCode(){
        StringBuilder res = new StringBuilder();
        if(val == null){
            res.append('\t').append(".type").append('\t').append(getName()).append(",@object\n");
            res.append('\t').append(".section").append('\t').append(".bss\n");
            res.append('\t').append(".globl").append('\t').append(getName()).append('\n');
            res.append(getName()).append(":\n");
            res.append('\t').append(".word").append('\t').append(0).append('\n');
            res.append('\t').append(".size").append('\t').append(getName()).append(", 4");
        }else{
            res.append('\t').append(".type").append('\t').append(getName()).append(",@object\n");
            res.append('\t').append(".section").append('\t').append(".rodata\n");
            res.append(getName()).append(":\n");
            res.append('\t').append(".asciz").append('\t').append('\"').append(Replace(val)).append('\"').append('\n');
            res.append('\t').append(".size").append('\t').append(getName()).append(", ").append(val.length());
        }
        return res.toString();
    }

    public String Replace(String str){
        return str.replace("\\", "\\\\")
                .replace("\n", "\\n")
                .replace("\0", "")
                .replace("\t", "\\t")
                .replace("\"", "\\\"");
    }
}
