package com.orderlist.model;

import java.util.*;
import java.sql.*;

public class OrderListJDBCDAO implements OrderListDAO_interface{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "Ab3345678";
	
	private static final String INSERT_STMT =
		"INSERT INTO OrderList(price,itemQty,orderRemark,orderId,itemId) VALUES (?,?,?,?,?)";
	private static final String GET_ALL_STMT =
		"SELECT OrderListId,price,itemQty,orderRemark,orderId,itemId FROM OrderList order by orderListId";
	private static final String GET_ONE_STMT =
		"SELECT OrderListId,price,itemQty,orderRemark,orderId,itemId FROM OrderList where orderListId = ?";
	private static final String UPDATE =
		"UPDATE OrderList set price=?, itemQty=?, orderRemark=?, orderId=?, itemId=? where orderListID = ?";
	
	//static block to host DIVER used by all methods
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database DRIVER. "
					+ e.getMessage());
		}
	}
	
	
	@Override
	public void insert(OrderListVO orderListVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, orderListVO.getPrice());
			pstmt.setInt(2, orderListVO.getItemQty());
			pstmt.setString(3, orderListVO.getOrderRemark());
			pstmt.setInt(4, orderListVO.getOrderId());
			pstmt.setInt(5, orderListVO.getItemId());
			
			pstmt.executeUpdate();
			
//		}catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database DRIVER. "
//					+ e.getMessage());
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
	public void update(OrderListVO orderListVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
//			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, orderListVO.getPrice());
			pstmt.setInt(2, orderListVO.getItemQty());
			pstmt.setString(3, orderListVO.getOrderRemark());
			pstmt.setInt(4, orderListVO.getOrderId());
			pstmt.setInt(5, orderListVO.getItemId());
			pstmt.setInt(6, orderListVO.getOrderListId());
			
			pstmt.executeUpdate();
			
//		}catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database DRIVER. "
//					+ e.getMessage());
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
	public OrderListVO findByPrimaryKey(Integer orderListId) {

		OrderListVO orderListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
//			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, orderListId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderListId(rs.getInt("orderListId"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setItemQty(rs.getInt("itemQty"));
				orderListVO.setOrderRemark(rs.getString("orderRemark"));
				orderListVO.setOrderId(rs.getInt("orderId"));
				orderListVO.setItemId(rs.getInt("itemId"));
			}
			
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver."
//							  +e.getMessage());
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
//			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderListId(rs.getInt("orderListId"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setItemQty(rs.getInt("itemQty"));
				orderListVO.setOrderRemark(rs.getString("orderRemark"));
				orderListVO.setOrderId(rs.getInt("orderId"));
				orderListVO.setItemId(rs.getInt("itemId"));
				list.add(orderListVO);
			}
			
//		}catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database DRIVER. "
//					+ e.getMessage());
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
		

//	public static void main(String[] args) {
//		
//		OrderListJDBCDAO dao = new OrderListJDBCDAO();
//		
//		//新增
//		OrderListVO orderListVO1 = new OrderListVO();
//		orderListVO1.setPrice(650);
//		orderListVO1.setItemQty(3);
//		orderListVO1.setOrderRemark("盡快發貨!");
//		orderListVO1.setOrderId(004);
//		orderListVO1.setItemId(10);
//		dao.insert(orderListVO1);
//		
//		//修改
//		OrderListVO orderListVO2 = new OrderListVO();
//		orderListVO2.setOrderListId(0001);
//		orderListVO2.setPrice(300);
//		orderListVO2.setItemQty(1);
//		orderListVO2.setOrderRemark("盡快發貨!");
//		orderListVO2.setOrderId(001);
//		orderListVO2.setItemId(05);
//		dao.update(orderListVO2);
//		
//		// 查詢
//		OrderListVO orderListVO3 = dao.findByPrimaryKey(0002);
//		System.out.print(orderListVO3.getOrderListId() + ",");
//		System.out.print(orderListVO3.getPrice() + ",");
//		System.out.print(orderListVO3.getItemQty() + ",");
//		System.out.print(orderListVO3.getOrderRemark() + ",");
//		System.out.print(orderListVO3.getOrderId() + ",");
//		System.out.println(orderListVO3.getItemId());
//		System.out.println("---------------------");
//		
//		
//		// 查詢
//		List<OrderListVO> list = dao.getAll();
//		for (OrderListVO aOrderList : list) {
//			System.out.print(aOrderList.getOrderListId() + ",");
//			System.out.print(aOrderList.getPrice() + ",");
//			System.out.print(aOrderList.getItemQty() + ",");
//			System.out.print(aOrderList.getOrderRemark() + ",");
//			System.out.print(aOrderList.getOrderId() + ",");
//			System.out.println(aOrderList.getItemId());
//			System.out.println();	
//		}
//	}
}
