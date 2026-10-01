# Basic:

# P15-P20
```sql
#DQL
#数据准备：
CREATE TABLE emp(
                    id INT COMMENT '编号',
                    workno VARCHAR(10) COMMENT '工号',
                    name VARCHAR(10) COMMENT '姓名',
                    gender CHAR COMMENT '性别',
                    age TINYINT UNSIGNED COMMENT '年龄',
                    idcard CHAR(18) COMMENT '身份证号',
                    workaddress VARCHAR(50) COMMENT '工作地址',
                    entrydate DATE COMMENT '入职时间'
) COMMENT '员工表';

INSERT INTO emp (id, workno, name, gender, age, idcard, workaddress, entrydate)
VALUES
    (1,'1','柳岩','女', 20,'EXAMPLE_ID_0000001','北京','2000-01-01'),
    (2,'2','张无忌','男', 18,'EXAMPLE_ID_0000002','北京','2005-09-01'),
    (3,'3','韦一笑','男', 38,'EXAMPLE_ID_0000003','上海','2005-08-01'),
    (4,'4','赵敏','女', 18,'EXAMPLE_ID_0000004','北京','2009-12-01'),
    (5,'5','小昭','女', 16,'EXAMPLE_ID_0000005','上海','2007-07-01'),
    (6,'6','杨逍','男', 28,'EXAMPLE_ID_000006X','北京','2006-01-01'),
    (7,'7','范瑶','男', 40,'EXAMPLE_ID_0000007','北京','2005-05-01'),
    (8,'8','黛绮丝','女', 38,'EXAMPLE_ID_0000008','天津','2015-05-01'),
    (9,'9','范凉凉','女', 45,'EXAMPLE_ID_0000009','北京','2010-04-01'),
    (10,'10','陈友谅','男', 53,'EXAMPLE_ID_0000002','上海','2011-01-01'),
    (11,'11','张士诚','男',55,'EXAMPLE_ID_0000010','江苏','2015-05-01'),
    (12,'12','常遇春','男',32,'EXAMPLE_ID_0000011','北京','2004-02-01'),
    (13,'13','张三丰','男',88,'EXAMPLE_ID_0000012','江苏','2020-11-01'),
    (14,'14','灭绝','女',65,'EXAMPLE_ID_0000013','西安','2019-05-01'),
    (15,'15','胡青牛','男',70,'EXAMPLE_ID_000014X','西安','2018-04-01'),
    (16,'16','周芷若','女',18,NULL,'北京','2012-06-01');

#Basic Query
select name, workno, age from emp;

select * from emp;

select workaddress  '地址' from emp;

select distinct workaddress  地址 from emp;

#Conditional Query
select * from emp where age <= 20;

select * from emp where age between 20 and 28;

select * from emp where age in(18, 20);

select * from emp where name like '__'; #query those names of 2 words
select * from emp where idcard like '%X'; #query those idcards end with 'X'

select * from emp where idcard is null;

select * from emp where gender = '女' && age <= 20;

#Aggregate Functions
select count(*) from emp;

select min(age) from emp;

select avg(age) from emp;

select sum(age) from emp where workaddress = '西安';

#Grouping Query
select gender, count(*) from emp group by gender;

select gender, avg(age) from emp group by gender;

#查询年龄小于45的员工，并根据工作地址分组，获取员工数量大于等于3的工作地址
select workaddress, count(*) as 'work_address_count' from emp where age < 45 group by workaddress having work_address_count >= 3;

#Sorting Query
select * from emp order by age asc;

select * from emp order by age asc, entrydate desc;

#Pagination Query
select * from emp limit 0, 10;
select * from emp limit 10;

#(2 - 1) * 10 = 10
select * from emp limit 10, 10;
```

---

# P21
```sql
#DQL Case Exercise

#1.查询年龄为20,21,22,23岁的女性员工信息。
select * from emp where gender = '女' and age in(20, 21, 22, 23);

#2.查询性别为男 ，并且年龄在 20-40 岁(含)以内的姓名为三个字的员工。
select * from emp where (gender = '男') and (age between 20 and 40) and (name like '___');

#3.统计员工表中,年龄小于60岁的，男性员工和女性员工的人数。
select gender, count(*) name_count from emp where age < 60 group by gender;

#4.查询所有年龄小于等于35岁员工的姓名和年龄，并对查询结果按年龄升序排序，如果年龄相同按入职时间降序排序
select name, age from emp where age <= 35 order by age, entrydate desc;

#5.查询性别为男，且年龄在20-40 岁(含)以内的前5个员工信息，对查询的结果按年龄升序排序，年龄相同按入职时间升序排序。
select * from emp where gender = '男' and age between 20 and 40 order by age, entrydate limit 5;

#P22
#DQL Execution Order
select e.name name1, e.age age1 from emp e where e.age > 15 order by age1; #OK
#select e.name name1, e.age age1 from emp e where age1 > 15 order by age1; #ERROR OCCURS

#P24 DCL-user management
#query users_table
use mysql;
select * from user;

#create users
create user 'testUser1'@'localhost' identified by '<PASSWORD REDACTED>'; #access in local host
create user 'testUser2'@'%' identified by '<PASSWORD REDACTED>'; #access in any hosts

#alter password
alter user 'testUser1'@'localhost' identified with mysql_native_password by '<PASSWORD REDACTED>';

#drop/delete users
drop user 'testUser'@'localhost';

#P25 DCL-privilege control
#query privilege
show grants for 'root'@'localhost';
show grants for 'testUser1'@'localhost';

#grant privilege
grant all on test1.* to 'testUser1'@'localhost';

#revoke privilege
revoke all on test1.* from 'testUser1'@'localhost';
```

