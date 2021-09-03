package com.prob.model;

import java.util.*;
import java.sql.*;

public class ProbJDBCDAO implements ProbDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "4579616593";

	private static final String INSERT_STMT = 
		"INSERT INTO PROBLEM (probtime,probtype,content,email) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT probno,probtime,probtype,content,email FROM PROBLEM order by probno";
	private static final String GET_BY_TYPE_STMT = 
		"SELECT probno,probtime,probtype,content,email FROM PROBLEM where probtype = ?";
	private static final String DELETE = 
		"DELETE FROM PROBLEM where probno = ?";
	private static final String UPDATE = 
		"UPDATE PROBLEM  set probtype=? where probno = ?";
	
//	private static final String UPDATE = 
//			"UPDATE  set ename=?, job=?, hiredate=?, sal=?, comm=?, deptno=? where empno = ?";

	@Override
	public void insert(ProbVO probVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setDate(1, probVO.getProbtime());
			pstmt.setString(2, probVO.getProbtype());
			pstmt.setString(3, probVO.getContent());
			pstmt.setString(4, probVO.getEmail());
			

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
	public void update(ProbVO probVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, probVO.getProbtype());
			pstmt.setInt(2, probVO.getProbno());

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
	public void delete(Integer probno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, probno);

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
	public List<ProbVO> findByType(String probtype) {
		List<ProbVO> list = new ArrayList<ProbVO>();

		ProbVO probVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_BY_TYPE_STMT);

			pstmt.setString(1, probtype);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				probVO = new ProbVO();
				probVO.setProbno(rs.getInt("probno"));
				probVO.setProbtime(rs.getDate("probtime"));
				probVO.setProbtype(rs.getString("probtype"));
				probVO.setContent(rs.getString("content"));
				probVO.setEmail(rs.getString("email"));
				list.add(probVO); // Store the row in the list

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

	@Override
	public List<ProbVO> getAll() {
		List<ProbVO> list = new ArrayList<ProbVO>();
		ProbVO probVO = null;

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
				probVO = new ProbVO();
				probVO.setProbno(rs.getInt("probno"));
				probVO.setProbtime(rs.getDate("probtime"));
				probVO.setProbtype(rs.getString("probtype"));				
				probVO.setContent(rs.getString("content"));
				probVO.setEmail(rs.getString("email"));
				list.add(probVO); // Store the row in the list
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

		ProbJDBCDAO dao = new ProbJDBCDAO();

		// 新增
//		ProbVO probVO1 = new ProbVO();
//		probVO1.setProbtime(java.sql.Date.valueOf("2021-08-01"));
//		probVO1.setProbtype("MANAGER");
//		probVO1.setContent("11111111");
//		probVO1.setEmail("java1234@gmail.com");
//		dao.insert(probVO1);
		
//		老師範例		
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);
	

		// 修改
		
//		ProbVO probVO2 = new ProbVO();
//		probVO2.setProbno(1);
//		probVO2.setProbtype("clerk");

		

//	        老師範例
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmp(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

		
		
		// 刪除
//		dao.delete(1);
//      老師範例		
//		dao.delete(7014);

		// 查詢
		
//		ProbVO probVO3 = dao.findByPrimaryKey("MANAGER");
//		System.out.print(probVO3.getProbno() + ",");
//		System.out.print(probVO3.getProbtime() + ",");
//		System.out.print(probVO3.getProbtype() + ",");
//		System.out.print(probVO3.getContent() + ",");
//		System.out.print(probVO3.getEmail() + ",");
//		System.out.println("---------------------");

//      老師範例		
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");

		// 多筆查詢
		List<ProbVO> list = dao.getAll();
		for (ProbVO aEmp : list) {
			System.out.print(aEmp.getProbno() + ",");
			System.out.print(aEmp.getProbtime() + ",");
			System.out.print(aEmp.getProbtype() + ",");
			System.out.print(aEmp.getContent() + ",");
			System.out.print(aEmp.getEmail() + ",");			
			System.out.println();		
		}
		
//		老師範例
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
	}
}