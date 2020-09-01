# Week 1 Notes

## 学习任务

- [ ] 学习《阿里巴巴 Java 开发手册》
- [ ] 学习 MySQL 数据库，git，maven，单元测试
- [ ] 复习常见的数据结构&算法知识：
  - [ ] 链表
  - [ ] 树
  - [ ] 字符串
  - [ ] 查询算法
  - [ ] 排序算法
  - [ ] 贪心算法
  - [ ] 动态规划
- [ ] 针对以上做思考归纳总结

## 下周抽查内容

1. 抽查验收《阿里巴巴 Java 开发手册》学习情况
2. 思考总结归纳文档

---

### Monday

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

### Tuesday

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
   6. [git 工作流](./git-workflow.png)

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
      4. `mvn package`： 打包，默认为 jar 包，可在pom.xml中更改
      5. `mvn install`： 将项目生成 jar 包
