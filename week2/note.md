# Week 2 Notes

[Week1 Note](../week1/note.md)

## 学习任务

- [ ] 继续学习并更新 week1 中的内容
- [ ] 研发流程拆解
  - [x] 系统分析
  - [x] 目标
  - [x] 图表
    - [x] User Case
    - [x] 活动图
    - [x] 系统架构图
    - [x] 时序图
    - [x] 数据库 ER 图
  - [ ] 接口文档
  - [ ] 研发计划

## Mini Project

### 淘宝摇一摇营销活动

- 制作活动页, 增加产品曝光机会
- 预计 PV(Page View) 1 亿, UV(Unique View) 3 千万
- 活动持续 3 天
- 每个用户抽奖中奖次数不超过 5 次
- 每个品牌实物库存为 1000 - 5000
- 平均中奖率 0.05%

## 下周抽查内容

1. mini project 系统分析初审评审
2. week1 带完成事项更新 review

---

## Monday

### mini project 初步系统分析 (背景, 业务价值, 技术价值, 业务目标, 系统目标)

1. 背景
   1. 目标用户: 所有群众
   2. 营销活动, 其目的是为了增加产品的曝光机会
   3. 参加企业需提供 1000 - 5000 实物库存
   4. 每个用户中奖次数上限为 5 次
   5. 用户平均中奖率为 0.05%
2. 业务价值 - (需要2方面结合： 运营方 + 研发方)
   1. 为企业提供产品的曝光机会, 增加产品知名度
   2. 为企业以及用户提供活动平台的同时增加平台流量
   3. 减少企业在宣传上的人力成本
3. 技术价值 - (需要体现价值亮点)
   1. 为营销活动提供技术支持, 保证营销活动的运行
   2. 为用户提供个性化信息 - 升级平台个性化推送算法能力
   3. 提供日PV 1亿
   4. 提高平台运行稳定性
4. 业务目标 - (需要具体数字)
   1. 为所有参加活动的企业提供产品的曝光机会以及产品曝光量
   2. 为用户提供中奖机会, 增加用户流量
   3. 根据用户信息(历史搜索记录, 购买产品类型等)推送不同产品
5. 系统目标
   1. 为全民提供参加活动的平台
   2. 在运行的同时, 防止用户恶意使用造成黑产
   3. 用户可查看中奖记录
   4. 中奖后及时通知产品提供方以及中奖者, 保证双方能及时沟通
   5. 为中奖者以及产品提供商提供交流平台, 避免线下交易

[MindMap](./Mini%20Project初步系统分析.xmind)

---

## Tuesday

### mini project 图表 (User Case, 活动图, 系统架构图)

- [LucidChart: Use Case Diagram](https://app.lucidchart.com/invitations/accept/c604f695-b77c-4800-83f2-36b933ba5608)
- [LucidChart: 活动图](https://app.lucidchart.com/invitations/accept/19c5beb2-d64c-4e83-8fa5-f43a14d5dbe5)
- [LucidChart: 系统架构图](https://app.lucidchart.com/invitations/accept/6cae25c2-ab1a-4a13-848b-893f2a3300d8)
  > [图片文件](./img)

---

## Wednesday

### mini project 图表 (时序图, 数据库 ER 图)

- [LucidChart: Sequence Diagram](https://app.lucidchart.com/invitations/accept/62877ca3-4e00-44ba-8138-b22a010c4e0c)
- [LucidChart: DB ER Diagram](https://app.lucidchart.com/invitations/accept/5eacf70a-89fb-45c8-a525-ba091ba42dfe)
  > [图片文件](./img)

---

## Thursday

### mini project 研发计划, 接口文档

---

## Friday

### Week1 内容更新以及 review

1. 链表

   1. 链表分为单向链表以及双向链表，Java 中的 LinkedList 为双向链表
   2. Java 中 LinkedList 有实现 Queue 接口，而 ArrayList 没有
   3. 链表在物理上不连续，在逻辑上连续
   4. 链表增删快，查询慢。ArrayList 增删慢，查询快
      1. 当 ArrayList 需要扩容时，其容量会被扩容至原来的 1.5 倍
      2. LinkedList 不需要担心扩容，当需要添加新元素时，只需要新建一个 node

2. 树
   1. 树的高度和深度 [StackOverFlow: Tree Height vs Depth](https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height)
      1. 高度和深度都从 0 开始计数
      2. 高度： 从树的最底层开始，到达根节点的节点个数 （包括根节点）
      3. 深度： 从根几点开始，到达最深的节点的几点个数 （包括最深的节点）
   2. 二叉树
      1. 二叉树的每一个节点最多有 2 个子树
      2. 每个子树也是二叉树
   3. 二叉搜索树
      1. 满足二叉树的条件
      2. 当左子树不为空时，左子树的值小于其根节点的值
      3. 当右子树不为空时，右子树的值大于其根节点的值
      4. 左右子树需要仍然满足二叉搜索树
   4. 平衡二叉树
      1. 如果这颗树不为空，那么其左右子树的高度差不会大于 1
      2. 当将有序的数列插入二叉树后，二叉树会变成类似与链表的数据结构，此时搜索效率由 O(log × n)变为 O(n)，平衡二叉树避免了这个问题
      3. 平衡二叉树最大节点数为： 2^(d + 1) - 1
         1. d 代表深度，若有 y 一个深度为 3 的平衡二叉树，则其最多能有 2^(3+1)-1 = 15 个节点
