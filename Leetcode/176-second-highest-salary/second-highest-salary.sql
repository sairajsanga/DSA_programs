# Write your MySQL query statement below
-- select MAX(salary) as SecondHighestSalary from Employee 
-- where salary < (select MAX(salary) from Employee);

select (select distinct salary from employee order by salary desc limit 1 OFFSET 1) as SecondHighestSalary