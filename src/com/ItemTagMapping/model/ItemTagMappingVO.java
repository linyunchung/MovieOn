package com.ItemTagMapping.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class ItemTagMappingVO implements java.io.Serializable{
	private Integer tagId;
	private Integer itemId;
	private Integer itemTagCategoryNumber;
	
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	//shop�s�W,�ŧR
	public Integer getItemTagCategoryNumber() {
		return itemTagCategoryNumber;
	}
	//shop�s�W����,�ŧR
	
	
	public void setItemTagCategoryNumber(Integer itemTagCategoryNumber) {
		this.itemTagCategoryNumber = itemTagCategoryNumber;
	}
	
	

	

}
