<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String method = request.getParameter("method"); //"null" 또는 "modify"
	MemberDaoCP mDao = new MemberDaoCP();
	int result = mDao.loginCheck(id, pw);
	if(result == MemberDaoCP.LOGIN_SUCCESS){
		MemberDto member = mDao.getMember(id);
		session.setAttribute("member", member);
		if(method.equals("null")) {
		response.sendRedirect("main.jsp");
		}else{
			response.sendRedirect(method+".jsp");
		}
	}else if(result == MemberDaoCP.LOGIN_FAIL_PW){
	%>
		<script>
			alert("비밀번호를 입력하세요");
			history.back();
			//location.back();
		</script>
	<%}else if(result == MemberDaoCP.LOGIN_FAIL_ID){ %>
		<script>
			alert("아이디를 입력하세요");
			history.back();
			//location.back();
		</script>
	<%}%>
</body>
</html>