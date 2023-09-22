--drop%create table
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
CREATE TABLE BOOK(
    bID NUMBER(7) PRIMARY KEY,
    BTITLE VARCHAR2(100) NOT NULL,
    BPRICE NUMBER(6)     NOT NULL,
    BIMAGE1 VARCHAR2(100) NOT NULL, --책대표이미지
    BIMAGE2 VARCHAR2(100) NOT NULL, --책 부가 이미지
    BCONTENT VARCHAR2(4000), --책설명 
    BDISCOUNT NUMBER(3) NOT NULL,
    BRDATE DATE DEFAULT SYSDATE NOT NULL
);
CREATE SEQUENCE BOOK_SEQ MAXVALUE 9999999 NOCACHE NOCYCLE;
SELECT * FROM BOOK;
INSERT INTO BOOK (BID,BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES (BOOK_SEQ.NEXTVAL,'이것이 자바다', 25000,'noimg.png','NOTING.JPG','베스트셀러',10);
INSERT INTO BOOK (BID,BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES (BOOK_SEQ.NEXTVAL,'JSP웹 프로그래밍', 30000,'noimg.png','NOTING.JPG','베스트셀러',10);
INSERT INTO BOOK (BID,BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES (BOOK_SEQ.NEXTVAL,'SPRING', 28000,'noimg.png','NOTING.JPG','베스트셀러',10);


-- 책등록


-- 도서(BOOK)테이블 dummy data  - 15개
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '쳇GPT 혁명',16000,'100.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '주린이가 가장 알고 싶은 최대질문Top77',20000,'101.jpg','noImg.png','태영호 증언',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '공정하다는 착각',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '부의 대이동',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '컨버전스 2030',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내면소통',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '꽤 괜찮은 해피엔딩',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '결국 무엇이든 해내는 사람',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '마지막 몰입',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'SQL',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '세이노의 가르침',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '기후로 다시 읽는 세계사',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'ADSP 데이터분석 준전문가',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
    
--DAO 들어갈 QUERY
--책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '쳇GPT 혁명',16000,'100.jpg','noImg.png','좋아',10);   
--책목록(PAGING 없이)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
--책목록(TOP-N구문)
SELECT ROWNUM RN, A.* 
    FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A ;--TOP-N구문의 INLINE VIEW에 들어갈 QUERY
    
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
    FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A )
    WHERE RN BETWEEN 7 AND 12;

--3. 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;
--4.책상세보기
SELECT * FROM BOOK WHERE BID='1'
    
    
    
    
    
    
    
    
    
    
    