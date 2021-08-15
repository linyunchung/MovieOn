package com.MovieTag.model;

import java.util.*;

import oracle.net.aso.p;

import java.sql.*;

public class MovieTagJDBCDAO implements MovieTagDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO MovieTag (movieId, genreId) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT tagId,movieId,genreId FROM MovieTag order by tagId";
	private static final String GET_ONE_STMT = 
		"SELECT tagId,movieId,genreId FROM MovieTag where tagId = ?";
	private static final String UPDATE = 
		"UPDATE MovieTag set movieId=?,genreId=? where tagId = ?";
	private static final String DELETE = 
			"DELETE FROM MovieTag where tagId = ?";
	

	@Override
	public void insert(MovieTagVO movieTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, movieTagVO.getMovieId());
			pstmt.setInt(2, movieTagVO.getGenreId());
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
	public void update(MovieTagVO movieTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, movieTagVO.getMovieId());
			pstmt.setInt(2, movieTagVO.getGenreId());
			pstmt.setInt(3, movieTagVO.getTagId());
		
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
	public MovieTagVO findByPrimaryKey(Integer tagId) {

		MovieTagVO movieTagVO = null;
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
				
				movieTagVO = new MovieTagVO();
				movieTagVO.setTagId(rs.getInt("tagId"));
				movieTagVO.setMovieId(rs.getInt("movieId"));
				movieTagVO.setGenreId(rs.getInt("genreId"));
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
		return movieTagVO;
	}

	@Override
	public List<MovieTagVO> getAll() {
		List<MovieTagVO> list = new ArrayList<MovieTagVO>();
		MovieTagVO movieTagVO = null;

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
				movieTagVO = new MovieTagVO();
				movieTagVO.setTagId(rs.getInt("tagId"));
				movieTagVO.setMovieId(rs.getInt("movieId"));
				movieTagVO.setGenreId(rs.getInt("genreId"));
				list.add(movieTagVO); // Store the row in the list
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

		MovieTagJDBCDAO dao = new MovieTagJDBCDAO();

		// 新增
//		MovieTagVO movieTagVO1 = new MovieTagVO();
//		movieTagVO1.setMovieId(1004);
//		movieTagVO1.setGenreId(50);
//		dao.insert(movieTagVO1);
		

//		// 修改
//		MovieTagVO movieTagVO2 = new MovieTagVO();
//		movieTagVO2.setTagId(2008);
//		movieTagVO2.setMovieId(1005);
//		movieTagVO2.setGenreId(10);
//		dao.update(movieTagVO2);
		
		// 刪除
//				dao.delete(2007);
//
//		// 查詢
//		MovieTagVO movieTagVO3 = dao.findByPrimaryKey(2002);
//		System.out.print(movieTagVO3.getTagId() + ",");
//		System.out.print(movieTagVO3.getMovieId() + ",");
//		System.out.println(movieTagVO3.getGenreId());
//		System.out.println("---------------------");

//		// 查詢
		List<MovieTagVO> list = dao.getAll();
		for (MovieTagVO aMovieTag : list) {
			System.out.print(aMovieTag.getTagId() + ",");
			System.out.print(aMovieTag.getMovieId() + ",");
			System.out.println(aMovieTag.getGenreId());
			
			System.out.println("-----------------------");
		}
	}
}