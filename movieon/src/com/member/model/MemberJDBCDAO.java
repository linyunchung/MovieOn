package com.member.model;

import java.util.*;
import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
	String USER = "root";
	String PASSWORD = "4579616593";

	private static final String INSERT_STMT = "INSERT INTO MOVIEON.MEMBER (username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT userid, username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt, admin FROM MOVIEON.MEMBER order by userid";
	private static final String GET_ONE_STMT = "SELECT userid, username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt, admin FROM MOVIEON.MEMBER where userid = ?";
	private static final String DELETE = "DELETE FROM MOVIEON.MEMBER where userid = ?";
	private static final String UPDATE = "UPDATE MOVIEON.MEMBER set profilepic=?, name=?, gender=?, birthday=?, address=?, education=?, occupation=?, ig=?, fb=?, twt=? where userid=?";
	private static final String login = "SELECT * FROM MOVIEON.MEMBER where email=? and password=?";
	private static final String changepwd = "UPDATE MOVIEON.MEMBER set password=? where userid = ?";
	private static final String reset = "SELECT userid, username, email, password, address, mobile, joindate, profilepic, name, gender, birthday, education, occupation, ig, fb, twt, admin FROM MOVIEON.MEMBER where email = ?";

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getUsername());
			pstmt.setString(2, memberVO.getEmail());
			pstmt.setString(3, memberVO.getPassword());
			pstmt.setString(4, memberVO.getAddress());
			pstmt.setString(5, memberVO.getMobile());
			pstmt.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
			pstmt.setBytes(7, memberVO.getProfilepic());
			pstmt.setString(8, memberVO.getName());
			pstmt.setString(9, memberVO.getGender());
			pstmt.setDate(10, memberVO.getBirthday());
			pstmt.setString(11, memberVO.getEducation());
			pstmt.setString(12, memberVO.getOccupation());
			pstmt.setString(13, memberVO.getIg());
			pstmt.setString(14, memberVO.getFb());
			pstmt.setString(15, memberVO.getTwt());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
			pstmt = con.prepareStatement(UPDATE);

	
			pstmt.setBytes(1, memberVO.getProfilepic());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getGender());
			pstmt.setDate(4, memberVO.getBirthday());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setString(6, memberVO.getEducation());
			pstmt.setString(7, memberVO.getOccupation());
			pstmt.setString(8, memberVO.getIg());
			pstmt.setString(9, memberVO.getFb());
			pstmt.setString(10, memberVO.getTwt());
			pstmt.setInt(11, memberVO.getUserid());


			/* pstmt.setInt(16, memberVO.getAdmin()); */

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, userid);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				memberVO.setProfilepic(rs.getBytes("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));
				memberVO.setAdmin(rs.getByte("admin"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				memberVO.setProfilepic(rs.getBytes("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));
				memberVO.setAdmin(rs.getByte("admin"));
				list.add(memberVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		// 新增
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setUsername("kk");
		memberVO1.setEmail("sony123@gmail.com");
		memberVO1.setPassword("sony123456");
		memberVO1.setAddress(null);
		memberVO1.setMobile(null);
		memberVO1.setProfilepic(null);
		memberVO1.setName(null);
		memberVO1.setGender(null);
		memberVO1.setBirthday(null);
		memberVO1.setEducation(null);
		memberVO1.setOccupation(null);
		memberVO1.setIg(null);
		memberVO1.setFb(null);
		memberVO1.setTwt(null);
		memberVO1.setAdmin(null);
		dao.insert(memberVO1);

//		//修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setUserid(7);
//		memberVO2.setUsername("willian");
//		memberVO2.setEmail("willianchen123@gmail.com");
//		memberVO2.setPassword("willian123456");
//		memberVO2.setAddress("忠孝東路5段2號");
//		memberVO2.setMobile("0987654321");
//		memberVO2.setJoindate("2021-9-16");
//		memberVO2.setProfilepic(null);
//		memberVO2.setName("威廉");
//		memberVO2.setGender("男");
//		memberVO2.setBirthday("1990-10-10");
//		memberVO2.setEducation("博士");
//		memberVO2.setOccupation("自由業");
//		memberVO2.setIg(null);
//		memberVO2.setFb(null);
//		memberVO2.setTwt(null);
//		memberVO2.setAdmin(0);
//		dao.update(memberVO2);

		// 刪除
//		dao.delete(7);

		// 查詢
		MemberVO memberVO3 = dao.findByPrimaryKey(1);
		System.out.println(memberVO3.getName());
		System.out.println(memberVO3.getAddress());
		System.out.println(memberVO3.getJoindate());

		// 查詢
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO aMember : list) {
//			System.out.println(aMember.getUserid() + ",");
//			System.out.println(aMember.getUsername() + ",");
//			System.out.println(aMember.getEmail() + ",");
//			System.out.println(aMember.getPassword() + ",");
//			System.out.println(aMember.getAddress() + ",");
//			System.out.println(aMember.getMobile() + ",");
//			System.out.println(aMember.getJoindate() + ",");
//			System.out.println(aMember.getProfilepic() + ",");
//			System.out.println(aMember.getName() + ",");
//			System.out.println(aMember.getGender() + ",");
//			System.out.println(aMember.getBirthday() + ",");
//			System.out.println(aMember.getEducation() + ",");
//			System.out.println(aMember.getOccupation() + ",");
//			System.out.println(aMember.getIg() + ",");
//			System.out.println(aMember.getFb() + ",");
//			System.out.println(aMember.getTwt() + ",");
//			System.out.println(aMember.getAdmin() + ",");
//		}

	}

	@Override
	public MemberVO login(String email, String password) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(login);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setUserid(rs.getInt("userid"));
				memberVO.setUsername(rs.getString("username"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setMobile(rs.getString("mobile"));
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				memberVO.setProfilepic(rs.getBytes("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void changepwd(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(changepwd);
			
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setInt(2, memberVO.getUserid());
			
			pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " 
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
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
	public void updateProfile(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

	
			pstmt.setBytes(1, memberVO.getProfilepic());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getGender());
			pstmt.setDate(4, memberVO.getBirthday());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setString(6, memberVO.getEducation());
			pstmt.setString(7, memberVO.getOccupation());
			pstmt.setString(8, memberVO.getIg());
			pstmt.setString(9, memberVO.getFb());
			pstmt.setString(10, memberVO.getTwt());
			pstmt.setInt(11, memberVO.getUserid());


			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public MemberVO findByEmail(String email) {
		
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(reset);

			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setUserid(rs.getInt("userid"));
				memberVO.setUsername(rs.getString("username"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setMobile(rs.getString("mobile"));
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				memberVO.setProfilepic(rs.getBytes("profilepic"));
				memberVO.setName(rs.getString("name"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setEducation(rs.getString("education"));
				memberVO.setOccupation(rs.getString("occupation"));
				memberVO.setIg(rs.getString("ig"));
				memberVO.setFb(rs.getString("fb"));
				memberVO.setTwt(rs.getString("twt"));
				memberVO.setAdmin(rs.getByte("admin"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	

}
