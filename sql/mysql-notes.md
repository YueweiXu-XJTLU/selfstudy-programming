# MySQL Notes
-p:
[LOCAL MYSQL PASSWORD REDACTED] for Windows;
[LOCAL MYSQL PASSWORD REDACTED] for Mac

---

## Basic

### P1-2：数据库简介
- **数据库 (DataBase, DB)**
- **数据库管理系统 (DataBase Management System， DBMS)**：操纵和管理数据库
- **SQL (Structured Query Language)**：操纵关系型数据库的编程语言

---

### P3：安装MySQL
1. 客户端（本机）启动与停止
  + 1
    1. Win + r：`services.msc` //搜索： 服务
    2. 找“MySQL80”
    3. 右键选择启动/停止
  + 2 
    1. Win + r：`cmd`：Shift + Ctrl + Enter（以管理员身份运行）
    2. 启动：`net start MySQL80`
       停止：`net stop MySQL80` 

2. 客户端连接至MySQL服务器
  + 1
    打开MySQL 8.0 Command Line Client（命令行客户端）
  + 2
    0. YOUR_MYSQL_BIN_PATH 添加到系统环境变量（Path）
    1. Win + r：cmd：Shift + Ctrl + Enter（以管理员身份运行）
    2. MySQL [-h 127.0.0.1] [-P 3306] -u root -p 
      (-h：IP；-P：端口-u：用户；-p：密码)
      ([]：可省略)


---

### P4：数据模型
+ **关系型数据库 (Relational DBMS, RDBMS)**：由多张互相联系的二维表组成的数据库

---

### P5：SQL 语法与分类
#### 一、SQL通用语法
1. 分号结尾，可单行或多行书写
2. 可使用空格/缩进来增强语句的可读性
3. 不区分大小写，建议关键字大写
4. 注释：
    - 单行注释：`-- 注释内容` 或 `#注释内容`
    - 多行注释：`/* 注释内容 */`

#### 二、SQL 分类
| 分类 | 全称 | 功能 |
|------|------|------|
| DDL  | Data Definition Language | 定义数据库对象（数据库，表，字段） |
| DML  | Data Manipulation Language | 增删改数据 |
| DQL  | Data Query Language | 查询数据 |
| DCL  | Data Control Language | 控制用户权限 |

---

### P6-P10：DDL
#### 一、数据库操作
| 操作 | 语法示例 |
|------|----------|
| 查询所有数据库 | `SHOW DATABASES;` |
| 创建数据库 | `CREATE DATABASE [IF NOT EXISTS] db_name [DEFAUT CHARSET 字符集] [COLLATE 排序规则];` |
| 删除数据库 | `DROP DATABASE [IF EXISTS] db_name;` |
| 使用数据库 | `USE db_name;` |
| 查询当前数据库 | `SELECT DATABASE();` |

#### 二、表操作
+ **数据类型**
1. 数值

|类型 |  大小 |描述|
|---|---|---|
|TINYINT |                1 byte     |                                                                                          小整数值|
|SMALLINT         |     2 bytes      |                                                                                       大整数值|
|MEDIUMINT    |      3 bytes       |                                                                                      大整数值|
|INT或INTEGER|       4 bytes        |                                                                                     大整数值|
|BIGINT           |         8 bytes         |                                                                                    极大整数值|
||||
|FLOAT          |        4 bytes          |                                                                                   单精度浮点数值|
|DOUBLE        |         8 bytes           |                                                                                  双精度浮点数值|
|DECIMAL =NUMERIC|              依赖于M(精度)和D(标度)的值（eg：123.45，M=5；D=2） |       小数值(精确定点数)|

+ eg.: 
```sql
age int unsigned
score decimal(4,1) signed
```

2. 字符串

|类型 |                                大小 |                                              描述|
|---|---|---|
|CHAR()             |                 0-255 bytes|                                  定长字符串（性能好，利用率低）(char = char(1))|
|VARCHAR()       |                0-65535 bytes      |                       变长字符串（性能差，利用率高）|
||||
|TINYBLOB    |                  0-255 bytes         |                         短二进制数据|
|BLOB            |                  0-65 535 bytes       |                      二进制形式的长文本数据|
|MEDIGHBLOB   |            0-16 777 215 bytes     |                 二进制形式的中等长度文本数据|
LONGBLOB  |                 0-4 294 967 295 bytes   |              二进制形式的极大文本数据|
||||
|TINYTEXT    |                  0-255 bytes             |                      短文本字符串|
|TEXT            |                  0-65 535 bytes        |                      长文本数据|
|MEDIUMTEXT     |         0-16 777 215 bytes    |                   中等长度文本数据|
|LONGTEXT|                   0-4 294 967 295 bytes  |                极大文本数据|

+ eg.:
```sql
username varchar(50)
gender char(1)
```

3. 日期时间


|类型          |                       大小          |                  范围                                                          |                      格式            |                                           描述|
|---------|--------------------------|---------------------------------------------------|--------------------------|------------------------------|
|DATE                            |   3          |                       1000-01-01至9999-12-31        |                	                   YYYY-MM-DD    |                                日期值|
|TIME                             |   3          |                       -838:59:59至838:59:59               |                                  HH:MM:SS       |                                    时间值或持续时间|
|YEAR                              | 1          |                       1901 至 2155                              |                                   YYYY               |                                      年份值|
|DATETIME[(fsp)]           |  8        |                        1000-01-01 00:00:00至9999-12-31 23:59:59    |        YYYY-MM-DD HH:MM:SS     |             混合日期和时间值|
|TIMESTAMP                  |  4         |                       1970-01-01 00:00:01至2038-01-19 03:14:07   |         YYYY-MM-DD HH:MM:SS    |              混合日期和时间值，时间戳(automatic time zone change when storing and querying)|

+ eg.:
```sql
birthday date
```

<br/>

1. **创建表**
```sql
CREATE TABLE 表名 (
    字段1 类型 [COMMENT '注释'],
    字段2 类型 [COMMENT '注释'],
    ...
) [COMMENT '表注释'];
```

2. **查询表**

| 操作 | 语法 |
|------|----------|
| 查询所有表 | `SHOW TABLES;` |
| 查询表结构 | `DESC 表名;` or `DESCRIBE 表名` |
| 查询建表语句 | `SHOW CREATE TABLE 表名;` |


3. **修改表**

|操作|语法|
|---|---|
|添加字段|` ALTER TABLE 表名 ADD 字段名 类型(长度) [COMMENT 注释] [约束]; `|
|修改数据类型|`ALTER TABLE 表名 MODIFY [COLUMN] 字段名 新数据类型(长度);`|
|修改字段名和字段类型|`ALTER TABLE 表名 CHANGE [COLUMN] 旧字段名 新字段名 类型(长度) [COMMENT 注释] [约束];`|
|删除字段|`ALTER TABLE 表名 DROP [COLUMN] 字段名;`|
|修改表名|`ALTER TABLE 表名 RENAME TO 新表名;`|

4. **删除表**

|操作|语法|
|---|---|
|删除表|`DROP TABLE [IF EXISTS] 表名;`|
|删除指定表，并重新创建该表（清空表中数据，保留表结构)|`TRUNCATE TABLE 表名;`|

---

### P11：DataGrip 使用
+ 连接MySQL
  1. 启动MySQL：net start MySQL80
  2. 启动DataGrip ---> new project
  3. 左上角“+” ---> data source ---> MySQL
  4. user：root
      password：[EXAMPLE PASSWORD REDACTED]
  5. Download：下载驱动文件
  6. Test Connection：Succeeded
  7. OK
  8. ... ---> All schemas ---> 刷新（展示所有数据库）（schema ==      database）

---

### P12-P14：DML
#### 一、添加数据
1. 给指定字段添加数据
```sql
INSERT INTO 表名 (字段名1,字段名2, ...) VALUES (值1, 值2, ...);
```

2. 给全部字段添加数据
```sql
INSERT INTO 表名 VALUES (值1,值2,….);
```

3. 批量添加数据
```sql
INSERT INTO 表名 (字段名1,字段名2, ...) VALUES (值1,值2, ...), (值1,值2, ...), (值1,值2, ...);
INSERT INTO 表名 VALUES (值1,值2, ...), (值1,值2, ...), (值1,值2, ...);
```

+ Note:
1. 插入数据时，指定的字段顺序需要与值的顺序是一一对应的
2. 字符串和日期型数据应该包含在引号中
3. 插入的数据大小，应该在字段的规定范围内

#### 二、修改数据
```sql
UPDATE 表名 SET 字段1=值1 [WHERE 条件];
```

+ Note:
1. 修改语句的条件可有可无，若无条件，则修改整张表的所有数据

#### 三、删除数据
```sql
DELETE FROM 表名 [WHERE 条件];
```

