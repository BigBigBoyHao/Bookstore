package cn.com.bookstore.control.entry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cn.com.bookstore.model.EntryModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.DlgSalesclerk;
import cn.com.bookstore.view.FrmEntry;
import cn.com.bookstore.vo.UserVO;

public class CertainActionListener implements ActionListener {

	private FrmEntry frame;
	
	private EntryModel model = new EntryModel();
	
	public CertainActionListener( FrmEntry frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String userName = frame.getTxtUserName().getText();
	    String password = new String(frame.getTxtPassword().getPassword());
	    String identity = (String)(frame.getCmbIdentity().getSelectedItem());
	    
	     UserVO argVO = new UserVO();
	      argVO.setUserName(userName);
	      argVO.setPassword(password);
	      argVO.setIdentity(identity);
	      
	    if(userName.equals("") || password.equals("")) {
	      JOptionPane.showMessageDialog(frame, "�������û��������룡");
	      return;
	    } else {
	      
	      if(model.check(argVO) == true) {
	        //����������
	        frame.dispose();
	        String welcome = argVO.getUserName() + ",   ��ӭ����������ϵͳ����";
	        JOptionPane.showMessageDialog(frame, welcome);
	        if(argVO.getIdentity().equals("��Ա")) {
	        	 new DlgSalesclerk(frame, "����������۽���").setVisible(true);
	        }else if(argVO.getIdentity().equals("����Ա")) {
	        	new DlgManager(frame, "�������������").setVisible(true);
	        }
	      } else {
	        //   JOptionPane.showMessageDialog(frame, "�û������������");
	        return;
	      }
	    }
	  }
	
}

