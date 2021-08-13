package com.orderInfo.model;
import java.sql.Date;

public class OrderInfoVO implements java.io.Serializable{
	private Integer orderId;          //�q��s��
	private Integer orderStatus;      //�q�檬�A
	private Date orderDate;           //�q����
	private Integer paymentMethodId;  //�I�ڤ覡
	private Integer deliveryMethodId; //�t�e�覡
	private String consignee;         //����H
	private String mobile;            //�q��
	private String address;           //����a�}
	private String invoiceId;         //�o���s��
	private Integer userId;           //�|���s��
	
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
