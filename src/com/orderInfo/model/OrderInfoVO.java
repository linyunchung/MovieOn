package com.orderInfo.model;

import java.sql.Timestamp;


public class OrderInfoVO implements java.io.Serializable{
	private Integer orderId;          //訂單編號
	private String orderStatus;      //訂單狀態
	private Timestamp orderDate;     //訂單日期
	private String paymentMethodId;  //付款方式
	private String deliveryMethodId; //配送方式
	private String consignee;         //收件人
	private String mobile;            //電話
	private String address;           //收件地址
	private String invoiceId;         //發票編號
	private Integer userId;           //會員編號
	private Integer orderTotal;       //商品總額
	private String payStatus;         //付款狀態 
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(String deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
}
