package FrontEnd;

import AST.*;
import Utils.GlobalScope;
import Utils.Position;
import Utils.Scope;
import Utils.SemanticError;

import java.util.ArrayList;
import java.util.Stack;

public class SemChecker implements ASTVisitor {
    public GlobalScope globalScope;
    public Scope curScope;
    public String curClass;
    public Stack<ASTNode> FuncStation;
    private final TypeNode TypeNull,TypeVoid,TypeInt,TypeBool,TypeString;
    int curLoops;

    public SemChecker(GlobalScope _globalScope){
        this.globalScope = _globalScope;
        this.curScope = _globalScope;
        this.TypeNull = new ClassTypeNode("null", new Position(-1, -1));
        this.TypeVoid = new VoidTypeNode(new Position(-1, -1));
        this.TypeInt = new ClassTypeNode("int", new Position(-1, -1));
        this.TypeBool = new ClassTypeNode("bool", new Position(-1, -1));
        this.TypeString = new ClassTypeNode("string", new Position(-1, -1));
        this.FuncStation = new Stack<>();
        this.curClass = null;
        this.curLoops = 0;
    }

    @Override
    public void visit(RootNode node){
        node.elements.forEach(ele -> ele.accept(this));
    }

    @Override
    public void visit(ClassDefNode node){
        curClass = node.classID;
        curScope = globalScope.ClassTable.get(curClass);
        for(VarDefStmtNode varStmt : node.memberVariable){
            for(VarDefNode singleVarDecl : varStmt.baseDecl){
                if(!globalScope.containsClass(singleVarDecl.variableType.typeID)){
                    throw new SemanticError("Undefined type.", singleVarDecl.pos);
                }
                if(singleVarDecl.initValue != null){
                    singleVarDecl.initValue.accept(this);
                    if(!singleVarDecl.initValue.exprType.isEqual(TypeNull) && !singleVarDecl.initValue.exprType.isEqual(varStmt.varType)){
                        throw new SemanticError("Unmatched type in variable declare.", singleVarDecl.pos);
                    }
                }
            }
        }
        node.memberFunctions.forEach(tmp -> tmp.accept(this));
        curClass = null;
        curScope = curScope.parent;
    }

    @Override
    public void visit(VarDefStmtNode node){
        node.baseDecl.forEach(tmp->tmp.accept(this));
    }

    @Override
    public void visit(VarDefNode node){
        if(curScope.containsVariable(node.variableID)){
            throw new SemanticError("Duplicate declare variable.", node.pos);
        }
        if(globalScope.containsClass(node.variableID)){
            throw new SemanticError("\"" + node.variableID + "\" is a identifier of class.", node.pos);
        }
        if(!globalScope.containsClass(node.variableType.typeID)){
            throw new SemanticError("Undefined variable type " + "\"" + node.variableType.typeID + "\"", node.pos);
        }
        if(node.initValue != null){
            node.initValue.accept(this);
            if(!node.initValue.exprType.isEqual(TypeNull) && !node.initValue.exprType.isEqual(node.variableType)){
                throw new SemanticError("Unmatched type in variable declare.", node.pos);
            }
        }
        curScope.defineVariable(node.variableID, node.variableType);
    }

    @Override
    public void visit(FuncDefNode node){
        //1.��麯�������Ƿ���ȷ(�Ƿ���ڻ�Ϊvoid);2.����Ƿ��з���ֵ���(��main��void����������return);3.Ϊmain�������Ĭ�ϵķ���ֵ���;
        //�Է������ļ�����visit returnStmtʱ����;
        FuncStation.push(node);
        curScope = new Scope(curScope);
        if(node.functionType != null && !globalScope.containsClass(node.functionType.typeID) && !node.functionType.isEqual(TypeVoid)){
            throw new SemanticError("Undefined function type.", node.pos);
        }
        if(node.parameterList != null){
            node.parameterList.forEach(tmp -> tmp.accept(this));
        }
        if(node.functionBody.stmtList != null){
            node.functionBody.stmtList.forEach(tmp -> tmp.accept(this));
        }
        if(node.functionType != null && !node.functionType.isEqual(TypeVoid) && !node.functionID.equals("main") && !node.hasReturn){
            throw new SemanticError("No return statement in no-void or main function", node.pos);
        }
        if(node.functionID.equals("main") && !node.hasReturn){
            if(node.functionBody.stmtList == null) node.functionBody.stmtList = new ArrayList<>();
            node.functionBody.stmtList.add(new ReturnStmtNode(new IntConstantExprNode(0, new Position(-1, -1)), new Position(-1, -1)));
        }
        FuncStation.pop();
        curScope = curScope.parent;
    }

