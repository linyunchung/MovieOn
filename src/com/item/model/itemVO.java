package com.item.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class itemVO implements java.io.Serializable{
	private Integer itemId;
	private String itemName;
	private Integer price;
	private String introduction;
	private String productSpecifications;
	private Integer inventory;
	private Integer salesVolume;
	private Date shelfDate;
	private Blob itemPic;
	
	public Blob getItemPic() {
		return itemPic;
	}
	public void setItemPic(Blob itemPic) {
		this.itemPic = itemPic;
	}
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getProductSpecifications() {
		return productSpecifications;
	}
	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	public Date getShelfDate() {
		return shelfDate;
	}
	public void setShelfDate(Date shelfDate) {
		this.shelfDate = shelfDate;
	}
	

}
