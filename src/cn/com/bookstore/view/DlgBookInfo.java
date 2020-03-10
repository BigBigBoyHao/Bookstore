package cn.com.bookstore.view;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.com.bookstore.control.common.CancelActionListener;
import cn.com.bookstore.control.manageb.CertainActionListener;

public class DlgBookInfo extends JDialog {

	 private String command;
	 
	  private JLabel lblBookId = new JLabel("���");
	  private JTextField txtBookId = new JTextField(8);
	  private JLabel lblCategory = new JLabel("���");
	  private JTextField txtCategory = new JTextField(8);
	  private JLabel lblBookName = new JLabel("����");
	  private JTextField txtBookName = new JTextField(8);
	  private JLabel lblAuthor = new JLabel("����");
	  private JTextField txtAuthor = new JTextField(8);
	  private JLabel lblPress = new JLabel("������");
	  private JTextField txtPress = new JTextField(8);
	  private JLabel lblBid = new JLabel("����");
	  private JTextField txtBid = new JTextField(8);
	  private JLabel lblPrice = new JLabel("����");
	  private JTextField txtPrice = new JTextField(8);
	  private JLabel lblStorage = new JLabel("�����");
	  private JTextField txtStorage = new JTextField(8);
	  private JLabel lblNum = new JLabel("�������");
	  private JTextField txtNum = new JTextField(8);
	  private JButton btnCertain = new JButton("ȷ��");
	  private JButton btnCancel = new JButton("ȡ��");
	  
	  public DlgBookInfo(Dialog owner, String title, 
		      boolean modal, String command) {
		    super(owner, title, modal);
		    this.command = command;
		    init();
	   }
	  
	  public String getCommand() {
		return command;
	}

	public JTextField getTxtBookId() {
		return txtBookId;
	}

	public JTextField getTxtCategory() {
		return txtCategory;
	}

	public JTextField getTxtBookName() {
		return txtBookName;
	}

	public JTextField getTxtAuthor() {
		return txtAuthor;
	}

	public JTextField getTxtPress() {
		return txtPress;
	}

	public JTextField getTxtBid() {
		return txtBid;
	}
	
	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public JTextField getTxtStorage() {
		return txtStorage;
	}
	  
	 public JTextField getTxtNum() {
		return txtNum;
	}

	private void init() {
		  this.setSize(450, 320);
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  this.setLayout(null);
		  this.setResizable(false);
		  
		  this.lblBookId.setBounds(20, 45, 30, 30);
		  this.add(lblBookId);
		  if(command == "����") {
			  txtBookId.setEnabled(false);
		  }
		  this.txtBookId.setBounds(60, 45, 140, 25);
		  this.add(txtBookId);
		  this.lblCategory.setBounds(230, 45, 30, 30);
		  this.add(lblCategory);
		  this.txtCategory.setBounds(270, 45, 140, 25);
		  this.add(txtCategory);
		  
		  this.lblBookName.setBounds(20, 90, 30, 30);
		  this.add(lblBookName);
		  this.txtBookName.setBounds(60, 90, 140, 25);
		  this.add(txtBookName);
		  this.lblAuthor.setBounds(230, 90, 30, 30);
		  this.add(lblAuthor);
		  this.txtAuthor.setBounds(270, 90, 140, 25);
		  this.add(txtAuthor);
		  
		  this.lblPress.setBounds(15, 135, 40, 30);
		  this.add(lblPress);
		  this.txtPress.setBounds(60, 135, 140, 25);
		  this.add(txtPress);
		  this.lblBid.setBounds(230, 135, 30, 30);
		  this.add(lblBid);
		  this.txtBid.setBounds(270, 135, 140, 25);
		  this.add(txtBid);
		  
		  this.lblPrice.setBounds(20, 180, 30, 30);
		  this.add(lblPrice);
		  this.txtPrice.setBounds(60, 180, 140, 25);
		  this.add(txtPrice);
		  if(command == "���") {
			  this.lblNum.setBounds(210, 180, 60, 30);
			  this.add(lblNum);
			  this.txtNum.setBounds(270, 180, 140, 25);
			  this.add(txtNum);
		  }else {
			  this.lblStorage.setBounds(220, 180,40, 30);
			  this.add(lblStorage);
			  this.txtStorage.setBounds(270, 180, 140, 25);
			  this.add(txtStorage);
		  }
		  this.btnCertain.setBounds(270, 240, 60, 30);
		  this.add(btnCertain);
		  this.btnCancel.setBounds(350, 240, 60, 30);
		  this.add(btnCancel);
		  
		  addListener();
	 }
	 
	 private void addListener() {
		 this.btnCancel.addActionListener(new CancelActionListener(this));
		 this.btnCertain.addActionListener(new CertainActionListener(this));
	 }
	 public static void main(String[] args) {
		new DlgBookInfo(null, " ",false , "����").setVisible(true);
	}
}