---

# P27-P31
```sql
#String Functions
select concat('Hello ', 'world!');

select lower('Aa');
select upper('Aa');

select LPAD('Hello', 9, '<!--');
select RPAD('Hello', 8, '-->');

select trim('   Hello world!   ');

select substring('Hello world!', 7, 5); #SUBSTRING(str, start, len), index(start) start from 1

#Case: Modify work_number to 5 digits (1 ---> 00001)
update emp set workno = LPAD(workno, 5, '0');



#Numeric Functions
select ceil(0.1);
select floor(1.1);
select mod(6, 5);

select rand();

select round(3.14159, 3);

#Case: Generate a random verification code (6 digits)
select rpad(floor(rand() * 10000000), 6, '0');



#Date and Time Functions
select curdate();
select curtime();
select now();

select year(now());
select month(now());
select day(now());

select date_add(now(), INTERVAL 10 day);

select datediff('2077-12-30', now());

#Case: Query date from entry of all employees, sequencing by descending
select *, datediff(curdate(), entrydate) work_period from emp order by work_period desc;



#Flow Control Functions
select if(true, 'OK', 'NO');

select ifnull('OK', 'NO');
select ifnull(null, 'NO');

#Case: Final grade: average score >= 85: A; average score < 60: C; other: B
create table score (
                       id int,
                       name varchar(10),
                       math int unsigned,
                       english int unsigned,
                       chinese int unsigned
);
insert into score value
    (1, 'Tom', 67, 88, 95),
    (2, 'Rose', 23, 66, 90),
    (3, 'Jack', 95, 90, 76);
select id, name, (case when (((math + english + chinese) / 3 ) >= 85) then 'A' when (((math + english + chinese) / 3 ) < 60) then 'C' else 'B' end) finalAVG from score;

#Case: Select some special workaddress
select name, (case workaddress when '北京' then '京爷' when '上海' then '沪爷' else '其他' end) workaddress from emp;
```

---

# P32-36 Constrains
```sql
#Create table with constrains
create table user(
                      id int primary key auto_increment,
                      name varchar(10) not null unique ,
                      age int check ( age > 0 and age < 120 ),
                      status char(1) default '1',
                      gander char(1)
);

#Insert data
insert into user (name, age, gander) value ('Tom', 19, 'M'), ('Jerry', 20,  'F'); #no need to insert 'id' as it is AUTO_INCREMENT

#P34 Foreign Key
create table department (
    id int auto_increment primary key,
    name varchar(50) not null
);
insert into department (id, name) value (1, 'research department'), (2, 'marketing department'), (3, 'finance department'), (4, 'sales department'), (5, 'management department')

create table emp(
                    id int auto_increment primary key,
                    name varchar(50) not null,
                    age int,
                    job varchar(20),
                    salary int,
                    entrydate date,
                    managerid int,
                    dept_id int
);
INSERT INTO employee (id, name, age, job, salary, entrydate, managerid, dept_id)
VALUES
    (1, '金庸', 66, 'General Manager', 20000, '2000-01-01', null, 5),
    (2, '张无忌', 20, 'Project Manager', 12500, '2005-12-05', 1, 1),
    (3, '杨逍', 33, 'Developer', 8400, '2000-11-03', 2, 1),
    (4, '韦一笑', 48, 'Developer', 11000, '2002-02-05', 2, 1),
    (5, '常遇春', 43, 'Developer', 10500, '2004-09-07', 3, 1),
    (6, '小昭', 19, 'Programmer Assistant', 6600, '2004-10-12', 2, 1),
    (7, '陈友谅', 40, null, 2000, '2011-10-12', null, null);

#Add foreign key
#employee.dept_id as foreign key, link to department.id which is primary key
alter table employee add constraint foreign_key_employee foreign key (dept_id) references department (id) on update cascade on delete set null;

update department set id = 6 where name = 'research department';
#update department set id = 1 where name = 'research department';

#Drop foreign key
#delete from department where id = 1; #error occurs
alter table employee drop foreign key foreign_key_employee;
```

---

# P37:Multiple Table Query: Multiple Table Relationship
```sql
#multiple-to-multiple
create table student(
  id int auto_increment primary key,
  name varchar(10),
  no varchar(10)
);
insert into student values (null, '黛绮丝', '2000100101'), (null, '殷天正', '2000100102'), (null, '韦一笑', '2000100103');

create table course(
    id int auto_increment primary key,
    name varchar(10)
);
insert into course values (null, 'Java'), (null, 'PHP'), (null, 'MySQL'), (null, 'Hadoop');

#intermediate table
create table student_course(
  id int auto_increment primary key,
  student_id int not null,
  course_id int not null,
  constraint foreign_key_intermediate_to_student foreign key (student_id) references student(id),
  constraint foreign_key_intermediate_to_course foreign key (course_id) references course(id)
);
insert into student_course values (null, 1, 1), (null, 1, 2), (null, 1, 3), (null, 2, 2), (null, 2, 3), (null, 2, 4);

#one-to-one
create table tb_user(
    id int primary key auto_increment,
    name varchar(10),
    age int,
    gender char(1),
    phone char(11)
);

create table tb_user_edu (
    id int auto_increment primary key,
    degree varchar(20),
    major varchar(50),
    primaryschool varchar(50),
    middleschool varchar(50),
    university varchar(50),
    userid int unique,
    constraint foreign_key_userid_to_id foreign key (userid) references tb_user(id)
);

insert into tb_user(id, name, age, gender, phone) values
(null, '黄涛', 45, 1, 'EXPHONE0001'),
(null, '冰冰', 35, 2, 'EXPHONE0002'),
(null, '马云', 55, 1, 'EXPHONE0003'),
(null, '李彦宏', 50, 1, 'EXPHONE0004');

insert into tb_user_edu(id, degree, major, primaryschool, middleschool, university, userid) values
(null, '本科', '舞蹈', '静安区第一小学', '静安区第一中学', '北京舞蹈学院', 1),
(null, '硕士', '表演', '朝阳区第一小学', '朝阳区第一中学', '北京电影学院', 2),
(null, '本科', '英语', '杭州市第一小学', '杭州市第一中学', '杭师范大学', 3),
(null, '本科', '应用数学', '阳泉区第一小学', '阳泉区第一中学', '清华大学', 4);
```

