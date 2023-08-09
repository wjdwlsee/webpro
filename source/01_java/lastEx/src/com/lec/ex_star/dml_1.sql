-- DML
select sName from star;
INSERT INTO SCORE
    VALUES(SCORE_no.nextval,'È«±æµ¿',(SELECT JNO FROM JOB WHERE JNAME='¹è¿ì'),99,99,100);
SELECT * FROM SCORE;
COMMIT;  