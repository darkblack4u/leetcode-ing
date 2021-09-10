> ## clean 清理闭包，使其准备好序列化并发送到任务

> 1. sc.clean(f) => F [api](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/SparkContext.scala)

```scala
  /**
   * Clean a closure to make it ready to be serialized and sent to tasks
   * (removes unreferenced variables in $outer's, updates REPL variables)
   * If <tt>checkSerializable</tt> is set, <tt>clean</tt> will also proactively
   * check to see if <tt>f</tt> is serializable and throw a <tt>SparkException</tt>
   * if not.
   *
   * @param f the closure to clean
   * @param checkSerializable whether or not to immediately check <tt>f</tt> for serializability
   * @throws SparkException if <tt>checkSerializable</tt> is set but <tt>f</tt> is not
   *   serializable
   * @return the cleaned closure
   */
  private[spark] def clean[F <: AnyRef](f: F, checkSerializable: Boolean = true): F = {
    ClosureCleaner.clean(f, checkSerializable)
    f
  }
```

> 2. ClosureCleaner [api](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/util/ClosureCleaner.scala) 

A cleaner that renders closures serializable if they can be done so safely.

> 3. Scala 闭包 [解释](https://www.runoob.com/scala/scala-closures.html)

闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。

如下面这段匿名的函数：
```scala
val multiplier = (i:Int) => i * 10
```
函数体内有一个变量`i`，它作为函数的一个参数。如下面的另一段代码：
```scala
val multiplier = (i:Int) => i * factor
```
在 multiplier 中有两个变量：`i`和`factor`。其中的一个`i`是函数的形式参数，在`multiplier`函数被调用时，`i`被赋予一个新的值。然而，`factor`不是形式参数，而是自由变量，考虑下面代码：
```scala
var factor = 3  
val multiplier = (i:Int) => i * factor  
```
这里我们引入一个自由变量`factor`，这个变量定义在函数外面。

这样定义的函数变量`multiplier`成为一个`闭包`，因为它引用到函数外面定义的变量，定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数。