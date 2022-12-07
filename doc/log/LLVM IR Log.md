# LLVM IR Log

## 开始写 Type

1. BoolType 为 i8 类型，占用一个字节。

2. PointerType 用于对全局变量和在堆空间中 new 出来的变量进行操作。由 c++ 指针知，64位操作系统下指针为8字节，32位系统下指针为4字节。所以在大作业中定义指针类型为 8字节。

   - 由于要实现类似于多级指针的操作（貌似Mx语言中没有多级指针），可以类比于多级数组的定义，由baseType 和 dim（维数）来表示一个pointerType.
   - LLVM IR 中不允许PointerType 指向 void 和 label。

3. ArrayType 的实现比较简单，由一个 IRType 类型的 baseType 成员和一个 int 类型的 size 成员构成。

   - 要注意多维数组不是一维的

   - ```assembly
     ; 3x4的32位整数值数组
     [3 x [4 x i32]]

     ; 12×10的单精度浮点数组
     [12 x [10 x float]]

     ; 2x3x4的16位整数值数组
     [2 x [3 x [4 x i16]]]
     ```

4. IntegerType 非常广泛，char可以看做 i8.

5. FunctionType 的设计：可以将函数类型看做函数签名，他由返回类型和形参类型列表组成，返回类型不能是 `label` 类型。FunctionType不能获取大小和判等。

6. StructType 的设计：记录所有的 成员变量 的 id 和 type 这里不用考虑成员函数，因为我们只关心 struct 的size是多少。

## 开始写 Constant

各个Constant类中有getName操作和toString操作。其中，getName操作用来得到这个Constant的name（类比于c++中的变量或常量的ID）,toString是用来 **打印 LLVM IR 代码** 时用的。

1. 基类为IRConstant，它派生自 User 类，而 User 类派生自 Value 类。
2. BoolConstant 和 IntConstant 非常简单，只需要记录其值即可。
3. StringConstant 看成指向 i8 类型数组的 Pointer 即可。字符常量的名字为 @.str，然后需要注意的是需要把转义字符在 LLMV IR 中做替换，所以需要写一个 RePlace() 函数.
4. 对于 NullConstant 类型，做出一些简化让它在 Value

## 开始写 Compound

1. IRModule ：不派生自任何基类。开一些ArrayList表示 函数定义，全局变量的定义，类的定义，字符串常量（注意这个并不在basicblock中，它是与function同级关系）。

   ```java
   public class IRModule {
       public ArrayList<IRFunction> functionArrayList;
       public ArrayList<StringConstant> stringConstantArrayList;
       //public ArrayList<GlobalDef> globalDefArrayList;
       public ArrayList<StructType> classArrayList;
       public ArrayList<IRFunction> globalInitList;//todo:for what?
   }
   ```

2. IRFunction ：类型由返回值确定。开一个ArrayList表示 此Function内的basicblock；一个Value类型的成员表示返回的地址（如果是void类型，地址为null；如果不是void类型，地址是一个有效的地址）；一个bool类型表示是否是内置函数；另一个bool类型表示是否被调用过（可以用来优化）。理论上来说还应该再加一个变量表示 parentModule 但是本次大作业只有单文件编译，所以不用加这个变量。

   ```java
   public class IRFunction extends User {
       public ArrayList<IRBasicBlock> basicBlockArrayList;
       public Value resAddress;
       public boolean isBuiltin;
       public boolean isUsed; //for optimize
   }
   ```

3. IRBasicBlock ：Label类型。需要一个LinkedList表示有链接的IRInstruction；一个TerminalInstruction；一个IRFunction表示该block在哪一个Function中

   ```java
   public class IRBasicBlock extends Value {
       public LinkedList<IRInstruction> instructionLinkedList;
       public IRInstruction terminator = null;
       public IRFunction parentFunc;
   }
   ```

## 开始写 Instruction

1. 设计基类 IRInstruction ：抽象类，表示所有类型的 Instruction 共有的特性。只需记录父basicblock即可。注意在每个Inst的构造函数中，要记得setBlock才行。每一个指令都有一个返回值类型。
2. BinaryInst ：Type由操作数类行决定。开一个枚举变量类型表示是哪一种操作，还要表示左操作数，右操作数（这里使用User类中的addOperand）即可。Type由操作数的类型决定。
3. BranchInst：Type为VoidType。因为br指令有两种格式，所以需要两个构造函数；除了指令所在的block外一个构造函数需要接受三个参数，`_tag,_trueLabel,_falseLabel` 表示分支跳转选择，另一个只有一个参数 `_targetLabel` 。判断以下条件是否是 `i1` 类型然后addOperand即可。
4. IcmpInst：Type为i1。记录一个opType。把两个操作数记录一下就可。
5. RetInst：Type由return value的type确定。operand里记录一个return value即可。
6. StoreInst：Type为VoidType。记录写入地址和写入的值即可。codegen函数记得要加align
7. LoadInst：Type为地址的解引用类型。记录载入的地址和值即可。
8. AllocInst：Type为传入Type的指针类型。记录一下写入的分配空间的Type即可。
9. GloablDefInst：Type为pointer类型。不需要传入_paraBlock参数。
10. CallInst：Type为函数返回值的Type。构造函数需要传入一个IRFunction
11. BitcastInst：Type为targetType。
12. GepInst：Type为targetType。需要记录一个计算出来的pointer。
13. TruncInst和ZextInst：Type为转换后的类型。

## 开始写 IRBuilder

比较棘手的问题是

1. 如何得到某node的地址？
2. 如何进行new操作？

### 取地址：

专门由一个getAddress()用来获得某个Node的address，分为以下几种情况：

1.为 Identifier：(1).id是class中的成员变量，那么先把this指针load出来，通过load指针的GepInst获取这个变量。(2).id不是class中的成员变量，那么直接从当前的scope中取出就行。

2.为 OnjectPortion：先访问baseObject，获取baseObject的位置，通过baseObject的位置构造GepInst来access元素。

3.为 ArrayAccess：获取数组的地址（数组是先通过开一个指向数据类型的指针来实现的，然后再new一些元素），所以我们获取的是一个二维指针，load这个二维指针，获得一维指针，然后根据这个指针构造GepInst指令计算要访问元素的位置。