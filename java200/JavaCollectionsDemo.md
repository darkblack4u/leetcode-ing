> ## ArrayList

| 方法             | 描述                                          |
|------------------|-----------------------------------------------|
| add()            | 将元素插入到指定位置的 arraylist 中           |
| addAll()         | 添加集合中的所有元素到 arraylist 中           |
| clear()          | 删除 arraylist 中的所有元素                   |
| clone()          | 复制一份 arraylist                            |
| contains()       | 判断元素是否在 arraylist                      |
| get()            | 通过索引值获取 arraylist 中的元素             |
| indexOf()        | 返回 arraylist 中元素的索引值                 |
| removeAll()      | 删除存在于指定集合中的 arraylist 里的所有元素 |
| remove()         | 删除 arraylist 里的单个元素                   |
| size()           | 返回 arraylist 里元素数量                     |
| isEmpty()        | 判断 arraylist 是否为空                       |
| subList()        | 截取部分 arraylist 的元素                     |
| set()            | 替换 arraylist 中指定索引的元素               |
| sort()           | 对 arraylist 元素进行排序                     |
| toArray()        | 将 arraylist 转换为数组                       |
| toString()       | 将 arraylist 转换为字符串                     |
| ensureCapacity() | 设置指定容量大小的 arraylist                  |
| lastIndexOf()    | 返回指定元素在 arraylist 中最后一次出现的位置 |
| retainAll()      | 保留 arraylist 中在指定集合中也存在的那些元素 |
| containsAll()    | 查看 arraylist 是否包含指定集合中的所有元素   |
| trimToSize()     | 将 arraylist 中的容量调整为数组中的元素个数   |
| removeRange()    | 删除 arraylist 中指定索引之间存在的元素       |
| replaceAll()     | 将给定的操作内容替换掉数组中每一个元素        |
| removeIf()       | 删除所有满足特定条件的 arraylist 元素         |
| forEach()        | 遍历 arraylist 中每一个元素并执行特定操作     |

> ## LinkedList

| 方法                                           | 描述                                                                                    |
|------------------------------------------------|-----------------------------------------------------------------------------------------|
| public boolean add(E e)                        | 链表末尾添加元素，返回是否成功，成功为 true，失败为 false。                             |
| public void add(int index, E element)          | 向指定位置插入元素。                                                                    |
| public boolean addAll(Collection c)            | 将一个集合的所有元素添加到链表后面，返回是否成功，成功为 true，失败为 false。           |
| public boolean addAll(int index, Collection c) | 将一个集合的所有元素添加到链表的指定位置后面，返回是否成功，成功为 true，失败为 false。 |
| public void addFirst(E e)                      | 元素添加到头部。                                                                        |
| public void addLast(E e)                       | 元素添加到尾部。                                                                        |
| public boolean offer(E e)                      | 向链表末尾添加元素，返回是否成功，成功为 true，失败为 false。                           |
| public boolean offerFirst(E e)                 | 头部插入元素，返回是否成功，成功为 true，失败为 false。                                 |
| public boolean offerLast(E e)                  | 尾部插入元素，返回是否成功，成功为 true，失败为 false。                                 |
| public void clear()                            | 清空链表。                                                                              |
| public E removeFirst()                         | 删除并返回第一个元素。                                                                  |
| public E removeLast()                          | 删除并返回最后一个元素。                                                                |
| public boolean remove(Object o)                | 删除某一元素，返回是否成功，成功为 true，失败为 false。                                 |
| public E remove(int index)                     | 删除指定位置的元素。                                                                    |
| public E poll()                                | 删除并返回第一个元素。                                                                  |
| public E remove()                              | 删除并返回第一个元素。                                                                  |
| public boolean contains(Object o)              | 判断是否含有某一元素。                                                                  |
| public E get(int index)                        | 返回指定位置的元素。                                                                    |
| public E getFirst()                            | 返回第一个元素。                                                                        |
| public E getLast()                             | 返回最后一个元素。                                                                      |
| public int indexOf(Object o)                   | 查找指定元素从前往后第一次出现的索引。                                                  |
| public int lastIndexOf(Object o)               | 查找指定元素最后一次出现的索引。                                                        |
| public E peek()                                | 返回第一个元素。                                                                        |
| public E element()                             | 返回第一个元素。                                                                        |
| public E peekFirst()                           | 返回头部元素。                                                                          |
| public E peekLast()                            | 返回尾部元素。                                                                          |
| public E set(int index, E element)             | 设置指定位置的元素。                                                                    |
| public Object clone()                          | 克隆该列表。                                                                            |
| public Iterator descendingIterator()           | 返回倒序迭代器。                                                                        |
| public int size()                              | 返回链表元素个数。                                                                      |
| public ListIterator listIterator(int index)    | 返回从指定位置开始到末尾的迭代器。                                                      |
| public Object[] toArray()                      | 返回一个由链表元素组成的数组。                                                          |
| public T[] toArray(T[] a)                      | 返回一个由链表元素转换类型而成的数组。                                                  |

