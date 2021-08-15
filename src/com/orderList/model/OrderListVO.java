package com.orderlist.model;

public class OrderListVO implements java.io.Serializable {
	private Integer orderListId;       //訂單明細編號
	private Integer price;             //商品單價
	private Integer itemQty;           //商品數量
	private String orderRemark;        //商品備註
	private Integer orderId;           //訂單編號
	private Integer itemId;            //商品編號
	
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
