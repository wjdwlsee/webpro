--Dept.xml의 id(함수명) = deptList (Dept.java X)
SELECT * FROM DEPT;

--Emp.xml의 id=empList
SELECT * FROM EMP WHERE DEPTNO = 40;
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%';
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'M'||'%';
SELECT * FROM EMP WHERE 1=1 AND ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'M'||'%' AND DEPTNO = 10;




