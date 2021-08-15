package com.orderInfo.model;
import java.sql.Date;

public class OrderInfoVO implements java.io.Serializable{
	private Integer orderId;          //訂單編號
	private Integer orderStatus;      //訂單狀態
	private Date orderDate;           //訂單日期
	private Integer paymentMethodId;  //付款方式
	private Integer deliveryMethodId; //配送方式
	private String consignee;         //收件人
	private String mobile;            //電話
	private String address;           //收件地址
	private String invoiceId;         //發票編號
	private Integer userId;           //會員編號
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public Integer getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(Integer deliveryMethodId) {
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
}
