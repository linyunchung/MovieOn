package com.review.model;

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

public class ReviewDAO implements ReviewDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MOVIEON");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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
	public void insert(ReviewVO reviewVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();	//Step2 建立連線
			pstmt=con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, reviewVO.getUserId());
			pstmt.setInt(2, reviewVO.getMovieId());
			pstmt.setString(3, reviewVO.getReviewTitle());
			pstmt.setDouble(4, reviewVO.getStarRate());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setTimestamp(6, reviewVO.getPostedAt());
			
			pstmt.executeUpdate(); //Step3 送出SQL command
			System.out.println("新增成功");
		} catch(SQLException se) {
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
	public void update(ReviewVO reviewVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();	//Step2 建立連線
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
		} catch(SQLException se) {
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
			con=ds.getConnection();	//Step2 建立連線
			pstmt=con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, reviewId);
			
			pstmt.executeUpdate(); //Step3 送出SQL command
			System.out.println("刪除成功");
		} catch(SQLException se) {
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
			con=ds.getConnection();	//Step2 建立連線
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
		} catch(SQLException se) {
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
			con=ds.getConnection();	//Step2 建立連線
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
		} catch(SQLException se) {
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

}
