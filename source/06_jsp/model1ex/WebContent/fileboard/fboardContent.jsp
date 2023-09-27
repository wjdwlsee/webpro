<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileBoardDto"%>
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
<style>
	#content_form{padding: 40px;}
</style>
</head>
<body>
	
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fbDao = FileBoardDao.getInstance();
		if(request.getParameter("after")==null){
			fbDao.hitUp(fid);
		}
		FileBoardDto fbDto = fbDao.getFBoard(fid); // dto가져오기
		if(fbDto == null){
			response.sendRedirect(conPath + "/board/list.jsp");
		}
	%>
		<table>
			<caption>글 상세보기</caption>
			<tr><th>글번호</th><td><%=fbDto.getFid() %></td></tr>
			<tr><th>제목</th><td><%=fbDto.getFtitle() %></td></tr>
			<tr><th>작성자</th><td><%=fbDto.getCname() %>
										(<%=fbDto.getCemail()!=null?  fbDto.getCemail() : "등록된 메일 주소 없음"%>)</td></tr>
			<tr><th>첨부파일</th><td><%
						if(fbDto.getFilename()==null){
							out.print("첨부파일없음");
						}else{
							out.print("<a href='../fileboardUpload/"+fbDto.getFilename()
														+"' target='_blank'>"+fbDto.getFilename()+"</a>");
						}
			%></td></tr>
			<tr><th>본문</th><td><pre><%=fbDto.getFcontent()!=null?  fbDto.getFcontent():"본문 내용없음"%></pre></td>
			<tr><th>작성일</th><td><%=fbDto.getFrdate() %></td></tr>
			<tr><th>조회수</th><td><%=fbDto.getFhit() %></td></tr>
			<tr><th>ip</th><td><%=fbDto.getFip() %></td></tr>
			<tr><td colspan="2">
					<button onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
					<%
						String cid = null;
					  CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					  if(customer!=null){
						  cid = customer.getCid();
					  }					
					  if(fbDto.getCid().equals(cid)){
					 %>
						<button 
						onclick="location='fboardUpdateForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
						수정</button>  
					<%}
						if(session.getAttribute("customer")!=null){ %>
						<button 
						onclick="location='fboardReplyForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
						답변</button>  
					<%} %>
					<button 
						onclick="location='fboardDeleteForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">
						삭제</button>  
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>