---

# P38
```sql
select * from employee, department where employee.dept_id = department.id;
```

---

# P39 Inner Join
```sql
#Query name of employees, join to their department names
#Implicit Inner Join
select employee.name, department.name from employee, department where employee.dept_id = department.id;

#Explicit Inner Join
select employee.name, department.name from employee inner join department on employee.dept_id = department.id;
```

---

# P40 Outer Join
```sql
#Query name of employees, join to their department names
#Left Outer Join
select e.name, d.name from employee e left outer join department d on e.dept_id = d.id;

#Right Outer Join
select e.name, d.name from employee e right outer join department d on e.dept_id = d.id;
```

---

# P41 Self Join
```sql
#Query employees and their managers' names (if no manager, then do not need to output)
select e1.name, e2.name from employee e1 join employee e2 on e1.managerid = e2.id;

#Query employees and their managers' names (if no manager, then also need to output)
select e1.name, e2.name from employee e1 left join employee e2 on e1.managerid = e2.id;

create table emp(
id  int auto_increment comment 'ID' primary key,
name varchar(50) not null comment '姓名',
age  int comment '年龄',
job varchar(20) comment '职位',
salary int comment '薪资',
entrydate date comment '入职时间',
managerid int comment '直属领导ID',
dept_id int comment '部门ID'
)comment '员工表';

INSERT INTO emp (id, name, age, job,salary, entrydate, managerid, dept_id) VALUES
(1, '金庸', 66, '总裁',20000, '2000-01-01', null,5),
(2, '张无忌', 20, '项目经理',12500, '2005-12-05', 1,1),
(3, '杨逍', 33, '开发', 8400,'2000-11-03', 2,1),
(4, '韦一笑', 48, '开发',11000, '2002-02-05', 2,1),
(5, '常遇春', 43, '开发',10500, '2004-09-07', 3,1),
(6, '小昭', 19, '程序员鼓励师',6600, '2004-10-12', 2,1),
(7, '灭绝', 60, '财务总监',8500, '2002-09-12', 1,3),
(8, '周芷若', 19, '会计',4800, '2006-06-02', 7,3),
(9, '丁敏君', 23, '出纳',5250, '2009-05-13', 7,3),
(10, '赵敏', 20, '市场部总监',12500, '2004-10-12', 1,2),
(11, '鹿杖客', 56, '职员',3750, '2006-10-03', 10,2),
(12, '鹤笔翁', 19, '职员',3750, '2007-05-09', 10,2),
(13, '方东白', 19, '职员',5500, '2009-02-12', 10,2),
(14, '张三丰', 88, '销售总监',14000, '2004-10-12', 1,4),
(15, '俞莲舟', 38, '销售',4600, '2004-10-12', 14,4),
(16, '宋远桥', 40, '销售',4600, '2004-10-12', 14,4),
(17, '陈友谅', 42, null,2000, '2011-10-12', 1,null);
```

---

# P42 Union Query
```sql
#select all employees with salary < 5000, and all employees with age > 50
select * from emp where salary < 5000
union all
select * from emp where age > 50;

#Remove replications
select * from emp where salary < 5000
union
select * from emp where age > 50;
```

---

# P44 Scalar Subquery
```sql
#query all emp info for 'sales department'
#query dept_id(id) of sales department
select * from emp where dept_id = (select id from test.department where name = 'sales department');
#as the subquery inside (select id from test.department where name = 'sales department') only return a scalar, this line is so called 'Scalar Subquery'

#query emp info for those entry after '方东白'
select * from emp where entrydate > (select entrydate from emp where name = '方东白');
```

---

# P45 Column Subquery
```sql
#query all emp of sales department & marketing department
select * from emp where dept_id in (select id from department where name = 'sales department' or name = 'marketing department');

#query emp with higher salary than all emp in finance department
select * from emp where salary > all (select salary from emp where dept_id = (select id from department where name = 'finance department'));

#query emp with higher salary than any emp in research department
select * from emp where salary > any (select salary from emp where dept_id = (select id from department where name = 'research department'));
```

---

# P46 Row Subquery
```sql
#query emp whose salary & manager are same as 张无忌's
select * from emp where (salary, managerid) = (select salary, managerid from emp where name = '张无忌');
```

---

# P47 Table Subquery
```sql
#query emp whose job & salary are same as '鹿杖客' | '宋远桥'
select * from emp where (job, salary) in (select job, salary from emp where name in ('鹿杖客', '宋远桥'))

#query all info of emp whose entry date after 2006-01-01
select * from ((select * from emp where entrydate > '2006-01-01') temp_table left join department on temp_table.dept_id = department.id);

#query name, salary and avg_salary in this employee's department
select name, salary, (select avg(salary) from emp where dept_id = e.dept_id) from emp e;
```

---

