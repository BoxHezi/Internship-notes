# Week 1 Notes

## 学习任务

- [ ] 学习《阿里巴巴 Java 开发手册》
- [x] 学习 MySQL 数据库，git，maven，单元测试
- [ ] 复习常见的数据结构&算法知识：
  - [ ] 链表
  - [ ] 树
  - [x] 字符串
  - [x] 查询算法
  - [x] 排序算法
  - [x] 贪心算法
  - [x] 动态规划
- [ ] 针对以上做思考归纳总结

## 下周抽查内容

1. 抽查验收《阿里巴巴 Java 开发手册》学习情况
2. 思考总结归纳文档

---

## Monday

1. 复习 HashMap 数据结构
   1. HashMap 底层数据结构为**数组+链表/红黑树**，链表为单向链表
   2. 计算链表数组的 Hash 值时，使用扰动函数以达到散列的效果，将下标尽可能的分散
   3. 位运算的效率最高，左移 1 位相当于 ×2，右移 1 位相当于 ÷2
   4. 当数组长度>64 && 单个链表长度>8，将链表转换成红黑树
   5. 当元素个数达到阈值时，会进行扩容，默认负载因为位 0.75，默认初始容量为 16。即，当元素个数达到 12 时，首次进行扩容。每次扩容后，容量 ×2。
   6. 扩容后，若已存在的元素的下标产生变化，则新的的下标为：元素目前下标+原数组长度。e.g. 若初始数组长度位 16。有一个元素的 key 为 17，则原本下标为 1。新下标为：1+16=17
   7. 扩容时，当某个数组中的链表元素>1 时，通过计算当前元素的**hash & 原数组容量**获得新的下标。e.g. 原数组容量为 16。若某个元素为 20:
      > 20 = 10100, 16 = 10000
      >
      > 10100  
      > 10000 &  
      > \-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-  
      > 10100 = 20(dec)

