package cn.com.bookstore.view;

import java.awt.Dialog;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.com.bookstore.control.common.CancelActionListener;



public class DlgProfit extends JDialog {

	  private Font font = new Font("黑体",Font.BOLD,14);
	  private JLabel lblDate = new JLabel("当前日期：");
	  private JTextField txtDate = new JTextField(15);
	  private JLabel lblProfit = new JLabel("所得利润：");
	  private JTextField txtProfit = new JTextField(15);
	  private JButton btnCertain = new JButton("确定");
	
	public JTextField getTxtDate() {
		return txtDate;
	}

	public JTextField getTxtProfit() {
		return txtProfit;
	}

	public DlgProfit(Dialog owner, String title, boolean modal) {
		super(owner,title,modal);
		init();
	}
	
	private void init() {
	      this.setSize(270, 200);
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  this.setLayout(null);
		  this.setResizable(false);
		 
		  lblDate.setFont(font);
		  lblProfit.setFont(font);
		  this.txtDate.setEditable(false);
		  this.txtProfit.setEditable(false);
		  
		  this.lblDate.setBounds(20, 20, 80, 30);
		  this.add(lblDate);
		  this.txtDate.setBounds(100, 20, 140, 25);
		  this.add(txtDate);
		  this.lblProfit.setBounds(20, 70, 80, 30);
		  this.add(lblProfit);
		  this.txtProfit.setBounds(100,70, 140, 25);
		  this.add(txtProfit);
		  
		  this.btnCertain.setBounds(180, 120, 60, 30);
		  this.add(btnCertain);
		  
		  addListener();
	}
	
	private void addListener() {
		this.btnCertain.addActionListener(new CancelActionListener(this));
	}
	public static void main(String[] args) {
		new DlgProfit(null, "",false).setVisible(true);
	}
}
