package FrontEnd.LLVM_IR;

import FrontEnd.Semantic.AST_Node.*;
import FrontEnd.LLVM_IR.BasicClass.Value;
import FrontEnd.LLVM_IR.Compound.IRBasicBlock;
import FrontEnd.LLVM_IR.Compound.IRFunction;
import FrontEnd.LLVM_IR.Compound.IRModule;
import FrontEnd.LLVM_IR.Instruction.*;
import FrontEnd.LLVM_IR.Operand.*;
import Utils.IRScope;
import FrontEnd.LLVM_IR.TypePackage.*;
import Utils.GlobalScope;
import java.util.*;

public class IRBuilder implements ASTVisitor {
    //name space:
    public GlobalScope globalScope;
    public IRScope curScope;
    public IRScope global_IRScope;
    //current position:
    public IRModule targetModule;
    public IRFunction curIRFunction;
    public IRBasicBlock curIRBlock;
    public StructType curClass;

    //some hash maps:
    public HashMap<String, IRType> typeTable;
    public HashMap<String, IRFunction> funcTable;
    public HashMap<String, StringConstant> stringTable;

    //global def linked_list:
    public LinkedList<VarDefNode> globalDefNodeList;
    private Stack<ExprNode> arrayAllocSizeStack;

    //stack for loops:用来记录continue和break跳转到的basicBlock是哪一个
    private final Stack<IRBasicBlock> loopContinue;
    private final Stack<IRBasicBlock> loopBreak;

    private IRType getIRType(TypeNode node){//通过node返回IRType,如果是arrayType那么type应该是pointerType
        if(node == null) return typeTable.get("void");
        IRType res = typeTable.get(node.typeID);
        if(node instanceof ArrayTypeNode){
            res = new PointerType(res, ((ArrayTypeNode) node).dimSize);
        }
        return res;
    }

    private Value getStringConstPtr(Value _value){
        //targetIRType应该是指向char的一个指针类型:
        GepInst ptr = new GepInst(curIRBlock, new PointerType(new IntegerType(8)), _value);
        ptr.addIndex(new IntConstant(0)).addIndex(new IntConstant(0));
        return ptr;
    }

    private Value getAddress(ASTNode node){
        if(node instanceof IdentifierExprNode){
            String id = ((IdentifierExprNode) node).identifier;
            Value resValue = curScope.getValue(id);
            if(curScope.isClassId(id)){
                Value ptr = curScope.getValue("_this");
                ptr = new LoadInst(curIRBlock, "_this", ptr);
                resValue = new GepInst(curIRBlock, new PointerType(curClass.typeTable.get(id)), ptr);
                ((GepInst) resValue).addIndex(new IntConstant(0)).addIndex(new IntConstant(curClass.indexTable.get(id)));
            }
            return resValue;
        }
        if(node instanceof ObjectPortionExprNode){
            ((ObjectPortionExprNode) node).baseObject.accept(this);
            Value baseAddress = ((ObjectPortionExprNode) node).baseObject.IROperand;
            StructType baseType = (StructType) baseAddress.type.deReference();
            GepInst res = new GepInst(curIRBlock, new PointerType((baseType.typeTable.get(((ObjectPortionExprNode) node).member))), baseAddress);
            res.addIndex(new IntConstant(0)).addIndex(new IntConstant(baseType.indexTable.get(((ObjectPortionExprNode) node).member)));
            return res;
        }
        if(node instanceof ArrayAccessNode){
            Value tmpPtrAddress = getAddress(((ArrayAccessNode) node).array);//Type**
            Value tmpPtr = new LoadInst(curIRBlock, "array", tmpPtrAddress);//Type*
            ((ArrayAccessNode) node).index.accept(this);
            Value tmpIndex = ((ArrayAccessNode) node).index.IROperand;
            GepInst res = new GepInst(curIRBlock, tmpPtr.type, tmpPtr);
            return res.addIndex(tmpIndex);
        }
        if(node instanceof MonocularOpExprNode){
            return getAddress(((MonocularOpExprNode) node).operand);
        }
        System.out.println("[Bug] getAddress wrong!");
        throw new RuntimeException("[Bug] getAddress wrong!");
    }

    private AllocInst stackAlloca(IRType _type, String _name){
        //用于在函数的entry_block处进行alloc指令
        return new AllocInst(curIRFunction.getEntryBlock(), _type, _name);
    }

    private Value heapAlloca(IRType _malloc_type, Value _malloc_size){
        String targetFuncName = "_malloc";
        funcTable.get("_malloc").isUsed = true;
        Value tmp = new CallInst(curIRBlock, funcTable.get("_malloc")).addArg(_malloc_size);
        return new BitcastInst(curIRBlock, tmp, _malloc_type);
    }

    private void addControl(IRBasicBlock _curBlock, Value _condition, IRBasicBlock _trueBlock, IRBasicBlock _falseBlock){
        //包装Trunc指令和Branch指令，使调用更方便
        assert !_condition.type.isEqual(new IntegerType(1));
        Value _cond = new TruncInst(_curBlock, _condition, new IntegerType(1));
        new BranchInst(_curBlock, _cond, _trueBlock, _falseBlock);
    }

    private Value reSetType(Value curValue, IRType targetType){
        if(curValue instanceof StringConstant) curValue = getStringConstPtr(curValue);
        if(curValue instanceof NullConstant) ((NullConstant) curValue).setType(targetType);
        return curValue;
    }

