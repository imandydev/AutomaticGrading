package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.TableDTO;
import config.AllSetting;
import config.Config;
import controller.CodeAndAnswerController;
import interf.InterView;

public class AddCodeAndAnswerView extends JFrame implements ActionListener, InterView {
	private JTextField tfInputCode;
	private JButton btnSave, btnBack, btnCancel, btnMinus, btnClear;
	private JButton[][] buttons = new JButton[40][4];
	private JPanel jpn1, jpn2Col1, jpn2Col2, jpn2Col3, jpn2Col4, jpnbottom;
	private int input = 0;
	private int checkCodeInput;
	private HashMap<Integer, String> listAnswers = new HashMap<Integer, String>();
	private ManagerCodeView mg;
	private TableDTO table;
	private CodeAndAnswerController cAndAControl;
	private String fontFamily;

	public AddCodeAndAnswerView(TableDTO table, ManagerCodeView mg) {
		this.mg = mg;
		this.table = table;
		this.fontFamily = AllSetting.fontFamilyAddCode;
		this.cAndAControl = new CodeAndAnswerController();
		setLayout(null);
		// row 1
		jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBackground(new Color(110, 115, 199));
//		button minus
		btnMinus = new JButton();
		btnMinus.setBounds(1294, 5, AllSetting.widthMinus, AllSetting.heightMinus);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		btnMinus.setToolTipText("Ẩn");
		btnMinus.setBorder(null);
		btnMinus.setBorderPainted(false);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMinus.setFocusPainted(false);
		btnMinus.setRequestFocusEnabled(false);
		btnMinus.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Minus_30px_3.png"));
		jpn1.add(btnMinus);

//		button cancel
		btnCancel = new JButton();
		btnCancel.setBounds(1324, 5, AllSetting.widthCancel, AllSetting.heightCancel);
		btnCancel.setIcon(new ImageIcon("Images/cancel_w_32px.png"));
		btnCancel.setToolTipText("Thoát");
		btnCancel.setBorder(null);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancel.setRequestFocusEnabled(false);
		btnCancel.setRolloverIcon(new ImageIcon("Images/icons8_Cancel_30px_3.png"));
		btnCancel.setVerifyInputWhenFocusTarget(false);
		jpn1.add(btnCancel);

		btnBack = new JButton();
		btnBack.setBounds(25, 25, AllSetting.widthBack, AllSetting.heightBack);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trở về");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		jpn1.add(btnBack);
		// lable
		JLabel lbCode = new JLabel(AllSetting.codeLb);
		lbCode.setBounds(560, 30, 100, 30);
		lbCode.setFont(new java.awt.Font(fontFamily, 0, 25));
		lbCode.setForeground(new Color(255, 255, 255));
		jpn1.add(lbCode);
		JLabel lbMess = new JLabel();
		lbMess.setForeground(new Color(255, 255, 255));
		lbMess.setBounds(760, 30, 200, 30);
		jpn1.add(lbMess);
		// txt
		tfInputCode = new JTextField();
		tfInputCode.setBounds(650, 30, 100, 35);
		tfInputCode.setBackground(new Color(110, 115, 199));
		tfInputCode.setFont(new java.awt.Font(fontFamily, 0, 25));
		tfInputCode.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));

		tfInputCode.setForeground(new Color(255, 255, 255));
		jpn1.add(tfInputCode);
		jpn1.setBounds(0, 0, 2200, 90);
		this.add(jpn1);

//		row 2 col 1
		jpn2Col1 = new JPanel();
		jpn2Col1.setLayout(null);
		jpn2Col1.setBackground(new java.awt.Color(255, 255, 255));
		addAnswer(50, 0, 10, jpn2Col1);
		jpn2Col1.setBounds(0, 100, 300, 500);
		this.add(jpn2Col1);

//		row2 col 2 
		jpn2Col2 = new JPanel();
		jpn2Col2.setLayout(null);
		jpn2Col2.setBackground(new java.awt.Color(255, 255, 255));
		addAnswer(50, 10, 20, jpn2Col2);
		jpn2Col2.setBounds(350, 100, 300, 500);
		this.add(jpn2Col2);

//		row2 col 3 
		jpn2Col3 = new JPanel();
		jpn2Col3.setLayout(null);
		jpn2Col3.setBackground(new java.awt.Color(255, 255, 255));
		addAnswer(50, 20, 30, jpn2Col3);
		jpn2Col3.setBounds(700, 100, 300, 500);
		this.add(jpn2Col3);

//		row2 col 4 
		jpn2Col4 = new JPanel();
		jpn2Col4.setLayout(null);
		jpn2Col4.setBackground(new java.awt.Color(255, 255, 255));
		addAnswer(50, 30, 40, jpn2Col4);
		jpn2Col4.setBounds(1050, 100, 300, 500);
		this.add(jpn2Col4);

