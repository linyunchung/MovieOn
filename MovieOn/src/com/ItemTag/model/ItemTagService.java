package com.ItemTag.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ItemTagService {

	private ItemTagDAO_interface dao;

	public ItemTagService() {
		dao = new ItemTagJDBCDAO();
	}

	public ItemTagVO addItemTag(Integer itemTag) {

		ItemTagVO itemTagVO = new ItemTagVO();

		itemTagVO.setItemTag(itemTag);
		dao.insert(itemTagVO);

		return itemTagVO;
	}

	public ItemTagVO updateItemTag(Integer itemTagCategoryNumber, Integer itemTag) {

		ItemTagVO itemTagVO = new ItemTagVO();

		itemTagVO.setItemTagCategoryNumber(itemTagCategoryNumber);
		itemTagVO.setItemTag(itemTag);
		dao.update(itemTagVO);

		return itemTagVO;
	}

	public ItemTagVO getOneItemTag(Integer itemTagCategoryNumber) {
		return dao.findByPrimaryKey(itemTagCategoryNumber);
	}

	public List<ItemTagVO> getAll() {
		return dao.getAll();
	}
}
