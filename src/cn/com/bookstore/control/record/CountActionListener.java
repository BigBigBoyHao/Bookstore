package cn.com.bookstore.control.record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgProfit;
import cn.com.bookstore.vo.SellRecordVO;

public class CountActionListener implements ActionListener {

	private  DlgManager dialog;
	private SellRecordModel model = new SellRecordModel();
	
	public  CountActionListener( DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		SellRecordVO argVO = new SellRecordVO();
		String buyDate = dialog.getTxtBuyDate().getText();
		
		if(!buyDate.equals("")) {
			argVO.setBuyDate(buyDate);
			String profit = model.countProfit(argVO);
			
			String date = argVO.getBuyDate();
			DlgProfit proDialog = new DlgProfit(dialog,"统计利润",true);
			proDialog.getTxtDate().setText(date);
			proDialog.getTxtProfit().setText(profit);
			proDialog.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(dialog, "请输入一个确切的日期！");
		}
		
	}

}
