package com.seating.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import com.follow.model.FollowVO;

public class SeatingDAOImpl implements SeatingDAO{
	
	// the DB login info
		public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		public static final String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
		public static final String USER = "root";
		public static final String PASSWORD = "Ab3345678";

	// the prepared statements
		public static final String CREATE_STMT = "insert into Screens values(?, ?, '[]', ?)";
		public static final String UPDATE_STMT = "update Screens set unavailable = ?, updatedAt = ? where screenID = ?";
		public static final String FINDBYID_STMT = "select * from Screens where screenID = ?";
	// static block to hold	driver used by all
//		private static DataSource ds = null;
		static {
			try {
//				Context ctx = new InitialContext();
//				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MOVIEON");
				Class.forName(DRIVER);
//			} catch (NamingException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	

	@Override
	public void newScreening(SeatingVO seating) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//Using SDF to create a DataTime String of time now, with format fit for SQL's DateTime.
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
		String currentDateTime = formatter.format(date);
		
		try {
			//改DataSource連線，可以不需要帳密和網址
//			con = ds.getConnection(); 
			con = DriverManager.getConnection(URL,USER,PASSWORD); //先改回來，上線前再換DataSource
			pstmt = con.prepareStatement(CREATE_STMT);
			
//			pstmt.setInt(1, follow.getFollowID());
			pstmt.setString(1, seating.getScreenID());
			pstmt.setString(2, seating.getLayout());
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

	@Override
	public void book(String screenID, String selected) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
		String currentDateTime = formatter.format(date);
		
		try {
			//con = ds.getConnection();
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setString(1, selected);
			pstmt.setString(2, currentDateTime);
			pstmt.setString(3, screenID);

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
	public SeatingVO findByID (String screenID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SeatingVO seatingVO = new SeatingVO();
		
		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FINDBYID_STMT); 
			
			pstmt.setString(1, screenID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				seatingVO.setScreenID(rs.getString("screenID"));
				seatingVO.setLayout(rs.getString("layout"));
				seatingVO.setUnavailable(rs.getString("unavailable"));
				seatingVO.setUpdatedAt(rs.getString("updatedAt"));				
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
		return seatingVO;		
	}
	
	
}
