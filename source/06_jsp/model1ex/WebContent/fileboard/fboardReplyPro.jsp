<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
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
</head>
<body>
	<%
		String path =  request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest multipartRequest = null;
		try{
			multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8",new DefaultFileRenamePolicy()); 
			Enumeration<String> params = multipartRequest.getFileNames(); 
			//while(params.hasMoreElements()){
				String param = params.nextElement();
				filename = multipartRequest.getFilesystemName(param);
			//}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일 소스폴더로 복사
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path+"/"+filename);
			if(serverFile.exists()){
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro/source/06_JSP/model1ex/WebContent/fileboardUpload/"+filename);
				byte[] bs = new byte[(int)serverFile.length()];
				int nReadByteCnt;
				while((nReadByteCnt=is.read(bs))!=-1){
					os.write(bs, 0, nReadByteCnt);
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			if(is!=null) is.close();
			if(os!=null) os.close();
		}
		// 전달받은 파라미터들
		// pageNum
		// fid, fgroup, fstep, findent (원글정보)
		// ftitle, fcontent, fpw (답변글 입력한 정보), filename(답변첨부파일명)
		String pageNum = multipartRequest.getParameter("pageNum");
		int fid = Integer.parseInt(multipartRequest.getParameter("fid"));// 원글번호
		int fgroup = Integer.parseInt(multipartRequest.getParameter("fgroup"));// 원글번호
		int fstep = Integer.parseInt(multipartRequest.getParameter("fstep"));// 원글번호
		int findent = Integer.parseInt(multipartRequest.getParameter("findent"));// 원글번호
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid(); // 답변쓴사람 id
		String ftitle = multipartRequest.getParameter("ftitle");
		String fcontent = multipartRequest.getParameter("fcontent");
		String fpw  = multipartRequest.getParameter("fpw");;
		String fip = request.getRemoteAddr();
		FileBoardDto fbDto = new FileBoardDto(fid, cid, ftitle, fcontent, filename, 0, fpw, fgroup,
					fstep, findent, fip, null, null, null);
		
		FileBoardDao fbDao = FileBoardDao.getInstance();
		int result = fbDao.replyFBoard(fbDto);
		if(result==FileBoardDao.SUCCESS){
	%>
			<script>
				alert('<%=fid%>번 글의 답글 쓰기 성공');
				location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
			</script>
	<%}else{%>
			<script>
				alert('답글쓰기 실패');
				history.back();
			</script>
	<%}%>
</body>
</html>