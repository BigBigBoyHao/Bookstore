package cn.com.bookstore.model;

import cn.com.bookstore.dao.UserDAO;
import cn.com.bookstore.vo.UserVO;

public class LogonModel {

	public static final int LENGTH = 12;
	
	private UserDAO dao = new UserDAO();
	
	public boolean isIdExist(UserVO argVO) {
		return dao.isIdExist(argVO);
	}
	
	public void logon(UserVO argVO) {
		dao.logon(argVO);
	}
	
	public boolean isOvernum(UserVO argVO) {
		if (argVO.getUserName().length() > LENGTH 
				  || argVO.getPassword().length() > LENGTH) {
	       return true;
	    }
		return false;
	}
}
