package cn.com.bookstore.control.record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.JTable;

import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.SellRecordVO;

public class SearchRecordActionListener implements ActionListener {

	private DlgManager dialog;
	private SellRecordModel model = new SellRecordModel();
	
	public SearchRecordActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent arg0) {

		JTable tblSellRecord = dialog.getTblSellRecord();
		SellRecordVO argVO = new SellRecordVO();
		
		String bookId = dialog.getTxtRecordBookId().getText();
		String buyDate = dialog.getTxtBuyDate().getText();
		argVO.setBookId(bookId);
		argVO.setBuyDate(buyDate);
		
		model.getSellRecord(argVO);
		
		Vector<Vector<String>> resultDataRows = 
		          model.getSellRecord(argVO);
		
		dialog.updateTable(tblSellRecord, resultDataRows);
	}

}
