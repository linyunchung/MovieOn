package com.TagCategory.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class TagCategoryVO implements java.io.Serializable{
	@Override
	public String toString() {
		return "TagCategoryVO [genreId=" + genreId + ", genreTag=" + genreTag + "]";
	}
	private Integer genreId;
	private String genreTag
	;
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public String getGenreTag() {
		return genreTag;
	}
	public void setGenreTag(String genreTag) {
		this.genreTag = genreTag;
	}
	
	
	

}
