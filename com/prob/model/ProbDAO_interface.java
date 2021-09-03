package com.prob.model;

import java.util.*;
public interface ProbDAO_interface {
          public void insert(ProbVO probVO);
          public void update(ProbVO probVO);
          public void delete(Integer probno);
          public List<ProbVO> findByType(String probtype);
          public List<ProbVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
