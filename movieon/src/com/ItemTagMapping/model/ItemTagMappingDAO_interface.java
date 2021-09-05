package com.ItemTagMapping.model;

import java.util.*;

public interface ItemTagMappingDAO_interface {
          public void insert(ItemTagMappingVO itemTagMappingVO);
          public void update(ItemTagMappingVO itemTagMappingVO);
          public void delete(Integer empno);
          public ItemTagMappingVO findByPrimaryKey(Integer tagId);
          public List<ItemTagMappingVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
