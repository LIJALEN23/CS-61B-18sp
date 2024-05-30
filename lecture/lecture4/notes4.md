# notes4-1
## Inheritance(继承),Implements(实现)
Hypernyms(上位词), Hyponyms(下位词), Interface Inheritance(接口继承)

关键字：
1. interface(它规定有能做什么但不会告诉怎么做):继承接口后需要重写接口里的方法，默认方法可以不管
2. default(在接口中定义默认的方法，如果子类的情况比较特殊需要子类对方法进行重写，接口中需要声明出来)
3. implements(实现接口声明的方法。子类需要在第一行声明出来)
4. override(方法重写,在子类中需要声明出来@override):重新定义从父类中继承的方法
5. overloaded(方法重载):在同一个类中的名字相同的方法，但是标签不同

Java的动态方法选择：
```java
import code4.2.List61B;
import code4.2.SLList;
/** Java中变量是有类型的
 *  list1是List61B类型，这被称为静态类型。但是list1的对象本质上是SLList，这被称为动态类型
 *  当Java运行被重写的方法时会在动态类型中搜索合适的方法并运它。
 *      -这对重载的方法并不起作用-
 *   当遇到重载的方法使用时，Java会通过静态类型而不是动态类型来调用方法。
 *  */
public class test<Item> extends SLList<Item> {
    
//    public static void test1(List61B<Item> list) {
//        System.out.println("This is test1!");
//    }
//    
//    public static void test2(SLList<Item> list) {
//        System.out.println("This is test2!");
//    }
//    
//    public static void test3(test<Item> list) {
//        System.out.println("This is test3!");
//    }
    
    public static void main(String[] args) {
        List61B<String> list1 = new SLList<String>();

//        test<String> list2 = new SLList<>();
//        SLLlsit<String> list3 = list2;
//        
    }
}
```
# notes4-2
## Extends(继承父类关键词),Casting(强制类型转换),Higher Order Functions(高阶函数)

关键字：
1. extends(继承)
2. constructor(构造函数)
3. super(父类)
4. abstract(抽象类)

### 基本的继承操作和构造器的使用
```java
public class example1 extends example2{}
```
引例1：如果我们想要一个基于SLList的RotatingSLList那么我们可以通过继承的方式进行使用
引例2：如果我们需要将remove的元素的存起来的VengefulSLList

继承：
1. 所有实例和方法
2. 所有方法
3. 所有嵌套类
4. 构造函数不能继承，私有成员不能被子类直接访问

构造函数的使用：
Java要求所有构造函数都必须调用其超类的构造函数开始。如果程序员没有手动显式调用，那么Java会自己隐式调用父类的无参构造函数。

### Object类
Java中的每个类都是Object的子类或者Object类的后代，即使类中没有extends显示的类，但是会隐式扩展Object类
Object中有一些方法，如：.equals(Object obj),.hashCode(),toString()

### 封装(Encapsulation)
封装：使调用的人不需要了解内部的代码，只进行调用接口就行了(封装可以解决复杂性)
继承可以破坏封装

### 类型检查(Type Checking)和强制类型转化(Casting)
编译器会根据对象的静态类型确定某项是否有效
强制类型转化是一种强大但危险的工具(就是告诉编译器不要执行类型检查的任务)

### 高阶函数
高阶函数：即将其他函数视为数据的函数
回调函数(callback)
```java
public interface IntUnaryFunction {
    int apply(int x);
}
```
```java
public class TenX implements IntUnaryFunction {
    public int apply(int x) {
        return 10 * x;
    }
}
```
```java
public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }
    
    public static void main(String[] args) {
        System.out.println(do_twice(new TenX(), 2));
    }
}
```

# notes4-3
## Subtype(子类) Polymorphism(多态) vs HoFs(高阶函数)
多态性的核心含义是“多种形式”。
在Java中，多态性是指对象可以具有多种形式或者类型。
在面向对象编程中，多态性是指对象可以被视为其自身类的实例、其超类的实例、其超类的超类的实例等。

引例：OurComparable(使用强制类型转化) - Compare(使用泛型)
1. 强制类型转化
   1. 定义一个接口，在接口中声明一个方法接口
   2. 在一个类中实现这个接口(一个特定的比较方法)
   3. 实现一个静态方法接受所有类的对象，通过不同对象调用相应的方法来实现多态
2. 泛型
   1. 在接口中使用泛型
   2. 在一个类中实现这个接口并且用这个类作为泛型
   3. 实现一个静态方法使其他对象调用

接口提供了实现回调函数的能力

# notes4-4
## Libraries(库),Abstract Classes(抽象类),Packages(包)
### Java库
ADTs：抽象数据类型
Java库中有三大类数据结构：List(LinkedList,ArrayList)，Set(HashSet,TreeSet)，Map(HashMap,TreeMap)
1. List（列表）：
特点：List是一个有序的集合，允许包含重复的元素。每个元素都有其对应的索引（从0开始）。
2. Set（集合）：
特点：Set是一个不包含重复元素的集合，无序（但某些实现类是有序的）。
3. Map（映射）：
特点：Map是一个键值对的集合，每个键唯一且对应一个值。键不能重复，但值可以重复。

### 抽象类
抽象类：
在Java中，抽象类是一种不能被实例化的类，专门用作其他类的基类。
抽象类可以包含抽象方法（没有实现的方法）以及具体方法（有实现的方法）。
抽象类的设计目的是提供一个通用的接口或基类，为具体子类提供基本的功能或结构，同时强制子类实现特定的方法。

接口：
1. 所有方法必须公开
2. 所有变量必须是公共静态最终变量
3. 无法实例化
4. 所有默认方法都是抽象的，除了default
5. 每个类可以实现多个接口

抽象类：
1. 方法可以公开，可以私有
2. 可以有任何类型的变量
3. 无法实例化
4. 方法默认为具体方法，除非特别指定abstract
5. 每个类只能实现一个

抽象类可以完成接口的所有事情
### 包
包：Java中的包（package）是一种用于组织类和接口的机制。
它提供了一种命名空间管理功能，可以避免类名冲突并提高代码的可维护性。
包还可以控制类和接口的访问权限，使得代码更易于管理和重用。