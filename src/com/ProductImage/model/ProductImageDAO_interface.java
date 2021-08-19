package com.ProductImage.model;

import java.util.*;

public interface ProductImageDAO_interface {
          public void insert(ProductImageVO productImageVO);
          public void update(ProductImageVO productImageVO);
          public void delete(Integer empno);
          public ProductImageVO findByPrimaryKey(Integer imageId);
          public List<ProductImageVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
