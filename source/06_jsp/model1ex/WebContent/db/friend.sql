DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_NO_SEQ;
CREATE SEQUENCE FRIEND_NO_SEQ START WITH 1 NOCACHE NOCYCLE;
CREATE TABLE FRIEND(
    NO   NUMBER(10) PRIMARY KEY,
    NAME VARCHAR2(20),
    TEL  VARCHAR2(20) 
    );
INSERT INTO FRIEND (NO,NAME,TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL,'김미소','010-6666-6666');
SELECT * FROM FRIEND ORDER BY NO;
SELECT FRIEND_NO_SEQ.CURRVAL FROM FRIEND; 
commit;