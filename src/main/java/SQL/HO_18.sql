SELECT
    customer_id,
    MAX(purch_amt) AS highest_purchase_amount
FROM orders
GROUP BY customer_id;

SELECT
    salesman_id,
    MAX(purch_amt) AS highest_purchase_amount
FROM orders
WHERE ord_date = '2012-08-17'
GROUP BY salesman_id;

SELECT
    o.customer_id,
    o.purch_amt AS highest_purchase_amount,
    o.ord_date
FROM orders AS o
WHERE o.purch_amt IN (2030, 3450, 5760, 6000)
  AND o.purch_amt = (
    SELECT MAX(o2.purch_amt)
    FROM orders AS o2
    WHERE o2.customer_id = o.customer_id
);