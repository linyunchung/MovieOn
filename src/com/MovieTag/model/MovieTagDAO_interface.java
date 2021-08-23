package com.MovieTag.model;

import java.util.*;

import com.movie.model.MovieVO;

public interface MovieTagDAO_interface {
          public void insert(MovieTagVO movieTagVO);
          public void update(MovieTagVO movieTagVO);
          public void delete(Integer empno);
          public MovieTagVO findByMovieId(Integer movieId);
          public List<MovieTagVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
		
}
