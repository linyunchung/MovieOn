package com.orderInfo.model;

import java.util.List;

public interface OrderInfoDAO_interface {
	public void insert(OrderInfoVO orderInfoVO);          //新增訂單
	public void update(OrderInfoVO orderInfoVO);          //更新訂單
	public OrderInfoVO findByPrimaryKey(Integer orderId); //提供訂單編號查詢訂單
	public List<OrderInfoVO> getAll();                    //查找所有資料
	
	//使用者每送出一筆訂單皆需保存紀錄,因此沒有設定刪除訂單的方法
}
