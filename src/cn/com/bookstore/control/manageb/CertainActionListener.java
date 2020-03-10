package cn.com.bookstore.control.manageb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.view.DlgBookInfo;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.BookVO;

public class CertainActionListener implements ActionListener {

   private DlgBookInfo dialog;
   private BookModel model = new BookModel();
	
	public CertainActionListener (DlgBookInfo dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		BookVO argVO = new BookVO();
	    
	    argVO.setBookId(dialog.getTxtBookId().getText());
	    argVO.setCategory(dialog.getTxtCategory().getText());
	    argVO.setBookName(dialog.getTxtBookName().getText());
	    argVO.setAuthor(dialog.getTxtAuthor().getText());
	    argVO.setPress(dialog.getTxtPress().getText());
	    argVO.setBid(dialog.getTxtBid().getText());
	    argVO.setPrice(dialog.getTxtPrice().getText());
	    if(dialog.getCommand().equals("���")) {
	    	argVO.setStorage(dialog.getTxtNum().getText());
	    }else {
		    argVO.setStorage(dialog.getTxtStorage().getText());
	    }

	    if(argVO.getBookId().equals("") || argVO.getBookName().equals("")) {
	        JOptionPane.showMessageDialog(dialog, "�������鼮��Ϣ����ź���������Ϊ�գ�");
	        return;
	    }
	    
	    DlgManager ownerDialog = (DlgManager)dialog.getOwner();
	    BookVO vo = new BookVO();
	    Vector<Vector<String>> resultDataRows = new Vector<Vector<String>>();
	    
	    if(dialog.getCommand().equals("���")) {//����
	    	if(JOptionPane.showConfirmDialog(dialog, "��ȷ������鼮����Ϣ","��ʾ",2) == 0) {
	    		 model.insertBookInfo(argVO);
	   	         resultDataRows = model.getBookInfo(vo, ownerDialog);
	   	         ownerDialog.getTxtBookName().setText(null);
	   	         ownerDialog.getTxtAuthor().setText(null);
	   	         ownerDialog.getTxtCategory().setText(null);
	    	}
	    } else {//����
	    	if(JOptionPane.showConfirmDialog(dialog, "��ȷ�ϸ��µ���Ϣ","��ʾ",2) == 0) {
			      model.updateBookinfo(argVO);
			      dialog.dispose();
			      vo.setBookName(ownerDialog.getTxtBookName().getText());
		    	  vo.setAuthor(ownerDialog.getTxtAuthor().getText());
		    	  vo.setCategory(ownerDialog.getTxtCategory().getText());
			      resultDataRows = model.getBookInfo(vo, ownerDialog);
	    	}
	    }
	 
	    JTable tblBookInfo = ownerDialog.getTblBookInfo();
	    ownerDialog.updateTable(tblBookInfo, resultDataRows);

	}

}
