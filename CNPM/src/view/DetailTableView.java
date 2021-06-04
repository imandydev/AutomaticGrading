package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import DTO.TableDTO;
import controller.MarkController;

public class DetailTableView extends JFrame {
	private JButton btnBack, btnCancel, btnMinus, btnCodeManager, btnMark;
//	private TableDTO table;

//	public DetailTableView(TableDTO table) {
	public DetailTableView() {
		getContentPane().setLayout(null);

		JPanel pn0 = new JPanel();
		pn0.setLayout(null);
		pn0.setBackground(new Color(110, 115, 199));
		pn0.setBounds(0, 0, 600, 40);
		getContentPane().add(pn0);

		btnMinus = new JButton();
		btnMinus.setBounds(528, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		btnMinus.setToolTipText("Thu nhỏ");
		btnMinus.setBorder(null);
		btnMinus.setBorderPainted(false);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMinus.setFocusPainted(false);
		btnMinus.setRequestFocusEnabled(false);
		btnMinus.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Minus_30px_3.png"));
		pn0.add(btnMinus);

		btnCancel = new JButton();
		btnCancel.setBounds(558, 5, 30, 30);
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

//		row 1
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		pn1.setBounds(0, 40, 600, 95);
		pn1.setBackground(new Color(110, 115, 199));
		getContentPane().add(pn1);

		btnBack = new JButton();
		btnBack.setBounds(10, 0, 32, 32);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trở về");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);

//		titleView
		JLabel tittle = new JLabel("CHI TIẾT BẢNG CHẤM ĐIỂM");
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setFont(new Font("Tahoma", Font.BOLD, 27));
		tittle.setForeground(new Color(255, 255, 255));
		tittle.setBounds(0, 0, 600, 30);
		pn1.add(tittle);

//		JLabel lblTableName = new JLabel(table.getTableName());
		JLabel lblTableName = new JLabel("Demo"); // ví dụ
		lblTableName.setForeground(Color.WHITE);
		lblTableName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTableName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableName.setBounds(0, 41, 600, 23);
		pn1.add(lblTableName);

//		JLabel lblNumberQuestionUse = new JLabel("Số lượng câu hỏi: " + table.getNumberQuestionUse());
		JLabel lblNumberQuestionUse = new JLabel("Số lượng câu hỏi: " + 10); // ví dụ
		lblNumberQuestionUse.setForeground(Color.WHITE);
		lblNumberQuestionUse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberQuestionUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberQuestionUse.setBounds(0, 68, 600, 23);
		pn1.add(lblNumberQuestionUse);

//		row2
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(0, 135, 600, 107);
//		pn2.setBackground(Color.yellow);
		getContentPane().add(pn2);

		btnCodeManager = new JButton("Quản lý mã đề");
		btnCodeManager.setBounds(55, 25, 140, 55);
		btnCodeManager.setForeground(new Color(255, 255, 255));
		btnCodeManager.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCodeManager.setBackground(new Color(110, 115, 199));
		btnCodeManager.setFocusPainted(false);
		pn2.add(btnCodeManager);

		JButton btnSeeListMark = new JButton("Bài đã chấm");
		btnSeeListMark.setForeground(Color.WHITE);
		btnSeeListMark.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSeeListMark.setFocusPainted(false);
		btnSeeListMark.setBackground(new Color(110, 115, 199));
		btnSeeListMark.setBounds(402, 25, 140, 55);
		pn2.add(btnSeeListMark);

		btnMark = new JButton("Chấm điểm");
		btnMark.setBounds(226, 25, 140, 55);
		pn2.add(btnMark);
		btnMark.setForeground(new Color(255, 255, 255));
		btnMark.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMark.setBackground(new Color(110, 115, 199));
		btnMark.setFocusPainted(false);

//		Sử để khi chấm bài xong
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 241, 600, 159);
		getContentPane().add(pn3);
		pn3.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);

//		Xử lí chấm điểm
		btnMark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

//		button back
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
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
	}

	public void backActionPerformed(ActionEvent avt) {
		this.dispose();
	}

	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}
