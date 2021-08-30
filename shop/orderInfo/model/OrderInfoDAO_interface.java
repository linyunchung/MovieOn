package com.orderInfo.model;

import java.sql.Connection;
import java.util.List;

import com.orderList.model.OrderListVO;

public interface OrderInfoDAO_interface {
	public Integer insert(OrderInfoVO orderInfoVO, List<OrderListVO> orderListVOList);    //新增訂單
	
	public void update(OrderInfoVO orderInfoVO);                                          //更新訂單
	public OrderInfoVO findByPrimaryKey(Integer orderId);            					  //提供訂單編號查詢訂單
	public List<OrderInfoVO> getAll();                               					  //查找所有資料
	public List<OrderInfoVO> getMyOrderInfo(Integer userId);         					  //會員查詢訂單

}

