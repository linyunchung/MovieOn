package com.shoppingCart.model;

import java.util.List;

public interface ShoppingCartDAO_interface {
	public void insert(ShoppingCartVO shoppingCartVO);
	public void update(ShoppingCartVO shoppingCartVO);
	public void delete(Integer cartId);
	public ShoppingCartVO findByPrimaryKey(Integer cartId);
	public List<ShoppingCartVO> getAll();
}
