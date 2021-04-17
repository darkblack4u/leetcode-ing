> ## 异常

**74.throw 和 throws 的区别？**

```
throw：表示方法内抛出某种异常对象，如果异常对象是非 RuntimeException 则需要在方法申明时加上该异常的抛出，即需要加上 throws 语句 或者 在方法体内 try catch 处理该异常，否则编译报错
执行到 throw 语句则后面的语句块不再执行。
throws：方法的定义上使用 throws 表示这个方法可能抛出某种异常，需要由方法的调用者进行异常处理。

原文链接：https://blog.csdn.net/meism5/article/details/90414147
```

**75.final、finally、finalize 有什么区别？**
```
一、final ：

1、修饰符（关键字） 如果一个类被声明为final,意味着它不能再派生新的子类，不能作为父类被继承。因此一个类不能及被声明为abstract，又被声明为final的。

2、将变量或方法声明为final,可以保证他们使用中不被改变。被声明为final的变量必须在声明时给定初值，而以后的引用中只能读取，不可修改，被声明为final的方法也同样只能使用，不能重载。

二、finally:

在异常处理时提供finally块来执行清楚操作。如果抛出一个异常，那么相匹配的catch语句就会执行，然后控制就会进入finally块，如果有的话。

三、finalize：

是方法名。java技术允许使用finalize()方法在垃圾收集器将对象从内存中清除之前做必要的清理工作。这个方法是在垃圾收集器在确定了，被清理对象没有被引用的情况下调用的。
```

**76.try-catch-finally 中哪个部分可以省略？**
```
catch 和 finally 语句块可以省略其中一个,否则编译会报错。
```

**77.try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？**
```
会执行，在return 前执行。如果finally里面也有return，就以finally里面的为主。
```

**78.常见的异常类有哪些？**
```
(1) NullPointerException 当应用程序试图访问空对象时，则抛出该异常。
(2) SQLException 提供关于数据库访问错误或其他错误信息的异常。
(3) IndexOutOfBoundsException指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。 
(4) NumberFormatException当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。
(5) FileNotFoundException当试图打开指定路径名表示的文件失败时，抛出此异常。
(6) IOException当发生某种I/O异常时，抛出此异常。此类是失败或中断的I/O操作生成的异常的通用类。
(7) ClassCastException当试图将对象强制转换为不是实例的子类时，抛出该异常。
(8) ArrayStoreException试图将错误类型的对象存储到一个对象数组时抛出的异常。
(9) IllegalArgumentException 抛出的异常表明向方法传递了一个不合法或不正确的参数。
(10) ArithmeticException当出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例。 
(11) NegativeArraySizeException如果应用程序试图创建大小为负的数组，则抛出该异常。
(12) NoSuchMethodException无法找到某一特定方法时，抛出该异常。
(13) SecurityException由安全管理器抛出的异常，指示存在安全侵犯。
(14) UnsupportedOperationException当不支持请求的操作时，抛出该异常。
(15) RuntimeExceptionRuntimeException 是那些可能在Java虚拟机正常运行期间抛出的异常的超类。
```