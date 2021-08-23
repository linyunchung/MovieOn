package com.msg.model;

import java.util.List;

public interface MsgDAO_interface {
	public void insert(MsgVO msgVO);
    public void update(MsgVO msgVO);
    public void delete(Integer msgId);
    public MsgVO findByPrimaryKey(Integer msgId);
    public List<MsgVO> getAll();
    
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<MsgVO> getAll(Map<String, String[]> map); 
}