+ Note:
1. 删除语句的条件可有可无，若无条件，则删除整张表的所有数据
2. DELETE语句不能删除某一个字段的值， 必须使用UPDATE进行字段删除（update 表名 set 字段1 = null where 字段2 = 值2;）
3. delete from 表名 where 字段 is null; （where后面只能用is null， where之前允许用= null）

---

### P15-P23：DQL
#### 一、基本查询 Basic Query
1. 查询字段：
```sql
SELECT 字段1, 字段2, ... FROM 表名;
SELECT * FROM 表名;
```
+ 查询全部字段
+ 尽量罗列全部，不要用*

2. 设置别名：
```sql
SELECT 字段1 [AS 别名1], 字段2 [AS 别名2], ... FROM 表名 [AS 表别名];

SELECT 字段1 [别名1]， 字段2 [别名2]， ... FROM 表名 [表别名];
```

3. 去除重复记录：
```sql
SELECT DISTINCT 字段列表 FROM 表名;
```

#### 二、条件查询 Conditional Query (WHERE)
```sql
SELECT * FROM 表名 WHERE 条件;
```

+ Conditions:
  + 比较运算符：>; >; =; =; <; =; <; != 或 <> 
  + BETWEEN ... AND ... ：两并区间
  + IN(...) ：in后列表中的值，多选一
  + LIKE 占位符：模糊匹配（_匹配单个字符，%匹配任意个字符）
  + IS (NOT) NULL
  + AND 或 &&
  + OR 或 ||
  + NOT 或 !

#### 三、聚合函数 Aggregate Functions (COUNT, MAX, MIN, AVG, SUM)

```sql
SELECT AggregateFunction(fields) FROM 表名;
```

+ Note:
  + 集合函数：将一列作为一个整体，进行纵向计算
  + null 不参与任何聚合函数的计算

#### 四、分组查询
```sql
SELECT 字段 FROM 表名 GROUP BY 分组字段 HAVING 条件;
```

+ Note: 
1. where与having区别
    1. 执行时机不同：where是分组之前进行过滤，不满足where条件，不参与分组；而having是分组之后对结果进行过滤
    2. 判断条件不同：where不能对聚合函数进行判断，而having可以
2. 执行顺序: 执行顺序: where > Aggregate Function in having > having > Aggregate Function in Select > Select
3. 分组之后，查询的字段一般为聚合函数和分组字段，查询其他字段无任何意义


#### 五、排序查询 Sorting Query (ORDER BY)
1. 语句：
```sql
SELECT 字段列表 FROM 表名 ORDER BY 字段1 排序方式1, 字段2 排序方式2, ... ;
```

2. 排序方式：
    1. ASC：升序（默认）
    2. DESC：降序

3. Note: 多字段排序时，仅当第一个字段的值相同时，才会根据第二个字段进行排序


#### 六、分页查询 Pagination Query (LIMIT)
1. 语句：
```sql
SELECT 字段列表 FROM 表名 LIMIT 起始索引, 查询记录数 ;
```

2. Note:
    1. 起始索引从0开始，起始索引 = (查询页码 - 1) * 每页显示记录数
    2. 分页查询是数据库的方言，不同的数据库有不同的实现，MySQL中是LIMIT
    3. 如果查询的是第一页数据，起始索引可以省略，直接简写为limit 10

#### 七、DQL语句编写顺序 & DQL语句执行顺序
1. DQL语句编写顺序
```sql
SELECT
	字段列表
FROM
	表名列表
WHERE
	条件列表
GROUP BY
	分组字段列表
HAVING
	分组后条件列表
ORDER BY
	排序字段列表
LIMIT
	分页参数;
```

2. DQL语句执行顺序
```sql
FROM & JOIN
	表名列表
WHERE
	条件列表
GROUP BY
	分组字段列表
HAVING
	分组后条件列表
SELECT (Aggregate Functions)
	字段列表
ORDER BY
	排序字段列表
LIMIT
	分页参数;
```

+ 验证：
```sql
select e.name name1, e.age age1 from emp e where e.age > 15 order by age1; #OK
#select e.name name1, e.age age1 from emp e where age1 > 15 order by age1; #ERROR OCCURS
```

---

### P24-P26：DCL
#### 一、用户管理
1. 查询用户：
```sql
USE mysql;
SELECT * FROM user;
```

2. 创建用户：
```sql
CREATE USER '用户名'@'主机名' IDENTIFIED BY '<PASSWORD REDACTED>';
```

3. 修改用户密码：
```sql
ALTER USER '用户名'@'主机名' IDENTFIED WITH mysql_native_password BY '<PASSWORD REDACTED>';
```

4. 删除用户：
```sql
DROP USER '用户名'@'主机名';
```

5. Note:  
    + host：主机
           1. localhost 仅能在本地主机访问，禁止远程访问
           2. % 可在任意主机访问
    + cmd中用：exit退出当前用户
    + 该部分指令主要由DBA（DataBase Administrator 数据库管理员）使用

#### 二、权限控制
1. MySQL常用权限类型：

|权限|                                           说明|
|---|---|
|USAGE                         |             无权限（仅连接登录）|
|ALL, ALL PRIVILEGES |              所有权限|
|SELECT       |                               查询数据|
|INSERT      |                                插入数据|
|UPDATE   |                                 修改数据|
|DELETE    |                                  删除数据|
|ALTER     |                                   修改表|
|DROP     |                                   删除数据库/表/视图|
|CREATE |                                    创建数据库/表|

2. 权限控制语句
    1. 查询权限：
    ```sql
    SHOW GRANTS FOR '用户名'@'主机名;
    ```

    2. 授予权限：
    ```sql
    GRANT 权限列表 ON 数据库名.表名 TO '用户名'@'主机名;
    ```

    3. 撤销权限：
    ```sql
    REVOKE 权限列表 ON 数据库名.表名 FROM '用户名'@'主机名;
    ```

3. Notes:
    + 多个权限之间（ 权限列表），使用逗号分隔
    + 授权时，数据库名和表名可以使用*进行通配，代表所有（*.* etc.）


---

### P27-P31：函数
#### 函数
1. 字符串函数：

|函数                                                                                                             |功能|
|---|---|
|CONCAT(S1, S2, ..., Sn)                                                                              |字符串拼接，将S1，S2，….Sn拼接成一个字符串|
|LOWER(str)                                                                                                 |将字符串str全部转为小写|
|UPPER(str)                                                                                                  |将字符串str全部转为大写|
|LPAD(str, n, pad)                                                                                       |左填充，用字符串pad对str的左边进行填充达使字符串整体到n个字符长度|
|RPAD(str, n, pad)                                                                                       |右填充，用字符串pad对str的右边进行填充达使字符串整体到n个字符长度|
|TRIM(str)                                                                                                    |去掉字符串头部和尾部的空格|
|SUBSTRING(str, start, len)                                                                         |字符串返回从字符串str从start位置起的len个长度的（index start from 1）|

2. 数值函数

|函数      |                                                                                                       功能|
|---|---|
|CEIL(x)  |                                                                                                       向上取整|
|FLOOR(x)     |                                                                                               向下取整|
|MOD(x, y)     |                                                                                              返回x/y的模（余数）|
|RAND()        |                                                                                               返回0~1内的随机数（ [0, 1)）|
|ROUND(x, y)    |                                                                                          求参数x的四舍五入的值，保留y位小数|

3. 日期函数：

|函数                                                                                                            | 功能|
|---|---|
|CURDATE()                                                                                                 |返回当前日期|
|CURTIME()                                                                                                  |返回当前时间|
|NOW()                                                                                                   |     返回当前日期和时间|
|YEAR(date)                                                                                              |   获取指定date的年份|
|MONTH(date)                                                                                       |     获取指定date的月份|
|DAY(date)                                                                                            |       获取指定date的日期|
|DATE_ADD(date, INTERVAL expr type)                                         |          返回一个日期/时间值加上一个时间间隔expr后的时间值（select date_add(now(), INTERVAL 10 day)）|
|DATEDIFF(date1, date2)                                                                |           返回起始时间date1 和 结束时门date2之间的天数|

4. 流程控制函数：

|函数                              |                                                                               功能|
|---|---|
|`IF(value, t, f)`           |                                                                                    如果value为true，则返回t，否则返回f|
|`IFNULL(value1, value2)`          |                                                                   如果value1不为空，返回value1，否则返回value2|
|`CASE WHEN [val1] THEN [res1] ... ELSE [default] END`        |                  如果val1为true，返回res1, …（可以继续接`WHEN [val2] THEN [res2] ...`） 否则返回default默认值|
|`CASE [expr] WHEN [val1] THEN [res1] ... ELSE [default] END`     |          如果expr的值等于val1，返回res1, … （可以继续接`WHEN [val2] THEN [res2] ...`）否则返回default默认值|

