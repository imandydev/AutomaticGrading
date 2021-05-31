package view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerCodeView extends JFrame {
	private JButton btnAdd, btnBack;
	public ManagerCodeView() {
		setLayout(null);
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		btnBack = new JButton();
		btnBack.setBounds(10,10, 30, 30);
		btnBack.setIcon(new ImageIcon("Images/back_to_32px.png"));
		btnBack.setToolTipText("Trở về");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);
		JLabel tittle = new  JLabel("DANH SÁCH MÃ ĐỀ");
		tittle.setFont(new java.awt.Font("Tahoma", 1, 25));
		tittle.setForeground(new Color(169, 224, 49));
		tittle.setBounds(75, 10, 250, 30);
		pn1.add(tittle);
		btnAdd = new JButton();
		btnAdd.setBounds(360, 10, 30, 30);
		btnAdd.setIcon(new ImageIcon("Images/add_64px.png"));
		btnAdd.setToolTipText("Thêm mã đề");
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAdd.setRequestFocusEnabled(false);
		pn1.add(btnAdd); 
		pn1.setBounds(0, 0, 400, 50);
		pn1.setBackground(new Color(31, 36, 42));
		add(pn1);
		
//		setting
		setUndecorated(true);
//		setResizable(false);
		setLocationRelativeTo(null);
		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
