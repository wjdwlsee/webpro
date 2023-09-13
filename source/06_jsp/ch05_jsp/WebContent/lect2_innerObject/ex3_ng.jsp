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
	int age =Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>성인이 아니니 주류를 살수 없습니다</h2>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='ex3_ageInput.html'">새로입력</button>
</body>
</html>