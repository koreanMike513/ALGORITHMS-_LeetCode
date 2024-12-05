# Write your MySQL query statement below


SELECT DISTINCT
    p.product_id,
    IFNULL(s2.new_price, 10) AS price
FROM 
    Products p
LEFT JOIN (
    SELECT 
        product_id,
        new_price,
        change_date,
        RANK() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS date_rank
    FROM 
        Products
    WHERE
        change_date <= DATE('2019-08-16')
) AS s2 ON p.product_id = s2.product_id AND s2.date_rank = 1;