> ## HashMap

| 方法               | 描述                                                                           |
|--------------------|--------------------------------------------------------------------------------|
| clear()            | 删除 hashMap 中的所有键/值对                                                   |
| clone()            | 复制一份 hashMap                                                               |
| isEmpty()          | 判断 hashMap 是否为空                                                          |
| size()             | 计算 hashMap 中键/值对的数量                                                   |
| put()              | 将键/值对添加到 hashMap 中                                                     |
| putAll()           | 将所有键/值对添加到 hashMap 中                                                 |
| putIfAbsent()      | 如果 hashMap 中不存在指定的键，则将指定的键/值对插入到 hashMap 中。            |
| remove()           | 删除 hashMap 中指定键 key 的映射关系                                           |
| containsKey()      | 检查 hashMap 中是否存在指定的 key 对应的映射关系。                             |
| containsValue()    | 检查 hashMap 中是否存在指定的 value 对应的映射关系。                           |
| replace()          | 替换 hashMap 中是指定的 key 对应的 value。                                     |
| replaceAll()       | 将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。                      |
| get()              | 获取指定 key 对应对 value                                                      |
| getOrDefault()     | 获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值                 |
| forEach()          | 对 hashMap 中的每个映射执行指定的操作。                                        |
| entrySet()         | 返回 hashMap 中所有映射项的集合集合视图。                                      |
| keySet()           | 返回 hashMap 中所有 key 组成的集合视图。                                       |
| values()           | 返回 hashMap 中存在的所有 value 值。                                           |
| merge()            | 添加键值对到 hashMap 中                                                        |
| compute()          | 对 hashMap 中指定 key 的值进行重新计算                                         |
| computeIfAbsent()  | 对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中 |
| computeIfPresent() | 对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。       |

> ## Stack 类

| 序号 | 方法描述                                                                                                                         |
|------|----------------------------------------------------------------------------------------------------------------------------------|
| 1    | boolean empty()  测试堆栈是否为空。                                                                                              |
| 2    | Object peek( ) 查看堆栈顶部的对象，但不从堆栈中移除它。                                                                          |
| 3    | Object pop( ) 移除堆栈顶部的对象，并作为此函数的值返回该对象。                                                                   |
| 4    | Object push(Object element) 把项压入堆栈顶部。                                                                                   |
| 5    | int search(Object element) 返回对象在堆栈中的位置，以 1 为基数。                                                                 |


> ## Number Math 类

| 序号 | 方法与描述                                                                                                                                                |
|------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | xxxValue() 将 Number 对象转换为xxx数据类型的值并返回。                                                                                                    |
| 2    | compareTo() 将number对象与参数比较。                                                                                                                      |
| 3    | equals() 判断number对象是否与参数相等。                                                                                                                   |
| 4    | valueOf() 返回一个 Number 对象指定的内置数据类型                                                                                                          |
| 5    | toString() 以字符串形式返回值。                                                                                                                           |
| 6    | parseInt() 将字符串解析为int类型。                                                                                                                        |
| 7    | abs() 返回参数的绝对值。                                                                                                                                  |
| 8    | ceil() 返回大于等于( >= )给定参数的的最小整数，类型为双精度浮点型。                                                                                       |
| 9    | floor() 返回小于等于（<=）给定参数的最大整数 。                                                                                                           |
| 10   | rint() 返回与参数最接近的整数。返回类型为double。                                                                                                         |
| 11   | round() 它表示四舍五入，算法为 Math.floor(x+0.5)，即将原来的数字加上 0.5 后再向下取整，所以，Math.round(11.5) 的结果为12，Math.round(-11.5) 的结果为-11。 |
| 12   | min() 返回两个参数中的最小值。                                                                                                                            |
| 13   | max() 返回两个参数中的最大值。                                                                                                                            |
| 14   | exp() 返回自然数底数e的参数次方。                                                                                                                         |
| 15   | log() 返回参数的自然数底数的对数值。                                                                                                                      |
| 16   | pow() 返回第一个参数的第二个参数次方。                                                                                                                    |
| 17   | sqrt() 求参数的算术平方根。                                                                                                                               |
| 18   | sin() 求指定double类型参数的正弦值。                                                                                                                      |
| 19   | cos() 求指定double类型参数的余弦值。                                                                                                                      |
| 20   | tan() 求指定double类型参数的正切值。                                                                                                                      |
| 21   | asin() 求指定double类型参数的反正弦值。                                                                                                                   |
| 22   | acos() 求指定double类型参数的反余弦值。                                                                                                                   |
| 23   | atan() 求指定double类型参数的反正切值。                                                                                                                   |
| 24   | atan2() 将笛卡尔坐标转换为极坐标，并返回极坐标的角度值。                                                                                                  |
| 25   | toDegrees() 将参数转化为角度。                                                                                                                            |
| 26   | toRadians() 将角度转换为弧度。                                                                                                                            |
| 27   | random() 返回一个随机数。                                                                                                                                 |

> ## Character 类

