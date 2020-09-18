# Week 3 Note

[Week1 Note](../week1/note.md)
[Week2 Note](../week2/note.md)

## 任务

## Monday

1. 系统分析初步评审后图表更新
   1. 完善时序图
   2. 新增领域模型图

---

## Tuesday

N/A

---

## Wednesday

1. [完善研发计划](../week2/摇一摇营销活动研发计划.docx)
2. 开发环境搭建
   1. [MyBatis 环境 notes](https://blog.csdn.net/zhoujiyu123/article/details/79786847)
   2. [我在搭建 mybatis 时碰到的一系列问题](https://blog.csdn.net/sinat_35803474/article/details/82626572)
   3. [application.properties vs application.yml](https://stackoverflow.com/questions/47462950/application-yml-vs-application-properties-for-spring-boot)

---

## Thursday

1. 数据库表建立 **_所有表包含 id, create_time, update_time, 其中 id 为主键_**
   1. 目前 4 张表
      1. user 用户表
         1. id
         2. username - unique
         3. password
         4. salt
         5. win_count
         6. create_time
         7. update_time
      2. company
         1. id
         2. company_name - uniqie
         3. create_time
         4. update_time
      3. product
         1. id
         2. company_id - 与 company 表中的 id 形成外键
         3. product_name
         4. stock_count
         5. create_time
         6. update_time
      4. win_record
         1. id
         2. company_id - 与 company 表中的 id 形成外键
         3. user_id - 与 user 表中的 id 形成外健
         4. product_id - 与 product 表中的 id 形成外键
         5. create_time
         6. update_time
2. 根据数据库表写 entity
   ### **_与领域模型图有出入,需修改_**
   2. 4 个 Java 类
      1. User
      2. Company
      3. Product
      4. WinRecord

## Friday

1. 用户注册登录模块
   1. [用户注册登录 password + salt](https://www.baeldung.com/java-password-hashing)
   2. 使用 Java SecureRandom 随机生成 salt
   3. 最终存储的 password: hash(salt + password)
   4. 登录时, 验证从数据库中根据用户名取得数据, 重新计算 hash(salt + password), 若匹配返回 true, 否则返回 false
2. 测试用户注册登录模块
   1. 
