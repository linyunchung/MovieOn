package com.orderList.model;

import java.util.List;

import com.orderInfo.model.OrderInfoVO;

public class OrderListService {
	
	private OrderListDAO_interface dao;
	
	public OrderListService() {
		dao = new OrderListJDBCDAO();
	}
	
	//新增訂單明細
	public OrderListVO addOrderList(
			Integer orderListId,
			Integer price,
			Integer itemQty,
			Integer orderId,
			Integer itemId) {
		
		OrderListVO orderListVO = new OrderListVO();
		
		orderListVO.setOrderListId(orderListId);
		orderListVO.setPrice(price);
		orderListVO.setItemQty(itemQty);
		orderListVO.setOrderId(orderId);
		orderListVO.setItemId(itemId);
		dao.insert(orderListVO, null);

		return orderListVO;
	}
	
	//更新訂單明細(取消訂單時使用)
	public OrderListVO updateOrderList(
			Integer orderListId,
			Integer price,
			Integer itemQty,
			String orderRemark,
			Integer orderId,
			Integer itemId) {
		
		OrderListVO orderListVO = new OrderListVO();
		
		orderListVO.setOrderListId(orderListId);
		orderListVO.setPrice(price);
		orderListVO.setItemQty(itemQty);
		orderListVO.setOrderId(orderId);
		orderListVO.setItemId(itemId);
		dao.update(orderListVO);

		return orderListVO;
	}
	
	public OrderListVO getOneOrderList(Integer orderListId) {
		return dao.findByPrimaryKey(orderListId);
	}

	public List<OrderListVO> getAll() {
		return dao.getAll();
	}
	public List<OrderListVO> getAllByOrderId(Integer orderId) {
		return dao.getByOrderId(orderId);
	}


	
}
