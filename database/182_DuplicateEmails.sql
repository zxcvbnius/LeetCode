# Write your MySQL query statement below
select Email FROM Person group by Email HAVING count(*) > 1
