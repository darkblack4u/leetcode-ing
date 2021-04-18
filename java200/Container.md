> # 容器

**18.java 容器都有哪些？**
```
Java 容器分为 Collection 和 Map 两大类，其下又有很多子类，如下所示：

Collection
List
ArrayList
LinkedList
Vector
Stack
Set
HashSet
LinkedHashSet
TreeSet
Map
HashMap
LinkedHashMap
TreeMap
ConcurrentHashMap
Hashtable
```
**19.Collection 和 Collections 有什么区别？**
```
Collection与Collections的根本区别是:
1. Collection 是一个集合接口。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的...
2. Collections 是一个包装类。它包含有各种有关集合操作的静态多态方法。此类不能实例化,就像一个工具类,服务于Java的Collection框架。
```
**20.List、Set、Map 之间的区别是什么？**
```
List：有序集合，元素可重复
Set：不重复集合，LinkedHashSet按照插入排序，SortedSet可排序，HashSet无序
Map：键值对集合，存储键、值和之间的映射；Key无序，唯一；value 不要求有序，允许重复
```
21.HashMap 和 Hashtable 有什么区别？

22.如何决定使用 HashMap 还是 TreeMap？

**23.说一下 HashMap 的实现原理？**
```
HashMap 基于 Hash 算法实现的，我们通过 put(key,value)存储，get(key)来获取。当传入 key 时，HashMap 会根据 key. hashCode() 计算出 hash 值，根据 hash 值将 value 保存在 bucket 里。当计算出的 hash 值相同时，我们称之为 hash 冲突，HashMap 的做法是用链表和红黑树存储相同 hash 值的 value。当 hash 冲突的个数比较少时，使用链表否则使用红黑树。

https://zhuanlan.zhihu.com/p/28501879
```

**24.说一下 HashSet 的实现原理？**
```
HashSet实际上是一个HashMap实例，都是一个存放链表的数组。它不保证存储元素的迭代顺序；此类允许使用null元素。HashSet中不允许有重复元素，这是因为HashSet是基于HashMap实现的，HashSet中的元素都存放在HashMap的key上面，而value中的值都是统一的一个固定对象private static final Object PRESENT = new Object();

HashSet中add方法调用的是底层HashMap中的put()方法，而如果是在HashMap中调用put，首先会判断key是否存在，如果key存在则修改value值，如果key不存在这插入这个key-value。而在set中，因为value值没有用，也就不存在修改value值的说法，因此往HashSet中添加元素，首先判断元素（也就是key）是否存在，如果不存在这插入，如果存在着不插入，这样HashSet中就不存在重复值。

 所以判断key是否存在就要重写元素的类的equals()和hashCode()方法，当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算次对象的哈希值，此哈希值决定了此对象在Set中存放的位置；若此位置没有被存储对象则直接存储，若已有对象则通过对象所在类的equals()比较两个对象是否相同，相同则不能被添加。

   iterator：返回对此set中元素进行迭代的迭代器      size：返回此set中元素的数量（set的容量）      isEmpty：判断Hashset集合是否为空      contains：判断某个元素是否存在于HashSet中      add（）：如果此set中尚未包含指定元素，则添加指定元素
```

**25.ArrayList 和 LinkedList 的区别是什么？**
```
1 数据结构实现：ArrayList 是动态数组的数据结构实现，而 LinkedList 是双向链表的数据结构实现。
2 随机访问效率：ArrayList 比 LinkedList 在随机访问的时候效率要高，因为 LinkedList 是线性的数据存储方式，所以需要移动指针从前往后依次查找。
3 增加和删除效率：在非首尾的增加和删除操作，LinkedList 要比 ArrayList 效率要高，因为 ArrayList 增删操作要影响数组内的其他数据的下标。
综合来说，在需要频繁读取集合中的元素时，更推荐使用 ArrayList，而在插入和删除操作较多时，更推荐使用 LinkedList。
```
**26.如何实现数组和 List 之间的转换？**
```
数组转 List ，使用 JDK 中 java.util.Arrays 工具类的 asList 方法
public static void testArray2List() {
    String[] strs = new String[] {"aaa", "bbb", "ccc"};
    List<String> list = Arrays.asList(strs);
    for (String s : list) {
        System.out.println(s);
    }
}
List 转数组，使用 List 的toArray方法。无参toArray方法返回Object数组，传入初始化长度的数组对象，返回该对象数组
public static void testList2Array() {
    List<String> list = Arrays.asList("aaa", "bbb", "ccc");
    String[] array = list.toArray(new String[list.size()]);
    for (String s : array) {
        System.out.println(s);
    }
}

```

