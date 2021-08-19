package com.ProductImage.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ProductImageService {

	private ProductImageDAO_interface dao;

	public ProductImageService() {
		dao = new ProductImageJDBCDAO();
	}

	public ProductImageVO addMovieTag(Integer itemId, Blob productImage) {

		ProductImageVO productImageVO = new ProductImageVO();

		
		productImageVO.setItemId(itemId);
		productImageVO.setProductImage(productImage);
		dao.insert(productImageVO);

		return productImageVO;
	}

	public ProductImageVO updateProductImage(Integer imageId, Integer itemId, Blob productImage) {

		ProductImageVO productImageVO = new ProductImageVO();

		productImageVO.setImageId(imageId);
		productImageVO.setItemId(itemId);
		productImageVO.setProductImage(productImage);
		dao.update(productImageVO);

		return productImageVO;
	}

	public void deleteProductImage(Integer imageId) {
		dao.delete(imageId);
	}

	public ProductImageVO getOneProductImage(Integer imageId) {
		return dao.findByPrimaryKey(imageId);
	}

	public List<ProductImageVO> getAll() {
		return dao.getAll();
	}
}
