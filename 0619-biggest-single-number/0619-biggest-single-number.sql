# Write your MySQL query statement below
SELECT
    MAX(m.num) AS num
FROM (
    SELECT 
        num
    FROM
        MyNumbers
    GROUP BY
        num
    HAVING
        COUNT(num) = 1
    ) AS m
;
