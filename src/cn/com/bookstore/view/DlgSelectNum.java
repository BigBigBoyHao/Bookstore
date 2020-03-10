package cn.com.bookstore.view;

import java.awt.Dialog;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.com.bookstore.control.common.CancelActionListener;
import cn.com.bookstore.control.salesbook.CertainActionListener;


public class DlgSelectNum  extends JDialog {

	  private Font font = new Font(Font.MONOSPACED,Font.BOLD,14);
	  private JLabel lblTitle = new JLabel("��Ҫ������鼮��");
	  private JLabel lblRTitle = new JLabel("��Ҫ�˻����鼮��");
	  private JLabel lblBookId = new JLabel("���");
	  private JTextField txtBookId = new JTextField(8);
	  private JLabel lblBookName = new JLabel("����");
	  private JTextField txtBookName = new JTextField(8);
	  private JLabel lblAuthor = new JLabel("����");
	  private JTextField txtAuthor = new JTextField(8);
	  private JLabel lblPrice = new JLabel("����");
	  private JTextField txtPrice = new JTextField(8);
	  private JLabel lblNum = new JLabel("�� Ҫ �� �� �� �� ����");
	  private JTextField txtNum = new JTextField(8);
	  private JLabel lblReturnNum = new JLabel("�� Ҫ �� �� �� �� ����");
	  private JTextField txtReturnNum = new JTextField(8);
	  
	  private JButton btnCertain = new JButton("ȷ��");
	  private JButton btnCancel = new JButton("ȡ��");
	  
	  private String command;
	  
	  public DlgSelectNum(Dialog owner, String title, boolean modal, String command) {
		  super(owner,title,modal);
		  this.command = command;
		  init();
	  }
	  
		public String getCommand() {
		return command;
	}

		public JTextField getTxtBookId() {
			return txtBookId;
		}
	
		public JTextField getTxtBookName() {
			return txtBookName;
		}
	
		public JTextField getTxtAuthor() {
			return txtAuthor;
		}
	
		public JTextField getTxtPrice() {
			return txtPrice;
		}
	
		public JTextField getTxtNum() {
			return txtNum;
		}
	  
		private void init() {
			  this.setSize(450, 250);
			  this.setLocationRelativeTo(null);
			  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  this.setLayout(null);
			  this.setResizable(false);
			  
			  if(command.equals("����")) {
				  this.lblTitle.setBounds(20, 10, 120,30);
				  this.add(lblTitle);
				  this.lblTitle.setFont(font);
				  
				  this.lblNum.setBounds(20, 135, 130, 30);
				  this.add(lblNum);
	
			  }
			  
			  if(command.equals("�˶�")) {
				  this.lblRTitle.setBounds(20, 10, 120,30);
				  this.add(lblRTitle);
				  this.lblRTitle.setFont(font);
				  
				  this.lblReturnNum.setBounds(20, 135, 130, 30);
				  this.add(lblReturnNum);
				  
			  }
			  
			  this.lblBookId.setBounds(20, 45, 30, 30);
			  this.add(lblBookId);
			  
			  this.txtBookId.setBounds(60, 45, 140, 25);
			  this.add(txtBookId);
			  txtBookId.setEditable(false);

			  this.lblBookName.setBounds(20, 90, 30, 30);
			  this.add(lblBookName);
			  
			  this.txtBookName.setBounds(60, 90, 140, 25);
			  this.add(txtBookName);
			  txtBookName.setEditable(false);
			  
			  this.lblAuthor.setBounds(230, 45, 30, 30);
			  this.add(lblAuthor);
			  
			  this.txtAuthor.setBounds(270, 45, 140, 25);
			  this.add(txtAuthor);
			  txtAuthor.setEditable(false);
			  
			  this.lblPrice.setBounds(230, 90, 30, 30);
			  this.add(lblPrice);
			  
			  this.txtPrice.setBounds(270, 90, 140, 25);
			  this.add(txtPrice);
			  txtPrice.setEditable(false);
	
			  txtNum.setText("1");
			  this.txtNum.setBounds(150, 135, 50, 25);
			  this.add(txtNum);
			
			  this.btnCertain.setBounds(270, 170, 60, 30);
			  this.add(btnCertain);
			  this.btnCancel.setBounds(350, 170, 60, 30);
			  this.add(btnCancel);
			  
			  addListener();
		 }
		 
		 private void addListener() {
			 this.btnCancel.addActionListener(new CancelActionListener(this));
			 this.btnCertain.addActionListener(new CertainActionListener(this));
		 }
		 public static void main(String[] args) {
			new DlgSelectNum(null, " ",false,"����").setVisible(true);
		}
}
