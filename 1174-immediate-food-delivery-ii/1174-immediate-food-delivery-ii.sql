# Write your MySQL query statement below
SELECT 
    ROUND(AVG(d.order_state) * 100, 2) AS immediate_percentage
FROM (
    SELECT
        IF(MIN(order_date) = MIN(customer_pref_delivery_date), 1, 0) AS order_state
    FROM 
        Delivery
    GROUP BY
        customer_id
) AS d
;

