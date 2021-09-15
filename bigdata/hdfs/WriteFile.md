> # HDFS写文件流程

`HDFS（Hadoop Distributed File System`）是GFS的开源实现。特点如下：

- 能够运行在廉价机器上，硬件出错常态，需要具备高容错性
- 流式数据访问，而不是随机读写
- 面向大规模数据集，能够进行批处理、能够横向扩展
- 简单一致性模型，假定文件是一次写入、多次读取

缺点：

- 不支持低延迟数据访问
- 不适合大量小文件存储（因为每条元数据占用空间是一定的）
- 不支持并发写入，一个文件只能有一个写入者
- 不支持文件随机修改，仅支持追加写入

> ### `block`

这个大家应该知道，文件上传前需要分块，这个块就是block，一般为128MB，当然你可以去改，不顾不推荐。因为块太小：寻址时间占比过高。块太大：Map任务数太少，作业执行速度变慢。它是最大的一个单位。

> ### `packet`

packet是第二大的单位，它是client端向DataNode，或DataNode的PipLine之间传数据的基本单位，默认64KB。

> ### `chunk`

chunk是最小的单位，它是client向DataNode，或DataNode的PipLine之间进行数据校验的基本单位，默认512Byte，因为用作校验，故每个chunk需要带有4Byte的校验位。所以实际每个chunk写入packet的大小为516Byte。由此可见真实数据与校验值数据的比值约为128 : 1。（即64*1024 / 512）

在client端向DataNode传数据的时候，HDFSOutputStream会有一个`chunk buff`，写满一个`chunk`后，会计算校验和并写入`当前的chunk`。之后再把带有校验和的chunk写入`packet`，当一个`packet写满`后，packet会进入`dataQueue`队列，其他的DataNode就是从这个`dataQueue`获取client端上传的数据并存储的。同时一个DataNode成功存储一个packet后之后会返回一个`ack packet`，放入`ack Queue`中。
