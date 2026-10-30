CREATE TABLE orders (
                        ord_no       INT PRIMARY KEY,
                        purch_amt    DECIMAL(10,2),
                        ord_date     DATE,
                        customer_id  INT,
                        salesman_id  INT
);

INSERT INTO orders (ord_no, purch_amt, ord_date, customer_id, salesman_id) VALUES
                                                                               (70001, 150.50,  '2026-01-05', 3005, 5002),
                                                                               (70002, 270.65,  '2026-01-10', 3001, 5005),
                                                                               (70003, 65.26,   '2026-01-15', 3002, 5001),
                                                                               (70004, 110.50,  '2026-02-01', 3009, 5003),
                                                                               (70005, 2400.60, '2026-02-10', 3007, 5001),
                                                                               (70006, 5760.00, '2026-02-15', 3002, 5001),
                                                                               (70007, 1983.43, '2026-03-01', 3004, 5006),
                                                                               (70008, 2480.40, '2026-03-05', 3008, 5002),
                                                                               (70009, 250.45,  '2026-03-10', 3009, 5003),
                                                                               (70010, 75.29,   '2026-03-15', 3003, 5007),
                                                                               (70011, 3045.60, '2026-04-01', 3002, 5001),
                                                                               (70012, 1800.00, '2026-04-10', 3010, 5005);

SELECT DISTINCT salesman_id
FROM orders;

SELECT ord_no
FROM orders
ORDER BY ord_date ASC;

SELECT ord_no
FROM orders
ORDER BY purch_amt DESC;

SELECT *
FROM orders
WHERE purch_amt < 500;

SELECT *
FROM orders
WHERE purch_amt BETWEEN 1000 AND 2000;