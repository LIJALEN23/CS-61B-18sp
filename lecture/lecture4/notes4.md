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
import code4.List61B;
import code4.SLList;
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
## Subtype Polymorphism(多态) vs HoFs(高阶函数)