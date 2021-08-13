package com.orderInfo.model;

import java.util.*;
import java.sql.*;

public class OrderInfoJDBCDAO implements OrderInfoDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";
	
	private static final String INSERT_STMT =
		"INSERT INTO orderInfo(orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = 
		"SELECT orderId,orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId FROM orderInfo order by orderId";
	private static final String GET_ONE_STMT = 
		"SELECT orderId,orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId FROM orderInfo where orderId = ?";
	private static final String UPDATE = 
		"UPDATE orderInfo set orderStatus=?, orderDate=?, paymentMethodId=?, deliveryMethodId=?, consignee=?, mobile=?, address=?, invoiceId=?, userId=? where orderId = ?";
	
	

	@Override
	public void insert(OrderInfoVO orderInfoVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			
			pstmt.setInt(1, orderInfoVO.getOrderStatus());
			pstmt.setDate(2, orderInfoVO.getOrderDate());
			pstmt.setInt(3, orderInfoVO.getPaymentMethodId());
			pstmt.setInt(4, orderInfoVO.getDeliveryMethodId());
			pstmt.setString(5, orderInfoVO.getConsignee());
			pstmt.setString(6, orderInfoVO.getMobile());
			pstmt.setString(7, orderInfoVO.getAddress());
			pstmt.setString(8, orderInfoVO.getInvoiceId());
			pstmt.setInt(9, orderInfoVO.getUserId());
			
			pstmt.executeUpdate();
			
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
	public void update(OrderInfoVO orderInfoVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, orderInfoVO.getOrderStatus());
			pstmt.setDate(2, orderInfoVO.getOrderDate());
			pstmt.setInt(3, orderInfoVO.getPaymentMethodId());
			pstmt.setInt(4, orderInfoVO.getDeliveryMethodId());
			pstmt.setString(5, orderInfoVO.getConsignee());
			pstmt.setString(6, orderInfoVO.getMobile());
			pstmt.setString(7, orderInfoVO.getAddress());
			pstmt.setString(8, orderInfoVO.getInvoiceId());
			pstmt.setInt(9, orderInfoVO.getUserId());
			pstmt.setInt(10, orderInfoVO.getOrderId());
			
			pstmt.executeUpdate();
				
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
	public OrderInfoVO findByPrimaryKey(Integer orderId) {
		
		OrderInfoVO orderInfoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, orderId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderInfoVO = new OrderInfoVO();
				orderInfoVO.setOrderId(rs.getInt("orderId"));
				orderInfoVO.setOrderStatus(rs.getInt("orderStatus"));
				orderInfoVO.setOrderDate(rs.getDate("orderDate"));
				orderInfoVO.setPaymentMethodId(rs.getInt("paymentMethodId"));
				orderInfoVO.setDeliveryMethodId(rs.getInt("deliveryMethodId"));
				orderInfoVO.setConsignee(rs.getString("consignee"));
				orderInfoVO.setMobile(rs.getString("mobile"));
				orderInfoVO.setAddress(rs.getString("address"));
				orderInfoVO.setInvoiceId(rs.getString("invoiceId"));
				orderInfoVO.setUserId(rs.getInt("userId"));
			}
		
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
		return orderInfoVO;
	}

	
	
	@Override
	public List<OrderInfoVO> getAll() {
		List<OrderInfoVO> list = new ArrayList<OrderInfoVO>();
		OrderInfoVO orderInfoVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderInfoVO = new OrderInfoVO();
				orderInfoVO.setOrderId(rs.getInt("orderId"));
				orderInfoVO.setOrderStatus(rs.getInt("orderStatus"));
				orderInfoVO.setOrderDate(rs.getDate("orderDate"));
				orderInfoVO.setPaymentMethodId(rs.getInt("paymentMethodId"));
				orderInfoVO.setDeliveryMethodId(rs.getInt("deliveryMethodId"));
				orderInfoVO.setConsignee(rs.getString("consignee"));
				orderInfoVO.setMobile(rs.getString("mobile"));
				orderInfoVO.setAddress(rs.getString("address"));
				orderInfoVO.setInvoiceId(rs.getString("invoiceId"));
				orderInfoVO.setUserId(rs.getInt("userId"));
				list.add(orderInfoVO);
			}
			
		}catch (ClassNotFoundException e) {
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
		
		OrderInfoJDBCDAO dao = new OrderInfoJDBCDAO();
		
		//穝糤
//		OrderInfoVO orderInfoVO1 = new OrderInfoVO();
//		orderInfoVO1.setOrderStatus(1);
//		orderInfoVO1.setOrderDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
//		orderInfoVO1.setPaymentMethodId(2);
//		orderInfoVO1.setDeliveryMethodId(1);
//		orderInfoVO1.setConsignee("Wendy");
//		orderInfoVO1.setMobile("0981098897");
//		orderInfoVO1.setAddress("カい跋玭ㄊ狥隔琿2196加");
//		orderInfoVO1.setInvoiceId("");
//		orderInfoVO1.setUserId(0005);
//		dao.insert(orderInfoVO1);
		
		//э
//		OrderInfoVO orderInfoVO2 = new OrderInfoVO();
//		orderInfoVO2.setOrderId(001);
//		orderInfoVO2.setOrderStatus(5);
//		orderInfoVO2.setOrderDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
//		orderInfoVO2.setPaymentMethodId(2);
//		orderInfoVO2.setDeliveryMethodId(1);
//		orderInfoVO2.setConsignee("ALLEN");
//		orderInfoVO2.setMobile("0981098897");
//		orderInfoVO2.setAddress("カい跋玭ㄊ狥隔琿2196加");
//		orderInfoVO2.setInvoiceId("MW97602397");
//		orderInfoVO2.setUserId(0001);
//		dao.update(orderInfoVO2);
		
		// 琩高
		OrderInfoVO orderInfoVO3 = dao.findByPrimaryKey(002);
		System.out.print(orderInfoVO3.getOrderId() + ",");
		System.out.print(orderInfoVO3.getOrderStatus() + ",");
		System.out.print(orderInfoVO3.getOrderDate() + ",");
		System.out.print(orderInfoVO3.getPaymentMethodId() + ",");
		System.out.print(orderInfoVO3.getDeliveryMethodId() + ",");
		System.out.print(orderInfoVO3.getConsignee() + ",");
		System.out.print(orderInfoVO3.getMobile() + ",");
		System.out.print(orderInfoVO3.getAddress() + ",");
		System.out.print(orderInfoVO3.getInvoiceId() + ",");
		System.out.println(orderInfoVO3.getUserId());
		System.out.println("---------------------");
		
		// 琩高
//		List<OrderInfoVO> list = dao.getAll();
//		for (OrderInfoVO aOrderInfo : list) {
//			System.out.print(aOrderInfo.getOrderId() + ",");
//			System.out.print(aOrderInfo.getOrderStatus() + ",");
//			System.out.print(aOrderInfo.getOrderDate() + ",");
//			System.out.print(aOrderInfo.getPaymentMethodId() + ",");
//			System.out.print(aOrderInfo.getDeliveryMethodId() + ",");
//			System.out.print(aOrderInfo.getConsignee() + ",");
//			System.out.print(aOrderInfo.getMobile() + ",");
//			System.out.print(aOrderInfo.getAddress() + ",");
//			System.out.print(aOrderInfo.getInvoiceId() + ",");
//			System.out.println(aOrderInfo.getUserId());
//			System.out.println();
		}
		
	}


