<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	
	<form action="friendInputListPro.jsp">
			<p>
				친구이름 <input type="text" name="name" value="">
				전화 <input type="text" name="name" value="">
				   <input type="submit" value="추가">
			</p>	
		</form>
		<table>	
		<%
		FriendDao dao = FriendDao.getIstance();
		ArrayList<FriendDto> friendDtos = dao.FirendList();
		if(friendDtos.size() != 0){
			for(FriendDto friend : friendDtos){
				out.print("<tr><td>" + friend.getNo()+ "</td>"
						+ "<td>" + friend.getName() + "</td>"
						+ "<td>" + friend.getTel() + "</td></tr>");
			}
	}else{
		out.print("<tr><td colspane='8'>해당 사원이 없습니다</td></tr>");
	}

		%>
		</table>
</body>
</html>