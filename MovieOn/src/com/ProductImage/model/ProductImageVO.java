package com.ProductImage.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class ProductImageVO implements java.io.Serializable{
	private Integer imageId;
	private Integer itemId;
	private Blob productImage;
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}
	
	
	

	

}