- Reference:
  - [知乎：JDK 源码中 HashMap 的 hash 方法原理是什么？](https://www.zhihu.com/question/20733617)
  - [Bilibili: 马士兵教育，阿里二面：HashMap 数据结构讲解、关键参数、源码分析](https://www.bilibili.com/video/BV1WA411t7dM?t=6035)

---

## Tuesday

1. Git - [对比 Git 与 SVN，这篇讲的很易懂](https://zhuanlan.zhihu.com/p/48148269)

   1. Git 是一个分布式的版本管理系统
   2. Git 核心概念就是一个工作流
      1. 工作区（workspace）
      2. 暂存区（staging）
      3. 仓库 （repository） - 仓库分为本地仓库和远程仓库
   3. 提交代码分为：
      1. `git add`将工作区文件提交到暂存区
      2. `git commit`将暂存区文件提交到本地仓库，常用命令为：`git commit -m [commit message]`
      3. `git push`将本地仓库提交到远程仓库
   4. pull vs fetch
      1. `git pull` 下载远程仓库的内容直接到工作区中。換句话说，`git pull` = `git fetch` + `git merge` [官方文档](https://git-scm.com/docs/git-pull)
      2. `git fetch` 更新远程仓库的内容到本地仓库中。当本地没有任何的更新时，`git fetch`相当与查看远程仓库的变动
   5. 常用命令
      1. 初始化
         1. `git init` - 在当前目录创建一个本地仓库
         2. `git clone [url]` - 下载一个项目及其所有 git 历史
      2. 配置
         1. `git config -l` - 查看 git 配置
         2. `git config --global user.name "[user name]"` - 设置提交时的用户信息
         3. `git config --global user.email "[email address]"` - 设置提交时的用户信息
         4. `git config credential.helper "cache --timeout=[time in second]"` - 设置验证信息缓存，以秒为单位，3600 为 1 小时
      3. 增删文件
         1. `git add .` - 添加当前目录以及所有子目录的所有文件到暂存区
         2. `git add [files]` - 添加指定文件到暂存区，可同时指定多个文件，用空格隔开
         3. `git add <dir>` - 添加指定目录以及子目录的所有文件到暂存区
         4. `git rm [files]` - 停止追踪指定文件，可同时指定多个文件，用空格隔开
            > 将文件添加到`.gitignore`中可以告诉 git 不去追踪相应的文件 e.g. `echo ".idea/" > .gitignore`git 不会追踪.idea/目录以及其子目录
      4. 分支
         1. `git branch` - 列出所有本地分支
         2. `git branch -a` - 列出所有本地以及远程分支
         3. `git branch [branch name]` - 新建新的本地分支
         4. `git checkout [branch name]` - 切换到指定本地分支
         5. `git checkout -b [branch name]` - 新建并切换至指定本地分支
         6. `git merge [branch name]` - 将指定分支合并到当前分支
         7. `git push [remote]:[remote branch]` - 删除远程分支
      5. 提交&拉取
         1. `git commit -m [message]` - 提交暂存区文件到本地仓库，并添加提交信息
         2. `git fetch [remote]` - 下载远程仓库所有变动到本地仓库
         3. `git pull` - 下载远程仓库所有变动并合并到当前分支
      6. 撤销
         1. `git checkout [files]` - 将指定文件从暂存区恢复到工作去，可同时指定多个文件，用空格隔开
         2. `git checkout .`- 将暂存区中所有文件恢复到工作区
         3. `git checkout [commit id]` - 将工作去恢复到指定的 commit
   6. [git 工作流](./img/git-workflow.png)

2. Maven - [Tutorialspoint - Maven](https://www.tutorialspoint.com/maven/)
   1. Maven 是一个项目管理工具，可以对 Java 项目进行构建、依赖管理
   2. 约定配置 - Maven 采用约定优先于配置
      1. `${basedir}` - pom.xml 和所有子目录
      2. `${basedir}/src/main/java` - 项目 Java 源码
      3. `${basedir}/src/main/resources` - 项目资源，springmvc.xml 等
      4. `${basedir}/src/test/java` - 测试类
      5. `${basedir}/src/test/resources` - 测试资源
      6. `${basedir}/src/main/webapp/WEB-INF` - web 应用文件目录，web 项目信息。web.xml，图片，views 等
      7. `${basedir}/target` - 打包输出目录
      8. `${basedir}/target/classes` - 编译输出目录
      9. `${basedir}/target/test-classes` - 测试编译输出目录
   3. Maven 构建 Java 项目 - `mvn archetype:generate "-DgroupId=test.maven.internship" "-DartifactId=internshipMavenTest" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"`
      1. -DgroupId: 项目名，包
      2. -DartifactId: 项目名+模块名
      3. -DarchetypeArtifactId： 指定 ArchetypeId
      4. -DinteractiveMode：是否使用交互模式
   4. 常用命令
      1. `mvn comppile`：将 Java 源码编译为 class 文件
      2. `mvn test`： 测试，并生成测试报告
      3. `mvn clean`： 删除已编译的 class 文件
      4. `mvn package`： 打包，默认为 jar 包，可在 pom.xml 中更改
      5. `mvn install`： 将项目生成 jar 包

---

## Wednesday

1. MySQL

   1. 事务 4 个特性 （ACID）
      1. Atomicity - 原子性。单个事务中的所有操作要被看为一个整体，一整个逻辑单元。这个逻辑单元中的语句，要么都执行，要么都不执行。
      2. Consistency - 一致性。事务不能破坏关系数据的完整性以及业务逻辑上的一致性。例如，A 转钱给 B，无论事务成功与否，A 和 B 的存款总量应保持一致。
      3. Isolation - 不同事务之间是独立存在的。当多个事务对同一数据进行处理时，必须等到前面的事务完成以后再执行。
      4. Durability - 持久性。当事务成功执行以后，这个事务多数据库的改变应该是永久的。比如，事务成功执行以后，系统故障导致数据库崩溃，恢复后数据库中的数据应该和事务成功执行后的状态。
   2. DDL - Data Definition Language - 数据定义语言
      1. CREATE TABLE: 创建 table  
         `CREATE TABLE <table name> {`  
         `<属性名称> <数据类型> [NOT NULL/AUTO INCREMENT],`  
         `<属性名称> <数据类型> [NOT NULL/AUTO INCREMENT],`  
         `PRIMARY KEY (主键属性),`  
         `}`
         > 可以有多个属性共同组成主键
      2. DROP TABLE: 删除 table  
         `DROP TABLE <table name>`
      3. ALTER TABLE: 改变 table
         1. 添加 column  
            `ALTER TABLE <table name>`  
            `ADD COLUMN <属性名称> <数据类型> [NOT NULL/AUTO INCREMENT]`
         2. 删除 column  
            `ALTER TABLE <table name>`  
            `DROP COLUMN <属性名称>`
         3. 改变 column  
            `ALTER TABLE <table name>`  
            `ALTER COLUMN <属性名称> <数据类型> [NOT NULL/AUTO INCREMENT]`
   3. DQL - Data Query Language - 数据查询语言
      1. 基本语法:  
         `SELECT <目标属性> FROM <table name> [WHERE条件] [ORDER BY条件]`
         > 目标属性为"\*"时代表所选 table 中的所有属性
      2. WHERE 条件 vs HAVING 条件  
         WHERE 作用在每一条数据中,而不能作用在使用了汇总后的数据  
         HAVING 可以作用在汇总后的数据
         - [SQL Tutorial](https://www.sqltutorial.org/sql-having/)
         - [GeeksforGeeks](https://www.geeksforgeeks.org/having-vs-where-clause-in-sql/)
   4. DML - Data Manipulation Language - 数据操纵语言
      1. 插入 - INSERT  
         `INSERT INTO <table name> VALUES()`
      2. 更新 - UPDATE  
         `UPDATE <table name> SET <属性=值> WHERE条件`
         > 务必添加 WHERE 条件，否则整张表的数据都会被更新
      3. 删除 - DELETE  
         `DELETE FROM <table name> WHERE条件`
         > 务必添加 WHERE 条件，否则整张表的数据都会被删除
   5. 存储引擎

      1. InnoDB
         1. 支持事务（ACID），行锁定，外键
      2. MyISAM
         1. 较高的插入、查询速度，但不支持事务（ACID）
      3. Memory（HEAP）

         1. 存放于内存中

      > InnoDB 以及 MyISAM 都使用 B+ Tree  
      > Reference:
      >
      > - [Mysql 存储引擎的区别和比较](https://blog.csdn.net/zgrgfr/article/details/74455547)
      > - [MySQL - 常见的三种存储引擎](https://segmentfault.com/a/1190000012588602)
      > - [YouTube B+ Tree Basic](https://www.youtube.com/playlist?list=PLI46DdbusvteROkxQi5sIXMZE0JblnjCh)

---

## Thursday

1. 单元测试 JUnit Test

   1. Junit 注解

      1. @Before: 每一个测试例方法**被调用前**都会被调用
      2. @After: 每一个测试例方法**被调用后**都会被调用
      3. @Test: 被标注的方法为测试例方法
      4. @BeforeClass: 在测试类**所有的**测试例方法被调用前被调用
      5. @AfterClass: 在测试类**所有的**测试例方法被调用后被调用
         > @BeforeClass 以及 @AfterClass 所标注的方法必须是**静态(static)方法**  
         > [StackOverflow: Why must jUnit's fixtureSetup be static?](https://stackoverflow.com/questions/1052577/why-must-junits-fixturesetup-be-static)

      > 代码执行逻辑为:  
      > ExampleTest.beforeClass();
      > ExampleTest test1 = new ExampleTest();  
      > test1.before();  
      > test1.test();  
      > test1.after();  
      > ExampleTest.afterClass();

   2. Junit 断言 (assert)
      1. assertTrue(条件): 若条件为 true, 则 pass, 否则 fail
      2. assertFalse(条件): 若条件为 false, 则 pass, 否则 fail
      3. assertEquals(expected, actual): 若 **expected.equals(actual)**, 则 pass, 否则 fail
      4. assertSame(expected, actual): 若 **expected == actual**, 则 pass, 否则 fail
      5. fail(): 直接 fail

2. 动态规划 - Dynamic Programming

   1. 递归中存在重叠子问题(Overlapping subproblems)
      1. Recursion vs Dynamic Programming - Fibonacci used as exampe
         1. Time Complexity
            1. Dynamic Programming: O(n)
            2. Recursion: O(2^n)
         2. Space COmplexity
            1. Dynamic Programming: O(1)
            2. Recursion: O(n)
               > [Dynamic Programming vs Recursion](https://weibeld.net/algorithms/recursion.html)
   2. 遇到可以使用递归或动态规划解决的问题时,首先分析问题的出口

   > [Fibonacci in Java](https://github.com/BoxHezi/Internship-notes/blob/master/week1/code/Fibonacci.java)  
   > [Bilibili 动态规划(第一讲)](https://www.bilibili.com/video/BV18x411V7fm)  
   > [Bilibili 动态规划(第二讲)](https://www.bilibili.com/video/BV12W411v7rd)

---

## Friday

1. 排序算法 - （默认升序）
   1. 冒泡
      1. 两两元素进行比较，若 arr[n] > arr[n+1]，则交换两元素位置
      2. 接着比较 n[n+1]和 n[n+2]，以此类推。
      3. 时间复杂度： O(n^2), 空间复杂度 O(1)
   2. 选择
      1. 找到数组中的最小的元素，将其和第一个元素交换
      2. 重复第一步，忽略已经排好序的元素
      3. 时间复杂度： O(n^2), 空间复杂度 O(1)
   3. 插入
      1. 从数组的第二个元素开始，把选择的元素与该元素前面的元素进行比较
      2. 若 arr[n] < arr[n-1]，则继续比较 arr[n]和 arr[n-2]，直到 arr[n] > arr[n-k]，把 arr[n]放到 arr[n-k+1]的位置上。
      3. 重复第二步，直到数组中的元素被全部遍历
      4. 时间复杂度： O(n^2), 空间复杂度 O(1)
   4. 归并
      1. 将已有的数组进行分解，直到每个数组的大小为 1，此时每个数组均为有序数组。
      2. 将小数组进行合并，与此同时，进行排序。首次合并时，每个数组大小为 1，此时排序速度很快。
      3. 重复第二步，将已合并的数组再次进行合并，直到所有数组被合并为 1 个数组。
      4. 时间复杂度： O(n × log(n)), 空间复杂度 O(n)
   5. 快速
      1. 从数组中随机挑选一个元素，作为基准(pivot)
      2. 将所有小于基准的元素，放到 pivot 前；所有大于基准的元素，放置 pivot 后。此时得到 2 个子数组
      3. 对每个子数组重复 1，2 两步
      4. 时间复杂度： O(n × log(n)), 空间复杂度 O(log(n))

| 排序算法 | 平均时间负载读 | 空间复杂度 | 是否稳定 |
| -------- | -------------- | ---------- | -------- |
| 冒泡排序 | O(n^2)         | O(1)       | True     |
| 选择排序 | O(n^2)         | O(1)       | False    |
| 插入排序 | O(n^2)         | O(1)       | True     |
| 归并排序 | O(n × log(n))  | O(n)       | True     |
| 快速排序 | O(n × log(n))  | O(log(n))  | False    |

> 稳定： 若 a == b，且排序前 a 在 b 的前面，则排序后 a 仍在 b 前
> 不稳定： 若 a == b，且排序前 a 在 b 的前面，排序后无法保证 a 仍在 b 前

- [十大经典排序算法（动图演示）](https://www.cnblogs.com/onepixel/articles/7674659.html)
- [必学十大经典排序算法，看这篇就够了(附完整代码动图优质文章)](https://zhuanlan.zhihu.com/p/57088609)

2. 查询算法

   1. 顺序查找
      1. 顾名思义，按顺序进行查找。
      2. 假设有一个数组 arr，已知目标为 k
      3. 则从 arr[0]开始查找，直到找到 k 或达到 arr[arr.length - 1]
   2. 二分查找
      1. 必要条件：已知数组/数据必须是有序的
      2. 从已知数组/元素的中间节点开始查找
      3. 若不匹配，根据目标元素以及当前节点比较，确定目标元素所在子数组/子数据。
      4. 重复 2，3，知道找到目标元素，或没有目标元素
   3. 插值查找
      1. 二分查找的优化
      2. 将查找点从中心点根据目标元素进行修改，以提高效率
      3. 假设已知数组包含有序的 100 个正整数元素
      4. 若查找目标为 10，则可以从 arr[arr.length / 90]处附近开始查找

3. 贪心算法

   1. 在对问题求解时，只考虑当前的最优解，忽略总体的最优解
   2. 贪心算法可以保证有解，但无法保证是最优解

4. 字符串 String vs StringBuilder vs StringBuffer
   1. String 是不可变的。例：String myStr = "hello"; myStr = myStr = " world";这个过程中，需要重新在 heap 中开辟相应的内存空间。  
      StringBuilder 和 StringBuffer 可以通过 append()，insert()等方法进行修改  
      StringBuilder 速度快，线程不安全
      StringBuffer 速度慢，线程安全
   - [java 中 String、StringBuffer 和 StringBuilder 的区别(简单介绍)](https://www.cnblogs.com/weibanggang/p/9455926.html)
   - [String,StringBuffer 与 StringBuilder 的区别](https://blog.csdn.net/u011702479/article/details/82262823)
