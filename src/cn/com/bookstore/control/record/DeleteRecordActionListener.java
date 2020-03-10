package cn.com.bookstore.control.record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;

public class DeleteRecordActionListener implements ActionListener {

	private DlgManager dialog;

	// private BookModel model = new BookModel();
	private SellRecordModel model = new SellRecordModel();

	public DeleteRecordActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent arg0) {

		JTable tblSellRecord = dialog.getTblSellRecord();
		String bookId = dialog.getTxtRecordBookId().getText();

		if (!bookId.equals("")) {
			if (JOptionPane.showConfirmDialog(dialog, "确定删除吗？", "提示", 2) == 0) {
				SellRecordVO argVO = new SellRecordVO();
				argVO.setBookId(bookId);
				model.deleteSellRecord(argVO);
				
				Vector<Vector<String>> resultDataRows = model.getSellRecord(argVO);
				dialog.updateTable(dialog.getTblSellRecord(), resultDataRows);
				
			}
		}else {
			JOptionPane.showMessageDialog(dialog, "请输入一个有效的书号！");
		}

	}

}
