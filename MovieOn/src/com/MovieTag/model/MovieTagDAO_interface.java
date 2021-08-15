package com.MovieTag.model;

import java.util.*;

public interface MovieTagDAO_interface {
          public void insert(MovieTagVO movieTagVO);
          public void update(MovieTagVO movieTagVO);
          public void delete(Integer empno);
          public MovieTagVO findByPrimaryKey(Integer tagId);
          public List<MovieTagVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
