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

	public itemVO addItem(String itemName, Integer price, String introduction,
			String productSpecifications, Integer inventory, Date shelfDate, byte[] itemPic, String itemTag, byte[] pic1, byte[] pic2, byte[] pic3 ) {

		itemVO itemVO = new itemVO();

		itemVO.setItemName(itemName);
		itemVO.setPrice(price);
		itemVO.setIntroduction(introduction);
		itemVO.setProductSpecifications(productSpecifications);
		itemVO.setInventory(inventory);
		itemVO.setShelfDate(shelfDate);
		itemVO.setItemPic(itemPic);
		itemVO.setItemTag(itemTag);
		itemVO.setPic1(pic1);
		itemVO.setPic2(pic2);
		itemVO.setPic3(pic3);
		dao.insert(itemVO);

		return itemVO;
	}

	public itemVO updateItem(Integer itemId, String itemName, Integer price, String introduction,
			String productSpecifications, Integer inventory, byte[] itemPic, String itemTag, byte[] pic1, byte[] pic2, byte[] pic3) {

		itemVO itemVO = new itemVO();

		itemVO.setItemId(itemId);
		itemVO.setItemName(itemName);
		itemVO.setPrice(price);
		itemVO.setIntroduction(introduction);
		itemVO.setProductSpecifications(productSpecifications);
		itemVO.setInventory(inventory);
		itemVO.setItemPic(itemPic);
		itemVO.setItemTag(itemTag);
		itemVO.setPic1(pic1);
		itemVO.setPic2(pic2);
		itemVO.setPic3(pic3);
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