    @Override
    public void visit(BlockStmtNode node){
        curScope = new Scope(curScope);
        if (node.stmtList != null){
            node.stmtList.forEach(tmp->tmp.accept(this));
        }
        curScope = curScope.parent;
    }

    @Override
    public void visit(IfStmtNode node){
        //1.condition ������bool����;
        if(node.condition == null){
            throw new SemanticError("Condition in if statement can't be empty.", node.pos);
        }
        node.condition.accept(this);
        if(!node.condition.exprType.isEqual(TypeBool)){
            throw new SemanticError("Condition isn't a bool value expression.", node.condition.pos);
        }
        if(node.thenStmt != null) {
            if(node.thenStmt instanceof BlockStmtNode) node.thenStmt.accept(this);
            else{
                curScope = new Scope(curScope);
                node.thenStmt.accept(this);
                curScope = curScope.parent;
            }
        }
        if(node.elseStmt != null) {
            if(node.elseStmt instanceof BlockStmtNode) node.elseStmt.accept(this);
            else {
                curScope = new Scope(curScope);
                node.elseStmt.accept(this);
                curScope = curScope.parent;
            }
        }
    }

    @Override
    public void visit(WhileStmtNode node){
        curLoops++;
        if(node.condition == null){
            throw new SemanticError("Condition in while statement can't be empty.", node.pos);
        }
        node.condition.accept(this);
        if(!node.condition.exprType.isEqual(TypeBool)){
            throw new SemanticError("Condition in while statement isn't a bool value.", node.condition.pos);
        }
        if(node.loopBody != null) {
            if(node.loopBody instanceof BlockStmtNode) node.loopBody.accept(this);
            else {
                curScope = new Scope(curScope);
                node.loopBody.accept(this);
                curScope = curScope.parent;
            }
        }
        curLoops--;
    }

    @Override
    public void visit(ForStmtNode node){
        //1.�ж�init�Ƿ�Ϊ��������֮һ;2.�ж�condition�Ƿ�Ϊbool;3.ע��forѭ����ѭ����������ռ�����;
        curLoops++;
        curScope = new Scope(curScope);
        if(node.init != null){
            if(!(node.init instanceof VarDefStmtNode) && !(node.init instanceof ExprStmtNode)){
                throw new SemanticError("Invalid statement in for init.", node.init.pos);
            }
            node.init.accept(this);
        }
        if(node.condition != null){
            node.condition.accept(this);
            if(!node.condition.exprType.isEqual(TypeBool)){
                throw new SemanticError("The condition in for isn't a bool value.", node.condition.pos);
            }
        }
        if(node.incrExpr != null){
            node.incrExpr.accept(this);
        }
        if(node.loopBody != null){
            if(node.loopBody instanceof BlockStmtNode){
                ((BlockStmtNode) node.loopBody).stmtList.forEach(tmp -> tmp.accept(this));
            }else{
                node.loopBody.accept(this);
            }
        }
        curLoops--;
        curScope = curScope.parent;
    }

