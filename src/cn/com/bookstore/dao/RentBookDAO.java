package cn.com.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JDialog;

import cn.com.bookstore.db.common.DBManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.vo.BookVO;

public class RentBookDAO {

	public Vector<Vector<String>>  searchBook(BookVO  argVO,JDialog dialog) {
	    Vector<Vector<String>> resultVector = new Vector<Vector<String>>();
	    String bookName = argVO.getBookName();
	    String author = argVO.getAuthor();
	    String category = argVO.getCategory();
	    
	    String sql = "select * from bookinfo where 1=1 ";
	    
	    if(!"".equals(bookName) && bookName != null) {
	      sql += "and bookname like '%" + bookName + "%'";
	    }
	    
	    if(!"".equals(author) && author != null) {
	      sql += "and author  like '%" + author + "%'";
	    }
	    
	    if(!"".equals(category) && category != null) {
		      sql += "and category  like '%" + category + "%'";
		    }
	    
	    Connection conn = DBManager.getConnection();
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	      st = conn.createStatement();
	      rs = st.executeQuery(sql);
	      while(rs.next()) {
	        Vector<String> v = new Vector<String>();
	        v.add(rs.getString(1));
	        v.add(rs.getString(2));
	        v.add(rs.getString(3));
	        v.add(rs.getString(4));
	        v.add(rs.getString(5));
	        if((dialog instanceof DlgSalesclerk ) == false) {
	        	v.add(rs.getString(6));
	        }
	        v.add(rs.getString(7));
	        v.add(rs.getString(8));
	        resultVector.add(v);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, st, rs);
	    }
	    
	    return resultVector;
	  }
	 
	 public void updateStorage(BookVO argVO) {
		    String sql = "update bookinfo set storage = '" + argVO.getStorage() +
		                                 "' where bookid = '" + argVO.getBookId() + "'";
		    Connection conn = DBManager.getConnection();
		    Statement st = null;
		    
		    try {
		      st = conn.createStatement();
		      st.executeUpdate(sql);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		      DBManager.free(conn, st);
		    }
		  }
	 
	 public void deleteBookInfo(BookVO argVO) {
		  String sql = "delete bookinfo where bookid = '" 
			  + argVO.getBookId() + "'";
		  Connection conn = DBManager.getConnection();
		  Statement st = null;
		    
		  try {
		    st = conn.createStatement();
		    st.executeUpdate(sql);
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    DBManager.free(conn, st);
		  }
	  }
	 
	 public void updateBookinfo(BookVO argVO) {
		    String sql = "update bookinfo set category = '" + argVO.getCategory() + "',"
		                                + "bookname = '"    + argVO.getBookName()    + "'," 
		                                + "author = '"   + argVO.getAuthor()   + "',"   
		                                + "press = '" + argVO.getPress() + "',"
		                                + "bid = '"    + argVO.getBid() + "', "
		                                +"price='" + argVO.getPrice() + "',"
		                                +"storage='" + argVO.getStorage() + "'"
		                          + "where bookid = '" + argVO.getBookId() + "'";
		    Connection conn = DBManager.getConnection();
		    Statement st = null;
		    
		    try {
		      st = conn.createStatement();
		      st.executeUpdate(sql);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		      DBManager.free(conn, st);
		    }
		  }
		  
		  public void insertBookInfo(BookVO argVO) {
		    String sql = "insert into bookinfo values('" + argVO.getBookId() 
		                                     + "', '" + argVO.getCategory()
		                                     + "', '" + argVO.getBookName()
		                                     + "', '" + argVO.getAuthor()
		                                     + "', '" + argVO.getPress()
		                                     + "', " + argVO.getBid()
		                                     + ", " + argVO.getPrice()
		                                     + ", " + argVO.getStorage()+ ")";
		    Connection conn = DBManager.getConnection();
		    Statement st = null;
		    
		    try {
		      st = conn.createStatement();
		      st.executeUpdate(sql);
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, st);
		    }
		    
		  }
}
