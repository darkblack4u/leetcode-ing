> 1. `Namenode的安全模式？`

安全模式是Namenode的一种状态（Namenode主要有active/standby/safemode三种模式）。

> 2. `哪些情况下，Namenode会进入安全模式？`

- Namenode发现集群中的block丢失率达到一定比例时（默认0.01%），Namenode就会进入安全模式，在安全模式下，客户端不能对任何数据进行操作，只能查看元数据信息
- 在hdfs集群正常冷启动时，Namenode也会在safemode状态下维持相当长的一段时间，此时你不需要去理会，等待它自动退出安全模式即可

> 3. `为什么，在HDFS集群冷启动时，Namenode会在安全模式下维持相当长的一段时间？`

Namenode的`内存元数据`中，包含文件路径、副本数、blockid，及每一个block所在Datanode的信息，而`fsimage中不包含block所在的Datanode信息`。
- 当Namenode冷启动时，此时内存中的元数据只能从fsimage中加载而来，从而就没有block所在的Datanode信息
- 就会导致Namenode认为所有的block都已经丢失
- 进入安全模式
- 所在的Datanode信息启动后，会定期向Namenode汇报自身所持有的block信息
- 随着Datanode陆续启动，从而陆续汇报block信息，Namenode就会将内存元数据中的block所在Datanode信息补全更新
- 找到了所有block的位置，从而自动退出安全模式

> 4. `如何退出安全模式？`

- 找到问题所在，进行修复（比如修复宕机的所在Datanode信息补全更新）
- 可以手动强行退出安全模式：hdfs namenode --safemode leave 【不推荐，毕竟没有真正解决问题】

> 7. `fsimage是否存放了block所在服务器信息 ？`

- 在edits中保存着每个文件的操作详细信息
- 在fsimage中保存着文件的名字、id、分块、大小等信息，但是不保存Datanode 的IP
- 在hdfs启动时处于安全模式，Datanode 向Namenode汇报自己的IP和持有的block信息