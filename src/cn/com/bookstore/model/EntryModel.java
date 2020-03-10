package cn.com.bookstore.model;

import javax.swing.JOptionPane;

import cn.com.bookstore.dao.UserDAO;
import cn.com.bookstore.view.FrmEntry;
import cn.com.bookstore.vo.UserVO;

public class EntryModel {

	private UserDAO dao = new UserDAO();
	private FrmEntry frame;

	public boolean check(UserVO argVO) {
		UserVO resultVO = dao.findPasswordByID(argVO);
		if (argVO.getPassword().equals(resultVO.getPassword())
				&& argVO.getIdentity().equals(resultVO.getIdentity())) {
			return true;
		} else {
			if (!argVO.getPassword().equals(resultVO.getPassword())) {
				JOptionPane.showMessageDialog(frame, "用户名或密码错误！");
			}else {
				JOptionPane.showMessageDialog(frame, "身份不匹配！");
			}
			return false;
		}
	}
	public int jspcheck(String str1,String str2,String str3) {
		UserVO argVO = new UserVO();
		argVO.setIdentity(str1);
		argVO.setUserName(str2);
		argVO.setPassword(str3);
		UserVO resultVO = dao.findPasswordByID(argVO);
		if (argVO.getPassword().equals(resultVO.getPassword())
				&& argVO.getIdentity().equals(resultVO.getIdentity())) {
			return 1;
		} else {
			return 0;
		}
	}
}
