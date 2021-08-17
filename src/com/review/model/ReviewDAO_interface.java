package com.review.model;

import java.util.List;

public interface ReviewDAO_interface { 
	public void insert(ReviewVO reviewVO);
	public void update(ReviewVO reviewVO);
	public void delete(Integer reviewId); //��primary key�R�����w��record
	public ReviewVO findByPrimaryKey(Integer reviewId); //�Ǧ^���w��ReviewVO����
	public List<ReviewVO> getAll();
}
