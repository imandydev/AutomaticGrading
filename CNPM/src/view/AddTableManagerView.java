package view;

import java.awt.Color;
import java.awt.Cursor;
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
import controller.TableController;
import interf.InterView;

public class AddTableManagerView extends JFrame implements ActionListener, InterView {
//	private JFrame frame;
	private JTextField textTableName;
	private JTextField textNumberQuestionUse;
	private JButton btnSave, btnBack, btnCancel, btnMinus;
	private JPanel panel, panel_header, panel_body;

	public AddTableManagerView() {
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 335, 280);
		panel.setLayout(null);

		panel_header = new JPanel();
		panel_header.setBackground(new Color(110, 115, 199));
		panel_header.setBounds(0, 0, 335, 80);
		panel_header.setLayout(null);
		btnBack = new JButton();
		btnBack.setBounds(10, 10, 35, 35);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trá»Ÿ vá»�");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		panel_header.add(btnBack);

		// button minus
		btnMinus = new JButton();
		btnMinus.setBounds(264, 5, 30, 30);
		btnMinus.setIcon(new javax.swing.ImageIcon("Images/minus_w_32px.png"));
		btnMinus.setToolTipText("Minimize");
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
		btnCancel.setToolTipText("ThoÃ¡t");
		btnCancel.setBorder(null);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancel.setRequestFocusEnabled(false);
		btnCancel.setRolloverIcon(new ImageIcon("Images/icons8_Cancel_30px_3.png"));
		btnCancel.setVerifyInputWhenFocusTarget(false);
		panel_header.add(btnCancel);

		JLabel lblC = new JLabel("T\u1EA1o B\u1EA3ng Ch\u1EA5m \u0110i\u1EC3m");
		lblC.setBounds(70, 40, 195, 28);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setForeground(new Color(255, 255, 255));
		panel_header.add(lblC);
		panel.add(panel_header);

		panel_body = new JPanel();
		panel_body.setBackground(new Color(255, 255, 255));
		panel_body.setBounds(0, 0, 335, 280);
		panel_body.setLayout(null);

		JLabel lblTnBi = new JLabel("1. T\u00EAn b\u00E0i ch\u1EA5m");
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

		JLabel lblSCu = new JLabel("2. S\u1ED1 c\u00E2u h\u1ECFi");
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
		btnSave.setToolTipText("LÆ°u mÃ£ Ä‘á»�");
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
		this.setSize(335, 280);
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
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});

	}

	@Override
	public void backActionPerformed(ActionEvent avt) {
		loadTableManager();
	}

	@Override
	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	@Override
	public void btnCancelActionPerformed(ActionEvent evt) {
		loadTableManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserDTO userDTO = new UserDTO(1, "Nhat", "sadasd", "ssss", 1, "ádds", 0);
		String tableName = getTextTableName().getText();
		String numberQuestionUse = getTextNumberQuestionUse().getText();
		boolean checkInput = checkInput(tableName, numberQuestionUse);
		if (!checkInput) {
			reload();
			JOptionPane.showMessageDialog(this, "Error!");
		} else {
			TableDTO tableDTO = new TableDTO(1, userDTO, tableName, Integer.parseInt(numberQuestionUse), 0);
			if (btnSave == e.getSource()) {
				int id = new TableController().insertTable(tableDTO);
				if (id == 0) {
					JOptionPane.showMessageDialog(this, "Trùng tên bảng chấm điểm!");
				} else {
					loadTableManager();
					JOptionPane.showMessageDialog(this, "Thêm bảng chấm điểm thành công!");

				}

			}
		}

	}

	private boolean checkInput(String tableName, String numberQuestionUse) {
		if (tableName == "" || numberQuestionUse == "") {
			return false;
		}
		try {
			int check = Integer.parseInt(numberQuestionUse);
			if (0 >= check || check > 40) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public JTextField getTextTableName() {
		return textTableName;
	}

	public JTextField getTextNumberQuestionUse() {
		return textNumberQuestionUse;
	}

	public void setTextNumberQuestionUse(JTextField textNumberQuestionUse) {
		this.textNumberQuestionUse = textNumberQuestionUse;
	}

	public void setTextTableName(JTextField textTableName) {
		this.textTableName = textTableName;
	}

	public void reload() {
		this.dispose();
		new AddTableManagerView();
	}

	public void loadTableManager() {
		this.dispose();
		new TableManagerView();
	}

}