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
	private byte[] itemPic;
	private String itemTag;
	private byte[] pic1;
	private byte[] pic2;
	private byte[] pic3;
	
	
	//shop�s�W,�ŧR
	public itemVO() {
		super();
	}
	public itemVO(Integer itemId, 
			String itemName, Integer price, String introduction, 
			String productSpecifications,Integer inventory,
			Integer salesVolume,Date shelfDate,byte[] itemPic,String itemTag,
			byte[] pic1,byte[] pic2, byte[] pic3) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.introduction = introduction;
		this.productSpecifications = productSpecifications;
		this.inventory = inventory;
		this.salesVolume = salesVolume;
		this.shelfDate = shelfDate;
		this.itemPic = itemPic;
		this.itemTag = itemTag;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof itemVO)) {
			return false;
		}
		itemVO other = (itemVO) obj;
		if (itemId == null) {
			if (other.itemId != null) {
				return false;
			}
		} else if (!itemId.equals(other.itemId)) {
			return false;
		}
		return true;
	}
	//shop�s�W����,�ŧR
	
	
	
	
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
	
	
	//shop�ק令byte[],�ŧR
	public byte[] getItemPic() {
		return itemPic;
	}
	public void setItemPic(byte[] itemPic) {
		this.itemPic = itemPic;
	}
	//shop�ק令byte[]����,�ŧR
	
	
	public String getItemTag() {
		return itemTag;
	}
	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
	}
	
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
}
