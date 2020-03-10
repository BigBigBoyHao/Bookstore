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
import cn.com.bookstore.control.manageb.DeleteActionListener;
import cn.com.bookstore.control.manageb.InsertActionListener;
import cn.com.bookstore.control.manageb.UpdateActionListener;
import cn.com.bookstore.control.manageuser.DeleteUserActionListener;
import cn.com.bookstore.control.manageuser.InsertUserActionListener;
import cn.com.bookstore.control.manageuser.RevisePswActionListener;
import cn.com.bookstore.control.manageuser.SearchUserActionListener;
import cn.com.bookstore.control.record.CountActionListener;
import cn.com.bookstore.control.record.DeleteRecordActionListener;
import cn.com.bookstore.control.record.SearchRecordActionListener;
import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.vo.SellRecordVO;


public class DlgManager extends JDialog {

	public static final String[] MANAGEBOOK = 
	    {"书号", "类别", "书名", "作者", "出版社","进价", "定价", "库存"};
	
	public static final String[] MANAGEUSER = 
	    {"用户名", "密码", "身份"};
	
	public static final String[] SELLRECORD = 
	    {"书号","书名","进价","单价","数量","总价","购书日期","所得利润"};
	
	private Font font = new Font(Font.MONOSPACED,Font.BOLD,16);
	private Font tableFont = new Font(Font.MONOSPACED,Font.BOLD,12);
	private JLabel lblBookName = new JLabel("书   名");
	private JTextField txtBookName = new JTextField(10);
	private JLabel lblAuthor = new JLabel("作   者");
	private JTextField txtAuthor = new JTextField(8);
	private JLabel lblCategory = new JLabel("类   别");
	private JTextField txtCategory = new JTextField(8);
	private JButton btnSearch = new JButton("搜索");
	private JTable tblBookInfo;
	private JButton btnUpdate = new JButton("修改信息");
	private JButton btnInsert = new JButton("书籍入库");
	private JButton btnDelete = new JButton("删除书籍");
	private JButton btnExit = new JButton("退出系统");
	private JTabbedPane tabManage = new JTabbedPane();
	
	private JLabel lblUserName = new JLabel("用户名");
	private JTextField txtUserName = new JTextField(15);
	private JLabel lblIdentity = new JLabel("身份");
	private JTextField txtIdentity = new JTextField(15);
	private JButton btnUserSearch = new JButton("搜索");
	private JTable tblUserInfo;
	private JButton btnUpdateUser = new JButton("修改密码");
	private JButton btnInsertUser = new JButton("添加用户");
	private JButton btnDeleteUser = new JButton("删除用户");
	
	private JLabel lblRecordBookId = new JLabel("书号");
	private JTextField txtRecordBookId  = new JTextField(15);
	private JLabel lblBuyDate = new JLabel("购买时间");
	private JTextField txtBuyDate= new JTextField(10);
	private JButton btnRecordSearch = new JButton("搜索");
	private JTable tblSellRecord;
	private JButton btnCount = new JButton("统计当前日利润");
	private JButton btnDeleteRecord = new JButton("删除本书记录");
	
	private FrmEntry frame;
	private SellRecordModel model = new SellRecordModel(); 
	
	public  DlgManager (Frame owner, String title) {
		super(owner, title);
		init();
	}
	
	public JTextField getTxtBookName() {
		return txtBookName;
	}
	
	public JTextField getTxtAuthor() {
		return txtAuthor;
	}
	
	public JTextField getTxtCategory() {
		return txtCategory;
	}
	
	public JTable getTblBookInfo() {
		return tblBookInfo;
	}
	
	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JTextField getTxtIdentity() {
		return txtIdentity;
	}

	public JTable getTblUserInfo() {
		return tblUserInfo;
	}

	public JTextField getTxtRecordBookId() {
		return txtRecordBookId;
	}

	public JTextField getTxtBuyDate() {
		return txtBuyDate;
	}
	
	public JTable getTblSellRecord() {
		return tblSellRecord;
	}

	private void init() {

		this.setSize(820, 620);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tabManage = initTabManage();
		tabManage.setFont(font);
		this.add(tabManage);
	    addListener();
	}

