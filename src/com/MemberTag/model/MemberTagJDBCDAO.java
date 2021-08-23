package com.MemberTag.model;

import java.util.*;

import com.TagCategory.model.TagCategoryVO;

import oracle.net.aso.p;

import java.sql.*;

public class MemberTagJDBCDAO implements MemberTagDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO MemberTag (userId, genreId) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT tagId,userId,genreId FROM MemberTag order by tagId";
	private static final String GET_ONE_STMT = 
		"SELECT tagId,userId,genreId FROM MemberTag where tagId = ?";
	private static final String UPDATE = 
		"UPDATE MemberTag set userId=?,genreId=? where tagId = ?";
	private static final String DELETE = 
			"DELETE FROM MemberTag where tagId = ?";

	@Override
	public void insert(MemberTagVO memberTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memberTagVO.getUserId());
			pstmt.setInt(2, memberTagVO.getGenreId());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
	public void update(MemberTagVO memberTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memberTagVO.getUserId());
			pstmt.setInt(2, memberTagVO.getGenreId());
			pstmt.setInt(3, memberTagVO.getTagId());
		
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
	public void delete(Integer tagId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, tagId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
	public MemberTagVO findByPrimaryKey(Integer tagId) {

		MemberTagVO memberTagVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, tagId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				memberTagVO = new MemberTagVO();
				memberTagVO.setTagId(rs.getInt("tagId"));
				memberTagVO.setUserId(rs.getInt("userId"));
				memberTagVO.setGenreId(rs.getInt("genreId"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberTagVO;
	}

	@Override
	public List<MemberTagVO> getAll() {
		List<MemberTagVO> list = new ArrayList<MemberTagVO>();
		MemberTagVO memberTagVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				memberTagVO = new MemberTagVO();
				memberTagVO.setTagId(rs.getInt("tagId"));
				memberTagVO.setUserId(rs.getInt("userId"));
				memberTagVO.setGenreId(rs.getInt("genreId"));
				list.add(memberTagVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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

		MemberTagJDBCDAO dao = new MemberTagJDBCDAO();

		// 新增
//		MemberTagVO memberTagVO1 = new MemberTagVO();
//		memberTagVO1.setUserId(5);
//		memberTagVO1.setGenreId(50);
//		dao.insert(memberTagVO1);
		

//		// 修改
//		MemberTagVO memberTagVO2 = new MemberTagVO();
//		memberTagVO2.setTagId(6001);
//		memberTagVO2.setUserId(1);
//		memberTagVO2.setGenreId(20);
//		dao.update(memberTagVO2);
		
		// 刪除
//				dao.delete(6008);

//		// 查詢
		MemberTagVO memberTagVO3 = dao.findByPrimaryKey(6001);
		System.out.print(memberTagVO3.getTagId() + ",");
		System.out.print(memberTagVO3.getUserId() + ",");
		System.out.println(memberTagVO3.getGenreId());
		System.out.println("---------------------");

//		// 查詢
		List<MemberTagVO> list = dao.getAll();
		for (MemberTagVO aMemberTag : list) {
			System.out.print(aMemberTag.getTagId() + ",");
			System.out.print(aMemberTag.getUserId() + ",");
			System.out.println(aMemberTag.getGenreId());
			
			System.out.println("-----------------------");
		}
	}
}