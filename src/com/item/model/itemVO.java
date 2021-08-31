package com.item.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

public class itemVO implements java.io.Serializable{
	
	
	private Integer itemId;
	private String itemName;
	private Integer price;
	private String introduction;
	private String productSpecifications;
	private Integer inventory;
	private Integer salesVolume;
	private Date shelfDate;
	private byte[] itemPic;
	private String itemTag;
	private byte[] pic1;
	private byte[] pic2;
	private byte[] pic3;
	
	
	public byte[] getPic1() {
		return pic1;
	}

	public void setPic1(byte[] pic1) {
		this.pic1 = pic1;
	}

	public byte[] getPic2() {
		return pic2;
	}

	public void setPic2(byte[] pic2) {
		this.pic2 = pic2;
	}

	public byte[] getPic3() {
		return pic3;
	}

	public void setPic3(byte[] pic3) {
		this.pic3 = pic3;
	}

	public byte[] getItemPic() {
		return itemPic;
	}

	public void setItemPic(byte[] itemPic) {
		this.itemPic = itemPic;
	}

	public String getItemTag() {
		return itemTag;
	}

	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
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
	@Override
	public String toString() {
		return "itemVO [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", introduction="
				+ introduction + ", productSpecifications=" + productSpecifications + ", inventory=" + inventory
				+ ", salesVolume=" + salesVolume + ", shelfDate=" + shelfDate + ", itemPic=" + Arrays.toString(itemPic)
				+ ", itemTag=" + itemTag + ", pic1=" + Arrays.toString(pic1) + ", pic2=" + Arrays.toString(pic2)
				+ ", pic3=" + Arrays.toString(pic3) + "]";
	}

}
