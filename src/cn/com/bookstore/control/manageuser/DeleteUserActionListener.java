package cn.com.bookstore.control.manageuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.model.UserModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.UserVO;

public class DeleteUserActionListener implements ActionListener {

	private DlgManager dialog;
	
	private UserModel model = new UserModel();
	
	public DeleteUserActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		JTable tblUserInfo = dialog.getTblUserInfo();
	    int row = tblUserInfo.getSelectedRow();
	    
	    if(row == -1) {
	      JOptionPane.showMessageDialog(dialog, "请选中一行数据！");
	      return;
	    }
	     
	    if(JOptionPane.showConfirmDialog(dialog, "确定删除吗？", "提示", 2) == 0) {
	    	UserVO argVO = new UserVO();
		    argVO.setUserName((String)tblUserInfo.getValueAt(row, 0));
		    model.deleteUserInfo(argVO);
		    
		    UserVO vo = new UserVO();
		    String userName = dialog.getTxtUserName().getText();
		    String identity = dialog.getTxtIdentity().getText();
		    vo.setUserName(userName);
		    vo.setIdentity(identity);
		    
		    Vector<Vector<String>> resultDataRows = 
		        model.searchUser(vo);
		      
		      //刷新JTable
		    dialog.updateTable(dialog.getTblUserInfo(), resultDataRows);
	    }
		
	}


}
