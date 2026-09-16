-- # Write your MySQL query statement below
-- select l1.num from Logs l1 where 1=
-- (select l2.id-l1.id from Logs l2 where 
-- l2.num=l1.num);



SELECT DISTINCT l1.num as 'ConsecutiveNums'
FROM Logs l1
JOIN Logs l2 ON l2.id = l1.id + 1
JOIN Logs l3 ON l3.id = l1.id + 2
WHERE l1.num = l2.num
  AND l2.num = l3.num;