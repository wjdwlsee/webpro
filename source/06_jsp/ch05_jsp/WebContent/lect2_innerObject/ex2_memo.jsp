<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex2.css" rel="stylesheet">
<script>
	window.onload = function () {
		document.querySelector('input[name="memo"]').onkeyup= function () {
			var span = document.querySelector('span');
			span.innerHTML =this.value.length+"/30";
		};
	}
</script>
</head>
<body>
	<form action="ex2_memoPro.jsp" method="post">
	<table>
		<tr>
			<td>작성자</td>
			<td>한줄메모</td>
		 </tr>
		 <tr>
		 	<td><input type="text" name="writer" size="3"></td>
		 	<td>
		 		<input type="text" name="memo" size="30">
		 		<span>0/30</span>
		 	</td>
		 </tr>
		 <tr>
		 	<td colspan="2"><input type="submit" value="작성"> </td>
	</table> 
	</form>
</body>
</html>