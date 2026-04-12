
create database capstone;
use capstone;
-- Create table
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

-- Insert 11 records
INSERT INTO employees (emp_id, name, department, salary) VALUES
(1, 'Amit Sharma', 'HR', 45000.00),
(2, 'Priya Singh', 'Finance', 55000.00),
(3, 'Rahul Verma', 'IT', 60000.00),
(4, 'Sneha Patil', 'Marketing', 48000.00),
(5, 'Vikas Gupta', 'Sales', 52000.00),
(6, 'Neha Joshi', 'IT', 62000.00),
(7, 'Arjun Mehta', 'Finance', 58000.00),
(8, 'Kavita Nair', 'HR', 47000.00),
(9, 'Rohan Das', 'Sales', 51000.00),
(10, 'Pooja Kulkarni', 'Marketing', 49000.00),
(11, 'Manish Yadav', 'IT', 63000.00);

select * from employees;

select emp_id,
name,
department,
salary,
ROW_NUMBER() OVER (PARTITION By department ORDER BY salary DESC) as row_num
from employees;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 2;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 1;

select *
FROM(
select *,
row_number() over (PARTITION BY department ORDER BY Salary desc) as rn
from employees
) t
WHERE rn = 2 or rn=1;

select
name,
salary,
LEAD(salary) OVER (ORDER BY salary) as next_salary
from employees;