	private JTabbedPane initTabManage() {
		  JPanel bookPane = new JPanel();
		  bookPane.setLayout(new BorderLayout());
		  
		  bookPane.add(this.initNorthMB(), BorderLayout.NORTH);
		  bookPane.add(this.initCenterMB(), BorderLayout.CENTER);
		  bookPane.add(this.initSouthMB(), BorderLayout.SOUTH);
       
		  tabManage.addTab("书籍管理", bookPane);
		  
		  JPanel userPane = new JPanel();
		  userPane.setLayout(new BorderLayout());
		  
		  userPane.add(this.initNorthMU(), BorderLayout.NORTH);
		  userPane.add(this.initCenterMU(), BorderLayout.CENTER);
		  userPane.add(this.initSouthMU(), BorderLayout.SOUTH);
       
		  tabManage.addTab("用户管理", userPane);
		  
		  JPanel recordPane = new JPanel();
		  recordPane.setLayout(new BorderLayout());
		  
		  recordPane.add(this.initNorthSR(), BorderLayout.NORTH);
		  recordPane.add(this.initCenterSR(), BorderLayout.CENTER);
		  recordPane.add(this.initSouthSR(), BorderLayout.SOUTH);
       
		  tabManage.addTab("销售记录", recordPane);
		  return tabManage;
	}
	
	private JPanel initSouthMB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		btnUpdate.setFont(font);
		btnInsert.setFont(font);
		btnDelete.setFont(font);
		btnExit.setFont(font);
		pane.add(btnUpdate);
		pane.add(btnInsert);
		pane.add(btnDelete);
		pane.add(btnExit);
		
