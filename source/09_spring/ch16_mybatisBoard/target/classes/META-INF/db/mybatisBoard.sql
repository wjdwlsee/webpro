-- table및 sequence 제거
DROP TABLE MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;
-- table및 sequence 생성
CREATE TABLE MVC_BOARD(
    bID     NUMBER(6) PRIMARY KEY,    -- 글번호
    bNAME   VARCHAR2(50) NOT NULL, -- 글쓴이
    bTITLE  VARCHAR2(50) NOT NULL, -- 글제목
    bCONTENT VARCHAR2(1000), -- 글본문
    bDATE   DATE DEFAULT SYSDATE NOT NULL, -- 글 작성시점
    bHIT    NUMBER(6) DEFAULT 0,     -- 글 조회수
    bGROUP  NUMBER(6) NOT NULL,  -- 글그룹(원글의 경우 글번호로/답변글일경우 원글의 BGROUP로)
    bSTEP   NUMBER(2) NOT NULL, -- 글그룹내 출력 순서(원글 0)
    bINDENT NUMBER(3) NOT NULL,  -- 글 LIST 출력시 글 제목 들여쓰기 정도(원글0)
    bIP     VARCHAR2(50) NOT NULL -- 글 쓴 컴퓨터의 IP
);
CREATE SEQUENCE MVC_BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

-- dummy data (3개 이상 - 2개원글+1개답변글)
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '홍', '글1', '', MVC_BOARD_SEQ.CURRVAL, 0,0, '192.1.1.1');--글1
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '홍', '글2', NULL, MVC_BOARD_SEQ.CURRVAL, 0,0, '192.1.1.2');--글2
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '답돌이', '글2-1(글3)', NULL, 2, 1, 1, '192.1.1.2'); -- 글2의 첫번째답(글3)
UPDATE MVC_BOARD SET BHIT=11 WHERE BID=3;
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP; -- 확인

-- board.xml에 들어갈 query
-- 1. 글목록(startRow부터 endRow)boardList
SELECT * 
  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)
  WHERE RN BETWEEN 2 AND 3;
  
-- 2. 글갯수 id =getBoardTotCnt
SELECT COUNT(*) CNT FROM MVC_BOARD;

-- 3. 원글쓰기 (사용자로부터 입력받은 bname, btitle, bcontent, bip, group은 글번호, gstep과 bindent은 0) id =boardWrite
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '김', '글3', NULL, MVC_BOARD_SEQ.CURRVAL, 0,0, '192.1.1.2');
-- 4. bid로 조회수 1 올리기(상세보기) id= boardHitUp
UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=3; 
-- 5. bid로 dto가져오기(상세보기, 글수정, 답변글쓰기) id = getBoardDto
SELECT * FROM MVC_BOARD WHERE BID=3;
-- 6. 글수정 (특정 bid의 bname, btitle, bcontent, bip 수정) id = boardModify
UPDATE MVC_BOARD  
  SET BNAME = '홍길동',
      BTITLE = '글2-1(글3)-수정',
      BCONTENT = '본문수정',
      BIP = '127.0.0.1'
    WHERE BID=3;
-- 7. 글삭제 (특정 bid 삭제) id =boardDelete
COMMIT;
DELETE FROM MVC_BOARD WHERE BID=1;
ROLLBACK;
-- 8. 답변글 저장 전단계(엑셀 ⓐ단계) : 3번글의 답변글을 달기 위해 3번글 정보필요
SELECT * FROM MVC_BOARD WHERE BID=3;
UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=2 AND BSTEP > 1;
-- 9. 답변글 저장 (원글의 BGROUP=2, BSTEP=1, BINDENT=1)
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '김', '글3의 답', '', 2, 2, 2, '192.1.1.1');
COMMIT;
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP; -- 확인













