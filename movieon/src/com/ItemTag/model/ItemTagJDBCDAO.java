package com.ItemTag.model;

import java.util.*;

import com.TagCategory.model.TagCategoryVO;
import com.item.model.itemVO;

import oracle.net.aso.p;

import java.sql.*;

public class ItemTagJDBCDAO implements ItemTagDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "4579616593";

	private static final String INSERT_STMT = 
		"INSERT INTO MOVIEON.ItemTag (itemTag) VALUES (?)";
	private static final String GET_ALL_STMT = 
		"SELECT itemTagCategoryNumber,itemTag FROM MOVIEON.ItemTag order by itemTagCategoryNumber";
	private static final String GET_ONE_STMT = 
		"SELECT itemTagCategoryNumber,itemTag FROM MOVIEON.ItemTag where itemTagCategoryNumber = ?";
	private static final String UPDATE = 
		"UPDATE MOVIEON.ItemTag set itemTag=? where itemTagCategoryNumber = ?";

	@Override
	public void insert(ItemTagVO itemTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, itemTagVO.getItemTag());
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
	public void update(ItemTagVO itemTagVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, itemTagVO.getItemTag());
			pstmt.setInt(2, itemTagVO.getItemTagCategoryNumber());
		
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
	public ItemTagVO findByPrimaryKey(Integer itemTagCategoryNumber) {

		ItemTagVO itemTagVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, itemTagCategoryNumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				itemTagVO = new ItemTagVO();
				itemTagVO.setItemTagCategoryNumber(rs.getInt("itemTagCategoryNumber"));
				itemTagVO.setItemTag(rs.getInt("itemTag"));
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
		return itemTagVO;
	}

	@Override
	public List<ItemTagVO> getAll() {
		List<ItemTagVO> list = new ArrayList<ItemTagVO>();
		ItemTagVO itemTagVO = null;

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
				itemTagVO = new ItemTagVO();
				itemTagVO.setItemTagCategoryNumber(rs.getInt("itemTagCategoryNumber"));
				itemTagVO.setItemTag(rs.getInt("itemTag"));
				list.add(itemTagVO); // Store the row in the list
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

		ItemTagJDBCDAO dao = new ItemTagJDBCDAO();

		// 新增
//		ItemTagVO itemTagVO1 = new ItemTagVO();
//		itemTagVO1.setItemTag(5);
//		dao.insert(itemTagVO1);
		

//		// 修改
//		ItemTagVO itemTagVO2 = new ItemTagVO();
//		itemTagVO2.setItemTagCategoryNumber(50);
//		itemTagVO2.setItemTag(100);
//		dao.update(itemTagVO2);
//
//		// 查詢
		ItemTagVO itemTagVO3 = dao.findByPrimaryKey(10);
		System.out.print(itemTagVO3.getItemTagCategoryNumber() + ",");
		System.out.println(itemTagVO3.getItemTag());
		System.out.println("---------------------");

//		// 查詢
		List<ItemTagVO> list = dao.getAll();
		for (ItemTagVO aItemTagVO : list) {
			System.out.print(aItemTagVO.getItemTagCategoryNumber() + ",");
			System.out.println(aItemTagVO.getItemTag());
		
			
			System.out.println("-----------------------");
		}
	}
}