    private BinaryInst.IRBinaryOpType toOpType(BinaryExprNode.BinaryOpType op){
        BinaryInst.IRBinaryOpType resOp;
        switch (op){
            case ADD -> resOp = BinaryInst.IRBinaryOpType.add;
            case SUB -> resOp = BinaryInst.IRBinaryOpType.sub;
            case MUL -> resOp = BinaryInst.IRBinaryOpType.mul;
            case DIV -> resOp = BinaryInst.IRBinaryOpType.sdiv;
            case MOD -> resOp = BinaryInst.IRBinaryOpType.srem;
            case SHL -> resOp = BinaryInst.IRBinaryOpType.shl;
            case SHR -> resOp = BinaryInst.IRBinaryOpType.ashr;
            case AND -> resOp = BinaryInst.IRBinaryOpType.and;
            case XOR -> resOp = BinaryInst.IRBinaryOpType.xor;
            case OR -> resOp = BinaryInst.IRBinaryOpType.or;
            case LAND -> resOp = BinaryInst.IRBinaryOpType.logic_and;
            case LOR -> resOp = BinaryInst.IRBinaryOpType.logic_or;
            case GT -> resOp = BinaryInst.IRBinaryOpType.sgt;
            case LT -> resOp = BinaryInst.IRBinaryOpType.slt;
            case GE -> resOp = BinaryInst.IRBinaryOpType.sge;
            case LE -> resOp = BinaryInst.IRBinaryOpType.sle;
            case EQ -> resOp = BinaryInst.IRBinaryOpType.eq;
            case NE -> resOp = BinaryInst.IRBinaryOpType.ne;
            case ASSIGN -> resOp = BinaryInst.IRBinaryOpType.assign;
            default -> throw new RuntimeException("[Bug] Unknown BinaryOpType.");
        }
        return resOp;
    }

    private Value doShortCircuit(BinaryExprNode node){
        BinaryInst.IRBinaryOpType opType = toOpType(node.opSymbol);
        Value shortCircuitAddress = stackAlloca(new BoolType() , "sc_tmp_address_" + opType.toString());
        Value lIROperand = node.leftOperand.IROperand;
        IRBasicBlock short_block = new IRBasicBlock("short_block", curIRFunction);
        IRBasicBlock long_block = new IRBasicBlock("long_block", curIRFunction);
        IRBasicBlock terminal_block = new IRBasicBlock("terminal_block", curIRFunction);
        if(opType == BinaryInst.IRBinaryOpType.logic_or){
            addControl(curIRBlock, lIROperand, short_block, long_block);
        } else {
            addControl(curIRBlock, lIROperand, long_block, short_block);
        }
        new StoreInst(short_block, lIROperand, shortCircuitAddress);
        new BranchInst(short_block, terminal_block);
        curIRBlock = long_block;
        node.rightOperand.accept(this);
        new StoreInst(long_block, node.rightOperand.IROperand, shortCircuitAddress);
        new BranchInst(long_block, terminal_block);
        curIRBlock = terminal_block;
        return new LoadInst(curIRBlock, "sc_terminal_address", shortCircuitAddress);
    }

    private IRConstant calculateConst(BinaryExprNode node, IRConstant lop, IRConstant rop){
        BinaryInst.IRBinaryOpType op = toOpType(node.opSymbol);
        IRConstant res;
        switch (op) {
            case add, sub, mul, sdiv, srem, shl, ashr, and, or, xor, logic_and, logic_or -> {
                //计算指令
                if(lop instanceof IntConstant && rop instanceof IntConstant){
                    //operands are int type:
                    int lop_value = ((IntConstant) lop).value, rop_value = ((IntConstant) rop).value, res_value;
                    switch (op) {
                        case add -> res_value = lop_value + rop_value;
                        case sub -> res_value = lop_value - rop_value;
                        case mul -> res_value = lop_value * rop_value;
                        case sdiv -> res_value = lop_value / rop_value;
                        case srem -> res_value = lop_value % rop_value;
                        case and -> res_value = lop_value & rop_value;
                        case or -> res_value = lop_value | rop_value;
                        case xor -> res_value = lop_value ^ rop_value;
                        case shl -> res_value = lop_value << rop_value;
                        case ashr -> res_value = lop_value >> rop_value;
                        default -> throw new RuntimeException("[calculateConst-Bug]_1 Unknown binary airth opType in constant calculation.");
                    }
                    res = new IntConstant(res_value);
                } else if(lop instanceof BoolConstant && rop instanceof BoolConstant){
                    //operands are boolean type:
                    boolean lop_value = ((BoolConstant) lop).value, rop_value = ((BoolConstant) rop).value, res_value;
                    switch (op){
                        case logic_and -> res_value = lop_value && rop_value;
                        case logic_or -> res_value = lop_value || rop_value;
                        default -> throw new RuntimeException("[calculateConst-Bug]_2 Unknown binary logic opType.");
                    }
                    res = new BoolConstant(res_value);
                } else throw new RuntimeException("[calculateConst-Bug & semantic error]_3 lop and rop is not the same type.");
            }
            case eq, ne, sgt, sge, slt, sle -> {
                boolean res_value;
                switch (op) {
                    case eq, ne -> {
                        if(lop instanceof IntConstant && rop instanceof IntConstant) {
                            int lop_value = ((IntConstant) lop).value, rop_value = ((IntConstant) rop).value;
                            res_value = ((op == BinaryInst.IRBinaryOpType.eq) == (lop_value == rop_value));
                        } else if(lop instanceof BoolConstant && rop instanceof BoolConstant) {
                            boolean lop_value = ((BoolConstant) lop).value, rop_value = ((BoolConstant) rop).value;
                            res_value = ((op == BinaryInst.IRBinaryOpType.eq) == (lop_value == rop_value));
                        } else throw new RuntimeException("[calculateConst-Bug]_4 Unknown operator type(not int or bool).");
                    }
                    case sgt, sge, slt, sle -> {
                        assert lop instanceof IntConstant && rop instanceof IntConstant;//均为Int类型;
                        int lop_value = ((IntConstant) lop).value, rop_value = ((IntConstant) rop).value;
                        switch (op) {
                            case sgt -> res_value = lop_value > rop_value;
                            case sge -> res_value = lop_value >= rop_value;
                            case slt -> res_value = lop_value < rop_value;
                            case sle -> res_value = lop_value <= rop_value;
                            default -> throw new RuntimeException("[calculateConst-Bug]_5(0)");
                        }
                    }
                    default -> throw new RuntimeException("[calculateConst-Bug]_5(1)");
                }
                res = new BoolConstant(res_value);
            }
            default -> throw new RuntimeException("[calculateConst-Bug]_6 Unknown binary opType.");
        }
        return res;
    }

