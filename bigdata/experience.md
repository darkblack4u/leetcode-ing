> ## mr过程

![image](https://img-blog.csdn.net/20170827154244422)

![image](http://p2.pstatp.com/large/pgc-image/15266254152789f8c307dee)

> **`MapReduce中排序发生在哪几个阶段？？这些排序是否可以避免，为什么？？`**

发生sort有两个地方
- 一个是在map side发生在spill后 partition前
    - map端排序是为了减轻reduce端排序的压力。在spark中，除了sort的方法，也提供hashmap，用户可配置，毕竟sort开销太大了。
- 一个是在reduce side 发生在copy后 reduce前
    - MR在reduce阶段需要分组，将key相同的放在一起进行规约，为了达到该目的，有两种算法：hashmap和sort，前者太耗内存，而排序通过外排可对任意数据量分组，只要磁盘够大就行。

> **`Hadoop中分片split的原理解析`**

split：split是逻辑切片，在mapreduce中的map task开始之前，将文件按照指定的大小切割成若干个部分，每一部分称为一个split，默认是split的大小与block的大小相等，均为128MB。

在优化过程中，若想调整split大小控制map task的数量，原则如下：
文件大小不变，minsize大小默认，增加map task数量，减小maxSize，则split减小

文件大小不变，maxSize大小默认，减小map task数量，增大minSize，则split增大

注意：split大小如何调整，split只能是一个文件的分片，不能让多个小文件“划入”一个split中

> ## 