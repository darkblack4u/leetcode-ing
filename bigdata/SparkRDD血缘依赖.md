# RDD依赖关系

1. RDD血缘关系
​ RDD只支持粗粒度转换，即在大量记录上执行的单个操作。将创建RDD的一系列Lineage（血统）记录下来，以便恢复丢失的分区。RDD的Lineage会记录RDD的元数据信息和转换行为，当该RDD的部分分区数据丢失时，它可以根据这些信息来重新运算和恢复丢失的数据分区。

查看RDD的血缘方法：rdd.toDebugString

2. 依赖关系
依赖关系： 当前RDD和和父RDD之间的依赖关系

查看依赖关系方法：rdd.dependencies

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

3. RDD的宽窄依赖
窄依赖 (NarrowDependency)

每一个父RDD的Partition只能被子RDD的一个Partition使用，窄依赖我们形象的比喻为独生子女。

宽依赖 (ShuffleDependency)

同一个父RDD的Partition被多个子RDD的Partition依赖，会引起Shuffle，宽依赖我们形象的比喻为多生。

4. 任务划分
RDD任务切分中间分为：Application、Job、Stage和Task

Application：初始化一个SparkContext即生成一个Application；

Job：一个Action算子就会生成一个Job；

Stage：Stage等于宽依赖(ShuffleDependency)的个数加1；

Task：一个Stage阶段中，最后一个RDD的分区个数就是Task的个数。

注意：**Application->Job->Stage->Task每一层都是1对n的关系。**