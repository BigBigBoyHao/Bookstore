package cn.com.bookstore.vo;

public class RentBookVO {

	private String bookId;
	private String category;
	private String bookName;
	private String author;
	private String press;
	private int rentableNum;
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPress() {
		return press;
	}
	
	public void setPress(String press) {
		this.press = press;
	}
	
	public int getRentableNum() {
		return rentableNum;
	}
	
	public void setRentableNum(int rentableNum) {
		this.rentableNum = rentableNum;
	}
}
