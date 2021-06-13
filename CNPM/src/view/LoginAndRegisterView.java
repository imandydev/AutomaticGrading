package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import DTO.UserDTO;
import config.AllSetting;
import controller.UserController;
import interf.InterView;

public class LoginAndRegisterView extends javax.swing.JFrame implements InterView{
	private javax.swing.JButton jButton1, JButtonInstruction;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel_SoftZyd;
	private javax.swing.JLabel jLabel_inven;
	private javax.swing.JLabel jLabel_inven1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPasswordField jPasswordField_Password;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JPasswordField jTextField18;
	private javax.swing.JTextField jTextField19;
	private javax.swing.JTextField jTextField20;
	private javax.swing.JPasswordField jTextField21;
	private javax.swing.JTextField jTextField_Email;
	private UserController userControl;
	public LoginAndRegisterView() {
		userControl = new UserController();
		initComponents();
		jPanel6.setVisible(false);

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jTextField_Email = new javax.swing.JTextField();
		jPasswordField_Password = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		JButtonInstruction = new JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jPanel3 = new javax.swing.JPanel();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jLabel_SoftZyd = new javax.swing.JLabel();
		jLabel_inven = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jTextField19 = new javax.swing.JTextField();
		jTextField20 = new javax.swing.JTextField();
		jTextField17 = new javax.swing.JTextField();
		jTextField18 = new JPasswordField();
		jTextField21 = new JPasswordField();
		jLabel13 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jButton14 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton();
		jLabel_inven1 = new javax.swing.JLabel();

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setForeground(new java.awt.Color(255, 255, 255));
		jPanel1.setLayout(null);

		jTextField_Email.setFont(new java.awt.Font("Trebuchet MS", 0, 24));
		jTextField_Email.setForeground(new java.awt.Color(0, 0, 0));
		jTextField_Email.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(110, 115, 199)));
		jTextField_Email.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jTextField_EmailMouseMoved(evt);
			}
		});
		jTextField_Email.setBounds(90, 205, 260, 40);
		jPanel1.add(jTextField_Email);
		jPasswordField_Password.setFont(new java.awt.Font("Trebuchet MS", 0, 24));
		jPasswordField_Password.setForeground(new java.awt.Color(0, 0, 0));
		jPasswordField_Password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(110, 115, 199)));
		jPasswordField_Password.setBounds(90, 305, 260, 40);
		jPanel1.add(jPasswordField_Password);
		jButton1.setBackground(new java.awt.Color(169, 224, 49));
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
		jButton1.setForeground(new java.awt.Color(0, 0, 0));
		jButton1.setText("Tạo Tài Khoản");
		jButton1.setBorder(null);
		jButton1.setBorderPainted(false);
		jButton1.setContentAreaFilled(false);
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.setRequestFocusEnabled(false);
		jButton1.setVerifyInputWhenFocusTarget(false);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton1.setBounds(70, 480, 140, 30);
		jPanel1.add(jButton1);
		JButtonInstruction.setBackground(new java.awt.Color(169, 224, 49));
		JButtonInstruction.setFont(new java.awt.Font("Tahoma", 0, 14));
		JButtonInstruction.setForeground(new java.awt.Color(0, 0, 0));
		JButtonInstruction.setText("Hướng Dẫn");
		JButtonInstruction.setBorder(null);
		JButtonInstruction.setBorderPainted(false);
		JButtonInstruction.setContentAreaFilled(false);
		JButtonInstruction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		JButtonInstruction.setRequestFocusEnabled(false);
		JButtonInstruction.setVerifyInputWhenFocusTarget(false);
		JButtonInstruction.setBounds(240, 480, 140, 30);
		jPanel1.add(JButtonInstruction);
		jLabel2.setIcon(new javax.swing.ImageIcon("Images/student_male_100px.png")); // NOI18N
		jLabel2.setBounds(170, 60, 100, 100);
		jPanel1.add(jLabel2);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(169, 224, 49));
		jLabel3.setIcon(new javax.swing.ImageIcon("Images/lock_b_35px.png")); // NOI18N
		jLabel3.setBounds(50, 305, 45, 45);
		jPanel1.add(jLabel3);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(169, 224, 49));
		jLabel4.setIcon(new javax.swing.ImageIcon("Images/male_b_user_35px.png")); // NOI18N
		jLabel4.setBounds(50, 205, 45, 45);
		jPanel1.add(jLabel4);

		jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel19.setForeground(new java.awt.Color(0, 0, 0));
		jLabel19.setText("Tên tài khoản");
		jLabel19.setBounds(180, 150, 90, 70);
		jPanel1.add(jLabel19);
		jSeparator1.setBounds(260, 172, 150, 0);
		jPanel1.add(jSeparator1);

		jPanel3.setBackground(new Color(110, 115, 199));
		jPanel3.setLayout(null);

		jButton10.setIcon(new javax.swing.ImageIcon("Images/cancel_w_32px.png"));
		jButton10.setToolTipText("Close");
		jButton10.setBorder(null);
		jButton10.setBorderPainted(false);
		jButton10.setContentAreaFilled(false);
		jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton10.setRequestFocusEnabled(false);
		jButton10.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Cancel_30px_3.png"));
		jButton10.setVerifyInputWhenFocusTarget(false);
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});
		jButton10.setBounds(410, 0, 40, 40);
		jPanel3.add(jButton10);
		jButton11.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		jButton11.setToolTipText("Minimize");
		jButton11.setBorder(null);
		jButton11.setBorderPainted(false);
		jButton11.setContentAreaFilled(false);
		jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton11.setFocusPainted(false);
		jButton11.setRequestFocusEnabled(false);
		jButton11.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Minus_30px_3.png"));

		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMinusActionPerformed(evt);
			}
		});
		jButton11.setBounds(380, 0, 40, 40);
		jPanel3.add(jButton11);

		jLabel_SoftZyd.setFont(new java.awt.Font("Tahoma", 1, 36));
		jLabel_SoftZyd.setForeground(new Color(255, 255, 255));
		jLabel_SoftZyd.setIcon(new javax.swing.ImageIcon("Images/grades_100px.png"));
		jLabel_SoftZyd.setText("CHẤM ĐIỂM");
		jLabel_SoftZyd.setBounds(60, 200, 400, 100);
		jPanel3.add(jLabel_SoftZyd);

		jLabel_inven.setFont(new java.awt.Font("Time New Roman", 0, 28));
		jLabel_inven.setForeground(new Color(255, 255, 255));
		jLabel_inven.setText("Tiện Ích - An Toàn - Hiệu Quả");
		jLabel_inven.setBounds(41, 300, 380, 50);
		jPanel3.add(jLabel_inven);

		jPanel6.setBackground(new Color(110, 115, 199));
		jPanel6.setLayout(null);

		jTextField20.setBackground(new java.awt.Color(110, 115, 199));
		jTextField20.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
		jTextField20.setForeground(new java.awt.Color(255, 255, 255));
		jTextField20.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		jTextField20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jTextField20MouseMoved(evt);
			}
		});
		jTextField20.setBounds(50, 170, 330, 40);
		jPanel6.add(jTextField20);

		jTextField17.setBackground(new java.awt.Color(110, 115, 199));
		jTextField17.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
		jTextField17.setForeground(new java.awt.Color(255, 255, 255));
		jTextField17.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		jTextField17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jTextField17MouseMoved(evt);
			}
		});
		jTextField17.setBounds(50, 250, 330, 40);
		jPanel6.add(jTextField17);

		jTextField18.setBackground(new java.awt.Color(110, 115, 199));
		jTextField18.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
		jTextField18.setForeground(new java.awt.Color(255, 255, 255));
		jTextField18.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		jTextField18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jTextField18MouseMoved(evt);
			}
		});
		jTextField18.setBounds(50, 320, 330, 40);
		jPanel6.add(jTextField18);

		jTextField21.setBackground(new java.awt.Color(110, 115, 199));
		jTextField21.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
		jTextField21.setForeground(new java.awt.Color(255, 255, 255));
		jTextField21.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		jTextField21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jTextField21MouseMoved(evt);
			}
		});
		jTextField21.setBounds(50, 390, 330, 40);
		jPanel6.add(jTextField21);
		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 33));
		jLabel13.setForeground(new java.awt.Color(255, 255, 255));
		jLabel13.setIcon(new javax.swing.ImageIcon("Images/grades_100px.png"));
		jLabel13.setText("CHẤM ĐIỂM");
		jLabel13.setBounds(30, 10, 350, 100);
		jPanel6.add(jLabel13);

		jLabel12.setFont(new java.awt.Font("Time New Roman", 0, 18));
		jLabel12.setForeground(new java.awt.Color(255, 255, 255));
		jLabel12.setText("Tiện Ích - An Toàn - Hiệu Quả");
		jLabel12.setBounds(135, 80, 250, 20);
		jPanel6.add(jLabel12);

		jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16));
		jLabel15.setForeground(new java.awt.Color(255, 255, 255));
		jLabel15.setText("Tên đăng nhập");
		jLabel15.setBounds(50, 150, 110, 20);
		jPanel6.add(jLabel15);

		jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16));
		jLabel18.setForeground(new java.awt.Color(255, 255, 255));
		jLabel18.setText("Mật khẩu");
		jLabel18.setBounds(50, 300, 100, 20);
		jPanel6.add(jLabel18);

		jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16));
		jLabel17.setForeground(new java.awt.Color(255, 255, 255));
		jLabel17.setText("Xác nhận mật khẩu");
		jLabel17.setBounds(50, 370, 200, 20);
		jPanel6.add(jLabel17);

		jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16));
		jLabel16.setForeground(new java.awt.Color(255, 255, 255));
		jLabel16.setText("Địa chỉ email");
		jLabel16.setBounds(50, 230, 100, 20);
		jPanel6.add(jLabel16);
		jButton14.setBackground(new java.awt.Color(169, 224, 49));
		jButton14.setFont(new java.awt.Font("Tahoma", 1, 18));
		jButton14.setForeground(new java.awt.Color(255, 255, 255));
		jButton14.setIcon(new javax.swing.ImageIcon("Images/back_to_w_32px.png"));
		jButton14.setText("Trở về");
		jButton14.setBorder(null);
		jButton14.setContentAreaFilled(false);
		jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton14.setRequestFocusEnabled(false);
		jButton14.setVerifyInputWhenFocusTarget(false);
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});
		jButton14.setBounds(150, 480, 110, 110);
		jPanel6.add(jButton14);

		jButton8.setBackground(new java.awt.Color(255, 255, 255));
		jButton8.setFont(new java.awt.Font("Tahoma", 0, 18));
		jButton8.setForeground(new java.awt.Color(110, 115, 199));
		jButton8.setText("Đăng Ký");
		jButton8.setBorder(null);
		jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton8.setFocusPainted(false);
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jButton8.setBounds(50, 450, 330, 40);
		jPanel6.add(jButton8);

		jPanel6.setBounds(20, 40, 410, 560);
		jPanel3.add(jPanel6);

		jPanel3.setBounds(460, 0, 450, 620);
		jPanel1.add(jPanel3);

		jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel20.setForeground(new java.awt.Color(0, 0, 0));
		jLabel20.setText("Mật khẩu");
		jLabel20.setBounds(190, 250, 70, 70);
		jPanel1.add(jLabel20);

		jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel21.setForeground(new java.awt.Color(0, 0, 0));
		jLabel21.setText("Quên mật khẩu");
		jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel21.setBounds(170, 310, 140, 140);
		jPanel1.add(jLabel21);

		jButton7.setBackground(new java.awt.Color(110, 115, 199));
		jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jButton7.setForeground(new java.awt.Color(255, 255, 255));
		jButton7.setText("Đăng Nhập");
		jButton7.setBorder(null);
		jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton7.setFocusPainted(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(AllSetting.widthLAR, AllSetting.heightLAR);
		setLocationRelativeTo(null);
		setVisible(true);
		


		jButton7.setBounds(90, 420, 260, 40);
		jPanel1.add(jButton7);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
//		event
		jButton7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = jTextField_Email.getText();
				String pass = jPasswordField_Password.getText();
				UserDTO user;
				if (username.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(jPanel1, "Vui lòng điền đầy đủ thông tin!");
				} else {
					try {
						user = userControl.checkUser(username, pass);
						if (user != null) {
							new HomeView(user);
							turnOffView(e);
						} else
							JOptionPane.showMessageDialog(jPanel1, "Tài khoản hoặc mật khẩu không chính xác!");
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}

	private void jTextField_EmailMouseMoved(java.awt.event.MouseEvent evt) {

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		jLabel_SoftZyd.setVisible(false);
		jLabel_inven.setVisible(false);
		jPanel6.setVisible(true);

	}
	 


	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jTextField19MouseMoved(java.awt.event.MouseEvent evt) {

	}

	private void jTextField20MouseMoved(java.awt.event.MouseEvent evt) {

	}

	private void jTextField17MouseMoved(java.awt.event.MouseEvent evt) {
	}

	private void jTextField18MouseMoved(java.awt.event.MouseEvent evt) {
	}

	private void jTextField21MouseMoved(java.awt.event.MouseEvent evt) {
	}

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
		jPanel6.setVisible(false);
		jLabel_SoftZyd.setVisible(true);
		jLabel_inven.setVisible(true);
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {

	}


	
	public void turnOffView(ActionEvent evt) {
		this.dispose();
	}
	
	@Override
	public void backActionPerformed(ActionEvent avt) {
		
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
