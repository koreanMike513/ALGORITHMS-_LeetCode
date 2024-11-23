# Write your MySQL query statement below

SELECT
    ROUND(AVG(IF(a2.event_date IS NOT NULL, 1, 0)), 2) AS fraction
FROM 
    (SELECT
        player_id,
        MIN(event_date) AS first_date
    FROM 
        Activity
    GROUP BY 
        player_id
) a1
LEFT JOIN 
    Activity a2
ON
    a1.player_id = a2.player_id
AND  
    DATEDIFF(a1.first_date, a2.event_date) = -1
;