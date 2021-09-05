package com.review.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewJDBCDAO implements ReviewDAO_interface{
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL="jdbc:mysql://35.201.252.250/MOVIEON?serverTimezone=Asia/Taipei";
	public static final String USERID="root";
	public static final String PWD="4579616593";
	
	public static final String INSERT_STMT=
			"insert into MOVIEREVIEW (userId, movieId, reviewTitle, starRate, review, postedAt) values (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_STMT=
			"update MOVIEREVIEW set userId=?, movieId=?, reviewTitle=?, starRate=?, review=? ,postedAt=? where reviewId = ?";
	public static final String DELETE_STMT=
			"delete from MOVIEREVIEW where reviewId = ?";
	public static final String GET_ONE_STMT=
			"select reviewId, userId, movieId, reviewTitle, starRate, review, postedAt from MOVIEREVIEW where reviewId = ?";
	public static final String GET_ALL_STMT=
			"select reviewId, userId, movieId, reviewTitle, starRate, review, postedAt from MOVIEREVIEW";
	
	
	@Override
	public void insert(ReviewVO reviewVO) {	// add a record
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(DRIVER);	//Step1 ���J�X��
			System.out.println("���J�X�ʦ��\");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 �إ߳s�u
			pstmt=con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, reviewVO.getUserId());
			pstmt.setInt(2, reviewVO.getMovieId());
			pstmt.setString(3, reviewVO.getReviewTitle());
			pstmt.setDouble(4, reviewVO.getStarRate());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setTimestamp(6, reviewVO.getPostedAt());
			
			pstmt.executeUpdate(); //Step3 �e�XSQL command
			System.out.println("�s�W���\");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(ReviewVO reviewVO) { //update a record
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(DRIVER);	//Step1 ���J�X��
			System.out.println("���J�X�ʦ��\");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 �إ߳s�u
			pstmt=con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, reviewVO.getUserId());
			pstmt.setInt(2, reviewVO.getMovieId());
			pstmt.setString(3, reviewVO.getReviewTitle());
			pstmt.setDouble(4, reviewVO.getStarRate());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setTimestamp(6, reviewVO.getPostedAt());
			pstmt.setInt(7, reviewVO.getReviewId());
			
			pstmt.executeUpdate(); //Step3 �e�XSQL command
			System.out.println("��s���\");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer reviewId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(DRIVER);	//Step1 ���J�X��
			System.out.println("���J�X�ʦ��\");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 �إ߳s�u
			pstmt=con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, reviewId);
			
			pstmt.executeUpdate(); //Step3 �e�XSQL command
			System.out.println("�R�����\");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public ReviewVO findByPrimaryKey(Integer reviewId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReviewVO reviewVO=null;
		try {
			Class.forName(DRIVER);	//Step1 ���J�X��
			System.out.println("���J�X�ʦ��\");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 �إ߳s�u
			pstmt=con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, reviewId);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				reviewVO=new ReviewVO();
				reviewVO.setReviewId(rs.getInt("reviewId"));
				reviewVO.setUserId(rs.getInt("userId"));
				reviewVO.setMovieId(rs.getInt("movieId"));
				reviewVO.setReviewTitle(rs.getString("reviewTitle"));
				reviewVO.setStarRate(rs.getDouble("starRate"));
				reviewVO.setReview(rs.getString("review"));
				reviewVO.setPostedAt(rs.getTimestamp("postedAt"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return reviewVO;
	}

	@Override
	public List<ReviewVO> getAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReviewVO reviewVO=null;
		List<ReviewVO> list=new ArrayList();
		try {
			Class.forName(DRIVER);	//Step1 ���J�X��
			System.out.println("���J�X�ʦ��\");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 �إ߳s�u
			pstmt=con.prepareStatement(GET_ALL_STMT);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				reviewVO=new ReviewVO();
				reviewVO.setReviewId(rs.getInt("reviewId"));
				reviewVO.setUserId(rs.getInt("userId"));
				reviewVO.setMovieId(rs.getInt("movieId"));
				reviewVO.setReviewTitle(rs.getString("reviewTitle"));
				reviewVO.setStarRate(rs.getDouble("starRate"));
				reviewVO.setReview(rs.getString("review"));
				reviewVO.setPostedAt(rs.getTimestamp("postedAt"));
				list.add(reviewVO);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		ReviewJDBCDAO dao=new ReviewJDBCDAO();
		
		/*
		//�s�W
		ReviewVO reviewVO_insert = new ReviewVO();
		reviewVO_insert.setUserId(1);
		reviewVO_insert.setMovieId(1001);
		reviewVO_insert.setReviewTitle("�i�L�p�v���j�m�c�F�j��6�G�̲׳��n�դh�A�S�O�A�H�H");
		reviewVO_insert.setStarRate(5.0);
		reviewVO_insert.setReview("�����A�ګD�`���w�o���q�v�A�H�t�C�q�v�������ӻ��A�m�c�F�j��6�G�̲׳��n��{�o�ܤ����C�۸��b�c�F�j���e�������A�j�h���b�s�y���D�A�[���H���w�g�V�ӶV����u�ۮɡA�S���ڭ̲��e�X�W�@�h���A�t���̤]�|�L�t�L�G�����ܡA�ӥBAlice�`�b�U���������J��@�ӫܤj���M���A��F�U�@���o��󪺥�N�L�h�C���M�o���n���]���o�ر��ΡA���O�o���m�̲׳��n�j���u���O�̲׳��F�C(���L�j�a�����D�A���ѷQ�A�X���Ȥ@���٬O���i�઺)");
		reviewVO_insert.setPostedAt(Timestamp.valueOf("2020-01-26 10:10:10"));
		
		dao.insert(reviewVO_insert);
		*/
		
		//�ק�
		/*
		ReviewVO reviewVO_update = new ReviewVO();
		
		reviewVO_update.setReviewId(11);
		reviewVO_update.setUserId(1);
		reviewVO_update.setMovieId(1001);
		reviewVO_update.setReviewTitle("�m�c�F�j��6�G�̲׳��n�դh�A�S�O�A�H�H");
		reviewVO_update.setStarRate(4.5);
		reviewVO_update.setReview("�����A�ګD�`���w�o���q�v�A�H�t�C�q�v�������ӻ��A�m�c�F�j��6�G�̲׳��n��{�o�ܤ����C�۸��b�c�F�j���e�������A�j�h���b�s�y���D�A�[���H���w�g�V�ӶV����u�ۮɡA�S���ڭ̲��e�X�W�@�h���A�t���̤]�|�L�t�L�G�����ܡA�ӥBAlice�`�b�U���������J��@�ӫܤj���M���A��F�U�@���o��󪺥�N�L�h�C���M�o���n���]���o�ر��ΡA���O�o���m�̲׳��n�j���u���O�̲׳��F�C(���L�j�a�����D�A���ѷQ�A�X���Ȥ@���٬O���i�઺)");
		reviewVO_update.setPostedAt(Timestamp.valueOf("2021-08-01 00:00:00"));
		dao.update(reviewVO_update);
		*/
		
		//�R��
		//dao.delete(11);
		
		//�d��
		
		ReviewVO reviewVO_find_One =dao.findByPrimaryKey(1); //�Ǧ^ReviewVO object, �z�L��object�Ӿާ@getter/setter��k
		System.out.print(reviewVO_find_One.getReviewId()+", ");
		System.out.print(reviewVO_find_One.getUserId()+", ");
		System.out.print(reviewVO_find_One.getMovieId()+", ");
		System.out.print(reviewVO_find_One.getReviewTitle()+", ");
		System.out.print(reviewVO_find_One.getStarRate()+", ");
		System.out.print(reviewVO_find_One.getReview()+", ");
		System.out.println(reviewVO_find_One.getPostedAt());
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		
		//�d�ߥ���
		List<ReviewVO> list = dao.getAll();
		for(ReviewVO review: list) {
			System.out.println(review.getReviewId());
			System.out.println(review.getUserId());
			System.out.println(review.getMovieId());
			System.out.println(review.getReviewTitle());
			System.out.println(review.getReview());
			System.out.println(review.getStarRate());
			System.out.println(review.getPostedAt());
		}
	}

	@Override
	public List<ReviewVO> getAllByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewVO> getFriendsActivity(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
