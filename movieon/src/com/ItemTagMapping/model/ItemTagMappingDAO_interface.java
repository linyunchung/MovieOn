package com.ItemTagMapping.model;

import java.util.*;

public interface ItemTagMappingDAO_interface {
          public void insert(ItemTagMappingVO itemTagMappingVO);
          public void update(ItemTagMappingVO itemTagMappingVO);
          public void delete(Integer empno);
          public ItemTagMappingVO findByPrimaryKey(Integer tagId);
          public List<ItemTagMappingVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