//		bottom
		jpnbottom = new JPanel();
		jpnbottom.setLayout(null);
		jpnbottom.setBackground(new Color(255, 255, 255));
		btnSave = new JButton();
		btnSave.setIcon(new ImageIcon("Images/save_b_50px.png"));
		btnSave.setToolTipText("Lưu mã đề");
		btnSave.setBounds(1280, 10, AllSetting.widthSave, AllSetting.heightSave);
		btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSave.setBackground(new java.awt.Color(255, 255, 255));
		btnSave.setFocusPainted(false);
		btnSave.addActionListener(this);
		btnSave.setFont(new java.awt.Font(fontFamily, 0, 15));
		jpnbottom.add(btnSave);
		btnClear = new JButton();
		btnClear.setBounds(1220, 10, 50, 50);
		btnClear.setIcon(new ImageIcon("Images/sync_b_50px.png"));
		btnClear.setToolTipText("Làm mới");
		btnClear.setFocusPainted(false);
		btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnClear.setFont(new java.awt.Font(fontFamily, 0, 14));
		btnClear.setBackground(new java.awt.Color(255, 255, 255));
		btnClear.addActionListener(this);
		btnClear.setFont(new java.awt.Font(fontFamily, 0, 15));
		jpnbottom.add(btnClear);
		jpnbottom.setBounds(0, 600, 1364, 80);
		this.add(jpnbottom);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		// display
		setUndecorated(true);
		setResizable(false);
		this.setSize(AllSetting.widthACASView, AllSetting.heightACASView);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

//		event
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMinusActionPerformed(e);
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
//		lam moi
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearAnsChoose(listAnswers, buttons);
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mg.reload();
				backActionPerformed(e);
			}
		});
	}

	// create list buttons answer A, B, C, D
	public void addAnswer(int x, int start, int end, JPanel jpn) {
		int xLeft = x;
		int yLeft = 0;
		int count = 0;
		for (int i = start; i < end; i++) {
			if (count == 0) {
				yLeft += 10;
				count++;
			} else
				yLeft += 50;
			xLeft = x;
			Label lb = new Label(i + 1 + "");
			lb.setForeground(new Color(110, 115, 199));
			lb.setFont(new java.awt.Font(fontFamily, 0, 16));
			lb.setBounds(10, yLeft, 30, 30);
			jpn.add(lb);
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(new Color(255, 255, 255));
				buttons[i][j].setFocusPainted(false);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setForeground(new Color(110, 115, 199));
				buttons[i][j].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(110, 115, 199)));
				buttons[i][j].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				switch (j) {
				case 0:
					buttons[i][j].setText("A");
					break;
				case 1:
					buttons[i][j].setText("B");
					break;
				case 2:
					buttons[i][j].setText("C");
					break;
				default:
					buttons[i][j].setText("D");
				}
				buttons[i][j].setBounds(xLeft, yLeft, 50, 30);
				xLeft += 60;
				jpn.add(buttons[i][j]);
			}

		}
	}

	// event click answer
	@Override
	public void actionPerformed(ActionEvent e) {
		int saveI = -1, saveJ = -1;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
//				 find button on click and set color
				if (buttons[i][j] == e.getSource()) {
					listAnswers.put(i + 1, buttons[i][j].getText());
					buttons[i][j].setBackground(new Color(110, 115, 199));
					buttons[i][j].setForeground(new Color(255, 255, 255));
					buttons[i][j].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(110, 115, 199)));
					saveI = i;
					saveJ = j;
				}
			}
//			click 1 dong 2 dap an
			if (saveI == i)
				for (int j2 = 0; j2 < buttons[i].length; j2++)
					if (saveJ != j2) {
						buttons[i][j2].setBackground(new Color(255, 255, 255));
						buttons[i][j2].setForeground(new Color(110, 115, 199));
						buttons[i][j2].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(110, 115, 199)));
					}
		}
//		Save
		if (btnSave == e.getSource()) {
			try {
				if (tfInputCode.getText().isEmpty())
					checkCodeInput = 1;
				else if (tfInputCode.getText().trim().length() != 3)
					checkCodeInput = 2;
				else {
					input = Integer.parseInt(tfInputCode.getText().trim());
					checkCodeInput = 0;
				}
			} catch (Exception ex) {
				checkCodeInput = 2;
			}
			switch (checkCodeInput) {
			case 1:
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã đề!");
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "Độ dài mã đề phải là 3 và mã đề phải là số!");
				break;
			default:
				listAnswers = beforeProcess(listAnswers, table.getNumberQuestionUse());
//				insert ma de va dap an
				boolean checkInsertAnswer = cAndAControl.insertCodeAndAnswer(input, table.getId(), listAnswers);
//				insert thanh cong
				if (!checkInsertAnswer) {
					JOptionPane.showMessageDialog(this, "Thêm mã đề thất bại!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm mã đề thành công!");
					tfInputCode.setText("");
					clearAnsChoose(listAnswers, buttons);
				}
				break;
			}
		}
	}

//	tien xu ly, cau nao chua chon thi cho F
	public HashMap<Integer, String> beforeProcess(HashMap<Integer, String> listAns, int numberQuestionUse) {
		for (int i = 0; i < numberQuestionUse; i++) {
			if (!listAns.containsKey(i + 1)) {
				listAns.put(i + 1, "F");
			}
		}
		return listAns;
	}

//	clear dap an
	public void clearAnsChoose(HashMap<Integer, String> listAns, JButton[][] matrixButton) {
		listAns.clear();
		for (int i = 0; i < matrixButton.length; i++) {
			for (int j = 0; j < matrixButton[i].length; j++) {
				matrixButton[i][j].setBackground(new Color(255, 255, 255));
				matrixButton[i][j].setForeground(new Color(110, 115, 199));
				matrixButton[i][j].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(110, 115, 199)));
			}
		}
	}

	@Override
	public void backActionPerformed(ActionEvent avt) {
		new ManagerCodeView(this.table);
		this.dispose();
	}

	@Override
	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	@Override
	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}
