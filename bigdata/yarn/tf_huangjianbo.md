> # Yarn-TF

> ## Client

> 1. 初始化client

```java
Client client = new Client();  this(new YarnConfiguration());
-> Client(Configuration conf); this("distributedshell.ApplicationMaster", conf);
-> Client(String appMasterMainClass, Configuration conf)
```

```java
client.init(args)
-> init(String[] args)
    -> buildMounts(val);// 怎加参数YARN_CONTAINER_RUNTIME_DOCKER_MOUNTS，获得环境的挂载信息
    -> outputPairs // 增加output参数用来确认输出路径是否合法
    -> num_parameter_servers/num_trainers // RUNTIME_DISTRIBUTED_TENSORFLOW专用参数
```

```java
result = client.run();
-> 
```

> ## ApplicationMaster

> 1. LaunchContainerRunnable run()

```java
// commands to execute
List<String> commands = new ArrayList<String>();
-> commands.add("tar -xf " + TAR_PATH); // tarPath文件，从HDFS上拿下来
-> commands.addAll(linkCommands);
    -> linkCommands.add(String.format("rm -rf %s; ln -s %s %s",
                        segs[1], segs[0], segs[1].replaceAll("/+$", ""))); // 硬盘挂载对应信息
-> commands.add(Utils.getDistributedShellCommand(shellCommand, shellArgs)); //实际命令行
    -> shellCommand: 命令行
    -> shellArgs: TensorFlow分布式所需参数（见下面TensorFlow分布式部署）
-> commands.addAll(outputCommands); //"cp -r %s %s", segs[0], segs[1] 转移结果到指定output目录
```

> ## Using GPU On YARN [api](https://hadoop.apache.org/docs/stable/hadoop-yarn/hadoop-yarn-site/UsingGpus.html) 3.2.0之后 LinuxContainerExecutor

在resource-types.xml中

```xml
<configuration>
  <property>
     <name>yarn.resource-types</name>
     <value>yarn.io/gpu</value>
  </property>
</configuration>
```



> ## TensorFlow分布式部署 [api](https://tensorflow.juejin.im/deploy/distributed.html)

在PS-Worker架构中，集群中的节点被分为两类：`参数服务器`（`parameter server`）和`工作服务器`（`worker`）。其中参数服务器存放模型的参数，而工作服务器负责计算参数的梯度。在每个迭代过程，工作服务器从参数服务器中获得参数，然后将计算的梯度返回给参数服务器，参数服务器聚合从工作服务器传回的梯度，然后更新参数，并将新的参数广播给工作服务器。

![image](https://support.huaweicloud.com/ug-tf-training-tensorflow/figure/zh-cn_image_0280171120.png)

TensorFlow Cluster是一组参与分布式执行 TensorFlow 计算图的“任务（Task）”集合。
- 每个任务都与一个 TensorFlow 服务器（Server） 相关联，TensorFlow 服务器中包含一个可以用来创建会话（sessions）的`Master`，和一个在计算图中执行命令的`Worker`。
- 一个集群同样可以被分为一个或多个“作业（Job）”，每个作业又包含一个或多个任务。

要创建一个群集，我们在群集中为`每个任务`启动一个 TensorFlow 服务器。通常每个任务运行在不同的机器上，但是这里我们在一台机器上运行多个任务（例如，控制不同的GPU设备）。 我们在每个任务中都做如下操作：

- 在集群中创建一个描述所有任务的 `tf.train.ClusterSpec`。它对每个任务而言都应该是相同的。
- 创建一个 `tf.train.Server`，将 tf.train.ClusterSpec 传给构造函数，并用工作名称标识本地任务和任务索引。

综上，所需四个参数：
- ps_hosts
- worker_hosts
- job_name: `ps` 或者 `worker`
- task_index

```Bash
# 要启动两个参数服务器和两个 Worker 的训练，请使用下面的命令行脚本（假设脚本被称为 trainer.py）
# On ps0.example.com:
$ python trainer.py \
     --ps_hosts=ps0.example.com:2222,ps1.example.com:2222 \
     --worker_hosts=worker0.example.com:2222,worker1.example.com:2222 \
     --job_name=ps --task_index=0
# On ps1.example.com:
$ python trainer.py \
     --ps_hosts=ps0.example.com:2222,ps1.example.com:2222 \
     --worker_hosts=worker0.example.com:2222,worker1.example.com:2222 \
     --job_name=ps --task_index=1
# On worker0.example.com:
$ python trainer.py \
     --ps_hosts=ps0.example.com:2222,ps1.example.com:2222 \
     --worker_hosts=worker0.example.com:2222,worker1.example.com:2222 \
     --job_name=worker --task_index=0
# On worker1.example.com:
$ python trainer.py \
     --ps_hosts=ps0.example.com:2222,ps1.example.com:2222 \
     --worker_hosts=worker0.example.com:2222,worker1.example.com:2222 \
     --job_name=worker --task_index=1
```