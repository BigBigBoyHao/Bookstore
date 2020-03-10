package cn.com.bookstore.model;

import java.util.Vector;

import javax.swing.JDialog;

import cn.com.bookstore.dao.UserDAO;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.UserVO;

public class UserModel {

	private UserDAO dao = new UserDAO();
	
	public Vector<Vector<String>>  searchUser(UserVO  argVO) {
		return dao.searchUser(argVO);
	}
	
	public void deleteUserInfo(UserVO argVO) {
		dao.deleteUserInfo(argVO);
	}
	
	public void updatePassword(UserVO argVO) {
		dao.updatePassword(argVO);
	}
	
}

