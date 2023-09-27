Drop table my;
CREATE TABLE my (
  ID      VARCHAR2(50) PRIMARY KEY,
  PW      VARCHAR2(50) NOT NULL,
  NAME    VARCHAR2(50) NOT NULL,
  age     NUMBER(3),
  favoritefood   VARCHAR2(50),
  favoritecolor   VARCHAR2(50),
  favoritespot  VARCHAR2(50),
  mbti VARCHAR2(10),
  BIRTH   DATE,
  GENDER  VARCHAR2(10) 
);
SELECT * FROM my;
commit;
SELECT COUNT(*) FROM MY WHERE ID='aaa';
INSERT INTO MY (ID,PW, NAME, AGE,favoritefood, favoritecolor,favoritespot,mbti,BIRTH,GENDER)
    VALUES ('aJ','111','진',25,'된장찌개','BLUE','바다','INFP','1995-12-12','F');