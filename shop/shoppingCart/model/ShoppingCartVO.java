package com.shoppingCart.model;

public class ShoppingCartVO implements java.io.Serializable {	
	private Integer cartId;    //�ʪ����s��
	private Integer itemQty;   //�ӫ~�ƶq
	private Integer userId;    //�|���s��
	private Integer itemId;    //�ӫ~�s��
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getItemQty() {
		return itemQty;
	}
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

}
