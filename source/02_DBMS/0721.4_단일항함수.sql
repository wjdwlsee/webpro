--[IV]�������Լ�

--�Լ�=�������Լ� + �׷��Լ�(�����Լ�)
SELECT HIREDATE , TO_CHAR(HIREDATE, 'YYYY-MM-DD')FROM EMP;--������ ����(INPUT 1��)->(OUTPUT 1��)

SELECT SUM(SAL), AVG(SAL)FROM EMP; --�׷��Լ�(INPUT N�� -> OUTPUT 1��)
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;

--�������Լ� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ� ,����ȯ�Լ�, MVL, ETC..��

    --DUAL ���̺�:����Ŭ���� ������ 1��1��¥�� DUMMY TABLE
    SELECT *FROM DUAL;
--1. ���ڰ��õ� �Լ�

SELECT FLOOR(34.5678) FROM DUAL;--�Ҽ������� ����(����)
SELECT FLOOR(34.5678*100)/100 FROM DUAL; --�Ҽ��� �ι�° �ڸ����� ����(����)
SELECT TRUNC(34.5978,2)FROM DUAL;        --�Ҽ��� �ι�° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;         --�Ҽ������� ���� (����)
SELECT TRUNC(34.5678,-1)FROM DUAL;        --���� �ڸ����� ����
  --ex.EMP ���̺��� �̸�,�޿�(���� �ڸ� ����)
 SELECT ENAME, TRUNC(SAL, -2), SAL FROM EMP;

SELECT ROUND(34.5678) FROM DUAL; --�Ҽ����ּ� �ݿø�(35)
SELECT ROUND(34.5678, 2)FROM DUAL; --�Ҽ��� �ι��� �ڿ��� �ݿø�(34.57)
SELECT ROUND(34.5678, -1)FROM DUAL; --�����ڸ� ���� �ݿø�(30)

SELECT CELL(34.5678) FROM DUAL; --�Ҽ����ּ� �ø�(35)
SELECT CELL(34.5678*100)/100 FROM DUAL; --�Ҽ��� �ι�°�ڸ����� �ø�(34.57)
SELECT MOD (9, 2) FROM DUAL; --9%2
--ex. Ȧ���⵵�� �Ի��� ����� ��� ���� ���
    SELECT '10'/2 FROM DUAL;
    SELECT*FROM EMP WHERE MOD (TO_CHAR(HIREDATE, 'RR'), 2)=1;
--2.���ڰ����Լ�
-- (1)��ҹ��ڰ���
    SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL;  --�������Ƿ� ������ ù���ڸ� �빮�ڷ�
    SELECT INITCAP('welcome to oracle') FROM DUAL;  
    SELECT UPPER('ABCabc')FROM DUAL;
    SELECT LOPER('ABCabc')FROM DUAL; --�ҹ��ڷ�
    SELECT* FROM EMP WHERE UPPER(ENAME) ='SCOTT';
    SELECT* FROM EMP WHERE INICAP(ENAME) ='SCOTT';
    SELECT* FROM EMP WHERE LOPER(ENAME) ='SCOTT';
    
 --(2) ���ڿ���(CONCAT�Լ�, ||������)
 SELECT 'AB'||'CD'||'EF' ||'GH' FROM DUAL;
 SELECT CONCAT('AB','CD'),CONCAT('EF' , 'GH') FROM DUAL;
 
 --ex. SMITH�� MANAGER�̴�
 SELECT ENAME || '��' ||JOB|| '��' MESSAGE FROM; 
 
 --(3) SUBSTR(STR, ������ġ, ���ڰ���) : STR�� ������ġ���� ���ڰ��� ��ŭ ����
                                    --������ġ�� 1���� �밡, ��ġ�� �����̸� ������ �ڸ����� ����
    --SUBSTRB(STR, ���۹���Ʈ��ġ, �����ҹ���Ʈ ��) :STR �� ���۹���Ʈ ��ġ���� ����Ʈ���� ����
 SELECT SUBSTR('ORACLE' , 3, 2) FROM DUAL; --3��° ���ں��� 2���� ����
 SELECT SUBSTRB('ORACLE' , 3, 2) FROM DUAL;--3��° ����Ʈ ���� 2����Ʈ ����
 SELECT SUBSTR('�����ͺ��̽�' ,4,3) FROM DUAL; --4��° ���ں��� 3���� ����
 SELECT SUBSTRB('�����ͺ��̽�',4,3)FROM DUAL; --4��° ����Ʈ���� 3����Ʈ ����
 --O R A C L E
 --1 2 3 4 5 6 (��ġ)
 --6-5-4-3-2-1 (��ġ)
 SELECT SUBSTR '010-9999-1234',-4,4) FROM DUAL; --4��° ���ں��� 4���� ����
 SELECT SUBSTR('ORACLE', -1, 1) FROM DUAL;
 
 SELECT SUBSTR(123,-1,1)FROM DUAL; -- ���ڵ����� ����
 --EX. 9���� �Ի��� ����� ��� ����
SELECT *REOM EMP EHWRW SUBSTR(HIREDATE);
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR (HIREDATE,'DO') ='109';

--(4) LENGTH(STR): STR�� ���ڼ�
    --LENGTHB(STR): STRDML ����Ʈ ��
    SELECT LENGTH('ABC') FROM DUAL;
    SELECT LENGTHB('ABC') FROM DUAL;
    SELECT LENGTH('����Ŭ')FROM DUAL;
    SELECT LENGTHB('����Ŭ')FROM DUAL;
    
--(5) LPAD(STR,�ڸ���,ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�﹮���� ���
    --LPAD(STR, �ڸ���):STR���ڸ�����ŭ Ȯ�� ���� ���ڸ���' '����� (�����̽�)
    --RPAD(STR, �ڸ���,ä�﹮��) :STR�� �ڸ��� ��ŭ Ȯ���Ͽ� ������ ���ڸ��� ä�﹮�ڷ� ���
    --RPAD(STR, �ڸ���) :STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ���' '�� ���
SELECT LPAD('ORACLE',10,'#') FROM DUAL;
SELECT RPAD('ORACLE',10,'*')FROM DUAL;
SELECT ENAME, LENGTH(ENAME), SAL FROM EMP; --ENAME10���ڱ��� ,SAL�� 5�ڸ����� ����
DESC EMP;
SELECT RPAD(ENAME, 11, '-')ENAME ,LPAD(SAL,6,'*') SAL FROM EMP;
SELECT LPAD(ENAME,11,'-') ENAME, RPAD(SAL , 6,'*') SAL FROM EMP;
SELECT LPAD(ENAME, 11) ENAME, RPAD(SAL,6) SAL FROM EMP;
    --ex. ��� �̸� (7369 ��� S****, 7521 W***,..) SUBSTR,LENGTH ,RPAD
    SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')ENAME
    FROM EMP;
    
    --eX2. ���, �̸�,��å(9�ڸ�Ȯ��), �Ի���(7396 smith ____****k 80/12/**) : LPAD, SUBSTR, CONCAT, ||,
    
    


    







