package com.follow.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

public class FollowDAOImpl implements FollowDAO{

// the DB login info, swapped for ds later
//	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	public static final String URL = "jdbc:mysql://35.201.252.250:3306/MOVIEON?serverTimezone=Asia/Taipei";
//	public static final String USER = "root";
//	public static final String PASSWORD = "4579616593";

// the prepared statements
	public static final String CREATE_STMT = "insert into MOVIEON.FOLLOW values(default, ?, ?, ?)";
	public static final String UPDATE_STMT = "update MOVIEON.FOLLOW set sourceID = ?, targetID = ?, updatedAt = ? where followID = ?";
	public static final String DELETEBYID_STMT = "delete from MOVIEON.FOLLOW where followID = ?";
	public static final String FINDBYID_STMT = "select * from MOVIEON.FOLLOW where followID = ?";
	public static final String FINDBYSOURCE_STMT = "select * from MOVIEON.FOLLOW where sourceID = ?";
	public static final String FINDBYTARGET_STMT = "select * from MOVIEON.FOLLOW where targetID = ?";
	public static final String FINDALL_STMT = "select * from MOVIEON.FOLLOW";
	public static final String FINDBYSNT_STMT = "select * from MOVIEON.FOLLOW where sourceID = ? and targetID = ?";
	public static final String DELETEBYSNT_STMT = "delete from MOVIEON.FOLLOW where sourceID = ? and targetID = ?";
// static block to hold	driver used by all
	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MOVIEON");
//			Class.forName(DRIVER);
		} catch (NamingException e) {
//		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
// the CRUD methods		
	@Override
	public void create(FollowVO follow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//Using SDF to create a DataTime String of time now, with format fit for SQL's DateTime.
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
		String currentDateTime = formatter.format(date);
		
		try {
			//改DataSource連線，可以不需要帳密和網址
			con = ds.getConnection(); 
//			con = DriverManager.getConnection(URL,USER,PASSWORD); //先改回來，上線前再換DataSource
			pstmt = con.prepareStatement(CREATE_STMT);
			
//			pstmt.setInt(1, follow.getFollowID());
			pstmt.setInt(1, follow.getSourceID());
			pstmt.setInt(2, follow.getTargetID());
			pstmt.setString(3, currentDateTime);
			
			pstmt.executeUpdate();
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
			
		} finally {
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}

	//Seem to be less than useful
	@Override
	public void update(FollowVO follow) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//	    Date date = new Date();
//		String currentDateTime = formatter.format(date);
//		
//		try {
//			//con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//			pstmt.setInt(1, follow.getSourceID());
//			pstmt.setInt(2, follow.getTargetID());
//			pstmt.setString(3, currentDateTime);
//			pstmt.setInt(4, follow.getFollowID());
//			
//			pstmt.executeUpdate();
//			
//		} catch(SQLException se) {
//			throw new RuntimeException("A database error occured. "+ se.getMessage());
//		} finally {
//			if (pstmt!=null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			if(con!=null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}		
	}

	@Override
	public void deleteByID(int followID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETEBYID_STMT);
			
			pstmt.setInt(1, followID);

			pstmt.executeUpdate();
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (pstmt!=null) {				
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public FollowVO findByID(int followID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FollowVO followVO = new FollowVO();
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDBYID_STMT); 
			
			pstmt.setInt(1, followID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				followVO.setFollowID(rs.getInt("followID"));
				followVO.setSourceID(rs.getInt("sourceID"));
				followVO.setTargetID(rs.getInt("targetID"));
				followVO.setUpdatedAt(rs.getString("updatedAt"));				
			}			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}		
		}
		return followVO;
	}

	@Override
	public List<FollowVO> findAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FollowVO> list = new ArrayList<FollowVO>();		
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDALL_STMT);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FollowVO follow = new FollowVO();
				follow.setFollowID(rs.getInt(1));
				follow.setSourceID(rs.getInt(2));
				follow.setTargetID(rs.getInt(3));
				follow.setUpdatedAt(rs.getString(4));
				
				list.add(follow);
			}			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return list;
	}

	@Override
	public List<FollowVO> findBySource(int userID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FollowVO> list = new ArrayList<FollowVO>();		
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDBYSOURCE_STMT);
			pstmt.setInt(1, userID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FollowVO follow = new FollowVO();
				follow.setFollowID(rs.getInt(1));
				follow.setSourceID(rs.getInt(2));
				follow.setTargetID(rs.getInt(3));
				follow.setUpdatedAt(rs.getString(4));
				
				list.add(follow);
			}			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return list;		
	}
	
	@Override
	public List<FollowVO> findByTarget(int userID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FollowVO> list = new ArrayList<FollowVO>();		
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDBYTARGET_STMT);
			pstmt.setInt(1, userID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FollowVO follow = new FollowVO();
				follow.setFollowID(rs.getInt(1));
				follow.setSourceID(rs.getInt(2));
				follow.setTargetID(rs.getInt(3));
				follow.setUpdatedAt(rs.getString(4));
				
				list.add(follow);
			}			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}				
		return list;				
	}

	@Override
	public FollowVO findBySourceAndTarget(int sourceId, int targetId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FollowVO followVO = null;
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDBYSNT_STMT); 
			
			pstmt.setInt(1, sourceId);
			pstmt.setInt(2, targetId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				followVO = new FollowVO();
				
				followVO.setFollowID(rs.getInt("followID"));
				followVO.setSourceID(rs.getInt("sourceID"));
				followVO.setTargetID(rs.getInt("targetID"));
				followVO.setUpdatedAt(rs.getString("updatedAt"));				
			}			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
		return followVO;
	}

	@Override
	public void deleteBySrouceAndTarget(int sourceId, int targetId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
//			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETEBYSNT_STMT);
			
			pstmt.setInt(1, sourceId);
			pstmt.setInt(2, targetId);

			pstmt.executeUpdate();
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (pstmt!=null) {				
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
}
