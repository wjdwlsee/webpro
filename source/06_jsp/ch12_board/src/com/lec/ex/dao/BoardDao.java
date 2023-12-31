package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	// 싱글톤
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}
	// getConnection()
	private Connection getConnection() throws SQLException {
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
	//1. 글목록(글 그룹이 최신글이 위로)
	public ArrayList<BoardDto> listBoard(){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD ORDER BY BGROUP DESC";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int bid         = rs.getInt("bid");
				String bname    = rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail   = rs.getString("bemail");
				int    bhit     = rs.getInt("bhit");
				String bpw      = rs.getString("bpw");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep    = rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip      = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bemail, 
						bhit, bpw, bgroup, bstep, bindent, bip, bdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	//2. 전체 글 갯수
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	//3. 원글쓰기 - 작성자, 글제목, 본문, 이메일, 비번, IP (BGROUP은 글번호, BSTEP은 0, BINDENT는 0)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, "
				+ "				BGROUP, BSTEP, BINDENT, BIP) "
				+ "	VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setString(6, dto.getBip());
			result = pstmt.executeUpdate();
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " - 원글쓰다 예외 발생 : " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//4. bID로 조회수 1 올리기 (글상세보기시 필요)
	public void hitUp(int bid) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid +"번 글 조회수 1up");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void hitUp(String bid) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid +"번 글 조회수 1up");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	//5. bID로 DTO가져오기(글상세보기) - 4번조회수 올리고 DTO가져오기
//	public BoardDto getContent(int bid) {
//		hitUp(bid); // 글 상세보기 시 조회수 자동 1올리기
//		BoardDto dto = null;
//		Connection        conn  = null;
//		PreparedStatement pstmt = null;
//		ResultSet         rs    = null;
//		String sql = "SELECT * FROM BOARD WHERE BID = ?";
//		try {
//			conn  = getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bid);
//			rs    = pstmt.executeQuery();
//			if(rs.next()) {
//				String bname    = rs.getString("bname");
//				String btitle   = rs.getString("btitle");
//				String bcontent = rs.getString("bcontent");
//				String bemail   = rs.getString("bemail");
//				int    bhit     = rs.getInt("bhit");
//				String bpw      = rs.getString("bpw");
//				int    bgroup   = rs.getInt("bgroup");
//				int    bstep    = rs.getInt("bstep");
//				int    bindent  = rs.getInt("bindent");
//				String bip      = rs.getString("bip");
//				Timestamp bdate = rs.getTimestamp("bdate");
//				dto = new BoardDto(bid, bname, btitle, bcontent, bemail, 
//						bhit, bpw, bgroup, bstep, bindent, bip, bdate);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(rs    != null) rs.close();
//				if(pstmt != null) pstmt.close();
//				if(conn  != null) conn.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return dto;
//	}
//	public BoardDto getContent(String bid) {
//		hitUp(bid); // 글 상세보기 시 조회수 자동 1올리기
//		BoardDto dto = null;
//		Connection        conn  = null;
//		PreparedStatement pstmt = null;
//		ResultSet         rs    = null;
//		String sql = "SELECT * FROM BOARD WHERE BID = ?";
//		try {
//			conn  = getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bid);
//			rs    = pstmt.executeQuery();
//			if(rs.next()) {
//				String bname    = rs.getString("bname");
//				String btitle   = rs.getString("btitle");
//				String bcontent = rs.getString("bcontent");
//				String bemail   = rs.getString("bemail");
//				int    bhit     = rs.getInt("bhit");
//				String bpw      = rs.getString("bpw");
//				int    bgroup   = rs.getInt("bgroup");
//				int    bstep    = rs.getInt("bstep");
//				int    bindent  = rs.getInt("bindent");
//				String bip      = rs.getString("bip");
//				Timestamp bdate = rs.getTimestamp("bdate");
//				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, 
//						bhit, bpw, bgroup, bstep, bindent, bip, bdate);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(rs    != null) rs.close();
//				if(pstmt != null) pstmt.close();
//				if(conn  != null) conn.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return dto;
//	}
	//5. bID로 DTO가져오기(글수정FORM, 답변글쓰기FORM) - 조회수 올리지 않음
	public BoardDto getBoardNotHitUp(int bid) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String bname    = rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail   = rs.getString("bemail");
				int    bhit     = rs.getInt("bhit");
				String bpw      = rs.getString("bpw");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep    = rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip      = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(bid, bname, btitle, bcontent, bemail, 
						bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	public BoardDto getBoardNotHitUp(String bid) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String bname    = rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail   = rs.getString("bemail");
				int    bhit     = rs.getInt("bhit");
				String bpw      = rs.getString("bpw");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep    = rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip      = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, 
						bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	//6. 글수정 (작성자, 글제목, 본문, 이메일, 비번, IP 수정)
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD " + 
				"  SET BNAME = ?, " + 
				"      BTITLE = ?, " + 
				"      BCONTENT = ?, " + 
				"      BEMAIL = ?," + 
				"      BPW    = ?," + 
				"      BIP    = ?" + 
				"  WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setString(6, dto.getBip());
			pstmt.setInt(7, dto.getBid());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정 성공":"글수정 실패(bid오류)");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " - 글수정 예외 발생 : " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//7. 글삭제(비번을 맞게 입력한 경우만 삭제)
	public int deleteBoard(int bid, String bpw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE BID=? AND BPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.setString(2, bpw);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제 성공":"글삭제 실패(비번확인)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		