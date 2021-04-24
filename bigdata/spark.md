> ## 聊聊 Scala 的伴生对象及其意义

实现类似 Java 中那种既有实例成员又有静态成员的类的功能。

为什么上面说它是一种 “功能” 呢？因为要想实现像 Java 中那样的类，光靠一个 Scala 类可不行。在 Scala 中，我们必须：
1. 定义一个 class 并在这里面实现所有的实例成员。
2. 添加一个 object ，这个 object 要与上面的 class 同名，然后在这里面实现所有的静态成员。
3. 定义的 class 与 object 必须在同一个文件内。

伴生对象这种存在最大的特点就是可以实现类似 Java 中那样，在同一个类里既有实例成员又有静态成员的功能。

另一个特点就是 class CompanionDemo 和 object CompanionDemo 虽然分开两处定义，但却可以访问对方的 private 变量及方法。

伴生对象中要想访问对方的私有属性，需要注意以下 2 点

1. class 中要访问 object 中的私有属性，直接以 object 名来 “点” 相应的变量或方法即可，可以参考上面例子；
2. object 中要访问 class 中的私有属性，必须要通过 class 的对象引用来 “点” 相应变量或方法，可以参考上面例子。

第 1 个意义就是为了弥补类中不能定义 static 属性的缺陷。
第 2 个意义就是节省内存资源。
第 3 个意义就是资源共享。


> ## 偏函数

偏函数(Partial Function)，是一个数学概念它不是"函数"的一种, 它跟函数是平行的概念。

Scala中的Partia Function是一个Trait，其的类型为PartialFunction[A,B]，其中接收一个类型为A的参数，返回一个类型为B的结果。

举个例子
```
scala> val pf:PartialFunction[Int,String] = {
     |   case 1=>"One"
     |   case 2=>"Two"
     |   case 3=>"Three"
     |   case _=>"Other"
     | }
pf: PartialFunction[Int,String] = <function1>

scala> pf(1)
res0: String = One

scala> pf(2)
res1: String = Two

scala> pf(3)
res2: String = Three

scala> pf(4)
res3: String = Other
```
偏函数内部有一些方法，比如isDefinedAt、OrElse、 andThen、applyOrElse等等。

1.1 isDefinedAt
isDefinedAt : 这个函数的作用是判断传入来的参数是否在这个偏函数所处理的范围内。
刚才定义的pf来尝试使用isDefinedAt()，只要是数字都是正确的，因为有case _=>"Other"这一句。如果换成其他类型就会报错。
```
scala> pf.isDefinedAt(1)
res4: Boolean = true

scala> pf.isDefinedAt(2)
res5: Boolean = true

scala> pf.isDefinedAt("1")
<console>:13: error: type mismatch;
 found   : String("1")
 required: Int
       pf.isDefinedAt("1")
                      ^

scala> pf.isDefinedAt(100)
res7: Boolean = true
```
那我们再定义一个PartialFunction
```
scala> val anotherPF:PartialFunction[Int,String] = {
     |    case 1=>"One"
     |    case 2=>"Two"
     |    case 3=>"Three"
     | }
anotherPF: PartialFunction[Int,String] = <function1>

scala> anotherPF.isDefinedAt(1)
res8: Boolean = true

scala> anotherPF.isDefinedAt(2)
res9: Boolean = true

scala> anotherPF.isDefinedAt(3)
res10: Boolean = true

scala> anotherPF.isDefinedAt(4)
res11: Boolean = false
```
去掉了原先的最后一句，再执行anotherPF.isDefinedAt(4)会返回false。

1.2 orElse
orElse : 将多个偏函数组合起来使用，效果类似case语句。

```
scala> val onePF:PartialFunction[Int,String] = {
     |   case 1=>"One"
     | }
onePF: PartialFunction[Int,String] = <function1>

scala> val twoPF:PartialFunction[Int,String] = {
     |   case 2=>"Two"
     | }
twoPF: PartialFunction[Int,String] = <function1>

scala> val threePF:PartialFunction[Int,String] = {
     |   case 3=>"Three"
     | }
threePF: PartialFunction[Int,String] = <function1>

scala> val otherPF:PartialFunction[Int,String] = {
     |   case _=>"Other"
     | }
otherPF: PartialFunction[Int,String] = <function1>

scala> val newPF = onePF orElse twoPF orElse threePF orElse otherPF
newPF: PartialFunction[Int,String] = <function1>

scala> newPF(1)
res0: String = One

scala> newPF(2)
res1: String = Two

scala> newPF(3)
res2: String = Three

scala> newPF(4)
res3: String = Other
```
这样，newPF跟原先的pf效果是一样的。

