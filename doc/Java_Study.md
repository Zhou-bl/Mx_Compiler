# Java_Study

## 基础语法

### 基本规则

1.类名：所有的类名的首字母应该大写。

2.方法名：所有的方法名应该以小写字母开头。

3.源文件名：源文件名字必须和类名相同。

4.主方法入口：所有的Java程序由public static void main(String [] args) 方法开始执行。

### Java标识符

标识符：类名、变量名和方法名。

特点同c++

### 修饰符

- 访问控制修饰符 : default, public , protected, private
- 非访问控制修饰符 : final, abstract, static, synchronized

### 变量

局部变量、类变量（静态变量）、成员变量（非静态变量）

### 数组

保存在堆空间上。

### 关键字

注意：null 不是关键字，是类似于true和false，是一个常量。

java注释同c++

## 对象和类

```java
public class Dog {
    //以下是该类定义的变量
    String breed;
    int size;
    String colour;
    int age;
 
    //以下是该类定义的方法
    void eat() {
    }
 
    void run() {
    }
 
    void sleep(){
    }
 
    void name(){
    }
}
```

一个类的声明

包含以下变量：

- 局部变量：在方法中声明的变量，方法结束后会销毁。
- 成员变量：定义在类中，但是在方法之外的变量。在创建对象的时候实例化。
- 类变量：用static修饰的成员变量。

### 构造方法

同c++构造函数。

可以有多个构造方法。

### 创建对象

使用new创建一个新的对象。

例如：

```java
public class Puppy{
   public Puppy(String name){
      //这个构造器仅有一个参数：name
      System.out.println("小狗的名字是 : " + name ); 
   }
   public static void main(String[] args){
      // 下面的语句将创建一个Puppy对象
      Puppy myPuppy = new Puppy( "tommy" );
   }
}
```

### 源文件声明规则

- 一个源文件中只能有一个public类
- 可以有多个非public类
- 源文件名和public类名保持一致

#### 包

相当于c++中的名字空间，将功能相似、相关的类或接口组织在同一个包中，方便类的查找和使用。

包的作用：避免发生名字冲突、限制访问权限。

## 关于java某些关键字：

#### @override：

表示对父类的同名函数进行重写

#### super：

该关键字可以使子类调用父类的构造函数

使用方法：

```java
super(parameter-list);//调用父类的构造函数
super.functionName;//调用父类的某个函数
```

#### extends：

继承的关键字

抽象类：抽象类不能被实例化，所以抽象类必须被继承。

List和ArrayList有什么区别？

A：List 是一个接口，而 ArrayList 是 List 接口的一个实现类。

#### final

修饰变量：表示该量为常量，其值不能被改变。

修饰方法：表示该方法在子类中不能被重写。

修饰类：该类不能被继承。

修饰对象：该对象的内容可变但是引用不可变。