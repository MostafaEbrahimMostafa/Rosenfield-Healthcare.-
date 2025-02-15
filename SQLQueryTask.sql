SELECT 
    c.cust_name AS "Customer Name",
    c.city AS "Customer City",
    s.name AS "Salesman Name",
    s.city AS "Salesman City",
    s.commission AS "Commission"
FROM Customer c
INNER JOIN Salesman s 
    ON c.salesman_id = s.salesman_id
WHERE c.city <> s.city
    AND s.commission > 0.12;
