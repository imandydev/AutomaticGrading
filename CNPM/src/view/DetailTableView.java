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
import DTO.UserDTO;
import config.AllSetting;
import controller.MarkController;
import controller.UserController;

public class DetailTableView extends JFrame {
	private JButton btnBack, btnCancel, btnMinus, btnCodeManager, btnMark, btnSeeListMark;
	private TableDTO table;
	private UserController userController;
	private UserDTO user;
	private MarkController mc;

	public DetailTableView(TableDTO table) {
		getContentPane().setLayout(null);
		this.table = table;
		this.userController = new UserController();
		JPanel pn0 = new JPanel();
		pn0.setLayout(null);
		pn0.setBackground(new Color(110, 115, 199));
		pn0.setBounds(0, 0, 600, 40);
		getContentPane().add(pn0);

		btnMinus = new JButton();
		btnMinus.setBounds(528, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		btnMinus.setToolTipText("Ẩn");
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

		JLabel lblTableName = new JLabel(table.getTableName());
		lblTableName.setForeground(Color.WHITE);
		lblTableName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTableName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableName.setBounds(0, 41, 600, 23);
		pn1.add(lblTableName);

		JLabel lblNumberQuestionUse = new JLabel("Số lượng câu hỏi: " + table.getNumberQuestionUse());
		lblNumberQuestionUse.setForeground(Color.WHITE);
		lblNumberQuestionUse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberQuestionUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberQuestionUse.setBounds(0, 68, 600, 23);
		pn1.add(lblNumberQuestionUse);

//		row2
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(0, 135, 600, 107);
		getContentPane().add(pn2);

		btnCodeManager = new JButton("Quản lý mã đề");
		btnCodeManager.setBounds(55, 25, 140, 55);
		btnCodeManager.setForeground(new Color(255, 255, 255));
		btnCodeManager.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCodeManager.setBackground(new Color(110, 115, 199));
		btnCodeManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCodeManager.setFocusPainted(false);
		pn2.add(btnCodeManager);

		btnSeeListMark = new JButton("Bài đã chấm");
		btnSeeListMark.setForeground(Color.WHITE);
		btnSeeListMark.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSeeListMark.setFocusPainted(false);
		btnSeeListMark.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSeeListMark.setBackground(new Color(110, 115, 199));
		btnSeeListMark.setBounds(402, 25, 140, 55);
		pn2.add(btnSeeListMark);

		btnMark = new JButton("Chấm điểm");
		btnMark.setBounds(226, 25, 140, 55);
		pn2.add(btnMark);
		btnMark.setForeground(new Color(255, 255, 255));
		btnMark.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMark.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMark.setBackground(new Color(110, 115, 199));
		btnMark.setFocusPainted(false);

//		Sử dụng sau khi chấm bài xong
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 241, 600, 159);
		getContentPane().add(pn3);
		pn3.setLayout(null);

		JLabel lblStatus = new JLabel();
		lblStatus.setForeground(new Color(11, 109, 9));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(0, 0, 600, 23);
		pn3.add(lblStatus);

		JLabel lblTotal = new JLabel();
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(193, 34, 263, 23);
		pn3.add(lblTotal);

		JLabel lblSuccess = new JLabel();
		lblSuccess.setHorizontalAlignment(SwingConstants.LEFT);
		lblSuccess.setForeground(Color.BLACK);
		lblSuccess.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSuccess.setBounds(193, 65, 263, 23);
		pn3.add(lblSuccess);

		JLabel lblSNotScan = new JLabel();
		lblSNotScan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSNotScan.setForeground(Color.BLACK);
		lblSNotScan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSNotScan.setBounds(193, 95, 263, 23);
		pn3.add(lblSNotScan);

		JLabel lblNotImage = new JLabel();
		lblNotImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotImage.setForeground(Color.BLACK);
		lblNotImage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNotImage.setBounds(193, 125, 263, 23);
		pn3.add(lblNotImage);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(AllSetting.widthDTView, AllSetting.heightDTView);
		setLocationRelativeTo(null);
		setVisible(true);

//		Quản lí mã đề
		btnCodeManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnManagementCodeAndAnswer(e);
			}
		});

//		Xử lí chấm điểm
		btnMark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("");
				lblTotal.setText("");
				lblSuccess.setText("");
				lblSNotScan.setText("");
				lblNotImage.setText("");
			
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setFileFilter(new FileNameExtensionFilter(".png", "png"));
				fileChooser.setFileFilter(new FileNameExtensionFilter(".jpeg", "jpeg"));
				fileChooser.setFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
				fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpeg", "jpg"));

				// Cho phép người dùng chọn nhiều file
				fileChooser.setMultiSelectionEnabled(true);
				fileChooser.setDialogTitle("Tải ảnh lên");
				int selected = fileChooser.showDialog(pn2, "Open");

				int numberFileChoose = 0; // Số file được chọn
				int countSuccess = 0; // Số file chấm thành công
				int countNotScan = 0; // Số file không Scan được
				int countNotImage = 0; // Số file không phải là hình ảnh

				if (selected == JFileChooser.APPROVE_OPTION) {
					lblStatus.setText("Hệ thống đang chấm bài!");
					File[] files = fileChooser.getSelectedFiles();
					numberFileChoose = files.length;
					java.util.List<String> listNameFileFalse = new ArrayList<String>();
					for (File file : files) {
						mc = new MarkController();
						if (mc.checkImage(file) == false) {
							countNotImage++;
						} else {
							try {
								if (mc.mark(table.getId(), table.getNumberQuestionUse(), file) == true)
									countSuccess++;
								else
									countNotScan++;
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}

				}

				if (countNotImage > 0) {
					JFrame frame = new JFrame();
					String messageError = "Bạn đã chọn " + countNotImage
							+ " file không phải là hình ảnh! Những file hình ảnh có đuôi là \".jpg\" \".jpeg\" vÃ  \".png\"\"";
					JOptionPane.showMessageDialog(frame, messageError, "File không hợp lệ", JOptionPane.ERROR_MESSAGE);
				}

				if (numberFileChoose > 0) {
					lblStatus.setText("ĐÃ CHẤM XONG!");
					lblTotal.setText("Tổng số file đã chọn: " + numberFileChoose);
					lblSuccess.setText("Số file chấm thành công: " + countSuccess);
					lblSNotScan.setText("Số file không Scan được: " + countNotScan);
					lblNotImage.setText("Số file không phải là hình ảnh: " + countNotImage);
				}
			}
		});

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

		// button list mark
		btnSeeListMark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSeeListMarkActionPerformed(e);

			}
		});
	}

	public void btnSeeListMarkActionPerformed(ActionEvent e) {
		new ListMarkView(table);
		this.dispose();
	}

	public void backActionPerformed(ActionEvent avt) {
		user = userController.findUserById(table.getUserId());
		new ManagerTableView(user);
		this.dispose();
	}

	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	public void btnManagementCodeAndAnswer(ActionEvent evt) {
		new ManagerCodeView(table);
		this.dispose();
	}
}
