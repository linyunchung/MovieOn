package com.ItemTagMapping.model;

import java.util.*;

import com.TagCategory.model.TagCategoryVO;
import com.item.model.itemVO;

import oracle.net.aso.p;

import java.sql.*;

public class ItemTagMappingJDBCDAO implements ItemTagMappingDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "4579616593";
	
	private static final String INSERT_STMT = 
		"INSERT INTO MOVIEON.ItemTagMapping (itemId, itemTagCategoryNumber) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT tagId,itemId,itemTagCategoryNumber FROM MOVIEON.ItemTagMapping order by tagId";
	private static final String GET_ONE_STMT = 
		"SELECT tagId,itemId,itemTagCategoryNumber FROM MOVIEON.ItemTagMapping where tagId = ?";
	private static final String DELETE = 
			"DELETE FROM MOVIEON.ItemTagMapping where tagId = ?";
	private static final String UPDATE = 
		"UPDATE MOVIEON.ItemTagMapping set itemId=?,itemTagCategoryNumber=? where tagId = ?";

	@Override
	public void insert(ItemTagMappingVO itemTagMappingVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, itemTagMappingVO.getItemId());
			pstmt.setInt(2, itemTagMappingVO.getItemTagCategoryNumber());

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
	public void update(ItemTagMappingVO itemTagMappingVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, itemTagMappingVO.getItemId());
			pstmt.setInt(2, itemTagMappingVO.getItemTagCategoryNumber());
			pstmt.setInt(3, itemTagMappingVO.getTagId());
		
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
	public void delete(Integer tagId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, tagId);

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
	public ItemTagMappingVO findByPrimaryKey(Integer tagId) {

		ItemTagMappingVO itemTagMappingVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, tagId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				itemTagMappingVO = new ItemTagMappingVO();
				itemTagMappingVO.setTagId(rs.getInt("tagId"));
				itemTagMappingVO.setItemId(rs.getInt("itemId"));
				itemTagMappingVO.setItemTagCategoryNumber(rs.getInt("itemTagCategoryNumber"));
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
		return itemTagMappingVO;
	}

	@Override
	public List<ItemTagMappingVO> getAll() {
		List<ItemTagMappingVO> list = new ArrayList<ItemTagMappingVO>();
		ItemTagMappingVO itemTagMappingVO = null;

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
				itemTagMappingVO = new ItemTagMappingVO();
				itemTagMappingVO.setTagId(rs.getInt("tagId"));
				itemTagMappingVO.setItemId(rs.getInt("itemId"));
				itemTagMappingVO.setItemTagCategoryNumber(rs.getInt("itemTagCategoryNumber"));
				list.add(itemTagMappingVO); // Store the row in the list
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

		ItemTagMappingJDBCDAO dao = new ItemTagMappingJDBCDAO();

		// 新增
//		ItemTagMappingVO itemTagMappingVO1 = new ItemTagMappingVO();
//		itemTagMappingVO1.setItemId(3003);
//		itemTagMappingVO1.setItemTagCategoryNumber(20);
//		dao.insert(itemTagMappingVO1);
		

//		// 修改
//		ItemTagMappingVO itemTagMappingVO2 = new ItemTagMappingVO();
//		itemTagMappingVO2.setTagId(4008);
//		itemTagMappingVO2.setItemId(3003);
//		itemTagMappingVO2.setItemTagCategoryNumber(30);
//		dao.update(itemTagMappingVO2);
		
		// 刪除
				dao.delete(4006);
//
//		// 查詢
		ItemTagMappingVO itemTagMappingVO3 = dao.findByPrimaryKey(4001);
		System.out.print(itemTagMappingVO3.getTagId() + ",");
		System.out.print(itemTagMappingVO3.getItemId() + ",");
		System.out.println(itemTagMappingVO3.getItemTagCategoryNumber());
		System.out.println("---------------------");

//		// 查詢
		List<ItemTagMappingVO> list = dao.getAll();
		for (ItemTagMappingVO aiTagMappingVO : list) {
			System.out.print(aiTagMappingVO.getTagId() + ",");
			System.out.print(aiTagMappingVO.getItemId() + ",");
			System.out.println(aiTagMappingVO.getItemTagCategoryNumber());
			
			System.out.println("-----------------------");
		}
	}
}