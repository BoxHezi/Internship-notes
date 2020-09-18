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
   1. [MyBatis环境notes](https://blog.csdn.net/zhoujiyu123/article/details/79786847)
   2. [我在搭建mybatis时碰到的一系列问题](https://blog.csdn.net/sinat_35803474/article/details/82626572)

---

## Thursday

1. 数据库表建立 ***所有表包含id, create_time, update_time, 其中id为主键***
   1. 目前4张表
      1. user用户表
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
         2. company_id - 与company表中的id形成外健
         3. product_name
         4. stock_count
         5. create_time
         6. update_time
      4. win_record
         1. id
         2. company_id - 与company表中的id形成外健
         3. user_id - 与user表中的id形成外健
         4. product_id - 与product表中的id形成外健
         5. create_time
         6. update_time
2. 根据数据库表写entity
   ### ***与领域模型图有出入,需修改***
   2. 4个Java类
      1. User
      2. Company
      3. Product
      4. WinRecord

## Friday
1. [用户注册登录password + salt](https://www.baeldung.com/java-password-hashing)
   1. 使用Java SecureRandom随机生成salt
   2. 最终存储的password: hash(salt + password)
   3. 登录时, 验证从数据库中根据用户名取得数据, 重新计算 hash(salt + password), 若匹配返回true, 否则返回false
   4. 