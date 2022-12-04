package MiddleEnd;

import AST.*;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.Compound.IRBasicBlock;
import MiddleEnd.Compound.IRFunction;
import MiddleEnd.Compound.IRModule;
import MiddleEnd.Instruction.*;
import MiddleEnd.Operand.*;
import MiddleEnd.Tools.IRScope;
import MiddleEnd.TypePackage.*;
import Utils.GlobalScope;
import Utils.Scope;

import java.util.*;

public class IRBuilder implements ASTVisitor {
    //name space:
    public GlobalScope globalScope;
    public IRScope curScope;
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

    //stack for loops:用来记录continue和break跳转到的basicBlock是哪一个
    private Stack<IRBasicBlock> loopContinue;
    private Stack<IRBasicBlock> loopBreak;

    private IRType getType(TypeNode node){//通过node返回IRType,如果是arrayType那么type应该是pointerType
        if(node == null) return typeTable.get("void");
        IRType res = typeTable.get(node.typeID);
        if(node instanceof ArrayTypeNode){
            res = new PointerType(res, ((ArrayTypeNode) node).dimSize);
        }
        return res;
    }

    private Value getStringConstPtr(Value _value){
        //targetType应该是指向char的一个指针类型:
        GepInst ptr = new GepInst(curIRBlock, new PointerType(new IntegerType(8)), _value);
        ptr.addIndex(new IntConstant(0)).addIndex(new IntConstant(0));
        return ptr;
    }

