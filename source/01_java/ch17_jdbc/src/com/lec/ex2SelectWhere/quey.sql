-- Ex1: ����ڷκ��� �μ���ȣ �޾� �μ����� ���
SELECT * FROM DEPT WHERE DEPTNO =40;

-- Ex2.�μ�����, (���,�̸�,�޿�,����̸�) ���
SELECT * FROM DEPT WHERE DEPTNO =10;
SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ')MANAGER 
    FROM EMP W, EMP M
    WHERE w.MGR =M.EMPNO(+) AND W.DEPTNO=10;
    
--Ex3.����ڷκ��� �μ����� �޾� �μ����� ���
SELECT * FROM DEPT WHERE DNAME = upper('ACCOUNTING');


