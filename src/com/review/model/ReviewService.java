package com.review.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.List;

import com.movie.model.MovieService;


public class ReviewService {
	private ReviewDAO_interface dao;
	
	public ReviewService() {
		dao=new ReviewDAO();
	}
	
	
	public ReviewVO updateReview(Integer reviewId, Integer userId, Integer movieId,
			String reviewTitle, Double starRate, String review, Timestamp postedAt) {
		ReviewVO reviewVO = new ReviewVO();
		
		reviewVO.setReviewId(reviewId);
		reviewVO.setUserId(userId);
		reviewVO.setMovieId(movieId);
		reviewVO.setReviewTitle(reviewTitle);
		reviewVO.setStarRate(starRate);
		reviewVO.setReview(review);
		reviewVO.setPostedAt(postedAt);
		
		dao.update(reviewVO);
		
		return reviewVO;
	}
	
	public void deleteReview(Integer reviewId) {
		dao.delete(reviewId);
	}
	
	public ReviewVO getOneReview(Integer reviewId) {
		return dao.findByPrimaryKey(reviewId);
	}
	
	public List<ReviewVO> getAll() {
		return dao.getAll();
	}
	
	public ReviewVO addReview(Integer userId, Integer movieId, String reviewTitle, Double starRate, String review, Timestamp postedAt) {

		  ReviewVO reviewVO = new ReviewVO();
		  
		  reviewVO.setUserId(userId);
		  reviewVO.setMovieId(movieId);
		  reviewVO.setReviewTitle(reviewTitle);
		  reviewVO.setStarRate(starRate);
		  reviewVO.setReview(review);
		  reviewVO.setPostedAt(postedAt);

		  dao.insert(reviewVO);
		  return reviewVO;
		 }
	
	public List<ReviewVO> getUserReview(Integer userId) {
		return dao.getAllByUser(userId);
	}
	
	public int userReviewCount(Integer userId) {		
		int result = dao.getAllByUser(userId).size();
		return result;
	}
	
	public int userReviewCountThisYear(Integer userId) {
		
		String currentyear = Year.now().toString();
		int result = 0;
		
		List<ReviewVO> allbyuser = dao.getAllByUser(userId);
		for(ReviewVO review : allbyuser) {
			if(currentyear.equals(review.getPostedAt().toString().substring(0,4))){
				result+=1;
			}
		}
		return result;
		
	}
	
	public String getMonthDate(Timestamp timestamp) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd");  
		String monthDate = formatter.format(timestamp);
		return monthDate;
	}
	
	public String getYearMonthDate(Timestamp timestamp) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");  
		String yearMonthDate = formatter.format(timestamp);
		return yearMonthDate;
	}
	
	public String getReleaseYear(ReviewVO reviewVO) {
		MovieService movieSvc = new MovieService();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
		return formatter.format((movieSvc.getOneMovie(reviewVO.getMovieId()).getReleaseDate()));
	}
	
	public List<ReviewVO> getFriendsActivity(int sourceId) {
		
		return dao.getFriendsActivity(sourceId);
	}
}
