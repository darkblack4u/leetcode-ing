> #### 组合两个表 https://leetcode-cn.com/problems/combine-two-tables/

**selct 列名 from A left join B on A.a = B.b**

```
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;
```

> #### 第二高薪 https://leetcode-cn.com/problems/second-highest-salary/

**ORDER BY**
**DESC**

```
SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary
```

```
mysql中isnull,ifnull,nullif的用法如下：

isnull(expr) 的用法： 如expr 为null，那么isnull() 的返回值为 1，否则返回值为 0。 
mysql> select isnull(1+1); -> 0 
mysql> select isnull(1/0); -> 1 
使用= 的null 值对比通常是错误的。

isnull() 函数同 is null比较操作符具有一些相同的特性。请参见有关is null 的说明。

IFNULL(expr1,expr2)的用法：

假如expr1 不为 NULL，则 IFNULL() 的返回值为 expr1; 否则其返回值为 expr2。IFNULL()的返回值是数字或是字符串，具体情况取决于其所使用的语境。

mysql> SELECT IFNULL(1,0);
-> 1
mysql> SELECT IFNULL(NULL,10);
-> 10
mysql> SELECT IFNULL(1/0,10);
-> 10
```

> #### 184. 部门工资最高的员工 https://leetcode-cn.com/problems/department-highest-salary/

**SELECT MAX(a) FROM A GROUP BY A.b**
**WHERE (a,b) IN ()**

```
SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Employee.DepartmentId , Salary) IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
	)
;
```

> #### 177. 第N高的薪水 https://leetcode-cn.com/problems/nth-highest-salary/

**SET**
**LIMIT i,n**

```
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT 
            salary
      FROM 
            employee
      GROUP BY 
            salary
      ORDER BY 
            salary DESC
      LIMIT N, 1
  );
END
```

```
select * from tableName limit i,n
# tableName：表名
# i：为查询结果的索引值(默认从0开始)，当i=0时可省略i
# n：为查询结果返回的数量
# i与n之间使用英文逗号","隔开

# 
limit n 等同于 limit 0,n
```

> #### 185. 部门工资前三高的所有员工 https://leetcode-cn.com/problems/department-top-three-salaries/

```
SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (SELECT
            COUNT(DISTINCT e2.Salary)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
                AND e1.DepartmentId = e2.DepartmentId
        )
;
```
```
公司里前 3 高的薪水意味着有不超过 3 个工资比这些值大。


select e1.Name as 'Employee', e1.Salary
from Employee e1
where 3 >
(
    select count(distinct e2.Salary)
    from Employee e2
    where e2.Salary > e1.Salary
)
;
```

> #### 178. 分数排名 https://leetcode-cn.com/problems/rank-scores/

- **row_number()**：依次递增排名，无重复排名
- **rank()**：相同分数有重复排名，但是重复后下一个人按照实际排名
- **dense_rank()**：分数一致排名一致，分数不一致排名+1
- **NTILE(4)**：分组排名，里面的数字是几，最多排名就是几，里面的数字是4，最多的排名就是4

```
# Write your MySQL query statement below
select Score, dense_rank() over (order by Score desc) as `Rank` from Scores
```

> #### 180. 连续出现的数字 https://leetcode-cn.com/problems/consecutive-numbers/

用 **DISTINCT** 和 **WHERE** 语句

```
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;
```

> #### 181. 超过经理收入的员工 https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/

```
SELECT 
    e1.Name as Employee
FROM 
    Employee e1,
    Employee e2
WHERE
    e1.ManagerId = e2.Id
    AND e1.Salary > e2.Salary
;
```

> #### 196. 删除重复的电子邮箱 https://leetcode-cn.com/problems/delete-duplicate-emails/

**DELETE 表名 WHERE**

```
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id
;
```

> #### 1777. 每家商店的产品价格 https://leetcode-cn.com/problems/products-price-for-each-store/

```
SELECT 
    product_id, 
    MIN(CASE store WHEN 'store1' THEN price ELSE null END) AS store1, 
    MIN(CASE store WHEN 'store2' THEN price ELSE null END) AS store2, 
    MIN(CASE store WHEN 'store3' THEN price ELSE null END) AS store3
FROM products
GROUP BY product_id
```

使用group by分组计算，取每一组中对应情况的通过case when + 聚合函数（min，max,sum,avg）的结合，
求出相同产品在不同商店中的price

