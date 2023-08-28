package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PERSONmNG {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection 		   conn = null;
		Statement  		   stmt = null; //�������
		PreparedStatement pstmt = null; //1��,2�� ���
		ResultSet rs 			= null;
		Scanner scanner = new Scanner(System.in);
		String fn ,sql;
		ArrayList<String> jobs = new ArrayList<String>(); //DB�� �ִ� ������� add
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs 	 = stmt.executeQuery(sql);
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)rs.close();
				if(conn!=null)rs.close();
			}catch(SQLException e)  {
				System.out.println(e.getMessage());
			}
		}
		//System.out.println("db�� �ִ� ������� :" +jobs);
		do {
			System.out.print("1:�Է�||2:��������ȸ||3:��ü��ȸ|�׿�:����");
			fn= scanner.next();
			switch(fn) {
			case "1": //�̸� ������ �� �� �� �Է¹޾� insert
				sql = "INSERT INTO PERSON"
				+" VALUES(person_pno_sq.nextval,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
				try {
					// 1�ܰ� driver load�� �ѹ��� �ϸ� ��. 2~7�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
					pstmt = conn.prepareStatement(sql); // (3)
					System.out.print("�Է��� �̸��� ? ");
					pstmt.setString(1, scanner.next());
					System.out.print("�Է��� ����" + jobs + "��?");
					pstmt.setString(2, scanner.next());
					System.out.print("����� ?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.print("����� ?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.print("������ ?");
					pstmt.setInt(5, scanner.nextInt());
					int result = pstmt.executeUpdate(); // (4) + (5)
					System.out.println(result>0 ? "�Է� ����":"�Է� ����"); // (6)
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally { // (7)
					try {
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
			}
				break;
			case "2"://������ �Է¹޾� ���
				sql = "SELECT ROWNUM RANK, A.* "
						+ "    FROM (SELECT PNAME ||'('||PNO||')' PNAME , JNAME, KOR,ENG,MAT,KOR+ENG+MAT SUM "
						+ "    FROM PERSON P, JOB J   "
						+ "    WHERE P.JNO = J.JNO AND JNAME=?"
						+ "    ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
					pstmt = conn.prepareStatement(sql);
					System.out.println("����ϰ��� �ϴ� ������ "+ jobs +"?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t"+jname+"\t"
												+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
						
					}else {
						System.out.println("�ش������� ����� ��ϵ��� �ʾҽ��ϴ�");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs != null) rs.close();
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			
			case "3"://��ü ���
				sql = "SELECT ROWNUM RANK, A.* "
						+ "    FROM (SELECT PNAME ||'('||PNO||')' PNAME , JNAME, KOR,ENG,MAT,KOR+ENG+MAT SUM "
						+ "    FROM PERSON P, JOB J "
						+ "    WHERE P.JNO = J.JNO "
						+ "    ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t"+jname+"\t"
												+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
						
					}else {
						System.out.println("�ش������� ����� ��ϵ��� �ʾҽ��ϴ�");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs!=null)
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.println("3������");
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");
	}
}
