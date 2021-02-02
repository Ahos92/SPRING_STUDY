select * from employees2 order by department_id desc;

create table employees2 as select * from employees;

update employees2 set salary = salary + 2500 where employee_id = 777;

DESC employees2;

SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES2' ;

select * from  employees2 e INNER JOIN departments d USING ( department_id );