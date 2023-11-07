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
	<h4>"현재 총  ${cnt } 명"</h4>
		<h2>결과는 다음과 같습니다</h2>
	<table>
		<tr><th>이름 : </th><td>${student.name }<td></tr>
		<tr><th>국어 : </th><td>${student.kor }<td></tr>
		<tr><th>영어 : </th><td>${student.eng }<td></tr>
		<tr><th>수학 : </th><td>${student.mat }<td></tr>
		<tr><th>총점 : </th><td>${student.tot }<td></tr>
		<tr><th>평균 : </th><td>${student.evg }<td></tr>
	</table>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}'">다시입력</button>
</body>
</html>