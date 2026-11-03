-- 1. Find all orders issued against the salesman who works for customer ID 3007
SELECT *
FROM orders
WHERE salesman_id = (
    SELECT salesman_id
    FROM customers
    WHERE customer_id = 3007
);

-- 2. Find all orders attributed to a salesman in New York
SELECT *
FROM orders
WHERE salesman_id IN (
    SELECT salesman_id
    FROM salesman
    WHERE city = 'New York'
);

-- 3. Count customers whose grade is above the average grade of New York customers
SELECT COUNT(*) AS customer_count
FROM customers
WHERE grade > (
    SELECT AVG(grade)
    FROM customers
    WHERE city = 'New York'
);

-- 4. Extract orders made through salesmen who earn the maximum commission
SELECT *
FROM orders
WHERE salesman_id IN (
    SELECT salesman_id
    FROM salesman
    WHERE commission = (
        SELECT MAX(commission)
        FROM salesman
    )
);