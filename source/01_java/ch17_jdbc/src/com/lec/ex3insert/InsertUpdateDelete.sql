-- insert 
    --ex1    
INSERT INTO DEPT VALUES (60,'IT','SEOUL');
SELECT * FROM DEPT WHERE DEPTNO >40;
commit;
    --ex2.�μ���ȣ �ߺ�üũ
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70; -- �ߺ�üũ�ϱ� ���� SELECT 
SELECT * FROM DEPT;

-- update
    --ex1
UPDATE DEPT SET DNAME = 'CS', LOC='INCHON' WHERE DEPTNO = 70;
SELECT * FROM DEPT;
commit;

    --ex2 : �μ���ȣ ���� Ȯ���� update
SELECT * FROM DEPT WHERE DEPTNO =70;
UPDATE DEPT SET DNAME = 'CS', LOC='INCHON' WHERE DEPTNO = 70;
commit;

--delete
DELETE FROM DEPT WHERE DEPTNO = 70;
rollback;
select * from dept;

--selectwheredept
















