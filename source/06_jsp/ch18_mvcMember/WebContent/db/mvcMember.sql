--테이블 제거
DROP TABLE MVC_MEMBER;
--테이블생성
CREATE TABLE MVC_MEMBER(
    mID    VARCHAR2(30)   PRIMARY KEY,
    mPW    VARCHAR2(30)   NOT NULL,
    mNAME  VARCHAR2(30)   NOT NULL,
    mEMAIL VARCHAR2(30),
    mPHOTO VARCHAR2(30)   NOT NULL,
    mBIRTH  DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);
--더미데이터
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('son','1','손흥민','son@naver.com','son.jpg','1992/07/08','강원도');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
COMMIT;
--DAO에 들어갈 쿼리
--(1)회원mid중복체크
SELECT COUNT(*) FROM MVC_MEMBER WHERE MID='go';  
--(2)회원가입
INSERT INTO MVC_MEMBER (MID,MPW,MNAME,MEMAIL,MPHOTO,MBIRTH,MADDRESS)
    VALUES ('JENIE','1','제니','JENIE@naver.com','JENIE.jpg','1982/11/05','서울시');
--(3)로그인
SELECT * FROM MVC_MEMBER WHERE MID='JENIE' AND MPW ='1';
--(4)mid로 멤버 dto가져오기 (로그인 성공시 session에 setAttibute하기 위함)
SELECT * FROM MVC_MEMBER WHERE MID='JENIE';
--(5)회원정보수정 (특정mid의 정보 수정)
UPDATE MVC_MEMBER 
    SET MPW = '1',
        MNAME = '제니',
        MEMAIL ='JENIE@naver.com',
        MPHOTO ='JENIE.jpg',
        MBIRTH = '1982/11/05',
        MADDRESS = '뉴욕시' 
    WHERE MID = 'JENIE';
--(6)회원리스트(top-n구문)
SELECT * FROM (SELECT ROWNUM RN , A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC)A)WHERE RN BETWEEN 1 AND 3;
--(7)회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
--(8)회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID ='JENIE';
ROLLBACK;















