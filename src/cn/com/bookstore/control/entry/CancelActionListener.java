package cn.com.bookstore.control.entry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.com.bookstore.view.FrmEntry;

public class CancelActionListener implements ActionListener {

	private FrmEntry frame;
	
	public CancelActionListener(FrmEntry frame) {
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {

		frame.dispose();
	}

}
