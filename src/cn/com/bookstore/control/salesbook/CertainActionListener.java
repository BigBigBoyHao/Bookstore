package cn.com.bookstore.control.salesbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.view.DlgSelectNum;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;

public class CertainActionListener implements ActionListener {

    //private DlgSalesclerk dialog;
	private DlgSelectNum dialog;
	private DlgManager manageDialog;
	
	private BookModel model = new BookModel();
    private SellRecordModel sellRecoModel = new SellRecordModel();
	
	public CertainActionListener( DlgSelectNum dialog) {
		this.dialog = dialog;
	}
	
	private String getDate() {
		Calendar cal=Calendar.getInstance();    
        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");    
        String buyDate = simpleDate.format(cal.getTime());
      
        return buyDate;
	}
	
	public void actionPerformed(ActionEvent e) {

		DlgSalesclerk sDialog = (DlgSalesclerk)(dialog.getOwner());
		JTable tblBookInfo = sDialog.getTblBookinfo();
		int row = tblBookInfo.getSelectedRow();
		String bookId = dialog.getTxtBookId().getText();
    	BookVO argVO = new BookVO();
    	argVO.setBookId(bookId);
         
    	 int num = Integer.parseInt( dialog.getTxtNum().getText());
    	 double price = Double.parseDouble(dialog.getTxtPrice().getText());
    	 double totalPrice = num * price;
    	 
    	 String total = "总金额为：" + totalPrice +"0元";
    	 
    	 if(dialog.getCommand().equals("购买") &&
    			 JOptionPane.showConfirmDialog(dialog, total,  "提示", 2) == 0) {
    		 
	         int storage = Integer.parseInt(tblBookInfo.getValueAt(row, 6).toString()) - num;
	         if(storage<0) {
	        	 JOptionPane.showMessageDialog(null, "对不起，库存不足！无法购买！");
	        	 storage += num;
	        	 argVO.setStorage(storage + "");
	         }else {
	        	 argVO.setStorage(storage + "");
	        	 
	        	 dialog.dispose();
	    		 
	    		 SellRecordVO sellBookVO = new SellRecordVO();
	    		 BookVO bookVO = new BookVO();
	    		 bookVO = model.searchSellBookInfo(argVO);
	    		 sellBookVO.setBookId(bookId);
	    		 sellBookVO.setQuantity(num+"");
	    		 sellBookVO.setTotalPrice(totalPrice +"");
	    		 double bid = Double.parseDouble(bookVO.getBid());
	    		 double profit = num *(price - bid);
	    		 sellBookVO.setProfit(profit + "");
	    		 sellBookVO.setBuyDate(getDate());
	    		 
	    		 sellRecoModel.insertSellRecord(sellBookVO); 
	         }
	     }else {
	    	 int storage = Integer.parseInt(tblBookInfo.getValueAt(row, 6).toString());
	    	 argVO.setStorage(storage+"");
	     }
    	 /*
    	 if(dialog.getCommand().equals("退订") &&
	    		 JOptionPane.showConfirmDialog(dialog, total, "提示", 2) == 0) {
    		 
    	     int storage = Integer.parseInt(tblBookInfo.getValueAt(row, 6).toString()) + num;
	         argVO.setStorage(storage + "");
	         dialog.dispose();
	     }
    	 
    	 */
	    	 model.updateStorage(argVO);
	    	 
	    	 Vector<Vector<String>> resultDataRows = 
	    		    model.getBookInfo(argVO,sDialog);
	    	 
	    	 sDialog.updateTable(sDialog.getTblBookinfo(),resultDataRows);
	     }

}
