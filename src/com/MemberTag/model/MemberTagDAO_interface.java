package com.MemberTag.model;

import java.util.*;

public interface MemberTagDAO_interface {
          public void insert(MemberTagVO memberTagVO);
          public void update(MemberTagVO memberTagVO);
          public void delete(Integer empno);
          public MemberTagVO findByPrimaryKey(Integer tagId);
          public List<MemberTagVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
