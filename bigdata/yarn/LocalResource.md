> # LocalResource [Source](https://github.com/apache/hadoop/blob/trunk/hadoop-yarn-project/hadoop-yarn/hadoop-yarn-api/src/main/java/org/apache/hadoop/yarn/api/records/LocalResource.java)

就是Application Master或者其下管理的Task运行所需要从`HDFS``下载`到`本地`的资源，你在提交APP时，`要自己上传文件到HDFS`，然后指定需要的LocalResource所在HDFS的Path

```java
Map<String, LocalResource> localResources = new HashMap<String, LocalResource>();

LocalResource shellRsrc = LocalResource.newInstance(yarnUrl,
                        LocalResourceType.FILE,
                        LocalResourceVisibility.APPLICATION, tarPathLen,
                        tarPathTimestamp);
localResources.put(TAR_PATH, shellRsrc);
```

然后，你可以启动一个新的Container了。这里需要注意的几点是：
- LocalResourceType是为了告诉NodeManager在启动这个Container之前，下载资源列表后，要按照何种方式来处理这些文件。比如，ARCHIVE表示这是一个压缩档，必须解压后程序才能使用。
- 在往Map<String, LocalResource>里添加资源时，这个key的作用是，这个文件被NodeManager本地化时会创建一个链接到该文件（这个文件会在一个缓存目录下，并不是在Container的工作区间），`这个链接的命名就是你的key`，对于普通文件还好，但是对于`压缩包就意味着解压后一定会在key这个目录`下，所以注意文件的路径变化。