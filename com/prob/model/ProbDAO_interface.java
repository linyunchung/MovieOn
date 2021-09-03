package com.prob.model;

import java.util.*;
public interface ProbDAO_interface {
          public void insert(ProbVO probVO);
          public void update(ProbVO probVO);
          public void delete(Integer probno);
          public List<ProbVO> findByType(String probtype);
          public List<ProbVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
