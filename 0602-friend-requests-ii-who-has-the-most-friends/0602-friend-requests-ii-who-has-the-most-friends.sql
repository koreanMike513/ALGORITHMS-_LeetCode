# Write your MySQL query statement below

SELECT requester_id as id,
       (SELECT COUNT(*) FROM RequestAccepted
            WHERE id = requester_id OR id = accepter_id) AS num
FROM RequestAccepted
GROUP BY requester_id

UNION ALL

SELECT accepter_id as id,
       (SELECT COUNT(*) FROM RequestAccepted
            WHERE id = requester_id OR id = accepter_id) AS num
FROM RequestAccepted
GROUP BY accepter_id

ORDER BY num DESC LIMIT 1


                