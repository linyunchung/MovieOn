package com.TagCategory.model;

import java.util.*;



import oracle.net.aso.p;

import java.sql.*;

public class TagCategoryJDBCDAO implements TagCategoryDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO TagCategory (genreTag) VALUES (?)";
	private static final String GET_ALL_STMT = 
		"SELECT genreId,genreTag FROM TagCategory order by genreId";
	private static final String GET_ONE_STMT = 
		"SELECT genreId,genreTag FROM TagCategory where genreId = ?";
	private static final String UPDATE = 
		"UPDATE TagCategory set genreTag=? where genreId = ?";

	@Override
	public void insert(TagCategoryVO tagCategoryVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, tagCategoryVO.getGenreTag());
		
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
	public void update(TagCategoryVO tagCategoryVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, tagCategoryVO.getGenreTag());
			pstmt.setInt(2, tagCategoryVO.getGenreId());

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
	public TagCategoryVO findByPrimaryKey(Integer genreId) {

		TagCategoryVO tagCategoryVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, genreId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				tagCategoryVO = new TagCategoryVO();
				tagCategoryVO.setGenreId(rs.getInt("genreId"));
				tagCategoryVO.setGenreTag(rs.getString("genreTag"));
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
		return tagCategoryVO;
	}

	@Override
	public List<TagCategoryVO> getAll() {
		List<TagCategoryVO> list = new ArrayList<TagCategoryVO>();
		TagCategoryVO tagCategoryVO = null;

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
				tagCategoryVO = new TagCategoryVO();
				tagCategoryVO.setGenreId(rs.getInt("genreId"));
				tagCategoryVO.setGenreTag(rs.getString("genreTag"));
				list.add(tagCategoryVO); // Store the row in the list
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

		TagCategoryJDBCDAO dao = new TagCategoryJDBCDAO();

		// 新增
//		TagCategoryVO tagCategoryVO1 = new TagCategoryVO();
//		tagCategoryVO1.setGenreTag("10");
//		dao.insert(tagCategoryVO1);
		

//		// 修改
//		TagCategoryVO tagCategoryVO2 = new TagCategoryVO();
//		tagCategoryVO2.setGenreId(90);
//		tagCategoryVO2.setGenreTag("9");
//		dao.update(tagCategoryVO2);

//		// 查詢
//		TagCategoryVO tagCategoryVO3 = dao.findByPrimaryKey(10);
//		System.out.print(tagCategoryVO3.getGenreId() + ",");
//		System.out.println(tagCategoryVO3.getGenreTag() + ",");
//		System.out.println("---------------------");

//		// 查詢
		List<TagCategoryVO> list = dao.getAll();
		for (TagCategoryVO aTagCategory : list) {
			System.out.print(aTagCategory.getGenreId() + ",");
			System.out.print(aTagCategory.getGenreTag());
			
			System.out.println();
		}
	}
}