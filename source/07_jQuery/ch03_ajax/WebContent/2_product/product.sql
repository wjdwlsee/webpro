DROP TABLE PRODUCT CASCADE CONSTRAINTS;

CREATE TABLE PRODUCT(
    PNO     NUMBER(3) PRIMARY KEY,
    PNAME  VARCHAR2(50) NOT NULL UNIQUE,
    PSTOCK NUMBER(3) NOT NULL
);
--더미데이터
INSERT INTO PRODUCT VALUES (1,'공책', 3);
INSERT INTO PRODUCT VALUES (2,'볼펜', 13);
INSERT INTO PRODUCT VALUES (3,'지우개', 0);
COMMIT;
--DAO에들어갈 QUERY
SELECT PSTOCK FROM PRODUCT WHERE PNAME='공책';
SELECT PSTOCK FROM PRODUCT WHERE PNAME='공';

