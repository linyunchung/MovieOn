package com.movie.model;

import java.util.*;

public interface MovieDAO_interface {
          public void insert(MovieVO movieVO);
          public void update(MovieVO movieVO);
          public void delete(Integer empno);
          public MovieVO findByPrimaryKey(Integer movieId);
          public List<MovieVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
