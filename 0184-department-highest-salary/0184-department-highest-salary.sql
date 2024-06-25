# Write your MySQL query statement below
SELECT
    t.Department,
    t.Employee,
    t.Salary
FROM (
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER(PARTITION BY d.id ORDER BY salary DESC) AS salary_rank
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
) AS t
WHERE t.salary_rank = 1;

