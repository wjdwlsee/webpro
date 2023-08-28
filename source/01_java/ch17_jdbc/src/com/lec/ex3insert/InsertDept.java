package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڿ��� �μ���ȣ ,�μ���,�ٹ����� �Է¹޾� dept ���̺� insert
public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�Է��� �μ���ȣ��(���� 2�ڸ� �̳�)?");
		int deptno = scanner.nextInt();
		//�μ���ȣ �ߺ�üũ
		
		System.out.println("�Է��� �μ����� ?");
		String dname = scanner.next();
		System.out.println("�Է��� �μ���ġ��?");
		String loc = scanner.next();
		String sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno,dname,loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql); //excuteUpdate : insert, update, delete �� ����
												 //	excuteQuery : select�� ���� - ���  resultSet
			System.out.println(result>0 ? "�Է¼���" : "�Է½���");
		} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
		} catch (SQLException e) {
				System.out.println("�ߺ��� �μ���ȣ�ų� �μ����̳� ��ġ�� �ʹ� ��� �Է��� ��� :" +e.getMessage());
		}finally {
			try {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}	
		} // try-catch
	}
}