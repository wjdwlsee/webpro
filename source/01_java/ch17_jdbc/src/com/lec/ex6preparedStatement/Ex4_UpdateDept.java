package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자에게 수정할 부서번호와 부서명 , 근무지를 입력받아 update 전송 (prepareStatement)
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 부서번호는 ?");
		int deptno = scanner.nextInt();
		//부서번호의 유무 확인
		
		System.out.print("수정할 부서명은 ?");
		String dname = scanner.next();
		System.out.print("수정할 부서지역은 ?");
		String loc = scanner.next();
		String sql =  String.format("UPDATE DEPT SET DNAME = ?, LOC=? WHERE DEPTNO = ?");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			int result = pstmt.executeUpdate(sql);
			System.out.println(result>0 ? deptno +"번 부서 수정성공" : deptno + "번 부서가 없어서 수정 실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {				
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
