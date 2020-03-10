package cn.com.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.swing.JDialog;

import cn.com.bookstore.db.common.DBManager;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;


public class BookDAO {

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
	        v.add(rs.getString("bookid"));
	        v.add(rs.getString("category"));
	        v.add(rs.getString("bookname"));
	        v.add(rs.getString("author"));
	        v.add(rs.getString("press"));
	        if((dialog instanceof DlgSalesclerk ) == false) {
	        	v.add(rs.getDouble("bid") + "0");
	        }
	        
            v.add(rs.getDouble("price") + "0");
	        v.add(rs.getString("storage"));
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
		    String sql = "update bookinfo set storage = ?   where bookid = ?";
		    Connection conn = DBManager.getConnection();
		    PreparedStatement pst = null;
		    
		    try {
		      pst = conn.prepareStatement(sql);
		     // pst.setInt(1, Integer.parseInt(argVO.getStorage()));
		      pst.setString(1, argVO.getStorage());
		      pst.setString(2, argVO.getBookId());
		      pst.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		      DBManager.free(conn, pst);
		    }
		  }
	 
	 public void deleteBookInfo(BookVO argVO) {
		  String sql = "delete bookinfo where bookid =?";
		  Connection conn = DBManager.getConnection();
		  PreparedStatement pst = null;
		    
		  try {
		    pst = conn.prepareStatement(sql);
		    pst.setString(1, argVO.getBookId());
		    pst.executeUpdate();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    DBManager.free(conn, pst);
		  }
	  }
	 
	 public void updateBookinfo(BookVO argVO) {
		    String sql = "update bookinfo set category = ?, bookname = ?,  author = ?, press = ?,"
		                                + "bid = ?,  price=?, storage=?    where bookid = ?";
		    Connection conn = DBManager.getConnection();
		   PreparedStatement pst = null;
		    
		    try {
		      pst = conn.prepareStatement(sql);
		      pst.setString(1, argVO.getCategory());
		      pst.setString(2, argVO.getBookName());
		      pst.setString(3, argVO.getAuthor());
		      pst.setString(4, argVO.getPress());
		      pst.setString(5, argVO.getBid());
		      pst.setString(6, argVO.getPrice());
		      pst.setString(7, argVO.getStorage());
		      pst.setString(8, argVO.getBookId());
		      pst.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		      DBManager.free(conn, pst);
		    }
		  }
		  
		  public void insertBookInfo(BookVO argVO) {
		    String sql = "insert into bookinfo values(?,?,?,?,?,?,?,?)";
		    Connection conn = DBManager.getConnection();
		   PreparedStatement pst = null;
		    
		    try {
		    	  pst = conn.prepareStatement(sql);
		    	  pst.setString(1, argVO.getBookId());
			      pst.setString(2, argVO.getCategory());
			      pst.setString(3, argVO.getBookName());
			      pst.setString(4, argVO.getAuthor());
			      pst.setString(5, argVO.getPress());
			      pst.setString(6, argVO.getBid());
			      pst.setString(7, argVO.getPrice());
			      pst.setString(8, argVO.getStorage());
			      
			      pst.executeUpdate();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, pst);
		    }
		    
		  }
		  
		  public  BookVO  searchSellBookInfo(BookVO  argVO) {
			    BookVO resultVO = new BookVO();
			    String bookId = argVO.getBookId();
			    
			    String sql = "select bookid,bookname,bid,price from bookinfo where  bookid =  ? ";
			    
			    Connection conn = DBManager.getConnection();
			    PreparedStatement pst = null;
			    ResultSet rs = null;
			    try {
			      pst = conn.prepareStatement(sql);
			      pst.setString(1, argVO.getBookId());
			      rs = pst.executeQuery();
			      while(rs.next()) {
			    	  resultVO.setBookId(rs.getString("bookid"));
			    	  resultVO.setBookName(rs.getString("bookname"));
			    	  resultVO.setBid(rs.getDouble("bid") + "0");
			    	  resultVO.setPrice(rs.getDouble("price") + "0");
			      }        
			    } catch (SQLException e) {
			      e.printStackTrace();
			    } finally {
			      DBManager.free(conn, pst, rs);
			    }
			    return resultVO;
		  }
}

