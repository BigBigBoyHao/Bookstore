package cn.com.bookstore.control.salesbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.view.DlgSelectNum;
import cn.com.bookstore.vo.BookVO;

public class SellOrReturnBook implements ActionListener {

	private DlgSalesclerk dialog;
	
	private BookModel model = new BookModel();
	
	public SellOrReturnBook(DlgSalesclerk dialog) {
		this.dialog = dialog;
	}
	
	private void  initSellBookDialog(DlgSelectNum _dialog) {
		JTable tblBookInfo = dialog.getTblBookinfo();
	    int row = tblBookInfo.getSelectedRow();  
	    
		_dialog.getTxtBookId().setText((String)tblBookInfo.getValueAt(row, 0));
		_dialog.getTxtBookName().setText((String)tblBookInfo.getValueAt(row, 2));
		_dialog.getTxtAuthor().setText((String)tblBookInfo.getValueAt(row, 3));
		_dialog.getTxtPrice().setText((String)tblBookInfo.getValueAt(row, 5));
		_dialog.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {

	     JTable tblBookInfo = dialog.getTblBookinfo();
	     int row = tblBookInfo.getSelectedRow();
	     
	     if(row == -1) {
	        JOptionPane.showMessageDialog(dialog, "请选中一行数据！");
	       return;
	     }else {
	    	 
	    	 if( arg0.getSource() == dialog.getBtnSell() &&
	    			 JOptionPane.showConfirmDialog(dialog, "确定购买吗？", "提示", 2) == 0) {
	    		 DlgSelectNum sDialog = new DlgSelectNum(dialog, "购买", true,"购买");
	 		     this.initSellBookDialog(sDialog);
    		    
		     }
	    	 /*
		     if(arg0.getSource() == dialog.getBtnReturn()  &&
		    		 JOptionPane.showConfirmDialog(dialog, "确定退订吗？", "提示", 2) == 0) {
		    	 DlgSelectNum rDialog = new DlgSelectNum(dialog, "退货", true,"退订");
		    	 this.initSellBookDialog(rDialog);
		 		
		     }
		     */    
	     }
	     
	}

}
