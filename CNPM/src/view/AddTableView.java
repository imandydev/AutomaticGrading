package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.TableDTO;
import DTO.UserDTO;
import config.AllSetting;
import controller.TableController;
import interf.InterView;

public class AddTableView extends JFrame implements ActionListener, InterView {

	private JTextField textTableName, textNumberQuestionUse;
	private JButton btnSave, btnCancel, btnMinus;
	private JPanel panel, panel_header, panel_body;
	private UserDTO user;
	private ManagerTableView table;
	private TableController tableController;

	public AddTableView(UserDTO user, ManagerTableView tableMa) {
		this.user = user;
		this.table = tableMa;
		this.tableController = new TableController();
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 335, 280);
		panel.setLayout(null);
		panel_header = new JPanel();
		panel_header.setBackground(new Color(110, 115, 199));
		panel_header.setBounds(0, 0, 335, 80);
		panel_header.setLayout(null);

		// button minus
		btnMinus = new JButton();
		btnMinus.setBounds(264, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		btnMinus.setToolTipText("Ẩn");
		btnMinus.setBorder(null);
		btnMinus.setBorderPainted(false);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMinus.setFocusPainted(false);
		btnMinus.setRequestFocusEnabled(false);
		btnMinus.setRolloverIcon(new javax.swing.ImageIcon("Images/icons8_Minus_30px_3.png"));
		panel_header.add(btnMinus);

//				button cancel
		btnCancel = new JButton();
		btnCancel.setBounds(295, 5, 30, 30);
		btnCancel.setIcon(new ImageIcon("Images/cancel_w_32px.png"));
		btnCancel.setToolTipText("Thoát");
		btnCancel.setBorder(null);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancel.setRequestFocusEnabled(false);
		btnCancel.setRolloverIcon(new ImageIcon("Images/icons8_Cancel_30px_3.png"));
		btnCancel.setVerifyInputWhenFocusTarget(false);
		panel_header.add(btnCancel);

		JLabel lblC = new JLabel("Tạo Bảng Chấm Điểm");
		lblC.setBounds(70, 40, 195, 28);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setForeground(new Color(255, 255, 255));
		panel_header.add(lblC);
		panel.add(panel_header);

		panel_body = new JPanel();
		panel_body.setBackground(new Color(255, 255, 255));
		panel_body.setBounds(0, 0, 335, 280);
		panel_body.setLayout(null);

		JLabel lblTnBi = new JLabel("1. Tên bảng");
		lblTnBi.setBounds(84, 95, 112, 14);
		lblTnBi.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblTnBi.setForeground(new Color(110, 115, 199));
		panel_body.add(lblTnBi);

		textTableName = new JTextField();
		textTableName.setBackground(new java.awt.Color(255, 255, 255));
		textTableName.setFont(new java.awt.Font("Tahoma", 0, 14));
		textTableName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(110, 115, 199)));
		textTableName.setBounds(84, 120, 184, 20);
		panel_body.add(textTableName);

		JLabel lblSCu = new JLabel("2. Số câu hỏi");
		lblSCu.setBounds(84, 151, 81, 14);
		lblSCu.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblSCu.setForeground(new Color(110, 115, 199));
		panel_body.add(lblSCu);

		textNumberQuestionUse = new JTextField();
		textNumberQuestionUse.setBackground(new java.awt.Color(255, 255, 255));
		textNumberQuestionUse.setFont(new java.awt.Font("Tahoma", 0, 14));
		textNumberQuestionUse.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(110, 115, 199)));
		textNumberQuestionUse.setBounds(84, 176, 184, 20);
		panel_body.add(textNumberQuestionUse);

		// btn save
		btnSave = new JButton();
		btnSave.setIcon(new ImageIcon("Images/save_b_50px.png"));
		btnSave.setBounds(265, 220, 40, 40);
		btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSave.setBackground(new java.awt.Color(255, 255, 255));
		btnSave.setFocusPainted(false);
		btnSave.addActionListener(this);
		btnSave.setFont(new java.awt.Font("Tahoma", 0, 15));
		panel_body.add(btnSave);

		panel.add(panel_body);
		getContentPane().add(panel);
		setUndecorated(true);
		setResizable(false);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(110, 115, 199)));
		this.setSize(AllSetting.widthATView, AllSetting.heightATView);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
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
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tableName = getTextTableName().getText();
		String numberQuestionUse = getTextNumberQuestionUse().getText();
		int checkInput = checkInput(tableName, numberQuestionUse);
		if (checkInput == 1) { //name and number question is empty
			JOptionPane.showMessageDialog(this, "HÃ£y vui lÃ²ng nháº­p Ä‘áº§y Ä‘á»§ thÃ´ng tin!");
			reload();
		} else if (checkInput == 2) {//name is empty
			JOptionPane.showMessageDialog(this, "HÃ£y vui lÃ²ng nháº­p tÃªn báº£ng cháº¥m Ä‘iá»ƒm!");
		} else if (checkInput == 3) { //number question is empty
			JOptionPane.showMessageDialog(this, "HÃ£y vui lÃ²ng nháº­p sá»‘ cÃ¢u há»�i!");
		} else if (checkInput == 4) { //not type number or >40 or <=0
			JOptionPane.showMessageDialog(this, "Sá»‘ cÃ¢u há»�i chá»‰ tá»« 1 Ä‘áº¿n 40. Vui lÃ²ng nháº­p láº¡i!");
			textNumberQuestionUse.setText("");
		} else {
			if (btnSave == e.getSource()) {
				checkAndInsertTable(tableName, numberQuestionUse);

			}
		}

	}

	private void checkAndInsertTable(String tableName, String numberQuestionUse) {
		TableDTO tableDTO = new TableDTO(0, user, tableName, Integer.parseInt(numberQuestionUse), 0);
		int id = tableController.insertTable(tableDTO);
		if (id == -1) {
			JOptionPane.showMessageDialog(this, "TÃªn báº£ng cháº¥m Ä‘iá»ƒm Ä‘Ã£ tá»“n táº¡i! ");
		} else if (id == 0) {
			JOptionPane.showMessageDialog(this, "ThÃªm báº£ng Ä‘iá»ƒm tháº¥t báº¡i!");
		} else {
			loadTableManager();
			JOptionPane.showMessageDialog(this, "ThÃªm báº£ng cháº¥m Ä‘iá»ƒm thÃ nh cÃ´ng!");

		}
	}

	private int checkInput(String tableName, String numberQuestionUse) {
		if (tableName.isEmpty() && numberQuestionUse.isEmpty()) {
			return 1;
		} else if (tableName.isEmpty()) {
			return 2;
		} else if (numberQuestionUse.isEmpty()) {
			return 3;
		} else {
			try {
				int check = Integer.parseInt(numberQuestionUse);
				if (0 >= check || check > 40) {
					return 4;
				}
			} catch (NumberFormatException e) {
				return 4;
			}
		}

		return 0;
	}

	public JTextField getTextTableName() {
		return textTableName;
	}

	public JTextField getTextNumberQuestionUse() {
		return textNumberQuestionUse;
	}

	public void reload() {
		textNumberQuestionUse.setText("");
		textTableName.setText("");
	}

//	reload table management
	public void loadTableManager() {
		this.table.reload();
		this.dispose();
	}

}
