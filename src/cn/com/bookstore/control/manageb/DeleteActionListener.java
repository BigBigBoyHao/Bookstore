package cn.com.bookstore.control.manageb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.com.bookstore.model.BookModel;
import cn.com.bookstore.model.SellRecordModel;
import cn.com.bookstore.view.DlgManager;
import cn.com.bookstore.vo.BookVO;

public class DeleteActionListener implements ActionListener {

	private DlgManager dialog;
	
	private BookModel model = new BookModel();
	private SellRecordModel srModel = new SellRecordModel();
	
	public DeleteActionListener(DlgManager dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent arg0) {

		JTable tblBookinfo = dialog.getTblBookInfo();
	    int row = tblBookinfo.getSelectedRow();
	    
	    if(row == -1) {
	      JOptionPane.showMessageDialog(dialog, "��ѡ��һ�����ݣ�");
	      return;
	    }
	     
	    if(JOptionPane.showConfirmDialog(dialog, "ȷ��ɾ����", "��ʾ", 2) == 0) {
	    	BookVO argVO = new BookVO();
		    argVO.setBookId((String)tblBookinfo.getValueAt(row, 0));
		    if(srModel.isSellRecord(argVO)) {
		    	JOptionPane.showMessageDialog(dialog, "�޷�ɾ���鼮��Ϣ������������ۼ�¼�и���ļ�¼��Ϣ");
		    }else {
		    	model.deleteBookInfo(argVO);
			    
			    BookVO vo = new BookVO();
			    String bookName = dialog.getTxtBookName().getText();
			    String author = dialog.getTxtAuthor().getText();
			    String category = dialog.getTxtCategory().getText();
			    vo.setBookName(bookName);
			    vo.setAuthor(author);
			    vo.setCategory(category);
			    
			    Vector<Vector<String>> resultDataRows = 
			        model.getBookInfo(vo,dialog);
			      
			      //ˢ�°༶JTable
			      dialog.updateTable(dialog.getTblBookInfo(), resultDataRows);
		    }
		    
	    }
		
	}

}
