-- dummy 
DROP TABLE SCORE;
DROP TABLE STAR;
Create table star (
    sNO number(5) primary key,
    sName varchar2(10) unique
);
create SEQUENCE score_no MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE SCORE (
    cNO NUMBER(5) PRIMARY KEY ,
    cNAME VARCHAR2(10) NOT NULL,
    sNO NUMBER(5) REFERENCES STAR(sNO) NOT NULL,
    KOR NUMBER(3) CHECK(KOR>=0 AND KOR<=100),
    ENG NUMBER(3) CHECK(ENG>=0 AND ENG<=100),
    MAT NUMBER(3) CHECK(MAT>=0 AND MAT<=100)
);
--1.sNAME에 들어갈
SELECT * FROM STAR;
INSERT INTO STAR VALUES( 10, '배우');
INSERT INTO STAR VALUES( 20, '가수');
INSERT INTO STAR VALUES (30, '엠씨');
SELECT * FROM SCORE;
 INSERT INTO SCORE VALUES (SCORE_NO.NEXTVAL,'정우성',10,90,80,81);
 INSERT INTO SCORE VALUES (SCORE_NO.NEXTVAL,'박세영',10,80,90,80);
 INSERT INTO SCORE VALUES (SCORE_NO.NEXTVAL,'배수지',20,20,90,90);
 COMMIT;
