package com.orderlist.model;

public class OrderListVO implements java.io.Serializable {
	private Integer orderListId;       //�q����ӽs��
	private Integer price;             //�ӫ~���
	private Integer itemQty;           //�ӫ~�ƶq
	private String orderRemark;        //�ӫ~�Ƶ�
	private Integer orderId;           //�q��s��
	private Integer itemId;            //�ӫ~�s��
	
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getItemQty() {
		return itemQty;
	}
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
}
