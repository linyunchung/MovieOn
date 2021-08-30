package com.orderInfo.model;

import java.sql.Connection;
import java.util.List;

import com.orderList.model.OrderListVO;

public interface OrderInfoDAO_interface {
	public Integer insert(OrderInfoVO orderInfoVO, List<OrderListVO> orderListVOList);    //�s�W�q��
	
	public void update(OrderInfoVO orderInfoVO);                                          //��s�q��
	public OrderInfoVO findByPrimaryKey(Integer orderId);            					  //���ѭq��s���d�߭q��
	public List<OrderInfoVO> getAll();                               					  //�d��Ҧ����
	public List<OrderInfoVO> getMyOrderInfo(Integer userId);         					  //�|���d�߭q��

}