#### 语句：
```sql
SELECT 函数(参数);
```


---

### P32-P36 Constrain
1. Categories of constrains
   
|Type|Description|
|---|---|
|`NOT NULL`|/|
|`UNIQUE`|/|
|`PRIMARY KEY`|NOT NULL & UNIQUE|
|`DEFAULT default_value`|
|`CHECK(condition)`|ensure fields(字段) meet certain condition|
|`FOREIGN KEY`|link 2 tables|
|`AUTO_INCREMENT`|Must be applied to a key column (primary key, unique key)|

2. Note: Multiple constrains are available, just use **space** to separate constrains

3. Foreign Key:
    + child table contains foreign key, which links to primary key in parent table
    + Syntax:
        1. Add foreign key:
        ```sql
        #when creating table:
       CREATE TABLE 表名 (
    	    字段名 数据类型,
    	    ... ,
    	    [CONSTRAINT] [外键名称] FOREIGN KEY (referencing_table外键字段名) REFERENCES referenced_table主表 (referenced_table主表列名) [ON UPDATE ref_opt ON DELETE ref_opt]
        );

        #after creating:
        ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段名) REFERENCES 主表(主表列名) ON UPDATE 更新行为 ON DELETE 删除行为;
        ```
        
        2. Drop foreign key:
        ```sql
        ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
        ```   
    
    + Update/Delete behaviors:
    + 
    |Type|Description|
    |---|---|
    |`NO ACTION` or `RESTRICT`|default, throw exceptions|
    |`CASCADE`|/|
    |`SET NULL`|if constrain of field does not contain 'not null'`|
    |`SET DEFAULT`|/|

---
---

### P37-P50 Multiple Tables Relationships
#### P37 Multiple Table Query: Multiple Table Relationship
1. Multiple Table Relationship:
    1. one-to-multiple: create foreign in the 'multiple' side, point to primary key in the 'one ' side

    2. multiple-to-multiple: create another intermediate table, contain at least 2 foreign keys, each point to primary key of the 2 tables

    3. one-to-one: for single table split: create a foreign key in any one table, set the foreign key to be UNIQUE can link to primary key in another table

#### P39 Inner Join
1. Meaning: Intersection(交集) between tables (hence if a tuple of a table lack a certain element related to the join, it does not belong to intersection, cannot be queried)

2. Syntax: 
    1. Implicit Inner Join    
    ```sql
    `SELECT fields FROM table1 [alias], table2 [alias] WHERE conditions;
    ```

    2. Explicit Inner Join
    ```sql
    SELECT fields FROM table1 [alias] [INNER] JOIN table2 [alias] ON conditions;
    ```

#### P40 Outer Join
1. Meaning: Intersection(交集) between tables + a certain table's complete data

2. Syntax: 
    1. Left Outer Join (Table1 + Intersection):
    ```sql
    SELECT fields FROM table1 [alias] LEFT [OUTER] JOIN table2 [alias] ON conditions;
    ```

    2. Right Outer Join:
    ```sql
    SELECT fields FROM table1 [alias] RIGHT [OUTER] JOIN table2 [alias] ON conditions;
    ```

#### P41 Self Join
1. Meaning: Query inside a single table, can be either inner join or outer join

2. Syntax:
```sql
SELECT fields FROM table1 alias1 JOIN/LEFT JOIN/RIGHT JOIN table1 alias2 ON conditions;
```

#### P42 Union Query
1. Meaning: show union of multiple times of query

2. Syntax:
```sql
SELECT fields1 FROM table1 ...
UNION [ALL]
SELECT fields1 FROM table2 ... ;
```

3. Notes:  
  + `UNION`: remove repeated replications
  + `UNION ALL`: keep repeated replications


#### P43-P47 Sub Query (Nested Query)
1. Syntax:
```sql
SELECT * FROM table1 WHERE column1 = (SELECT column1 FROM table2)
#or SELECT... after INSERT/DELETE/UPDATE/SELECT
```
2. Categories:
+ Scalar Subquery: 
  + Meaning: on get on value: the subquery inside () only return a scalar
  + eg. `select * from emp where entrydate > (select entrydate from emp where name = '方东白');`

+ Column Subquery: 
  + Meaning: the subquery inside () return a column of data
  + Operators: `IN (...)` ：in后列表中的值，多选一, `NOT IN (...)`, `ANY (...)` = `SOME (...)`, `ALL (...)`
  + eg. `select * from emp where salary > all (select salary from emp where dept_id = (select id from department where name = 'finance department'));`

+ Row Subquery: 
  + Meaning: the subquery inside () only return a row of data
  + Operators: `IN (...)`, `NOT IN (...)`, `=`, `<>`
  + eg. `select * from emp where (salary, managerid) = (select salary, managerid from emp where name = '张无忌');`
  + Note: after 'select', not use (field1, field2) as this will be recognized as a whole attribute, use field1, field instead

+ Table Subquery: 
  + Meaning: the subquery inside () only return rows and colums (a table)
  + Operators: `IN (...)`
  + eg. `select * from ((select * from emp where entrydate > '2006-01-01') temp_table left join department on temp_table.dept_id = department.id);`

3. Positions:
    1. after WHERE: eg. select * from emp where (salary, managerid) = (select salary, managerid from emp where name = '张无忌');

    2. after FROM: eg. select * from ((select * from emp where entrydate > '2006-01-01') temp_table left join department on temp_table.dept_id = department.id);

    3. after SELECT: eg. select name, salary, (select avg(salary) from emp where dept_id = e.dept_id) from emp e;

---
---

### P51-P54：transaction
#### P51 transaction 事务
1. Meaning:
    1. a collection of manipulations, execute at the same time, either all success or all fail (if fail in the middle, executed codes will rollback)

    2. Without manually manipulation, each code is a transaction in MySQL, it will automatically commit to database upon execute

2. syntax:
    1. Check/Set commit pattern of transaction:
    ```sql
    SELECT @@autocommit;

    SET @@autocommit = 0; --0:Manually; 1:Automatically
    ```

    2. Start transaction:
    ```sql
    START TRANSACTION;
    #OR
    BEGIN;
    ```

    3. Commit transaction:
    ```sql
    COMMIT;
    ```

    4. Rollback transaction:
    ```sql
    ROLLBACK;
    ```

---

#### P52 4 properties of transactions: ACID
1. 原子性 (Atomicity)：All or nothing ---> **Undo Log**
2. 一致性 (Consistency)：Data remains valid (fit constrains) after the transaction (eg: sum of money keeps unchanged) ---> **Undo Log + Redo Log**
3. 隔离性 (Isolation)：Transactions run independently & cocurrently ---> **Lock + MVCC**
4. 持久性 (Durability)：Changes are permanent once committed ---> **Redo Log**

#### P53 Concurrency issues in transactions
|Type|Description|
|---|---|
|Dirty Read 脏读|Reading uncommitted changes|
|Non-repeatable Read 不可重复读|Inconsistent reads of the same record|
|Phantom Read 幻读|Ghost rows appearing/disappearing|

#### P54 Isolation Level
1. Isolation Levels
2. 
|Isolation Level|                                                  Dirty Read|                    Non-repeatable Read|                    Phantom Read|
|---|---|---|---|
|Read uncommitted|                                                Y(appear)|                              Y|                                                 Y|
Read committed(Default in Oracle)|                     N(disappear)|                        Y|                                                 Y|
Repeatable Read(Default in MySQL)|                   N|                                            N|                                                 Y|
Serializable|                                                              N|                                           N|                                                 N|

2. Syntax
    1. Check Current Isolation Level:
    ```sql
    SELECT @@TRANSACTION_ISOLATION;
    ```

    2. Set Isolation Level:
    ```sql
    SET [ | SESSION | GLOBAL] TRANSACTION ISOLATION LEVEL Read uncommitted | Read committed | Repeatable Read | Serializable;
    #[no input]: 仅对下一个事务生效
    #SESSION: 会话级别，仅对当前窗口（客户端）有效
    #GLOBAL: 全局级别，对所有窗口（客户端）有效
    ```

---
---
---

## Advanced

### P2 MySQL Architecture
#### P2 MySQL Architecture
|Layer|Description|
|---|---|
|Connection Layer|Handles client-server communication and authorization, security|
|Service Layer|Processes SQL logic and optimizes queries|
|Engine Layer|use Pluggable Storage Engines to store or extract data (Index implements in this layer)|
|Storage Layer|Persistent data and log storage|

### P3-7 Storage Engine
#### P3-7 Storage Engine
1. Default Storage Engine: InnoDB

