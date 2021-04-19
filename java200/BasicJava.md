> ## Java 基础

**1.JDK 和 JRE 有什么区别？**

```
JRE：Java Runtime Environment JDK：它是Java开发运行环境，在程序员的电脑上当然要安装JDK；
JDK：Java Development Kit, Java Runtime Environment它是Java运行环境，如果你不需要开发只需要运行Java程序，那么你可以安装JRE。
例如程序员开发出的程序最终卖给了用户，用户不用开发，只需要运行程序，所以用户在电脑上安装JRE即可。
 JDK包含了JRE。
 JRE中包含虚拟机JVM
```

**2.== 和 equals 的区别是什么？**
```
== 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断。
String s="abcd"是一种非常特殊的形式,和new 有本质的区别。它是java中唯一不需要new 就可以产生对象的途径。以String s="abcd";形式赋值在java中叫直接量,它是在常量池中而不是象new一样放在压缩堆中。 这种形式的字符串，在JVM内部发生字符串拘留，即当声明这样的一个字符串后，JVM会在常量池中先查找有有没有一个值为"abcd"的对象,如果有,就会把它赋给当前引用.即原来那个引用和现在这个引用指点向了同一对象, 如果没有,则在常量池中新创建一个"abcd",下一次如果有String s1 = "abcd";又会将s1指向"abcd"这个对象,即以这形式声明的字符串,只要值相等,任何多个引用都指向同一对象.
```
**3.两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？**
```
不对
```
**4.final 在 java 中有什么作用？**
```
final作为Java中的关键字可以用于三个地方。用于修饰类、类属性和类方法。
特征：凡是引用final关键字的地方皆不可修改！
(1)修饰类：表示该类不能被继承；
(2)修饰方法：表示方法不能被重写；
(3)修饰变量：表示变量只能一次赋值以后值不能被修改（常量）。
相信大家都具备基本的常识: 被final修饰的变量是不能够被改变的. 但是这里的"不能够被改变"对于不同的数据类型是有不同的含义的.
当final修饰的是一个基本数据类型数据时, 这个数据的值在初始化后将不能被改变; 当final修饰的是一个引用类型数据时, 也就是修饰一个对象时, 引用在初始化后将永远指向一个内存地址, 不可修改. 但是该内存地址中保存的对象信息, 是可以进行修改的.
```
**5.java 中的 Math.round(-1.5) 等于多少？**
```
答：-1。

Math.round()四舍五入的原理，小数：
大于0.5，舍去小数，绝对值+1；
小于0.5，仅舍去小数；
等于0.5，取原数字+0.5

Math.floor() 求一个最接近它的整数，它的值小于或等于这个浮点数。（正数去掉小数，负数去小数+1）
```

**6.String 属于基础的数据类型吗？**
```
所以String类型不属于基础数据类型,但是为什么会有这么一问呢?

分析:

当我们在给一个String类型的变量赋值的时候我们是可以不使用 “new” 关键字的, 例如: String name = “小明”; 这样就ok了
这种写法和基本数据类型的使用是很像的,如果基础不扎实,整天的业务代码,还真有可能被唬住.
再有就是,java中的设计,String类型的值是存储在常量池中的.String类型是我们在编程中经常使用的数据类型.因此java的设计者将String类型做了一定的特殊处理.
```
**7.java 中操作字符串都有哪些类？它们之间有什么区别？**
```
String、StringBuffer、StringBuilder

相同（StringBuffer、StringBuilder）：
都是字符串的缓冲区、可变的字符序列；具有相同的构造和方法。
 

区别（String、StringBuffer、StringBuilder）：
内存
String 是不可变的对象，每次操作都会生成新的 String 对象，然后将指针指向新的 String 对象，
StringBuffer、StringBuilder 可以在原有对象的基础上进行操作，所以在经常改变字符串内容的情况下最好不要使用 String。

出现版本：
StringBuffer是 Jdk 1.1
StringBuilder是 Jdk 1.5

线程安全：
StringBuffer线程安全，同步锁（synchronized），多线程仍可以保证数据安全
StringBuilder线程不安全，多线程无法保证数据安全

效率：
StringBuilder > StringBuffer > String
 
总结:
不频繁增改字符，就用String;否则用StringBuffer或StringBuilder
 
String的常用方法
Stringbuffer的构造（三构造）；常用方法（添加，删除，替换和反转）
```
**8.String str="i"与 String str=new String(“i”)一样吗？**
```
equit相同，==不同
String str="i"; 因为String 是final类型的，所以“i”应该是在常量池。

而new String("i");则是新建对象放到堆内存中。
```

