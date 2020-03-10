package cn.com.bookstore.control.manageuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import cn.com.bookstore.model.UserModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.vo.UserVO;

public class SearchUserActionListener implements ActionListener {

	private DlgManager dialog;
	
	private UserModel model = new UserModel();
	
	public SearchUserActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		UserVO argVO = new UserVO();
		
	    String  userName =dialog.getTxtUserName().getText();
	    String  identity =dialog.getTxtIdentity().getText();
	    argVO.setUserName(userName);
	    argVO.setIdentity(identity);
	   
	    Vector<Vector<String>> resultDataRows = 
	          model.searchUser(argVO );
	
	    dialog.updateTable(dialog.getTblUserInfo(),resultDataRows);
	}

}
