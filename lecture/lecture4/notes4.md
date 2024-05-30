# notes4-1
## Inheritance(继承),Implements(实现)
### Hypernyms(上位词), Hyponyms(下位词), Interface Inheritance(接口继承)
关键字：
1. interface(它规定有能做什么但不会告诉怎么做。子类需要在第一行声明出来):继承接口后需要重写接口里的方法，默认方法可以不管
2. default(在接口中定义默认的方法，如果子类的情况比较特殊需要子类对方法进行重写，接口中需要声明出来)
3. implements(实现接口声明的方法)
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

List61B<String> list1 = new SLList<String>();



```