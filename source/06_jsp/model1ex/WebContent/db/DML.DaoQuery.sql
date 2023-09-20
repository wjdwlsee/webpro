--Customer에 들어갈 QUERY
-- 1. 회원가입시 id 중복체크 : public int confirmId(String cid)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
-- SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 2. 회원가입 : public int joinCustmer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
  VALUES ('aaa', '111', '홍길동', '010-9999-9999', 'h@h.com', '서울', '1995-12-12', 'm');

-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO 가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111',
                CNAME='마길순',
                CTEL = '02-111-1111',
                CEMAIL='m@h.com',
                CADDRESS='제주도',
                CBIRTH = '1999-12-12',
                CGENDER = 'f'
          WHERE CID='aaa';
SELECT * FROM CUSTOMER;
COMMIT;