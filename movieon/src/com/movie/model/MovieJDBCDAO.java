package com.movie.model;

import java.sql.*;
import java.util.*;

public class MovieJDBCDAO implements MovieDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "4579616593";

	private static final String INSERT_STMT = 
		"INSERT INTO MOVIEON.Movie (movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director, movieTag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT movieId,movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director,movieTag FROM MOVIEON.Movie order by movieId";
	private static final String GET_ONE_STMT = 
		"SELECT movieId,movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director,movieTag FROM MOVIEON.Movie where movieId = ?";
	private static final String UPDATE = 
		"UPDATE MOVIEON.Movie set movieName=?, movieEName=?, releaseDate=?, mins=?, studio=?, plot=?,Poster=?, actor=?, director=?, movieTag=? where movieId = ?";
	private static final String DELETE = 
			"DELETE FROM MOVIEON.Movie where movieId = ?";
	private static final String GET_ALL_BY_NAME = 
			"SELECT * FROM MOVIEON.Movie where movieName like ?";
	
	@Override
	public void insert(MovieVO movieVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, movieVO.getMovieName());
			pstmt.setString(2, movieVO.getMovieEName());
			pstmt.setDate(3, movieVO.getReleaseDate());
			pstmt.setInt(4, movieVO.getMins());
			pstmt.setString(5, movieVO.getStudio());
			pstmt.setString(6, movieVO.getPlot());
			pstmt.setBytes(7, movieVO.getPoster());
			pstmt.setString(8, movieVO.getActor());
			pstmt.setString(9, movieVO.getDirector());
			pstmt.setString(10, movieVO.getMovieTag());

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
	public void update(MovieVO movieVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, movieVO.getMovieName());
			pstmt.setString(2, movieVO.getMovieEName());
			pstmt.setDate(3, movieVO.getReleaseDate());
			pstmt.setInt(4, movieVO.getMins());
			pstmt.setString(5, movieVO.getStudio());
			pstmt.setString(6, movieVO.getPlot());
			pstmt.setBytes(7, movieVO.getPoster());			
			pstmt.setString(8, movieVO.getActor());
			pstmt.setString(9, movieVO.getDirector());
			pstmt.setString(10, movieVO.getMovieTag());
			pstmt.setInt(11, movieVO.getMovieId());

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
	public void delete(Integer movieId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, movieId);

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
	public MovieVO findByPrimaryKey(Integer movieId) {

		MovieVO movieVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, movieId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				movieVO = new MovieVO();
				movieVO.setMovieId(rs.getInt("movieId"));
				movieVO.setMovieName(rs.getString("movieName"));
				movieVO.setMovieEName(rs.getString("movieEName"));
				movieVO.setReleaseDate(rs.getDate("releaseDate"));
				movieVO.setMins(rs.getInt("mins"));
				movieVO.setStudio(rs.getString("studio"));
				movieVO.setPlot(rs.getString("plot"));
				movieVO.setPoster(rs.getBytes("poster"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
				movieVO.setMovieTag(rs.getString("movieTag"));
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
		return movieVO;
	}

	@Override
	public List<MovieVO> getAll() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieVO movieVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				movieVO = new MovieVO();
				movieVO.setMovieId(rs.getInt("movieId"));
				movieVO.setMovieName(rs.getString("movieName"));
				movieVO.setMovieEName(rs.getString("movieEName"));
				movieVO.setReleaseDate(rs.getDate("releaseDate"));
				movieVO.setMins(rs.getInt("mins"));
				movieVO.setStudio(rs.getString("studio"));
				movieVO.setPlot(rs.getString("plot"));
				movieVO.setPoster(rs.getBytes("poster"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
				movieVO.setMovieTag(rs.getString("movieTag"));
				list.add(movieVO); // Store the row in the list
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
	

	
	@Override
	public List<MovieVO> getAllByMovieName(String movieName) {
		List<MovieVO> list1 = new ArrayList<MovieVO>();
		MovieVO movieVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_BY_NAME);
			
	
			pstmt.setString(1, "%" +movieName+ "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				movieVO = new MovieVO();
				movieVO.setMovieId(rs.getInt("movieId"));
				movieVO.setMovieName(rs.getString("movieName"));
				movieVO.setMovieEName(rs.getString("movieEName"));
				movieVO.setReleaseDate(rs.getDate("releaseDate"));
				movieVO.setMins(rs.getInt("mins"));
				movieVO.setStudio(rs.getString("studio"));
				movieVO.setPlot(rs.getString("plot"));
				movieVO.setPoster(rs.getBytes("poster"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
				movieVO.setMovieTag(rs.getString("movieTag"));
				list1.add(movieVO); // Store the row in the list
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
		return list1;
	}

	public static void main(String[] args) {

		MovieJDBCDAO dao = new MovieJDBCDAO();

		// ?s?W
//		MovieVO movieVO1 = new MovieVO();
//		movieVO1.setMovieName("?O?L?_??");
//		movieVO1.setMovieEName("Jungle Cruise");
//		movieVO1.setReleaseDate(java.sql.Date.valueOf("2021-07-30"));
//		movieVO1.setMins(java.sql.Time.valueOf("02:07:00"));
//		movieVO1.setStudio("???S?}?h???u?@???q?v");
//		movieVO1.setPlot("?G???y?z?@???W?s?N?y???h?]???e?????? ???t?^?o?{?F?`???b?????????A?????@???????v?????O???_???????A???n???o?o?????????O?A?????a???@???Q?H?????????u???_?b?Y?v?????}???A?N?y???h?M?w?n?`?J?O?L?A???@???o?????????s???A?o?????F?@???????i?a?A???????O???u?Q?B?F?C?????????????????X?k???J?????]?????j?? ???t?^?A?o?????k???J???????v?P?????]???J?h?S?N?? ???t?^?e???O?L?i?}?o?????}?????????????????{?C....");
//		movieVO1.setPoster(null);
//		movieVO1.setActor("?????j???B?R?e???P?????B???J?P?h?S?????B?????P?????????B?????P?????X?B?O???P?N????");
//		movieVO1.setDirector("?????P?F???S-????");
//		dao.insert(movieVO1);
		

//		// ????
//		MovieVO movieVO2 = new MovieVO();
//		movieVO2.setMovieId(1005);
//		movieVO2.setMovieName("???R???Y9");
//		movieVO2.setMovieEName("Fast & Furious 9");
//		movieVO2.setReleaseDate(java.sql.Date.valueOf("2021-08-11"));
//		movieVO2.setMins(java.sql.Time.valueOf("02:23:00"));
//		movieVO2.setStudio("???y?v?~");
//		movieVO2.setPlot("1989?~?A???J?P???????b?@?????????????D?J?????A???l???M?????A?Q???????????_???A???????`?A?b???????????????l???U?M???i???J???????@?L?X?????????C.....");
//		movieVO2.setPoster(null);
//		movieVO2.setActor("???P?}???B?e?????P???w??????\r\n?B???????P?N?????B???F?J?????B?????P???n?B?????R?P???|???S?B?R?????P?????????B???????B?????P?????B?F?S?P?????B?????P????");
//		movieVO2.setDirector("?L???l");
//		dao.update(movieVO2);
		
		// ?R??
//				dao.delete(1005);
//
//		// ?d??
//		MovieVO movieVO3 = dao.findByPrimaryKey(1001);
//		System.out.print(movieVO3.getMovieId() + ",");
//		System.out.print(movieVO3.getMovieName() + ",");
//		System.out.print(movieVO3.getMovieEName() + ",");
//		System.out.println(movieVO3.getReleaseDate() + ",");
//		System.out.println(movieVO3.getMins() + ",");
//		System.out.println(movieVO3.getStudio() + ",");
//		System.out.println(movieVO3.getPlot() + ",");
//		System.out.println(movieVO3.getPoster() + ",");
//		System.out.println(movieVO3.getActor() +",");
//		System.out.println(movieVO3.getDirector());
//		System.out.println("---------------------");

//		// ?d??
//		List<MovieVO> list = dao.getAll();
//		for (MovieVO aMovie : list) {
//			System.out.print(aMovie.getMovieId() + ",");
//			System.out.print(aMovie.getMovieName() + ",");
//			System.out.print(aMovie.getMovieEName() + ",");
//			System.out.println(aMovie.getReleaseDate() + ",");
//			System.out.println(aMovie.getMins() + ",");
//			System.out.println(aMovie.getStudio() + ",");
//			System.out.println(aMovie.getPlot() + ",");
//			System.out.println(aMovie.getPoster() + ",");
//			System.out.println(aMovie.getActor() +",");
//			System.out.println(aMovie.getDirector());
//			System.out.println("----------------");
//		}
		
		
		// ?d???W?r
				List<MovieVO> list1 = dao.getAllByMovieName("??");
				for (MovieVO aMovie1 : list1) {
					System.out.print(aMovie1.getMovieId() + ",");
					System.out.print(aMovie1.getMovieName() + ",");
					System.out.print(aMovie1.getMovieEName() + ",");
					System.out.println(aMovie1.getReleaseDate() + ",");
					System.out.println(aMovie1.getMins() + ",");
					System.out.println(aMovie1.getStudio() + ",");
					System.out.println(aMovie1.getPlot() + ",");
					System.out.println(aMovie1.getPoster() + ",");
					System.out.println(aMovie1.getActor() +",");
					System.out.println(aMovie1.getDirector());
					System.out.println(aMovie1.getMovieTag());
					System.out.println("----------------");
				}
	}

	
}
