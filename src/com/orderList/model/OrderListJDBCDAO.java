package com.orderList.model;

import java.util.*;
import java.sql.*;

public class OrderListJDBCDAO implements OrderListDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "4579616593";

	private static final String INSERT_STMT = 
			"INSERT INTO orderList(price,itemQty,orderId,itemId) VALUES (?,?,?,?)";
	private static final String GET_ALL_STMT = 
			"SELECT orderListId,price,itemQty,orderId,itemId FROM orderList order by orderListId";
	private static final String GET_ALL_STMT_BY_ORDER_ID = 
			"SELECT orderListId,price,itemQty,orderId,itemId FROM orderList where orderId = ? order by orderListId";
	private static final String GET_ONE_STMT = 
			"SELECT orderListId,price,itemQty,orderId,itemId FROM orderList where orderListId = ?";
	private static final String UPDATE = 
			"UPDATE orderList set price=?, itemQty=?, orderId=?, itemId=? where orderListId = ?";



	@Override
	public void insert(OrderListVO orderListVO, List<OrderListVO> orderListVOList, Connection con) {
		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(INSERT_STMT);	
			
			pstmt.setInt(1, orderListVO.getPrice());
			pstmt.setInt(2, orderListVO.getItemQty());
			pstmt.setInt(3, orderListVO.getOrderId());
			pstmt.setInt(4, orderListVO.getItemId());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			try {
				// 發生例外即進行rollback動作
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}
			

	
	@Override
	public void insert(OrderListVO orderListVO, List<OrderListVO> orderListVOList) {
		// TODO Auto-generated method stub

	}

	
	
	
	@Override
	public void update(OrderListVO orderListVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orderListVO.getPrice());
			pstmt.setInt(2, orderListVO.getItemQty());
			pstmt.setInt(3, orderListVO.getOrderId());
			pstmt.setInt(4, orderListVO.getItemId());
			pstmt.setInt(5, orderListVO.getOrderListId());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public OrderListVO findByPrimaryKey(Integer orderListId) {

		OrderListVO orderListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orderListId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderListId(rs.getInt("orderListId"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setItemQty(rs.getInt("itemQty"));
				orderListVO.setOrderId(rs.getInt("orderId"));
				orderListVO.setItemId(rs.getInt("itemId"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return orderListVO;
	}

	@Override
	public List<OrderListVO> getAll() {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		OrderListVO orderListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderListId(rs.getInt("orderListId"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setItemQty(rs.getInt("itemQty"));
				orderListVO.setOrderId(rs.getInt("orderId"));
				orderListVO.setItemId(rs.getInt("itemId"));
				list.add(orderListVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	@Override
	public List<OrderListVO> getByOrderId(Integer orderId) {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		OrderListVO orderListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT_BY_ORDER_ID);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderListId(rs.getInt("orderListId"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setItemQty(rs.getInt("itemQty"));
				orderListVO.setOrderId(rs.getInt("orderId"));
				orderListVO.setItemId(rs.getInt("itemId"));
				list.add(orderListVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		OrderListJDBCDAO dao = new OrderListJDBCDAO();

		// 新增
//		OrderListVO orderListVO1 = new OrderListVO();
//		orderListVO1.setPrice(650);
//		orderListVO1.setItemQty(3);
//		orderListVO1.setOrderId(004);
//		orderListVO1.setItemId(10);
//		dao.insert(orderListVO1);

		// 修改
//		OrderListVO orderListVO2 = new OrderListVO();
//		orderListVO2.setOrderListId(0001);
//		orderListVO2.setPrice(300);
//		orderListVO2.setItemQty(1);
//		orderListVO2.setOrderId(001);
//		orderListVO2.setItemId(05);
//		dao.update(orderListVO2);

		// 查詢
		OrderListVO orderListVO3 = dao.findByPrimaryKey(0002);
		System.out.print(orderListVO3.getOrderListId() + ",");
		System.out.print(orderListVO3.getPrice() + ",");
		System.out.print(orderListVO3.getItemQty() + ",");
		System.out.print(orderListVO3.getOrderId() + ",");
		System.out.println(orderListVO3.getItemId());
		System.out.println("---------------------");

		// 查詢
		List<OrderListVO> list = dao.getAll();
		for (OrderListVO aOrderList : list) {
			System.out.print(aOrderList.getOrderListId() + ",");
			System.out.print(aOrderList.getPrice() + ",");
			System.out.print(aOrderList.getItemQty() + ",");
			System.out.print(aOrderList.getOrderId() + ",");
			System.out.println(aOrderList.getItemId());
			System.out.println();
		}
	}

}
