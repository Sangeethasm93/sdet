REM   Script: Session 02- Activity 01
REM   Session 02- Activity 01

select SUM(purchase_amount) AS "Total Purchase Amount" from orders;

select AVG(purchase_amount) AS "Average Purchase Amount" from orders;

select MAX(purchase_amount) AS "Maximum Purchase Amount" from orders;

select MIN(purchase_amount) AS "Minumum Purchase Amount" from orders;

select COUNT(distinct salesman_id) AS "Number of Salesman" from orders;

