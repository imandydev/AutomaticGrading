package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import DTO.CodeDTO;
import DTO.TableDTO;
import config.AllSetting;
import controller.CodeAndAnswerController;
import interf.InterView;
import javafx.scene.layout.Border;
import model.CodeDAO;

public class ManagerCodeView extends JFrame implements ActionListener, InterView{
	private JButton btnAdd, btnBack, btnCancel, btnMinus;
	private AddCodeAndAnswerView addView;
	private List<JButton> listBtnCode,removeBtnCode;
	private List<CodeDTO> listCodeLoad;
	private JPanel pn3, pn4;
	private JLabel lbSize0;
	private TableDTO table;
	private JScrollPane talkPane;
	private CodeAndAnswerController CodeAndAns;
	public ManagerCodeView(TableDTO table) {
//		row 0
		this.table = table;
		listBtnCode = new ArrayList<JButton>();
		removeBtnCode = new ArrayList<JButton>();
		CodeAndAns = new CodeAndAnswerController();
		setLayout(null);
		JPanel pn0 = new JPanel();
		pn0.setLayout(null);
		btnMinus = new JButton();
		btnMinus.setBounds(728, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png")); 
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
		btnCancel.setBounds(758, 5, 30, 30);
		btnCancel.setIcon(new ImageIcon("Images/cancel_w_32px.png"));
		btnCancel.setToolTipText("Thoát");
		btnCancel.setBorder(null);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancel.setRequestFocusEnabled(false);
		btnCancel.setRolloverIcon(new ImageIcon("Images/icons8_Cancel_30px_3.png")); 
		btnCancel.setVerifyInputWhenFocusTarget(false);
		pn0.add(btnCancel);
		
		pn0.setBackground(new Color(110, 115, 199));
//		pn0.setBackground(new Color(31, 36, 42));
		pn0.setBounds(0, 0, 800, 40);
		add(pn0);
//		row 1
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		
		btnBack = new JButton();
		btnBack.setBounds(10,10, 32, 32);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trở về");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);
		
		JLabel tittle = new  JLabel("DANH SÁCH MÃ ĐỀ");
		tittle.setFont(new Font("Tahoma", 1, 25));
		tittle.setForeground(new Color(255,255,255));
		tittle.setBounds(285, 10, 250, 30);
		pn1.add(tittle);
		
		btnAdd = new JButton();
		btnAdd.setBounds(758, 10, 32, 32);
		btnAdd.setIcon(new ImageIcon("Images/add_w_32px.png"));
		btnAdd.setToolTipText("Thêm mã đề");
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAdd.setRequestFocusEnabled(false);
		pn1.add(btnAdd); 
		pn1.setBounds(0, 40, 800, 50);
		pn1.setBackground(new Color(110, 115, 199));
		add(pn1);
		
//		row 3 list code
		pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setPreferredSize(new Dimension(800, 500));
		
//		add code to button
		listCodeLoad = loadCodeDTOByIDTable(table);
		pn4 = new JPanel();
		pn4.setLayout(null);
		pn4.setPreferredSize(new Dimension(800, listCodeLoad.size()*50 + 20));
		if (listCodeLoad.size() > 0) {
			addCodeToButton(listCodeLoad, listBtnCode);
//			add button remove
			createRemoveButton(listBtnCode.size(), removeBtnCode);
			addButtonToPanel(listBtnCode, pn4);
			addButtonToPanel(removeBtnCode, pn4);
			
		} else {
			listCode0();
		}
		talkPane = new JScrollPane(pn4,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		talkPane.setBounds(0, 0, 800, 510);
		pn3.add(talkPane, BorderLayout.CENTER);
		
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 90, 800, 510);
		add(pn3);
//		line border
		
	
		
//		setting
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(AllSetting.widthMCView, AllSetting.heightMCView);
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
		new DetailTableView(this.table);
		this.dispose();
	}
	public void addActionPerformed(ActionEvent evt) {
		addView = new AddCodeAndAnswerView(this.table, this);
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
			btn.setIcon(new ImageIcon("Images/delete1_40px.png"));
			btn.addActionListener(this);
			btn.setToolTipText("Xóa mã đề");
			btn.setFocusPainted(false);
			btn.setContentAreaFilled(false);
			btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btn.setRequestFocusEnabled(false);
			btn.setBounds(525, 30 + stepRow, 50, 50);
			listBtn.add(btn);
			stepRow += 80;
		}
	}
	
//	add code in button
	public void addCodeToButton(List<CodeDTO> listCodes, List<JButton> listBtn) {
		int stepRow = 0;
//		for (CodeDTO codeDTO : listCodes) {
		for (int i = 0; i < listCodes.size(); i++) {
			String code = checkCode(listCodes.get(i).getCode());
			JButton btn = new JButton(code);
			btn.setBackground(new Color(110, 115, 199));
			btn.setForeground(new Color(255,255,255));
			btn.addActionListener(this);
//			setname = codeid
			btn.setName(listCodes.get(i).getCodeID()+"");
			btn.setToolTipText("Xem mã đề và đáp án");
			btn.setFont(new Font("Tahoma", 1, 25));
			btn.setFocusPainted(false);
			btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btn.setBounds(225, 30 + stepRow, 300, 50);
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
		return CodeAndAns.loadListCodeByIDTable(table);
	}
	
//	click code
	@Override
	public void actionPerformed(ActionEvent e) {
//		list button code
		for (JButton btn : listBtnCode) {
			if (e.getSource() == btn) {
				
			}
		}
//		list button remove
		for (int i = 0; i < removeBtnCode.size(); i++) {
			if (e.getSource() == removeBtnCode.get(i)) {
//				ma code tuong ung voi button remove
				int result = JOptionPane.showConfirmDialog(pn3, "Bạn có muốn xóa mã đề ?", "", JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					int getCodeID = Integer.parseInt(listBtnCode.get(i).getName());
					System.out.println(getCodeID);
					boolean checkRemove = CodeDAO.hideCodeByID(getCodeID, 1);
					if (checkRemove) {
						JOptionPane.showMessageDialog(pn3, "Xóa mã đề thành công!");
						reload();
					}else
						JOptionPane.showMessageDialog(pn3, "Xóa mã đề thất bại!");
				}
			}
		}
	}
	public void listCode0() {
		this.lbSize0 = new JLabel("Danh Sách Mã Đề Rỗng!");
		this.lbSize0.setBounds(340, 30, 200, 30);
		this.pn4.add(lbSize0);
	}
	
	private String checkCode(int code){
		String result = null;
		if (code < 10) {
			result = "00" + code;
		} else if (code < 100 && code >= 10) {
			result = "0" + code;
		} else {
			result = String.valueOf(code);
		}
		return result;
	}

	
	
	
//	reload lai danh sach ma de sau khi remove 1 ma de nao do
	public void reload() {
		pn4.removeAll();
		pn4.hide();
//		clear list
		listBtnCode.clear();
		removeBtnCode.clear();
		listCodeLoad.clear();
//		load lai list
		listCodeLoad = loadCodeDTOByIDTable(table);
		if (listCodeLoad.size() > 0) {
//			add ma de vao btn
			pn4.setPreferredSize(new Dimension(800, listCodeLoad.size()*50 + 20));
			addCodeToButton(listCodeLoad, listBtnCode);
			createRemoveButton(listBtnCode.size(), removeBtnCode);
//			add btn vao panel
			addButtonToPanel(listBtnCode, pn4);
			addButtonToPanel(removeBtnCode, pn4);
		} else {
			listCode0();
		}
		pn4.show();
	}
}