**9.如何将字符串反转？**
```
1. 利用 StringBuffer 或 StringBuilder 的 reverse 成员方法:
2. 利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接:
3. 利用 String 的 CharAt 方法取出字符串中的各个字符:
```

**10.String 类的常用方法都有那些？**
```
(1).indexOf()：返回指定字符的索引。
(2).charAt()：返回指定索引处的字符。
(3).replace()：字符串替换。
(4).trim()：去除字符串两端空白。
(5).split()：分割字符串，返回一个分割后的字符串数组。
(6).getBytes()：返回字符串的 byte 类型数组。
(7).length()：返回字符串长度。
(8).toLowerCase()：将字符串转成小写字母。
(9).toUpperCase()：将字符串转成大写字符。
(10).substring()：截取字符串。
(11).equals()：字符串比较。
```
**11.抽象类必须要有抽象方法吗？**
```
答：不需要，

抽象类不一定有抽象方法；但是包含一个抽象方法的类一定是抽象类。（有抽象方法就是抽象类，是抽象类可以没有抽象方法）

解释：

抽象方法：
java中的抽象方法就是以abstract修饰的方法，这种方法只声明返回的数据类型、方法名称和所需的参数，没有方法体，也就是说抽象方法只需要声明而不需要实现。

抽象方法与抽象类：
当一个方法为抽象方法时，意味着这个方法必须被子类的方法所重写，否则其子类的该方法仍然是abstract的，而这个子类也必须是抽象的，即声明为abstract。abstract抽象类不能用new实例化对象，abstract方法只允许声明不能实现。如果一个类中含有abstract方法，那么这个类必须用abstract来修饰，当然abstract类也可以没有abstract方法。 一个抽象类里面没有一个抽象方法可用来禁止产生这种类的对象。

Java中的抽象类：
abstract class 在 Java 语言中表示的是一种继承关系，一个类只能使用一次继承关系。但是，一个类却可以实现多个interface。

在abstract class 中可以有自己的数据成员，也可以有非abstarct的成员方法，而在interface中，只能够有静态的不能被修改的数据成员（也就是必须是static final的，不过在 interface中一般不定义数据成员），所有的成员方法都是abstract的。
```

