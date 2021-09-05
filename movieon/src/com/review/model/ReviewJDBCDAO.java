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
			Class.forName(DRIVER);	//Step1 載入驅動
			System.out.println("載入驅動成功");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 建立連線
			pstmt=con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, reviewVO.getUserId());
			pstmt.setInt(2, reviewVO.getMovieId());
			pstmt.setString(3, reviewVO.getReviewTitle());
			pstmt.setDouble(4, reviewVO.getStarRate());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setTimestamp(6, reviewVO.getPostedAt());
			
			pstmt.executeUpdate(); //Step3 送出SQL command
			System.out.println("新增成功");
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
			Class.forName(DRIVER);	//Step1 載入驅動
			System.out.println("載入驅動成功");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 建立連線
			pstmt=con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, reviewVO.getUserId());
			pstmt.setInt(2, reviewVO.getMovieId());
			pstmt.setString(3, reviewVO.getReviewTitle());
			pstmt.setDouble(4, reviewVO.getStarRate());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setTimestamp(6, reviewVO.getPostedAt());
			pstmt.setInt(7, reviewVO.getReviewId());
			
			pstmt.executeUpdate(); //Step3 送出SQL command
			System.out.println("更新成功");
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
			Class.forName(DRIVER);	//Step1 載入驅動
			System.out.println("載入驅動成功");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 建立連線
			pstmt=con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, reviewId);
			
			pstmt.executeUpdate(); //Step3 送出SQL command
			System.out.println("刪除成功");
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
			Class.forName(DRIVER);	//Step1 載入驅動
			System.out.println("載入驅動成功");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 建立連線
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
			Class.forName(DRIVER);	//Step1 載入驅動
			System.out.println("載入驅動成功");
			con=DriverManager.getConnection(URL,USERID,PWD);	//Step2 建立連線
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
		//新增
		ReviewVO reviewVO_insert = new ReviewVO();
		reviewVO_insert.setUserId(1);
		reviewVO_insert.setMovieId(1001);
		reviewVO_insert.setReviewTitle("【無雷影評】《惡靈古堡6：最終章》博士，又是你？？");
		reviewVO_insert.setStarRate(5.0);
		reviewVO_insert.setReview("首先，我非常喜歡這部電影，以系列電影的結尾來說，《惡靈古堡6：最終章》表現得很不錯。相較在惡靈古堡前五集中，大多都在製造問題，觀眾以為已經越來越接近真相時，又給我們眼前蒙上一層霧，配角們也會無緣無故的失蹤，而且Alice常在各集的結尾遇到一個很大的危機，到了下一集卻草草的交代過去。雖然這集好像也有這種情形，但是這次《最終章》大概真的是最終章了。(不過大家都知道，哪天想再出來賺一筆還是有可能的)");
		reviewVO_insert.setPostedAt(Timestamp.valueOf("2020-01-26 10:10:10"));
		
		dao.insert(reviewVO_insert);
		*/
		
		//修改
		/*
		ReviewVO reviewVO_update = new ReviewVO();
		
		reviewVO_update.setReviewId(11);
		reviewVO_update.setUserId(1);
		reviewVO_update.setMovieId(1001);
		reviewVO_update.setReviewTitle("《惡靈古堡6：最終章》博士，又是你？？");
		reviewVO_update.setStarRate(4.5);
		reviewVO_update.setReview("首先，我非常喜歡這部電影，以系列電影的結尾來說，《惡靈古堡6：最終章》表現得很不錯。相較在惡靈古堡前五集中，大多都在製造問題，觀眾以為已經越來越接近真相時，又給我們眼前蒙上一層霧，配角們也會無緣無故的失蹤，而且Alice常在各集的結尾遇到一個很大的危機，到了下一集卻草草的交代過去。雖然這集好像也有這種情形，但是這次《最終章》大概真的是最終章了。(不過大家都知道，哪天想再出來賺一筆還是有可能的)");
		reviewVO_update.setPostedAt(Timestamp.valueOf("2021-08-01 00:00:00"));
		dao.update(reviewVO_update);
		*/
		
		//刪除
		//dao.delete(11);
		
		//查詢
		
		ReviewVO reviewVO_find_One =dao.findByPrimaryKey(1); //傳回ReviewVO object, 透過該object來操作getter/setter方法
		System.out.print(reviewVO_find_One.getReviewId()+", ");
		System.out.print(reviewVO_find_One.getUserId()+", ");
		System.out.print(reviewVO_find_One.getMovieId()+", ");
		System.out.print(reviewVO_find_One.getReviewTitle()+", ");
		System.out.print(reviewVO_find_One.getStarRate()+", ");
		System.out.print(reviewVO_find_One.getReview()+", ");
		System.out.println(reviewVO_find_One.getPostedAt());
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		
		//查詢全部
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
