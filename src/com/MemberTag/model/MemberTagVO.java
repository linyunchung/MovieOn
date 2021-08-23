package com.MemberTag.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class MemberTagVO implements java.io.Serializable{
	private Integer tagId;
	private Integer userId;
	private Integer genreId;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	
	
	

	

}
