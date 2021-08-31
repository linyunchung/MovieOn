package com.orderList.model;

import java.sql.Connection;
import java.util.List;

public interface OrderListDAO_interface {
	public void insert(OrderListVO orderListVO, List<OrderListVO> orderListVOList);        
	public void insert(OrderListVO orderListVO, List<OrderListVO> orderListVOList, Connection con);
	
	public void update(OrderListVO orderListVO);
	public OrderListVO findByPrimaryKey(Integer orderListId);
	public List<OrderListVO> getAll();
	public List<OrderListVO> getByOrderId(Integer orderId);
	
}
