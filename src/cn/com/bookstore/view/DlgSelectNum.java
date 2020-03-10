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
	  private JLabel lblTitle = new JLabel("您要购买的书籍：");
	  private JLabel lblRTitle = new JLabel("您要退货的书籍：");
	  private JLabel lblBookId = new JLabel("书号");
	  private JTextField txtBookId = new JTextField(8);
	  private JLabel lblBookName = new JLabel("书名");
	  private JTextField txtBookName = new JTextField(8);
	  private JLabel lblAuthor = new JLabel("作者");
	  private JTextField txtAuthor = new JTextField(8);
	  private JLabel lblPrice = new JLabel("单价");
	  private JTextField txtPrice = new JTextField(8);
	  private JLabel lblNum = new JLabel("您 要 购 买 的 数 量：");
	  private JTextField txtNum = new JTextField(8);
	  private JLabel lblReturnNum = new JLabel("您 要 退 货 的 数 量：");
	  private JTextField txtReturnNum = new JTextField(8);
	  
	  private JButton btnCertain = new JButton("确定");
	  private JButton btnCancel = new JButton("取消");
	  
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
			  
			  if(command.equals("购买")) {
				  this.lblTitle.setBounds(20, 10, 120,30);
				  this.add(lblTitle);
				  this.lblTitle.setFont(font);
				  
				  this.lblNum.setBounds(20, 135, 130, 30);
				  this.add(lblNum);
	
			  }
			  
			  if(command.equals("退订")) {
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
			new DlgSelectNum(null, " ",false,"购买").setVisible(true);
		}
}
