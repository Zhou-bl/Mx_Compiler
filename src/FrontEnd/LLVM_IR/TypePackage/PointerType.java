package FrontEnd.LLVM_IR.TypePackage;

public class PointerType extends IRType{
    public IRType baseType;
    public int dim;

    public PointerType(IRType _baseType){
        if(_baseType instanceof PointerType){
            if(((PointerType) _baseType).baseType instanceof LabelType){
                throw new RuntimeException("\"PointerType\" can't point to \"LabelType\".");
            }
            this.baseType = ((PointerType) _baseType).baseType;
            this.dim = ((PointerType) _baseType).dim + 1;
        } else {
            if(_baseType instanceof LabelType){
                throw new RuntimeException("\"PointerType\" can't point to \"LabelType\".");
            }
            this.baseType = _baseType;
            this.dim = 1;
        }
    }

    public PointerType(IRType _baseType, int _dim){
        if(_baseType instanceof PointerType){
            if(((PointerType) _baseType).baseType instanceof LabelType){
                throw new RuntimeException("\"PointerType\" can't point to \"LabelType\".");
            }
            this.baseType = ((PointerType) _baseType).baseType;
            this.dim = ((PointerType) _baseType).dim + _dim;
        } else {
            if(_baseType instanceof LabelType){
                throw new RuntimeException("\"PointerType\" can't point to \"LabelType\".");
            }
            this.baseType = _baseType;
            this.dim = _dim;
        }
    }

    @Override
    public int typeSize(){
        return 4;
    }

    @Override
    public String toString(){
        return this.baseType.toString() + "*".repeat(this.dim);
    }

    @Override
    public boolean isEqual(IRType other){
        return (other instanceof PointerType) &&
                (((PointerType) other).baseType.isEqual(this.baseType)) &&
                (((PointerType) other).dim == this.dim);
    }
}
