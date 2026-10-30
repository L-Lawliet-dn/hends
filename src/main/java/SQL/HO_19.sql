CREATE TABLE customers (
                           customer_id INT PRIMARY KEY,
                           cust_name   VARCHAR(100) NOT NULL,
                           city        VARCHAR(100),
                           grade       INT,
                           salesman_id INT
);

SELECT
    c.customer_id,
    c.cust_name,
    s.salesman_id,
    s.name AS salesman_name
FROM customers AS c
         JOIN salesman AS s
              ON s.salesman_id = c.salesman_id
ORDER BY c.customer_id;

SELECT
    c.customer_id,
    c.cust_name,
    c.grade,
    s.salesman_id,
    s.name AS salesman_name
FROM customers AS c
         JOIN salesman AS s
              ON s.salesman_id = c.salesman_id
WHERE c.grade < 300
ORDER BY c.customer_id ASC;

SELECT
    c.customer_id,
    c.cust_name,
    s.salesman_id,
    s.name AS salesman_name,
    s.commission
FROM customers AS c
         JOIN salesman AS s
              ON s.salesman_id = c.salesman_id
WHERE s.commission > 0.12;

SELECT
    o.ord_no,
    o.ord_date,
    o.purch_amt,
    c.customer_id,
    c.cust_name,
    s.salesman_id,
    s.name AS salesman_name,
    s.commission
FROM orders AS o
         JOIN customers AS c
              ON c.customer_id = o.customer_id
         JOIN salesman AS s
              ON s.salesman_id = c.salesman_id
ORDER BY o.ord_no;