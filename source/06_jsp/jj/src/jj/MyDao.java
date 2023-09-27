package jj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MyDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public static final int LOGIN_FAIL = 1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int CUSTOMER_EXISTENT =0; 
	public static final int CUSTOMER_NOEXISTENT =1; 
	private static MyDao instnace = new MyDao();
	public static MyDao getInstance() {
		return instnace;
	}
	private MyDao() {}
	private Connection getConnection () throws SQLException{
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); 
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public ArrayList<MyDto> mylist(){
		ArrayList<MyDto> my = new ArrayList<MyDto>();
		
	}
	//아이디 중복확인
	public int confirmID(String id) {
		int result = CUSTOMER_EXISTENT;
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			 rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MY WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt == 0) {
				result = CUSTOMER_NOEXISTENT;
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//2. 회원가입                     : public int joinCustmer(CustomerDto dto)
	public int joinMy(MyDto dto) {
		int result = FAIL;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = " INSERT INTO MY (ID, PW, NAME, AGE,FAVORITEFOOD,  FAVORITECOLOR, FAVORITESPOT, MBTI, BIRTH ,GENDER )" 
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString (1, dto.getId());
			pstmt.setString	(2, dto.getPw());
			pstmt.setString	(3, dto.getName());
			pstmt.setInt	(4, dto.getAge());
			pstmt.setString	(5, dto.getFavoritefood());
			pstmt.setString	(7, dto.getFavoritecolor());
			pstmt.setString	(8, dto.getFavoritespot());
			pstmt.setString	(4, dto.getMbti());
			result = pstmt.executeUpdate();
			System.out.println("회원가입 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입실패" + dto);
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//3. 로그인                        : public int loginCheck(String cid, String cpw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql ="SELECT * FROM MY WHERE ID=? AND PW=?";
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString (1, id);
			pstmt.setString	(2, pw);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				result = LOGIN_SUCCESS;
			}else {
				result = LOGIN_FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	}
	//4. cid로 DTO 가져오기    : public CustomerDto getCustomer(String cid)
	public MyDto getMy(String id) {
		MyDto	 dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MY WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pw      = rs.getString("pw");;
				String name    = rs.getString("name");
				int age    	   = rs.getInt("age");
				String favoritefood   = rs.getString("favoritefood");
				String favoritecolor =rs.getString("favoritecolor");
				String favoritespot  = rs.getString("favoritespot");
				String mbti  = rs.getString("mbti");
				Date   birth   = rs.getDate("birth");
				String gender  = rs.getString("gender");
				dto = new MyDto(id, pw, name, age, favoritefood, favoritecolor, favoritespot, mbti, birth, gender);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	//5. 정보수정
	public int modify(MyDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET PW = ?," + 
				"                NAME=?, " + 
				"                AGE = ?, " + 
				"                FAVORITEFOOD=?, " + 
				"                FAVORITECOLOR=?, " + 
				"                FAVORITESPOT = ?, " + 
				"                MBTI = ? " + 
				"          WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getFavoritecolor());
			pstmt.setString(5, dto.getFavoritecolor());
			pstmt.setString(6, dto.getFavoritespot());
			pstmt.setString(7, dto.getMbti());
			pstmt.setDate(8, dto.getBirth());
			pstmt.setString(9, dto.getGender());
			pstmt.setString(10,dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원수정성공":"회원수정실패(id("+dto.getCid()+")가없음)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 : " + dto);
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}