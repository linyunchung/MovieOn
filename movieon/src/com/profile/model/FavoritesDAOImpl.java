package com.profile.model;

import java.sql.Connection;
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

import com.follow.model.FollowVO;

public class FavoritesDAOImpl implements FavoritesDAO {

	public static final String CREATE_STMT = "insert into MOVIEON.Favorites values(default, ?, null, null, null, null)";
	public static final String UPDATE_STMT = "update MOVIEON.Favorites set favorites1 = ?, favorites2 = ?, favorites3 = ?, favorites4 = ? where userID = ?";
	public static final String FINDBYID_STMT = "select * from MOVIEON.Favorites where userID = ?";

	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MOVIEON");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(int userID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CREATE_STMT);

			pstmt.setInt(1, userID);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(FavoritesVO favoritesVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, favoritesVO.getFavorites1());
			pstmt.setInt(2, favoritesVO.getFavorites2());
			pstmt.setInt(3, favoritesVO.getFavorites3());
			pstmt.setInt(4, favoritesVO.getFavorites4());
			pstmt.setInt(5, favoritesVO.getUserID());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
		public List<Integer> findByUserID(int userID) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Integer> list = new ArrayList<Integer>();
			
			try {
				con = ds.getConnection(); 
				pstmt = con.prepareStatement(FINDBYID_STMT);
				
				pstmt.setInt(1, userID);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					for (int i = 3; i<=6; i++) {
						if (rs.getInt(i)!=0) {
							list.add(rs.getInt(i));
							}	
						}
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

}
