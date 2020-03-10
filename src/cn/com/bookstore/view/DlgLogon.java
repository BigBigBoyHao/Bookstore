package cn.com.bookstore.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.com.bookstore.control.common.CancelActionListener;
import cn.com.bookstore.control.logon.CertainActionListener;

public class DlgLogon extends JDialog {

	 private Font font = new Font(Font.MONOSPACED,Font.BOLD,18);
	  private JLabel lblTitle = new JLabel("书店管理系统注册");
	  private JLabel lblIdentity = new JLabel("身   份");
	  private JComboBox cmbIdentity = new JComboBox(FrmEntry.identity);
	  private JLabel lblUserName = new JLabel("用 户 名 ");
	  private JTextField txtUserName = new JTextField(10);
	  private JLabel lblPassword = new JLabel("密  码 ");
	  private JPasswordField txtPassword = new JPasswordField(10);
	  private JLabel lblConfirm = new JLabel("确认密码 ");
	  private JPasswordField txtConfirm = new JPasswordField(10);
	  private JButton btnCertain = new JButton("确定");
	  private JButton btnCancel = new JButton("取消");
	  
	  private String command;
	  
	  public DlgLogon(Frame owner, String title, boolean modal) {
		  super(owner,title,modal);
		  this.command = command;
		  init();
	  }
	  
	  public DlgLogon(Dialog owner, String title, boolean modal) {
		  super(owner,title,modal);
		  this.command = command;
		  init();
	  }

	public JComboBox getCmbIdentity() {
		return cmbIdentity;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
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
		 
		  this.lblTitle.setFont(font);
		  this.lblTitle.setBounds(80, 20, 200, 30);
		  this.add(lblTitle);
		  this.lblIdentity.setBounds(60, 60, 80, 30);
		  this.add(lblIdentity);
		  this.cmbIdentity.setBounds(120, 60, 130, 25);
		  this.add(cmbIdentity);

		  this.lblUserName.setBounds(60, 90, 50, 30);
		  this.add(lblUserName);
		  this.txtUserName.setBounds(120, 90, 130, 25);
		  this.add(txtUserName);
		  
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
		  /*
		  this.img.setBounds(0, 0, 320, 240);
		  this.add(img);
		  */
		  this.setResizable(false);
		  //this.setVisible(true);
	  }
	
	private void addListener() {

		this.btnCertain.addActionListener(new CertainActionListener(this));
		this.btnCancel.addActionListener(new CancelActionListener(this));
		
	}
	
	public static void main(String[] args) {
		 //new DlgLogon(null," ",false).setVisible(true); 
	}
	
}
