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
		Statement  		   stmt = null; //직업명들
		PreparedStatement pstmt = null; //1번,2번 기능
		ResultSet rs 			= null;
		Scanner scanner = new Scanner(System.in);
		String fn ,sql;
		ArrayList<String> jobs = new ArrayList<String>(); //DB에 있는 직업명들 add
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
		//System.out.println("db에 있는 직업명들 :" +jobs);
		do {
			System.out.print("1:입력||2:직업별조회||3:전체조회|그외:종료");
			fn= scanner.next();
			switch(fn) {
			case "1": //이름 직업명 국 영 수 입력받아 insert
				sql = "INSERT INTO PERSON"
				+" VALUES(person_pno_sq.nextval,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
				try {
					// 1단계 driver load는 한번만 하면 됨. 2~7단계
					conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
					pstmt = conn.prepareStatement(sql); // (3)
					System.out.print("입력할 이름은 ? ");
					pstmt.setString(1, scanner.next());
					System.out.print("입력할 직업" + jobs + "은?");
					pstmt.setString(2, scanner.next());
					System.out.print("국어는 ?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.print("영어는 ?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.print("수학은 ?");
					pstmt.setInt(5, scanner.nextInt());
					int result = pstmt.executeUpdate(); // (4) + (5)
					System.out.println(result>0 ? "입력 성공":"입력 실패"); // (6)
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
			case "2"://직업명 입력받아 출력
				sql = "SELECT ROWNUM RANK, A.* "
						+ "    FROM (SELECT PNAME ||'('||PNO||')' PNAME , JNAME, KOR,ENG,MAT,KOR+ENG+MAT SUM "
						+ "    FROM PERSON P, JOB J   "
						+ "    WHERE P.JNO = J.JNO AND JNAME=?"
						+ "    ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
					pstmt = conn.prepareStatement(sql);
					System.out.println("출력하고자 하는 직업명 "+ jobs +"?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t"+jname+"\t"
												+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
						
					}else {
						System.out.println("해당직업의 사람이 등록되지 않았습니다");
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
			
			case "3"://전체 출력
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
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t"+jname+"\t"
												+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
						
					}else {
						System.out.println("해당직업의 사람이 등록되지 않았습니다");
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
				System.out.println("3번가능");
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");
	}
}
