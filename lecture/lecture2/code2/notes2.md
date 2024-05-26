# Objects
## Static vs Non-Static Methods
1. static methods : 可以不用实例化直接通过类名使用(就像函数一样)
2. non-static methods : 必须实例化一个对象才能使用

## Constructors in Java
关键字 : new
实例化一个对象需要通过构造函数的使用
## String[] args
命令行参数
```java
public class Print {
    public static void main(String[] args) {
        for (int i : args) {
            system.out.println(i);
        }
    }
}
```
```shell
javac Print.java
java Print.class Hello world!
```
```
Hello
world!
```
## Using libraries
了解怎么使用Java的库