    @Override
    public void visit(ReturnStmtNode node){
        //1.����Ƿ��ں�������;2.��鷵��ֵ�����Ƿ�ͺ�������һ��;
        if(FuncStation.size() == 0){
            throw new SemanticError("No return for a function.", node.pos);
        }
        if(FuncStation.peek() instanceof FuncDefNode){
            FuncDefNode curFunc = (FuncDefNode) FuncStation.peek();
            if(node.resValue == null){//return ;
                if(!curFunc.functionType.isEqual(TypeVoid) && curFunc.functionType != null){
                    throw new SemanticError("Invalid return value.", node.pos);
                }
            }else{//���캯��������return value;
                if(curFunc.functionType == null) throw new SemanticError("Construct function can't have a return value.", node.pos);
                node.resValue.accept(this);
                if(!curFunc.functionType.isEqual(node.resValue.exprType) && !node.resValue.exprType.isEqual(TypeNull)){
                    //TypeNull���Ը�������Type
                    throw new SemanticError("Return value is unmatched to function type.", node.pos);
                }
            }
            ((FuncDefNode) FuncStation.peek()).hasReturn = true;
        } else {
            LambdaExprNode curFunc = (LambdaExprNode) FuncStation.peek();
            if(node.resValue == null) curFunc.returnType = TypeVoid;
            else {
                node.resValue.accept(this);
                if(curFunc.returnType == null) curFunc.returnType = node.resValue.exprType;
                else if(!curFunc.returnType.isEqual(node.resValue.exprType)){
                    throw new SemanticError("Multiple return type.", node.pos);
                }
            }
        }
    }

    @Override
    public void visit(BreakStmtNode node){
        if(curLoops == 0) throw new SemanticError("\"break\" should occur in a loopbody.", node.pos);
    }

    @Override
    public void visit(ContinueStmtNode node){
        if(curLoops == 0) throw new SemanticError("\"continue\" should occur in a  loopbody.", node.pos);
    }

    @Override
    public void visit(ExprStmtNode node){
        node.expr.accept(this);
    }

    @Override
    public void visit(IdentifierExprNode node){
        TypeNode idType = curScope.getVariableType(node.identifier);
        if(idType == null){
            throw new SemanticError("Invalid identifier.", node.pos);
        }
        node.exprType = idType; node.isAssignment = true;
    }

    @Override
    public void visit(ObjectPortionExprNode node){
        //1.����������;2.�������һ��
        node.baseObject.accept(this);
        if(node.baseObject.exprType instanceof ArrayTypeNode){
            if(!node.forFunc){
                throw new SemanticError("Array type don't have members.", node.pos);
            }
            if(!node.member.equals("size")){
                throw new SemanticError("Array type only have function size().", node.pos);
            }
            node.funcInfo = new FuncDefNode(new ClassTypeNode("int", new Position(-1, -1)),"size",null,null, new Position(-1, -1));
        }else{
            if(!node.forFunc){
                node.exprType = globalScope.ClassTable.get(node.baseObject.exprType.typeID).getVariableType(node.member);
                if(node.exprType == null){
                    throw new SemanticError("Class" + "\""+ node.baseObject.exprType.typeID +"\"" + "has no member named " + "\"" + node.member + "\"", node.pos);
                }
                node.isAssignment = true;
            }else{
                node.funcInfo = globalScope.ClassTable.get(node.baseObject.exprType.typeID).getFunctionDef(node.member);
                if(node.funcInfo == null){
                    throw new SemanticError("Class" + "\""+ node.baseObject.exprType.typeID +"\"" + "has no function named " + "\"" + node.member + "\"", node.pos);
                }
            }
        }
    }

    @Override
    public void visit(AllocExprNode node){
        //1.��alloc��type�Ƿ����;2.������ά���Ƿ���int
        if(!globalScope.containsClass(node.allocType.typeID)){
            throw new SemanticError("Undefined type.", node.pos);
        }
        if(node.sizeList != null){
            node.sizeList.forEach(tmp  -> {
                tmp.accept(this);
                if(!tmp.exprType.isEqual(TypeInt)){
                    throw new SemanticError("Size should be a int value.", tmp.pos);
                }
            });
        }
        if(node.dimSize > 0) node.exprType = new ArrayTypeNode(node.allocType.typeID, node.dimSize, node.pos);
        else node.exprType = new ClassTypeNode(node.allocType.typeID, node.pos);
        node.isAssignment = false;
    }

