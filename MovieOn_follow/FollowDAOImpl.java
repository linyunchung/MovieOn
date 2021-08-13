package MovieOn_follow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class FollowDAOImpl implements FollowDAO{

// the DB login info
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://mysql0719.jnlyc.cloudns.cl:3306/MOVIEON?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "Ab3345678";

// the prepared statements
	public static final String CREATE_STMT = "insert into FOLLOW values(default, ?, ?, ?)";
	public static final String UPDATE_STMT = "update FOLLOW set sourceID = ?, targetID = ?, updatedAt = ? where followID = ?";
	public static final String DELETEBYID_STMT = "delete from FOLLOW where followID = ?";
	public static final String FINDBYID_STMT = "select * from FOLLOW where followID = ?";
	public static final String FINDBYSOURCE_STMT = "select * from FOLLOW where sourceID = ?";
	public static final String FINDBYTARGET_STMT = "select * from FOLLOW where targetID = ?";
	public static final String FINDALL_STMT = "select * from FOLLOW";
	
// static block to hold	driver used by all
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
// the CRUD methods		
	@Override
	public void create(FollowVO follow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//用SDF新增此刻時間的DateTime String，格式要符合mySQL的DateTime
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
		String currentDateTime = formatter.format(date);
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(CREATE_STMT);
			
//			pstmt.setInt(1, follow.getFollowID());
			pstmt.setInt(1, follow.getSourceID());
			pstmt.setInt(2, follow.getTargetID());
			pstmt.setString(3, currentDateTime);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void update(FollowVO follow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = new Date();
		String currentDateTime = formatter.format(date);
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, follow.getSourceID());
			pstmt.setInt(2, follow.getTargetID());
			pstmt.setString(3, currentDateTime);
			pstmt.setInt(4, follow.getFollowID());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void deleteByID(int followID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETEBYID_STMT);
			
			pstmt.setInt(1, followID);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) {				
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
		FollowVO follow = new FollowVO();
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FINDBYID_STMT); 
			
			pstmt.setInt(1, followID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				follow.setFollowID(rs.getInt("followID"));
				follow.setSourceID(rs.getInt("sourceID"));
				follow.setTargetID(rs.getInt("targetID"));
				follow.setUpdatedAt(rs.getString("updatedAt"));				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
		return follow;
	}

	@Override
	public List<FollowVO> findAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FollowVO> list = new ArrayList<FollowVO>();		
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
			con = DriverManager.getConnection(URL,USER,PASSWORD);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
			con = DriverManager.getConnection(URL,USER,PASSWORD);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}				
		return list;				
	}
	
}