# P48,P49 Exercise
```sql
create table salgrade(
    grade int,
    losal int,
    hisal int
) comment '薪资等级表';

insert into salgrade values (1,0,3000);
insert into salgrade values (2,3001,5000);
insert into salgrade values (3,5001,8000);
insert into salgrade values (4,8001,10000);
insert into salgrade values (5,10001,15000);
insert into salgrade values (6,15001,20000);
insert into salgrade values (7,20001,25000);
insert into salgrade values (8,25001,30000);

alter table employee add constraint foreign_key_employee foreign key (dept_id) references department (id);
INSERT INTO test.department (id, name) VALUES (6, 'human-resource sales department');

#1.查询员工的姓名、年龄、职位、部门信息（隐式内连接）。
#Inner Join
select emp.name, emp.age, emp.job, department.name from emp, department where department.id = emp.dept_id;

#2.查询年龄小于30岁的员工姓名、年龄、职位、部门信息（显式内连接）。
#Inner Join
select emp.name, emp.age, emp.job, department.name department_name from emp join department on department.id = emp.dept_id where emp.age < 30;

#3.查询拥有员工的部门ID、部门名称。
#Inner Join
select distinct department.id, department.name from department join emp on emp.dept_id = department.id;

#4.查询所有年龄大于40岁的员工,及其归属的部门名称;如果员工没有分配部门,也需要展示出来。
#Left Outer Join
select emp.name, department.name from emp left join department on department.id = emp.dept_id where emp.age > 40;

#5.查询所有员工的工资等级。
#Left Outer Join
select emp.name, salgrade.grade from emp join salgrade on emp.salary between salgrade.losal and salgrade.hisal;

#6.查询"研发部"所有员工的信息及工资等级。
#Inner Join + Row Subquery
select emp.*, salgrade.grade from emp join salgrade on (emp.salary between salgrade.losal and salgrade.hisal) where emp.dept_id = (select id from department where name = 'research department');

#Inner Join
select emp.*, salgrade.grade from emp, department, salgrade where (emp.salary between salgrade.losal and salgrade.hisal) and (emp.dept_id = department.id) and (department.name = 'research department');

#7.查询"研发部"员工的平均工资。
select avg(salary) from emp, department where (emp.dept_id = department.id) and (department.name = 'research department');

#8.查询工资比"灭绝"高的员工信息。
#Scalar Subquery
select * from emp where salary > (select salary from emp where name = '灭绝');

#9.查询比平均薪资高的员工信息。
#Scalar Subquery
select * from emp where salary > (select avg(salary) from emp);

#10.查询低于本部门平均工资的员工信息。
#Column Subquery
select *, (select avg(salary) from emp e2 where e1.dept_id = e2.dept_id) dept_avg_salary from emp e1 where salary < (select avg(e2.salary) from emp e2 where e1.dept_id = e2.dept_id);

#Inner Join + Table Subquery
select emp.*, avg_salary_table.avg_salary from emp join (select dept_id, avg(salary) avg_salary from emp group by dept_id) avg_salary_table on avg_salary_table.dept_id = emp.dept_id where emp.salary < avg_salary_table.avg_salary;

#11.查询所有的部门信息,并统计部门的员工人数。
#Column Subquery
select department.*, (select count(*) from emp where emp.dept_id = department.id) members from department;

#Left Join + Table Subquery
select department.*, member_count.members from department left join (select dept_id, count(*) members from emp group by dept_id) member_count on department.id = member_count.dept_id;

#12.查询所有学生的选课情况,展示出学生名称,学号,课程名称。
select s.name, s.id, c.name from student s, student_course sc, course c where s.id = sc.student_id and c.id = sc.course_id;

# P52 transaction
create table account(
    id int auto_increment primary key comment '主键ID',
    name varchar(10) comment '姓名',
    money int comment '余额'
) comment '账户表';

insert into account(id, name, money) VALUES (null,'张三',2000),(null,'李四',2000);

update account set money = 2000 where name = '张三' or name = '李四';

#check & set commit pattern of transaction:
select @@autocommit;

set @@autocommit = 0;
select @@autocommit;

#Start transaction
start transaction;
#or
begin;

#Transfer Money
#Step1:if if 张三's money >= 1000
select money from account where name = '张三';
#Step2:张三's money - 1000
update account set money = money - 1000 where name = '张三';
#Step3:李四's money + 1000
update account set money = money + 1000 where name = '李四';

#with @@autocommit = 1, the code will be commited to database only if we run this code below:
commit;

#before commit, if we find some exceptions, we run this code below to rollback:
rollback;

#P54 Isolation Level
#Check Current Isolation Level
SELECT @@TRANSACTION_ISOLATION;

#Set Isolation Level
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
```

---
---
---

# Advanced:

# P3-7 Storage Engine
```sql
#ckeck all engines
show engines;
#create tables with certain engine
create table my_myisam (
    id int
) engine = myisam;
show create table my_myisam;

create table my_memory (
                           id int
) engine = memory;
show create table my_memory;
```

---

