package cn.com.bookstore.control.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;

public class ExitActionListener implements ActionListener {

	private JDialog dialog;
	
	public ExitActionListener(DlgSalesclerk dialog) {
		this.dialog = dialog;
	}
	
	public ExitActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		if(JOptionPane.showConfirmDialog(dialog, "确定退出吗？", "提示", 2) == 0) {
			dialog.dispose();
		}
		 
	}

}
