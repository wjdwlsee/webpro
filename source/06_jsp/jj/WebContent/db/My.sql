Drop table my;
CREATE TABLE my (
  ID      VARCHAR2(50) PRIMARY KEY,
  PW      VARCHAR2(50) NOT NULL,
  NAME    VARCHAR2(50) NOT NULL,
  age     VARCHAR2(3),
  favoritefood   VARCHAR2(50),
  favoritestyle  VARCHAR2(50),
  favoritecolor   VARCHAR2(50),
  favoritespot  VARCHAR2(50),
  mbti VARCHAR2(10),
  BIRTH   DATE,
  GENDER  VARCHAR2(1)  CHECK(GENDER='m' OR GENDER='f'),
  address   VARCHAR2(50)
);
SELECT * FROM my;
commit;
SELECT COUNT(*) FROM MY WHERE ID='aaa';