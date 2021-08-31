package com.seating.model;

public class SeatingVO {

	private String screenID;
	private String layout;
	private String unavailable;
	private String updatedAt;
	
	public SeatingVO() {
		super();
	}
	
	public SeatingVO(String screenID, String layout, String unavailable, String updatedAt) {
		super();
		this.screenID = screenID;
		this.layout = layout;
		this.unavailable = unavailable;
		this.updatedAt = updatedAt;
	}

	public String getScreenID() {
		return screenID;
	}

	public void setScreenID(String screenID) {
		this.screenID = screenID;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getUnavailable() {
		return unavailable;
	}

	public void setUnavailable(String unavailable) {
		this.unavailable = unavailable;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "seatingVO [screenID=" + screenID + ", layout=" + layout + ", unavailable=" + unavailable
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	

}
