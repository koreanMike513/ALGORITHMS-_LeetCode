# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d
  ON e.departmentId = d.id
WHERE 
    (e.id, e.salary)
IN (
    SELECT
        sub_query.id,
        sub_query.salary
    FROM (
        SELECT
            *,
            DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS salary_rank
    FROM Employee
    ) AS sub_query
    WHERE sub_query.salary_rank <= 3
)