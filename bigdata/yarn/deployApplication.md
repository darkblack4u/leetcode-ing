> ### Yarn作业执行流程

1. 客户端`Client`提交job后（job.submit()），`Yarn`的`ResourceManager`会返回本次所提交的job的`提交路径`（hdfs://xxx../staging）和`applicationid`，然后拼接为一个job的资源提交路径 （hdfs://…./staging/jobid）

1. 用户`Client`向`YARN ResourceManager`中提交应用程序，其中包括`MRAppMaster`程序（job.split、job.xml、job.jar），启动`MRAppMaster`的命令，用户程序等。

2. `ResourceManager` 为该程序分配第一个`Container`，并与对应的`NodeManager`通讯，要求它在这个`Container`中启动应用程序`MRAppMaster`。

3. `MRAppMaster`首先向`ResourceManager`注册，这样用户可以直接通过`ResourceManager`查看应用程序的运行状态，然后将为各个任务申请资源，并监控它的运行状态，直到运行结束，重复 4 到 7 的步骤。

4. `MRAppMaster` 采用轮询的方式通过 `RPC` 协议向 `ResourceManager` 申请和领取资源。

5. 一旦 `MRAppMaster` 申请到资源后，便与对应的 `NodeManager` 通讯，要求它启动任务。

6. `NodeManager` 为任务设置好运行环境（包括环境变量、JAR 包、二进制程序等）后，将任务启动命令写到一个脚本中，并通过运行该脚本启动任务。

7. 各个任务通过某个 RPC 协议向 `MRAppMaster` 汇报自己的状态和进度，以让 `MRAppMaster` 随时掌握各个任务的运行状态，从而可以在任务败的时候重新启动任务。