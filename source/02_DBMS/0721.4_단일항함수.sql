--[IV]단일함함수

--함수=단일행함수 + 그룹함수(집계함수)
SELECT HIREDATE , TO_CHAR(HIREDATE, 'YYYY-MM-DD')FROM EMP;--단일행 적용(INPUT 1행)->(OUTPUT 1행)

SELECT SUM(SAL), AVG(SAL)FROM EMP; --그룹함수(INPUT N행 -> OUTPUT 1행)
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;

--단일행함수 : 숫자관련함수, 문자관련함수, 날짜관련함수 ,형변환함수, MVL, ETC..★

    --DUAL 테이블:오라클에서 제공한 1행1열짜리 DUMMY TABLE
    SELECT *FROM DUAL;
--1. 숫자관련된 함수

SELECT FLOOR(34.5678) FROM DUAL;--소수점에서 내림(버림)
SELECT FLOOR(34.5678*100)/100 FROM DUAL; --소수점 두번째 자리에서 내림(버림)
SELECT TRUNC(34.5978,2)FROM DUAL;        --소수점 두번째 자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL;         --소수점에서 내림 (버림)
SELECT TRUNC(34.5678,-1)FROM DUAL;        --일의 자리에서 내림
  --ex.EMP 데이블에서 이름,급여(십의 자리 내림)
 SELECT ENAME, TRUNC(SAL, -2), SAL FROM EMP;

SELECT ROUND(34.5678) FROM DUAL; --소수점애서 반올림(35)
SELECT ROUND(34.5678, 2)FROM DUAL; --소수점 두번쨰 자에서 반올림(34.57)
SELECT ROUND(34.5678, -1)FROM DUAL; --일의자리 에서 반올림(30)

SELECT CELL(34.5678) FROM DUAL; --소수점애서 올림(35)
SELECT CELL(34.5678*100)/100 FROM DUAL; --소수점 두번째자리에서 올림(34.57)
SELECT MOD (9, 2) FROM DUAL; --9%2
--ex. 홀수년도에 입사한 사원의 모든 정보 출력
    SELECT '10'/2 FROM DUAL;
    SELECT*FROM EMP WHERE MOD (TO_CHAR(HIREDATE, 'RR'), 2)=1;
--2.문자관련함수
-- (1)대소문자관련
    SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL;  --어절단의로 나눠서 첫문자만 대문자로
    SELECT INITCAP('welcome to oracle') FROM DUAL;  
    SELECT UPPER('ABCabc')FROM DUAL;
    SELECT LOPER('ABCabc')FROM DUAL; --소문자로
    SELECT* FROM EMP WHERE UPPER(ENAME) ='SCOTT';
    SELECT* FROM EMP WHERE INICAP(ENAME) ='SCOTT';
    SELECT* FROM EMP WHERE LOPER(ENAME) ='SCOTT';
    
 --(2) 문자연결(CONCAT함수, ||연산자)
 SELECT 'AB'||'CD'||'EF' ||'GH' FROM DUAL;
 SELECT CONCAT('AB','CD'),CONCAT('EF' , 'GH') FROM DUAL;
 
 --ex. SMITH는 MANAGER이다
 SELECT ENAME || '는' ||JOB|| '다' MESSAGE FROM; 
 
 --(3) SUBSTR(STR, 시작위치, 문자갯수) : STR을 시작위치부터 문자갯수 만큼 추출
                                    --시작위치가 1부터 싲가, 위치가 음수이면 끝부터 자리수를 센다
    --SUBSTRB(STR, 시작바이트위치, 추출할바이트 수) :STR 을 시작바이트 위치부터 바이트수만 추출
 SELECT SUBSTR('ORACLE' , 3, 2) FROM DUAL; --3번째 글자부터 2글자 추출
 SELECT SUBSTRB('ORACLE' , 3, 2) FROM DUAL;--3번째 바이트 부터 2바이트 추출
 SELECT SUBSTR('데이터베이스' ,4,3) FROM DUAL; --4번째 글자부터 3글자 추출
 SELECT SUBSTRB('데이터베이스',4,3)FROM DUAL; --4번째 바이트부터 3바이트 추출
 --O R A C L E
 --1 2 3 4 5 6 (위치)
 --6-5-4-3-2-1 (위치)
 SELECT SUBSTR '010-9999-1234',-4,4) FROM DUAL; --4번째 글자부터 4글자 추출
 SELECT SUBSTR('ORACLE', -1, 1) FROM DUAL;
 
 SELECT SUBSTR(123,-1,1)FROM DUAL; -- 숫자데이터 적용
 --EX. 9월에 입사한 사원의 모든 정보
SELECT *REOM EMP EHWRW SUBSTR(HIREDATE);
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR (HIREDATE,'DO') ='109';

--(4) LENGTH(STR): STR의 글자수
    --LENGTHB(STR): STRDML 바이트 수
    SELECT LENGTH('ABC') FROM DUAL;
    SELECT LENGTHB('ABC') FROM DUAL;
    SELECT LENGTH('오라클')FROM DUAL;
    SELECT LENGTHB('오라클')FROM DUAL;
    
--(5) LPAD(STR,자리수,채울문자) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울문으로 출력
    --LPAD(STR, 자리수):STR을자리수만큼 확보 왼쪽 빈자리에' '로출력 (스페이스)
    --RPAD(STR, 자리수,채울문자) :STR을 자리수 만큼 확보하여 오른쪽 빈자리에 채울문자로 출력
    --RPAD(STR, 자리수) :STR을 자리수만큼 확보하고 오른쪽 빈자리에' '로 출력
SELECT LPAD('ORACLE',10,'#') FROM DUAL;
SELECT RPAD('ORACLE',10,'*')FROM DUAL;
SELECT ENAME, LENGTH(ENAME), SAL FROM EMP; --ENAME10글자까지 ,SAL은 5자리까지 가능
DESC EMP;
SELECT RPAD(ENAME, 11, '-')ENAME ,LPAD(SAL,6,'*') SAL FROM EMP;
SELECT LPAD(ENAME,11,'-') ENAME, RPAD(SAL , 6,'*') SAL FROM EMP;
SELECT LPAD(ENAME, 11) ENAME, RPAD(SAL,6) SAL FROM EMP;
    --ex. 사번 이름 (7369 출력 S****, 7521 W***,..) SUBSTR,LENGTH ,RPAD
    SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')ENAME
    FROM EMP;
    
    --eX2. 사번, 이름,직책(9자리확보), 입사일(7396 smith ____****k 80/12/**) : LPAD, SUBSTR, CONCAT, ||,
    
    


    







