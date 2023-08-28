package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڿ��� ������ �μ���ȣ�� �μ��� , �ٹ����� �Է¹޾� update ���� (prepareStatement)
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		//�μ���ȣ�� ���� Ȯ��
		
		System.out.print("������ �μ����� ?");
		String dname = scanner.next();
		System.out.print("������ �μ������� ?");
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
			System.out.println(result>0 ? deptno +"�� �μ� ��������" : deptno + "�� �μ��� ��� ���� ����");
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
