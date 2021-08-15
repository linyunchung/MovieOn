package com.MemberTag.model;

import java.util.*;

public interface MemberTagDAO_interface {
          public void insert(MemberTagVO memberTagVO);
          public void update(MemberTagVO memberTagVO);
          public void delete(Integer empno);
          public MemberTagVO findByPrimaryKey(Integer tagId);
          public List<MemberTagVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
