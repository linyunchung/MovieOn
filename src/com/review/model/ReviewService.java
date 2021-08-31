package com.review.model;

import java.sql.Timestamp;
import java.util.List;


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
}
