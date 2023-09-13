<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청url1:ex_forward.jgp?n=1 -->
	<h2>ex2_forward.jsp입니다</h2>
	<%
	String n = request.getParameter("n");
	%>
	<h2>ex2에서 요청한 n : <%=n %></h2>
</body>
</html>