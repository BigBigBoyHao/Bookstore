package cn.com.bookstore.view;

import java.awt.Dialog;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.com.bookstore.control.common.CancelActionListener;
import cn.com.bookstore.control.manageuser.CertainActionListener;



public class DlgPassword extends JDialog {

	 private Font font = new Font(Font.MONOSPACED,Font.BOLD,16);
	  private JLabel lblTitle = new JLabel("修  改  密  码");
	 // private JLabel lblIdentity = new JLabel("身   份");
	 // private JComboBox cmbIdentity = new JComboBox(FrmEntry.identity);
	  private JLabel lblUserName = new JLabel("用 户 名 ");
	  private JTextField txtUserName = new JTextField(10);
	  private JLabel lblOldPassword = new JLabel("原 密 码 ");
	  private JPasswordField txtOldPassword = new JPasswordField(10);
	  private JLabel lblPassword = new JLabel("新 密 码 ");
	  private JPasswordField txtPassword = new JPasswordField(10);
	  private JLabel lblConfirm = new JLabel("确认密码 ");
	  private JPasswordField txtConfirm = new JPasswordField(10);
	  private JButton btnCertain = new JButton("确定");
	  private JButton btnCancel = new JButton("取消");
	  
	  public DlgPassword(Dialog owner, String title, boolean modal) {
		  super(owner,title,modal);
		  init();
	  }
	  
	public JTextField getTxtUserName() {
		return txtUserName;
	}
	
	public JPasswordField getTxtOldPassword() {
		return txtOldPassword;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	
	public JPasswordField getTxtConfirm() {
		return txtConfirm;
	}

	private void init() {
		  this.setSize(320, 280);
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  this.setLayout(null);
		 
		  this.lblTitle.setBounds(100, 20, 200, 30);
		  this.lblTitle.setFont(font);
		  this.add(lblTitle);
		  this.lblUserName.setBounds(60, 60, 80, 30);
		  this.add(lblUserName);
		  this.txtUserName.setBounds(120, 60, 130, 25);
		  this.add(txtUserName);
		  txtUserName.setEditable(false);

		  this.lblOldPassword.setBounds(60, 90, 50, 30);
		  this.add(lblOldPassword);
		  this.txtOldPassword.setBounds(120, 90, 130, 25);
		  this.add(txtOldPassword);
		  
		  this.lblPassword.setBounds(60, 120, 50, 30);
		  this.add(lblPassword);
		  this.txtPassword.setBounds(120, 120, 130, 25);
		  this.add(txtPassword);
		  
		  this.lblConfirm.setBounds(60, 150, 60, 30);
		  this.add(lblConfirm);
		  this.txtConfirm.setBounds(120, 150, 130, 25);
		  this.add(txtConfirm);
		  
		  this.btnCertain.setBounds(80, 190, 60, 30);
		  this.add(btnCertain);
		  this.btnCancel.setBounds(180, 190, 60, 30);
		  this.add(btnCancel);
		  addListener();
		 
		  this.setResizable(false);
	  }
	
	private void addListener() {

		this.btnCertain.addActionListener(new CertainActionListener(this));
		this.btnCancel.addActionListener(new CancelActionListener(this));
		
	}
	
	public static void main(String[] args) {
		new DlgPassword(null," ",false).setVisible(true); 
	}
}
