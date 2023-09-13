<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//post 요청시 request 파라미터 한글처리
	String writer = request.getParameter("writer");
	String memo = request.getParameter("memo");
	String ip = request.getRemoteAddr();
	Date date = new Date(System.currentTimeMillis()); //요청한 시점
	Timestamp now = new Timestamp(System.currentTimeMillis());
	%>
	<h2>글쓴이: <%=writer %> </h2>
	<h3>한줄메모: <%=memo %></h3>
	<h3>글쓴이ip: <%=ip %></h3>
	<h3>글쓴날짜: <%=date %></h3>
	<h3>글쓴날짜: <%=now %></h3>
</body>
</html>