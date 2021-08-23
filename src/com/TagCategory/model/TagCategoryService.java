package com.TagCategory.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class TagCategoryService {

	private TagCategoryDAO_interface dao;

	public TagCategoryService() {
		dao = new TagCategoryJDBCDAO();
	}

	public TagCategoryVO addTagCategory(String genreTag) {

		TagCategoryVO tagCategoryVO = new TagCategoryVO();

		tagCategoryVO.setGenreTag(genreTag);
		dao.insert(tagCategoryVO);

		return tagCategoryVO;
	}

	public TagCategoryVO updateTagCategory(Integer genreId, String genreTag) {

		TagCategoryVO tagCategoryVO = new TagCategoryVO();

		tagCategoryVO.setGenreId(genreId);
		tagCategoryVO.setGenreTag(genreTag);
		dao.update(tagCategoryVO);

		return tagCategoryVO;
	}

	public TagCategoryVO getOneTagCategory(Integer genreId) {
		return dao.findByPrimaryKey(genreId);
	}

	public List<TagCategoryVO> getAll() {
		return dao.getAll();
	}
}
