package com.orderInfo.model;

import java.util.*;

import com.orderList.model.OrderListJDBCDAO;
import com.orderList.model.OrderListVO;

import java.sql.*;

public class OrderInfoJDBCDAO implements OrderInfoDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";

	private static final String INSERT_STMT = 
			"INSERT INTO orderInfo(orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId,orderTotal,payStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = 
			"SELECT orderId,orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId,orderTotal,payStatus FROM orderInfo order by orderId";
	private static final String GET_ONE_STMT = 
			"SELECT orderId,orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId,orderTotal,payStatus FROM orderInfo where orderId = ?";
	private static final String UPDATE = 
			"UPDATE orderInfo set orderStatus=?, orderDate=?, paymentMethodId=?, deliveryMethodId=?, consignee=?, mobile=?, address=?, invoiceId=?, userId=?, orderTotal=?, payStatus=? where orderId = ?";
	private static final String GET_MYORDERINFO_STMT = 
			"SELECT orderId,orderStatus,orderDate,paymentMethodId,deliveryMethodId,consignee,mobile,address,invoiceId,userId,orderTotal,payStatus FROM orderInfo where userId = ?";

	public Integer insert(OrderInfoVO orderInfoVO, List<OrderListVO> orderListVOList) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Integer next_order_no = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			
			// 1.設定於pstmt.executeUpdate()之前
			con.setAutoCommit(false); 
			
			//先新增訂單
			String cols[] = { "orderId" };
			pstmt = con.prepareStatement(INSERT_STMT, cols);
			pstmt.setString(1, orderInfoVO.getOrderStatus());
			pstmt.setTimestamp(2, orderInfoVO.getOrderDate());
			pstmt.setString(3, orderInfoVO.getPaymentMethodId());
			pstmt.setString(4, orderInfoVO.getDeliveryMethodId());
			pstmt.setString(5, orderInfoVO.getConsignee());
			pstmt.setString(6, orderInfoVO.getMobile());
			pstmt.setString(7, orderInfoVO.getAddress());
			pstmt.setString(8, orderInfoVO.getInvoiceId());
			pstmt.setInt(9, orderInfoVO.getUserId());
			pstmt.setInt(10, orderInfoVO.getOrderTotal());
			pstmt.setString(11, orderInfoVO.getPayStatus());
			pstmt.executeUpdate();

			// 取得對應的自增主鍵值
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_order_no = rs.getInt(1);
				System.out.println("自增主鍵值= " + next_order_no + "(剛新增成功的訂單編號)");
			} else {
				System.out.println("未取得自增主鍵值");
			}
			rs.close();
			
			// 再新增訂單明細內容
			OrderListJDBCDAO OrderList = new OrderListJDBCDAO();
			for (OrderListVO OrderListVO : orderListVOList) {
				OrderListVO.setOrderId(next_order_no);
				OrderList.insert(OrderListVO, orderListVOList, con);
			}
			
			// 2.設定於pstmt.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("新增訂單編號 " + next_order_no + " 時，明細同時被新增完畢");
			
	
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return next_order_no;
	}

	
	
	@Override
	public void update(OrderInfoVO orderInfoVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, orderInfoVO.getOrderStatus());
			pstmt.setTimestamp(2, orderInfoVO.getOrderDate());
			pstmt.setString(3, orderInfoVO.getPaymentMethodId());
			pstmt.setString(4, orderInfoVO.getDeliveryMethodId());
			pstmt.setString(5, orderInfoVO.getConsignee());
			pstmt.setString(6, orderInfoVO.getMobile());
			pstmt.setString(7, orderInfoVO.getAddress());
			pstmt.setString(8, orderInfoVO.getInvoiceId());
			pstmt.setInt(9, orderInfoVO.getUserId());
			pstmt.setInt(10, orderInfoVO.getOrderId());
			pstmt.setInt(11, orderInfoVO.getOrderTotal());
			pstmt.setString(12, orderInfoVO.getPayStatus());
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

			while (rs.next()) {
				orderInfoVO = new OrderInfoVO();
				orderInfoVO.setOrderId(rs.getInt("orderId"));
				orderInfoVO.setOrderStatus(rs.getString("orderStatus"));
				orderInfoVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderInfoVO.setPaymentMethodId(rs.getString("paymentMethodId"));
				orderInfoVO.setDeliveryMethodId(rs.getString("deliveryMethodId"));
				orderInfoVO.setConsignee(rs.getString("consignee"));
				orderInfoVO.setMobile(rs.getString("mobile"));
				orderInfoVO.setAddress(rs.getString("address"));
				orderInfoVO.setInvoiceId(rs.getString("invoiceId"));
				orderInfoVO.setUserId(rs.getInt("userId"));
				orderInfoVO.setOrderTotal(rs.getInt("orderTotal"));
				orderInfoVO.setPayStatus(rs.getString("payStatus"));
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

			while (rs.next()) {
				orderInfoVO = new OrderInfoVO();
				orderInfoVO.setOrderId(rs.getInt("orderId"));
				orderInfoVO.setOrderStatus(rs.getString("orderStatus"));
				orderInfoVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderInfoVO.setPaymentMethodId(rs.getString("paymentMethodId"));
				orderInfoVO.setDeliveryMethodId(rs.getString("deliveryMethodId"));
				orderInfoVO.setConsignee(rs.getString("consignee"));
				orderInfoVO.setMobile(rs.getString("mobile"));
				orderInfoVO.setAddress(rs.getString("address"));
				orderInfoVO.setInvoiceId(rs.getString("invoiceId"));
				orderInfoVO.setUserId(rs.getInt("userId"));
				orderInfoVO.setOrderTotal(rs.getInt("orderTotal"));
				orderInfoVO.setPayStatus(rs.getString("payStatus"));
				list.add(orderInfoVO);
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
//
//		OrderInfoJDBCDAO dao = new OrderInfoJDBCDAO();
//
//		// 新增
//		OrderInfoVO orderInfoVO1 = new OrderInfoVO();
//		orderInfoVO1.setOrderStatus("處理中");
//		orderInfoVO1.setOrderDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
//		orderInfoVO1.setPaymentMethodId("信用卡");
//		orderInfoVO1.setDeliveryMethodId("宅配到府");
//		orderInfoVO1.setConsignee("林政達");
//		orderInfoVO1.setMobile("0981098897");
//		orderInfoVO1.setAddress("台北市中山區南京東路三段219巷6樓");
//		orderInfoVO1.setInvoiceId("QR12435678");
//		orderInfoVO1.setUserId(5);
//		orderInfoVO1.setOrderTotal(300);
//		orderInfoVO1.setPayStatus("已付款");
//		dao.insert(orderInfoVO1);
//
//		// 修改
//		OrderInfoVO orderInfoVO2 = new OrderInfoVO();
//		orderInfoVO2.setOrderId(2);
//		orderInfoVO2.setOrderStatus("已完成");
//		orderInfoVO2.setOrderDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
//		orderInfoVO2.setPaymentMethodId("ATM轉帳");
//		orderInfoVO2.setDeliveryMethodId("宅配到府");
//		orderInfoVO2.setConsignee("吳亞德");
//		orderInfoVO2.setMobile("0988765432");
//		orderInfoVO2.setAddress("100, Mingquan East Road, Taipei, Taiwan");
//		orderInfoVO2.setInvoiceId("MW97602397");
//		orderInfoVO2.setUserId(2);
//		orderInfoVO2.setOrderTotal(600);
//		orderInfoVO2.setPayStatus("已付款");
//		dao.update(orderInfoVO2);
//
//		// 查詢
//		OrderInfoVO orderInfoVO3 = dao.findByPrimaryKey(002);
//		System.out.print(orderInfoVO3.getOrderId() + ",");
//		System.out.print(orderInfoVO3.getOrderStatus() + ",");
//		System.out.print(orderInfoVO3.getOrderDate() + ",");
//		System.out.print(orderInfoVO3.getPaymentMethodId() + ",");
//		System.out.print(orderInfoVO3.getDeliveryMethodId() + ",");
//		System.out.print(orderInfoVO3.getConsignee() + ",");
//		System.out.print(orderInfoVO3.getMobile() + ",");
//		System.out.print(orderInfoVO3.getAddress() + ",");
//		System.out.print(orderInfoVO3.getInvoiceId() + ",");
//		System.out.println(orderInfoVO3.getUserId() + ",");
//		System.out.println(orderInfoVO3.getOrderTotal() + ",");
//		System.out.println(orderInfoVO3.getPayStatus());
//		System.out.println("---------------------");
//
//		// 查詢
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
//			System.out.println(aOrderInfo.getUserId() + ",");
//			System.out.println(aOrderInfo.getOrderTotal() + ",");
//			System.out.println(aOrderInfo.getPayStatus());
//			System.out.println();
//		}
//
	}

	@Override
	public List<OrderInfoVO> getMyOrderInfo(Integer userId) {
		List<OrderInfoVO> list = new ArrayList<OrderInfoVO>();
		OrderInfoVO orderInfoVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_MYORDERINFO_STMT);

			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderInfoVO = new OrderInfoVO();
				orderInfoVO.setOrderId(rs.getInt("orderId"));
				orderInfoVO.setOrderStatus(rs.getString("orderStatus"));
				orderInfoVO.setOrderDate(rs.getTimestamp("orderDate"));
				orderInfoVO.setPaymentMethodId(rs.getString("paymentMethodId"));
				orderInfoVO.setDeliveryMethodId(rs.getString("deliveryMethodId"));
				orderInfoVO.setConsignee(rs.getString("consignee"));
				orderInfoVO.setMobile(rs.getString("mobile"));
				orderInfoVO.setAddress(rs.getString("address"));
				orderInfoVO.setInvoiceId(rs.getString("invoiceId"));
				orderInfoVO.setUserId(rs.getInt("userId"));
				orderInfoVO.setOrderTotal(rs.getInt("orderTotal"));
				orderInfoVO.setPayStatus(rs.getString("payStatus"));
				list.add(orderInfoVO);
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



}
