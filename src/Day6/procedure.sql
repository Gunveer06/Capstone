use capstone;

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(10) CHECK (department IN ('CS', 'IT', 'ENTC')),
    marks INT
);

INSERT INTO student (student_id, name, department, marks) VALUES
(1, 'Amit', 'CS', 85),
(2, 'Sneha', 'IT', 78),
(3, 'Rahul', 'ENTC', 82),
(4, 'Priya', 'CS', 90),
(5, 'Karan', 'IT', 76),
(6, 'Neha', 'ENTC', 88),
(7, 'Vikas', 'CS', 91),
(8, 'Pooja', 'IT', 73),
(9, 'Arjun', 'ENTC', 80),
(10, 'Meera', 'CS', 87);

select * from student where department='cs';

DELIMITER $$

CREATE PROCEDURE GetStudentsByDepartment(IN dept VARCHAR(10))
BEGIN
    SELECT * 
    FROM student
    WHERE department = dept;
END $$

DELIMITER ;

CALL GetStudentsByDepartment('CS');


DELIMITER $$

create procedure showstudent()
begin
	select * 
    from student;
end $$

DELIMITER ;

CALL showstudent;



-- find highest marks

DELIMITER $$

create procedure highestmarks()
begin
	select *
    from student
    WHERE marks = (SELECT MAX(marks) FROM student);
end $$

DELIMITER ;

call highestmarks;
    


-- find average marks 
DELIMITER $$

create procedure averagemarks()
begin
	select avg(marks)
    from student;
end $$

DELIMITER ;

call averagemarks;


-- show students between 70-90 marks


DELIMITER $$

create procedure betweenmarks()
begin 
	select * 
    from student 
    where marks between 70 and 90;
end $$

DELIMITER ;

call betweenmarks;



CREATE TABLE main (
    id INT PRIMARY KEY,
    salary INT
);

CREATE TABLE backup (
    id INT,
    salary INT
);

DELIMITER $$

CREATE TRIGGER t1
BEFORE DELETE ON main
FOR EACH ROW
BEGIN
    INSERT INTO backup (id, salary)
    VALUES (OLD.id, OLD.salary);
END $$

DELIMITER ;

INSERT INTO main VALUES (1, 50000), (2, 60000);

DELETE FROM main WHERE id = 1;

SELECT * FROM backup;


