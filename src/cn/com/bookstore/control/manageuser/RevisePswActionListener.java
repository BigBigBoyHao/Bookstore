package cn.com.bookstore.control.manageuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.UserModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgPassword;

public class RevisePswActionListener implements ActionListener {

   private DlgManager dialog;
	
	private UserModel model = new UserModel();
	
	public RevisePswActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent arg0) {

		DlgPassword passwordDialog = new DlgPassword(dialog, "修改密码", true); 
	    JTable tblUserInfo = dialog.getTblUserInfo();
	    int row = tblUserInfo.getSelectedRow();
	    
	    if(row == -1) {
	      JOptionPane.showMessageDialog(dialog, "请选中一行数据！");
	      return;
	    }
	    
	    passwordDialog.getTxtUserName().setText((String)tblUserInfo.getValueAt(row, 0));
	    
	    passwordDialog.setVisible(true);
	}

}
