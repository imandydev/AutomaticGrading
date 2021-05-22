package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CodeAndAnswerController;

public class AddCodeView extends JFrame implements ActionListener{
	private JTextField tfInputCode;
	private Button btnSave;
	private JButton[][] buttons = new JButton[40][4];
	private JPanel jpn1,jpn2Col1, jpn2Col2, jpn2Col3, jpn2Col4, jpnbottom;
	private int input = 0;
	private boolean checkCodeInput;
	private HashMap<Integer, String> listAnswers = new HashMap<Integer, String>();
	public AddCodeView() {
		setLayout(null);
		// row 1
		jpn1 = new JPanel();
		jpn1.setLayout(null);

		// lable
		JLabel lbCode = new JLabel("Mã đề: ");
		lbCode.setBounds(600, 25, 50, 30);
		jpn1.add(lbCode);
		JLabel lbMess = new JLabel();
		lbMess.setBounds(630, 50, 200, 30);
		jpn1.add(lbMess);
		// txt
		tfInputCode = new JTextField();
		tfInputCode.setBounds(650, 30, 100, 25);
		jpn1.add(tfInputCode);
		jpn1.setBounds(0, 0, 2200, 100);
		this.add(jpn1);
		tfInputCode.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try {
					if (tfInputCode.getText().length() > 3) {
						lbMess.setText("Không được dài quá 3 chữ số !");
						checkCodeInput = false;
					} else if (tfInputCode.getText().equals("")) {
						checkCodeInput = false;
					}else {
						input = Integer.parseInt(tfInputCode.getText());
						lbMess.setText("");
						checkCodeInput = true;
					}
				} catch (Exception ex) {
					lbMess.setText("Vui lòng nhập vào số");
					checkCodeInput = false;
				}
			}
		});

//		row 2 col 1
		jpn2Col1 = new JPanel();
		jpn2Col1.setLayout(null);
		jpn2Col1.setBackground(new java.awt.Color(31, 36, 42));
		addAnswer(50, 0, 10, jpn2Col1);
		jpn2Col1.setBounds(0, 100, 300, 500);
		this.add(jpn2Col1);

//		row2 col 2 
		jpn2Col2 = new JPanel();
		jpn2Col2.setLayout(null);
		jpn2Col2.setBackground(new java.awt.Color(31, 36, 42));
		addAnswer(50, 10, 20, jpn2Col2);
		jpn2Col2.setBounds(350, 100, 300, 500);
		this.add(jpn2Col2);

//		row2 col 3 
		jpn2Col3 = new JPanel();
		jpn2Col3.setLayout(null);
		jpn2Col3.setBackground(new java.awt.Color(31, 36, 42));
		addAnswer(50, 20, 30, jpn2Col3);
		jpn2Col3.setBounds(700, 100, 300, 500);
		this.add(jpn2Col3);

//		row2 col 4 
		jpn2Col4 = new JPanel();
		jpn2Col4.setLayout(null);
		jpn2Col4.setBackground(new java.awt.Color(31, 36, 42));
		addAnswer(50, 30, 40, jpn2Col4);
		jpn2Col4.setBounds(1050, 100, 300, 500);
		this.add(jpn2Col4);
		
//		bottom
		jpnbottom = new JPanel();
		jpnbottom.setLayout(null);
		
		btnSave = new Button("Save");
		btnSave.setBounds(1232, 7, 100, 50);
		btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSave.setFont(new java.awt.Font("Verdana", 0, 14));
		btnSave.setBackground(new java.awt.Color(169, 224, 49));
		btnSave.addActionListener(this);
		jpnbottom.add(btnSave);
		jpnbottom.setBounds(0, 600, 1364, 100);
		this.add(jpnbottom);
		// display
//		this.setUndecorated(true);
		this.setSize(1364, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
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
			Label lb = new Label(i+1+"");
			lb.setBounds(10, yLeft, 30, 30);
			jpn.add(lb);
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.BLUE);
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
					listAnswers.put(i+1, buttons[i][j].getText());
					buttons[i][j].setBackground(new java.awt.Color(152, 201, 45));
					saveI = i;
					saveJ = j;
				}
			}
//			on clock again has click
			if (saveI == i) 
				for (int j2 = 0; j2 < buttons[i].length; j2++) 
					if (saveJ != j2)
						buttons[i][j2].setBackground(Color.BLUE);
		}
//		Save
		if (btnSave == e.getSource()) {
			if (!checkCodeInput) {
				JOptionPane.showMessageDialog(this, "Error!");
			} else {
				boolean checkCodeExist = new CodeAndAnswerController().checkCode(input, null, null,listAnswers);
				if (!checkCodeExist) {
					JOptionPane.showMessageDialog(this, "Exist!");
				} else {
					this.setVisible(false);
				}
			}
		}
	}

}
