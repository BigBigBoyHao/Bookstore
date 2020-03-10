package cn.com.bookstore.control.manageb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.BookVO;

public class DeleteActionListener implements ActionListener {

	private DlgManager dialog;
	
	private BookModel model = new BookModel();
	private SellRecordModel srModel = new SellRecordModel();
	
	public DeleteActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent arg0) {

		JTable tblBookinfo = dialog.getTblBookInfo();
	    int row = tblBookinfo.getSelectedRow();
	    
	    if(row == -1) {
	      JOptionPane.showMessageDialog(dialog, "请选中一行数据！");
	      return;
	    }
	     
	    if(JOptionPane.showConfirmDialog(dialog, "确定删除吗？", "提示", 2) == 0) {
	    	BookVO argVO = new BookVO();
		    argVO.setBookId((String)tblBookinfo.getValueAt(row, 0));
		    if(srModel.isSellRecord(argVO)) {
		    	JOptionPane.showMessageDialog(dialog, "无法删除书籍信息，请先清空销售记录中该书的记录信息");
		    }else {
		    	model.deleteBookInfo(argVO);
			    
			    BookVO vo = new BookVO();
			    String bookName = dialog.getTxtBookName().getText();
			    String author = dialog.getTxtAuthor().getText();
			    String category = dialog.getTxtCategory().getText();
			    vo.setBookName(bookName);
			    vo.setAuthor(author);
			    vo.setCategory(category);
			    
			    Vector<Vector<String>> resultDataRows = 
			        model.getBookInfo(vo,dialog);
			      
			      //刷新班级JTable
			      dialog.updateTable(dialog.getTblBookInfo(), resultDataRows);
		    }
		    
	    }
		
	}

}
