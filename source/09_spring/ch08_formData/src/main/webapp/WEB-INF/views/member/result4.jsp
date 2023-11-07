<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h5>어떤 요청이 들어와도 cnt, list는 model에 add됨</h5>
	<h6>cnt : ${cnt } </h6>
	<h6>list : ${list } </h6>
	<h3>result.jsp페이지입니다(join6결과)</h3>
	<h4>이름 : ${member.name } </h4>
	<h4>아디 : ${member.id } </h4>
	<h4>비번 : ${member.pw } </h4>
	<h4>나이 : ${member.age } </h4>
	<h4>메일 : ${member.email } </h4>
	<h4>주소 : ${member.address } </h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}'">다시입력</button>
	
</body>
</html>