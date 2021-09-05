package com.movie.model;

import java.util.List;

public interface MovieDAO_interface {
	 public void insert(MovieVO movieVO);
     public void update(MovieVO movieVO);
     public void delete(Integer empno);
     public MovieVO findByPrimaryKey(Integer movieId);
     public List<MovieVO> getAll();
     public List<MovieVO> getAllByMovieName(String movieName);
	
}
