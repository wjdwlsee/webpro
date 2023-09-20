<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
p{text-align: center;}
</style>
</head>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe"; 
	Connection conn;
	PreparedStatement  pstmt;
	ResultSet  rs;
%>
<body>
	<form action="">
		<p>
		부서번호
		<select name="deptno">
			<option value="0">s</option>
			<%
			String deptnoStr = request.getParameter("deptno");
			if(deptnoStr==null) 
				deptnoStr= "0";
			int deptnoInput = Integer.parseInt(deptnoStr);
			String sql = "SELECT * FROM DEPT";
			try{
				Class.forName(driver);
				conn  = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs    = pstmt.executeQuery();
				while(rs.next()){
				int deptno   = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc 	 = rs.getString("loc");
				if(deptnoInput ==  deptno){
					out.print("<option value='"+ deptno+"'+ selected='selected'>"
					+deptno+ "-" +dname+ "-" + loc +"</option>");
				}else{
					out.print("<option value='" + deptno + "' >"
							+ deptno + "-" + dname + "-"+ loc + "</option>");
				}
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				 if(rs	 !=null) rs.close();
				 if(pstmt!=null) pstmt.close();
				 if(conn !=null) conn.close();
			}
			%>
		</select>
		<input type="submit" value="검색" class="btn"> 
		</p>
	</form>
	<table>
	<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>
		<%
			sql = "select empno, ename, hiredate, e.deptno, dname"  
				   + "from emp e, dept d"
				   + "where e.deptno = d.deptno and e.deptno like '%' || ?";
			try{
				conn  = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptnoInput);
				rs  = pstmt.executeQuery();
				if(rs.next()){
				do{
					int empno =rs.getInt("empno");
					String ename =rs.getString("ename");
					Date hiredate = rs.getDate("hiredate");
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					out.print("<tr><td>" + empno + "</td>"
								+"<td>" + ename + "</td>"
								+"<td>" + hiredate + "</td>"
								+"<td>" + deptno + "</td>"
								+"<td>" + dname + "</td></tr>");
					}while(rs.next());
				}else{
					out.println("<tr><td colspan='5'>해당 부서번호의 사원이 없습니다</td><tr>");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				 if(rs	 !=null) rs.close();
				 if(pstmt!=null) pstmt.close();
				 if(conn !=null) conn.close();
			}
		%>
	</table>
</body>
</html>





