2. Syntax:
    1. check all engines:
    ```sql 
    SHOW ENGINES;
    ```

    2. use certain engine when creating a table:
    ```sql
    CREATE TABLE table_name (
    ...
    ) ENGINE = INNODB;
    ```

3. Different Engines
    1. InnoDB: 
        + Transaction + row-level locking (行级锁)+ Foreign Key
        + file: table_name.ibd: store table_structure, data, index
        + TableSpace > Segment > Extent (1M) > Page (smallest manipulation unit)(16K) > Row > Trx id (id od latest manipulation) + Roll pointer + columns

    2. MyISAM
        + NO transaction, NO Foreign + table-level locking (表锁), NO row-level locking + fast visit
        + file: table_name.MYD(data) + table_name.MYI(index) + table_name_incrementNumber.sdi(table structure)(json.cn)

    3. Memory
        + store in memory, fast but lose when power-off + Hash Index
        + file: table_name_incrementNumber.sdi(table structure)

---
---

### P8 MySQL-Linux版安装
#### P8 MySQL-Linux版安装

##### 1. 准备一台Linux服务器

云服务器或者虚拟机都可以; 

Linux的版本为 CentOS7;



##### 2. 下载Linux版MySQL安装包

https://downloads.mysql.com/archives/community/

*Original study image unavailable*

##### 3. 上传MySQL安装包

*Original study image unavailable* 



##### 4. 创建目录,并解压

```
mkdir mysql

tar -xvf mysql-8.0.26-1.el7.x86_64.rpm-bundle.tar -C mysql
```



##### 5. 安装mysql的安装包

```
cd mysql

rpm -ivh mysql-community-common-8.0.26-1.el7.x86_64.rpm 

rpm -ivh mysql-community-client-plugins-8.0.26-1.el7.x86_64.rpm 

rpm -ivh mysql-community-libs-8.0.26-1.el7.x86_64.rpm 

rpm -ivh mysql-community-libs-compat-8.0.26-1.el7.x86_64.rpm

yum install openssl-devel

rpm -ivh  mysql-community-devel-8.0.26-1.el7.x86_64.rpm

rpm -ivh mysql-community-client-8.0.26-1.el7.x86_64.rpm

rpm -ivh  mysql-community-server-8.0.26-1.el7.x86_64.rpm

```



##### 6. 启动MySQL服务

```
systemctl start mysqld
```

```
systemctl restart mysqld
```

```
systemctl stop mysqld
```



##### 7. 查询自动生成的root用户密码

```
grep 'temporary password' /var/log/mysqld.log
```

命令行执行指令 :

```
mysql -u root -p
```

然后输入上述查询到的自动生成的密码, 完成登录 .



##### 8. 修改root用户密码

登录到MySQL之后，需要将自动生成的不便记忆的密码修改了，修改成自己熟悉的便于记忆的密码。

```
ALTER  USER  'root'@'localhost'  IDENTIFIED BY '<PASSWORD REDACTED>';
```

执行上述的SQL会报错，原因是因为设置的密码太简单，密码复杂度不够。我们可以设置密码的复杂度为简单类型，密码长度为4。

```
set global validate_password.policy = 0;
set global validate_password.length = 4;
```

降低密码的校验规则之后，再次执行上述修改密码的指令。



##### 9. 创建用户

默认的root用户只能当前节点localhost访问，是无法远程访问的，我们还需要创建一个root账户，用户远程访问

```
create user 'root'@'%' IDENTIFIED WITH mysql_native_password BY '<PASSWORD REDACTED>';
```



##### 10. 并给root用户分配权限

```
grant all on *.* to 'root'@'%';
```



##### 11. 重新连接MySQL

```
mysql -u root -p
```

然后输入密码



##### 12. 通过DataGrip远程连接MySQL

---
---

### P9-31：Index
#### P9 Concept
Index is a kind of ordered **data structure**, used for get data with high efficiency

---

#### P10-P14 Data Structure

##### Types
1. B+Tree (available in InnoDB, MyISAM,  Memory)(Default)
2. Hash (available only in memory)
3. R-tree
4. Full-text

##### Details
1. B-Tree (Balance-Tree) (多路平衡查找树)
+ degree: number of child node for a parent node
+ max-degree = 5 ---> 5-ordered ---> 1 node ~ 4 keys ~ 5 pointers
+ 中间元素向上分裂
+ > [A website for visualization of data structures]

[A website for visualization of data structures]: https://www.cs.usfca.edu/~galles/visualization/Algorithms.html

2. B+Tree
+ Based on B-Tree
+ A B-Tree for **Indices** storage
+ All element appears in leave clid node
+ All leave child nodes form a **single-rirectional-chain-list**
+ B+Tree in MySQL: add **double-directional-pointers** between every 2 leave-child-nodes (include head & tail nodes), form a chain-list with ordered pointers
+ Each node stored inside in a **page (16KB)**
+ Advantage compared to Binary Tree: a node have multiple child nodes ---> have less levels (height)
+ Advantages compared to B-Tree: 
    1. only leave-child-node store data, other node can each contain more pointers/keys ---> less levels (height)
    2. all data in leave-child-node and form a chain list: stable search efficiency & easy for sorting/range queries
+ Advantage compared to Hash: all data in leave-child-node forming a chain list: stable search efficiency & easy for sorting/range queries


3. Hash
+ calculate Hash value of an element, placed in correct position in form of (data, hash_value_of_primary_key)
+ if **Hash-conflict**, use **Chain-list** to store
+ only for **Equality Comparisons** (=; in); not for **Range Queries** (<, >)
+ can not be ordered
+ high efficiency

---

#### P15-P16 Categories

##### general categories
| Category    | Meaning                                                    | Feature               | Keyword  |
|:-------------:|:------------------------------------------------------------:|:--------------------------:|:----------:|
| Primary Index | Index created for the primary key in the table            | Automatically created by default, only one | PRIMARY  |
| Unique Index  | Avoids duplicate values in a column of a table            | Can have multiple        | UNIQUE   |
| Normal Index  | Quickly locates specific data                             | Can have multiple        |     /     |
| Fulltext Index | Fulltext index can search keywords in the text, rather than comparing values in the index column | Can have multiple        | FULLTEXT |

##### index categories in **InnoDB**

| Category    | Meaning                                                    | Feature               |
|:-------------:|:------------------------------------------------------------:|:--------------------------:|
|Clustered Index (聚集索引)|data stored together with index, leave-child-node of index structure store the row-data|Must have;  only allow 1
|Secondary Index (二级索引/辅助索引/非聚集索引)|data stored separately with index, leave-child-node of index structure linking to primary key|Can have multiple|

*Generation rule of clustered index:  
1. if primary key exist, primary key index is clustered index
2. if primary key does not existm, the first unique index is clustered index
3. if neither, InnoDB automatically generate a hidden clustered index: rowid

*Back Table Query (回表查询): use secondary index to search for the primary key, use clusted index of primary key to get the row-data

---

#### P17 Index Syntax
1. Create Index
   ```sql
   CREATE [PRIMARY] [UNIQUE] [FULLTEXT] INDEX index_name ON table_name (field_name1[, field_name2, ...]);
   ```

<br/>

2. Check Index
   ```sql
   SHOW INDEX FROM table_name;
   ```

<br/>

3. Drop Index
   ```sql
   DROP INDEX index_name ON table_name;
   ```

---

#### P18-P21 SQL Performance Analysis
1. **Frequency Query**
+ Optimizing main focus on: **QUERY**
+ hence we first check manipulation frequncy, to decide if we need to deeply optimize the database
  (if many "select", significant optimization, if minor, less optimization)
