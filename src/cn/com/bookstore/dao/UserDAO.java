package cn.com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.com.bookstore.db.common.DBManager;
import cn.com.bookstore.vo.UserVO;

public class UserDAO {

  public UserVO findPasswordByID(UserVO argVO) {
	  UserVO resultVO = new UserVO();
   
	  String sql = "select  password,identity from userinfo where username = ?"; 

    Connection conn = DBManager.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, argVO.getUserName());
      rs = pst.executeQuery();
      if(rs.next()) {
    	  resultVO.setPassword((rs.getString("password"))); 
    	  resultVO.setIdentity((rs.getString("identity")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
    	DBManager.free(conn, pst, rs);
    }
    
    return resultVO;
  }
  
  public boolean isIdExist(UserVO argVO) {
	  String sql = "select * from userinfo where username = ?";
	  Connection conn = DBManager.getConnection();
	 PreparedStatement pst = null;
	  ResultSet rs = null;
	    try {
	      pst = conn.prepareStatement(sql);
	      pst.setString(1, argVO.getUserName());
	      rs = pst.executeQuery();
	      if(rs.next()) {
	    	  return true;
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }finally {
		    DBManager.free(conn, pst);
		}  
	   return false;
	  
  }
  
  public void logon(UserVO argVO) {
	    String sql = "insert into userinfo values(?,?,?)";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement pst = null;
	    
	    try {
	      pst = conn.prepareStatement(sql);
	      pst.setString(1, argVO.getUserName());
	      pst.setString(2, argVO.getPassword());
	      pst.setString(3, argVO.getIdentity());
	      pst.executeQuery();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }finally {
		    DBManager.free(conn, pst);
		}  
	  
  }
  
  public Vector<Vector<String>>  searchUser(UserVO  argVO) {
	    Vector<Vector<String>> resultVector = new Vector<Vector<String>>();
	    String userName = argVO.getUserName();
	    String identity = argVO.getIdentity();
	    
	    String sql = "select * from userinfo where 1=1 ";
	    
	    if(!"".equals(userName) && userName != null) {
	      sql += "and username like '%" + userName + "%'";
	    }
	    
	    if(!"".equals(identity) && identity != null) {
	      sql += "and identity  like '%" + identity + "%'";
	    }
	    
	    Connection conn = DBManager.getConnection();
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    try {
	      pst = conn.prepareStatement(sql);
	      rs = pst.executeQuery();
	      while(rs.next()) {
	        Vector<String> v = new Vector<String>();
	        v.add(rs.getString("username"));
	        v.add(rs.getString("password"));
	        v.add(rs.getString("identity"));
	        resultVector.add(v);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, pst, rs);
	    }
	    
	    return resultVector;
	  }
  
  public void deleteUserInfo(UserVO argVO) {
	  String sql = "delete userinfo where username =?" ;
			  
	  Connection conn = DBManager.getConnection();
	  PreparedStatement pst = null;
	    
	  try {
	    pst = conn.prepareStatement(sql);
	    pst.setString(1, argVO.getUserName());
	    pst.executeUpdate();
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } finally {
	    DBManager.free(conn, pst);
	  }
  }
 
 public void updatePassword(UserVO argVO) {
	    String sql = "update userinfo set password = ?   where username = ?";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement pst = null;
	    
	    try {
	      pst = conn.prepareStatement(sql);
	      pst.setString(1, argVO.getPassword());
	      pst.setString(2, argVO.getUserName());
	      pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	      DBManager.free(conn, pst);
	    }
	  }
	  
}
