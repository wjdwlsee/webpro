<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css"  rel="stylesheet" type="text/css">
</head>
<body>
	<h1>테스트 페이지</h1>
	<% 
	CustomerDao cdao = CustomerDao.getInstance();
	String cid = "bbb";
	int result = cdao.confirmID(cid);
	if	(result == CustomerDao.CUSTOMER_EXISTENT){
		out.print("<h3>1.confitmID결과:" + cid + "는 중복된 아이디로 회원가입 불가합니다</h3>");
	}else{
		out.print("<h3>1.confirmID결과 :" + cid +"는 가입가는한 아이디입니다</h3>");
		CustomerDto dto = new CustomerDto(cid, "111", "김미소", "010-9999-9999","miso@k.com", "서울", null, "f", null);
		result = cdao.joinCustomer(dto);
		if(result==CustomerDao.SUCCESS){
			out.print("<h3>2.join결과:" + cid+ "회원가입성공</h3>");
		}else{
			out.print("<h3>2.join결과: 회원가입실패</h3>");
		}
	}
	out.println("<h3>3. 로그인 결과 </h3>");
	cid = "bbb"; String cpw = "111";
	result = cdao.loginCheck(cid, cpw);
	if(result == CustomerDao.LOGIN_SECCESS){
		out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 성공<br>");
	}else if(result == CustomerDao.LOGIN_FAIL){
		out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 실패<br>");
	}
	out.print("<h3>3. 로그인 결과(2)</h3>");
	cid= "ppp"; cpw = "444";
	result = cdao.loginCheck(cid, cpw);
	if(result == CustomerDao.LOGIN_SECCESS){
		out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 성공<br>");
	}else {
		out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 실패<br>");
	}
	
	out.print("<h3>4. cid로 dto가져오기 </h3>");
	CustomerDto dto = cdao.getCustomer("bbb");
	out.println( "id =aaa인 "  +dto +"<br>");
	CustomerDto dto2 = cdao.getCustomer("ppp");
	out.println("id=qqq인 : " + dto2 + "<br>");
	
	out.println("<h3>5. 정보 수정 </h3>");
	dto.setCname("김민지");
	dto.setCaddress("서대문구");
	result = cdao.modifyCustomer(dto);
	if(result == CustomerDao.SUCCESS){
		out.println("수정완료<br>");
		out.println("db의 수정된 데이터 :" + cdao.getCustomer(dto.getCid()) +"<br>");
	}else{
		out.println(dto.getCid()+" 수정 실패<br>");
	}
	%>
</body>
</html>