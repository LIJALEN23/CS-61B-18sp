# note6-1
## Exceptions(异常), Iterators(迭代器), Iterables(可迭代对象), ObjectMethod(对象方法)
### Lists(表), Sets(集合), ArraySet(数组集)
Java中自带Lists, Sets, Maps
引例：创建一个ArraySet类
### Throwing Exceptions(抛出异常)
抛出异常的作用：
关键字：throw, try, catch, throws
能抛出的异常都是Java知道可以让程序员修复的
1. 我们可以控制我们的代码：我们有意识地决定在什么时候停止程序的流程
2. 对于使用我们代码的用户来说，更有用的异常类型和有用的错误消息
### Iterator and Iterable
如果不是一个数组想使用for reach循环，这看样子是不行的，但是Java中可以用一些特定的方法实现，即Iterator(迭代器)
引例：ArrayMap的迭代器实现(在ArrayMap中嵌套一个ArraySetIterator的类(实现了Iterator的接口))
ArraySet类实现了Iterable接口，因此可以使用增强型for循环来遍历它的元素。
ArraySetIterator类实现了Iterator接口，用于迭代ArraySet集合中的元素。

1. Iterable接口
Iterable接口代表一个可以被迭代的集合对象。实现这个接口的类可以用增强型
for循环（for-each循环）进行遍历。

2. Iterator接口
Iterator接口用于在集合上进行迭代操作。

### Object
所有类都从Object类继承
String toString() : 可以形成一个特定的字符串，可以配合StringBuilder使用
boolean equals(Object obj) : '==' 并不能比较一个对象是否相等，而可以在类中通过重写此方法来实现
int hashCode()
.......