# P17 Index
```sql
create table tb_user(
                        id int primary key auto_increment comment '主键',
                        name varchar(50) not null comment '用户名',
                        phone varchar(11) not null comment '手机号',
                        email varchar(100) comment '邮箱',
                        profession varchar(11) comment '专业',
                        age tinyint unsigned comment '年龄',
                        gender char(1) comment '性别 , 1: 男, 2: 女',
                        status char(1) comment '状态',
                        createtime datetime comment '创建时间'
) comment '系统用户表';


INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('吕布', 'EXPHONE0005', 'user001@example.invalid', '软件工程', 23, '1', '6', '2001-02-02 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('曹操', 'EXPHONE0006', 'user002@example.invalid', '通讯工程', 33, '1', '0', '2001-03-05 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('赵云', 'EXPHONE0007', 'user003@example.invalid', '英语', 34, '1', '2', '2002-03-02 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('孙悟空', 'EXPHONE0008', 'user004@example.invalid', '工程造价', 54, '1', '0', '2001-07-02 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('花木兰', 'EXPHONE0009', 'user005@example.invalid', '软件工程', 23, '2', '1', '2001-04-22 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('大乔', 'EXPHONE0010', 'user006@example.invalid', '舞蹈', 22, '2', '0', '2001-02-07 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('露娜', 'EXPHONE0011', 'user007@example.invalid', '应用数学', 24, '2', '0', '2001-02-08 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('程咬金', 'EXPHONE0012', 'user008@example.invalid', '化工', 38, '1', '5', '2001-05-23 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('项羽', 'EXPHONE0013', 'user009@example.invalid', '金属材料', 43, '1', '0', '2001-09-18 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('白起', 'EXPHONE0014', 'user010@example.invalid', '机械工程及其自动化', 27, '1', '2', '2001-08-16 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('韩信', 'EXPHONE0015', 'user011@example.invalid', '无机非金属材料工程', 27, '1', '0', '2001-06-12 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('荆轲', 'EXPHONE0016', 'user012@example.invalid', '会计', 29, '1', '0', '2001-05-11 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('兰陵王', 'EXPHONE0017', 'user013@example.invalid', '工程造价', 44, '1', '1', '2001-04-09 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('狂铁', 'EXPHONE0018', 'user014@example.invalid', '应用数学', 43, '1', '2', '2001-04-10 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('貂蝉', 'EXPHONE0019', 'user015@example.invalid', '软件工程', 40, '2', '3', '2001-02-12 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('妲己', 'EXPHONE0020', 'user016@example.invalid', '软件工程', 31, '2', '0', '2001-01-30 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('芈月', 'EXPHONE0021', 'user017@example.invalid', '工业经济', 35, '2', '0', '2000-05-03 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('嬴政', 'EXPHONE0022', 'user018@example.invalid', '化工', 38, '1', '1', '2001-08-08 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('狄仁杰', 'EXPHONE0023', 'user019@example.invalid', '国际贸易', 30, '1', '0', '2007-03-12 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('安琪拉', 'EXPHONE0024', 'user020@example.invalid', '城市规划', 51, '2', '0', '2001-08-15 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('典韦', 'EXPHONE0025', 'user021@example.invalid', '城市规划', 52, '1', '2', '2000-04-12 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('廉颇', 'EXPHONE0026', 'user022@example.invalid', '土木工程', 19, '1', '3', '2002-07-18 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('后羿', 'EXPHONE0027', 'user023@example.invalid', '城市园林', 20, '1', '0', '2002-03-10 00:00:00');
INSERT INTO tb_user (name, phone, email, profession, age, gender, status, createtime) VALUES ('姜子牙', 'EXPHONE0028', 'user024@example.invalid', '工程造价', 29, '1', '4', '2003-05-26 00:00:00');

#check index
show index from tb_user;

#create index
create index index_name on tb_user(name); #normal index
create unique index index_phone on tb_user(phone); #unique index
create index index_profession_age_status on tb_user(profession, age, status); #compisite index #order of fields is important

#drop index
drop index index_name on tb_user;
```

---

# P18 Performance Analysis
```sql
#Frequncy Query
show global status like 'Com_______';
show session status like 'Com_______';
```

---

# P21 Explain
```sql
select s.*, c.* from student s, course c, student_course sc where s.id = sc.student_id and sc.course_id = c.id;
explain select s.*, c.* from student s, course c, student_course sc where s.id = sc.student_id and sc.course_id = c.id;

select * from student where id in (select student_id from student_course where course_id in (select id from course where name = 'MySQL'));
explain select * from student where id in (select student_id from student_course where course_id = (select id from course where name = 'MySQL'));

explain select * from tb_user where id = 1;

explain select 'A';
explain select * from tb_user where id = 10000000000;
```

---

# P22 introduction to index usage
```sql
#Fast as use PRIMARY Index
select * from tb_sku where id = 1;
explain select * from tb_sku where id = 1;

#Slow as no Index
select * from tb_sku where sn = '100000003145001';
explain select * from tb_sku where sn = '100000003145001';

#Add an index ---> fast
create index index_tb_sku_sn on tb_sku(sn); #Slow itself
select * from tb_sku where sn = '100000003145001';
explain select * from tb_sku where sn = '100000003145001';
```

---

# P23 Leftmost Prefix Rule & Range Query
```sql
#Leftmost Prefix Rule
show index from tb_user;
explain select * from tb_user where profession = ''软件工程'' and age = 31 and status = ''0''; #use #len = 54
explain select * from tb_user where profession = ''软件工程'' and age = 31; #use #len = 49
explain select * from tb_user where profession = ''软件工程''; #use #len = 47
explain select * from tb_user where age = 31 and status = 0; #null index
explain select * from tb_user where profession = ''软件工程'' and status = ''0''; #Partially use #len = 47

#Range Query
explain select * from tb_user where profession = ''软件工程'' and age > 30 and status = ''0''; #Partially use #len = 49
#to avoid this:
explain select * from tb_user where profession = ''软件工程'' and age >= 30 and status = ''0''; #Partially use #len = 54
```

---

