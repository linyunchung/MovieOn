package com.item.model;

import java.sql.Date;


//shop·s¼WÀÉ®×
public class ShopOrderItem extends itemVO{
	private Integer itemQty;
	
	public ShopOrderItem(
			Integer itemId,
			String itemName,
			Integer price,
			String introduction,
			String productSpecifications,
			Integer inventory,
			Integer salesVolume,
			Date shelfDate,
			byte[] itemPic,
			String itemTag,
			int itemQty,
			byte[] pic1,
			byte[] pic2,
			byte[] pic3) {
		
		super(itemId, 
			  itemName, 
			  price,
			  introduction,
			  productSpecifications,
			  inventory,salesVolume,
			  shelfDate,
			  itemPic,
			  itemTag,
			  pic1,
			  pic2,
			  pic3);
		this.itemQty = itemQty;
	}
	
	public ShopOrderItem(itemVO itemVO, Integer itemQty) {
		this(
			itemVO.getItemId(),
			itemVO.getItemName(),
			itemVO.getPrice(),
			itemVO.getIntroduction(),
			itemVO.getProductSpecifications(),
			itemVO.getInventory(),
			itemVO.getSalesVolume(),
			itemVO.getShelfDate(),
			itemVO.getItemPic(),
			itemVO.getItemTag(),
			itemQty,
			itemVO.getPic1(),
			itemVO.getPic2(),
			itemVO.getPic3());
		this.itemQty = itemQty;
	}
	
	public Integer getItemQty() {
		return itemQty;
	}
	
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
}
