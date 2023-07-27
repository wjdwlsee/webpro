--[VLLL] Sequence :순차번호 생성기 . 대부분 인위적인 pk 사용 용도
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1  --1부터시작
    INCREMENT BY 1 --1씩 증가
    MAXVALUE 9999   --최대값
    MINVALUE  1     --최소값
    NOCACHE
    NOCYCLE;