package com.TagCategory.model;

import java.util.*;

public interface TagCategoryDAO_interface {
          public void insert(TagCategoryVO tagCategoryVO);
          public void update(TagCategoryVO tagCategoryVO);
          public TagCategoryVO findByPrimaryKey(Integer genreId);
          public List<TagCategoryVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
