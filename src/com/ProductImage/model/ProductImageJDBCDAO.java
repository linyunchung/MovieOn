package com.ProductImage.model;

import java.util.*;



import oracle.net.aso.p;

import java.sql.*;

public class ProductImageJDBCDAO implements ProductImageDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO ProductImage (itemId, productImage) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT imageId,itemId, productImage FROM ProductImage order by imageId";
	private static final String GET_ONE_STMT = 
		"SELECT imageId,itemId, productImage FROM ProductImage where imageId = ?";
	private static final String UPDATE = 
		"UPDATE ProductImage set itemId=?,productImage=? where imageId = ?";
	private static final String DELETE = 
			"DELETE FROM ProductImage where imageId = ?";

	@Override
	public void insert(ProductImageVO productImageVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productImageVO.getItemId());
			pstmt.setBlob(2, productImageVO.getProductImage());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ProductImageVO productImageVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productImageVO.getItemId());
			pstmt.setBlob(2, productImageVO.getProductImage());
			pstmt.setInt(3, productImageVO.getImageId());
		
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}


	@Override
	public void delete(Integer imageId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, imageId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ProductImageVO findByPrimaryKey(Integer imageId) {

		ProductImageVO productImageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, imageId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				productImageVO = new ProductImageVO();
				productImageVO.setImageId(rs.getInt("imageId"));
				productImageVO.setItemId(rs.getInt("itemId"));
				productImageVO.setProductImage(rs.getBlob("productImage"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productImageVO;
	}

	@Override
	public List<ProductImageVO> getAll() {
		List<ProductImageVO> list = new ArrayList<ProductImageVO>();
		ProductImageVO productImageVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				productImageVO = new ProductImageVO();
				productImageVO.setImageId(rs.getInt("imageId"));
				productImageVO.setItemId(rs.getInt("itemId"));
				productImageVO.setProductImage(rs.getBlob("productImage"));
				list.add(productImageVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		ProductImageJDBCDAO dao = new ProductImageJDBCDAO();

		// 新增
//		ProductImageVO productImageVO1 = new ProductImageVO();
//		productImageVO1.setItemId(3001);
//		productImageVO1.setProductImage(null);
//		dao.insert(productImageVO1);
		

////		// 修改
//		ProductImageVO productImageVO2 = new ProductImageVO();
//		productImageVO2.setImageId(5003);
//		productImageVO2.setItemId(3003);
//		productImageVO2.setProductImage(null);
//		dao.update(productImageVO2);
		
		// 刪除
				dao.delete(5002);
//
//		// 查詢
		ProductImageVO productImageVO3 = dao.findByPrimaryKey(5001);
		System.out.print(productImageVO3.getImageId() + ",");
		System.out.print(productImageVO3.getItemId() + ",");
		System.out.println(productImageVO3.getProductImage());
		System.out.println("---------------------");

//		// 查詢
		List<ProductImageVO> list = dao.getAll();
		for (ProductImageVO aProductImageVO : list) {
			System.out.print(aProductImageVO.getImageId() + ",");
			System.out.print(aProductImageVO.getItemId() + ",");
			System.out.println(aProductImageVO.getProductImage());
			
			System.out.println("-----------------------");
		}
	}
}