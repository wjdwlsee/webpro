<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	<% request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page" />
	<jsp:setProperty property="*" name="dto"/>
	<%
	String tempCbirth = request.getParameter("tempCbirth");
	if(! tempCbirth.equals("")){
		dto.setCbirth(Date.valueOf(tempCbirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmId(dto.getCid());
	if(result == CustomerDao.CUSTOMER_NONEXISTENT){
		result = cDao.joinCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("cid", dto.getCid());
		%>
		<script>
			alert("회원가입 감사합니다 . 로그인 이후에 서비스를 이용하세요");
			location.href = 'loginForm.jsp';
		</script>
		<% }else{ %>
		<script>
		alert("회원가입이 실패되었습니다. 너무 긴 데이터는 가입 불가합니다. 다시 가입해 주세요");
		history.go(-1)
		</script>
		<%}%>
	<%}else{
		%>
		<script>
		alert('중복된 ID입니다. 다른아이디를 사용하세요');
		history.back();
		</script>
	<%}%>
</body>
</html>