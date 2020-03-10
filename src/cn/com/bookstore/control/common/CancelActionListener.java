package cn.com.bookstore.control.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import cn.com.bookstore.view.FrmEntry;

public class CancelActionListener implements ActionListener {

    private JDialog dialog;

	public CancelActionListener( JDialog dialog) {
		this.dialog= dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		dialog.dispose();
	}

}
