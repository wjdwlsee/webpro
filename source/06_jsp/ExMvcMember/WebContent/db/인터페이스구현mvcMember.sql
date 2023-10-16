--테이블 삭제
DROP TABLE MVC_MEMBER;
--테이블생성
CREATE TABLE MVC_MEMBER(
    mID    VARCHAR2(30)   PRIMARY KEY,
    mPW    VARCHAR2(30)   NOT NULL,
    mNAME  VARCHAR2(30)   NOT NULL,
    mEMAIL VARCHAR2(30),
    mBIRTH  DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);
--Dao에 들어갈 query
--1.mid 중복체크
SELECT *FROM MVC_MEMBER WHERE MID='aaa';
--2.회원가입(mid,mpw,memail,mbirth,maddress)
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL,  MBIRTH, MADDRESS)
    VALUES ('aa','1','홍길동','hong@hong.com','1999/01/27','서대문');
--3.로그인 체크(mid,mpw)
SELECT * FROM MVC_MEMBER WHERE MID='aaa' AND MPW='1';
--4.로그인 성공시 session에 넣을 dto (mid로 dto가져오기)
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';
commit;