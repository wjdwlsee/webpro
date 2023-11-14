--book query
--1. 책목록(startRow부터 endRow)
--ID=mainList (신작순서대로 BOOK리스트)
SELECT * FROM BOOK ORDER BY BRDATE;
--ID=bookLisT(책이름 ㄱㄴ 순서대로 TOP-N구문)
SELECT * FROM 
    (SELECT ROWNUM RN , A.* FROM 
        (SELECT * FROM BOOK ORDER BY bTITLE)A)
    WHERE RN BETWEEN 1 AND 3;
--ID=totCntBook
SELECT COUNT(*) FROM BOOK;
--ID=getDetailBook
SELECT * FROM BOOK WHERE BNUM=1;
--ID=registerBook(BIMG를 둘다 입력할 수도 있지만 하나만 입력할 수도 입력안할수도 있음)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1,bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '아주 희미한 빛으로도','최은영',SYSDATE, 'noImg.png','noImg.png','문학');
--ID=modifyBook
UPDATE BOOK SET 
    bTITLE = '내게 무해한 사랑',
    bWRITER = '최은영',
    bRDATE = SYSDATE,
    bIMG1 = 'noImg.png',
    bIMG2 = 'noImg.png',
    bINFO = '소설'
    WHERE BNUM = 5;
--MAPPER query
--ID = idConfirm
SELECT COUNT(*) FROM MEMBER WHERE mID = 'aaa';
SELECT * FROM  MEMBER WHERE MID ='aaa';
--ID=joinMember
INSERT INTO MEMBER VALUES ('bbb','1','김길동','kim@naver.com','12345','서울');
--id =getDetailMember
SELECT * FROM  MEMBER WHERE MID ='aaa';
--ID = modifyMember
UPDATE MEMBER SET 
    MPW ='1',
    mNAME='홍길순',
    mMAIL = 'hong@hong.com',
    mPOST = '12345',
    MADDRESS = '서대문구'
    WHERE MID = 'aaa';
select * from member;

    



    

