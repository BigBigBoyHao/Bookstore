package cn.com.bookstore.control.entry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.bookstore.model.EntryModel;
import cn.com.bookstore.view.DlgLogon;
import cn.com.bookstore.view.FrmEntry;

public class LogonActionListener implements ActionListener {

   private FrmEntry frame;
	
	private EntryModel model = new EntryModel();
	
	public LogonActionListener( FrmEntry frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		DlgLogon logon = new DlgLogon(frame, "ÓÃ»§×¢²á", true);
		logon.setVisible(true);
	}

}
