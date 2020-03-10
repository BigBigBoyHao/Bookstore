package cn.com.bookstore.control.manageb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.view.DlgBookInfo;
import cn.com.bookstore.view.DlgManager;

public class UpdateActionListener implements ActionListener {

    private DlgManager dialog;
	
	private BookModel model = new BookModel();
	
	public UpdateActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		    DlgBookInfo bookInfoDialog = new DlgBookInfo(dialog, "书籍信息更新", true, "更新"); 
		    JTable tblBookInfo = dialog.getTblBookInfo();
		    int row = tblBookInfo.getSelectedRow();
		    
		    if(row == -1) {
		      JOptionPane.showMessageDialog(dialog, "请选中一行数据！");
		      return;
		    }
		    
		    bookInfoDialog.getTxtBookId().setText((String)tblBookInfo.getValueAt(row, 0));
		    bookInfoDialog.getTxtCategory().setText((String)tblBookInfo.getValueAt(row, 1));
		    bookInfoDialog.getTxtBookName().setText((String)tblBookInfo.getValueAt(row, 2));
		    bookInfoDialog.getTxtAuthor().setText((String)tblBookInfo.getValueAt(row, 3));
		    bookInfoDialog.getTxtPress().setText((String)tblBookInfo.getValueAt(row, 4));
		    bookInfoDialog.getTxtBid().setText((String)tblBookInfo.getValueAt(row, 5));
		    bookInfoDialog.getTxtPrice().setText((String)tblBookInfo.getValueAt(row, 6));
		    bookInfoDialog.getTxtStorage().setText((String)tblBookInfo.getValueAt(row, 7));
		    
		    bookInfoDialog.setVisible(true);
	}

}
