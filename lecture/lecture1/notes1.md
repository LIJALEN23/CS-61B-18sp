# notes1-1
## Essentials
### Hello world 
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld!");
    }
}
```
1. 一个HelloWorld的类中
2. main方法为入口
3. String[] args : 命令行参数
4. System.out.println("");进行输出
### Running a Java Program
```shell
javac HelloWrold.java
java HelloWrold.class
```
### Variables and Loops
和C语言几乎一样，但是有一个enhance loop
### Static Typing

### Define Functions in Java
和C语言几乎一样，多了public static
### Code Style,Comment,Javadoc
代码风格，文档的书写
# notes1-2
## Objects
### Static vs Non-Static Methods
1. static methods : 可以不用实例化直接通过类名使用(就像函数一样)
2. non-static methods : 必须实例化一个对象才能使用

### Constructors in Java
关键字 : new
实例化一个对象需要通过构造函数的使用
### String[] args
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
### Using libraries
了解怎么使用Java的库