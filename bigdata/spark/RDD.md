# RDD

> **`RDD`**

RDD（Resilient Distributed Dataset）叫做`弹性分布式数据集`，是Spark中最基本的`数据抽象`，它代表一个不可变、可分区、里面的元素可并行计算的集合。RDD具有数据流模型的特点：`自动容错`、`位置感知性调度`和`可伸缩性`。RDD允许用户在执行多个查询时显式地将工作集缓存在内存中，后续的查询能够重用工作集，这极大地提升了查询速度。

> **`RDD基本属性`** [source](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/RDD.scala)

- A list of partitions
    - `protected def getPartitions: Array[Partition]`: 由子类实现以返回此RDD中的分区集。此方法只调用一次，因此在其中实现耗时的计算是安全的
    - `HadoopRDD`中会根据文件的个数与大小来生成Partition，关键因素[FileInputFormat](https://github.com/apache/hadoop/blob/trunk/hadoop-mapreduce-project/hadoop-mapreduce-client/hadoop-mapreduce-client-core/src/main/java/org/apache/hadoop/mapreduce/lib/input/FileInputFormat.java)中的getSplits判断文件isSplitable，如果可以拆分，就生成多个，不可以就只能返回一个。
- A function for computing each split
    - `def compute(split: Partition, context: TaskContext): Iterator[T]`: 由子类实现以计算给定分区。
    - `HadoopRDD`里的实现就是个reader读文件。
- A list of dependencies on other RDDs 依赖关系
    - `protected def getDependencies: Seq[Dependency[_]] = deps`: 由子类实现，以返回此RDD如何依赖于父RDD。此方法只调用一次，因此在其中实现耗时的计算是安全的。
    - `HadoopRDD`里无实现。
    - `UnionRDD`里依赖于每一个父RDD
- Optionally, a Partitioner for key-value RDDs (e.g. to say that the RDD is hash-partitioned) 独立写一个KV的RDD，可以用Hash处理
- Optionally, a list of preferred locations to compute each split on (e.g. block locations for an HDFS file)
    - `HadoopRDD`里获得的是分片位置信息。

> **`RDD血缘关系`**

​RDD只支持`粗粒度转换`，即在大量记录上执行的单个操作。将创建RDD的一系列Lineage（血统）记录下来，以便恢复丢失的分区。RDD的Lineage会记录RDD的`元数据信息`和`转换行为`，当该RDD的部分分区数据丢失时，它可以根据这些信息来重新运算和恢复丢失的数据分区。

查看RDD的血缘方法：rdd.toDebugString

> **`依赖关系`**

依赖关系： 当前RDD和和父RDD之间的依赖关系，查看依赖关系方法：`rdd.dependencies`

```
//不依赖于任何RDD
List()
----------------------
// 1对1(1父1子)依赖  (窄依赖),窄依赖不会划分Stage
List(org.apache.spark.OneToOneDependency@1eaf1e62)
----------------------
//1对N（1父多子）依赖（宽依赖或shuffle依赖）,宽依赖会划分Stage
List(org.apache.spark.ShuffleDependency@5fad41be)
```

> **`RDD的宽窄依赖`**

1. 窄依赖 (NarrowDependency/OneToOneDependency)，每一个父RDD的Partition只能被子RDD的一个Partition使用，窄依赖我们形象的比喻为独生子女。
2. 宽依赖 (ShuffleDependency)，同一个父RDD的Partition被多个子RDD的Partition依赖，会引起Shuffle，宽依赖我们形象的比喻为多生。

> **`任务划分`**

RDD任务切分中间分为：Application、Job、Stage和Task
- `Application`：初始化一个SparkContext即生成一个Application；
- `Job`：一个Action算子就会生成一个Job；
- `Stage`：Stage等于宽依赖(ShuffleDependency)的个数加1；
- `Task`：一个Stage阶段中，最后一个RDD的分区个数就是Task的个数。Task的类型分为2种：ShuffleMapTask和ResultTask。

注意：**`Application->Job->Stage->Task每一层都是1对n的关系。`**

> **`RDD缓存`**

`persist()`/`cache()`，persist默认StorageLevel.MEMORY_ONLY，cache==persist

```Scala
    def persist(): this.type = persist(StorageLevel.MEMORY_ONLY)
    def cache(): this.type = persist()
```