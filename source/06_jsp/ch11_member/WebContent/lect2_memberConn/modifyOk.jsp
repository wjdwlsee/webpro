<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<%--modifyOk.jsp 에서 전달받은 파라미터 :id,Pw(바꾸고싶은새비번),name, phone1,phone2,gender,email,address(MemberDto)
	 oldPs(현비번), tempBirth (MemberDto에없는 변수이름)
	 --%>
	 <% request.setCharacterEncoding("utf-8");%>
	 <jsp:useBean id="dto" class="com.lec.member.MemberDto" />
	 <jsp:setProperty property="*" name="dto" />
	 <%
	 String tempBirth = request.getParameter("tempBirth");
	 if(!tempBirth.equals("")) {
		 dto.setBirth(Date.valueOf(tempBirth));
	 }
	 MemberDto member = (MemberDto)session.getAttribute("member");
	 String sessionPw =null;
	 if(member!=null){
		 sessionPw = member.getPw(); // member 세션의 pw
	 }
	 String oldPw = request.getParameter("oldPw");
	 if(sessionPw.equals(oldPw)){
		 //현비빌번호를 맞게 입력한 경우 정보 수정 진행
		 if(dto.getPw()==null){ //새비밀번호를 입력하지 않은 경우
			 dto.setPw(oldPw); //새비밀번호를 현재 비밀번호로
		 }
		 MemberDaoCP mDao = new MemberDaoCP();
		 int result = mDao.modifyMember(dto);
		 if(result == MemberDaoCP.SUCCESS){
			 session.setAttribute("member", dto);//수정된 정보를 session 속성으로도 수정
	%>
			<script>
				alert('정보수정이 완료되었습니다');
				location.href='main.jsp';
			</script>
		<% }else{//수정 실패%>
			<script>
				alert('정보수정이 실패하였습니다. 정보가 너무 깁니다');
				location.href = 'modify.jsp';
			</script>
		<%}%>
	<%}else{ //현 비밀번호를 틀리게 입력한 경우 이전페이지로%>
		 <script>
		 	alert('현 비밀번호가 바르지 않습니다. 확인하세요');
		 	history.back();
		 </script>
	 <%}%>
</body>
</html>












