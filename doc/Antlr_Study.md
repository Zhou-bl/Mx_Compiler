# Antlr_Study

## Antlr功能

分为两个步骤执行。

### Step1 词法分析（lexer）

由字符生成词法符号（token），并对词法符号进行归类。词法符号包含两部分信息：1.token的类型（可根据类型识别词法结构）；2.token对应的文本。

### Step2 语法分析（Parser）

构建词法分析树。树内的每一个内部结点是词组名，用于识别它们的子节点并将子节点归类。叶节点都是token。

## Antlr的实现

antlr根据我们写的g4文件生成一个递归下降的**语法分析器**。这个语法分析器本质上是若干**递归方法**的集合。每一个递归方法对应一条规则。下降的过程就是在语法分析树上**自上而下**遍历解析的过程。

例如：

```c++
//assign : ID '=' expr ';' ;
//上面是我们写的语法规则，下面是antlr根据语法规则生成的该语句的方法
void assign() {
    match(ID);
    match('=');
    expr(); //这时候调用expr子节点，进行expr的相关操作;
    match(';');
}
//此方法仅验证所有的token都存在且顺序正确
```

当某个语法的右侧有多个备选分支时，对该语法的解析像一个switch语句，例如：

```c++
stat 	: assign
		| ifstat
      	| whilestat
      ...
        ;
//以上是语法规则，以下是根据规则生成的方法，我们的解析应该如此：
void stat() {
    switch ("当前输入的token"){
        case : ID	assign(); break;
        case : IF	ifstat(); break;
        case : WHILE whilestat(); break;
        default : //todo:抛出异常；
    }
}
```

在上面的例子中，我们需要一个**前瞻词法符号（lookahead token）**来判断哪一个stat分支是正确的，在某些语言中，我们多个lookahead token 才能正确判断下一步的分支。

## 语句歧义

例如：

```c++
//f（）的两种理解方式
stat : expr ';'        //作为表达式调用
     | ID '(' ')' ';'  //作为函数调用

expr : ID '(' ')' ';'
     | INT
     ;
```

**lexer和paser**可能都会有歧义发生，但是antlr有其解决方案：

paser ：当有歧义时，antlr会选择所有可行的分支中的第一条。

lexer ： 当有歧义时，会选择最靠前的那条词法规则，例如：

```c++
BEGIN 	: 'begin' ;
ID 		: [a-z]+ ;
```

lexer会优先匹配词素BEGIN；而且lexer会匹配可能的最长字符串来生成相应的token，例如beginner只会匹配为ID。

## antlr监听器和访问者模式

//todo

## antlr工具、运行库、自动生成的代码

antlr工具：对g4文件使用，根据g4文件生成lexer和paser

运行库：提供lexer和paser运行所必需的环境

我们要做的操作：1.写好g4文件。2.对g4文件使用antlr生成lexer和paser。3.完善lexer和paser。4.对lexer和paser以及jar包中的运行库一起编译。5.将编译好的代码和运行库放在一起运行。

### 学习正则表达式

正则表达式是一种字符串匹配模式。

```C++
[ABC] //匹配[...]中的所有字符
[^ABC] //匹配除了[...]中的所有字符
[A-Z] //表示一个区间，匹配区间中的所有字符
. //匹配除了换行符之外的任何单个字符，相当于[^\r\n]
() //标识一个子表达式的开始和结束位置
+ //表示前面的字符至少出现一次
* //表示前面的字符可以出现0,1或多次
？ //表示前面的字符出现0或1次    
```

### 写g4

1.for 里面的expression作为初始化是什么？A：对之前已有的变量进行更改

2.expression : expression DOT IDENTIFIER

3.关于string_constant

4.用condition代替statement的作用（可能）：因为条件表达式的值只能是bool类型

5.g4中<assoc=right>是什么操作？A：表示这个操作是右结合性的。

6.allocFormat含义？

## 关于Parser

1.MxParser.DeclTypeContext

2.ctx.declType是一个ArrayList<>吗？

3.ASTNode

4.ParserRuleContext 中的 getStart();返回值是ctx对应的开始的token

5.利用TypeNode结点进行类型的判断。类型判断相等要注意：1.class  2.array  3.void

6.我们将variabledecl 连续声明的情况改写为多个single variable declare结点

7.使用ClassTypeNode的原因：因为TypeNode是一个抽象类，不能够实例化，所以必须派生出一个ClassTypeNode

8.关于字符串常量

9.关于alloc多维数组，中间数组维数为空的情况；

10.ObjExprNode中的两个成员是干什么的？

11.还是用StmtNode来表述更合理，把两种情况进行合并

12.将三种jump指令合并成一类节点名为JumpStmtNode

13.在g4语法文件的设计中，利用compoundExpr放在前面来使得括号能够改变运算优先级。

14.数组的size内建方法要怎么实现？

15.

```
class A{
    B b;
}
class B{
    int a;
}
```

注意此时是合法的，所以我们需要preprocess的过程。首先把class declare全部先做完。

16.其实for循环里面将条件分开是没有意义的，因为两者都是expression类别，parser无法分辨出来。