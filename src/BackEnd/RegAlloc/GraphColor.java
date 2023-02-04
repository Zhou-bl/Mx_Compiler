package BackEnd.RegAlloc;

import BackEnd.Compound.ASMBlock;
import BackEnd.Compound.ASMFunction;
import BackEnd.Compound.ASMModule;
import BackEnd.Instruction.*;
import BackEnd.Operand.Imm;
import BackEnd.Operand.PhysicalRegister;
import BackEnd.Operand.VirtualRegister;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class GraphColor {
    static final int K = 25;
    public ASMModule targetModule;
    public HashSet<String> physicalRegisterSet;
    public HashSet<Pair<String, String>> conflictCheck;
    //邻接表存储图:
    public HashMap<String, HashSet<String>> conflictGraph;
    public HashMap<String,Integer> degree;
    public HashMap<String,Integer> weight;

    public HashMap<String,HashSet<MoveInstruction>> move_list;
    public HashSet<MoveInstruction> worklist_move;
    public HashSet<MoveInstruction> active_move;
    public HashSet<MoveInstruction> constrained_move;
    public HashSet<MoveInstruction> coalesced_move;
    public HashSet<MoveInstruction> frozen_move;

    public HashSet<String> initial;
    public HashMap<String,String> alias;
    public HashMap<String,Integer> color;

    public HashSet<String> simplify_worklist;
    public HashSet<String> freeze_worklist;
    public HashSet<String> spill_worklist;

    public Stack<String> select_stack;
    public HashSet<String> coalesced_nodes;
    public HashSet<String> colored_nodes;
    public HashSet<String> spilled_nodes;

    public GraphColor(ASMModule _targetModule){
        targetModule = _targetModule;
        physicalRegisterSet = new HashSet<>(PhysicalRegister.regName);
        for(int i = 0; i < targetModule.ASMFunctionArrayList.size(); ++i){
            ASMFunction curFunc = targetModule.ASMFunctionArrayList.get(i);
            process(curFunc);
            regAlloc(curFunc);
        }
    }

    private void addEdge(String u, String v){
        if(u.equals(v) || conflictCheck.contains(new Pair<>(u, v)) ) return;
        conflictCheck.add(new Pair<>(u, v));
        conflictCheck.add(new Pair<>(v, u));
        //对非物理寄存器进行建图:
        if(!physicalRegisterSet.contains(u)){
            //u -> v
            conflictGraph.get(u).add(v);
            degree.replace(u, degree.get(u) + 1);
        }
        if(!physicalRegisterSet.contains(v)){
            //v -> u
            conflictGraph.get(v).add(u);
            degree.replace(v, degree.get(v) + 1);
        }
    }

    private void clearWorkCookie(){
        conflictCheck = new HashSet<>();
        conflictGraph = new HashMap<>();
        degree = new HashMap<>();
        weight = new HashMap<>();
        move_list = new HashMap<>();
        worklist_move = new HashSet<>();
        active_move = new HashSet<>();
        constrained_move = new HashSet<>();
        coalesced_move = new HashSet<>();
        frozen_move = new HashSet<>();
        initial = new HashSet<>();
        alias = new HashMap<>();
        color = new HashMap<>();
        simplify_worklist = new HashSet<>();
        freeze_worklist = new HashSet<>();
        spill_worklist = new HashSet<>();
        select_stack = new Stack<>();
        coalesced_nodes = new HashSet<>();
        colored_nodes = new HashSet<>();
        spilled_nodes = new HashSet<>();
        for(int i = 0; i < 32; ++i){
            color.put(PhysicalRegister.regName.get(i), i);
        }
    }

    private boolean check(String x, String y){
        return degree.get(x) < K || physicalRegisterSet.contains(x) || conflictCheck.contains(new Pair<>(x,y));
    }

    private boolean moveRelated(String operandName){
        return nodeMoves(operandName).size() != 0;
    }

    private HashSet<MoveInstruction> nodeMoves(String operandName){
        HashSet<MoveInstruction> retVal = new HashSet<>(worklist_move);
        retVal.addAll(active_move);
        retVal.retainAll(move_list.get(operandName));
        return retVal;
    }
    private HashSet<String> removedStack(String operandName){
        //将所有stack中的元素从operandName对应的operand集合中去除:
        HashSet<String> resSet = new HashSet<>();
        resSet.addAll(conflictGraph.get(operandName));
        resSet.removeAll(select_stack);
        resSet.removeAll(coalesced_nodes);
        return resSet;
    }

    private void subDegree(String operandName){
        int originDegree = degree.get(operandName);
        degree.replace(operandName, originDegree - 1);
        //对于临界情况:原来的度数为 K （无法着色）的operand,度数减少后可以着色
        //将operandName放入可着色点的集合内
        if(originDegree == K){
            HashSet<String > tmp = new HashSet<>();
            tmp.addAll(conflictGraph.get(operandName));
            tmp.add(operandName);
            //将tmp中所有点放入worklist:
            for(String curOperandName:tmp){
                HashSet<MoveInstruction> ttmp = new HashSet<>(worklist_move);
                ttmp.addAll(active_move);
                ttmp.retainAll(move_list.get(curOperandName));
                ttmp.forEach(ele -> {
                    if(active_move.contains(ele)){
                        active_move.remove(ele);
                        worklist_move.add(ele); }
                });
            }
            spill_worklist.remove(operandName);
            if(moveRelated(operandName)) {
                freeze_worklist.add(operandName);
            } else {
                simplify_worklist.add(operandName);
            }
        }
    }

    private boolean conservative(HashSet<String> nodes){
        int cnt = 0;
        for(String regName : nodes){
            if(degree.get(regName) >= K) cnt += 1;
        }
        return cnt < K;
    }

    private void doSimplify(){
        String curEle = simplify_worklist.iterator().next();
        select_stack.push(curEle);
        simplify_worklist.remove(curEle);
        HashSet<String> res = removedStack(curEle);
        res.forEach(ele -> subDegree(ele));
    }

    private String getAlias(String node){
        return coalesced_nodes.contains(node) ? getAlias(alias.get(node)) : node;
    }

    private void addWorkList(String regName){
        if((!physicalRegisterSet.contains(regName)) && (!moveRelated(regName)) && degree.get(regName) < K){
            freeze_worklist.remove(regName);
            simplify_worklist.add(regName);
        }
    }
    private void coalescing(){
        //合并结点消除死代码:
        MoveInstruction curEle = worklist_move.iterator().next();
        worklist_move.remove(curEle);
        String x = getAlias(curEle.rd.getName()), y = getAlias(curEle.rs1.getName()),u,v;
        if(physicalRegisterSet.contains(y)){
            u = y;
            v = x;
        }else{
            u = x;
            v = y;
        }
        if(u.equals(v)){
            coalesced_move.add(curEle);
            addWorkList(u);
        }else if(physicalRegisterSet.contains(v) || conflictCheck.contains(new Pair<>(u,v))){
            constrained_move.add(curEle);
            addWorkList(u);
            addWorkList(v);
        }else{
            boolean flag = true;//用George算法判断是否可以进行凝聚:
            if(physicalRegisterSet.contains(u)){
                for(String tmp : removedStack(v)){
                    //George:
                    //对于x,y: y的每个相邻结点 t 有:
                    //1. degree(t) < K
                    //或 2.t 与 x 冲突
                    //或 3.t 已被 assign 为 physical reg
                    if(!check(tmp,u)){
                        flag = false;
                        break;
                    }
                }
            } else {
                HashSet<String> tmp = removedStack(u);
                tmp.addAll(removedStack(v));
                if(!conservative(tmp)) flag = false;
            }
            if(flag){
                coalesced_move.add(curEle);
                //合并 u, v:
                if(freeze_worklist.contains(v)) freeze_worklist.remove(v);
                else spill_worklist.remove(v);
                coalesced_nodes.add(v);
                alias.put(v,u);
                move_list.get(u).addAll(move_list.get(v));
                removedStack(v).forEach(operandName->{
                    addEdge(operandName,u);
                    subDegree(operandName);
                });
                if(degree.get(u) >= K && freeze_worklist.contains(u)){
                    freeze_worklist.remove(u);
                    spill_worklist.add(u);
                }
                addWorkList(u);
            } else {
                active_move.add(curEle);
            }
        }
    }

    private void freezeMove(String u){
        for(MoveInstruction inst : nodeMoves(u)){
            String v;
            if(getAlias(u).equals(getAlias(inst.rs1.getName()))) v = getAlias(inst.rd.getName());
            else v = getAlias(inst.rs1.getName());
            active_move.remove(inst);
            frozen_move.add(inst);
            if(nodeMoves(v).size() == 0 && degree.get(v) < K){
                freeze_worklist.remove(v);
                simplify_worklist.add(v);
            }
        }
    }

    private void freeze(){
        String curEle = freeze_worklist.iterator().next();
        freeze_worklist.remove(curEle);
        simplify_worklist.add(curEle);
        freezeMove(curEle);
    }

    private void spill(){
        //以 weight / degree 作为权重:
        String toSpill = null;
        double min = Integer.MAX_VALUE;
        for(String candidate : spill_worklist){
            if(degree.get(candidate) == 0) continue;
            double curValue = 1.0 * weight.get(candidate) / degree.get(candidate);
            if(min > curValue){
                min = curValue;
                toSpill = candidate;
            }
        }
        spill_worklist.remove(toSpill);
        simplify_worklist.add(toSpill);
        freezeMove(toSpill);
    }

    public void calculateLiveRange(ASMFunction curFunc){
        //计算live range:
        //1.先把每个basic block中的def use记录下来
        HashMap<ASMBlock, HashSet<String>> block_def = new HashMap<>(), block_use = new HashMap<>();
        for(ASMBlock curBlock : curFunc.blockArrayList){
            HashSet<String> curBlock_def = new HashSet<>(), curBlock_use = new HashSet<>();
            for(ASM_Instruction curInst : curBlock.instructionList){
                curInst.useArrayList.forEach(use_ele -> {
                    //如果在def中有的，就不会重复添加
                    if(curBlock_def.contains(use_ele)) return;
                    curBlock_use.add(use_ele);
                });
                curBlock_def.addAll(curInst.defArrayList);
            }
            block_use.put(curBlock, curBlock_use);
            block_def.put(curBlock, curBlock_def);
        }
        //对每个基本块上分析live range:
        HashMap<ASMBlock,HashSet<String>> block_liveIn = new HashMap<>(), block_liveOut = new HashMap<>();
        for (ASMBlock curBlock : curFunc.blockArrayList){
            block_liveIn.put(curBlock, new HashSet<>());
            block_liveOut.put(curBlock, new HashSet<>());
        }
        while(true){
            boolean flag = true;
            for(int i = curFunc.blockArrayList.size() - 1;i >= 0;--i){
                ASMBlock bb = curFunc.blockArrayList.get(i);
                HashSet<String> tmp_out = new HashSet<>();
                bb.successorArrayList.forEach(tmpbb->tmp_out.addAll(block_liveIn.get(tmpbb)));
                int check_out_new = tmp_out.size(),check_out_old = block_liveOut.get(bb).size();
                block_liveOut.replace(bb,tmp_out);
                HashSet<String> tmp_in = new HashSet<>(block_use.get(bb));
                HashSet<String> tmp_set = new HashSet<>(tmp_out);
                tmp_set.removeAll(block_def.get(bb));
                tmp_in.addAll(tmp_set);
                int check_in_new = tmp_in.size(),check_in_old = block_liveIn.get(bb).size();
                block_liveIn.replace(bb,tmp_in);
                flag = flag && (check_in_new == check_in_old) && (check_out_new == check_out_old);
            }
            if(flag) break;
        }
        //建图
        for(ASMBlock bb : curFunc.blockArrayList){
            HashSet<String> inst_out = block_liveOut.get(bb);
            for(int i = bb.instructionList.size() - 1;i >= 0;--i){
                ASM_Instruction inst = bb.instructionList.get(i);
                // calculate weight
                inst.useArrayList.forEach(tmp->{
                    if(!physicalRegisterSet.contains(tmp)) weight.replace(tmp,weight.get(tmp)+1);
                });
                inst.defArrayList.forEach(tmp->{
                    if(!physicalRegisterSet.contains(tmp)) weight.replace(tmp,weight.get(tmp)+1);
                });

                if(inst instanceof MoveInstruction){
                    inst.useArrayList.forEach(inst_out::remove);
                    inst.useArrayList.forEach(tmp->move_list.get(tmp).add((MoveInstruction) inst));
                    inst.defArrayList.forEach(tmp->move_list.get(tmp).add((MoveInstruction) inst));
                    worklist_move.add((MoveInstruction) inst);
                }
                inst.defArrayList.forEach(tmpu-> inst_out.forEach(tmpv -> addEdge(tmpu,tmpv)));
                inst.defArrayList.forEach(inst_out::remove);
                inst_out.addAll(inst.useArrayList);
            }
        }
    }

    private void coloring(){
        while(!select_stack.empty()){
            String toAssign = select_stack.pop();
            ArrayList<Integer> okColors = new ArrayList<>();
            for(int i = 31;i >= 5;--i) okColors.add(i);
            okColors.add(1); // ra ; 28 physical register
            conflictGraph.get(toAssign).forEach(w->{
                String tmp = getAlias(w);
                if(colored_nodes.contains(tmp) || physicalRegisterSet.contains(tmp)) okColors.remove(color.get(tmp));
            });
            if(okColors.size() == 0) spilled_nodes.add(toAssign);
            else{
                colored_nodes.add(toAssign);
                boolean assigned = false; // for assign callerSaved in priority
                for (int futureColor : okColors) {
                    if (PhysicalRegister.callerSaved_check.contains(futureColor)) {
                        assigned = true;
                        color.put(toAssign, futureColor);
                        break;
                    }
                }
                if(!assigned){ // only callee saved
                    color.put(toAssign,okColors.get(0));
                }
            }
        }
        coalesced_nodes.forEach(regName->color.put(regName,color.get(getAlias(regName))));
    }


    private void rewrite(ASMFunction func){
        HashMap<String,Integer> subTable = new HashMap<>();
        spilled_nodes.forEach(regName->{
            int offset = func.allocStack().value;
            subTable.put(regName,offset);
        });
        for(ASMBlock bb : func.blockArrayList){
            LinkedList<ASM_Instruction> writtenInst = new LinkedList<>();
            for(ASM_Instruction inst : bb.instructionList){
                for(int i = 0;i < inst.useArrayList.size();++i){
                    String regName = inst.useArrayList.get(i);
                    if(spilled_nodes.contains(regName)){
                        int offset = subTable.get(regName);
                        assert offset >= 0;
                        VirtualRegister tmpReg = new VirtualRegister(func.virtualIndex++);
                        if(offset < 2048){
                            ASM_Instruction newInstr = new LoadInstruction(null,"lw");
                            newInstr.addOperand(tmpReg,new VirtualRegister(func.virtualIndex++, 8, new Imm(-offset)));
                            writtenInst.add(newInstr);
                        }else{  // previous li add load
                            VirtualRegister tmpAddress = new VirtualRegister(func.virtualIndex++);
                            writtenInst.add(new LiInstruction(null).addOperand(tmpAddress,new Imm(-offset)));
                            writtenInst.add(new ArithInstruction(null, "add").addOperand(tmpAddress,new PhysicalRegister("s0"),tmpAddress));
                            writtenInst.add(new LoadInstruction(null,"lw").addOperand(tmpReg,tmpAddress));
                        }
                        inst.renameUse(regName,tmpReg);
                    }
                }
                writtenInst.add(inst);
                for(String regName : inst.defArrayList){
                    if(spilled_nodes.contains(regName)){
                        int offset = subTable.get(regName);
                        assert offset >= 0;
                        VirtualRegister tmpReg = new VirtualRegister(func.virtualIndex++);
                        if(offset < 2048){
                            ASM_Instruction newInstr = new StoreInstruction(null,"sw");
                            newInstr.addOperand(tmpReg,new VirtualRegister(func.virtualIndex++,8, new Imm(-offset)));
                            writtenInst.add(newInstr);
                        }else{
                            VirtualRegister tmpAddress = new VirtualRegister(func.virtualIndex++);
                            writtenInst.add(new LiInstruction(null).addOperand(tmpAddress,new Imm(-offset)));
                            writtenInst.add(new ArithInstruction(null, "add").addOperand(tmpAddress,new PhysicalRegister("s0"),tmpAddress));
                            writtenInst.add(new StoreInstruction(null,"sw").addOperand(tmpReg,tmpAddress));
                        }
                        inst.renameDef(regName,tmpReg);
                    }
                }
            }
            bb.instructionList = writtenInst;
        }
    }

    public void process(ASMFunction curFunc){
        //分析变量的live range
        //1.构造冲突图，若两个变量的live range有重叠，则连一条边,其中live range定义为:"变量第一次被定义(赋值)到该变量下一次被赋值前的最后一次使用."
        //利用 ASM_Instruction 类里面的 use and def list 进行live range的计算.
        //2.启发式算法进行图染色

        //对curFunc预处理:
        clearWorkCookie();
            //把所有的operand放到init里面:
        for(int i = 0; i < curFunc.blockArrayList.size(); ++i){
            ASMBlock curBlock = curFunc.blockArrayList.get(i);
            for(int j = 0; j < curBlock.instructionList.size(); ++j){
                ASM_Instruction curInst = curBlock.instructionList.get(i);
                initial.addAll(curInst.defArrayList);
                initial.addAll(curInst.useArrayList);
            }
        }
        for(String operandRegName:initial){
            //已经是确定的物理寄存器无法进行分配，将权值和度数赋为无穷
            //若不是物理寄存器则初始化为0
            if(physicalRegisterSet.contains(operandRegName)){
                weight.put(operandRegName, Integer.MAX_VALUE);
                degree.put(operandRegName, Integer.MAX_VALUE);
            } else {
                weight.put(operandRegName, 0);
                degree.put(operandRegName, 0);
            }
        }
        for (String operandRegName:initial){
            conflictGraph.put(operandRegName, new HashSet<>());
            move_list.put(operandRegName, new HashSet<>());
            alias.put(operandRegName, null);
        }
        //已经确定的物理寄存器不参与分配:
        initial.removeAll(physicalRegisterSet);
        //分析变量的live range 并 构造冲突图:
        calculateLiveRange(curFunc);
        while(true){
            if(!simplify_worklist.isEmpty()) doSimplify();
            else if(!worklist_move.isEmpty()) coalescing();//寄存器 "凝聚" : 消除死代码，将不同的 node 分配到同一个寄存器
            //凝聚之后凝聚点的度数增加，可能导致无法进行图染色，那么需要 选取合适的结点 spill到内存中
            else if(!frozen_move.isEmpty()) freeze();
            else if(!spill_worklist.isEmpty()) spill();
            else break;
        }
        coloring();
        if(spilled_nodes.size() != 0){
            rewrite(curFunc);
            process(curFunc);
        }
    }

    private void regAlloc(ASMFunction func){
        assert spilled_nodes.size() == 0;
        for(ASMBlock bb : func.blockArrayList){
            LinkedList<ASM_Instruction> newList = new LinkedList<>();
            for(ASM_Instruction inst : bb.instructionList){
                if(inst instanceof MoveInstruction){
                    if(Objects.equals(color.get(inst.rd.getName()), color.get(inst.rs1.getName()))) continue;
                }
                if(inst.rd instanceof VirtualRegister){
                    VirtualRegister vReg = (VirtualRegister) inst.rd;
                    Integer finalColor = color.get(vReg.getName());
                    assert finalColor != null;
                    inst.rd = new PhysicalRegister(vReg, finalColor);
                }
                if(inst.rs1 instanceof VirtualRegister){
                    VirtualRegister vReg = (VirtualRegister) inst.rs1;
                    Integer finalColor = color.get(vReg.getName());
                    assert finalColor != null;
                    inst.rs1 = new PhysicalRegister(vReg, finalColor);
                }
                if(inst.rs2 instanceof VirtualRegister){
                    VirtualRegister vReg = (VirtualRegister) inst.rs2;
                    Integer finalColor = color.get(vReg.getName());
                    assert finalColor != null;
                    inst.rs2 = new PhysicalRegister(vReg, finalColor);
                }
                newList.add(inst);
            }
            bb.instructionList = newList;
        }
        //与栈分配一样:
        LinkedList<ASM_Instruction> entryList = func.getEntryBlock().instructionList;
        LinkedList<ASM_Instruction> exitList = func.getExitBlock().instructionList;
        int offset = func.stackSize;
        if(offset < 2048){
            entryList.addFirst(new ArithInstruction(null, "add").addOperand(
                    new PhysicalRegister("s0"),new PhysicalRegister("sp"),new Imm(offset)));
            entryList.addFirst(new ArithInstruction(null, "add")
                    .addOperand(new PhysicalRegister("sp"),new PhysicalRegister("sp"),new Imm(-offset)));
            exitList.addLast(new ArithInstruction(null, "add")
                    .addOperand(new PhysicalRegister("sp"),new PhysicalRegister("sp"),new Imm(offset)));
        }else{
            entryList.addFirst(new ArithInstruction(null, "sub").addOperand(
                    new PhysicalRegister("s0"),new PhysicalRegister("sp"),new PhysicalRegister("t0")));
            entryList.addFirst(new ArithInstruction(null, "add")
                    .addOperand(new PhysicalRegister("sp"),new PhysicalRegister("sp"),new PhysicalRegister("t0")));
            entryList.addFirst(new LiInstruction(null).addOperand(new PhysicalRegister("t0"),new Imm(-offset)));
            exitList.addLast(new LiInstruction(null).addOperand(new PhysicalRegister("t0"),new Imm(offset)));
            exitList.addLast(new ArithInstruction(null, "add")
                    .addOperand(new PhysicalRegister("sp"),new PhysicalRegister("sp"),new PhysicalRegister("t0")));
        }
        entryList.addFirst(new StoreInstruction(null,"sw").addOperand(
                new PhysicalRegister("s0"),new PhysicalRegister("sp",new Imm(-4))));
        exitList.addLast(new LoadInstruction(null,"lw").addOperand(
                new PhysicalRegister("s0"),new PhysicalRegister("sp",new Imm(-4))));
        exitList.addLast(new RetInstruction(null));
    }

}
