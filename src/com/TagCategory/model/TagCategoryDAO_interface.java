package com.TagCategory.model;

import java.util.*;

public interface TagCategoryDAO_interface {
          public void insert(TagCategoryVO tagCategoryVO);
          public void update(TagCategoryVO tagCategoryVO);
          public TagCategoryVO findByPrimaryKey(Integer genreId);
          public List<TagCategoryVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
