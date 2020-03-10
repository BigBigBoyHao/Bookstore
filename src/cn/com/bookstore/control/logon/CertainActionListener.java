package cn.com.bookstore.control.logon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;


import cn.com.bookstore.model.LogonModel;
import cn.com.bookstore.model.UserModel;
import cn.com.bookstore.view.DlgLogon;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.UserVO;

public class CertainActionListener implements ActionListener {

	private DlgLogon dialog;
	private LogonModel model = new LogonModel();
	private UserModel uModel = new UserModel();
	
	public CertainActionListener(DlgLogon dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String userName = dialog.getTxtUserName().getText();
	    String password = new String(dialog.getTxtPassword().getPassword());
	    String confirm = new String(dialog.getTxtConfirm().getPassword());
	    String identity = (String)(dialog.getCmbIdentity().getSelectedItem());
	    
	    UserVO argVO = new UserVO();
	    argVO.setUserName(userName);
	    argVO.setPassword(password);
	    argVO.setIdentity(identity);
	    
	    if(userName.equals("") || password.equals("")) {
		      JOptionPane.showMessageDialog(dialog, "请输入完整的注册信息！");
		      return;
	    } else {
	      if(model.isIdExist(argVO) == true) {
	    	  JOptionPane.showMessageDialog
              (dialog, "注册失败！用户名已存在！"); 
	    	  return;
	      }if(model.isOvernum(argVO) == true){
	    	  JOptionPane.showMessageDialog
              (dialog, "注册失败！用户名和密码要求小于" + model.LENGTH + "个字符\n请重新输入注册信息！"); 
	    	  return;
	      }if(password.equals( confirm) == false){
	    	  JOptionPane.showMessageDialog
              (dialog, "两次输入密码不一致！"); 
	    	  return;
	      }else{
	    	  model.logon(argVO);
		      JOptionPane.showMessageDialog(dialog, "注册成功！");
		      dialog.dispose();
		      if(dialog.getOwner() instanceof DlgManager) {
		    	  DlgManager mDialog = (DlgManager)(dialog.getOwner()) ;
		    	//刷新用户JTable
			      UserVO vo = new UserVO();
			      Vector<Vector<String>> resultDataRows = new Vector<Vector<String>>();
			      resultDataRows = uModel.searchUser(vo);
		   	      mDialog.getTxtUserName().setText(null);
		   	      mDialog.getTxtIdentity().setText(null);
		   	      JTable tblUserInfo = mDialog.getTblUserInfo();
		   	      mDialog.updateTable(tblUserInfo, resultDataRows);
		      }
		      return; 
	      }
	    }
	}

}
