package com.ItemTag.model;

import java.util.*;

public interface ItemTagDAO_interface {
          public void insert(ItemTagVO itemTagVO);
          public void update(ItemTagVO itemTagVO);
          public ItemTagVO findByPrimaryKey(Integer itemTagCategoryNumber);
          public List<ItemTagVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
