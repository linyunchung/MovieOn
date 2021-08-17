package com.msg.model;

import java.sql.Timestamp;

public class MsgVO implements java.io.Serializable{
	private Integer msgId;
	private Integer reviewId;
	private Integer userId;
	private Timestamp msgTime;
	private String msgContext;
	
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Timestamp getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}
	public String getMsgContext() {
		return msgContext;
	}
	public void setMsgContext(String msgContext) {
		this.msgContext = msgContext;
	}
}
