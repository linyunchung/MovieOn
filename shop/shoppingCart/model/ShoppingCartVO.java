package com.shoppingCart.model;

public class ShoppingCartVO implements java.io.Serializable {	
	private Integer cartId;    //購物車編號
	private Integer itemQty;   //商品數量
	private Integer userId;    //會員編號
	private Integer itemId;    //商品編號
	
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
