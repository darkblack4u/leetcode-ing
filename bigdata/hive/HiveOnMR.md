> ## Hive on Mapreduce执行流程 [参考](https://www.jianshu.com/p/a38215b6395c)

![image](https://upload-images.jianshu.io/upload_images/2671133-534a3e316d179cbd?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)

- `Step 1`. UI(user interface) 调用 executeQuery 接口，发送 HQL 查询语句给 Driver
- `Step 2`. Driver 为查询语句创建会话句柄，并将查询语句发送给 Compiler， 等待其进行语句解析并生成执行计划
- `Step 3 and 4`. Compiler 从 metastore 获取相关的元数据
- `Step 5`. 元数据用于对查询树中的表达式进行类型检查，以及基于查询谓词调整分区，生成计划。
- `Step 6 (6.1，6.2，6.3)`. 由 Compiler 生成的执行计划是阶段性的 DAG，每个阶段都可能会涉及到 Map/Reduce job、元数据的操作、HDFS 文件的操作，Execution Engine 将各个阶段的 DAG 提交给对应的组件执行。
- `Step 7, 8 and 9`：在每个任务（mapper / reducer）中，查询结果会以临时文件的方式存储在 HDFS 中。保存查询结果的临时文件由 Execution Engine 直接从 HDFS 读取，作为从 Driver Fetch API 的返回内容。

> ## 从CLI来看run里干了什么 [source](https://github.com/apache/hive/blob/master/cli/src/java/org/apache/hadoop/hive/cli/CliDriver.java)

1. OptionsProcessor 解析参数，使用的是Commons CLI提供的Options类，它是Option对象的容器。[source](https://github.com/apache/hive/blob/master/cli/src/java/org/apache/hadoop/hive/cli/OptionsProcessor.java)
2. create CliSessionState [source](https://github.com/apache/hive/blob/master/cli/src/java/org/apache/hadoop/hive/cli/CliSessionState.java)，创建链接状态，SessionState [source](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/session/SessionState.java#L131)封装与会话关联的公共数据。
3. OptionsProcessor检查session信息
4. HiveConf conf 设置通过命令行指定的所有属性
5. prompt 读取提示符配置（hive.cli.prompt）和替换变量
6. HIVE_CLI_TEZ_SESSION_ASYNC: 在使用Tez运行CLI时，是否在后台启动Tez会话，以允许CLI更早地可用。
7. 更新并且打印当前线程的名称：
8. CalcitePlanner 初始化元数据提供程序类和修剪器，`老版本没有`
9.  创建和初始化视图注册缓存
10. executeDriver执行Driver
11. cliDriver配置参数
12. 执行`use database_name`;
13. 执行`-i`后面跟的`Initialization SQL file`; 
14. 执行`-e`后面的命令/执行`-f`后面的文件，然后return，没有的话，continue
15. Hive逐行输入执行
16. 所有命令都需要通过`processCmd1`发送出去，返回`CommandProcessorResponse`

```java
public int run(String[] args) throws Exception {

    OptionsProcessor oproc = new OptionsProcessor();
    if (!oproc.process_stage1(args)) {
      return 1;
    }

    // NOTE: It is critical to do this here so that log4j is reinitialized
    // before any of the other core hive classes are loaded
    boolean logInitFailed = false;
    String logInitDetailMessage;
    try {
      logInitDetailMessage = LogUtils.initHiveLog4j();
    } catch (LogInitializationException e) {
      logInitFailed = true;
      logInitDetailMessage = e.getMessage();
    }

    CliSessionState ss = new CliSessionState(new HiveConf(SessionState.class));
    ss.in = System.in;
    try {
      ss.out =
          new SessionStream(System.out, true, StandardCharsets.UTF_8.name());
      ss.info =
          new SessionStream(System.err, true, StandardCharsets.UTF_8.name());
      ss.err = new CachingPrintStream(System.err, true,
          StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      return 3;
    }

    if (!oproc.process_stage2(ss)) {
      return 2;
    }

    if (!ss.getIsSilent()) {
      if (logInitFailed) {
        System.err.println(logInitDetailMessage);
      } else {
        SessionState.getConsole().printInfo(logInitDetailMessage);
      }
    }

    // set all properties specified via command line
    HiveConf conf = ss.getConf();
    for (Map.Entry<Object, Object> item : ss.cmdProperties.entrySet()) {
      conf.set((String) item.getKey(), (String) item.getValue());
      ss.getOverriddenConfigurations().put((String) item.getKey(), (String) item.getValue());
    }

    // read prompt configuration and substitute variables.
    prompt = conf.getVar(HiveConf.ConfVars.CLIPROMPT);
    prompt = new VariableSubstitution(new HiveVariableSource() {
      @Override
      public Map<String, String> getHiveVariable() {
        return SessionState.get().getHiveVariables();
      }
    }).substitute(conf, prompt);
    prompt2 = spacesForString(prompt);

    // 在使用Tez运行CLI时，是否在后台启动Tez会话，以允许CLI更早地可用。默认true
    // 如果是false，就
    // 这里的if else 方法都是调用org.apache.hadoop.hive.ql.session.SessionState#start方法
    if (HiveConf.getBoolVar(conf, ConfVars.HIVE_CLI_TEZ_SESSION_ASYNC)) {
      // Start the session in a fire-and-forget manner. When the asynchronously initialized parts of
      // the session are needed, the corresponding getters and other methods will wait as needed.
      // 传入：start(startSs, true, console);
      SessionState.beginStart(ss, console);
    } else {
      // 传入：start(startSs, false, null);
      SessionState.start(ss);
    }
    // 更新并且打印当前线程的名称：
    ss.updateThreadName();

    // Initialize metadata provider class and trimmer
    // 初始化元数据提供程序类和修剪器，老版本没有
    CalcitePlanner.warmup();
    // Create views registry
    // 创建和初始化视图注册缓存
    HiveMaterializedViewsRegistry.get().init();

    // init metastore client cache
    if (HiveConf.getBoolVar(conf, ConfVars.MSC_CACHE_ENABLED)) {
      HiveMetaStoreClientWithLocalCache.init(conf);
    }

    // execute cli driver work
    try {
      executeDriver(ss, conf, oproc);
      return 0;
    } catch (CommandProcessorException e) {
      return e.getResponseCode();
    } finally {
      ss.resetThreadName();
      ss.close();
    }
  }

  /**
   * Execute the cli work
   * @param ss CliSessionState of the CLI driver
   * @param conf HiveConf for the driver session
   * @param oproc Operation processor of the CLI invocation
   * @return status of the CLI command execution
   * @throws Exception
   */
  private CommandProcessorResponse executeDriver(CliSessionState ss, HiveConf conf, OptionsProcessor oproc)
      throws Exception {

    CliDriver cli = new CliDriver();
    cli.setHiveVariables(oproc.getHiveVariables());

    // use the specified database if specified
    cli.processSelectDatabase(ss);

    // Execute -i init files (always in silent mode)
    // 执行-i后面跟的Initialization SQL file 
    cli.processInitFiles(ss);

    // 执行 -e 后面的操作
    if (ss.execString != null) {
      return cli.processLine(ss.execString);
    }

    // 执行 -f 文件
    try {
      if (ss.fileName != null) {
        return cli.processFile(ss.fileName);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Could not open input file for reading. (" + e.getMessage() + ")");
      throw new CommandProcessorException(3);
    }
    if ("mr".equals(HiveConf.getVar(conf, ConfVars.HIVE_EXECUTION_ENGINE))) {
      console.printInfo(HiveConf.generateMrDeprecationWarning());
    }

    setupConsoleReader();

    String line;
    CommandProcessorResponse response = new CommandProcessorResponse();
    StringBuilder prefix = new StringBuilder();
    String curDB = getFormattedDb(conf, ss);
    String curPrompt = prompt + curDB;
    String dbSpaces = spacesForString(curDB);

    while ((line = reader.readLine(curPrompt + "> ")) != null) {
      if (!prefix.toString().equals("")) {
        prefix.append('\n');
      }
      if (line.trim().startsWith("--")) {
        continue;
      }
      if (line.trim().endsWith(";") && !line.trim().endsWith("\\;")) {
        line = prefix + line;
        response = cli.processLine(line, true);
        prefix.setLength(0);;
        curDB = getFormattedDb(conf, ss);
        curPrompt = prompt + curDB;
        dbSpaces = dbSpaces.length() == curDB.length() ? dbSpaces : spacesForString(curDB);
      } else {
        prefix.append(line);
        curPrompt = prompt2 + dbSpaces;
        continue;
      }
    }

    return response;
  }
```

> ## processLocalCmd创建CommandProcessor, 执行用户指令

1. `CommandProcessor proc = CommandProcessorFactory.get(tokens, (HiveConf) conf);` 非SQL查询操作set,reset,dfs,add,list,delete,reload,compile,llap都有对应的Processer，而例如select之类的都new一个IDriver返回。 [CommandProcessorFactory](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/processors/CommandProcessorFactory.java#L41) [DriverFactory](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/DriverFactory.java#L37) [IDriver](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/IDriver.java#L38) [Driver](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/Driver.java#L72)
2. Driver中对command先进行解析，得到QueryPlan 
    - SQL->AST(Abstract Syntax Tree抽象语法树)->QueryPlan [source](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/ql/src/java/org/apache/hadoop/hive/ql/Compiler.java) 
        - SQL->AST: [source](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/parser/src/java/org/apache/hadoop/hive/ql/parse/ParseDriver.java#L41)
          - GenericHiveLexer词法分析器: HiveLexerStandard/HiveLexer
            - 都传入ANTLRNoCaseStringStream [source](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/parser/src/java/org/apache/hadoop/hive/ql/parse/ANTLRNoCaseStringStream.java#L37) extends ANTLRStringStream [source](https://github.com/antlr/antlr3/blob/master/runtime/Java/src/main/java/org/antlr/runtime/ANTLRStringStream.java) ANTLR解析 
          - 封装结果返回 ParseResultd [source](https://github.com/apache/hive/blob/c066d5d2b5098bb7cd4b7a5500cc076c32dccf1e/parser/src/java/org/apache/hadoop/hive/ql/parse/ParseResult.java)
        - analyze()分析，返回BaseSemanticAnalyzer [source](https://github.com/apache/hive/blob/7b3ecf617a6d46f48a3b6f77e0339fd4ad95a420/ql/src/java/org/apache/hadoop/hive/ql/parse/SemanticAnalyzer.java)
          - analyzeInternal:
            - 从语法树生成解析树 QueryBlock
            - 从解析树生成操作树 genOPTree
            - Deduce Resultset Schema
            - `为优化器和物理编译器生成分析上下文`
            - 创建视图
            - Generate table access stats if required
            - 执行逻辑优化 `Optimizer`
            - 可能的话，进行列裁剪
            - 优化物理操作树并转换为目标执行引擎 `compilePlan` [MapReduceCompiler](https://github.com/apache/hive/blob/7b3ecf617a6d46f48a3b6f77e0339fd4ad95a420/ql/src/java/org/apache/hadoop/hive/ql/parse/MapReduceCompiler.java#L76)/SparkCompiler/TezCompiler