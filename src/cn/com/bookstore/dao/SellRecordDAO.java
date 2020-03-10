package cn.com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.com.bookstore.db.common.DBManager;
import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.vo.BookVO;
import cn.com.bookstore.vo.SellRecordVO;

public class SellRecordDAO {

	public Vector<Vector<String>> searchSellRecord(SellRecordVO argVO) {
		Vector<Vector<String>> resultVector = new Vector<Vector<String>>();

		String bookId = argVO.getBookId();
		String buyDate = argVO.getBuyDate();

		String sql = "select * from sellrecord where 1=1 ";

		if (!"".equals(bookId) && bookId != null) {
			sql += "and bookid like '%" + bookId + "%'";
		}

		if (!"".equals(buyDate) && buyDate != null) {
			sql += "and buydate = TO_DATE('" + buyDate + "','yyyy-mm-dd')";
		}

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				BookModel model = new BookModel();
				BookVO vo = new BookVO();
				BookVO resultVO = new BookVO();
				vo.setBookId(rs.getString(2));
				resultVO = model.searchSellBookInfo(vo);

				Vector<String> v = new Vector<String>();
				v.add(rs.getString("bookid"));
				v.add(resultVO.getBookName());
				v.add(resultVO.getBid());
				v.add(resultVO.getPrice());
				v.add(rs.getString("quantity"));
				v.add(rs.getDouble("totalPrice") + "0");
				v.add(rs.getDate("buyDate").toString());
				v.add(rs.getDouble("profit") + "0");
				resultVector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return resultVector;
	}

	public void insertSellRecord(SellRecordVO argVO) {

		String sql = "insert into sellrecord values('', '" + argVO.getBookId()
				+ "', '" + argVO.getQuantity() + "', '" + argVO.getTotalPrice()
				+ "', TO_DATE('" + argVO.getBuyDate() + "','YYYY-MM-DD')"
				+ ", " + argVO.getProfit() + ")";

		// String sql = "insert into sellrecord values(?, ?, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st);
		}
	}

	public String countProfit(SellRecordVO argVO) {
		String profit = new String();
		double _profit = 0;
		String sql = "select profit from sellrecord where buydate = TO_DATE('"
				+ argVO.getBuyDate() + "','yyyy-mm-dd')";
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				_profit += rs.getDouble("profit");
			}
			profit = _profit + "0Ԫ";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profit;
	}

	public boolean isSellRecord(BookVO argVO) {
		String sql = "select * from sellrecord where bookid=?";
				
		Connection conn = DBManager.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, argVO.getBookId());
			rs =pst.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void deleteSellRecord(SellRecordVO argVO) {
		  String sql = "delete sellrecord where bookid =?";
		  Connection conn = DBManager.getConnection();
		  PreparedStatement pst = null;
		    
		  try {
		    pst = conn.prepareStatement(sql);
		    pst.setString(1, argVO.getBookId());
		    pst.executeUpdate();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    DBManager.free(conn, pst);
		  }
	  }
}