    private Value calculateString(BinaryExprNode node, Value _lStr, Value _rStr){
        BinaryInst.IRBinaryOpType op = toOpType(node.opSymbol);
        assert _lStr.type.isEqual(new PointerType(new IntegerType(8))) && _rStr.type.isEqual(new PointerType(new IntegerType(8)));
        CallInst res;
        String funcName;
        switch (op) {
            case add -> funcName = "_str_splice";
            case eq -> funcName = "_str_eq";
            case ne -> funcName = "_str_ne";
            case slt -> funcName = "_str_lt";
            case sle -> funcName = "_str_le";
            case sgt -> funcName = "_str_gt";
            case sge -> funcName = "_str_ge";
            default -> throw new RuntimeException("[calculateString]");
        }
        res = new CallInst(curIRBlock, funcTable.get(funcName));
        funcTable.get(funcName).isUsed = true;
        res.addArg(_lStr).addArg(_rStr);
        return res;
    }

    private Value doArraySize(Value _address){
        Value tmpPtr = new BitcastInst(curIRBlock, _address, new PointerType(new IntegerType(32)));
        GepInst tmp = new GepInst(curIRBlock, new PointerType(new IntegerType(32)), tmpPtr);
        tmp.addIndex(new IntConstant(-1));
        return new LoadInst(curIRBlock, "array_size", tmp);
    }