    private Value getAddress(ASTNode node){
        if(node instanceof IdentifierExprNode){
            String id = ((IdentifierExprNode) node).identifier;
            Value resValue = curScope.getValue(id);
            if(curScope.isClass(id)){
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
            GepInst resValue = new GepInst(curIRBlock, new PointerType((baseType.typeTable.get(((ObjectPortionExprNode) node).member))), baseAddress);
            return resValue;
        }
        if(node instanceof ArrayAccessNode){
            //todo
        }
        if(node instanceof MonocularOpExprNode){
            return getAddress(((MonocularOpExprNode) node).operand);
        }
        System.out.println("[Bug] getAddress wrong!");
        throw new RuntimeException("[Bug] getAddress wrong!");
    }

    private AllocInst stackAlloc(IRType _type, String _name){
        //用于在函数的entry_block处进行alloc指令
        return new AllocInst(curIRFunction.getEntryBlock(), _type, _name);
    }

    private void addControl(IRBasicBlock _conditionBlock, Value _condition, IRBasicBlock _trueBlock, IRBasicBlock _falseBlock){
        //包装Trunc指令和Branch指令，使调用更方便
        Value _cond = new TruncInst(_conditionBlock, _condition, new IntegerType(1));
        new BranchInst(_conditionBlock, _cond, _trueBlock, _falseBlock);
    }

    private void reSetType(Value curValue, IRType targetType){
        if(curValue instanceof StringConstant) curValue = getStringConstPtr(curValue);
        if(curValue instanceof NullConstant) ((NullConstant) curValue).setType(targetType);
    }

    public IRBuilder(GlobalScope _globalScope, IRModule _module){
        this.globalScope = _globalScope;
        this.curScope = new IRScope(null, IRScope.scopeType.Global);
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
            FunctionType funcType = new FunctionType(getType(funcNode.functionType));
            if(funcNode.parameterList != null){
                for(int i = 0; i < funcNode.parameterList.size(); ++i){
                    IRType paraType = getType(funcNode.parameterList.get(i).variableType);
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
                classScope.VariableTable.forEach((ID, tmpTy) -> ((StructType)curType).addMember(ID, getType(tmpTy)));
            }
            for(Map.Entry<String, FuncDefNode> FuncIter : classScope.FunctionTable.entrySet()){
                //add member function:
                String funcName = FuncIter.getKey();
                FuncDefNode funcNode = FuncIter.getValue();
                IRType returnTy = getType(funcNode.functionType);
                FunctionType funcType = new FunctionType(returnTy);
                IRType tmpArgTy = new PointerType(curType).deReference();
                //添加 this 指针
                funcType.addParameter(tmpArgTy, "_this");
                if(funcNode.parameterList != null){
                    for(VarDefNode _tmp:funcNode.parameterList){
                        tmpArgTy = getType(_tmp.variableType);
                        funcType.addParameter(tmpArgTy, _tmp.variableID);
                    }
                }
                IRFunction _newMemberFunc = new IRFunction("_class_"+ className + "_" + funcName, funcType);
                if(funcNode.isBuildIn) _newMemberFunc.isBuiltin = true;
                funcTable.put(_newMemberFunc.name, _newMemberFunc);
                targetModule.addFunction(_newMemberFunc);
            }
            //添加默认构造函数
            if(!className.equals("string") && funcTable.get("_class" + className + "_" + className) == null){
                FunctionType funcType = new FunctionType(new VoidType());
                IRType tmpArgType = new PointerType(curType);
                funcType.addParameter(tmpArgType, "_this");
                IRFunction defaultConstructionFunc = new IRFunction("_class_" + className + "_" + className, funcType);
                defaultConstructionFunc.addOperand(new Value("_arg", tmpArgType));
                IRBasicBlock newBlock = new IRBasicBlock(defaultConstructionFunc.name, defaultConstructionFunc);
                new RetInst(newBlock, new Value("voidrestype", new VoidType()));
                funcTable.put(defaultConstructionFunc.name, defaultConstructionFunc);
                targetModule.addFunction(defaultConstructionFunc);
            }
        }
        node.elements.forEach(_ele -> _ele.accept(this));
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
        IRBasicBlock entryBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);
        IRBasicBlock returnBlock = new IRBasicBlock(curIRFunction.name, curIRFunction);
        FunctionType funcType = (FunctionType) curIRFunction.type;//返回值转为funcType
        Value funcResValue = null;
        if(!funcType.toString().equals("void")){
            curIRFunction.resAddress = stackAlloc(funcType.resType, "_return");
            funcResValue = new LoadInst(curIRFunction.getReturnBlock(), "_return", curIRFunction.resAddress);
        } else {
            funcResValue = new Value("voidrestype", new VoidType());
        }
        new RetInst(curIRFunction.getReturnBlock(), funcResValue);//这里设置
        curIRBlock = curIRFunction.getEntryBlock();
        //add parameters into entryBlock:
        if(node.parameterList != null){
            for(int i = 0; i < funcType.parameterNameList.size(); ++i){
                String tmpParaName = funcType.parameterNameList.get(i);
                IRType tmpParaType = funcType.parameterTypeList.get(i);
                Value tmpArg = new Value("_arg", tmpParaType);
                curIRFunction.addOperand(tmpArg);
                AllocInst localPara = stackAlloc(tmpParaType, tmpParaName);
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
        IRType curType = getType(node.variableType);
        Value curIRValue = null;
        if(curScope.parentScope == null){//global def:
            curIRValue = new GlobalDefInst(curType, node.variableID);
            targetModule.addGlobalDef((GlobalDefInst) curIRValue);
            curScope.putValue(node.variableID, curIRValue);
            node.IROperand = curIRValue;
            if(node.initValue != null || node.variableType instanceof ArrayTypeNode){
                globalDefNodeList.add(node);
            }
        } else {//local def:
            curIRValue = stackAlloc(curType, node.variableID);
            curScope.putValue(node.variableID, curIRValue);
            node.IROperand = curIRValue;
            if(node.initValue != null){
                node.initValue.accept(this);
                Value curInitValue = node.initValue.IROperand;
                reSetType(curInitValue, curType);
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
        addControl(conditionBlock, node.condition.IROperand, whileBodyBlock, terminalBlock);
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
        loopContinue.push(incrBlock);
        loopBreak.push(terminalBlock);
        if(node.init != null){
            node.init.accept(this);
        }
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = conditionBlock;
        if(node.condition != null){
            node.condition.accept(this);
            addControl(curIRBlock, node.condition.IROperand, forBodyBlock, terminalBlock);
        }
        else {
            new BranchInst(curIRBlock, forBodyBlock);
        }
        curIRBlock = incrBlock;
        if(node.incrExpr != null){
            node.incrExpr.accept(this);
        }
        new BranchInst(curIRBlock, conditionBlock);
        curIRBlock = forBodyBlock;
        if(node.loopBody != null){
            node.loopBody.accept(this);
        }
        new BranchInst(curIRBlock, incrBlock);
        curIRBlock = terminalBlock;
        loopContinue.pop();
        loopBreak.pop();
        curScope = curScope.upRoot();
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
        //todo:
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
            //todo : 成员函数的调用
        }
        if(nodeFunc == null){
            throw new RuntimeException("[Bug] node func is null.");
        }else{nodeFunc.isUsed = true;}
        //add args:
        if(node.parameterListForCall != null){
            for(int i = 0; i < node.parameterListForCall.size(); ++i){
                node.parameterListForCall.get(i).accept(this);
                Value arg = node.parameterListForCall.get(i).IROperand;

                reSetType(arg, ((FunctionType)nodeFunc.type).parameterTypeList.get(i));
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
        LoadInst loadInst = new LoadInst(curIRBlock, "_array", targetAddress);
        node.IROperand = loadInst;
    }

    @Override
    public void visit(MonocularOpExprNode node){
        if(!curScope.isValid) return;
        node.operand.accept(this);
        Value oldNodeOperand = oldNodeOperand = node.operand.IROperand, valueAddress = null;
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
            case POS -> {//do nothing:
                node.IROperand = oldNodeOperand;
            }
            case NEG -> {
                if(oldNodeOperand instanceof IRConstant) node.IROperand = new IntConstant(-((IntConstant) oldNodeOperand).value);
                else node.IROperand = new BinaryInst(curIRBlock, BinaryInst.IRBinaryOpType.sub,new IntConstant(0), oldNodeOperand);
            }
        }
    }

    @Override
    public void visit(BinaryExprNode node){
        if(!curScope.isValid) return;
        //todo
    }

    @Override public void visit(ArrayTypeNode node){}

    @Override public void visit(BoolConstantExprNode node){}

    @Override public void visit(ClassTypeNode node){}

    @Override public void visit(IntConstantExprNode node){}

    @Override public void visit(NullExprNode node){}

    @Override public void visit(StringConstantExprNode node){}

    @Override public void visit(ThisExprNode node){}

    @Override public void visit(VoidTypeNode node){}

    @Override public void visit(LambdaExprNode node){}
}