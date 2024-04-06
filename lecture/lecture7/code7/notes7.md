# Inheritance,Implements

## The Desire for Generality
Java的开发速度比较快是因为：面向对象的开发思路可以免掉一些重复性的工作
如何实现？接口，继承的思想

## Hypernyms,Hyponyms,Interface Inheritance
继承的思想

## The Interface and Implements Keywords
private就没有意义了，因为其他类要重写方法
```java
//设置了一个List基本操作的接口
public interface List61B<Item> {
    public void addLast(Item x);
    public void addFirst(Item x);
    public Item getFitst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();
}
```
```java
public class AListImpl<Item> implements List61B<Item> {
    @Override
    public void addLast(Item x);
    @Override
    public void addFirst(Item x);
    @Override
    public Item getFitst();
    @Override
    public Item getLast();
    @Override
    public Item removeLast();
    @Override
    public Item get(int i);
    @Override
    public void insert(Item x, int position);
    @Override
    public int size();
}
```
```java
public class SLListImpl<Item> implements List61B<Item> {
    @Override
    public void addLast(Item x);
    @Override
    public void addFirst(Item x);
    @Override
    public Item getFitst();
    @Override
    public Item getLast();
    @Override
    public Item removeLast();
    @Override
    public Item get(int i);
    @Override
    public void insert(Item x, int position);
    @Override
    public int size();
}
```

## Overriding and Overloading
重写和重载
1. 重写：将继承的方法进行重写
2. 重载：定义的名字相同，而实现不同功能

## Interface Inheritance
## Implementation Inheritance:Default Methods
```java
public interface List61B<Item> {
    public void addLast(Item x);
    public void addFirst(Item x);
    public Item getFitst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();
    default public void print() {
        for (int i = 0; i < size(); i += 1){
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
```
## Overriding Default Methods
## Dynamic Method Selection and Overloaded Methods
## Is a vs Has a,Interface vs Implementation