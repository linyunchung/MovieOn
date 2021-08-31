package com.item.model;

import java.util.*;

import com.TagCategory.model.TagCategoryVO;
import com.item.model.itemVO;

import oracle.net.aso.i;
import oracle.net.aso.p;

import java.sql.*;

public class itemJDBCDAO implements itemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
		"INSERT INTO item (itemName, price, introduction, productSpecifications, inventory, salesVolume, shelfDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT itemId,itemName,price,introduction,productSpecifications,inventory,salesVolume,shelfDate FROM item order by itemId";
	private static final String GET_ONE_STMT = 
		"SELECT itemId,itemName,price,introduction,productSpecifications,inventory,salesVolume,shelfDate FROM item where itemId = ?";
	private static final String DELETE = 
			"DELETE FROM item where itemId = ?";
	private static final String UPDATE = 
		"UPDATE item set itemName=?, price=?, introduction=?, productSpecifications=?, inventory=?, salesVolume=?, shelfDate=? where itemId=?";

	@Override
	public void insert(itemVO itemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, itemVO.getItemName());
			pstmt.setInt(2, itemVO.getPrice());
			pstmt.setString(3, itemVO.getIntroduction());
			pstmt.setString(4,  itemVO.getProductSpecifications());
			pstmt.setInt(5, itemVO.getInventory());
			pstmt.setInt(6, itemVO.getSalesVolume());
			pstmt.setDate(7, itemVO.getShelfDate());

			
			
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
	public void update(itemVO itemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			
			pstmt.setString(1, itemVO.getItemName());
			pstmt.setInt(2, itemVO.getPrice());
			pstmt.setString(3, itemVO.getIntroduction());
			pstmt.setString(4, itemVO.getProductSpecifications());
			pstmt.setInt(5, itemVO.getInventory());
			pstmt.setInt(6, itemVO.getSalesVolume());
			pstmt.setDate(7, itemVO.getShelfDate());
			pstmt.setInt(8, itemVO.getItemId());
			
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
	public void delete(Integer itemId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, itemId);

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
	public itemVO findByPrimaryKey(Integer itemId) {

		itemVO itemVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, itemId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				itemVO = new itemVO();
				itemVO.setItemId(rs.getInt("itemId"));
				itemVO.setItemName(rs.getString("itemName"));
				itemVO.setPrice(rs.getInt("price"));
				itemVO.setIntroduction(rs.getString("introduction"));
				itemVO.setProductSpecifications(rs.getString("productSpecifications"));
				itemVO.setInventory(rs.getInt("inventory"));
				itemVO.setSalesVolume(rs.getInt("salesVolume"));
				itemVO.setShelfDate(rs.getDate("shelfDate"));
				
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
		return itemVO;
	}

	@Override
	public List<itemVO> getAll() {
		List<itemVO> list = new ArrayList<itemVO>();
		itemVO itemVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				itemVO = new itemVO();
				itemVO.setItemId(rs.getInt("itemId"));
				itemVO.setItemName(rs.getString("itemName"));
				itemVO.setPrice(rs.getInt("price"));
				itemVO.setIntroduction(rs.getString("introduction"));
				itemVO.setProductSpecifications(rs.getString("productSpecifications"));
				itemVO.setInventory(rs.getInt("inventory"));
				itemVO.setSalesVolume(rs.getInt("salesVolume"));
				itemVO.setShelfDate(rs.getDate("shelfDate"));
				list.add(itemVO); // Store the row in the list
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

		itemJDBCDAO dao = new itemJDBCDAO();

		// �s�W
//		itemVO itemVO1 = new itemVO();
//		itemVO1.setItemName("�P�ڤj�� FORCE FX ���C");
//		itemVO1.setPrice(10200);
//		itemVO1.setIntroduction("�]�p�F�P�Ӧ۬P�ڤj�ԡG�ƻs�H���Ԥ��k�^���G��Ĭ�d�ӿժ����C�����A���XLED�M���ġA�����W�̰����Ū�������C����");
//		itemVO1.setProductSpecifications("�콦");
//		itemVO1.setInventory(10);
//		itemVO1.setSalesVolume(3);
//		itemVO1.setShelfDate(java.sql.Date.valueOf("2021-07-01"));
//		
//		dao.insert(itemVO1);
//		

//		// �ק�
//		itemVO itemVO2 = new itemVO();
//		itemVO2.setItemId(3001);
//		itemVO2.setItemName("�P�ڤj�ԶªZ�h�O�N�c");
//		itemVO2.setPrice(18000);
//		itemVO2.setIntroduction("�ȶ}�ɼ����H�����ĩI�l�n�A�i�O�N��s/���˶���");
//		itemVO2.setProductSpecifications("ABS���");
//		itemVO2.setInventory(90);
//		itemVO2.setSalesVolume(400);
//		itemVO2.setShelfDate(java.sql.Date.valueOf("2021-07-20"));
//		
//		dao.update(itemVO2);
		
		// �R��
//				dao.delete(3004);

//		// �d��
//		itemVO itemVO3 = dao.findByPrimaryKey(3002);
//		System.out.print(itemVO3.getItemId() + ",");
//		System.out.print(itemVO3.getItemName() + ",");
//		System.out.print(itemVO3.getPrice() + ",");
//		System.out.print(itemVO3.getIntroduction() + ",");
//		System.out.print(itemVO3.getProductSpecifications() + ",");
//		System.out.print(itemVO3.getInventory() + ",");
//		System.out.print(itemVO3.getSalesVolume() + ",");
//		System.out.println(itemVO3.getShelfDate());
//		
//		System.out.println("---------------------");

//		// �d��
		List<itemVO> list = dao.getAll();
		for (itemVO aItemVO : list) {
			System.out.print(aItemVO.getItemId() + ",");
			System.out.print(aItemVO.getItemName() + ",");
			System.out.print(aItemVO.getPrice() + ",");
			System.out.print(aItemVO.getIntroduction() + ",");
			System.out.print(aItemVO.getProductSpecifications() + ",");
			System.out.print(aItemVO.getInventory() + ",");
			System.out.print(aItemVO.getSalesVolume() + ",");
			System.out.println(aItemVO.getShelfDate());
			System.out.println("-----------------------");
		}
	}
}