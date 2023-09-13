<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	<form action="loginPro.jsp" method="post">
	<table>
		<tr>
			<th><label for="id">아이디</label></th>
			<td><input type="text" name="id" id="id" class="id" required="required"></td>
		</tr>
		<tr>
			<th><label for="pw">비밀번호</label></th>
			<td><input type="password" name="pw" id="pw" class="pw" required="required"></td>
		</tr>
		<tr>
					<td colspan="2"> </td>
				</tr>
				<tr >
					<td colspan="2">
						<input type="submit" value="가입하기" onclick="location.href='loginPro.jsp'">
					</td>
				</tr>
	</table>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println(msg);
		}
	%>
	</form>
</body>
</html>