package com.movie.model;

import java.util.*;

public interface MovieDAO_interface {
          public void insert(MovieVO movieVO);
          public void update(MovieVO movieVO);
          public void delete(Integer empno);
          public MovieVO findByPrimaryKey(Integer movieId);
          public List<MovieVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
