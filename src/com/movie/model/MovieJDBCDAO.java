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

		// �s�W
//		MovieVO movieVO1 = new MovieVO();
//		movieVO1.setMovieName("�O�L�_��");
//		movieVO1.setMovieEName("Jungle Cruise");
//		movieVO1.setReleaseDate(java.sql.Date.valueOf("2021-07-30"));
//		movieVO1.setMins(java.sql.Time.valueOf("02:07:00"));
//		movieVO1.setStudio("�دS�}�h���u�@�ǹq�v");
//		movieVO1.setPlot("�G�ƴy�z�@��W�s�N�y�դh�]��e������ ���t�^�o�{�F�`�æb�Ȱ����̡A���ۤ@���֦��v¡���O���_�ۤ���A�ӭn���o�o�ʾ𪺯��O�A�����a�ۤ@�ӳQ�H�����ê��u���_�b�Y�v�ӸѶ}���A�N�y�դh�M�w�n�`�J�O�L�A�Ӥ@���o�Ӷǻ����s���A�o��ӤF�@�Ӭݦ��i�a�A�����O�ӥu�Q�B�F�C�Ȫ�����������X�k���J����]���۱j�� ���t�^�A�o���Ϊk���J���ۦۤv�P�̧̡]�ǧJ�h�S�N�� ���t�^�e���O�L�i�}�o���Ѷ}�����ǻ��������ȵ{�C....");
//		movieVO1.setPoster(null);
//		movieVO1.setActor("���۱j�ˡB�R�e���P���ԡB�ǧJ�P�h�S�����B���P�Ԧ̷���B�Ǧ�P���ܻX�B�Où�P�N����");
//		movieVO1.setDirector("�����P�F�ǯS-���");
//		dao.insert(movieVO1);
		

//		// �ק�
//		MovieVO movieVO2 = new MovieVO();
//		movieVO2.setMovieId(1005);
//		movieVO2.setMovieName("���R���Y9");
//		movieVO2.setMovieEName("Fast & Furious 9");
//		movieVO2.setReleaseDate(java.sql.Date.valueOf("2021-08-11"));
//		movieVO2.setMins(java.sql.Time.valueOf("02:23:00"));
//		movieVO2.setStudio("���y�v�~");
//		movieVO2.setPlot("1989�~�A�ǧJ�P���禫�b�@���ɨ����ɤ��D�J���סA���l��M�����A�Q��⼲����_���A�������`�A�b�ǻ�������Ө�l���U�M��i���J�˲��ظ@�L�X�ƪ������C.....");
//		movieVO2.setPoster(null);
//		movieVO2.setActor("���P�}���B�e����Pù�w������\r\n�B���紵�P�N���ˡB���F�J�����B�����P�ƫn�B�줦�R�P���|���S�B�R����P��үú��B������B���ۡP�����B�F�S�Pù���B����P�ɶ�");
//		movieVO2.setDirector("�L�ڱl");
//		dao.update(movieVO2);
		
		// �R��
//				dao.delete(1005);
//
//		// �d��
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

//		// �d��
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