    @Override
    public void visit(FuncCallExprNode node){
        //1.��麯���Ƿ����;2.��麯���Ĳ����б��Ƿ���Ϲ淶
        FuncDefNode funcBase;
        if(node.func instanceof ObjectPortionExprNode){//���Ա��������
            ((ObjectPortionExprNode) node.func).forFunc = true;
            node.func.accept(this);
            funcBase = ((ObjectPortionExprNode) node.func).funcInfo;
        }else{//ע�������л����ȵ�����ĳ�Ա����
            String funcID = ((IdentifierExprNode) node.func).identifier;
            if(curClass == null){
                if(!globalScope.containsFunction(funcID)){
                    throw new SemanticError("Undefined function[1].", node.pos);
                } else {
                    funcBase = globalScope.FunctionTable.get(funcID);
                }
            } else{
                funcBase = globalScope.ClassTable.get(curClass).getFunctionDef(funcID);
                if(funcBase == null){
                    funcBase = globalScope.getFunctionDef(funcID);
                }
                if(funcBase == null){
                    throw new SemanticError("Undefined function[2].", node.pos);
                }
            }
        }
        //
        if(node.parameterListForCall != null){
            node.parameterListForCall.forEach(tmp -> tmp.accept(this));
        }
        boolean isWrong = false;
        if((node.parameterListForCall == null && funcBase.parameterList != null)
            || (node.parameterListForCall != null && funcBase.parameterList == null)){
            isWrong = true;
        }else{//��ʱ������Ϊ�ջ��߶���Ϊ��;
            if(node.parameterListForCall != null){
                if(node.parameterListForCall.size() != funcBase.parameterList.size()) isWrong = true;
                else{
                    for(int i = 0; i < node.parameterListForCall.size(); ++i){
                        if(!funcBase.parameterList.get(i).variableType.isEqual(node.parameterListForCall.get(i).exprType)
                                && !node.parameterListForCall.get(i).exprType.isEqual(TypeNull)){
                            isWrong = true;
                            break;
                        }
                    }
                }
            }
        }
        if(isWrong){
            throw new SemanticError("Wrong parameter call list.", node.pos);
        }
        node.exprType = funcBase.functionType;
        node.isAssignment = false;
    }

    @Override
    public void visit(ArrayAccessNode node){
        //1.���base�Ƿ���ȷ;2.���index�Ƿ�Ϊint;
        //��һ·�ݹ鵽identifier����Ƿ����;
        node.array.accept(this);
        if(!(node.array.exprType instanceof ArrayTypeNode)){
            throw new SemanticError("Not a array type.", node.pos);
        }
        node.index.accept(this);
        if(!node.index.exprType.isEqual(TypeInt)){
            throw new SemanticError("Index is not a int value.", node.index.pos);
        }
        if(((ArrayTypeNode) node.array.exprType).dimSize == 1){
            node.exprType = new ClassTypeNode(node.array.exprType.typeID, node.pos);
        } else {
            node.exprType = new ArrayTypeNode(node.array.exprType.typeID, ((ArrayTypeNode) node.array.exprType).dimSize - 1, node.pos);
        }
        node.isAssignment = true;
    }

    @Override
    public void visit(MonocularOpExprNode node){
        //1.��ֵ���������Լ�; 2.Logic_Not ONLY for TypeBool; 3.other operator only for TypeInt;
        node.operand.accept(this);
        if(!node.operand.exprType.isEqual(TypeBool) && !node.operand.exprType.isEqual(TypeInt)){
            throw new SemanticError("Invalid type for monocular operator.", node.pos);
        }
        if(!node.operand.isAssignment
                && (node.opSymbol == MonocularOpExprNode.MonocularOpType.SINC || node.opSymbol == MonocularOpExprNode.MonocularOpType.SDER
                || node.opSymbol == MonocularOpExprNode.MonocularOpType.SINC_AFT || node.opSymbol == MonocularOpExprNode.MonocularOpType.SDER_AFT)){
            throw new SemanticError("Invalid operator for right value.", node.pos);
        }
        if(node.operand.exprType.isEqual(TypeBool) && node.opSymbol != MonocularOpExprNode.MonocularOpType.LOGIC_NOT){
            throw new SemanticError("Invalid operator for bool value.", node.pos);
        }
        if(node.operand.exprType.isEqual(TypeInt) && node.opSymbol == MonocularOpExprNode.MonocularOpType.LOGIC_NOT){
            throw new SemanticError("Invalid operator for int value.", node.pos);
        }
        node.exprType = node.operand.exprType;
        node.isAssignment = (node.opSymbol == MonocularOpExprNode.MonocularOpType.SDER || node.opSymbol == MonocularOpExprNode.MonocularOpType.SINC);
    }

