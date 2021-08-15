package com.orderList.model;

import java.util.List;

public interface OrderListDAO_interface {
	public void insert(OrderListVO orderListVO);        
	public void update(OrderListVO orderListVO);
	public OrderListVO findByPrimaryKey(Integer orderListId);
	public List<OrderListVO> getAll(); 
}
