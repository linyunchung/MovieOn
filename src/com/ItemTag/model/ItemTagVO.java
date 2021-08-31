package com.ItemTag.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class ItemTagVO implements java.io.Serializable{
	private Integer itemTagCategoryNumber;
	private Integer itemTag;
	
	
	public Integer getItemTagCategoryNumber() {
		return itemTagCategoryNumber;
	}
	public void setItemTagCategoryNumber(Integer itemTagCategoryNumber) {
		this.itemTagCategoryNumber = itemTagCategoryNumber;
	}
	public Integer getItemTag() {
		return itemTag;
	}
	public void setItemTag(Integer itemTag) {
		this.itemTag = itemTag;
	}

}
