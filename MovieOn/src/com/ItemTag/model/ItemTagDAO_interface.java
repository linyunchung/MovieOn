package com.ItemTag.model;

import java.util.*;

public interface ItemTagDAO_interface {
          public void insert(ItemTagVO itemTagVO);
          public void update(ItemTagVO itemTagVO);
          public ItemTagVO findByPrimaryKey(Integer itemTagCategoryNumber);
          public List<ItemTagVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
