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
	      JOptionPane.showMessageDialog(frame, "请输入用户名和密码！");
	      return;
	    } else {
	      
	      if(model.check(argVO) == true) {
	        //弹出主界面
	        frame.dispose();
	        String welcome = argVO.getUserName() + ",   欢迎来到书店管理系统！！";
	        JOptionPane.showMessageDialog(frame, welcome);
	        if(argVO.getIdentity().equals("店员")) {
	        	 new DlgSalesclerk(frame, "花花书店销售界面").setVisible(true);
	        }else if(argVO.getIdentity().equals("管理员")) {
	        	new DlgManager(frame, "花花书店管理界面").setVisible(true);
	        }
	      } else {
	        //   JOptionPane.showMessageDialog(frame, "用户名或密码错误！");
	        return;
	      }
	    }
	  }
	
}

