package com.member.model;

import java.util.*;
import java.sql.*;


public class MemberJDBCDAO implements MemberDAO_interface {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String USER = "root";
	String PASSWORD = "Ab3345678";
	
	private static final String INSERT_STMT = 
		"INSERT INTO MEMBER VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT =
		"SELECT userid, username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt, admin FROM MEMBER order by userid";
	private static final String GET_ONE_STMT =
		"SELECT userid, username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt, admin FROM MEMBER where userid = ?";
	private static final String DELETE = 
		"DELETE FROM MEMBER where userid = ?";
	private static final String UPDATE = 
		"UPDATE MEMBER set userid=?, username=?, email=?, password=?, address=?, mobile=?, joindate=?, profilepic=?, name=?, gender=?, birthday=?, education=?, occupation=?, ig=?, fb=?, twt=?, admin=? where userid = ? ";
	
	@Override
	public void insert(MemberVO memberVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, memberVO.getUserid());
			pstmt.setString(2, memberVO.getUsername());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getPassword());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setString(6, memberVO.getMobile());
			pstmt.setString(7, memberVO.getJoindate());
			pstmt.setString(8, memberVO.getProfilepic());
			pstmt.setString(9, memberVO.getName());
			pstmt.setString(10, memberVO.getGender());
			pstmt.setString(11, memberVO.getBirthday());
			pstmt.setString(12, memberVO.getEducation());
			pstmt.setString(13, memberVO.getOccupation());
			pstmt.setString(14, memberVO.getIg());
			pstmt.setString(15, memberVO.getFb());
			pstmt.setString(16, memberVO.getTwt());
			pstmt.setInt(17, memberVO.getAdmin());
			
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
	public void update(MemberVO memberVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, memberVO.getUserid());
			pstmt.setString(2, memberVO.getUsername());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getPassword());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setString(6, memberVO.getMobile());
			pstmt.setString(7, memberVO.getJoindate());
			pstmt.setString(8, memberVO.getProfilepic());
			pstmt.setString(9, memberVO.getName());
			pstmt.setString(10, memberVO.getGender());
			pstmt.setString(11, memberVO.getBirthday());
			pstmt.setString(12, memberVO.getEducation());
			pstmt.setString(13, memberVO.getOccupation());
			pstmt.setString(14, memberVO.getIg());
			pstmt.setString(15, memberVO.getFb());
			pstmt.setString(16, memberVO.getTwt());
			pstmt.setInt(17, memberVO.getAdmin());
			
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
	public void delete(Integer userid) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, userid);
			
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
	public MemberVO findByPrimaryKey(Integer userid) {
		
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, userid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setUserid(rs.getInt("userid"));
				memberVO.setUsername(rs.getString("username"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setMobile(rs.getString("mobile"));
				memberVO.setJoindate(rs.getString("joindate"));
				memberVO.setProfilepic(rs.getString("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getString("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));
				memberVO.setAdmin(rs.getInt("admin"));
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
		return memberVO;
	}
	
	
	
	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setUserid(rs.getInt("userid"));
				memberVO.setUsername(rs.getString("username"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setMobile(rs.getString("mobile"));
				memberVO.setJoindate(rs.getString("joindate"));
				memberVO.setProfilepic(rs.getString("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getString("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));
				memberVO.setAdmin(rs.getInt("admin"));
				list.add(memberVO);
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
	
	public static void main(String args[]) {
		
		MemberJDBCDAO dao = new MemberJDBCDAO();
		
		//新增
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setUserid(7);
		memberVO1.setUsername("willian");
		memberVO1.setEmail("willianchen123@gmail.com");
		memberVO1.setPassword("willian123456");
		memberVO1.setAddress("忠孝東路5段");
		memberVO1.setMobile("0987654321");
		memberVO1.setJoindate("2021-9-16");
		memberVO1.setProfilepic(null);
		memberVO1.setName("威廉");
		memberVO1.setGender("男");
		memberVO1.setBirthday("1990-10-10");
		memberVO1.setEducation("博士");
		memberVO1.setOccupation("自由業");
		memberVO1.setIg(null);
		memberVO1.setFb(null);
		memberVO1.setTwt(null);
		memberVO1.setAdmin(0);
		dao.insert(memberVO1);
		
		//刪除
//		dao.delete(7);
		
		
		
		
		
		//查詢
		MemberVO memberVO3 = dao.findByPrimaryKey(1);
		System.out.println(memberVO3.getName());
		System.out.println(memberVO3.getAddress());
		
		
		
		//查詢
		List<MemberVO> list = dao.getAll();
		for (MemberVO aMember : list) {
			System.out.println(aMember.getUserid() + ",");
			System.out.println(aMember.getUsername() + ",");
			System.out.println(aMember.getEmail() + ",");
			System.out.println(aMember.getPassword() + ",");
			System.out.println(aMember.getAddress() + ",");
			System.out.println(aMember.getMobile() + ",");
			System.out.println(aMember.getJoindate() + ",");
			System.out.println(aMember.getProfilepic() + ",");
			System.out.println(aMember.getName() + ",");
			System.out.println(aMember.getGender() + ",");
			System.out.println(aMember.getBirthday() + ",");
			System.out.println(aMember.getEducation() + ",");
			System.out.println(aMember.getOccupation() + ",");
			System.out.println(aMember.getIg() + ",");
			System.out.println(aMember.getFb() + ",");
			System.out.println(aMember.getTwt() + ",");
			System.out.println(aMember.getAdmin() + ",");
		}
		
		
	}

}	
