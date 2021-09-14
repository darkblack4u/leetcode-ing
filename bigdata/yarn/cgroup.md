> ## **`yarn使用cgroup隔离cpu资源`**

- 参考文献 https://blog.csdn.net/leone911/article/details/77849271

yarn默认只管理内存资源，虽然也可以申请cpu资源，但是在没有cpu资源隔离的情况下效果并不是太好。在集群规模大，任务多时资源竞争的问题尤为严重。

还好yarn提供的`LinuxContainerExecutor`可以通过`cgroup`来隔离cpu资源。

> ### `通过cgroup隔离cpu资源的步骤为`

1. 在cpu目录创建分组

- cgroup以组为单位隔离资源，同一个组可以使用的资源相同。
- 一个组在cgroup里面体现为一个文件夹，创建分组直接使用mkdir命令即可。
- 组下面还可以创建下级组。最终可以形成一个树形结构来完成复杂的资源隔离方案。每当创建了一个组，系统会自动在目录立即创建一些文件，资源控制主要就是通过配置这些文件来完成。

2. yarn默认使用`hadoop-yarn`组作为最上层，任务运行时yarn会为`每个container`在hadoop-yarn里面创建一个组，yarn主要使用`cpu.cfs_quota_us cpu.cfs_period_us cpu.shares`3个文件

yarn使用cgroup的两种方式来控制cpu资源分配

- 严格按核数隔离资源
    - `可使用核数` = cpu.cfs_quota_us/cpu.cfs_period_us
    - 在yarn中cpu.cfs_quota_us被直接设置为1000000(这个参数可以设置的最大值)
然后根据任务申请的core来计算出cpu.cfs_period_us
- 按比例隔离资源
    - 按每个分组里面cpu.shares的比率来分配cpu
    - 比如A B C三个分组,cpu.shares分别设置为1024 1024 2048,那么他们可以使用的cpu比率为1:1:2

3. 将`进程id`添加到指定组的tasks文件，创建完分组后只需要将要限制的进程的id写入tasks文件即可，如果需要解除限制，在tasks文件删除即可。

> ### 配置请参考 http://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/NodeManagerCgroups.html