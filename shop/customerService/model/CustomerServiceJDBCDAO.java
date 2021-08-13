package com.customerService.model;

import java.util.*;
import java.sql.*;

public class CustomerServiceJDBCDAO implements CustomerServiceDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT =
		"INSERT INTO customerService(msgTime,msgTitle,msgContext,reContext) VALUES (?,?,?,?)";
	private static final String GET_ALL_STMT =
		"SELECT msgId,msgTime,msgTitle,msgContext,reContext FROM customerService order by msgId";
	private static final String GET_ONE_STMT =
		"SELECT msgId,msgTime,msgTitle,msgContext,reContext FROM customerService where msgId = ?";
	private static final String DELETE =
		"DELETE FROM customerService where msgId = ?";
	private static final String UPDATE =
		"UPDATE customerService set msgTime=?, msgTitle=?, msgContext=?, reContext=? where msgId = ?";
	
	
	@Override
	public void insert(CustomerServiceVO customerServiceVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setDate(1, customerServiceVO.getMsgTime());
			pstmt.setString(2, customerServiceVO.getMsgTitle());
			pstmt.setString(3, customerServiceVO.getMsgContext());
			pstmt.setString(4, customerServiceVO.getReContext());
			
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
	public void update(CustomerServiceVO customerServiceVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setDate(1, customerServiceVO.getMsgTime());
			pstmt.setString(2, customerServiceVO.getMsgTitle());
			pstmt.setString(3, customerServiceVO.getMsgContext());
			pstmt.setString(4, customerServiceVO.getReContext());
			pstmt.setInt(5, customerServiceVO.getMsgId());
			
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
	public void delete(Integer msgId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, msgId);
			
			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
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
	public CustomerServiceVO findByPrimaryKey(Integer msgId) {
		
		CustomerServiceVO customerServiceVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, msgId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				customerServiceVO = new CustomerServiceVO();
				customerServiceVO.setMsgId(rs.getInt("msgId"));
				customerServiceVO.setMsgTime(rs.getDate("msgTime"));
				customerServiceVO.setMsgTitle(rs.getString("msgTitle"));
				customerServiceVO.setMsgContext(rs.getString("msgContext"));
				customerServiceVO.setReContext(rs.getString("reContext"));
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
		return customerServiceVO;
	}
		
		
	
	
	@Override
	public List<CustomerServiceVO> getAll() {
		List<CustomerServiceVO> list = new ArrayList<CustomerServiceVO>();
		CustomerServiceVO customerServiceVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				customerServiceVO = new CustomerServiceVO();
				customerServiceVO.setMsgId(rs.getInt("msgId"));
				customerServiceVO.setMsgTime(rs.getDate("msgTime"));
				customerServiceVO.setMsgTitle(rs.getString("msgTitle"));
				customerServiceVO.setMsgContext(rs.getString("msgContext"));
				customerServiceVO.setReContext(rs.getString("reContext"));
				list.add(customerServiceVO);
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
		
		CustomerServiceJDBCDAO dao = new CustomerServiceJDBCDAO();
		
		//新增
		CustomerServiceVO customerServiceVO1 = new CustomerServiceVO();
		customerServiceVO1.setMsgTime(java.sql.Date.valueOf(java.time.LocalDate.now()));
		customerServiceVO1.setMsgTitle("詢問商品顏色");
		customerServiceVO1.setMsgContext("想詢問1號商品之後會有其他顏色嗎?");
		customerServiceVO1.setReContext("");
		
		//修改
		CustomerServiceVO customerServiceVO2 = new CustomerServiceVO();
		customerServiceVO1.setMsgId(001);
		customerServiceVO2.setMsgTime(java.sql.Date.valueOf(java.time.LocalDate.now()));
		customerServiceVO2.setMsgTitle("詢問配送時間?");
		customerServiceVO2.setMsgContext("若今日確認付款的話,預計幾號能出貨呢?");
		customerServiceVO2.setReContext("今日付款的話,預計明日發貨");
		
		// 刪除
		dao.delete(004);
		
		//查詢
		CustomerServiceVO customerServiceVO3 = dao.findByPrimaryKey(003);
		System.out.print(customerServiceVO3.getMsgId() + ",");
		System.out.print(customerServiceVO3.getMsgTime() + ",");
		System.out.print(customerServiceVO3.getMsgTitle() + ",");
		System.out.print(customerServiceVO3.getMsgContext() + ",");
		System.out.println(customerServiceVO3.getReContext());
		System.out.println("---------------------");
		
		//查詢
		List<CustomerServiceVO> list = dao.getAll();
		for(CustomerServiceVO aCustomerService : list) {
			System.out.print(aCustomerService.getMsgId() + ",");
			System.out.print(aCustomerService.getMsgTime() + ",");
			System.out.print(aCustomerService.getMsgTitle() + ",");
			System.out.print(aCustomerService.getMsgContext() + ",");
			System.out.println(aCustomerService.getReContext());
			System.out.println();
		}
	}
}
