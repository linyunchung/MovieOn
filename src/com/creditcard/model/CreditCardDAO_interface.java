package com.creditcard.model;

import java.util.List;

public interface CreditCardDAO_interface {
	public void insert(CreditCardVO creditCardVO);
	public void update(CreditCardVO creditCardVO);
	public void delete(Integer creditid);
	public CreditCardVO findByPrimaryKey(Integer creditid);
	public List<CreditCardVO> getAll();
}
