package com.msg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MsgDAO implements MsgDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MOVIEON");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO MESSAGE (reviewId, userId, msgTime, msgContext) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE MESSAGE SET reviewId=?, userId=?, msgTime=?, msgContext=? where msgId = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM MESSAGE WHERE msgId = ?";
	private static final String GET_ALL_STMT = 
			"SELECT msgId, reviewId, userId, msgTime, msgContext FROM MESSAGE";
	private static final String GET_ONE_STMT = 
			"SELECT msgId, reviewId, userId, msgTime, msgContext FROM MESSAGE WHERE msgId = ?";

	@Override
	public void insert(MsgVO msgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, msgVO.getReviewId());
			pstmt.setInt(2, msgVO.getUserId());
			pstmt.setTimestamp(3, msgVO.getMsgTime());
			pstmt.setString(4, msgVO.getMsgContext());

			pstmt.executeUpdate();
			System.out.println("A record is inserted.");

		} catch (SQLException se) { // Handle any SQL errors
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally { // Clean up JDBC resources
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
		

	@Override
	public void update(MsgVO msgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, msgVO.getReviewId());
			pstmt.setInt(2, msgVO.getUserId());
			pstmt.setTimestamp(3, msgVO.getMsgTime());
			pstmt.setString(4, msgVO.getMsgContext());
			pstmt.setInt(5, msgVO.getMsgId());

			pstmt.executeUpdate(); // Step3 送出SQL command
			System.out.println("Update successfully.");

		} catch (SQLException se) { // Handle any SQL errors
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally { // Clean up JDBC resources
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer msgId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, msgId);

			pstmt.executeUpdate();
			System.out.println("One record has been deleted successfully.");

		} catch (SQLException se) { // Handle any SQL errors
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally { // Clean up JDBC resources
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public MsgVO findByPrimaryKey(Integer msgId) {
		MsgVO msgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, msgId); // 只有1個 ?

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// msgVO 也稱為 Domain objects
				msgVO = new MsgVO();
				msgVO.setMsgId(rs.getInt("msgId"));
				msgVO.setReviewId(rs.getInt("reviewId"));
				msgVO.setUserId(rs.getInt("userId"));
				msgVO.setMsgTime(rs.getTimestamp("msgTime"));
				msgVO.setMsgContext(rs.getString("msgContext"));
			}

		} catch (SQLException se) { // Handle any SQL errors
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally { // Clean up JDBC resources
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return msgVO;
	}

	@Override
	public List<MsgVO> getAll() {
		List<MsgVO> list = new ArrayList<MsgVO>();
		MsgVO msgVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				msgVO = new MsgVO();
				msgVO.setMsgId(rs.getInt("msgId"));
				msgVO.setReviewId(rs.getInt("reviewId"));
				msgVO.setUserId(rs.getInt("userId"));
				msgVO.setMsgTime(rs.getTimestamp("msgTime"));
				msgVO.setMsgContext(rs.getString("msgContext"));
				list.add(msgVO); // Store the row in the list
			}

		} catch (SQLException se) { // Handle any SQL errors
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally { // Clean up JDBC resources
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	
}
