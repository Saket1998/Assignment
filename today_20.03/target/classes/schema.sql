create database student_db;
use student_db;

create table student(
	id int(10) NOT NULL,
	name varchar(100) NOT NULL,
	marks int(10) NOT NULL,
	primary key(id)
	);
	
insert into student(id,name,marks)values(200,'Didwania',100);