+ **Syntax**
  ```sql
  SHOW [SESSION | GLOBAL] STATUS LIKE 'Com________';
  ```
  
  (SESSION: manipulations of current cosole
   GLOBAL: all manipulations of the server since it started)
  
  (use 'Com_" + 6"_", as 'insert''delete''update''select' are all in 6 letters)

<br/>

2. **Slow Query Log**
+  Slow Query Log (慢查询日志): log of all SQLs over a time threshold (10s by default)
+  To switch on it:
   1. check (in MySQL):
   ```sql
   SHOW VARIABLES LIKE 'slow_query_log';
   ```
   
   <br/>

   2. in MySQL configuration file (in Linux):
      (vi editor in Linux: i--insert; :x--save & quit)
   ```bash
   vi /etc/my.cnf
   ```
   ```bash
   #add lines below
   #switch on
   slow_query_log = 1
   
   #threshold = 2s
   long_query_time = 2 
   ```
   ```bash
   systemctl restart mysqld
   ```

   <br/>

   3. check slow query log file (in Linux):
   ```bash
   cat /var/lib/mysql/localhost-slow.log
   ```

   <br/>

3. **Show Profiles**
+ check if is accessible to show profiles
  ```sql
  SELECT @@have_profiling;
  ```
+ switch on show profile
  ```sql
  SELECT @@profiling;
  ```
  ```sql
  SET [GLOBAL | SESSION] profiling = 1;
  ```
+ use show profiling
  1. Check all SQLs
  ```sql
  show profiles;
  ```
  
  <br/>
  
  2. Check a certain SQL in its different periods
  ```sql
  show profile for query query_id;
  ```

  <br/>

  3. Check a certain SQL on its CPU usage
  ```sql
  show profile cpu for quert query_id;
  ```

4. Explain
+ Syntax (EXPLAIN can be replaced by DESC or DESCRIBE)
```sql
EXPLAIN SELECT ...;
```
+ Details
   + id:  
     sequence of table execution  
     id大的限制性,相同的id从上到下依次执行
     
     <br/>

   + type:  
     connection type  
     better ---> worse: NUll, system, const, eq_ref, ref, range, indeex, all

     <br/>

   + possible_key; key; key_len:  
     about Index

   <br/>

   + filtered:  
     an approximate percentage of returned line/queried lines after 'where'  
     larger (---> 100%) means better

  <br/>

  + Collation:
  A: Ascending
  D: Descending

---

#### P22-P29 Utilization Principle
+ Leftmost Prefix Rule (最左前缀法则) (**for composite index**):  
  + The index will be used only in the columns in the composite index **from left to right, without omitting**
  + If the leftmost colume no exist after where (here we only care about if **exist**, not care about order after where): not use the index
  + If omit some intermediate columns after where: partially use the index

<br/>

+ Range Query (范围查询) (**for composite index**):
  + If range query occurs ('<'; '>'), index right of this condition will be invalid (the range query itself will still use the index)
  + To avoid this: use **'<='; '>='**
  
<br/>

+ Index Invalidation (索引失效)
  + Do not use **Arithmetic/Function Operation** (运算操作) in index column to avoid index invalidation
  + Do not miss **'' for char()/varchar()** to avoid index invalidation
  + for **Vague Search**, if head is vague, index invalid, if tial vague, index valid
  + if use **OR**, if condition in any  side of 'OR' do not use index, all index will be invalid
  + **Impact of Data Distribution**: if MySQL evaluated that use index for search is slower than full-table-scanning, it automatically give up index  utilization

<br/>

+ SQL Hint (SQL提示)
  + give hint on index usage to MySQL manually
  + **Syntax**
    1. use index (give advice to use):
    ```sql
    EXPLAIN SELECT field_names FROM table_name USE INDEX (index_name) WHERE conditions;
    ```

    2. force index (force to use):
    ```sql
    EXPLAIN SELECT field_names FROM table_name FORCE INDEX (index_name) WHERE conditions;
    ```

    3. ignore index:
    ```sql
    EXPLAIN SELECT field_names FROM table_name IGNORE INDEX (index_name) WHERE conditions;
    ```

<br/>

+ Index Covering (覆盖索引)
  + use **Index Covering** to  avoid **Back Table Query (回表查询)**
  + let index covering the fields of query, **avoid using '*'**
  + in 'Extra' of EXPALIN result:  
    '[Using where;] Using index': not use back table query  
    'Using index condition'/<null>: use back table query

<br/>

+ Prefix Index
  + if a varchar/text is a **very long String**, we use part of it (**its prefix**) as index
  + **Syntax**
  ```sql
  CREATE INDEX index_name ON table_name(field_name(prefix_length));
  ```
  (prefix_length will be shown in EXPLAIN result 'Sub_part')
  + **Selectivity of Index** (索引的选择性) 
    + Selectivity of Index = Number of Distinct Cardinalities / Total Number of Rows 
    + Selectivity of Index is better when ---> 1 (eg.: Primary Index)
    + **Syntax**
    ```sql
    SELECT COUNT(DISTINCT field_name) / COUNT(*) from tb_user;
    SELECT COUNT(DISTINCT SUBSTRING(field_name, start, len) / COUNT(*) from tb_user;
    ```

<br/>

+ Single-column Index & Multiple-column Index/Composite Index
  + Single-column Index:  
    + index link to 1 field
    + if multiple columns with each own single-column is query, MySQL will evaluate efficiency and choose **1** single-column index
  + Multiple-column Index/Composite Index:  
    + index link to multiple fields  
    + order of fields is important

<br/>

---

#### P30 Design Principle
1. Create indexes for tables with **large amounts of data** (100W+ cardinality) and **frequent queries**
2. Create indexes for fields that are **commonly used as query conditions (WHERE), sorting (ORDER BY), and grouping (GROUP BY) operations**
3. Choose columns with **high selectivity** as indexes, and establish **unique indexes** whenever possible
4. If the field is of string type and has a long length, consider creating a **prefix index**
5. Use **composite indexes** as much as possible to reduce single-column indexes
6. **Control the number of indexes**
7. If an indexed column cannot store NULL values, use the **NOT NULL constraint** when creating it (When the optimizer and execution engine know whether a column contains NULL values, they can better determine which index is most effective for the query)

<br/>   

---
---

### P32-P39 SQL Optimizing
#### P32 Insert Data
1. Batch Insert Data: insert 500-1000 tuples in 1 insert SQL
2. Manually commit transaction to reduce number of transaction start and commit
3. Insert in order of Primary Key (按主键顺序插入)
4. For large amount of data insertion: use 'load' to load local files:
  ```bash
  #When connect to MySQL Server
  mysql --local-infile -u root -p 
  ```

  ```sql
  select @@local_infile;
  set global local_infile = 1;

  load data local infile 'path/to/file' into table `tablr_name` fields terminated by ',' lines terminated by '\n';
  ```

---

#### P33 Primary Key Optimizing
1. in InnoDB data are stored in primary key order, this storage strategy is called: Index Organized Table, IOT, 索引组织表
2. Page
    + **Page Split** (页分裂): orrur in **disorderd primary insertion**
    + **Page Merge** (页合并): when deleted data reach **MERGE_THRESHOLD** (50%, by default), pages will be automatically merged
3. **Primary Key Design Principles**:
   1. decrease primary key **length** (save storage for secondary index)
   2. insert primary key **in order** or use AUTO_INCREMENT (avoid page split)
    3. avoid using **natural primary key**, eg.: ID Card Number (avoid 1, 2 above)
    4. **avoid update** in primary key

---

#### P34 Order By Optimizing
1. Order By Strategies (in EXPLAIN 'Extra'):
    1. Usibg filesort: read valid tuples, then sort in buffer area
    2. Using index: sort directly using the ordered scanning by index
2. **Order By Optimizing Principles**
    1. Create index (need obey the leftmost principle)
    2. All these optimizing strategies are based on **Covering Index**
    3. give Collation when creating index
      ```sql
      CREATE idx_name ON table_name (field_name1 ASC, field_name2  DESC);
      ```
    4. If using filesort is unavoidable, expand the buffer area
      ```sql
      show variables like 'sort_buffer_size';
      #256k(262144) by default

      SET sort_buffer_size = 1048576;
      #1MB
      ```

---

#### P35 Group By Optimizin
1. Group By Strategies (in EXPLAIN 'Extra')
    1. Using temporary: no index
    2. Using index: with index
2. **Order By Optimizing Principles**
    1. Create index (need obey the leftmost principle)

---

#### P36 Limit Optimizing
1. When the start_index of LIMIT is extremely large, the SQL take a lot of time
2. **Limit Optimizing Principles**
    1. **Covering Index**
    2. **Table Subquery**: View the column_subquery as a table query with only one column, as 'LIMIT' is not available inside IN()
3. eg.:
    ```sql
    select s.* from tb_sku s, (select id from tb_sku order by id limit 1000000, 10) l where s.id = l.id;
    ```

---

#### P37 Count Optimizing
1. Difficult to optimize dur to property if InnoDB
2. Count(): judge the returned value, if **NOT NULL**, count++
3. Types  
    1. count(primary_key)
        + get each primary_key_value
    2. count(field)
        + get each value by back_table_query
    3. count(1_or_any_other_strange_thing_here): 
        + InnoDB iterate the full table, get each row (but no need to get values in it), return a '1_or_any_other_strange_thing_here' into this row, then count number of '1_or_any_other_strange_thing_here' which is **NOT NULL** for sure
        + count(null) ---> 0
    4. count(*)
        + don't get value, directly count++
4. **Count Optimizing Principle**
    1. Efficiency Rank (depend on whether **get value**):  
    **count(*) = count(1) > count(primary_key) > count(field_not_null) > count(field)**

---

#### P38 Update Optimizing
1. Locking:
    + InnoDB: **row-level locking** (行级锁) in transaction: if a line has not been commited, this **row** is forbidden for manipulation
    + However, if the WHERE in UPDATE **does not have index**, then **table-locking**, lead to low efficiency
2. **UPDATE Optimizing Principle**
    + create index for WHERE fields in the UPDATE SQL

---
---

### P40-P44 View 
#### P40 Basic
1. Concepts:
   + a **View(视图)** is a **virtual table** dased on (encapsulate part of data of) a table in the SELECT statements (base table 基表)
   
2. Syntax
    1. create views:
    ```sql
    CREATE [OR REPLACE] VIEW view_name[(field_names)] AS select_statement [WITH [CASCADE | LOCAL] CHECK OPTION];
    ```

    2. query views:
    ```sql
    #ckeck view's building statements:
    SHOW CREATE VIEW view_name;

    #query view's contains (Same as DQL)
    SELECT * FROM view_name ...;
    ```

    3. alter view
    ```sql
    #Method1: same as create views:
    CREATE [OR REPLACE] | ALTER VIEW view_name[(field_names)] AS select_statement [WITH [CASCADE | LOCAL] CHECK OPTION];
    ```

    4. drop view
    ```sql
    DROP [IF EXISTS] view_name1[, view_name2, ...];
    ```

    5. insert data (insert into base table through view)
    ```sql
    INSERT INTO view_name VALUES (...);
    ```

#### P41-P42 Check Option
1. MySQL will check every update through view, to verfify the data update validity under view's conditions
2. Types:
    1. null: do not check any option
    2. Cascade: Cascade to ckeck option of **all** depending tables/views **no matter if the depending tables have check options**
    3. Local: check this option, cascade to its depending base table/view:   
        + **if the base table has check option**, then check the base table's option;
        + **if the base table does not have check option**, then **do not check anything except for its own option**;
  
#### P43 Update & Usage 
1. Update
+ a view can only update when lines in a view is **uniquely corresponding to lines in the base table**
+ eg.: if a view contains **aggregated functions, `DISTINCT`, `GROUP BY`, `HAVING `, `UNION [ALL]`**, the view is **not insertable**

2. Usage
+ Simplify: encapsulate difficult DML into views, eg.: Multiple_table_query
+ Safety: grant privilege to fields to users (more detailed than DCL)
+ Data independanvy: hide some change from the base table for uses

---
---

### P45-P57 Storage Process
#### P45 Basic
+ Storage Process (存储过程): **compile/encapsulate** a segment of SQL
+ Properties:
    + Encapsulation & Repeated Usage
    + Can accept parameters & return parameters
    + Reduced Internet communication, imprvoe efficiency

#### P46 Syntax
1. Create
```sql
CREATE PROCEDURE storage_process_name([parameter_list])
BEGIN
  --SQL Statements;
END;
#在命令行中，会遇到因'--SQL Statements;'含有';'直接结束的问题
#使用`delimiter $$_or_anything_elsr`以使用特殊字符结束语句
#用完记得改回来(`delimiter ;`)
```

2. Invoke
```sql
CALL storage_process_name([parameter_list]);
```

3. Query
```sql
#query storage process status of a certain database
SELECT * FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_SCHEMA = 'database_name';
#here, one column in the result called 'ROUTINE_DEFINITION' also contains definitions of all storage processes

#query definition of a certain storage process
SHOW CREATE PROCEDURE storage_process_name;
```

4. Drop
```sql
DROP PROCEDURE [IF EXISTS] storage_process_name;
```

### P47-P49 Variables
#### P47 Variable - System Variables (@@)
+ Provided by MySQL Server (in server level)
+ Types:
    + `GLOBAL` #Recover to default values upon restart mysql server --->  `vim /etc/my.cnf` to change configuration
    + `SESSION` #Default
+ Syntax:
    + Query
    ```sql
    #Show all system variables
    SHOW [SESSION | GLOBAL] VARIABLES;
    
    #Search using vague matching
    SHOW [SESSION | GLOBAL] VARIABLES LIKE '...';

    #Show value of a certain system variable
    SELECT @@[SESSION | GLOBAL].sytem_variable_name;
    ```
    + Set
    ```sql
    SET [SESSION | GLOBAL] sytem_variable_name = value;
    SET @@[SESSION | GLOBAL].sytem_variable_name = value;
    ```

#### P48 User-Defined Variables (@)
+ Assigned by users, no need to declare ahead (you can directly `SELECT` without `SET`, but value = **null** if isn't initialized), function for **current connection** 
+ Syntax:
    + Assignment (Just assign agian for update; or assign it to 'null' for dropping, as user-defined variables do not need to state aahead)
    ```sql
    SET|SELECT @var_name [:]= expr[, @var_name [:]= expr, ...]; --better to use ':=' as there's no '==' in MySQL 
    #OR
    SELECT field_name INTO @var_name FROM table_name ...; 
    ```

    + Invoke
    ```sql
    SELECT @var_name;
    ```

#### P49 Local Variables
+ Valid in side a stated **range (`BEGIN` to `END;`)**; **need use `DECLARE` to declare ahead**
+ Syntax:
    + Declare
    ```sql
    DECLARE variable_name variable_type [DEFAULT ...];
    ```
    
    + Assignment
    ```sql
    SET var_name [:]= expr[, var_name [:]= expr, ...]; --better to use ':=' as there's no '==' in MySQL 
    #OR
    SELECT field_name INTO @var_name FROM table_name ...; 
    ```

    + Invoke
    ```sql
    SELECT var_name;
    ```

### P50 If
+ Syntax:
```sql
IF condition1 THEN
  ... 
[ELSEIF condition2 THEN
  ...
ELSE
  ...]
END IF;
```

### P51 Parameter
+ Types:

|Type|Description|
|----|-----------|
|`IN`|**input** when invoke **(defualt)**|
|`OUT`|**output/return**; when passing **(outside of the procedure)**, use **`@var`** to **define** a user-defined parameter, then `SELECT @var` to check; **initialize** the user-defined variable first, as it is `null` by default, hence can not be arithmetically manipulated|
|`INOUT`|**both** `IN` & `OUT`|

+ Syntax
```sql
CREATE PROCEDURE storage_process_name([IN|OUT|INOUT] parameter1_name parameter1_type[, [IN|OUT|INOUT] parameter2_name parameter2_type, ...])
BEGIN
  --SQL Statements;
END;
```

### P52 Case
+ Syntax:
```sql
CASE
    WHEN expr_1 THEN 
        statements_1;
    [WHEN expr_2 THEN 
        statements_2;]
    [...]
    [ELSE 
        statements;]
END CASE;

#OR

CASE variable_name
    WHEN value_1 THEN 
        statements_1
    [WHEN value_2 THEN 
        statements_2]
    [...]
    [ELSE 
        statements]
END CASE;
```

### P53-P55 Loops
#### P53 While
+ Syntax:
```sql
WHILE condition DO
    statements;
END WHILE;
```

#### P54 Repeat
+ Syntax:
```sql
REPEAT 
    statements;
    UNTIL condition
END REPEAT;
```

#### P55 Loop
+ Keywords:
    + `LEAVE`: quit the loop
    + `ITERATE`: quit this iteration, enter next iteration
+ Syntax:
```sql
#eldless loop by default
[loop_name:] LOOP
    statements；
END LOOP [loop_name]; #this line just mark the range of loop, do not mean leave

#use keywords
LEAVE loop_name;
ITERATE loop_name;
```

### P56 Cursor
+ Function: data type for storage of result set
+ Syntax:
```sql
-- declare cursor
DECLARE cursor_name CURSOR FOR dql_statement;

-- open cursor
OPEN cursor_name;

-- fetch cursor recrds
FETCH cursor_name INTO variable[1, variable2, ...];

-- close cursor
CLOSE cursor_name;
```

### P57 Handler (条件处理程序)
+ Function: define procedures to handle specific issues in flow control
+ Syntax:
```sql
DECLARE handler_action HANDLER FOR condition_value[1, condition_value2, ...] statement;

-- handler_action:
CONTINUE
EXIT --EXIT the whole process

-- condition_value
SQLSTATE 'sqlstate_value' --状态码
SQLWARNING --所有以01开头的SQLSATATE
NOT FOUND --所有以02开头的SQLSATATE
SQLEXCEPTION --所有其它的SQLSATATE
```

### P58 Storage Function
+ Definition: Storage Functionis a storage process using IN for parameters (if have parameters) and with returned values
+ Syntax:
```sql
CREATE FUNCTION storage_function_name ([parameter_list]) --do NOT add 'in' here, there are default
RETURNS type [characteristc ...]
BEGIN
  statements;
  RETUEN ...;
END;

--- characteristc
DETERMINISTIC --相同输入参数产生相同结果（结果不因时间，随机数等变化，仅由输入参数决定）
NO SQL --不包含SQL语句
READS SQL DATA --包含DQL，不包含DML（不允许改变原数据库）
```

### P59-62 Trigger (触发器)
+ Function: be defined to trigger some statements before or after executing DML, help maintain db integrity, log, and data parity
+ Alias:
  + `OLD` for getting old data (for `INSERT` or `UPDATE`)
  + `NEW` for getting new data (for `DELETE` or `UPDATE`)
+ Tips: only have row_level_trigger (trigger once for one row), not statement_level_trigger (trigger once for one statement)
+ Syntax:
```sql
-- Create
CREATE TRIGGER tigger_name
BEFORE|AFTER INSERT|UPDATE|DELETE
on table_name FOR EACH ROW --row_level_trigger
BEGIN
  statements;
END;

-- Show
SHOW TRIGGERS;

-- Drop
DROP TRIGGER [schema_name.]tigger_name;
```

---
---

### P64-P75 Lock
#### P64 Lock Introduction
+ Definition: a mechanism for computer to coordinte accesses to shared resources by multiple precesses or threads; prevent DDL & DML, only allow DQL
+ Types:
  1. Global Lock: Locks all tables in the entire database
  2. Table-Level Lock: Locks the entire table for each operation
  3. Row-Level Lock: Locks only the specific row(s) involved in each operation

#### P65-P66 Global Lock
+ Scenarios: whole_db_backup
+ Syntax:
```sql
-- add global lock
flush tables with read lock;
```

```bash
# backup db_name into file: db_name.sql
mysqldump [--single-transaction] [-hIP_address_if_not_localhost] -uuser_name -ppassword db_name > C:/db_name.sql 
# --single-transaction in InnoDB for low_lock backup
```

```sql
-- unlock
unlock tables;
```

#### P67-P70 Table-level Lock
1. Table Lock (表锁)：
  + Types:
    + Read Lock 表共享读锁：所有用户能读不能写
    + Write Lock 表独占写锁：自己能读能写，其他人不能读不能写
  + Syntax: 
  ```sql
  -- add lock
  lock tables table_name[1, table_name2, ...] read|write;

  -- unlock
  unlock tables;
  ```

2. Meta Date Lock (MDL) (元数据锁)
  + Funtion: if a table has transcations which are not commited, MDL will be automatically added for meta data
  + Types:

  |SQL                                                | Type                                    |Description                                            |
  |------------------------------------------------------|-----------------------------------------|-----------------------------------------------|
  | `LOCK TABLES table_name_list READ\|WRITE;`                      | `SHARED_READ_ONLY`\|`SHARED_NO_READ_WRITE` | Compatible with`SHARED_READ`&`SHARED_WRITE`;Not compatible with`EXCLUSIVE` |
  | `SELECT`\|`SELECT ... LOCK IN SHARE MODE`           | `SHARED_READ`                            | Compatible with`SHARED_READ`&`SHARED_WRITE`;Not compatible with`EXCLUSIVE` |
  | `INSERT`\|`UPDATE`\|`DELETE`\|`SELECT ... FOR UPDATE` | `SHARED_WRITE`                           | Compatible with`SHARED_READ`&`SHARED_WRITE`;Not compatible with`EXCLUSIVE` |
  | `ALTER TABLE ...`                                    | `EXCLUSIVE`                              | Not compatible with ang other MDL                        |

  + Syntax for show MDL:
  ```sql
  SELECT
    object_type,
    object_schema,
    object_name,
    lock_type,
    lock_duration
  FROM performance_schema.metadata_locks;
  ```

3. Intension Lock (意向锁)
  + Function: avoid checking for each row's Row_Level_lock before a Table_Level_Lock is added: Intension Lock is added whenever a Row_Leve_Lock is added ---> STable_Level_Lcok only need to copare the compatibiity with the intension lock
  + Types:
    1. Intention Shared (IS) (意向共享锁):
      + Autoatically added when `SELECT ... LOCK IN SHARE MODE`
      + Compatible with a table-level shared lock (read), not compatible with a table-level exclusive lock (write) 
    2. Intention Exclusive (IX) (意向排他锁): 
      + Automatically added when `INSERT`, `UPDATE`, `DELETE`, or `SELECT ... FOR UPDATE`
      + Not compatible with both table-level shared (read) and exclusive (write) locks
    3. IS and IX do not conflict with each other
  + Syntax for show MDL & Row Locks:
    ```sql
    SELECT  object_schema,
      object_name,
      index_name,
      lock_type,
      lock_mode,
      lock_data
    FROM performance_schema.data_locks;
    ```

#### P71-P74 Row-level Lock (InnoDB)
+ Types：
  1. Record Lock (行锁)
      + Lock one row ---> `a`
  2. Gap Lock (间隙锁)
      + Lock an interval in B+_tree's leaf nodes ---> `(a-n, a)`
  3. Next-Key Lock (临键锁)
      + Ecord Lock + Gap Lock ---> `(a-n, a]`

+ Types:
  + Exclusive Lock (X) (排他锁): Allow a transaction holding X to update the data, and prevents other transactions from acquiring either X or S locks on the same data set
  + Shared Lock (S) (共享锁): Allow a transaction to read a row, but prevents other transactions from acquiring X s on the same data set.
  + 
    | Lock Type | S| X |
    | ------------------- | --------------- | ------------------ |
    | S  | Compatible      | Non-compatible           |
    | S   | Non-compatible        | Non-compatible           |

+ Syntax for adding locks:

| SQL Statement                 | Row Lock Type  | Description                                         |
| ----------------------------- | -------------- | --------------------------------------------------- |
| `INSERT ... `                   | X | Automatically acquires lock                         |
| `UPDATE ...`                    | X | Automatically acquires lock                         |
| `DELETE ...`                    | X | Automatically acquires lock                         |
| `SELECT`               | No Lock        | No lock is acquired                                 |
| `SELECT ... LOCK IN SHARE MODE` | S    | Must manually add `LOCK IN SHARE MODE` after `SELECT` |
| `SELECT ... FOR UPDATE`         | X | Must manually add `FOR UPDATE` after `SELECT`         |
  
+ Syntax for showing MDL & Row Locks:
```sql
SELECT  object_schema,
  object_name,
  index_name,
  lock_type,
  lock_mode,
  lock_data
FROM performance_schema.data_locks;
```

+ Results (default is Nextr-Key Lock)

|lock_mode|description|
|---|---|
|S|Share_Lock, Next_Key_Lock, lock `(a-n, a]`|
|S, REC_NOT_GAP|Share_Lock, Record_Lock, lock `a`|
|S, GAP|Share_Lock, Gap_Lock, `(a-n, a)`|
    
+ Key Points
  + InnoDB add row locks w.r.t. **INDEX**, if no index is found, automatically upgrade to an Intension Lock
  + 
  + Equality Query on Unique Index: When locking a record that does not exist, the next-key lock is optimized to a gap lock
  + Equality Query on Non-Unique Index: During right traversal, when the last value does not satisfy the query condition, the next-key lock degrades to a gap lock
  + Range Query on Unique Index: The scan stops upon encountering the first value that does not meet the condition
  + 
  + The sole purpose of gap locks is to prevent other transactions from inserting into the gap. Gap locks can be shared; a gap lock acquired by one transaction does not block another transaction from acquiring a gap lock on the same gap

---

### P76-P90 InnoDB

#### P76 Logical Storage Structure
1. Tablespace (ibd file): A MySQL instance can correspond to multiple tablespaces

2. Segment: Segments are divided into Data Segment (Leaf node segment), Index Segment (Non-leaf node segment), and Rollback Segment

3. Extent: Extent is the unit structure of the tablespace; The size of each extent is 1MB; By default, the page size of InnoDB storage engine is 16KB, so each extent contains 64 consecutive pages

4. Page: page is the smallest disk management unit of InnoDB storage engine, and the default size of each page is 16KB; To ensure the continuity of pages, InnoDB storage engine applies for 4-5 extents from the disk at a time

5. Row: Data in InnoDB storage engine is stored by rows
  - Special Hidden Row Structures:
    - Trx_id:	Each time a record is modified, the corresponding transaction id is assigned to the hidden colum
    - Roll_pointer:	Each time an index record is modified, the old version is written into the undo log, and this hidden column acts as a pointer, which can be used to find the information of the record before modification

#### P77-P80 Framework
1. Memory Frmamework Structures
- Buffer Pool: a memory region for caching frequently accessed disk data, improving operation efficiency and reducing disk I/O；Use unit of pages: free page (Free and unused) & clean page(Used but unmodified) & dirty page (Used and modified)

- Change Buffer: a memory area for non-unique secondary index pages; During DML operations, if the target page is not in the Buffer Pool, the modification is not immediately written to disk but is cached in the Change Buffer; The actual merge into Buffer Pool and flush to disk occurs later, reducing disk I/O operations.

- Adaptive Hash Index: if InnoDB determines that a hash index would speed up queries on Buffer Pool data, it automatically creates Hash Index which is primitively not supported in InnoDB; Relevant Parameter: `adaptive_hash_index`

- Log Buffer: a memory area for temporarily storing redo and undo log data before it is written to disk; By default, its size is 16MB; The log buffer contents are periodically flushed to disk; For transactions with many row changes, increasing the buffer size can reduce disk I/O and improve performance; Relevant Parameters: `innodb_log_buffer_size`(Control size of the log buffer) & `innodb_flush_log_at_trx_commit`(Determines the timing of flushing logs to disk)

2. Disk Framework Structures
- System Tablespace:
  - storage area change buffer.
  - Parameter: innodb_data_file_path

- File-Per-Table Tablespaces
  - Each table’s data and indexes are stored in a separate data file on the file system
  - Parameter: innodb_file_per_table

- General Tablespaces
  - created with SQL statement and be assigned to tables when created manually
  - Syntax:
    ```sql
    -- Create
    CREATE TABLESPACE table_space_name ADD DATAFILE 'file_name' ENGINE = engine_name;

    -- Assignment
    CREATE TABLE table_name (...) TABLESPACE tablea_space_name;
    ```
- Undo Tablespaces
  - Used to store undo log data
  - MySQL automatically creates two default undo tablespaces at startup (default size: 16MB)

- Temporary Tablespaces
  - Used for temporary data

- Doublewrite Buffer Files
  - for crash recovery.
  - before flushing data pages from the Buffer Pool to disk, InnoDB writes them to the doublewrite buffer files `#ib_16384_0.dblwr` & `#ib_16384_1.dblwr`
  
- Redo Log
  - ensures transaction durabilit (ACID)
  - physical log: store pysical data
  - after a transaction is committed, all modification information is saved in the redo log file, which is then used for data recovery when flushing dirty pages to disk or when errors occur
  - two components:
    - Redo log buffer: Stored in memory
    - Redo log files: Stored on disk
  - Redo logs are written in a circular fashion and involve two files:`ib_logfile0` & `ib_logfile1`

3. Background Threads
- Function: flushing data from memory to disk
- Types
  1. Master Thread: core background thread; responsible for coordinating other threads, asynchronously flushing modified data from the buffer pool to disk, flushing dirty pages, merging insert buffer entries, and reclaiming undo pages
  2. IO Threads: process IO requests, handling callbacks for these IO operations
  3. Purge Thread: for reclaiming undo logs that are no longer needed after a transaction is committed
  4. Page Cleaner Thread: assists the master thread in flushing dirty pages to disk

#### P81-P83 Principle Of Transactions
1. Redo Log
- ensures transaction durabilit (ACID)

- physical log: store pysical data

- after a transaction is committed, all modification information is saved in the redo log file, which is then used for data recovery when flushing dirty pages to disk or when errors occur

- two components:
  - Redo log buffer: Stored in memory
  - Redo log files: Stored on disk

- Redo logs are written in a circular fashion and involve two files:`ib_logfile0` & `ib_logfile1`

2. Undo Log (Rollback Log)
- ensures transaction atomicity (ACID)

- logical log: store logical operations

- record information about the state of data before it is modified(when a record is deleted, the undo log records a corresponding insert operation; conversely, when a record is inserted, a corresponding delete operation is logged. When a record is updated, the undo log contains an entry that represents the reverse of the update operation)

- functions:
  - providing rollback capability
  - supporting MVCC (Multi-Version Concurrency Control).


- Undo log disposal: The undo log is generated during transaction execution and is not immediately deleted upon transaction commit, since these logs may still be required for MVCC purposes

- Undo log storage: Undo logs are managed and recorded in the form of segments, and are stored within rollback segments. Internally, there are 1,024 undo log segments within the rollback segment structure

#### P84-P89 MVCC
- Current Read & Snapshot Read
  - Current read: reading the latest version of a record, locks are acquired on the accessed record, such as `select ... lock in share mode` (shared lock) & `select ... for update`, `update`, `insert`, `delete` (exclusive locks)

  - Snapshot read: performed using a simple select statement, read retrieves the visible version of a record, which may be a historical version, and does not acquire locks—thus(non-blocking read)

- MVCC: Multi-Version Concurrency Control

- MVCC maintains multiple versions of a data item, allowing read and write operations to occur without conflict， snapshot reads are implemented using MVCC

- implementation of MVCC：
  - three hidden fields：
    - B_TRX_ID: The ID of the most recent modifying transaction. This field stores the transaction ID that inserted or last modified this record.
    - DB_ROLL_PTR:	Rollback pointer. This field points to the previous version of the record, used together with the undo log to locate the earlier version.
    - DB_ROW_ID:	Hidden primary key. If the table structure does not specify a primary key, this hidden field will be generated as a unique row identifier

  - undo log (chain)
    - When different transactions modify the same record, the undo log generates a version chain for that record
    - The head of the chain points to the most recent previous version, while the tail of the chain points to the earliest version

  - readView
    - different isolation levels have different timing of ReadView creation
      - READ COMMITTED (RC): a new ReadView is created each time a transaction is executing a snapshot read

      - REPEATABLE READ (RR): a new ReadView is created only at first time a transaction is executing a snapshot read

      - SERIALIZABLE: snapshot will degaded into current read 

    - Fields in the view

    |Field|Meaning|
    |---|---|
    | m_ids | The set of transaction IDs for all currently active transactions|
    | min_trx_id| The smallest transaction ID among the active transactions|
    | max_trx_id| The next-to-be-assigned transaction ID, i.e., the current maximum transaction ID + 1 (because transaction IDs are auto-incremented) |
    | creator_trx_id | The transaction ID of the creator of the ReadView|

    - Version Chain Data Access Rules (trx_id: Represents the current transaction ID)
      - trx_id == creator_trx_id: Can access this version(data was modified by the current transaction)

      - trx_id < min_trx_id: Can access this version (data has already been committed)

      - trx_id > max_trx_id: Cannot access this version (transaction started after the ReadView was generated)

      - min_trx_id <= trx_id <= max_trx_id: If trx_id is not in m_ids, can access this version (the data has been committed)

---

### P91-P94 MySQL Management
#### P91 MySQL System Databases
|MySQL System Databases|Function|
|---|---|
|mysql|data for normal operation of the MySQL server, such as timezone, master/slave, users, privileges, etc.|
|information_schema|metadata about databases i, tables, views, etc.|
|performance_schema|monitoring capability for MySQL server runtime status|
|sys|views for developers, based on performance_schema|

#### P92-P93 Useful tools
1. `mysql` (client tool)
```bash
mysql [options] [database]

# options
-u, --user=name       # user name
-p, --password[=name] # password
-h, --host=name       # server IP or domain name
-P, --port=port       # connection port
-e, --execute=name    # execute SQL statement and exit directly, convenient for some scripts
```

2. `mysqladmin` (administration operations)
```bash
# check the options through the help documentation
mysqladmin --help
```

3. `mysqlbinlog` (check binary log files)
```bash
mysqlbinlog [options] log-files1 log-files2 ...

# Options
-d, --database=name       # Specify database name
-o, --offset=             # Skip the first # commands in the log
-r, --result-file=name    # Output the log in text format to the specified file
-s, --short-form          # Show in simple format, omitting some information
--start-datetime=date1 --stop-datetime=date2   # Specify all logs within the date range
--start-position=pos1 --stop-position=pos2     # Specify all logs within the position range
```

4. `mysqlshow` (check statistic information)
```bash
mysqlshow [options] [db_name [table_name [col_name]]]

# Options
--count      # Show statistical information about databases and tables
-i           # Show status information of the specified database or table

5. `mysqldump` (back up databases or migrate data)
```bash
mysqldump [options] db_name [tables]
mysqldump [options] --database/-B db1 [db2 db3...]
mysqldump [options] --all-databases/-A

# Connection Options
-u, --user=name           # Specify user name
-p, --password[=name]     # Specify password
-h, --host=name           # Specify server IP or domain name
-P, --port=               # Specify connection port

# Output Options
--add-drop-database   # Add drop database statement before each database creation statement
--add-drop-table      # Add drop table statement before each table creation statement
-n, --no-create-db    # Do not include create database statement
-t, --no-create-info  # Do not include create table statement
-d, --no-data         # Do not include data
-T, --tab=name        # Automatically generate two files: one .sql file for table creation statements, one .txt file for data
```

6. `mysqlimport/source` (data import tool)
```bash
# import .sql & .txt files
mysqlimport [options] db_name textfile1 [textfile2...]

# import .sql files
source /root/xxxxx.sql
```
