four Java Syntax
1. autoboxing, promotion, immutability, generics
2. exceptions, access control
3. iterables(可迭代对象)/iterators(迭代器), equals, other looses ends
4. wildcards, type upper bounds, covariance(not in the scope of the class)

# notes5

## Generics(泛型), Autoboxing(自动装箱)
### Generics
generics(泛型)：接受一个类，或者引用类型

***Generic Method and Type Upper Bounds***

### Autoboxing and Unboxing
初始类型和引用类型之间的隐式的自动转化

注意事项
在自动装箱和拆箱时，需要记住以下几点：
1. 数组永远不会自动装箱或自动取消装箱，例如，如果您有一个整数数组int[] x，
并尝试将其地址放入类型的变量中Integer[]，则编译器将不允许您的程序进行编译。

2. 自动装箱和拆箱也会对性能产生可衡量的影响。也就是说，
依赖自动装箱和拆箱的代码会比避免此类自动转换的代码慢。

3. 包装类型比原始类型占用更多的内存。在大多数现代计算机上，您的代码不仅必须保
存对对象的 64 位引用，而且每个对象还需要 64 位开销来存储对象的动态类型等内容。

### Widening(加宽)
比如一个int在和double一起运算时，会先将int加宽为double类型然后再将两个数进行运算

### Immutable Data Types(不变的数据类型)
实例化后就不能以任何可观察的方式改变的数据类型

在类中以final声明的数据，初始化后就不能更改了。只可以通过重新实例化对象，改变指针的指向
