<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../member/header.jsp"></jsp:include>
	<%
		request.setCharacterEncoding("utf-8"); // post방식일 때만
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
			response.sendRedirect(conPath+"/member/login.jsp?msg=");			
		}else{
			response.sendRedirect(conPath+"/member/main.jsp");
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
		}
	
	%>
	
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>















