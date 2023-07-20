---[III] JOIN ; 2�� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ���
SELECT *FROM EMP WHERE ENAME = 'SCOTT' ;--1��
SELECT * FROM DEPT; --4��
--CROSS JOIN (FROM ���� ���̺��� 2���̻�)
SELECT *FROM EMP,DEPT WHERE ENAME = 'SCOTT' ;   
SELECT * FROM EMP,DEPT; --EMP�� 14 * DEPT�� 4=56��

-- 1. EQUI JOIN (��������) :���� �ʵ� (DEPTNO)�� ���� ��ġ�Ǵ� ���Ǹ� JOIN
SELECT * FROM EMP , DEPT 
  WHERE EMP.DEPTNO=DEPT.DEPTNO AND ENAME = 'SCOTT';
SELECT EMPNO,ENAME,JOB,MGR, HIREDATE ,SAL,COMM,DEPT.DEPTNO,DNAME,LOC 
    FROM EMP,DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
SELECT EMPNO "NO", ENAME,JOB,MGR, HIREDATE ,SAL,COMM,E.DEPTNO,DNAME,LOC  
    FROM EMP E, DEPT D --���̺��� ��Ī�� ���� ��� �����̺� ���� ����� �� ���� ��Ī�� ���
    WHERE E.DEPTNO =D.DEPTNO
    ORDER BY EMPNO;
--2.�޿��� 2000�̻��� ������ �̸�, ��å, �޿�, �μ���,�ٹ��� �μ���ȣ ���
SELECT ENAME, JOB, SAL, DNAME, LOC, E.DEPTNO
 FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO AND SAL >=2000;
 --EX.20�� �μ��� ������ �̸�,�μ���ȣ, �ٹ��� ���
SELECT ENAME,D.DEPTNO, LOC 
FROM EMP E, DEPT D
WHERE E.DEOTNI -D.DEPTNO AND E.DEPTNO=20;
 -- EX.�ٹ���(LOC)�� CHICAHO �� ����� �̸�, ����, �μ����� ���
 SELECT ENAME ,JOB,SAL,DEPTNO
 FROM EMP E, DEET D
 WHERE E.DEPRNO =D.DEPTNO AND LOC ='CHOCAGO';
 --EX.�μ���ȣ�� 10�̰ų� 20�� ����� �̸�, ���� ,��ȭ�� (�޿���)
SELECT EMP E, DEAP D
WHERE E.DEPTNO =D.DEITNO AND E.DEPTNO) IN (10,20)
OBER BY SAL;
--EX. JIB�� SHLEMAN�̰ų� MANAGER�� ����� �̸�, �޿� ��, ����=(SAL+COMM)) *�μ��� �ٹ���(����ū��) 
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ANNUAL,DNAME,LOC
FROM EMP E,DEPT D 
WHERE E.DEPTNO =D.DEPTNO AND JOB IN ('SALEMAN', 'MANAFER')
ORDER BY ANNUAL DESC;
--EX.COM�� NULL�̰� SAL�� 1200�̻��� ����� �̸� , �޿� �Ի��� �μ���ȣ, �μ��� (�μ��� ��, �޿� ū �� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL AND SAL >=1200
ORDER BY DNAME, SAL DESC;

źź ������

��- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
    SELECT ENAME, SAL FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC='NEW YORK'; 
��- ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
    SELECT ENAME ,HIREDATE FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
��- ������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
    SELECT ENAME ,DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB= 'MANAGER';
��- Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
    SELECT ENAME ,SAL, E.DEPTNO ,LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL; 

--��2.NON -EQUI JOIN
    SELECT * FROM EMP WHERE ENAME = 'SCOTT'; --SAL�� 3000
    SELECT * FROM SALGRADE; --�޿� ��� ����
    SELECT * FROM EMP , SALGRADE
    WHERE ENAME = 'SCOTT' ; --CROSS JOIN (EMP�� 1�� *SALGRADE�� 5�� = 5��)
    SELECT * FROM EMP ,SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME ='SCOTT';
--��3.

--��4.

-- PART2
--1. ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
    SELECT ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO =D.DEPTNO;
--2. NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
    SELECT ENAME , JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC ='NEW YORK';
--3. ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
    SELECT  ENAME, JOB, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;
    SELECT  ENAME, JOB, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM >0;
--4. �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
    SELECT ENAME, JOB, DNAME,LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
    SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO =D.DEPTNO ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�
--�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
    SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D WHERE E.DEPTNO =D.DEPTNO AND SAL>=2000 ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
    SELECT EMPNO, ENAME, JOB, SAL, DNAME  FROM EMP E, DEPT D WHERE E.DEPTNO =D.DEPTNO AND JOB = 'MANAGER' AND SAL>=2500 ORDER BY EMPNO ;
--ex .��� ����� ��� ,�̸�, ��å, ����� ,�޿� ,�޿����(1���,2���,...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE ||'���' GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
--źź1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME ,SAL, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE 
    WHERE E.DEPTNO= D.DEPTNO  AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;














