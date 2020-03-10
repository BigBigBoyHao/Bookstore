package cn.com.bookstore.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.com.bookstore.control.common.ExitActionListener;
import cn.com.bookstore.control.common.SearchActionListener;
import cn.com.bookstore.control.salesbook.SellOrReturnBook;

public class DlgSalesclerk extends JDialog {

	public static final String[] SELLBOOK = 
        {"书号", "类别", "书名", "作者", "出版社", "定价", "库存"};
	public static final String[] RENTBOOK = 
	    {"书号", "类别", "书名", "作者", "出版社", "可借数量"};
	
	private Font font = new Font(Font.MONOSPACED,Font.BOLD,16);
	private Font tableFont = new Font(Font.MONOSPACED,Font.BOLD,12);

	private JLabel lblBookName = new JLabel("书   名");
	private JTextField txtBookName = new JTextField(15);
	private JLabel lblAuthor = new JLabel("作   者");
	private JTextField txtAuthor = new JTextField(15);
	private JButton btnSearch = new JButton("搜索");
	private JTable tblBookInfo;
	private JButton btnSell = new JButton("购买书籍");
	//private JButton btnReturn = new JButton("退订");
	private JButton btnExit = new JButton("退出系统");
	private JTabbedPane tabSellBook = new JTabbedPane();
	
	private JLabel lblRentBookName = new JLabel("书   名");
	private JTextField txtRentBookName = new JTextField(10);
	private JLabel lblRBookAuthor = new JLabel("作   者");
	private JTextField txtRBookAuthor = new JTextField(10);
	private JButton btnRBookSearch = new JButton("搜索");
	private JLabel lblCategory = new JLabel("类别");
	private JTextField txtCategory = new JTextField(10);
	private JTable tblRentBookInfo;
	private JButton btnRent = new JButton("借书");
	private JButton btnReturnBook = new JButton("还书");
	//private JTabbedPane tabRentBook = new JTabbedPane();
	
	
	public JTextField getTxtBookName() {
		return txtBookName;
	}

	public JTextField getTxtAuthor() {
		return txtAuthor;
	}
	
	public JTable getTblBookinfo() {
		return tblBookInfo;
	}
	
	public JButton getBtnSell() {
		return btnSell;
	}
/*
	public JButton getBtnReturn() {
		return btnReturn;
	}
	*/
	public JTextField getTxtCategory() {
		return txtCategory;
	}

	public JTable getTblRentBookInfo() {
		return tblRentBookInfo;
	}

	public JButton getBtnRent() {
		return btnRent;
	}

	public JButton getBtnReturnBook() {
		return btnReturnBook;
	}

	public  DlgSalesclerk (Frame owner, String title) {
		super(owner, title);
		init();
	}

	private void init() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tabbedPane = initTabbedPane();
		tabbedPane.setFont(font);
		this.add(tabbedPane);
	    addListener();
	}
	

	private JTabbedPane initTabbedPane() {
		JPanel sellPane = new JPanel();
		sellPane.setLayout(new BorderLayout());
		  
		sellPane.add(this.initNorthSB(), BorderLayout.NORTH);
		sellPane.add(this.initCenterSB(), BorderLayout.CENTER);
		sellPane.add(this.initSouthSB(), BorderLayout.SOUTH);
	 
	    tabSellBook.addTab("销售书籍", sellPane);
	    
	    /*
	    JPanel rentPane = new JPanel();
	    rentPane.setLayout(new BorderLayout());
		  
	    rentPane.add(this.initNorthRB(), BorderLayout.NORTH);
	    rentPane.add(this.initCenterRB(), BorderLayout.CENTER);
	    rentPane.add(this.initSouthRB(), BorderLayout.SOUTH);
   
		tabSellBook.addTab("租借书籍", rentPane);
		  */
		return tabSellBook;
	}
	
	private JPanel initSouthSB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		btnSell.setFont(font);
		pane.add(btnSell);
		//pane.add(btnReturn);
		btnExit.setFont(font);
		pane.add(btnExit);
		
		return pane;
	}
	
	private JPanel initSouthRB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		pane.add(btnRent);
		pane.add(btnReturnBook);
		//pane.add(btnExit);
		
		return pane;
	}

	private JPanel initNorthSB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
	   //this.lblBookName.setSize(45, 30);
		lblBookName.setFont(font);
		pane.add(lblBookName);
	   //this.txtBookName.setBounds(0, 0, 150, 25);
		pane.add(txtBookName);
		lblAuthor.setFont(font);
		pane.add(lblAuthor);
		pane.add(txtAuthor);
		btnSearch.setFont(font);
		pane.add(btnSearch);
			
	   return pane;
	}

	private JPanel initNorthRB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		pane.add(lblRentBookName);
		pane.add(txtRentBookName);
		pane.add(lblRBookAuthor);
		pane.add(txtRBookAuthor);
		pane.add(lblCategory);
		pane.add(txtCategory);
		pane.add(btnRBookSearch);
			
	    return pane;
	}
	private JPanel initCenterSB() {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());
	    
	    tblBookInfo = new JTable(new String[][]{}, SELLBOOK);
	    tblBookInfo.setFont(tableFont);
	    tblBookInfo.setRowHeight(30);
	    this.setTblColumnSize(tblBookInfo);
	    
	    JScrollPane sPane = new JScrollPane(tblBookInfo,
	    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    pane.add(sPane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	private JPanel initCenterRB() {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());
	    
	    tblRentBookInfo = new JTable(new String[][]{}, RENTBOOK);
	    this.setTblColumnSize(tblRentBookInfo);
	    JScrollPane sPane = new JScrollPane(tblRentBookInfo,
	    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    pane.add(sPane, BorderLayout.CENTER);
	    
	    return pane;
	 }

	/**
	 * 设置JTable每一列的宽度，单位为像素
	 * @param table  被设置的JTable
	 */
	 public void setTblColumnSize(JTable table) {
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		 table.getColumnModel().getColumn(0).setPreferredWidth(120);
		 table.getColumnModel().getColumn(1).setPreferredWidth(50);
		 table.getColumnModel().getColumn(2).setPreferredWidth(160);
		 table.getColumnModel().getColumn(3).setPreferredWidth(100);
	     table.getColumnModel().getColumn(4).setPreferredWidth(140);
	     table.getColumnModel().getColumn(5).setPreferredWidth(40);
		 table.getColumnModel().getColumn(6).setPreferredWidth(30);
	     /*
	     if(table == tblRentBookInfo){
	    	 table.getColumnModel().getColumn(5).setPreferredWidth(30);
	     }
	     */
	 }
	 
	private void addListener() {
	   	 this.btnExit.addActionListener(new ExitActionListener(this));
	   	 this.btnSearch.addActionListener(new SearchActionListener(this));
		 this.btnSell.addActionListener(new SellOrReturnBook(this));
		// this.btnReturn.addActionListener(new SellOrReturnBook(this));
	}
	
	//刷新图书信息JTable
	public void updateTable (JTable table, Vector<Vector<String>> resultDataRows) {
		Vector<String> colNamesVector = new Vector<String>();
	    for(String name : DlgSalesclerk.SELLBOOK) {
	      colNamesVector.add(name);
	    }
	   
	    table.setModel(new DefaultTableModel(resultDataRows, colNamesVector));
	    //重设JTable的列宽
	    setTblColumnSize(table);
	}
	
	public static void main(String[] args) {
		new DlgSalesclerk(null," 销售书籍").setVisible(true);
	}
}
