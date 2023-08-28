package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڿ��� �μ���ȣ�� �޾� �ߺ�üũ �� ,�μ���,�ٹ����� �Է¹ް� dept ���̺� insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null; 
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.println("�Է��� �μ���ȣ��(���� 2�ڸ� �̳�)?");
			int deptno = scanner.nextInt();
			//�μ���ȣ �ߺ�üũ
			String selectSQL ="SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" +deptno;
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt =rs.getInt("cnt");
			if(cnt==1) {
				System.out.println("�ߺ��� �μ���ȣ�� �Է� �Ұ��մϴ�");
			}else {
				System.out.println("�Է��� �μ����� ?");
				String dname = scanner.next();
				System.out.println("�Է��� �μ���ġ��?");
				String loc = scanner.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno,dname,loc);
				int result = stmt.executeUpdate(sql); //excuteUpdate : insert, update, delete �� ����
												 //	excuteQuery : select�� ���� - ���  resultSet
				System.out.println(result>0 ? "�Է¼���" : "�Է½���");
			}
		} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
		} catch (SQLException e) {
				System.out.println("�ߺ��� �μ���ȣ�ų� �μ����̳� ��ġ�� �ʹ� ��� �Է��� ��� :" +e.getMessage());
		}finally {
			try {
			if(rs 	!= null)  rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}	
		} // try-catch
	}
}