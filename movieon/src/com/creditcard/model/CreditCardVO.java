package com.creditcard.model;

public class CreditCardVO implements java.io.Serializable {
	private Integer creditid;
	private Integer userid;
	private String creditno;
	private String creditexp;
	private String cardholder;
	private String creditpin;

	public Integer getCreditid() {
		return creditid;
	}

	public void setCreditid(Integer creditid) {
		this.creditid = creditid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCreditno() {
		return creditno;
	}

	public void setCreditno(String creditno) {
		this.creditno = creditno;
	}

	public String getCreditexp() {
		return creditexp;
	}

	public void setCreditexp(String creditexp) {
		this.creditexp = creditexp;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public String getCreditpin() {
		return creditpin;
	}

	public void setCreditpin(String creditpin) {
		this.creditpin = creditpin;
	}

}
