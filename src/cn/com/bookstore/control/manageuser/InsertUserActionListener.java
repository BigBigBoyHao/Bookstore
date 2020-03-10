package cn.com.bookstore.control.manageuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.bookstore.model.EntryModel;
import cn.com.bookstore.view.DlgLogon;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.view.FrmEntry;

public class InsertUserActionListener implements ActionListener {
	   private DlgManager dialog;
		
		private EntryModel model = new EntryModel();
		
		public InsertUserActionListener(DlgManager dialog) {
			this.dialog = dialog;
		}
		
		public void actionPerformed(ActionEvent e) {
			DlgLogon logon = new DlgLogon(dialog, "ÓÃ»§×¢²á", true);
			logon.setVisible(true);
		}

}
