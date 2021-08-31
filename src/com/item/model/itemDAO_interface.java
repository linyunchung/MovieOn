package com.item.model;

import java.util.*;

public interface itemDAO_interface {
          public void insert(itemVO itemVO);
          public void update(itemVO itemVO);
          public void delete(Integer empno);
          public itemVO findByPrimaryKey(Integer itemId);
          public List<itemVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