**12.普通类和抽象类有哪些区别？**
```
抽象类不能被实例化
抽象类可以有抽象方法，抽象方法只需申明，无需实现
含有抽象方法的类必须申明为抽象类
抽象的子类必须实现抽象类中所有抽象方法，否则这个子类也是抽象类
抽象方法不能被声明为静态
抽象方法不能用private修饰
抽象方法不能用final修饰
```
**13.抽象类能使用 final 修饰吗？**
```
“final修饰的类不能被继承，没有子类。如果类中有抽象的方法也是没有意义的。abstract类为抽象类。即该类只关心子类具有的功能，而不是功能的具体实现。如果 用final修饰方法，那么该方法则不能再被重写。final 是不能修饰abstract所修饰的方法的。”
```
**14.接口和抽象类有什么区别？**
```
抽象类是什么：

抽象类不能创建实例，它只能作为父类被继承。抽象类是从多个具体类中抽象出来的父类，它具有更高层次的抽象。从多个具有相同特征的类中抽象出一个抽象类，以这个抽象类作为其子类的模板，从而避免了子类的随意性。

(1) 抽象方法只作声明，而不包含实现，可以看成是没有实现体的虚方法
(2) 抽象类不能被实例化
(3) 抽象类可以但不是必须有抽象属性和抽象方法，但是一旦有了抽象方法，就一定要把这个类声明为抽象类
(4) 具体派生类必须覆盖基类的抽象方法
(5) 抽象派生类可以覆盖基类的抽象方法，也可以不覆盖。如果不覆盖，则其具体派生类必须覆盖它们

接口是什么：
(1) 接口不能被实例化
(2) 接口只能包含方法声明
(3) 接口的成员包括方法、属性、索引器、事件
(4) 接口中不能包含常量、字段(域)、构造函数、析构函数、静态成员

接口和抽象类的区别：
（1）抽象类可以有构造方法，接口中不能有构造方法。
（2）抽象类中可以有普通成员变量，接口中没有普通成员变量
（3）抽象类中可以包含静态方法，接口中不能包含静态方法
（4） 一个类可以实现多个接口，但只能继承一个抽象类。
（5）接口可以被多重实现，抽象类只能被单一继承
（6）如果抽象类实现接口，则可以把接口中方法映射到抽象类中作为抽象方法而不必实现，而在抽象类的子类中实现接口中方法

接口和抽象类的相同点：
(1) 都可以被继承
(2) 都不能被实例化
(3) 都可以包含方法声明
(4) 派生类必须实现未实现的方法
```
**15.java 中 IO 流分为几种？**
```
InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。
```
**16.BIO、NIO、AIO 有什么区别？**
```
BIO (Blocking I/O): 同步阻塞I/O模式，数据的读取写入必须阻塞在一个线程内等待其完成。在活动连接数不是特别高（小于单机1000）的情况下，这种模型是比较不错的，可以让每一个连接专注于自己的 I/O 并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统的 BIO 模型是无能为力的。因此，我们需要一种更高效的 I/O 处理模型来应对更高的并发量。
NIO (New I/O): NIO是一种同步非阻塞的I/O模型，在Java 1.4 中引入了NIO框架，对应 java.nio 包，提供了 Channel , Selector，Buffer等抽象。NIO中的N可以理解为Non-blocking，不单纯是New。它支持面向缓冲的，基于通道的I/O操作方法。 NIO提供了与传统BIO模型中的 Socket 和 ServerSocket 相对应的 SocketChannel 和 ServerSocketChannel 两种不同的套接字通道实现,两种通道都支持阻塞和非阻塞两种模式。阻塞模式使用就像传统中的支持一样，比较简单，但是性能和可靠性都不好；非阻塞模式正好与之相反。对于低负载、低并发的应用程序，可以使用同步阻塞I/O来提升开发速率和更好的维护性；对于高负载、高并发的（网络）应用，应使用 NIO 的非阻塞模式来开发
AIO (Asynchronous I/O): AIO 也就是 NIO 2。在 Java 7 中引入了 NIO 的改进版 NIO 2,它是异步非阻塞的IO模型。异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。AIO 是异步IO的缩写，虽然 NIO 在网络操作中，提供了非阻塞的方法，但是 NIO 的 IO 行为还是同步的。对于 NIO 来说，我们的业务线程是在 IO 操作准备好时，得到通知，接着就由这个线程自行进行 IO 操作，IO操作本身是同步的。查阅网上相关资料，我发现就目前来说 AIO 的应用还不是很广泛，Netty 之前也尝试使用过 AIO，不过又放弃了。
```

**17.Files的常用方法都有哪些？**
```
Files. exists()：检测文件路径是否存在。
Files. createFile()：创建文件。
Files. createDirectory()：创建文件夹。
Files. delete()：删除一个文件或目录。
Files. copy()：复制文件。
Files. move()：移动文件。
Files. size()：查看文件个数。
Files. read()：读取文件。
Files. write()：写入文件。
```