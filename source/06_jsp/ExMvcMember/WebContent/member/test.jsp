<%@page import="com.lec.ex.dto.Dto"%>
<%@page import="com.lec.ex.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css"  rel="stylesheet" type="text/css">
</head>
<body>
	<%
	Dao dao = Dao.getInstance();
	out.println("<h3>1.회원id중복체크</h3>");
	if(Dao.EXISTENT == dao.midConfirm("bbb")){
		out.println("bbb는 중복된 ID");
	}else if(Dao.NONEXISTENT == dao.midConfirm("bbb")){
		out.println("bbb는 사용가능한 ID");
		out.println("<h3>2.회원가입</h3>");
		int result = dao.joinMember(new Dto("bbb","1","신길","h@h.com",null, "경기",null));
		if(result == Dao.SUCCESS){
			out.println("회원가입 성공");
		}else if(result == Dao.FAIL){
			out.println("회원가입 실패");
		}
	}
	out.println("<h3>3.로그인</h3>");
	String mid = "bbb", mpw="1";
	int result = dao.loginCheck(mid, mpw);
	if(result == Dao.SUCCESS){
		out.println("<p>"+mid+"/"+mpw+" 로그인 성공</p>");
	}else if(result == Dao.FAIL){
		out.println("<p>"+mid+"/"+mpw+" 로그인 실패</p>");
	}
	mid = "bbb"; mpw="9";
	result = dao.loginCheck(mid, mpw);
	if(result == Dao.SUCCESS){
		out.println("<p>"+mid+"/"+mpw+" 로그인 성공</p>");
	}else if(result == Dao.FAIL){
		out.println("<p>"+mid+"/"+mpw+" 로그인 실패</p>");
	}
	out.println("<h3>4.mid로 dto가져오기</h3>");
	Dto member = dao.getMember("aaa");
	out.println("<p>"+member+"</p>");
	%>
</body>
</html>