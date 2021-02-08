select * from employees where employee_id < 110;

create table employees2 as select * from employees;

update employees2 set salary = salary + 2500 where employee_id = 777;

DESC employees2;

SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES2' ;

select * from  employees2 e INNER JOIN departments d USING ( department_id );

select * from employees2 order by employee_id desc;

DESC jobs;

SELECT MAX(employee_id) from employees2;

CREATE SEQUENCE emp2_seq START WITH 208 MINVALUE 208 NOCACHE;

drop sequence emp2_seq;

SELECT * FROM user_sequences;

select sysdate from dual;

select emp2_seq.nextval from dual;

select emp2_seq.currval from dual;

select manager_id, job_id from employees2;

select DISTINCT manager_id from employees2 where manager_id > 0 order by manager_id;

select DISTINCT job_id from employees2 order by job_id;

select DISTINCT department_id from employees2 where department_id > 0 order by department_id;

/*
    OFFSET : [(pageNum - 1) * amount] ROWS FETCH FIRST 한페이지에 나올 행의 개수 ROWS ONLY;
    오라클 12C버전부터 사용 가능
*/
SELECT * FROM employees ORDER BY employee_id
OFFSET 20 ROWS FETCH FIRST 10 ROWS ONLY;


/*
    ROWNUM이 n보다 작은 조건은 조회할 수 있지만,
    2이상의 숫자보다 큰 조건은 조회할 수 없다.
    (조건에 맞지 않는 행을 잘라내면 다음행이 다시 rownum 1 이 된다.
    
    먼저 서브쿼리를 이용해 조회하려는 최대 rownum보다 작은것들을 추려낸 후 
    서브쿼리의 바깥에서 최소값으로 한번 더 추려내야 한다.
*/
SELECT 
    rn, employee_id, first_name, last_name
FROM
    (SELECT 
        ROWNUM rn, employee_id, first_name, last_name 
    FROM 
        employees 
    WHERE 
        ROWNUM <= 20) -- 1페이지 - 10 / 2페이지 - 20 / 3페이지 30 ... (pageNum * amount)
WHERE 
    rn > 10; -- 1페이지 - 0 / 2페이지 - 10 / 3페이지 - 20 ... (pageNum - 1) * amount