    private Value doArrayAlloc(IRType _malloc_type){
        assert !arrayAllocSizeStack.empty();
        IRType mallocType = _malloc_type.deReference();
        ExprNode curSizeExpr = arrayAllocSizeStack.pop();
        curSizeExpr.accept(this);
        //数组的元素数即:size()返回的值:
        Value curSizeValue = curSizeExpr.IROperand;
        Value realSize = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.mul, curSizeValue, new IntConstant(mallocType.typeSize()));
        //总空间需要再加一个int的空间来记录size大小
        Value mallocByteSize = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.add, realSize, new IntConstant(4));
        Value mallocPointer = heapAlloca(new PointerType(new IntegerType(32)), mallocByteSize);
        new StoreInst(curIRBlock, curSizeValue, mallocPointer);//存放size的value;
        //+1的offset之后的指针:
        GepInst arrayPointer = new GepInst(curIRBlock, new PointerType(new IntegerType(32)), mallocPointer).addIndex(new IntConstant(1));
        BitcastInst res = new BitcastInst(curIRBlock, arrayPointer, _malloc_type);
        if(arrayAllocSizeStack.empty()) return res;
        //写一个循环来为每一个维数组malloc空间:
        IRBasicBlock allocConditionBlock = new IRBasicBlock("alloc_condition_bb", curIRFunction);
        IRBasicBlock allocBodyBlock = new IRBasicBlock("alloc_body_bb", curIRFunction);
        IRBasicBlock allocTerminalBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);
        AllocInst iter_ptr = stackAlloca(new IntegerType(32), "alloc_iter_ptr");//循环计数器
        new StoreInst(curIRBlock, new IntConstant(0), iter_ptr);
        new BranchInst(curIRBlock, allocConditionBlock); curIRBlock = allocConditionBlock;
        LoadInst iter_value = new LoadInst(curIRBlock, "alloc_iter_value", iter_ptr);
        IcmpInst jumpFlag = new IcmpInst(curIRBlock, BinaryInst.IRBinaryOpType.ne, iter_value, curSizeValue);
        new BranchInst(curIRBlock, jumpFlag, allocBodyBlock, allocTerminalBlock); curIRBlock = allocBodyBlock;
        GepInst cur_ptr = new GepInst(curIRBlock, _malloc_type, res).addIndex(iter_value);
        new StoreInst(curIRBlock, doArrayAlloc(mallocType), cur_ptr);
        BinaryInst iterValue_plus_1 = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.add, new IntConstant(1), iter_value);
        new StoreInst(curIRBlock, iterValue_plus_1, iter_ptr);
        new BranchInst(curIRBlock, allocConditionBlock);
        curIRBlock = allocTerminalBlock;
        return res;
    }

    private Value doNormalAlloc(AllocExprNode node){
        //先申请空间，再调用构造函数
        assert !node.isArray();
        Value res;
        String typeName = node.allocType.typeID;
        StructType typeStruct = (StructType) typeTable.get(typeName).deReference();
        //申请空间
        res = heapAlloca(new PointerType(typeStruct), new IntConstant(typeStruct.typeSize()));
        //调用构造函数,只有一个构造函数,有多个构造函数的情况为UB.
        CallInst callConstruction = new CallInst(curIRBlock, funcTable.get("_" + typeStruct.name + "_" + typeName));
        callConstruction.addArg(res);
        return res;
    }

    private void visitGlobalDef(){
        assert !globalDefNodeList.isEmpty();
        IRType res_type = new FunctionType(new VoidType());
        IRFunction global_all = new IRFunction("Global_init", res_type);
        IRBasicBlock global_all_bb = new IRBasicBlock("global_all_bb", global_all);
        for(int i = 0; i < globalDefNodeList.size(); ++i){
            VarDefNode curNode = globalDefNodeList.get(i);
            IRFunction global_init_single = new IRFunction("global_init_" + curNode.variableID, res_type);
            IRBasicBlock entry_block = new IRBasicBlock(curNode.variableID + "_entry_bb", global_init_single);
            IRBasicBlock exit_block = new IRBasicBlock(curNode.variableID + "_exit_bb", global_init_single);
            Value init_value;
            IRType value_IRType = getIRType(curNode.variableType);
            Value value_address = global_IRScope.getValue(curNode.variableID);
            curIRBlock = entry_block;
            curIRFunction = global_init_single;
            if(curNode.initValue == null) init_value = new NullConstant();
            else {
                curNode.initValue.accept(this);
                init_value = curNode.initValue.IROperand;
            }
            init_value = reSetType(init_value, value_IRType);
            new StoreInst(curIRBlock, init_value, value_address);
            new BranchInst(curIRBlock, exit_block); curIRBlock = exit_block;
            new RetInst(curIRBlock, new Value("voidrestype", new VoidType())); curIRBlock = global_all_bb;
            CallInst callSingleInitFunc = new CallInst(curIRBlock, global_init_single);
            targetModule.addGlobalInit(global_init_single);
        }
        curIRBlock = global_all_bb;
        new RetInst(curIRBlock, new Value("voidrestype", new VoidType()));
        targetModule.addGlobalInit(global_all);
    }

    public IRBuilder(GlobalScope _globalScope, IRModule _module){
        this.globalScope = _globalScope;
        this.curScope = new IRScope(null, IRScope.scopeType.Global);
        this.global_IRScope = this.curScope;
        this.targetModule = _module;
        this.curIRBlock = null;
        this.curClass = null;
        this.curIRFunction = null;
        this.typeTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.stringTable = new HashMap<>();
        this.globalDefNodeList = new LinkedList<>();
        this.loopBreak = new Stack<>();
        this.loopContinue = new Stack<>();
        this.arrayAllocSizeStack = new Stack<>();
    }

    @Override
    public void visit(RootNode node){//add class function in
        typeTable.put("void", new VoidType());
        for(Map.Entry<String, GlobalScope> iter : globalScope.ClassTable.entrySet()){//add class.
            String className = iter.getKey();
            if(className.equals("int")) typeTable.put("int", new IntegerType(32));
            else if(className.equals("bool")) typeTable.put("bool", new BoolType());
            else if(className.equals("string")) typeTable.put("string", new PointerType(new IntegerType(8)));
            else {
                StructType newClass = new StructType(className);
                typeTable.put(className, new PointerType(newClass));
                targetModule.addClass(newClass);
            }
        }
        for(Map.Entry<String, FuncDefNode> iter : globalScope.FunctionTable.entrySet()){//add non-member functions.
            String funcName = iter.getKey();
            FuncDefNode funcNode = iter.getValue();
            FunctionType funcType = new FunctionType(getIRType(funcNode.functionType));
            if(funcNode.parameterList != null){
                for(int i = 0; i < funcNode.parameterList.size(); ++i){
                    IRType paraType = getIRType(funcNode.parameterList.get(i).variableType);
                    String paraID = funcNode.parameterList.get(i).variableID;
                    funcType.addParameter(paraType, paraID);
                }
            }
            IRFunction newFunction = new IRFunction("_f_" + funcName, funcType);
            newFunction.isBuiltin = funcNode.isBuildIn;
            targetModule.addFunction(newFunction);
            funcTable.put(funcName, newFunction);
        }
        for(Map.Entry<String, GlobalScope> iter : globalScope.ClassTable.entrySet()){//add member variables , functions and construction functions.
            String className = iter.getKey();
            GlobalScope classScope = iter.getValue();
            if(className.equals("int") || className.equals("bool")) continue;
            IRType curType = typeTable.get(className).deReference();
            if(!className.equals("string")){
                //add variable
                classScope.VariableTable.forEach((ID, tmpTy) -> ((StructType)curType).addMember(ID, getIRType(tmpTy)));
            }
            for(Map.Entry<String, FuncDefNode> FuncIter : classScope.FunctionTable.entrySet()){
                //add member function:
                String funcName = FuncIter.getKey();
                FuncDefNode funcNode = FuncIter.getValue();
                IRType returnTy = getIRType(funcNode.functionType);
                FunctionType funcType = new FunctionType(returnTy);
                IRType tmpArgTy = new PointerType(curType);
                //添加 this 指针
                funcType.addParameter(tmpArgTy, "_this");
                if(funcNode.parameterList != null){
                    for(VarDefNode _tmp:funcNode.parameterList){
                        tmpArgTy = getIRType(_tmp.variableType);
                        funcType.addParameter(tmpArgTy, _tmp.variableID);
                    }
                }
                IRFunction _newMemberFunc = new IRFunction("_class_"+ className + "_" + funcName, funcType);
                if(funcNode.isBuildIn) _newMemberFunc.isBuiltin = true;
                funcTable.put("_class_"+ className + "_" + funcName, _newMemberFunc);
                targetModule.addFunction(_newMemberFunc);
            }
            //添加默认构造函数

            if(!className.equals("string") && funcTable.get("_class_" + className + "_" + className) == null){
                //System.out.println("_class" + className + "_" + className);
                FunctionType funcType = new FunctionType(new VoidType());
                IRType tmpArgType = new PointerType(curType);
                funcType.addParameter(tmpArgType, "_this");
                IRFunction defaultConstructionFunc = new IRFunction("_class_" + className + "_" + className, funcType);
                defaultConstructionFunc.addOperand(new Value("_arg", tmpArgType));
                IRBasicBlock newBlock = new IRBasicBlock(defaultConstructionFunc.name, defaultConstructionFunc);
                new RetInst(newBlock, new Value("voidrestype", new VoidType()));
                funcTable.put("_class_" + className + "_" + className, defaultConstructionFunc);
                targetModule.addFunction(defaultConstructionFunc);
            }
        }
        node.elements.forEach(_ele -> _ele.accept(this));
        if(!globalDefNodeList.isEmpty()) visitGlobalDef();
    }

    @Override
    public void visit(ClassDefNode node){
        curClass = (StructType) typeTable.get(node.classID).deReference();
        curScope = new IRScope(curScope, IRScope.scopeType.Class);
        curClass.indexTable.forEach((id, index) -> curScope.putValue(id, new IntConstant(index)));
        if (node.memberFunctions != null) node.memberFunctions.forEach(ele->ele.accept(this));
        curClass = null;
        curScope = curScope.upRoot();
    }

    @Override
    public void visit(FuncDefNode node){
        //需要先把parameter中的参数拷贝一份到函数体内，即alloc多个空间存放parameter的值
        curScope = new IRScope(curScope, IRScope.scopeType.Func);
        if(curClass == null) curIRFunction = funcTable.get(node.functionID);
        else curIRFunction = funcTable.get("_" + curClass.name + "_" + node.functionID);
        new IRBasicBlock(curIRFunction.name, curIRFunction);
        new IRBasicBlock(curIRFunction.name, curIRFunction);
        FunctionType funcType = (FunctionType) curIRFunction.type;//返回值转为funcType
        Value funcResValue;
        if(!funcType.toString().equals("void")){
            curIRFunction.resAddress = stackAlloca(funcType.resType, "_return");
            funcResValue = new LoadInst(curIRFunction.getReturnBlock(), "_return", curIRFunction.resAddress);
        } else {
            funcResValue = new Value("voidrestype", new VoidType());
        }
        new RetInst(curIRFunction.getReturnBlock(), funcResValue);//这里设置
        curIRBlock = curIRFunction.getEntryBlock();
        //add parameters into entryBlock:
        if(funcType.parameterNameList != null){
            for(int i = 0; i < funcType.parameterNameList.size(); ++i){
                String tmpParaName = funcType.parameterNameList.get(i);
                IRType tmpParaType = funcType.parameterTypeList.get(i);
                Value tmpArg = new Value("_arg", tmpParaType);
                curIRFunction.addOperand(tmpArg);
                AllocInst localPara = stackAlloca(tmpParaType, tmpParaName);
                new StoreInst(curIRBlock, tmpArg, localPara);//把参数传到function本地的value中
                curScope.putValue(tmpParaName, localPara);
            }
        }
        if(node.functionBody.stmtList != null) node.functionBody.stmtList.forEach(ele->ele.accept(this));
        if(curIRBlock.terminator == null) {//增加跳转指令
            if(node.functionType != null && (!funcType.toString().equals("void"))){//main函数默认返回 int 0
                new StoreInst(curIRBlock, new IntConstant(0), curIRFunction.resAddress);
            }
            new BranchInst(curIRBlock, curIRFunction.getReturnBlock());
        }
        curIRBlock = null;
        curScope = curScope.upRoot();
    }

    @Override
    public void visit(VarDefStmtNode node){
        if(!curScope.isValid) return;
        node.baseDecl.forEach(ele -> ele.accept(this));
    }

    @Override
    public void visit(VarDefNode node){
        if(!curScope.isValid) return;
        IRType curType = getIRType(node.variableType);
        Value curIRValue;
        if(curScope.parentScope == null){//global def:
            curIRValue = new GlobalDefInst(curType, node.variableID);
            targetModule.addGlobalDef((GlobalDefInst) curIRValue);
            curScope.putValue(node.variableID, curIRValue);
            node.IROperand = curIRValue;
            if(node.initValue != null || node.variableType instanceof ArrayTypeNode){
                globalDefNodeList.add(node);
            }
        } else {//local def:
            curIRValue = stackAlloca(curType, node.variableID);
            curScope.putValue(node.variableID, curIRValue);
            node.IROperand = curIRValue;
            if(node.initValue != null){
                node.initValue.accept(this);
                Value curInitValue = node.initValue.IROperand;
                curInitValue = reSetType(curInitValue, curType);
                new StoreInst(curIRBlock, curInitValue, curIRValue);
            } else {
                if(node.variableType instanceof ArrayTypeNode){
                    new StoreInst(curIRBlock, new NullConstant((PointerType) curType), curIRValue);
                }
            }
        }
    }

    @Override
    public void visit(BlockStmtNode node){
        if(!curScope.isValid) return;
        curScope = new IRScope(curScope, IRScope.scopeType.Block);
        if(node.stmtList != null) node.stmtList.forEach(ele -> ele.accept(this));
        curScope = curScope.upRoot();
    }

    @Override
    public void visit(IfStmtNode node){
        //三部分：condition, thenblock, elseblock
        if(!curScope.isValid) return;
        curScope = new IRScope(curScope, IRScope.scopeType.Flow);
        //define blocks:
        IRBasicBlock thenBlock = new IRBasicBlock("if_then", curIRFunction);
        IRBasicBlock elseBlock = null; //待定
        IRBasicBlock terminalBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);
        //add control flows:
        node.condition.accept(this);
        if(node.elseStmt != null){
            elseBlock = new IRBasicBlock("if_else", curIRFunction);
            addControl(curIRBlock, node.condition.IROperand, thenBlock, elseBlock);
        } else {
            addControl(curIRBlock, node.condition.IROperand, thenBlock, terminalBlock);
        }
        //递归访问thenBlock
        curIRBlock = thenBlock;
        node.thenStmt.accept(this);
        new BranchInst(curIRBlock, terminalBlock);
        //递归访问elseBlock
        if(node.elseStmt != null){
            curIRBlock = elseBlock;
            node.elseStmt.accept(this);
            new BranchInst(curIRBlock, terminalBlock);
        }
        curIRBlock = terminalBlock;
        curScope = curScope.upRoot();
    }

    @Override
    public void visit(WhileStmtNode node){
        //condition 单独开一个block,因为涉及到多次判断条件的情况，if的条件只需要判断一次
        //还需要一个while_body_bb表示循环体
        if(!curScope.isValid) return;
        curScope = new IRScope(curScope, IRScope.scopeType.Flow);
        //define blocks:

        IRBasicBlock conditionBlock = new IRBasicBlock("while_condition_bb", curIRFunction);
        IRBasicBlock whileBodyBlock = new IRBasicBlock("while_body_bb", curIRFunction);
        IRBasicBlock terminalBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);

        //add control flows:

        loopContinue.push(conditionBlock);
        loopBreak.push(terminalBlock);
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = conditionBlock;
        node.condition.accept(this);
        addControl(curIRBlock, node.condition.IROperand, whileBodyBlock, terminalBlock);
        if(node.loopBody != null){
            curIRBlock = whileBodyBlock;
            node.loopBody.accept(this);
            new BranchInst(curIRBlock, conditionBlock);
        }
        curIRBlock = terminalBlock;
        loopContinue.pop();
        loopBreak.pop();
        curScope = curScope.upRoot();
    }

    @Override
    public void visit(ForStmtNode node){
        //与whileStmtNode类似，自增部分需要新开一个block
        if(!curScope.isValid) return;
        curScope = new IRScope(curScope, IRScope.scopeType.Flow);
        //define blocks:
        IRBasicBlock conditionBlock = new IRBasicBlock("for_condition_bb", curIRFunction);
            //for continue:这样使continue的处理容易一些:
        IRBasicBlock incrBlock = new IRBasicBlock("for_iter_bb", curIRFunction);
        IRBasicBlock forBodyBlock = new IRBasicBlock("for_body_bb", curIRFunction);
        IRBasicBlock terminalBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);
        //add control flows:
        if(node.init != null){
            node.init.accept(this);
        }
        loopContinue.push(incrBlock);
        loopBreak.push(terminalBlock);
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = conditionBlock;
        if(node.condition != null){
            node.condition.accept(this);
            addControl(curIRBlock, node.condition.IROperand, forBodyBlock, terminalBlock);
        }
        else {
            new BranchInst(curIRBlock, forBodyBlock);
        }
        curIRBlock = forBodyBlock;
        if(node.loopBody != null){
            node.loopBody.accept(this);
        }
        new BranchInst(curIRBlock, incrBlock); curIRBlock = incrBlock;
        if(node.incrExpr != null){
            node.incrExpr.accept(this);
        }
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = terminalBlock;
        loopContinue.pop();
        loopBreak.pop();
        curScope = curScope.upRoot();

        /*
        if(node.incrExpr != null){
            node.incrExpr.accept(this);
        }
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = forBodyBlock;

        new BranchInst(curIRBlock, incrBlock);
        curIRBlock = terminalBlock;

        curScope = curScope.upRoot();
        */
    }

    @Override
    public void visit(ReturnStmtNode node){
        if(!curScope.isValid) return;
        if(node.resValue != null){
            Value resValue;
            node.resValue.accept(this);
            resValue = node.resValue.IROperand;
            if(node.resValue.IROperand instanceof StringConstant){
                resValue = getStringConstPtr(resValue);
            }
            if(node.resValue.IROperand instanceof NullConstant){
                ((NullConstant) resValue).setType(((FunctionType) curIRFunction.type).resType);
            }
            new StoreInst(curIRBlock, resValue, curIRFunction.resAddress);
        }
        new BranchInst(curIRBlock, curIRFunction.getReturnBlock());
        curScope.setInvalid();
    }

    @Override
    public void visit(BreakStmtNode Node){
        if(!curScope.isValid) return;
        if(loopBreak.empty()){
            System.out.println("[Bug] the break stack is empty!");
            return;
        }
        new BranchInst(curIRBlock, loopBreak.peek());
        curScope.setInvalid();
    }

    @Override
    public void visit(ContinueStmtNode node){
        if(!curScope.isValid) return;
        if(loopContinue.empty()){
            System.out.println("[Bug] the continue stack is empty?");
            return;
        }
        new BranchInst(curIRBlock, loopContinue.peek());
        curScope.setInvalid();
    }

    @Override
    public void visit(ExprStmtNode node){
        if(!curScope.isValid) return;
        node.expr.accept(this);
    }

    @Override
    public void visit(IdentifierExprNode node){
        if(!curScope.isValid) return;
        node.IROperand = new LoadInst(curIRBlock, node.identifier, getAddress(node));
    }

    @Override
    public void visit(ObjectPortionExprNode node){
        if(!curScope.isValid) return;
        node.baseObject.accept(this);
        Value baseAddress = node.baseObject.IROperand;
        StructType baseType = (StructType) baseAddress.type.deReference();
        GepInst nodeOperand = new GepInst(curIRBlock, new PointerType(baseType.typeTable.get(node.member)), baseAddress);
        nodeOperand.addIndex(new IntConstant(0)).addIndex(new IntConstant(baseType.indexTable.get(node.member)));
        node.IROperand = new LoadInst(curIRBlock, node.member, nodeOperand);
    }

    @Override
    public void visit(AllocExprNode node){
        if(!curScope.isValid) return;
        Value nodeIROperand;
        if(node.isArray()){
            assert arrayAllocSizeStack.empty();
            for(int i = node.sizeList.size() - 1; i >= 0; --i) arrayAllocSizeStack.push(node.sizeList.get(i));
            nodeIROperand = doArrayAlloc(new PointerType(getIRType(node.allocType), node.dimSize));
        } else {
            nodeIROperand = doNormalAlloc(node);
        }
        node.IROperand = nodeIROperand;
    }

    @Override
    public void visit(FuncCallExprNode node){
        //成员函数和普通函数调用:
        //在class内优先调用class内的成员函数
        if(!curScope.isValid) return;
        IRFunction nodeFunc = null;
        Value thisPtr = null;
        if(node.func instanceof IdentifierExprNode){
            boolean isMemberFunction = false;
            String funcName = ((IdentifierExprNode) node.func).identifier;
            String debuger = "println";

            if(curClass != null){
                nodeFunc =  funcTable.get("_" + curClass.name + "_" + funcName);
            }
            if(nodeFunc == null){
                nodeFunc = funcTable.get(funcName);
            } else {isMemberFunction = true;}
            if(nodeFunc == null){
                throw new RuntimeException("[Bug] can't find function in LLVM.");
            }
            if(isMemberFunction){//add this 指针
                thisPtr = curScope.getValue("_this");
                thisPtr = new LoadInst(curIRBlock, "_this", thisPtr);
            }
        }
        if(node.func instanceof ObjectPortionExprNode){
            ((ObjectPortionExprNode) node.func).baseObject.accept(this);
            thisPtr = ((ObjectPortionExprNode) node.func).baseObject.IROperand;
            if(((ObjectPortionExprNode) node.func).baseObject.exprType instanceof ArrayTypeNode){
                //只有size函数
                if(!((ObjectPortionExprNode) node.func).member.equals("size")){
                    String s = ((ObjectPortionExprNode) node.func).member;
                    throw new RuntimeException("[Bug] the wrong function: " + s);
                }
                node.IROperand = doArraySize(thisPtr);
                return;
            }
            String classID; IRType classType = thisPtr.type.deReference();
            if(classType instanceof StructType) classID = ((StructType) classType).name;
            else {
                classID = "class_string";
            }
            nodeFunc = funcTable.get("_" + classID + "_" + ((ObjectPortionExprNode) node.func).member);
        }
        if(nodeFunc == null){
            throw new RuntimeException("[Bug] node func is null.");
        }else{nodeFunc.isUsed = true;}
        //add args:
        if(node.parameterListForCall != null){
            for(int i = 0; i < node.parameterListForCall.size(); ++i){
                node.parameterListForCall.get(i).accept(this);
                Value arg = node.parameterListForCall.get(i).IROperand;
                arg = reSetType(arg, ((FunctionType)nodeFunc.type).parameterTypeList.get(i));
                node.parameterListForCall.get(i).IROperand = arg;
            }
        }
        node.IROperand = new CallInst(curIRBlock, nodeFunc);
        if(thisPtr != null)((CallInst) node.IROperand).addArg(thisPtr);
        if(node.parameterListForCall != null){
            for(int i = 0; i < node.parameterListForCall.size(); ++i) ((CallInst) node.IROperand).addArg(node.parameterListForCall.get(i).IROperand);
        }
    }

    @Override
    public void visit(ArrayAccessNode node){
        if(!curScope.isValid) return;
        Value targetAddress = getAddress(node);
        node.IROperand = new LoadInst(curIRBlock, "array", targetAddress);
    }

    @Override
    public void visit(MonocularOpExprNode node){
        if(!curScope.isValid) return;
        node.operand.accept(this);
        Value oldNodeOperand = node.operand.IROperand, valueAddress;
        switch (node.opSymbol){
            case LOGIC_NOT -> {
                if(oldNodeOperand instanceof IRConstant) node.IROperand = new BoolConstant(!((BoolConstant) oldNodeOperand).value);
                else node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.xor, oldNodeOperand, new BoolConstant(true));
            }
            case BIT_NOT -> {
                if(oldNodeOperand instanceof IRConstant) node.IROperand = new IntConstant(~((IntConstant) oldNodeOperand).value);
                //(~x) = (-1) ^ x;
                else node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.xor, oldNodeOperand, new IntConstant(-1));
            }
            case SINC -> {
                valueAddress = getAddress(node.operand);
                node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.add, oldNodeOperand, new IntConstant(1));
                new StoreInst(curIRBlock, node.IROperand, valueAddress);
            }
            case SDER -> {
                valueAddress = getAddress(node.operand);
                node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.sub, oldNodeOperand, new IntConstant(1));
                new StoreInst(curIRBlock, node.IROperand, valueAddress);
            }
            case SINC_AFT -> {
                valueAddress = getAddress(node.operand);
                node.IROperand = oldNodeOperand;
                Value newValue = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.add, oldNodeOperand, new IntConstant(1));
                new StoreInst(curIRBlock, newValue, valueAddress);
            }
            case SDER_AFT -> {
                valueAddress = getAddress(node.operand);
                node.IROperand = oldNodeOperand;
                Value newValue = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.sub, oldNodeOperand, new IntConstant(1));
                new StoreInst(curIRBlock, newValue, valueAddress);
            }
            case POS -> //do nothing:
                node.IROperand = oldNodeOperand;
            case NEG -> {
                if(oldNodeOperand instanceof IRConstant) node.IROperand = new IntConstant(-((IntConstant) oldNodeOperand).value);
                else node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.sub,new IntConstant(0), oldNodeOperand);
            }
        }
    }

    @Override
    public void visit(BinaryExprNode node){
        if(!curScope.isValid) return;
        Value nodeOperand = null;
        BinaryInst.IRBinaryOpType opType = toOpType(node.opSymbol);
        if(opType == BinaryInst.IRBinaryOpType.logic_and || opType == BinaryInst.IRBinaryOpType.logic_or){
            //可能需要短路运算的指令运算类型: 如果为Bool常量，可以直接算出结果; 如果是表达式则必须进行短路运算.
            node.leftOperand.accept(this);
            if(opType == BinaryInst.IRBinaryOpType.logic_and){
                if(node.leftOperand.IROperand instanceof BoolConstant){
                    //不需要短路运算,直接计算出结果
                    if(!((BoolConstant) node.leftOperand.IROperand).value) nodeOperand = node.leftOperand.IROperand;
                    else {
                        node.rightOperand.accept(this);
                        nodeOperand = node.rightOperand.IROperand;
                    }
                } else {
                    //需要短路运算
                    nodeOperand = doShortCircuit(node);
                }
            } else {
                if(node.leftOperand.IROperand instanceof BoolConstant){
                    if(((BoolConstant) node.leftOperand.IROperand).value) nodeOperand = node.leftOperand.IROperand;
                    else {
                        node.rightOperand.accept(this);
                        nodeOperand = node.rightOperand.IROperand;
                    }
                } else {
                    nodeOperand = doShortCircuit(node);
                }
            }
        } else {
            node.rightOperand.accept(this);
            if(opType == BinaryInst.IRBinaryOpType.assign){
                //赋值语句:把左操作数的Address取出,将新值存到左操作数的地址上.
                Value tmpAddress = getAddress(node.leftOperand);
                node.rightOperand.IROperand = reSetType(node.rightOperand.IROperand, tmpAddress.type.deReference());
                nodeOperand = node.rightOperand.IROperand;
                new StoreInst(curIRBlock, nodeOperand, tmpAddress);
            } else {
                //不是赋值操作:把结果存到新的地址上;
                Value lop, rop;
                node.leftOperand.accept(this);
                lop = node.leftOperand.IROperand; rop = node.rightOperand.IROperand;
                if(lop instanceof StringConstant) lop = getStringConstPtr(lop);
                if(rop instanceof StringConstant) rop = getStringConstPtr(rop);
                if(lop instanceof IRConstant && rop instanceof IRConstant) nodeOperand = calculateConst(node, (IRConstant) lop, (IRConstant) rop);
                else{//非常量作为运算数的情形
                    if(lop.type.isEqual(new PointerType(new IntegerType(8)))){
                        //string 类型作为操作数
                        nodeOperand = calculateString(node, lop, rop);
                    } else {
                        switch (opType) {
                            case eq, ne, sgt, sge, slt, sle -> {
                                rop = reSetType(rop, lop.type);
                                IcmpInst tmpInst = new IcmpInst(curIRBlock, opType, lop, rop);
                                nodeOperand = new ZextInst(curIRBlock, tmpInst, new BoolType());
                            }
                            case add, sub, mul, sdiv, srem, shl, ashr, and, or, xor -> nodeOperand = new BinaryInst(curIRBlock, opType, lop, rop);
                        }
                    }
                }
            }
        }
        node.IROperand = nodeOperand;
    }

    @Override
    public void visit(ThisExprNode node){
        if(!curScope.isValid) return;
        if(curClass == null){
            throw new RuntimeException("[visit thisExprNode]");
        }
        Value this_ptr = curScope.getValue("_this");
        node.IROperand = new LoadInst(curIRBlock, "_this", this_ptr);
    }
    @Override
    public void visit(BoolConstantExprNode node){
        if(!curScope.isValid) return;
        node.IROperand = new BoolConstant(node.value);
    }

    @Override
    public void visit(IntConstantExprNode node){
        if(!curScope.isValid) return;
        node.IROperand = new IntConstant(node.value);
    }

    @Override
    public void visit(NullExprNode node){
        if(!curScope.isValid) return;
        node.IROperand = new NullConstant();//类型后面用到的时候会确定下来
    }

    @Override
    public void visit(StringConstantExprNode node){
        if(!curScope.isValid) return;
        if(stringTable.get(node.value) == null){
            stringTable.put(node.value, new StringConstant(node.value));
            targetModule.stringConstantArrayList.add(stringTable.get(node.value));
        }
        node.IROperand = stringTable.get(node.value);
    }

    @Override public void visit(ArrayTypeNode node){}
    @Override public void visit(ClassTypeNode node){}
    @Override public void visit(VoidTypeNode node){}
    @Override public void visit(LambdaExprNode node){}
}