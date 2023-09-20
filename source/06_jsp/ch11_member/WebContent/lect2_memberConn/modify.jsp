<%@page import="java.sql.Date"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css"  rel="stylesheet" type="text/css">
<script>
	//submit 이벤트 제한 추가 :pw와 pwchk같은지
</script>
</head>
<body>
<%! String id, pw, name, phone1, phone2, phone3, gender, email, address;
	Date birth;
%>
	<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member==null){//비로그인 상태
		response.sendRedirect("login.jsp?method=modify");
	}else{ //로그인상태
	 	 id = member.getId();
	 	 pw = member.getPw();
	 	 name 	= member.getName();
		 phone1 = member.getPhone1();
	 	 phone2 = member.getPhone2();
	 	 phone3 = member.getPhone3();
	 	 gender = member.getGender();
	 	 email 	= member.getEmail();
	 	 birth 	= member.getBirth();
	 	 address= member.getAddress();
	}
	%>
	<form action="modifyOk.jsp" method="post" name="join_frm">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="<%=id%>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현비밀번호</th>
				<td><input type="password" name="oldPw" required="required" >
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="pw" placeholder="비밀번호 수정을 원치 않으면 입력하지 마세요"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<select name="phone1">
					<option <%if("010".equals(phone1)){
								out.print("selected='seleted'");} 
							%>>010</option>
					<option <%if("02".equals(phone1)){
								out.print("selected='seleted'");} 
							%>>02</option>
					<option <%if("031".equals(phone1)){
								out.print("selected='seleted'");} 
							%>>031</option>
					<option <%if("032".equals(phone1)){
								out.print("selected='seleted'");} 
							%>>032</option>
					</select> -
					<input type="text" name= "phone2" size="2" value="<%=phone2!=null?phone2 : ""%>"> -
					<input type="text" name= "phone3" size="2" value="<%=phone3!=null?phone3 : ""%>">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<%if("m".equals(gender)){ %>
					<input type="radio" name="gender" value="m" checked="checked">남
					<input type="radio" name="gender" value="f">여	
				<%}else if("f".equals(gender)){ %>
					<input type="radio" name="gender" value="m" >남
					<input type="radio" name="gender" value="f" checked="checked">여
				<%}else { 	%>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f">여		
				<%}%>
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="email" value="<%=email!=null? email: ""%>"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempBirth" value="<%=birth != null? birth:""%>"></td>
			</tr>
				<%--파라미터 이름을 birth로 하면 bin태그 사용시 날짜를 입력하면 500에러 --%>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="<%=address==null?"":address%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보수정"> 
					<input type="reset" value="취소">
					<input type="button" value="회원가입" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>
	
	
	</form>
</body>
</html>