| 序号 | 方法与描述                                         |
|------|----------------------------------------------------|
| 1    | isLetter() 是否是一个字母                          |
| 2    | isDigit() 是否是一个数字字符                       |
| 3    | isWhitespace() 是否是一个空白字符                  |
| 4    | isUpperCase() 是否是大写字母                       |
| 5    | isLowerCase() 是否是小写字母                       |
| 6    | toUpperCase() 指定字母的大写形式                   |
| 7    | toLowerCase() 指定字母的小写形式                   |
| 8    | toString() 返回字符的字符串形式，字符串的长度仅为1 |

> ## String类

| SN(序号) | 方法描述                                                                                                                         |
|----------|----------------------------------------------------------------------------------------------------------------------------------|
| 1        | char charAt(int index) 返回指定索引处的 char 值。                                                                                |
| 2        | int compareTo(Object o) 把这个字符串和另一个对象比较。                                                                           |
| 3        | int compareTo(String anotherString) 按字典顺序比较两个字符串。                                                                   |
| 4        | int compareToIgnoreCase(String str) 按字典顺序比较两个字符串，不考虑大小写。                                                     |
| 5        | String concat(String str) 将指定字符串连接到此字符串的结尾。                                                                     |
| 6        | boolean contentEquals(StringBuffer sb) 当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。                            |
| 7        | static String copyValueOf(char[] data) 返回指定数组中表示该字符序列的 String。                                                   |
| 8        | static String copyValueOf(char[] data, int offset, int count) 返回指定数组中表示该字符序列的 String。                            |
| 9        | boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结束。                                                               |
| 10       | boolean equals(Object anObject) 将此字符串与指定的对象比较。                                                                     |
| 11       | boolean equalsIgnoreCase(String anotherString) 将此 String 与另一个 String 比较，不考虑大小写。                                  |
| 12       | byte[] getBytes()  使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。                        |
| 13       | byte[] getBytes(String charsetName) 使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。           |
| 14       | void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 将字符从此字符串复制到目标字符数组。                           |
| 15       | int hashCode() 返回此字符串的哈希码。                                                                                            |
| 16       | int indexOf(int ch) 返回指定字符在此字符串中第一次出现处的索引。                                                                 |
| 17       | int indexOf(int ch, int fromIndex) 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。                            |
| 18       | int indexOf(String str)  返回指定子字符串在此字符串中第一次出现处的索引。                                                        |
| 19       | int indexOf(String str, int fromIndex) 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。                        |
| 20       | String intern()  返回字符串对象的规范化表示形式。                                                                                |
| 21       | int lastIndexOf(int ch)  返回指定字符在此字符串中最后一次出现处的索引。                                                          |
| 22       | int lastIndexOf(int ch, int fromIndex) 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。            |
| 23       | int lastIndexOf(String str) 返回指定子字符串在此字符串中最右边出现处的索引。                                                     |
| 24       | int lastIndexOf(String str, int fromIndex)  返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。         |
| 25       | int length() 返回此字符串的长度。                                                                                                |
| 26       | boolean matches(String regex) 告知此字符串是否匹配给定的正则表达式。                                                             |
| 27       | boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) 测试两个字符串区域是否相等。          |
| 28       | boolean regionMatches(int toffset, String other, int ooffset, int len) 测试两个字符串区域是否相等。                              |
| 29       | String replace(char oldChar, char newChar) 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。      |
| 30       | String replaceAll(String regex, String replacement) 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。      |
| 31       | String replaceFirst(String regex, String replacement)  使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。 |
| 32       | String[] split(String regex) 根据给定正则表达式的匹配拆分此字符串。                                                              |
| 33       | String[] split(String regex, int limit) 根据匹配给定的正则表达式来拆分此字符串。                                                 |
| 34       | boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开始。                                                             |
| 35       | boolean startsWith(String prefix, int toffset) 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。                          |
| 36       | CharSequence subSequence(int beginIndex, int endIndex)  返回一个新的字符序列，它是此序列的一个子序列。                           |
| 37       | String substring(int beginIndex) 返回一个新的字符串，它是此字符串的一个子字符串。                                                |
| 38       | String substring(int beginIndex, int endIndex) 返回一个新字符串，它是此字符串的一个子字符串。                                    |
| 39       | char[] toCharArray() 将此字符串转换为一个新的字符数组。                                                                          |
| 40       | String toLowerCase() 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。                                                |
| 41       | String toLowerCase(Locale locale)  使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。                                  |
| 42       | String toString()  返回此对象本身（它已经是一个字符串！）。                                                                      |
| 43       | String toUpperCase() 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。                                                |
| 44       | String toUpperCase(Locale locale) 使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。                                   |
| 45       | String trim() 返回字符串的副本，忽略前导空白和尾部空白。                                                                         |
| 46       | static String valueOf(primitive data type x) 返回给定data type类型x参数的字符串表示形式。                                        |
| 47       | contains(CharSequence chars) 判断是否包含指定的字符系列。                                                                        |
| 48       | isEmpty() 判断字符串是否为空。                                                                                                   |