**27.ArrayList 和 Vector 的区别是什么？**
```
线程安全：Vector 使用了 Synchronized 来实现线程同步，是线程安全的，而 ArrayList 是非线程安全的。
性能：ArrayList 在性能方面要优于 Vector。
扩容：ArrayList 和 Vector 都会根据实际的需要动态的调整容量，
     只不过在 Vector 扩容每次会增加 1 倍，而 ArrayList 只会增加 50%。
```
**28.Array 和 ArrayList 有何区别？**
```
①Array是Java中的数组，声明数组有三种方式
int[] a=new int[10];
int a[]=new int[10];
int a[]={1,2,3,4};
可以看出：在定义一个数组的时候，必须指定这个数组的数据类型及数组的大小，也就是说数组中存放的元素个数固定并且类型一样

②ArrayList是动态数组,也就是数组的复杂版本，它可以动态的添加和删除元素，被称为”集合“，集合的声明如下
ArrayList list = new ArrayList(10);
ArrayList list1 = new ArrayList();
可以看出：在不使用泛型的情况下，这个list是可以添加进不同类型的元素的，而且arraylist是可以不用指定长度的。在使用泛型时，我们就只能添加一种类型的数据了
```
**29.在 Queue 中 poll()和 remove()有什么区别？**
```
poll()和remove()都将移除并且返回队列头，但是在poll()在队列为空时返回null，而remove()会抛出NoSuchElementException异常。
```

**30.哪些集合类是线程安全的？**
```
Vector
Stack
Hashtable
java.util.concurrent 包下所有的集合类 ArrayBlockingQueue、ConcurrentHashMap、ConcurrentLinkedQueue、ConcurrentLinkedDeque...
```
**31.迭代器 Iterator 是什么？**
```

```
**32.Iterator 怎么使用？有什么特点？**
```
例如Java的Iterator只能单向移动，它能用来：
（1）使用方法Iterator（）要求容器返回一个Iterator。Iterator将准备好返回序列的第一个元素。
（2）使用next（）获得序列中的下一个元素
（3）使用hasNext（）检查序列中是否还有元素。
（4）使用remove（）将迭代器新近返回的元素删除。
Iterator的一个很强的用处：能够将遍历序列的操作与序列底层的结构分离。
```

**33.Iterator 和 ListIterator 有什么区别？**
```
ListIterator 继承 Iterator
ListIterator 比 Iterator多方法
          add(E e)  将指定的元素插入列表，插入位置为迭代器当前位置之前
          set(E e)  迭代器返回的最后一个元素替换参数e
          hasPrevious()  迭代器当前位置，反向遍历集合是否含有元素
          previous()  迭代器当前位置，反向遍历集合，下一个元素
          previousIndex()  迭代器当前位置，反向遍历集合，返回下一个元素的下标
          nextIndex()  迭代器当前位置，返回下一个元素的下标

使用范围不同，Iterator可以迭代所有集合；ListIterator 只能用于List及其子类
ListIterator 有 add 方法，可以向 List 中添加对象；Iterator 不能
ListIterator 有 hasPrevious() 和 previous() 方法，可以实现逆向遍历；Iterator不可以
ListIterator 有 nextIndex() 和previousIndex() 方法，可定位当前索引的位置；Iterator不可以
ListIterator 有 set()方法，可以实现对 List 的修改；Iterator 仅能遍历，不能修改
```
**34.怎么确保一个集合不能被修改？**
```
目前查到有两种方法：
（1）通过 Collections.unmodifiableCollection(Collection c)
（2）通过Arrays.asList创建的集合
```