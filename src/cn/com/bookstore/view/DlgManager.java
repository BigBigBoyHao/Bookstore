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
	    {"���", "���", "����", "����", "������","����", "����", "���"};
	
	public static final String[] MANAGEUSER = 
	    {"�û���", "����", "���"};
	
	public static final String[] SELLRECORD = 
	    {"���","����","����","����","����","�ܼ�","��������","��������"};
	
	private Font font = new Font(Font.MONOSPACED,Font.BOLD,16);
	private Font tableFont = new Font(Font.MONOSPACED,Font.BOLD,12);
	private JLabel lblBookName = new JLabel("��   ��");
	private JTextField txtBookName = new JTextField(10);
	private JLabel lblAuthor = new JLabel("��   ��");
	private JTextField txtAuthor = new JTextField(8);
	private JLabel lblCategory = new JLabel("��   ��");
	private JTextField txtCategory = new JTextField(8);
	private JButton btnSearch = new JButton("����");
	private JTable tblBookInfo;
	private JButton btnUpdate = new JButton("�޸���Ϣ");
	private JButton btnInsert = new JButton("�鼮���");
	private JButton btnDelete = new JButton("ɾ���鼮");
	private JButton btnExit = new JButton("�˳�ϵͳ");
	private JTabbedPane tabManage = new JTabbedPane();
	
	private JLabel lblUserName = new JLabel("�û���");
	private JTextField txtUserName = new JTextField(15);
	private JLabel lblIdentity = new JLabel("���");
	private JTextField txtIdentity = new JTextField(15);
	private JButton btnUserSearch = new JButton("����");
	private JTable tblUserInfo;
	private JButton btnUpdateUser = new JButton("�޸�����");
	private JButton btnInsertUser = new JButton("����û�");
	private JButton btnDeleteUser = new JButton("ɾ���û�");
	
	private JLabel lblRecordBookId = new JLabel("���");
	private JTextField txtRecordBookId  = new JTextField(15);
	private JLabel lblBuyDate = new JLabel("����ʱ��");
	private JTextField txtBuyDate= new JTextField(10);
	private JButton btnRecordSearch = new JButton("����");
	private JTable tblSellRecord;
	private JButton btnCount = new JButton("ͳ�Ƶ�ǰ������");
	private JButton btnDeleteRecord = new JButton("ɾ�������¼");
	
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
       
		  tabManage.addTab("�鼮����", bookPane);
		  
		  JPanel userPane = new JPanel();
		  userPane.setLayout(new BorderLayout());
		  
		  userPane.add(this.initNorthMU(), BorderLayout.NORTH);
		  userPane.add(this.initCenterMU(), BorderLayout.CENTER);
		  userPane.add(this.initSouthMU(), BorderLayout.SOUTH);
       
		  tabManage.addTab("�û�����", userPane);
		  
		  JPanel recordPane = new JPanel();
		  recordPane.setLayout(new BorderLayout());
		  
		  recordPane.add(this.initNorthSR(), BorderLayout.NORTH);
		  recordPane.add(this.initCenterSR(), BorderLayout.CENTER);
		  recordPane.add(this.initSouthSR(), BorderLayout.SOUTH);
       
		  tabManage.addTab("���ۼ�¼", recordPane);
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
	 * ����JTableÿһ�еĿ�ȣ���λΪ����
	 * @param table  �����õ�JTable
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
	
	//ˢ��JTable
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
		    //����JTable���п�
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
