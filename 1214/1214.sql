-- 1.
select ename �̸�,
       DNO   �μ���ȣ
from EMPLOYEE
where eno = 7788;

-- 2.
select ename    �̸�,
       hiredate �Ի���
from employee
where to_char(hiredate, 'YYYYMMDD') like '__81%';


-- 3,
select ename  �̸�,
       job    ������,
       salary �޿�
from EMPLOYEE
where salary not in (1600, 950, 1300)
AND job in ('CLERK', 'SALESMAN');


-- 4.
select trunc(months_between(sysdate, '1995/10/23'))
from dual;

-- 5.
select dno �μ���ȣ, round(avg(SALARY), 2) ��տ���
from EMPLOYEE
group by dno
having avg(SALARY) >= 2000
order by dno ASC;

-- 6.
select eno   �����ȣ,
       ename �̸�
from EMPLOYEE
where salary >= (select avg(salary) from EMPLOYEE)
order by salary ASC;

-- 7.
select e.ename �̸�,
       d.dno   �μ���ȣ,
       d.dname �μ���,
       d.loc   �μ���ġ
from EMPLOYEE e
         join
     DEPARTMENT d
     on
         e.dno = d.dno
where job = 'MANAGER'
order by ename DESC;

-- 8.
create view v_join
as
select ename �̸�,
       job   ��å,
       dname �μ���,
       loc   �μ���ġ
from EMPLOYEE e
         join
     DEPARTMENT d
     on
         e.dno = d.dno
where e.dno <> 20
  AND salary in (select MIN(salary)
                 from EMPLOYEE
                 group by dno
                 having MIN(salary) >= 900);
select *
from v_join;

-- 9.
create table emp50
as
select *
from EMPLOYEE;

create table dept50
as
select *
from DEPARTMENT;

alter table emp50
    ADD constraint pk_emp50_eno primary key (eno);
alter table dept50
    ADD constraint pk_dept50_dno primary key (dno);
alter table emp50
    add constraint fk_emp50_dno foreign key (dno) references dept50 (dno);
commit;

-- 10.
-- -- 1.
insert into emp50
values (8181, 'ȫ�浿', '�繫��', 7788, sysdate, 1000, 100, 20);
commit;
-- -- 2.
update emp50
set commission = 50
where COMMISSION is null
   or COMMISSION = 0;
commit;
-- -- 3.
update dept50
set dname = '���',
    loc   = '����'
where dno = 40;
commit;
-- -- 4.
delete emp50
where job = 'MANAGER';
commit;


---------------------------------------------------------
select *
from emp50;
select *
from dept50;

