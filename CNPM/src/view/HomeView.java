package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.UserDTO;
import config.AllSetting;
import interf.InterView;

public class HomeView extends JFrame implements InterView {
	private JButton btnBack, btnCancel, btnMinus;
	private JButton arrBtn[] = new JButton[7];
	private JPanel jpn1, jpn2;
	private JLabel lbTitle;
	private int locationStart;

// role = 1 admin, = 0 user
	public HomeView(UserDTO user) {

		setLayout(null);
		jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBackground(new Color(110, 115, 199));
//		button minus
		btnMinus = new JButton();
		btnMinus.setBounds(840, 5, 30, 30);
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
		btnCancel.setBounds(870, 5, 30, 30);
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

//		title
		lbTitle = new JLabel("TRANG CHỦ");
		lbTitle.setFont(new java.awt.Font("Tahoma", 1, 30));
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setBounds(380, 30, 160, 35);
		jpn1.add(lbTitle);

		jpn1.setBounds(0, 0, 910, 90);
		this.add(jpn1);

//		panel 2
		jpn2 = new JPanel();
		jpn2.setLayout(null);
//		set location button first 
		if (user.getRole() == 0)
			locationStart = 120;
		else
			locationStart = 40;
//		list btn
		for (int i = 0; i < arrBtn.length; i++) {
			if (user.getRole() == 0) {
				if (i == 4 || i == 5) {
					continue;
				} else {
					switch (i) {
					case 0:
						arrBtn[i] = new JButton("Quản lý bảng chấm điểm");
						break;
					case 1:
						arrBtn[i] = new JButton("Tải phiếu thi");
						break;
					case 2:
						arrBtn[i] = new JButton("Hướng dẫn sử dụng");
						break;
					case 3:
						arrBtn[i] = new JButton("Đổi mật khẩu");
						break;
					case 6:
						arrBtn[i] = new JButton("Đăng xuất");
						break;
					}
					arrBtn[i].setBackground(new Color(110, 115, 199));
					arrBtn[i].setForeground(new Color(255, 255, 255));
					arrBtn[i].setFont(new Font("Tahoma", 1, 25));
					arrBtn[i].setFocusPainted(false);
					arrBtn[i].setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
					arrBtn[i].setBounds(280, locationStart, 350, 50);
					jpn2.add(arrBtn[i]);
					locationStart += 80;
				}
			} else {
				switch (i) {
				case 0:
					arrBtn[i] = new JButton("Quản lý bảng chấm điểm");
					break;

				case 1:
					arrBtn[i] = new JButton("Tải phiếu thi");
					break;
				case 2:
					arrBtn[i] = new JButton("Hướng dẫn sử dụng");
					break;
				case 3:
					arrBtn[i] = new JButton("Đổi mật khẩu");
					break;
				case 4:
					arrBtn[i] = new JButton("Chỉnh sửa hướng dẫn");
					break;
				case 5:
					arrBtn[i] = new JButton("Quản lý tài khoản");
					break;
				case 6:
					arrBtn[i] = new JButton("Đăng xuất");
					break;
				}
				arrBtn[i].setBackground(new Color(110, 115, 199));
				arrBtn[i].setForeground(new Color(255, 255, 255));
				arrBtn[i].setFont(new Font("Tahoma", 1, 25));
				arrBtn[i].setFocusPainted(false);
				arrBtn[i].setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
				arrBtn[i].setBounds(280, locationStart, 350, 50);
				jpn2.add(arrBtn[i]);
				locationStart += 80;
			}
		}
		
		jpn2.setBounds(0, 90, 910, 610);
		this.add(jpn2);
//		setting
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(AllSetting.widthHomeView, AllSetting.heightHomeView);
		setLocationRelativeTo(null);
		setVisible(true);

//		event
//		cancel
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
//		minus
		btnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
//		management table
		arrBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerTableView(user);
				backActionPerformed(e);
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
