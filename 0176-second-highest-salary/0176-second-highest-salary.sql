# Write your MySQL query statement below
SELECT 
    MAX(t.salary) AS SecondHighestSalary
FROM (
    SELECT 
        salary,
        DENSE_RANK() 
            OVER(ORDER BY salary DESC) AS salary_rank
    FROM
        Employee
) AS t
WHERE 
    t.salary_rank = 2
