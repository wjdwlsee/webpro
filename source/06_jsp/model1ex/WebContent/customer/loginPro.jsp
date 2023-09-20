<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	request.setCharacterEncoding("utf-8");
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	String method = request.getParameter("method");
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);
	if(result == CustomerDao.LOGIN_SECCESS){
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer",customer);
		if(method.equals("null")){
			response.sendRedirect(conPath+"/main/main.jsp");
		}else{
			response.sendRedirect(method+".jsp");
		}
	}else {
		response.sendRedirect("loginForm.jsp?msg=");
	}
	%>
</body>
</html>