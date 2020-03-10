package cn.com.bookstore.vo;


public class SellRecordVO {

	  private String bookId; 
	  private String quantity; 
	  private String totalPrice;
	  private String buyDate;
	  private String profit;
	  
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String  getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getProfit() {
		return profit;
	}
	
	public void setProfit(String profit) {
		this.profit = profit;
	}
	  
	  
}
