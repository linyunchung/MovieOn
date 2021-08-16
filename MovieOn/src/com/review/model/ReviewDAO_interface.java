package com.review.model;

import java.util.List;

public interface ReviewDAO_interface { 
	public void insert(ReviewVO reviewVO);
	public void update(ReviewVO reviewVO);
	public void delete(Integer reviewId); //依primary key刪除指定的record
	public ReviewVO findByPrimaryKey(Integer reviewId); //傳回指定的ReviewVO物件
	public List<ReviewVO> getAll();
}
