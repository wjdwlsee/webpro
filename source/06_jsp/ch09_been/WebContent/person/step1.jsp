<%@page import="com.lex.ex.Person"%>
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
	<%
	Person p = new Person();
	p.setName(request.getParameter("name"));
	p.setAge(Integer.parseInt(request.getParameter("age")));
	p.setGender(request.getParameter("gender").charAt(0));
	p.setAddress(request.getParameter("address"));
	%>
	<h2>개인정보(step1)</h2>
	이름  : <%=p.getName() %><br>
	나이  : <%=p.getAge() %><br>
	성별  : <%=p.getGender() %><br>
	주소  : <%=p.getAddress() %><br>
	
</body>
</html>