1.3 andThen
andThen: 相当于方法的连续调用，比如g(f(x))。
```
scala> val pf1:PartialFunction[Int,String] = {
     |   case i if i == 1 => "One"
     | }
pf1: PartialFunction[Int,String] = <function1>

scala> val pf2:PartialFunction[String,String] = {
     |   case str if str eq "One" => "The num is 1"
     | }
pf2: PartialFunction[String,String] = <function1>

scala> val num = pf1 andThen pf2
num: PartialFunction[Int,String] = <function1>

scala> num(1)
res4: String = The num is 1
```
pf1的结果返回类型必须和pf2的参数传入类型必须一致，否则会报错。

1.4 applyOrElse
applyOrElse：它接收2个参数，第一个是调用的参数，第二个是个回调函数。如果第一个调用的参数匹配，返回匹配的值，否则调用回调函数。
```
scala> onePF.applyOrElse(1,{num:Int=>"two"})
res5: String = One

scala> onePF.applyOrElse(2,{num:Int=>"two"})
res6: String = two
```
在这个例子中，第一次onePF匹配了1成功则返回的是"One"字符串。第二次onePF匹配2失败则触发回调函数，返回的是"Two"字符串。

2. 偏应用函数
偏应用函数(Partial Applied Function)也叫部分应用函数，跟偏函数(Partial Function)从英文名来看只有一字之差，但他们二者之间却有天壤之别。

部分应用函数, 是指一个函数有n个参数, 而我们为其提供少于n个参数, 那就得到了一个部分应用函数。
个人理解的偏应用函数类似于柯里化，可以参考我以前写的文章借助Java 8实现柯里化

举个例子，定义好一个函数有3个参数，再提供几个有1-2个已知参数的偏应用函数
```
scala> def add(x:Int,y:Int,z:Int) = x+y+z
add: (x: Int, y: Int, z: Int)Int

scala> def addX = add(1,_:Int,_:Int) // x 已知
addX: (Int, Int) => Int

scala> addX(2,3)
res1: Int = 6

scala> addX(3,4)
res2: Int = 8

scala> def addXAndY = add(10,100,_:Int) // x 和 y 已知
addXAndY: Int => Int

scala> addXAndY(1)
res3: Int = 111

scala> def addZ = add(_:Int,_:Int,10) // z 已知
addZ: (Int, Int) => Int

scala> addZ(1,2)
res4: Int = 13
```

总结

本篇笔记是为了下一篇 Scala 模式匹配所做的铺垫。模式匹配会用到偏函数，所以先整理出来。还详细介绍了偏函数和偏应用函数的区别。

> ## Scala 函数柯里化(Currying)

柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有第二个参数为参数的函数。

实例:

首先我们定义一个函数:

```def add(x:Int,y:Int)=x+y```
那么我们应用的时候，应该是这样用：add(1,2)

现在我们把这个函数变一下形：

```def add(x:Int)(y:Int) = x + y```

那么我们应用的时候，应该是这样用：add(1)(2),最后结果都一样是3，这种方式（过程）就叫柯里化。

实现过程
add(1)(2) 实际上是依次调用两个普通函数（非柯里化函数），第一次调用使用一个参数 x，返回一个函数类型的值，第二次使用参数y调用这个函数类型的值。

实质上最先演变成这样一个方法：

```def add(x:Int)=(y:Int)=>x+y```

那么这个函数是什么意思呢？ 接收一个x为参数，返回一个匿名函数，该匿名函数的定义是：接收一个Int型参数y，函数体为x+y。现在我们来对这个方法进行调用。

```val result = add(1) ```

返回一个result，那result的值应该是一个匿名函数：```(y:Int)=>1+y```

所以为了得到结果，我们继续调用result。

```val sum = result(2)```
最后打印出来的结果就是3。

完整实例

下面是一个完整实例：

```
object Test {
   def main(args: Array[String]) {
      val str1:String = "Hello, "
      val str2:String = "Scala!"
      println( "str1 + str2 = " +  strcat(str1)(str2) )
   }

   def strcat(s1: String)(s2: String) = {
      s1 + s2
   }
}
```
执行以上代码，输出结果为：
```
$ scalac Test.scala
$ scala Test
str1 + str2 = Hello, Scala!
```