		return pane;
	}

	private JPanel initNorthMB() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		lblBookName.setFont(font);
		lblAuthor.setFont(font);
		lblCategory.setFont(font);
		btnSearch.setFont(font);
		pane.add(lblBookName);
		pane.add(txtBookName);
		pane.add(lblAuthor);
		pane.add(txtAuthor);
		pane.add(lblCategory);
		pane.add(txtCategory);
		pane.add(btnSearch);
			
	   return pane;
	}

	private JPanel initCenterMB() {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());
	    
	    tblBookInfo = new JTable(new String[][]{}, MANAGEBOOK);
	    tblBookInfo.setFont(tableFont);
	    tblBookInfo.setRowHeight(30);
	    this.setTblColumnSize(tblBookInfo);
	    
	    JScrollPane sPane = new JScrollPane(tblBookInfo,
	    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    pane.add(sPane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	
	private JPanel initSouthMU() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		btnUpdateUser.setFont(font);
		btnInsertUser.setFont(font);
		btnDeleteUser.setFont(font);
		pane.add(btnUpdateUser);
		pane.add(btnInsertUser);
		pane.add(btnDeleteUser);
		//pane.add(btnExit);
		
		return pane;
	}

	private JPanel initNorthMU() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		lblUserName.setFont(font);
		lblIdentity.setFont(font);
		btnUserSearch.setFont(font);
		pane.add(lblUserName);
		pane.add(txtUserName);
		pane.add(lblIdentity);
		pane.add(txtIdentity);
		pane.add(btnUserSearch);
			
	   return pane;
	}

	private JPanel initCenterMU() {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());
	    
	    tblUserInfo = new JTable(new String[][]{}, MANAGEUSER);
	    tblUserInfo.setFont(tableFont);
	    tblUserInfo.setRowHeight(30);
	    JScrollPane sPane = new JScrollPane(tblUserInfo,
	    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    pane.add(sPane, BorderLayout.CENTER);
	    
	    return pane;
	  }

	private JPanel initNorthSR() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		lblRecordBookId.setFont(font);
		lblBuyDate.setFont(font);
		btnRecordSearch.setFont(font);
		pane.add(lblRecordBookId);
		pane.add(txtRecordBookId);
		pane.add(lblBuyDate);
		pane.add(txtBuyDate);
		pane.add(btnRecordSearch);
			
	   return pane;
	}

	private JPanel initCenterSR() {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());
	    
	    tblSellRecord = new JTable(new String[][]{}, SELLRECORD);
	    this.setTblColumnSize(tblSellRecord);
	    tblSellRecord.setRowHeight(30);
	    tblSellRecord.setFont(tableFont);
	    
	    JScrollPane sPane = new JScrollPane(tblSellRecord,
	    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    pane.add(sPane, BorderLayout.CENTER);
	    
	    SellRecordVO vo = new SellRecordVO();
		Vector<Vector<String>> resultDataRows = model.getSellRecord(vo);
	    this.updateTable(tblSellRecord, resultDataRows);
	    
	    return pane;
	  }
	
	private JPanel initSouthSR() {
		JPanel pane = new JPanel();
		FlowLayout layout = new FlowLayout();
		pane.setLayout(layout);
		layout.setAlignment(layout.RIGHT);
		
		btnCount.setFont(font);
		btnDeleteRecord.setFont(font);
		pane.add(btnCount);
		pane.add(btnDeleteRecord);
	
		return pane;
	}
	
	/**
	 * 设置JTable每一列的宽度，单位为像素
	 * @param table  被设置的JTable
	 */
	 public void setTblColumnSize(JTable table) {
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		if(table == tblBookInfo) {
			table.getColumnModel().getColumn(0).setPreferredWidth(120);
			 table.getColumnModel().getColumn(1).setPreferredWidth(50);
			 table.getColumnModel().getColumn(2).setPreferredWidth(160);
			 table.getColumnModel().getColumn(3).setPreferredWidth(80);
		     table.getColumnModel().getColumn(4).setPreferredWidth(140);
		     table.getColumnModel().getColumn(5).setPreferredWidth(30);
		     table.getColumnModel().getColumn(6).setPreferredWidth(30);
		     table.getColumnModel().getColumn(7).setPreferredWidth(40);
			 
		}
		
		if(table == tblSellRecord) {
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			 table.getColumnModel().getColumn(1).setPreferredWidth(160);
			 table.getColumnModel().getColumn(2).setPreferredWidth(40);
			 table.getColumnModel().getColumn(3).setPreferredWidth(40);
		     table.getColumnModel().getColumn(4).setPreferredWidth(20);
		     table.getColumnModel().getColumn(5).setPreferredWidth(60);
		     table.getColumnModel().getColumn(6).setPreferredWidth(100);
		     table.getColumnModel().getColumn(7).setPreferredWidth(60);
			 
		}
		 
	 }
	
	//刷新JTable
		public void updateTable (JTable table, Vector<Vector<String>> resultDataRows) {
			
			Vector<String> colNamesVector = new Vector<String>();
			if(table == tblBookInfo) {
				for(String name : DlgManager.MANAGEBOOK) {
				      colNamesVector.add(name);
				}
		    }
			if(table == tblUserInfo) {
				for(String name : DlgManager.MANAGEUSER) {
				      colNamesVector.add(name);
				}
		    }
		    
			if(table == tblSellRecord) {
				for(String name : DlgManager.SELLRECORD) {
				      colNamesVector.add(name);
				}
			}
		    table.setModel(new DefaultTableModel(resultDataRows, colNamesVector));
		    //重设JTable的列宽
		    if(table !=  tblUserInfo) {
		    	setTblColumnSize(table);
		    }
		}
		
	private void addListener() {

		this.btnDelete.addActionListener(new DeleteActionListener(this));
		this.btnSearch.addActionListener(new SearchActionListener(this));
		this.btnUpdate.addActionListener(new UpdateActionListener(this));
		this.btnInsert.addActionListener(new InsertActionListener(this));
		this.btnExit.addActionListener(new ExitActionListener(this));
		
		this.btnUserSearch.addActionListener(new SearchUserActionListener(this));
		this.btnDeleteUser.addActionListener(new DeleteUserActionListener(this));
		this.btnUpdateUser.addActionListener(new RevisePswActionListener(this));
		this.btnInsertUser.addActionListener(new InsertUserActionListener(this));
		
		this.btnRecordSearch.addActionListener(new SearchRecordActionListener(this));
		this.btnCount.addActionListener(new CountActionListener(this));
		this.btnDeleteRecord.addActionListener(new DeleteRecordActionListener(this));
	 }
	
	public static void main(String[] args) {
		new DlgManager(null," ").setVisible(true);
	}
	
		
}
