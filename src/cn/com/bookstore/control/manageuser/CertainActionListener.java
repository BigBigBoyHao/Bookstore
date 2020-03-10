package cn.com.bookstore.control.manageuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.UserModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgPassword;
import cn.com.bookstore.vo.UserVO;

public class CertainActionListener implements ActionListener {

    private DlgPassword dialog;
    private DlgManager mdialog;
	
	private UserModel model = new UserModel();
	
	public CertainActionListener(DlgPassword dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {

		String userName = new String(dialog.getTxtUserName().getText());
		String oldPassword = new String(dialog.getTxtOldPassword().getPassword());
	    String password = new String(dialog.getTxtPassword().getPassword());
	    String confirm = new String(dialog.getTxtConfirm().getPassword());
	   
	    UserVO argVO = new UserVO();
	    argVO.setUserName(userName);
	    argVO.setPassword(password);
	    
	    if(oldPassword.equals("") || password.equals("") || confirm.equals("")) {
		      JOptionPane.showMessageDialog(dialog, "������������������룡");
		      return;
	    } else {
	    		if(password.equals( confirm) == false){
	  	    	  JOptionPane.showMessageDialog (dialog, "�����������벻һ�£�"); 
	  	    	  return;
	  	         }else{
	  	    	  if(JOptionPane.showConfirmDialog(dialog, "ȷ���޸���", "��ʾ", 2) == 0) {
	  	    		  model.updatePassword(argVO);
	  	    		  dialog.dispose();
	  			      JOptionPane.showMessageDialog(dialog, "�޸ĳɹ���");
	  			      
	  			      //ˢ��JTable
	  			      UserVO vo = new UserVO();
	  			      DlgManager ownerDialog =  (DlgManager)(dialog.getOwner());
	  			      vo.setUserName(ownerDialog.getTxtUserName().getText());
	  			      vo.setIdentity(ownerDialog.getTxtIdentity().getText());
	  			      Vector<Vector<String>> resultDataRows = model.searchUser(vo);
	  			    
	  			      JTable tblUserInfo = ownerDialog.getTblUserInfo();
	  			      ownerDialog.updateTable(tblUserInfo,resultDataRows);
	  			      return; 
	  	    	  }
	  	        }
	     }
	    
	}

}