case when的使用方法如下：
```
    CASE 输入参数
    WHEN 可能的情况 THEN
        result
    ELSE
        else_result
    END
我们先来看一下case when的作用
SELECT 
    product_id,
    (CASE store WHEN 'store1' THEN price ELSE null END) AS store1, 
    (CASE store WHEN 'store2' THEN price ELSE null END) AS store2, 
    (CASE store WHEN 'store3' THEN price ELSE null END) AS store3
FROM products
执行之后会出现如下结果:
[0, 95, null, null], 
[0, null, null, 105], 
[0, null, 100, null], 
[1, 70, null, null], 
[1, null, null, 80]
```

> #### 182. 查找重复的电子邮箱 https://leetcode-cn.com/problems/duplicate-emails/

方法一：使用 **GROUP BY** 和**临时表**
```
select Email from
(
  select Email, count(Email) as num
  from Person
  group by Email
) as statistic
where num > 1
;
```
方法二：使用 **GROUP BY** 和 **HAVING** 条件
```
select Email
from Person
group by Email
having count(Email) > 1;
```

> #### 1179. 重新格式化部门表 https://leetcode-cn.com/problems/reformat-department-table/

```
select id,
    sum(case month when 'Jan' then revenue end) as Jan_Revenue,
    sum(case month when 'Feb' then revenue end) as Feb_Revenue,
    sum(case month when 'Mar' then revenue end) as Mar_Revenue,
    sum(case month when 'Apr' then revenue end) as Apr_Revenue,
    sum(case month when 'May' then revenue end) as May_Revenue,
    sum(case month when 'Jun' then revenue end) as Jun_Revenue,
    sum(case month when 'Jul' then revenue end) as Jul_Revenue,
    sum(case month when 'Aug' then revenue end) as Aug_Revenue,
    sum(case month when 'Sep' then revenue end) as Sep_Revenue,
    sum(case month when 'Oct' then revenue end) as Oct_Revenue,
    sum(case month when 'Nov' then revenue end) as Nov_Revenue,
    sum(case month when 'Dec' then revenue end) as Dec_Revenue
from Department
group by id
order by id
```

> #### 197. 上升的温度 https://leetcode-cn.com/problems/rising-temperature/


MySQL 使用 **DATEDIFF** 来比较两个日期类型的值。


```
SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.date, w.date) = 1
        AND weather.Temperature > w.Temperature
;
```

> #### 627. 变更性别 https://leetcode-cn.com/problems/swap-salary/

要想动态地将值设置成列，我们可以在使用 **CASE...WHEN...** 流程控制语句的同时使用 **UPDATE SET** 语句。
```
UPDATE salary
SET
    sex = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;
```

> #### 601. 体育馆的人流量 https://leetcode-cn.com/problems/human-traffic-of-stadium/

```
select distinct t1.*
from stadium t1, stadium t2, stadium t3
where t1.people >= 100 and t2.people >= 100 and t3.people >= 100
and
(
	(t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1) -- t1, t2, t3
    or
    (t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1) -- t2, t1, t3
    or
    (t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2) -- t3, t2, t1
)
order by t1.id
;
```

> #### 626. 换座位 https://leetcode-cn.com/problems/exchange-seats/

**WHEN CASE**

```
SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND c = id THEN id
        WHEN MOD(id, 2) != 0 AND c != id THEN id + 1 
        ELSE id - 1
    END) AS 'id',
    student
FROM 
    seat, (SELECT COUNT(*) AS c FROM seat) as seats
ORDER BY
    id ASC

```

> #### 1141. 查询近30天活跃用户数 https://leetcode-cn.com/problems/user-activity-for-the-past-30-days-i/

```
SELECT activity_date AS day, COUNT(DISTINCT user_id) AS active_users
FROM Activity
WHERE datediff('2019-07-27',activity_date) < 30
-- WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY activity_date
```

> #### 1270. 向公司CEO汇报工作的所有人 https://leetcode-cn.com/problems/all-people-report-to-the-given-manager/

**UNION ALL**

```
SELECT DISTINCT employee_id FROM (
    SELECT employee_id
    FROM Employees WHERE manager_id = 1
    UNION ALL
    SELECT employee_id
    FROM Employees WHERE manager_id IN (
        SELECT employee_id FROM Employees WHERE manager_id = 1
    )
    UNION ALL
    SELECT employee_id
    FROM Employees WHERE manager_id IN (
        SELECT employee_id FROM Employees WHERE manager_id IN (
            SELECT employee_id FROM Employees WHERE manager_id = 1
        )
    )
) T WHERE employee_id != 1

```