package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import DTO.CodeDTO;
import DTO.TableDTO;
import interf.InterView;
import model.CodeDAO;

public class ManagerCodeView extends JFrame implements ActionListener, InterView{
	private JButton btnAdd, btnBack, btnCancel, btnMinus;
	private AddCodeView addView;
	private List<JButton> listCode,removeCode;
	private JPanel pn3;
	private TableDTO table;
	public ManagerCodeView() {
//		row 0
		listCode = new ArrayList<JButton>();
		removeCode = new ArrayList<JButton>();
		setLayout(null);
		JPanel pn0 = new JPanel();
		pn0.setLayout(null);
		btnMinus = new JButton();
		btnMinus.setBounds(730, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/icons8_Minus_32px_1.png")); 
		btnMinus.setToolTipText("Minimize");
		btnMinus.setBorder(null);
		btnMinus.setBorderPainted(false);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMinus.setFocusPainted(false);
		btnMinus.setRequestFocusEnabled(false);
		btnMinus.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Minus_30px_3.png"));
		pn0.add(btnMinus);
		
		btnCancel = new JButton();
		btnCancel.setBounds(760, 5, 30, 30);
		btnCancel.setIcon(new ImageIcon("Images/icons8_Cancel_32px.png"));
		btnCancel.setToolTipText("Thoát");
		btnCancel.setBorder(null);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancel.setRequestFocusEnabled(false);
		btnCancel.setRolloverIcon(new ImageIcon("Images/icons8_Cancel_30px_3.png")); 
		btnCancel.setVerifyInputWhenFocusTarget(false);
		pn0.add(btnCancel);
		
		pn0.setBackground(new Color(31, 36, 42));
		pn0.setBounds(0, 0, 800, 40);
		add(pn0);
//		row 1
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		btnBack = new JButton();
		btnBack.setBounds(10,10, 30, 30);
		btnBack.setIcon(new ImageIcon("Images/icons8_Back_To_32px_2.png"));
		btnBack.setToolTipText("Trở về");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);
		
		JLabel tittle = new  JLabel("DANH SÁCH MÃ ĐỀ");
		tittle.setFont(new Font("Tahoma", 1, 25));
		tittle.setForeground(new Color(169, 224, 49));
		tittle.setBounds(285, 10, 250, 30);
		pn1.add(tittle);
		
		btnAdd = new JButton();
		btnAdd.setBounds(760, 10, 30, 30);
		btnAdd.setIcon(new ImageIcon("Images/add_37px.png"));
		btnAdd.setToolTipText("Thêm mã đề");
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAdd.setRequestFocusEnabled(false);
		pn1.add(btnAdd); 
		pn1.setBounds(0, 40, 800, 50);
		pn1.setBackground(new Color(31, 36, 42));
		add(pn1);
		
//		row 3 list code
		pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setPreferredSize(new Dimension(800, 500));
		
//		add code to button
		addCodeToButton(null, listCode);
		
//		add button to panel 3
		addButtonToPanel(listCode, pn3);
		
//		add button remove
		createRemoveButton(4, removeCode);
		addButtonToPanel(removeCode, pn3);
		
		pn3.setBackground(new Color(31, 36, 42));
		pn3.setBounds(0, 90, 800, 510);
		add(pn3);
//		setting
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	
//		event
//		button back
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
//		button cancel
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
//		button hide window
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMinusActionPerformed(e);
			}
		});
//		button add new code and answer
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
	}

	public void backActionPerformed(ActionEvent avt) {
		this.dispose();
	}
	public void addActionPerformed(ActionEvent evt) {
		addView = new AddCodeView(null, this);
		this.setVisible(false);
	}
	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}
	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	public void createRemoveButton(int size, List<JButton> listBtn) {
		int stepRow = 0;
		for (int i = 0; i < size; i++) {
			JButton btn = new JButton();
			btn.setIcon(new ImageIcon("Images/delete_40px.png"));
			btn.addActionListener(this);
			btn.setToolTipText("Xóa mã đề");
			btn.setFocusPainted(false);
			btn.setContentAreaFilled(false);
			btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btn.setRequestFocusEnabled(false);
			btn.setBounds(550, 30 + stepRow, 50, 50);
			listBtn.add(btn);
			stepRow += 80;
		}
	}
	
//	add code in button
	public void addCodeToButton(List<CodeDTO> listCodes, List<JButton> listBtn) {
		int stepRow = 0;
//		for (CodeDTO codeDTO : listCodes) {
		for (int i = 0; i < 4; i++) {
			JButton btn = new JButton("123");
			btn.setBackground(new Color(169, 224, 49));
			btn.addActionListener(this);
//			setname = codeid
			btn.setName("123xx");
			btn.setToolTipText("Xem mã đề và đáp án");
			btn.setFont(new Font("Tahoma", 1, 25));
			btn.setFocusPainted(false);
			btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btn.setBounds(250, 30 + stepRow, 300, 50);
			listBtn.add(btn);
			stepRow += 80;
		}
	}
	
//	add button to pannel
	public void addButtonToPanel(List<JButton> listButtons, JPanel panel) {
		for (JButton btn : listButtons) {
			panel.add(btn);
		}
	}
	
//	get list codes by id table
	public List<CodeDTO> loadCodeDTOByIDTable(TableDTO table) {
		return null;
	}
	
//	click code
	@Override
	public void actionPerformed(ActionEvent e) {
//		list button code
		for (JButton btn : listCode) {
			if (e.getSource() == btn) {
				
			}
		}
//		list button remove
		for (int i = 0; i < removeCode.size(); i++) {
			if (e.getSource() == removeCode.get(i)) {
//				ma code tuong ung voi button remove
				int result = JOptionPane.showConfirmDialog(pn3, "Bạn có muốn xóa mã đề ?", "", JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					int getCodeID = Integer.parseInt(listCode.get(i).getName());
					boolean checkRemove = CodeDAO.removeCodeByID(getCodeID, 1);
					if (checkRemove)
						JOptionPane.showMessageDialog(pn3, "Xóa mã đề thành công "+getCodeID);
					else
						JOptionPane.showMessageDialog(pn3, "Xóa mã đề thất bại "+getCodeID);
				}
			}
		}
	}
	
//	reload lai danh sach ma de sau khi remove 1 ma de nao do
	public void reload() {
		
	}
}
