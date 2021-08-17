package com.item.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class itemService {

	private itemDAO_interface dao;

	public itemService() {
		dao = new itemJDBCDAO();
	}

	public itemVO addMovie(String itemName, Integer price, String introduction,
			String productSpecifications, Integer inventory, Integer salesVolume, Date shelfDate) {

		itemVO itemVO = new itemVO();

		itemVO.setItemName(itemName);
		itemVO.setPrice(price);
		itemVO.setIntroduction(introduction);
		itemVO.setProductSpecifications(productSpecifications);
		itemVO.setInventory(inventory);
		itemVO.setSalesVolume(salesVolume);
		itemVO.setShelfDate(shelfDate);
		dao.insert(itemVO);

		return itemVO;
	}

	public itemVO updateItem(Integer itemId, String itemName, Integer price, String introduction,
			String productSpecifications, Integer inventory, Integer salesVolume, Date shelfDate) {

		itemVO itemVO = new itemVO();

		itemVO.setItemId(itemId);
		itemVO.setItemName(itemName);
		itemVO.setPrice(price);
		itemVO.setIntroduction(introduction);
		itemVO.setProductSpecifications(productSpecifications);
		itemVO.setInventory(inventory);
		itemVO.setSalesVolume(salesVolume);
		itemVO.setShelfDate(shelfDate);
		dao.update(itemVO);

		return itemVO;
	}

	public void deleteItem(Integer itemId) {
		dao.delete(itemId);
	}

	public itemVO getOneItem(Integer itemId) {
		return dao.findByPrimaryKey(itemId);
	}

	public List<itemVO> getAll() {
		return dao.getAll();
	}
}
