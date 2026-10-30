SELECT
    SUM(purch_amt) AS total_purchase_amount,
    AVG(purch_amt) AS average_purchase_amount,
    MAX(purch_amt) AS maximum_purchase_amount,
    MIN(purch_amt) AS minimum_purchase_amount,
    COUNT(DISTINCT salesman_id) AS number_of_salesmen
FROM orders;