package cn.com.bookstore.model;

import java.util.Vector;

import cn.com.bookstore.dao.SellRecordDAO;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;

public class SellRecordModel {

	private SellRecordDAO  dao = new SellRecordDAO();;
	  
	public Vector<Vector<String>>  getSellRecord(SellRecordVO  argVO) {
		return dao.searchSellRecord(argVO);
	}
	
	public void insertSellRecord(SellRecordVO argVO) {
		dao.insertSellRecord(argVO);
	}
	
	public String countProfit(SellRecordVO argVO) {
		return dao.countProfit(argVO);
	}
	
	public boolean isSellRecord(BookVO argVO) {
		return dao.isSellRecord(argVO);
	}
	
	public void deleteSellRecord(SellRecordVO argVO) {
		dao.deleteSellRecord(argVO);
	}
}
