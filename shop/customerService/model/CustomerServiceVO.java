package com.customerService.model;

import java.sql.Date;

public class CustomerServiceVO implements java.io.Serializable {
	private Integer msgId;     //留言編號
	private Date msgTime;      //留言時間
	private String msgTitle;   //留言標題
	private String msgContext; //留言內容
	private String reContext;  //回覆內容
	
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
