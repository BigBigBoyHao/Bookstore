package cn.com.bookstore.control.manageb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.view.DlgBookInfo;
import cn.com.bookstore.view.DlgManager;

public class InsertActionListener implements ActionListener {

	private DlgManager dialog;
	
	private BookModel model = new BookModel();
	
	public InsertActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
   
		 DlgBookInfo bookInfoDialog = new DlgBookInfo(dialog, "新书籍入库", true, "添加");
		 bookInfoDialog.setVisible(true);
		
	}

}
