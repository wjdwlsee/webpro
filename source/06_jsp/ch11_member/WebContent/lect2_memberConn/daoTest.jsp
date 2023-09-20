<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="sun.security.jca.GetInstance"%>
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
	MemberDaoCP dao = new MemberDaoCP();
	String id = "bbb";
	int result = dao.confirmID(id);
	if(result== MemberDaoCP.MEMBER_EXISTENT){
		out.print("<h3>1.confitmID결과:" + id+ "는 중복된 아이디로 회원가입 불가합니다</h3>");
	}else{
		out.print("<h3>1.confirmID결과 :" + id +"는 가입가는한 아이디입니다</h3>");
		MemberDto dto = new MemberDto(id, "111", "홍", null, null, null, null,"a@hong.com", null, null, null);
		result = dao.joinMember(dto);
		if(result==MemberDaoCP.SUCCESS){
			out.print("<h3>2.join결과:" + id+ "회원가입성공</h3>");
		}else{
			out.print("<h3>2.join결과: 회원가입실패</h3>");
		}
	}
	out.print("<h3>logincheck결과</h3>");
	id= "bbb"; String pw = "111";
	result = dao.loginCheck(id, pw);
	if(result==MemberDaoCP.LOGIN_SUCCESS){
		out.print("ID는:"+id+",pw는"+pw+": 로그인성공<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_PW){
		out.print("ID는:"+id+",pw는"+pw+": 비밀번호 오류로 로그인실패<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_ID){
		out.print("ID는:"+id+",pw는"+pw+": id 오류로 로그인실패<br>");
	}
	
	id= "bbb";  pw ="xxx";
	result = dao.loginCheck(id, pw);
	if(result==MemberDaoCP.LOGIN_SUCCESS){
		out.print("ID는:"+id+",pw는"+pw+": 로그인성공<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_PW){
		out.print("ID는:"+id+",pw는"+pw+": 비밀번호 오류로 로그인실패<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_ID){
		out.print("ID는:"+id+",pw는"+pw+": id 오류로 로그인실패<br>");
	}

	id= "xxx";  pw = "111";
	result = dao.loginCheck(id, pw);
	if(result==MemberDaoCP.LOGIN_SUCCESS){
		out.print("ID는:"+id+",pw는"+pw+": 로그인성공<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_PW){
		out.print("ID는:"+id+",pw는"+pw+": 비밀번호 오류로 로그인실패<br>");
	}else if(result==MemberDaoCP.LOGIN_FAIL_ID){
		out.print("ID는:"+id+",pw는"+pw+": id 오류로 로그인실패<br>");
	}
	out.print("<h3>4. id로 dto가져오기 </h3>");
	MemberDto dto = dao.getMember("aaa");
	out.print("id= aaa 인 dto정보"+dto+ "<br>");
	dto = dao.getMember("zzz");
	out.print("id==zzz인 member:" + dto + "<br>");
	out.print("<h3>5.정보수정</h3>");
	out.print("id=aaa인 member 수정전 :" +dao.getMember("aaa")+"<br>");
	dto =new MemberDto("aaa", "111", "홍낄동", "02", "9999", "9999", null,"ssss@hong.com", null, null, null);
	result = dao.modifyMember(dto);
	if(result==MemberDaoCP.SUCCESS){
		out.print("db에 수정후 데이터  :" +dao.getMember("aaa")+ "<br>");
	}else{
		out.print(dto.getId() +"수정실패");
	}
		
	%>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
</body>
</html>