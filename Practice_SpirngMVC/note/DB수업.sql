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
    OFFSET : [(pageNum - 1) * amount] ROWS FETCH FIRST ���������� ���� ���� ���� ROWS ONLY;
    ����Ŭ 12C�������� ��� ����
*/
SELECT * FROM employees ORDER BY employee_id
OFFSET 20 ROWS FETCH FIRST 10 ROWS ONLY;


/*
    ROWNUM�� n���� ���� ������ ��ȸ�� �� ������,
    2�̻��� ���ں��� ū ������ ��ȸ�� �� ����.
    (���ǿ� ���� �ʴ� ���� �߶󳻸� �������� �ٽ� rownum 1 �� �ȴ�.
    
    ���� ���������� �̿��� ��ȸ�Ϸ��� �ִ� rownum���� �����͵��� �߷��� �� 
    ���������� �ٱ����� �ּҰ����� �ѹ� �� �߷����� �Ѵ�.
*/
SELECT 
    rn, employee_id, first_name, last_name
FROM
    (SELECT 
        ROWNUM rn, employee_id, first_name, last_name 
    FROM 
        employees 
    WHERE 
        ROWNUM <= 20) -- 1������ - 10 / 2������ - 20 / 3������ 30 ... (pageNum * amount)
WHERE 
    rn > 10; -- 1������ - 0 / 2������ - 10 / 3������ - 20 ... (pageNum - 1) * amount

