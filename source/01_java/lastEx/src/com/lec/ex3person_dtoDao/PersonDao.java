package com.lec.ex3person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PersonDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int success = 1;
	public final static int FAIL 	= 0;
	private static PersonDao INSTANCE= new PersonDao();
	public  static PersonDao getInstance() {
//		if(INSTANCE==null) {
//			INSTANCE = new PersonDao();
//		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver); //1�ܰ�� �����ڿ��� �ѹ�
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//jname���� ArrayList<String>�� return �Լ�
	public ArrayList<String> jnameList(){
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url ,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}//close
		}//try-catch-finally
		return jnames;
	}
	//1�� ��� dto(�̸�,������,��,��,��)�� �޾� db insert�ϰ� ��� (success�Ǵ� fail)�� return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="INSERT INTO PERSON "
				 + "   VALUES(person_pno_sq.nextval,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?) ";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getPname());
		pstmt.setString(2, dto.getJname());
		pstmt.setInt(3, dto.getKor());
		pstmt.setInt(4, dto.getEng());
		pstmt.setInt(5, dto.getMat());
		result = pstmt.executeUpdate();
		System.out.println(result== success ? "�Է¼���":"�Է½���");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}// close
		}// try-catch-finally
		return result;
		
	}
	//2�� ��� jname�� �ٴ� db�� select �� ����� Arayylist<person>�� return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new  ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT ROWNUM RANK, A.* "
				+ "  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM "
				+ "          FROM PERSON P, JOB J "
				+ "          WHERE P.JNO = J.JNO AND JNAME=? "
				+ "          ORDER BY SUM DESC) A "; 
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank 	 = rs.getInt("rank") ;
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}// close
		}// try-catch-finally
		return dtos;
	}
	
	//3�� ��� db�� ��ü select�� ����� arraylist<personDto>�� ���� 
	public ArrayList<PersonDto> selectAll() {
			ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.* "
			+ "    FROM (SELECT PNAME ||'('||PNO||')' PNAME , JNAME, KOR,ENG,MAT,KOR+ENG+MAT SUM "
			+ "    FROM PERSON P, JOB J "
			+ "    WHERE P.JNO = J.JNO "
			+ "    ORDER BY SUM DESC) A ";
	
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}// close
		}// try-catch-finally
		return dtos;
	}
}