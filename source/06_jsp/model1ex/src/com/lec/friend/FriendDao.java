package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class FriendDao {
	private static final int SUCCESS = 1;
	private static final int FAIL= 0;
	private static FriendDao instance = new FriendDao();
	public static FriendDao getIstance() {
		return instance;
}
private FriendDao () {}
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
public int inserFriend(FriendDto dto) {
	int result =FAIL;
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	String sql ="INSERT INTO FRIEND (NO,NAME,TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL,?,?)";
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTel());
		result = pstmt.executeUpdate();
		System.out.println("성공");
	}catch (SQLException e) {
		System.out.println(e.getMessage());
		System.out.println("실패" +dto);
	}finally {
		try {
			if(rs    != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn  != null) conn.close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	return result;
}
public int inserFriend(String name, String tel) {
	int result =FAIL;
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	String sql ="SELECT * FROM FRIEND ORDER BY NO";
	try {
	conn = getConnection();
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	if(rs.next()) {
		int no 	= rs.getInt("no");
		name    = rs.getString("name");
		tel     = rs.getString("tel");;
		result = SUCCESS;
	}
	}catch (SQLException e) {
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
return result;
}
public ArrayList<FriendDto> FirendList(){
	ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
	Connection		 conn	= null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	String sql ="SELECT * FROM FRIEND ORDER BY NO";
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) { 
			int    no   = rs.getInt("no");
			String name = rs.getString("name");
			String tel  = rs.getString("tel");
			dtos.add(new FriendDto(no, name, tel));
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally { //(7)
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
}
























