<%@page import="com.lec.dao.FileBoardDao"%>
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
		FileBoardDao fbDao = FileBoardDao.getInstance();
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		String fpw = request.getParameter("fpw");
		int result = fbDao.deleteFBoard(fid, fpw);
		if(result==FileBoardDao.SUCCESS){
	%>
			<script>
				alert("<%=fid%>번 글 삭제성공");
				location.href = '<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>';
			</script>		
	<%}else{%>
			<script>
				alert("삭제실패. 비밀번호 확인하세요");
				history.go(-1);
			</script>	
	<%}%>
</body>
</html>