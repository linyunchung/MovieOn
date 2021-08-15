package com.customerService.model;

import java.util.List;

public interface CustomerServiceDAO_interface {
	public void insert(CustomerServiceVO customerServiceVO);
	public void update(CustomerServiceVO customerServiceVO);
	public void delete(Integer msgId);
	public CustomerServiceVO findByPrimaryKey(Integer msgId);
	public List<CustomerServiceVO> getAll();
}
