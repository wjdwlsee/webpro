package com.lec.ex2SelectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*사용자에게 부서번호를 입력받아
 * (1) 해당부서번호가 존재하면 :부서정보 출력, 사원정보(사번,이름,급여,상사이름) 출력
 * (2) 해당부서번호가 존재하지 않으면 : 부서번호가 존재하지 않는다고 출력
 */
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
    	String url	  ="jdbc:oracle:thin:@127.0.0.1:1521:xe";	
    	Connection conn 	= null;
    	Statement  stmt 	= null;
    	ResultSet  rs 		= null;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("부서번호를 입력하세요");
    	int deptno = scanner.nextInt();
    	String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" +deptno;
    	String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ')MANAGER "
    				 + "  FROM EMP W, EMP M"
    				 + "  WHERE w.MGR =M.EMPNO(+) AND W.DEPTNO=" +deptno;
    	try {
			Class.forName(driver);//(1)
			conn = DriverManager.getConnection(url,"scott","tiger"); //(2)
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println("부서번호 :" + deptno);
				System.out.println("부서명 :" + rs.getString("dname"));
				System.out.println("부서위치 :" + rs.getString("loc"));
				//sql2전송후 결과 받아 출력
				rs.close();
				rs= stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t상사");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager =rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal +"\t" + manager);
					}while(rs.next());
				}else {
					System.out.println(deptno+"번 사원이 없습니다");
				}
			}else {
				System.out.println(deptno +"번 부서는 유요한 부서번호가 아닙니다");
			}
    	
    	} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs !=null)  rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	
		}
	}
}