# P24-25 Index Invalidation
```sql
explain select * from tb_user where substring(phone, 10, 2) = 15; #index invalidation

explain select * from tb_user where profession = '软件工程' and age = 30 and status = '0'; #index_profession_age_status = 54
explain select * from tb_user where profession = '软件工程' and age = 30 and status = 0; #index_profession_age_status = 49

explain select * from tb_user where profession like '软件%'; #index_profession_age_status = 47
explain select * from tb_user where profession like '%工程'; #index invalidation

explain select * from tb_user where id = 10 OR age = 23; #index invalidation
create  index idx_user_age on tb_user(age);
explain select * from tb_user where id = 10 OR age = 23; #PRIMARY,idx_user_age

explain select * from tb_user where profession is not null; #index invalidation
```

---

# P26 SQL Hint
```sql
explain select * from tb_user where profession = '软件工程';
create index idx_user_pro on tb_user(profession);
explain select * from tb_user where profession = '软件工程';

explain select * from tb_user use index (idx_user_pro) where profession = '软件工程'; #use idx_user_pro

explain select * from tb_user force index (idx_user_pro) where profession = '软件工程'; #use idx_user_pro

explain select * from tb_user ignore index (index_profession_age_status) where profession = '软件工程'; #use idx_user_pro
```

---

# P27 Index  Covering
```sql
drop index idx_user_age on tb_user;
drop index idx_user_pro on tb_user;
show index from tb_user;

explain select * from tb_user where profession = '软件工程' and age = 31 and status = '0'; #Using index condition

explain select id, profession, age from tb_user where profession = '软件工程' and age = 31 and status = '0'; #Using where; Using index

explain select id, profession, age, status from tb_user where profession = '软件工程' and age = 31 and status = '0'; #Using where; Using index
```

---

# P28 Prefix Index
```sql
select count(*) from tb_user; #24
select count(distinct email) from tb_user; #24

select count(distinct email) / count(*) from tb_user; #1.0000
select count(distinct substring(email, 1, 10)) / count(*) from tb_user; #1.0000
select count(distinct substring(email, 1, 9)) / count(*) from tb_user; #0.9583
select count(distinct substring(email, 1, 5)) / count(*) from tb_user; #0.9583
select count(distinct substring(email, 1, 4)) / count(*) from tb_user; #0.9167
#Hence, if we do not always require 100% selectivity, we choose prefix_length = 5 to decrease index size

create index idx_email_5 on tb_user(email(5));
show index from tb_user;

explain select * from tb_user where email = 'user003@example.invalid';
```

---

#P34 Order By Optimizing
```sql
show index from tb_user;

explain select id, age, phone from tb_user order by age; #No index: Using filesort

create index idx_users_age_phone on tb_user(age, phone);

explain select id, age, phone from tb_user order by age; #use left-most part of the index: Using index

explain select id, age, phone from tb_user order by phone; #use other part of the index (obey the leftmost prefix rule): Using index; Using filesort

explain select id, age, phone from tb_user order by age desc, phone desc; #use composite index, all desc: Backward index scan; Using index

explain select id, age, phone from tb_user order by age, phone desc; #use composite index, some asc, other desc(obey B+Tree Structure): Using index; Using filesort
#To solve this, give Collation when creating the index:
create index idx_users_age_phone_ad on tb_user(age asc, phone desc);
explain select id, age, phone from tb_user order by age, phone desc; #use composite index, some asc, other desc(obey B+Tree Structure): Using index

explain select id, age, phone, profession from tb_user order by age, phone desc; #use composite index, some asc, other desc(obey B+Tree Structure): Using index

explain select id, name, age, phone, profession from tb_user order by age, phone desc; #Not covering index: Using filesort

show variables like 'sort_buffer_size'; #256k by default
SET sort_buffer_size = 1048576; #1MB
```

---

# P35 Group By Optimizing
```sql
show index from tb_user;

explain select profession, count(*) from tb_user group by profession; #No index: Using temporary

create index idx_user_pro_age_status on tb_user(profession, age, status);

explain select profession, count(*) from tb_user group by profession; #With index: Using index

explain select profession, age, count(*) from tb_user where profession = '软件工程' group by age; #this also obeys the leftmost principle: Using index
```

---

# P36 Limit Optimizing
```sql
select count(*) from tb_sku;
select * from tb_sku limit 0, 10;

select * from tb_sku limit 1000000, 10; #take a lot of time

select id from tb_sku order by id limit 1000000, 10; #Covering Index

#View the column_subquery as a table query with only one column, as 'LIMIT' is not available inside IN()
select s.* from tb_sku s, (select id from tb_sku order by id limit 1000000, 10) l where s.id = l.id; #Covering Index + Table Subquery
```

---

# P37 Count Optimizing
```sql
select count(*) from tb_user;
select count(666) from tb_user;
select count('666') from tb_user;
```

---
---

# P40 view syntax
```sql
#creat view
create or replace view tb_user_view_1 as select id, name, age from tb_user where age <= 25 and gender = 2 order by age;
create or replace view tb_user_view_2 as select id, name, age from tb_user where age <= 25 and gender = 1 order by age with cascaded check option;

#show create view
show create view tb_user_view_1;

#query view
select * from tb_user_view_1 where age = (select min(age) from tb_user_view_1);

#alter view:
create or replace view tb_user_view_1 as select id, name, age, phone from tb_user where age <= 25 and gender = 2 order by age;
alter view tb_user_view_1 as select id, name, age, phone, email from tb_user where age <= 25 and gender = 2 order by age;

#drop view
drop view if exists tb_user_view_2;
```

---

# P43 Update views
```sql
create view tb_user_view_4 as select count(*) from tb_user;

insert into tb_user_view_4 value (10); #error: The target table tb_user_view_4 of the INSERT is not insertable-into
```

---

