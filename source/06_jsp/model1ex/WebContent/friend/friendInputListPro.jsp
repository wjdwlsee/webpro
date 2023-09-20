
<%@page import="com.sun.net.httpserver.Authenticator.Success"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<jsp:forward page="friendInputList.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css"  rel="stylesheet" type="text/css">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String method = request.getParameter("method");
	FriendDao cDao = FriendDao.getIstance();
	int result = cDao.inserFriend(dto);
	%>
</body>
</html>