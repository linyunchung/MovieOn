package com.ItemTagMapping.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ItemTagMappingService {

	private ItemTagMappingDAO_interface dao;

	public ItemTagMappingService() {
		dao = new ItemTagMappingJDBCDAO();
	}

	public ItemTagMappingVO addItemTagMapping( Integer itemId, Integer itemTagCategoryNumber) {

		ItemTagMappingVO itemTagMappingVO = new ItemTagMappingVO();

		itemTagMappingVO.setItemId(itemId);
		itemTagMappingVO.setItemTagCategoryNumber(itemTagCategoryNumber);
		dao.insert(itemTagMappingVO);

		return itemTagMappingVO;
	}

	public ItemTagMappingVO updateItemTagMapping(Integer tagId, Integer itemId, Integer itemTagCategoryNumber) {

		ItemTagMappingVO itemTagMappingVO = new ItemTagMappingVO();

		itemTagMappingVO.setTagId(tagId);;
		itemTagMappingVO.setItemId(itemId);
		itemTagMappingVO.setItemTagCategoryNumber(itemTagCategoryNumber);
		dao.update(itemTagMappingVO);

		return itemTagMappingVO;
	}

	public void deleteItemTagMapping(Integer tagId) {
		dao.delete(tagId);
	}
	
	public ItemTagMappingVO getOneItemTagMapping(Integer tagId) {
		return dao.findByPrimaryKey(tagId);
	}

	public List<ItemTagMappingVO> getAll() {
		return dao.getAll();
	}
}