    @Override
    public void visit(BinaryExprNode node){
        //1.notice: TypeNull ������ arrayType classType �� ASSIGN\EQ\NE ���������� ����
        //2.ASSIGN �������� operand1 ����Ϊ leftvalue
        //3.ADD,GT,LT,GE,LE : int\string valid;
        //4.SUB,MUL,DIV,MOD,SHL,SHR,AND,XOR,OR : int;
        //5.LAND,LOR : bool;
        //6.EQ,NE : ��������������� �� null��class\array
        node.leftOperand.accept(this);
        node.rightOperand.accept(this);
        node.isAssignment = false;
        if(node.opSymbol != BinaryExprNode.BinaryOpType.ASSIGN && node.opSymbol != BinaryExprNode.BinaryOpType.NE
        && node.opSymbol != BinaryExprNode.BinaryOpType.EQ && !node.leftOperand.exprType.isEqual(node.rightOperand.exprType)){
            throw new SemanticError("Unmatched operand type.", node.pos);
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.ADD || node.opSymbol == BinaryExprNode.BinaryOpType.GT
        || node.opSymbol == BinaryExprNode.BinaryOpType.LT || node.opSymbol == BinaryExprNode.BinaryOpType.GE
        || node.opSymbol == BinaryExprNode.BinaryOpType.LE){
            if(!node.leftOperand.exprType.isEqual(TypeInt) && !node.leftOperand.exprType.isEqual(TypeString)){
                throw new SemanticError("Invalid operand type. The type should be \"int\" or \"string\".", node.pos);
            }
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.SUB || node.opSymbol == BinaryExprNode.BinaryOpType.MUL
        || node.opSymbol == BinaryExprNode.BinaryOpType.DIV || node.opSymbol == BinaryExprNode.BinaryOpType.MOD
        || node.opSymbol == BinaryExprNode.BinaryOpType.SHL || node.opSymbol == BinaryExprNode.BinaryOpType.SHR
        || node.opSymbol == BinaryExprNode.BinaryOpType.AND || node.opSymbol == BinaryExprNode.BinaryOpType.XOR
        || node.opSymbol == BinaryExprNode.BinaryOpType.OR){
            if(!node.leftOperand.exprType.isEqual(TypeInt)){
                throw new SemanticError("Invalid operand type. The type should be \"int\".", node.pos);
            }
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.LAND || node.opSymbol == BinaryExprNode.BinaryOpType.LOR){
            if(!node.leftOperand.exprType.isEqual(TypeBool)){
                throw new SemanticError("Invalid operand type. The type should be \"bool\".", node.pos);
            }
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.ASSIGN){
            if(!node.leftOperand.isAssignment){
                throw new SemanticError("Left value can't be assigned in ASSIGN.", node.pos);
            }
            if(!node.leftOperand.exprType.isEqual(node.rightOperand.exprType) && !node.rightOperand.exprType.isEqual(TypeNull)){
                throw new SemanticError("Unmatched operand type in ASSIGN.", node.pos);
            }
            if(node.rightOperand.exprType.isEqual(TypeNull)){
                if(node.leftOperand.exprType.isEqual(TypeInt) || node.leftOperand.exprType.isEqual(TypeString)
                        || node.leftOperand.exprType.isEqual(TypeBool) || node.leftOperand.exprType.isEqual(TypeVoid)){
                    throw new SemanticError("Unmatched operand type in ASSIGN.", node.pos);
                }
            }
            node.isAssignment = true;
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.EQ || node.opSymbol == BinaryExprNode.BinaryOpType.NE){
            if(!node.leftOperand.exprType.isEqual(TypeNull) && !node.rightOperand.exprType.isEqual(TypeNull)){
                if(!node.leftOperand.exprType.isEqual(node.rightOperand.exprType)) throw new SemanticError("Unmatched operand type in NE or EQ.", node.pos);
            }
            if(node.leftOperand.exprType.isEqual(TypeNull)){
                if(node.rightOperand.exprType.isEqual(TypeInt) || node.rightOperand.exprType.isEqual(TypeString)
                        || node.rightOperand.exprType.isEqual(TypeBool) || node.rightOperand.exprType.isEqual(TypeVoid)){
                    throw new SemanticError("Unmatched type in NE or EQ.", node.pos);
                }
            } else if(node.rightOperand.exprType.isEqual(TypeNull)){
                if(node.leftOperand.exprType.isEqual(TypeInt) || node.leftOperand.exprType.isEqual(TypeString)
                    || node.leftOperand.exprType.isEqual(TypeBool) || node.leftOperand.exprType.isEqual(TypeVoid)){
                    throw new SemanticError("Unmatched type in NE or EQ.", node.pos);
                }
            }
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.GT || node.opSymbol == BinaryExprNode.BinaryOpType.LT || node.opSymbol == BinaryExprNode.BinaryOpType.GE
            || node.opSymbol == BinaryExprNode.BinaryOpType.LE || node.opSymbol == BinaryExprNode.BinaryOpType.EQ || node.opSymbol == BinaryExprNode.BinaryOpType.NE
            || node.opSymbol == BinaryExprNode.BinaryOpType.LAND || node.opSymbol == BinaryExprNode.BinaryOpType.LOR){
            node.exprType = TypeBool;
        }
        if(node.opSymbol == BinaryExprNode.BinaryOpType.ADD || node.opSymbol == BinaryExprNode.BinaryOpType.SUB || node.opSymbol == BinaryExprNode.BinaryOpType.MUL
            || node.opSymbol == BinaryExprNode.BinaryOpType.DIV || node.opSymbol == BinaryExprNode.BinaryOpType.MOD || node.opSymbol == BinaryExprNode.BinaryOpType.SHL
            || node.opSymbol == BinaryExprNode.BinaryOpType.SHR || node.opSymbol == BinaryExprNode.BinaryOpType.AND || node.opSymbol == BinaryExprNode.BinaryOpType.XOR
            || node.opSymbol == BinaryExprNode.BinaryOpType.OR || node.opSymbol == BinaryExprNode.BinaryOpType.ASSIGN){
            node.exprType = node.leftOperand.exprType;
        }
    }

