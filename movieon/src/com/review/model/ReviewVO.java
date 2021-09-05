package com.review.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReviewVO implements Serializable{ //規定用包裝型別的原因是若資料庫規格定義not null, 只適用於物件型態
	@Override
	public String toString() {
		return "ReviewVO [reviewId=" + reviewId + ", userId=" + userId + ", movieId=" + movieId + ", reviewTitle="
				+ reviewTitle + ", starRate=" + starRate + ", review=" + review + ", postedAt=" + postedAt + "]";
	}

	private Integer reviewId;
	private Integer userId;
	private Integer movieId;
	private String reviewTitle;
	private Double starRate;
	private String review;
	private Timestamp postedAt;
	
	public ReviewVO() {}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public Double getStarRate() {
		return starRate;
	}

	public void setStarRate(Double starRate) {
		this.starRate = starRate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Timestamp getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}
}
