package jj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
	
	public int confirmID(String id) {
		int result = CUSTOMER_EXISTENT;
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			 rs = null;
		String sql = "SELECT COUNT(*) FROM MY WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
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
		String sql = " INSERT INTO MY (ID, PW, NAME, AGE,GENDER,FAVORITEFOOD, FAVORITESTYLE, FAVORITECOLOR, FAVORITESPOT, MBTI,ADDRESS,BIRTH )" 
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString (1, dto.getId());
			pstmt.setString	(2, dto.getPw());
			pstmt.setString	(3, dto.getName());
			pstmt.setString	(4, dto.getAge());
			pstmt.setString	(5, dto.getFavoritefood());
			pstmt.setString	(6, dto.getFavoritestyle());
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
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql ="SELECT * FROM CUSTOMER WHERE CID=? AND CPW=?";
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString (1, cid);
			pstmt.setString	(2, cpw);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				result = LOGIN_SECCESS;
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
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw      = rs.getString("cpw");;
				String cname    = rs.getString("cname");
				String ctel     = rs.getString("ctel");;
				String cemail   = rs.getString("cemail");;
				String caddress =rs.getString("caddress");;
				Date   cbirth   = rs.getDate("cbirth");;
				String cgender  = rs.getString("cgender");
				Timestamp crdate=rs.getTimestamp("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cbirth, cgender, crdate);
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
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW = ?," + 
				"                CNAME=?, " + 
				"                CTEL = ?, " + 
				"                CEMAIL=?, " + 
				"                CADDRESS=?, " + 
				"                CBIRTH = ?, " + 
				"                CGENDER = ? " + 
				"          WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCgender());
			pstmt.setString(8, dto.getCid());
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