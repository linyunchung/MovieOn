package com.msg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MsgJDBCDAO implements MsgDAO_interface {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	public static final String USERID = "root";
	public static final String PWD = "Ab3345678";

	private static final String INSERT_STMT = "INSERT INTO MESSAGE (reviewId, userId, msgTime, msgContext) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE MESSAGE SET reviewId=?, userId=?, msgTime=?, msgContext=? where msgId = ?";
	private static final String DELETE_STMT = "DELETE FROM MESSAGE WHERE msgId = ?";
	private static final String GET_ALL_STMT = "SELECT msgId, reviewId, userId, msgTime, msgContext FROM MESSAGE";
	private static final String GET_ONE_STMT = "SELECT msgId, reviewId, userId, msgTime, msgContext FROM MESSAGE WHERE msgId = ?";

	@Override
	public void insert(MsgVO msgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER); // Step1 更臱笆
			con = DriverManager.getConnection(URL, USERID, PWD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, msgVO.getReviewId());
			pstmt.setInt(2, msgVO.getUserId());
			pstmt.setTimestamp(3, msgVO.getMsgTime());
			pstmt.setString(4, msgVO.getMsgContext());

			pstmt.executeUpdate();
			System.out.println("A record is inserted.");

		} catch (ClassNotFoundException e) { // Handle any driver errors
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERID, PWD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, msgVO.getReviewId());
			pstmt.setInt(2, msgVO.getUserId());
			pstmt.setTimestamp(3, msgVO.getMsgTime());
			pstmt.setString(4, msgVO.getMsgContext());
			pstmt.setInt(5, msgVO.getMsgId());

			pstmt.executeUpdate(); // Step3 癳SQL command
			System.out.println("Update successfully.");

		} catch (ClassNotFoundException e) { // Handle any driver errors
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERID, PWD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, msgId);

			pstmt.executeUpdate();
			System.out.println("One record has been deleted successfully.");

		} catch (ClassNotFoundException e) { // Handle any driver errors
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERID, PWD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, msgId); // Τ1 ?

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// msgVO 嘿 Domain objects
				msgVO = new MsgVO();
				msgVO.setMsgId(rs.getInt("msgId"));
				msgVO.setReviewId(rs.getInt("reviewId"));
				msgVO.setUserId(rs.getInt("userId"));
				msgVO.setMsgTime(rs.getTimestamp("msgTime"));
				msgVO.setMsgContext(rs.getString("msgContext"));
			}

		} catch (ClassNotFoundException e) { // Handle any driver errors
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERID, PWD);
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

		} catch (ClassNotFoundException e) { // Handle any driver errors
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());

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

	public static void main(String[] args) {
		MsgJDBCDAO dao = new MsgJDBCDAO();
		/*
		 * //穝糤 MsgVO msgVO_insert = new MsgVO(); msgVO_insert.setReviewId(3);
		 * msgVO_insert.setUserId(3);
		 * msgVO_insert.setMsgTime(Timestamp.valueOf("2021-08-07 10:31:12")); 
		 * msgVO_insert.setMsgContext("崩崩!!"); dao.insert(msgVO_insert);
		 */

		/*
		 * //э MsgVO msgVO_update = new MsgVO(); msgVO_update.setMsgId(12);
		 * msgVO_update.setReviewId(3); msgVO_update.setUserId(4);
		 * msgVO_update.setMsgTime(Timestamp.valueOf("2021-08-08 12:12:00")); //莱эΘ讽丁
		 * msgVO_update.setMsgContext("程Τ眒矹程Τ眒矹程Τ眒矹璶单辊常禲ЧXD");
		 * 
		 * dao.update(msgVO_update);
		 */

		// 埃
//		dao.delete(13);

		// 琩高
		MsgVO msgVO_find_one = dao.findByPrimaryKey(2);
		System.out.print(msgVO_find_one.getMsgId() + ", ");
		System.out.print(msgVO_find_one.getReviewId() + ", ");
		System.out.print(msgVO_find_one.getUserId()+", ");
		System.out.print(msgVO_find_one.getMsgTime() + ", ");
		System.out.println(msgVO_find_one.getMsgContext());
		System.out.println("--------------------------------------------------------------------------------");

		// 琩高场
		List<MsgVO> list = dao.getAll();
		for (MsgVO msgvo : list) {
			System.out.print(msgvo.getMsgId() + ", ");
			System.out.print(msgvo.getReviewId() + ", ");
			System.out.print(msgvo.getUserId()+", ");
			System.out.print(msgvo.getMsgTime() + ", ");
			System.out.println(msgvo.getMsgContext());
			System.out.println();
		}
	}

}