# P44 Case
```sql
-- Create Students Table
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    english_name VARCHAR(50) NOT NULL
);

-- Create Courses Table
CREATE TABLE Courses (
    course_code VARCHAR(10) PRIMARY KEY,
    course_full_name VARCHAR(100) NOT NULL
);

-- Create Junction Table
CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_code VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_code) REFERENCES Courses(course_code)
);

-- Insert Sample Students
INSERT INTO Students (student_id, english_name) VALUES
(1, 'John Doe'),
(2, 'Jane Smith'),
(3, 'Michael Brown'),
(4, 'Emily Davis'),
(5, 'David Wilson');

-- Insert Sample Courses
INSERT INTO Courses (course_code, course_full_name) VALUES
('MATH101', 'Mathematics 101'),
('ENG201', 'English Literature 201'),
('SCI301', 'Introduction to Science 301'),
('HIST401', 'World History 401'),
('ART105', 'Fine Arts Fundamentals');

-- Insert Enrollment Records
INSERT INTO Enrollments (student_id, course_code) VALUES
(1, 'MATH101'),
(1, 'ENG201'),
(2, 'ENG201'),
(2, 'SCI301'),
(3, 'MATH101'),
(3, 'HIST401'),
(4, 'ART105'),
(4, 'SCI301'),
(5, 'ENG201'),
(5, 'HIST401'),
(5, 'ART105');

#1. 为了保证数据库表的安全性，开发人员在操作tb_user表时，只能看到的用户的基本字段，屏蔽手机号和邮箱两个字段。
create or replace view tb_user_view_case_1 as select id, name, profession, age, gender, status, createtime from tb_user with cascaded check option;
select * from tb_user_view_case_1;

#2. 查询每个学生所选修的课程（三张表联查），这个功能在很多的业务中都有使用到，为了简化操作，定义一个视图。
create or replace view view_s_e_c_1 as select Students.*, Courses.* from Students, Enrollments, Courses where Students.student_id = Enrollments.student_id and Enrollments.course_code = Courses.course_code with cascaded check option;
select * from view_s_e_c_1;
```

---

# P46 Storage Process Syntax
```sql
#Create
create procedure sp_1()
begin
    select count(*) from Students;
end;

create procedure sp_2()
begin
    select count(*) from Students;
end;

#Invoke
call sp_1();

#Query
select * from information_schema.ROUTINES where ROUTINE_SCHEMA = 'self_study';
show create procedure sp_1;

#Drop
drop procedure if exists sp_2;
```

---

# P47 System Variables
```sql
#Query
show variables; #'session' by default
show global variables like '%auto%';
select @@global.autocommit;

#Set
set global autocommit  = 1;
set @@global.autocommit  = 1;
```

---

# P48 User-Defined Variables
```sql
#Assignment
set @my_v_1 = 'my_v_1';
select @my_v_2 := 'my_v_2';
set @my_v_3 = 'my_v_3', @my_v_4 = 'my_v_4';
set @my_v_4 = 'new_my_v_4';

select count(*) into @my_v_5 from tb_user;

#Invoke
select @my_v_1, @my_v_2, @my_v_3, @my_v_4, @my_v_5, @my_v_6;
```

---

# P49 Local Variables
```sql
create procedure sp_2()
begin
    #Declare
    declare v1 int default 0;
    declare v2 int default 0;
    declare v3 int default 0;
    declare v4 int;

    #Assignment
    set v1 := 100, v2 = 20;
    select count(*) into v3 from tb_user;

    #Invoke
    select v1, v2, v3, v4;
end;

call sp_2();
```

---

# P50 If
```sql
drop procedure if exists sp_3;

create procedure sp_3()
begin
    declare score int default 58;
    declare grade varchar(5);

    #根据定义的分数score变量，判定当前分数对应的分数等级。
#1.score >=85分，等级为优秀。
#2.score >= 60分 且 score <85分，等级为及格。
#3.score <60分，等级为不及格。
    if score >= 85 then
        set grade := '优秀';
    elseif score >= 60 then
        set grade := '及格';
    else
        set grade := '不及格';
    end if;

    select grade;
end;

call sp_3();
```

---

# P51 Parameter
```sql
-- 根据传入（in）参数score，判定当前分数对应的分数等級，并返回Cout）。
-- score >= 85分，等级为优秀。
-- score >= 60分 日 score < 85分，等級为及格。
-- score <60分，等级为不及格
create procedure sp_4(in score int, out grade varchar(5))
begin

    if score >= 85 then
        set grade := '优秀';
    elseif score >= 60 then
        set grade := '及格';
    else
        set grade := '不及格';
    end if;

end;

-- set user-defined variables to accept the return parameter
call sp_4(88, @grade);
select @grade;

-- 将传入的200分制的分数，进行换算，换算成百分制，然后返回
create procedure sp_5(inout score double)
begin
    set score := score / 2;
end;

-- set user-defined variables and assign it as an `IN` value first,
-- and then use it again to accept the return parameter
set @score = 198;
call sp_5(@score);
select @score;
```

---

