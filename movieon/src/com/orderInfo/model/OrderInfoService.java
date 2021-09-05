package com.orderInfo.model;

import java.util.List;
import com.orderList.model.OrderListVO;
import java.sql.Timestamp;

public class OrderInfoService {

	private OrderInfoDAO_interface dao;

	public OrderInfoService() {
		dao = new OrderInfoJDBCDAO();
	}


	// 更新訂單明細(取消訂單時使用)
	public OrderInfoVO updateOrderInfo(Integer orderId, String orderStatus, Timestamp orderDate, String paymentMethodId,
			String deliveryMethodId, String consignee, String mobile, String address, String invoiceId, Integer userId,
			Integer orderTotal, String payStatus) {

		OrderInfoVO orderInfoVO = new OrderInfoVO();

		orderInfoVO.setOrderId(orderId);
		orderInfoVO.setOrderStatus(orderStatus);
		orderInfoVO.setOrderDate(orderDate);
		orderInfoVO.setPaymentMethodId(paymentMethodId);
		orderInfoVO.setDeliveryMethodId(deliveryMethodId);
		orderInfoVO.setConsignee(consignee);
		orderInfoVO.setMobile(mobile);
		orderInfoVO.setAddress(address);
		orderInfoVO.setInvoiceId(invoiceId);
		orderInfoVO.setUserId(userId);
		orderInfoVO.setOrderTotal(orderTotal);
		orderInfoVO.setPayStatus(payStatus);
		dao.update(orderInfoVO);

		return orderInfoVO;
	}

	public OrderInfoVO getOneOrderInfo(Integer orderId) {
		return dao.findByPrimaryKey(orderId);
	}

	public List<OrderInfoVO> getAll() {
		return dao.getAll();
	}

	public List<OrderInfoVO> getMyOrderInfo(Integer userId) {
		return dao.getMyOrderInfo(userId);
	}

	public OrderInfoVO getOneItem(Integer orderId) {
		return dao.findByPrimaryKey(orderId);
	}

	// 新增訂單
//	public Integer addOrderListVO(Integer orderId, String orderStatus, Timestamp orderDate, String paymentMethodId,
//			String deliveryMethodId, String consignee, String mobile, String address, String invoiceId, Integer userId,
//			Integer orderTotal, String payStatus, List<OrderListVO> orderListVOList) {
//		OrderInfoVO orderInfoVO = new OrderInfoVO();
//
//		orderInfoVO.setOrderStatus(orderStatus);
//		orderInfoVO.setOrderDate(orderDate);
//		orderInfoVO.setPaymentMethodId(paymentMethodId);
//		orderInfoVO.setDeliveryMethodId(deliveryMethodId);
//		orderInfoVO.setConsignee(consignee);
//		orderInfoVO.setMobile(mobile);
//		orderInfoVO.setAddress(address);
//		orderInfoVO.setInvoiceId(invoiceId);
//		orderInfoVO.setUserId(userId);
//		orderInfoVO.setOrderTotal(orderTotal);
//		orderInfoVO.setPayStatus(payStatus);
//
//		Integer next_order_no = dao.insert(orderInfoVO, orderListVOList);
//		
//		
//		
//		return next_order_no;
//	}
	
	// 新增訂單
		public void addOrderListVO(OrderInfoVO orderInfoVO,  List<OrderListVO> orderListVOList) {
			Integer next_order_no = dao.insert(orderInfoVO, orderListVOList);		
			orderInfoVO.setOrderId(next_order_no);
			
		}
	

}
