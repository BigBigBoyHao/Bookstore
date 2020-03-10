package cn.com.bookstore.control.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JDialog;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.vo.BookVO;

public class SearchActionListener implements ActionListener {

	//private DlgSalesclerk sDialog;
	//private DlgManager mDialog;
	private JDialog dialog;
	
	private BookModel model = new BookModel();
	
	public SearchActionListener(DlgSalesclerk dialog) {
		this.dialog = dialog;
	}
	
	public SearchActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		BookVO argVO = new BookVO();
		if(dialog instanceof DlgSalesclerk) {
		    String bookName =((DlgSalesclerk) dialog).getTxtBookName().getText();
		    String author = ((DlgSalesclerk) dialog).getTxtAuthor().getText();
		    argVO.setBookName(bookName);
		    argVO.setAuthor(author);
		}
		
		if(dialog instanceof DlgManager) {
			    String  bookName = ((DlgManager)dialog).getTxtBookName().getText();
			    String  author =((DlgManager) dialog).getTxtAuthor().getText();
			    String  category = ((DlgManager)dialog).getTxtCategory().getText();
			   argVO.setBookName(bookName);
			   argVO.setAuthor(author);
			   argVO.setCategory(category);
		}
	   
	    
	    Vector<Vector<String>> resultDataRows = 
	          model.getBookInfo(argVO , dialog);
	    if(dialog instanceof DlgSalesclerk) {
	    	((DlgSalesclerk) dialog).updateTable(((DlgSalesclerk) dialog).getTblBookinfo(),resultDataRows);
	    }
	    if(dialog instanceof DlgManager) {
	    	((DlgManager) dialog).updateTable(((DlgManager) dialog).getTblBookInfo(),resultDataRows);
	    }
      }
		
}

