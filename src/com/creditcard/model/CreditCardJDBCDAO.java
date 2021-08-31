package com.creditcard.model;

import java.sql.*;
import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class CreditCardJDBCDAO implements CreditCardDAO_interface {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String USER = "root";
	String PASSWORD = "Ab3345678";

	private static final String INSERT_STMT = 
			"INSERT INTO CreditCard VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT creditid, userid, creditno, creditexp, cardholder, creditpin FROM CreditCard order by creditid";
	private static final String GET_ONE_STMT = 
			"SELECT creditid, userid, creditno, creditexp, cardholder, creditpin FROM CreditCard where userid = ?";
	private static final String DELETE = 
			"DELETE FROM CreditCard where creditid = ?";
	private static final String UPDATE = 
			"UPDATE CreditCard set creditid=?, userid=?, creditno=?, creditexp=?, cardholder=?, creditpin=?";

	@Override
	public void insert(CreditCardVO creditCardVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, creditCardVO.getCreditid());
			pstmt.setInt(2, creditCardVO.getUserid());
			pstmt.setString(3, creditCardVO.getCreditno());
			pstmt.setString(4, creditCardVO.getCreditexp());
			pstmt.setString(5, creditCardVO.getCardholder());
			pstmt.setString(6, creditCardVO.getCreditpin());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A datebase error occured. " + se.getMessage());
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
	public void update(CreditCardVO creditCardVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, creditCardVO.getCreditid());
			pstmt.setInt(2, creditCardVO.getUserid());
			pstmt.setString(3, creditCardVO.getCreditno());
			pstmt.setString(4, creditCardVO.getCreditexp());
			pstmt.setString(5, creditCardVO.getCardholder());
			pstmt.setString(6, creditCardVO.getCreditpin());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A datebase error occured. " + se.getMessage());
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
	public void delete(Integer creditid) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, creditid);

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
	public CreditCardVO findByPrimaryKey(Integer creditid) {

		CreditCardVO creditCardVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, creditid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				creditCardVO = new CreditCardVO();
				creditCardVO.setCreditid(rs.getInt("creditid"));
				creditCardVO.setUserid(rs.getInt("userid"));
				creditCardVO.setCreditno(rs.getString("creditno"));
				creditCardVO.setCreditexp(rs.getString("creditexp"));
				creditCardVO.setCardholder(rs.getString("cardholder"));
				creditCardVO.setCreditpin(rs.getString("creditpin"));
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
		return creditCardVO;
	}

	@Override
	public List<CreditCardVO> getAll() {

		List<CreditCardVO> list = new ArrayList<CreditCardVO>();
		CreditCardVO creditCardVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				creditCardVO = new CreditCardVO();
				creditCardVO.setCreditid(rs.getInt("creditid"));
				creditCardVO.setUserid(rs.getInt("userid"));
				creditCardVO.setCreditno(rs.getString("creditno"));
				creditCardVO.setCreditexp(rs.getString("creditexp"));
				creditCardVO.setCardholder(rs.getString("cardholder"));
				creditCardVO.setCreditpin(rs.getString("creditpin"));
				list.add(creditCardVO);
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
	
	public static void main(String args[]) {
		
		CreditCardJDBCDAO dao = new CreditCardJDBCDAO();
		
		
		//新增
		CreditCardVO creditCardVO1 = new CreditCardVO();
		creditCardVO1.setCreditid(7);
		creditCardVO1.setUserid(7);
		creditCardVO1.setCreditno("2843036247951632");
		creditCardVO1.setCreditexp("2024-12-12");
		creditCardVO1.setCardholder("chen wei lian");
		creditCardVO1.setCreditpin("606");
		dao.insert(creditCardVO1);
		System.out.println("新增成功");
		
		
		//刪除
//		dao.delete(7);
		
		
		
		
		//查詢
//		CreditCardVO creditCardVO3 = dao.findByPrimaryKey(1);
//		System.out.println(creditCardVO3.getCreditid() + ",");
//		System.out.println(creditCardVO3.getUserid() + ",");
//		System.out.println(creditCardVO3.getCreditno() + ",");
//		System.out.println(creditCardVO3.getCreditexp() + ",");
//		System.out.println(creditCardVO3.getCardholder() + ",");
//		System.out.println(creditCardVO3.getCreditpin() + ",");
		
		//查詢
//		List<CreditCardVO> list = dao.getAll();
//		for (CreditCardVO aCreditCard : list) {
//			System.out.println(aCreditCard.getCreditid() + ",");
//			System.out.println(aCreditCard.getUserid() + ",");
//			System.out.println(aCreditCard.getCreditno() + ",");
//			System.out.println(aCreditCard.getCreditexp() + ",");
//			System.out.println(aCreditCard.getCardholder() + ",");
//			System.out.println(aCreditCard.getCreditpin() + ",");
//		}
	}

}