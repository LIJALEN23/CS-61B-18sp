# note6-1
## Packages(包), Access Control(访问控制),
### Packages and JAR file
包：包是Java中用来组织类和接口的一种机制，类似于文件系统中的文件夹
1. 命名空间管理： 包提供了一种命名空间，防止类名冲突。比如，com.example.myapp 是一个包名，其中的类可以通过完全限定名 com.example.myapp.SomeClass 进行引用。 
2. 访问控制： 包也是Java的访问控制单元。类可以声明为 public、protected、private 或默认（包内可见），这取决于它们所在的包和成员的访问修饰符。
3. 组织代码： 包可以帮助组织大型项目的代码，提高代码的结构化和可维护性。

JAR：JAR文件是一种Java的归档文件格式，用于将多个Java类、相关资源和元数据打包成一个单独的文件。
1. 压缩和打包： JAR文件使用ZIP格式进行压缩，可以包含 .class 文件、资源文件（如图片、配置文件）和元数据（如 META-INF/MANIFEST.MF）。
2. 类路径管理： JAR文件是Java应用程序的重要组成部分，可以通过类路径（classpath）在应用程序中加载和使用其中的类和资源。
3. 分发和部署： JAR文件方便了Java程序的分发和部署，特别是用于发布独立的应用程序或共享的库。

### Access Control(访问控制)
关键字：private, public, protected

| Modifier  | Class | Package | Subclass | world |
|-----------|-------|---------|----------|-------|
| public    | Y     | Y       | Y        | Y     |
| protected | Y     | Y       | Y        | N     |
|           | Y     | Y       | N        | N     |
| private   | Y     | N       | N        | N     |

# note6-2
## Efficient Programming
### Encapsulation(封装)
在Java编程中，封装（Encapsulation）是面向对象编程的一个基本概念，它指的
是将对象的状态（属性）和行为（方法）封装在一起，对外提供访问接口，而隐藏对象的
具体实现细节。这样做的目的是为了保护数据的完整性和安全性，增强代码的可维护性和可读性。

封装的实现：
1. 类和对象： 将数据和操作数据的方法封装在一个类中。类是对象的模板，定义了对象的属性和行为。
2. 访问修饰符： Java提供了四种访问修饰符：private、default（包访问权限）、protected和public，用来控制类成员的访问权限。
private：私有的，只有类内部可以访问。
default：包访问权限，只有同一个包内的类可以访问。
protected：受保护的，只有同一个包内的类和子类可以访问。
public：公共的，任何地方都可以访问。
3. Getter和Setter方法： 为私有属性提供公共的访问方法，通常称为getter和setter方法。getter方法用于获取属性值，setter方法用于设置属性值。

封装的好处：
1. 数据保护： 通过将属性设置为私有，可以防止外部代码直接访问和修改属性值，保护数据的完整性。
2. 隐藏实现细节： 外部代码不需要了解类的具体实现，只需要通过公共方法与类交互，提高了代码的可维护性。
3. 灵活性： 可以在getter和setter方法中添加额外的逻辑（例如，验证输入），提高了代码的灵活性和安全性。
4. 松耦合： 类的实现细节与外部代码解耦，修改类的内部实现不会影响外部代码，提高了代码的可扩展性。

### API's
API : Application Programing Interface
ADT的API基本是构造函数和一些方法
### ADT's
ADT : Abstract Data Structures

delegation(委托) vs inheritance(继承)
委托：是一种设计模式，指的是一个对象将某个任务交给另一个辅助对象来处理。委托实现了组合和转发，通过在一个类中包含另一个类的实例，并调用该实例的方法来实现功能。

继承："is-a"
委托："has-a"

通常推荐优先考虑组合（委托）而不是继承，尤其是在类之间不是严格的"is-a"关系时。组合更灵活，可以减少类之间的耦合，增强代码的可维护性和可扩展性