    @Override
    public void visit(ThisExprNode node){
        if(curClass == null){
            throw new SemanticError("Not in a class.", node.pos);
        }
        node.exprType = new ClassTypeNode(curClass, node.pos);
        node.isAssignment = false;
    }

    @Override
    public void visit(LambdaExprNode node){
        curScope = new Scope(curScope);
        FuncStation.push(node);
        if(node.lambdaParameter != null) node.lambdaParameter.forEach(tmp -> tmp.accept(this));
        if(node.parameterForCall != null) node.parameterForCall.forEach(tmp -> tmp.accept(this));
        if(node.parameterForCall == null || node.lambdaParameter == null){
            if(!(node.parameterForCall == null && node.lambdaParameter == null)){
                throw new SemanticError("Unmatched parameter list in lambda expression.", node.pos);
            }
        } else {
            if(node.lambdaParameter.size() != node.parameterForCall.size()){
                throw new SemanticError("Unmatched parameter list in lambda expression.", node.pos);
            }
            for(int i = 0; i < node.lambdaParameter.size(); ++i){
                if(!node.lambdaParameter.get(i).variableType.isEqual(node.parameterForCall.get(i).exprType)){
                    throw new SemanticError("Unmatched parameter list in lambda expression.", node.pos);
                }
            }
        }
        node.funcBody.stmtList.forEach(tmp -> tmp.accept(this));
        if(node.returnType == null) node.exprType = TypeVoid;
        else node.exprType = node.returnType;
        node.isAssignment = false;
        FuncStation.pop();
        curScope = curScope.parent;
    }

    @Override public void visit(ArrayTypeNode node) {}
    @Override public void visit(BoolConstantExprNode node) {}
    @Override public void visit(ClassTypeNode node) {}
    @Override public void visit(IntConstantExprNode node) {}
    @Override public void visit(NullExprNode node) {}
    @Override public void visit(StringConstantExprNode node) {}
    @Override public void visit(VoidTypeNode node) {}

}
