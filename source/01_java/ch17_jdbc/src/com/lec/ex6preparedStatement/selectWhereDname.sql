-- 부서명을 입력받아 해당 부서 사원을 출력(사번, 이름, 상사이름,급여, 급여등급,상사가 없는 사람은 상사명에 -ceo로
SELECT W.EMPNO , W.ENAME , NVL(M.ENAME,'-CEO-') MANAGER , W.SAL ,GRADE
    FROM EMP W, EMP M , SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO(+) 
        AND W.SAL BETWEEN LOSAL AND HISAL 
        AND W.DEPTNO =D.DEPTNO
        AND DNAME = UPPER('ACCOUNTING')
        ORDER BY SAL;