<%@page import="com.lec.ex.Member"%>
<%@page import="java.net.URLEncoder"%>
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
	//id, pw 파마리터로 받고 유효한 id와pw인경우 :로그인처리 (세션에 추가)-> welcome.jsp 
	//                  유효하지 않은 id와 pw인 경우 : login.jsp?msg=~check
	String msg= "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id!=null && id.equals("aaa")){
		//유효한 아이디를 입력한 경우
	if(pw!=null && pw.equals("111")){
		//로그인 처리(세션에 속성추가)	
		session.setAttribute("id", id);
		session.setAttribute("name", "홍길동");
		/*Member member = new Member(id,pw,"홍길동");
		session.setAttribute("Member", member);*/
		response.sendRedirect("welcome.jsp");
	}else{
		//pw를 틀린 경우
		msg = URLEncoder.encode("pw를 체크하세여" ,"utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
		}
	}else{
		msg = URLEncoder.encode("id를 체크하세여" ,"utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
		
	}
	%>
</body>
</html>