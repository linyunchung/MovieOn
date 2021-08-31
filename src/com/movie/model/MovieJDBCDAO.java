package com.movie.model;

import java.util.*;

import oracle.net.aso.p;

import java.sql.*;

public class MovieJDBCDAO implements MovieDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO Movie (movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT movieId,movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director FROM Movie order by movieId";
	private static final String GET_ONE_STMT = 
		"SELECT movieId,movieName,movieEName,releaseDate,mins,studio,plot,poster,actor,director FROM Movie where movieId = ?";
	private static final String UPDATE = 
		"UPDATE Movie set movieName=?, movieEName=?, releaseDate=?, mins=?, studio=?, plot=?, poster=?, actor=?, director=? where movieId = ?";
	private static final String DELETE = 
			"DELETE FROM Movie where movieId = ?";
	
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
			pstmt.setBlob(7, movieVO.getPoster());
			pstmt.setString(8, movieVO.getActor());
			pstmt.setString(9, movieVO.getDirector());

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
			pstmt.setBlob(7, movieVO.getPoster());
			pstmt.setString(8, movieVO.getActor());
			pstmt.setString(9, movieVO.getDirector());
			pstmt.setInt(10, movieVO.getMovieId());

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
				movieVO.setPoster(rs.getBlob("poster"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
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
				movieVO.setPoster(rs.getBlob("poster"));
				movieVO.setActor(rs.getString("actor"));
				movieVO.setDirector(rs.getString("director"));
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

	public static void main(String[] args) {

		MovieJDBCDAO dao = new MovieJDBCDAO();

		// 新增
//		MovieVO movieVO1 = new MovieVO();
//		movieVO1.setMovieName("叢林奇航");
//		movieVO1.setMovieEName("Jungle Cruise");
//		movieVO1.setReleaseDate(java.sql.Date.valueOf("2021-07-30"));
//		movieVO1.setMins(java.sql.Time.valueOf("02:07:00"));
//		movieVO1.setStudio("華特迪士尼工作室電影");
//		movieVO1.setPlot("故事描述一位名叫霍頓博士（艾蜜莉布朗 飾演）發現了深藏在亞馬遜裡，有著一顆擁有治癒神力的奇幻之樹，而要取得這棵樹的神力，必須帶著一個被人類收藏的「神奇箭頭」來解開它，霍頓博士決定要深入叢林，來一探這個傳說的究竟，她找來了一個看似可靠，但其實是個只想詐騙遊客的狡猾渡輪船長—法蘭克船長（巨石強森 飾演），她雇用法蘭克載著自己與弟弟（傑克懷特霍爾 飾演）前往叢林展開這場解開神秘傳說之謎的旅程。....");
//		movieVO1.setPoster(null);
//		movieVO1.setActor("巨石強森、愛蜜莉·布朗、傑克·懷特豪爾、艾格·拉米瑞茲、傑西·普萊蒙、保羅·吉馬蒂");
//		movieVO1.setDirector("豪梅·寇勒特-瑟拉");
//		dao.insert(movieVO1);
		

//		// 修改
//		MovieVO movieVO2 = new MovieVO();
//		movieVO2.setMovieId(1005);
//		movieVO2.setMovieName("玩命關頭9");
//		movieVO2.setMovieEName("Fast & Furious 9");
//		movieVO2.setReleaseDate(java.sql.Date.valueOf("2021-08-11"));
//		movieVO2.setMins(java.sql.Time.valueOf("02:23:00"));
//		movieVO2.setStudio("環球影業");
//		movieVO2.setPlot("1989年，傑克·泰瑞托在一場賽車比賽中遭遇車禍，車子突然失控，被對手撞飛後起火，不幸身亡，在旁輔佐的兩個兒子雅各和唐姆尼克親眼目睹他出事的瞬間。.....");
//		movieVO2.setPoster(null);
//		movieVO2.setActor("馮·迪索、蜜雪兒·羅德里奎茲\r\n、泰瑞斯·吉布森、路達克里斯、約翰·希南、喬丹娜·布魯斯特、娜塔莉·伊曼紐爾、姜成鎬、海倫·米蘭、寇特·羅素、莎莉·賽隆");
//		movieVO2.setDirector("林詣彬");
//		dao.update(movieVO2);
		
		// 刪除
//				dao.delete(1005);
//
//		// 查詢
		MovieVO movieVO3 = dao.findByPrimaryKey(1001);
		System.out.print(movieVO3.getMovieId() + ",");
		System.out.print(movieVO3.getMovieName() + ",");
		System.out.print(movieVO3.getMovieEName() + ",");
		System.out.println(movieVO3.getReleaseDate() + ",");
		System.out.println(movieVO3.getMins() + ",");
		System.out.println(movieVO3.getStudio() + ",");
		System.out.println(movieVO3.getPlot() + ",");
		System.out.println(movieVO3.getPoster() + ",");
		System.out.println(movieVO3.getActor() +",");
		System.out.println(movieVO3.getDirector());
		System.out.println("---------------------");

//		// 查詢
		List<MovieVO> list = dao.getAll();
		for (MovieVO aMovie : list) {
			System.out.print(aMovie.getMovieId() + ",");
			System.out.print(aMovie.getMovieName() + ",");
			System.out.print(aMovie.getMovieEName() + ",");
			System.out.println(aMovie.getReleaseDate() + ",");
			System.out.println(aMovie.getMins() + ",");
			System.out.println(aMovie.getStudio() + ",");
			System.out.println(aMovie.getPlot() + ",");
			System.out.println(aMovie.getPoster() + ",");
			System.out.println(aMovie.getActor() +",");
			System.out.println(aMovie.getDirector());
			System.out.println("----------------");
		}
	}
}