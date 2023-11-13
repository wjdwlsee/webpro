<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
s<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${Writeresult eq SUCCESS }">
		<script>alert('글쓰기 성공');</script>
	</c:if>
	<c:if test="${Writeresult eq FAIL }">
		<script>alert('글쓰기 실패'); history.back(); </script>
	</c:if>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="${conPath }/board/myBoardwrite.do">글쓰기</a></td></tr>
	</table>
	<table>
		<tr>
			<th>순번</th><th>역번</th>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>IP</th><th>작성</th><th>조회수</th>
		</tr>
		<%-- <c:if test="${boardList.isEmpty() }"> --%>
		<c:if test="${boardList.size() eq 0 }">
			<tr><td colspan="8">해당 페이지 글이 없습니다</td></tr>
		</c:if>
		<c:set var="oNum" value="${paging.startRow }"/>
		<c:set var="iNum" value="${paging.totCnt - paging.startRow+1 }"/>
		<c:forEach var="Board" items="${boardList }">
			<tr onclick="trClicked(${Board.bid })">
			<td>${oNum }</td>
			<td>${iNum }</td>
			<td>${Board.bid }</td>
			<td>${Board.bname }</td>
			<td class="left">
			<c:forEach var="i" begin="1" end="${Board.bindent }">
						<c:if test="${i eq Board.bindent}">
							▒┌⊙ ⊙ ☆
								  º ─┘▒
						</c:if>
						<c:if test="${i != Board.bindent }">
							&nbsp; &nbsp; &nbsp;  
						</c:if>
					</c:forEach><!-- 답변글일 경우 들여쓰기 처리 -->
					${Board.btitle }
					<c:if test="${Board.bhit > 10 }">
						<b>( * )</b>
					</c:if>
					<c:if test="${not empty Board.bfileName }">
						<img src="${conPath }/img/${Board.bfileName}" width="20">
					</c:if>
						</td>
				<td>${Board.bip }</td>
				<td>
					<fmt:formatDate value="${Board.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
				</td>
				<td>${Board.bhit }</td>
			</tr>
			<c:set var="oNum" value="${oNum+1 }"/>
			<c:set var="iNum" value="${iNum-1}"/>
		</c:forEach>
	</table>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/board/list.do?pageNum=${paging.startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[ <a href="${conPath }/board/list.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/board/list.do?pageNum=${paging.endPage+1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>