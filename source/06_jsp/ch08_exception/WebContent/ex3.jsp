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
	<a href="x.jsp">없는 파일로 가라고 하면 404에러</a>
	<%--
		String nullStr = request.getParameter("xx").toUpperCase(); // NullPointerException
	--%>
</body>
</html>