package com.customerService.model;

import java.sql.Date;

public class CustomerServiceVO implements java.io.Serializable {
	private Integer msgId;     //�d���s��
	private Date msgTime;      //�d���ɶ�
	private String msgTitle;   //�d�����D
	private String msgContext; //�d�����e
	private String reContext;  //�^�Ф��e
	
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	
	public Date getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
	
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	
	public String getMsgContext() {
		return msgContext;
	}
	public void setMsgContext(String msgContext) {
		this.msgContext = msgContext;
	}
	
	public String getReContext() {
		return reContext;
	}
	public void setReContext(String reContext) {
		this.reContext = reContext;
	}
}