# P52 Case
```sql
#根据传入的月份，判定月份所属的季度（要求采用case结构）
create procedure sp_6(in month int, out season varchar(20))
begin

    case
    #1-3月份，为第一季度
        when month >= 1 and month <= 3 then
                set season = concat(month, ': ', 'Season 1');
    #4-6月份，为第二季度
        when month >= 4 and month <= 6 then
                set season = concat(month, ': ', 'Season 2');
    #7-9月份，为第三季度
        when month >= 7 and month <= 9 then
                set season = concat(month, ': ', 'Season 3');
    #10-12月份，为第四季度
        when month >= 10 and month <= 12 then
                set season = concat(month, ': ', 'Season 4');
    #否则提示非法输入
        ELSE
                set season = concat(month, ': ', 'Invalid!');
    end case;

end;
call sp_6(20, @season1);
select @season1;

#OR

create procedure sp_7(in month int, out season varchar(20))
begin

    case month
        WHEN 1 THEN SET season = CONCAT(month, ': ', 'Season 1');
        WHEN 2 THEN SET season = CONCAT(month, ': ', 'Season 1');
        WHEN 3 THEN SET season = CONCAT(month, ': ', 'Season 1');
        WHEN 4 THEN SET season = CONCAT(month, ': ', 'Season 2');
        WHEN 5 THEN SET season = CONCAT(month, ': ', 'Season 2');
        WHEN 6 THEN SET season = CONCAT(month, ': ', 'Season 2');
        WHEN 7 THEN SET season = CONCAT(month, ': ', 'Season 3');
        WHEN 8 THEN SET season = CONCAT(month, ': ', 'Season 3');
        WHEN 9 THEN SET season = CONCAT(month, ': ', 'Season 3');
        WHEN 10 THEN SET season = CONCAT(month, ': ', 'Season 4');
        WHEN 11 THEN SET season = CONCAT(month, ': ', 'Season 4');
        WHEN 12 THEN SET season = CONCAT(month, ': ', 'Season 4');
        ELSE SET season = CONCAT(month, ': ', 'Invalid!');
    end case;

end;

call sp_7(4, @season2);
select @season2;
```

---

# P53 While
```sql
create procedure sp_8(in n int, out sum int)
begin
    set sum := 0;

    while n > 0 DO
        set sum := sum + n;
        set n := n - 1;
    end while;

end;

call sp_8(100, @sum);
select @sum;
```

---

# P54 Repeat
```sql
create procedure sp_8(in n int, out sum int)
begin
    set sum = 0;

    repeat
        set sum := sum + n;
        set n := n - 1;
        until n = 0
    end repeat;

end;

call sp_8(100, @sum);
select @sum;
```

---

# P55 Loop
```sql
create procedure sp_9(in n int, out sum int)
begin
    set sum := 0;

    loop1: loop
        if n % 2 = 1 then
            set n = n - 1;
            iterate loop1;
        end if;

        set sum := sum + n;
        set n := n - 1;

        if n <= 0 then
            leave loop1;
        end if;
    end loop loop1; #this line just mark the range of loop, do not mean leave

end;

call sp_9(100, @sum);
select @sum;
```

---

# P56-57 Cursor & Handler
```sql
create procedure p11(in uage int)
begin
    -- 1. prepare variables & cursors (variables must BEFORE cursors) & handler (cursors must BEFORE handlers)
    declare uname varchar(20);
    declare uphone varchar(50);
    declare ucursor cursor for select name, phone from tb_user where age < uage;
    declare exit handler for SQLSTATE '02000' close ucursor;

    -- 2. prepare table
    drop table  if exists tb_user_phone;
    create table tb_user_phone (
        id int primary key auto_increment,
        name varchar(20),
        phone varchar(50)
    );

    -- 3. use cursor
    -- a. open
    open ucursor;
    -- b. fetch (using loops)
    while true do
        fetch ucursor into uname, uphone;
        insert into tb_user_phone (name, phone) VALUES (uname, uphone);
    end while;
    -- c. close
    close ucursor;
end;

call p11(54);
select * from tb_user_phone;
```

---

# P58 Storage Function
```sql
CREATE FUNCTION fun_1 (n int)
RETURNS int deterministic
begin
    declare sum int default 0;
    while n > 0 do
        set sum := sum + n;
        set n := n -1;
        end while;

    return sum;
end;

select fun_1(100);
```

---
# P59-62 Trigger
```sql
-- preparation
create table user_logs(
    id int primary key auto_increment,
    operation varchar(20) not null,
    operate_time datetime not null,
    operate_id int not null,
    operate_params varchar(500)
);
show triggers;

drop trigger if exists tb_user_insert_trigger;
drop trigger if exists tb_user_update_trigger;
drop trigger if exists tb_user_delete_trigger;

show triggers;

-- insert_trigger
create trigger tb_user_insert_trigger
    after insert
    on tb_user for each row
    begin
        insert into user_logs (id, operation, operate_time, operate_id, operate_params)
            values (null, 'insert', now(), new.id, concat('inserting: id = ',new.id,'; name = ',new.name,'; age = ',new.age,'; gender = ',new.gender,'; phone = ',new.phone));
    end;

-- update_trigger
create trigger tb_user_update_trigger
    after update
    on tb_user for each row
    begin
        insert into user_logs (id, operation, operate_time, operate_id, operate_params)
            values (null, 'update', now(), new.id, concat('updating: id = ',old.id,'; name = ',old.name,'; age = ',old.age,'; gender = ',old.gender,'; phone = ',old.phone,' ---> id = ',new.id,'; name = ',new.name,'; age = ',new.age,'; gender = ',new.gender,'; phone = ',new.phone));
    end;

-- delete_trigger
create trigger tb_user_delete_trigger
    after delete
    on tb_user for each row
    begin
        insert into user_logs (id, operation, operate_time, operate_id, operate_params)
            values (null, 'delete', now(), old.id, concat('deleting: id = ',old.id,'; name = ',old.name,'; age = ',old.age,'; gender = ',old.gender,'; phone = ',old.phone));
    end;

-- test
insert into tb_user values (null, '张三', 60, 2, 'EXPHONE0029'), (null, '李四', 62, 2, 'EXPHONE0030'); -- trigger act twice (2 records in user_logs)
update tb_user set gender = 1  where age >= 60; -- trigger act twice (2 records in user_logs)
delete from tb_user where age >= 60; -- trigger act twice (2 records in user_logs)
```