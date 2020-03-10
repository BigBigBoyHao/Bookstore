package cn.com.bookstore.model;

import java.util.Vector;

import javax.swing.JDialog;

import cn.com.bookstore.dao.BookDAO;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;


public class BookModel {

	private BookDAO  dao = new BookDAO();
	  
	public Vector<Vector<String>>  getBookInfo(BookVO  argVO, JDialog dialog) {
		return dao.searchBook(argVO, dialog);
	}
	  
	  public void  updateStorage(BookVO argVO) {
		  dao.updateStorage(argVO);
	  }
	  
	  public void deleteBookInfo (BookVO argVO) {
		  dao.deleteBookInfo(argVO);
	  }
	  
	  public void updateBookinfo(BookVO argVO) {
		  dao.updateBookinfo(argVO);
	  }
	  
	  public void insertBookInfo(BookVO argVO) {
		  dao.insertBookInfo(argVO);
	  }
	  
	  public BookVO searchSellBookInfo(BookVO argVO) {
		 return  dao.searchSellBookInfo(argVO);
	  }
}
