<%@page import="java.io.PrintWriter"%>
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
	String agree = request.getParameter("agree"); //"y" "n" null
	if("y".equals(agree)){
		//약관에 동의한 경우 : 세션속성값(id,pw,name) 받아 파일저장 . 세션삭제(id,name)->result.jsp?mag=succecs
		String id =(String)session.getAttribute("id");
		String pw =(String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		//파일에 저장(소스폴더의 wepContent/WEB-INF/id.txt)
		String filePath = "C:/Webpro/source/06_jsp/ch07_session/WebContent/WEB-INF/"+id+".txt";
		PrintWriter writer = new PrintWriter(filePath);
		writer.write("오늘은 DB에 insert하는 대신 파일 출력\n");
		writer.println("id :" +id);
		writer.println("pw :" +pw);
		writer.println("name :" +name);
		writer.close(); 
		session.removeAttribute("pw");
		session.removeAttribute("name");
		//세션에 id속성은 유지 (로그인페이지 사용예정)
		response.sendRedirect("result.jsp?msg=success");
		
	}else{
		//약관에 동의하지 않았구나 이파일부터 실행한 경우:세션날림 ->result.jsp?mag=fail
		session.invalidate();
		response.sendRedirect("result.jsp?msg=fail");
	}
	%>
</body>
</html>