REM   Script: Session 02- Activity 10
REM   Session 02- Activity 10

Select * from customers;

select * from salesman;

select * from orders;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE SALESMAN_CITY='New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commisission=( SELECT MAX(commisission) FROM salesman));

