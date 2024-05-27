# notes2-1
## Reference(引用),Recursion(递归) and Lists(表)
### 位(bits)
计算机底层以010101代码进行储存
### 基本类型(primitive type)
八种基本类型：byte,short,int,long,float,double,boolean,char
### 引用类型(reference type)
除了八种基本类型以外的类型都是引用类型(相当于简化了C语言中的指针)，包括数组也是引用类型
### 参数传递
在Java中使用是按值传递
Java 是按值传递参数的，但对于对象而言，传递的是对象引用的值。这意味着当你向一个静态方法传递一个对象时，方法接收到的是该对象的引用，而不是对象的副本。因此，静态方法可以通过这个引用修改对象的属性。
但是需要注意，如果在静态方法中改变对象引用本身（即让引用指向一个新的对象），不会影响传入方法的那个引用。这是因为 Java 按值传递的是对象引用的副本。
### 实例化数组
```java
elementType[] name = new elementType[arraySize];
```
### IntLists
涉及到new关键字的使用和引用变量的问题
IntList.java

# notes2-2
## SLLists(单链表),Nested Classes(嵌套类),Sentinel Nodes(哨兵节点)
### SLLists
1. 将IntList独立出来变成IntNode嵌套在SLList中
2. 用private声明first节点以避免在外部修改了SLList
3. 将IntNode定义成static(这意味着IntNode不能使用SLList中的非静态方法，但是这会减少内存的占用)
4. 辅助递归来完成size的功能
5. Caching : 为了避免大型SLList中的从头size很麻烦，所以在每次添加节点时就直接计算size(private int size)
6. 空列表 : 构造SLList时没有输入数据则构造一个空列表
7. 哨兵节点 ：可以提高代码的可读性

将IntList这个类变成IntNode(即一个基本的头节点)嵌套在SLList中实现一个单链表使addFirst这类操作很简单
关键字public,private,protect
### Nested Classes
嵌套并不会影响性能
像IntNode这个类嵌套在SLList中，可以用static定义(这意味着IntNode不能使用SLList中的非静态方法，但是这会减少内存的占用)
### Sentinel Nodes
将第一个节点成为哨兵节点，指向一个SLList并且储存了SLList的长度
# notes2-3
## DLLists
由于SLList的addLast()很慢，所以将SLList改为DLList可以将对头节点和尾节点的操作变快和方便
改进办法：在节点储存一个前驱节点
改进哨兵节点：1. 加一个指向最后元素的哨兵节点 2. 直接变成循环链表

将链表泛化(Generic DLList<ElementType>)
泛化：
   1. 只需要在文件的最顶部的类名之后指定一次泛型类型的名称 
   2. 在使用您的数据结构的其他 .java 文件中，在声明期间指定特定的所需类型，并在实例化期间使用空菱形运算符。
   3. 如果需要在原始类型上实例化泛型，使用Integer,Double,Character,Boolean,Short,Byte,Float
泛型的知识在后面的章节中
# notes2-4
## Arrays
数组的基本知识：一个固定的大小的数组，和类不一样，数组没有方法
数组的创建：
```java
int[] y = new int[3];

int[] x = new int[]{1, 2, 3, 4, 5};
int[] w = {1, 2, 3, 4, 5};
```
二维数组
```java
int[][] array = new int[4][];
array[0] = new int[]{0, 1, 2, 3};

int[][] array = new int[4][4];
int[][] array = new int[][]{{1}, {1, 2}, {1, 2, 3}}
```


# notes2-5
## ALists,Resizing vs SList
因为获取到指定位置的元素，SLList和DLList都要一个一个寻找，而数组可以直接通过下标获取
缺点：数组的大小是固定的，但是可以通过resize动态位数组重新分配大小(其实是重新开了一个更大的数组，但效率仍然底下)
改进：几何调整数组大小，但扩充了很大的内存空间后再搁置会占用多余的空间，所以要监控数组中的元素个数一次来调整到合适的大小    