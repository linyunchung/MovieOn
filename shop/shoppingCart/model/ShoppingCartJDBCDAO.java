package com.shoppingCart.model;

import java.util.*;
import java.sql.*;

public class ShoppingCartJDBCDAO implements ShoppingCartDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Ab3345678";
	
	private static final String INSERT_STMT =
		"INSERT INTO shoppingCart (itemQty,userId,itemId) VALUES (?,?,?)";
	private static final String GET_ALL_STMT =
		"SELECT cartId,itemQty,userId,itemId FROM shoppingCart order by cartId";
	private static final String GET_ONE_STMT =
		"SELECT cartId,itemQty,userId,itemId FROM shoppingCart where cartId = ?";
	private static final String DELETE =
		"DELETE FROM shoppingCart where cartId =?";
	private static final String UPDATE =
		"UPDATE shoppingCart set itemQty=?, userId=?, itemId=? where cartId = ?";
	
	
	
	@Override
	public void insert(ShoppingCartVO shoppingCartVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, shoppingCartVO.getItemQty());
			pstmt.setInt(2, shoppingCartVO.getUserId());
			pstmt.setInt(3, shoppingCartVO.getItemId());
			
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
	public void update(ShoppingCartVO shoppingCartVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, shoppingCartVO.getItemQty());
			pstmt.setInt(2, shoppingCartVO.getUserId());
			pstmt.setInt(3, shoppingCartVO.getItemId());
			pstmt.setInt(4, shoppingCartVO.getCartId());
			
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
	public void delete(Integer cartId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, cartId);
			
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
	public ShoppingCartVO findByPrimaryKey(Integer cartId) {
		
		ShoppingCartVO shoppingCartVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, cartId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				shoppingCartVO = new ShoppingCartVO();
				shoppingCartVO.setCartId(rs.getInt("cartId"));
				shoppingCartVO.setItemQty(rs.getInt("itemQty"));
				shoppingCartVO.setUserId(rs.getInt("userId"));
				shoppingCartVO.setItemId(rs.getInt("itemId"));
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
		return shoppingCartVO;
	}
		

	
	
	@Override
	public List<ShoppingCartVO> getAll() {
		List<ShoppingCartVO> list = new ArrayList<ShoppingCartVO>();
		ShoppingCartVO shoppingCartVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shoppingCartVO = new ShoppingCartVO();
				shoppingCartVO.setCartId(rs.getInt("cartId"));
				shoppingCartVO.setItemQty(rs.getInt("itemQty"));
				shoppingCartVO.setUserId(rs.getInt("userId"));
				shoppingCartVO.setItemId(rs.getInt("itemId"));
				list.add(shoppingCartVO);
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
		
		ShoppingCartJDBCDAO dao = new ShoppingCartJDBCDAO();
		
		//新增
		ShoppingCartVO shoppingCartVO1 = new ShoppingCartVO();
		shoppingCartVO1.setItemQty(10);
		shoppingCartVO1.setUserId(0005);
		shoppingCartVO1.setItemId(30);
		dao.insert(shoppingCartVO1);
		
		
		//修改
		ShoppingCartVO shoppingCartVO2 = new ShoppingCartVO();
		shoppingCartVO2.setCartId(001);
		shoppingCartVO2.setItemQty(2);
		shoppingCartVO2.setUserId(0001);
		shoppingCartVO2.setItemId(2);
		dao.update(shoppingCartVO2);
		
		
		// 刪除
		dao.delete(004);
		
		
		//查詢
		ShoppingCartVO shoppingCartVO3 = dao.findByPrimaryKey(003);
		System.out.print(shoppingCartVO3.getCartId() + ",");
		System.out.print(shoppingCartVO3.getItemQty() + ",");
		System.out.print(shoppingCartVO3.getUserId() + ",");
		System.out.println(shoppingCartVO3.getItemId());
		System.out.println("---------------------");
		
		
		// 查詢
		List<ShoppingCartVO> list = dao.getAll();
		for (ShoppingCartVO aShoppingCart : list) {
			System.out.print(aShoppingCart.getCartId() + ",");
			System.out.print(aShoppingCart.getItemQty() + ",");
			System.out.print(aShoppingCart.getUserId() + ",");
			System.out.print(aShoppingCart.getItemId());
			System.out.println();
		}
	}
}
