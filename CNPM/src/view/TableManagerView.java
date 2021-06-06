package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DTO.TableDTO;
import DTO.UserDTO;
import controller.TableController;
import interf.InterView;

public class TableManagerView extends JFrame implements ActionListener, InterView {
	private JButton btnAdd, btnBack, btnCancel, btnMinus;
	private List<JButton> removeTableManager;
	private JPanel pn3;
	private UserDTO user;
	private TableController tableControl;
	public TableManagerView(UserDTO user) {
		this.user = user;
		tableControl = new TableController();
		removeTableManager = new ArrayList<JButton>();
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
		btnCancel.setToolTipText("ThoÃ¡t");
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
		btnBack.setBounds(10, 10, 32, 32);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trá»Ÿ vá»�");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);

		JLabel tittle = new JLabel("DANH SÁCH BẢNG CHẤM ĐIỂM");
		tittle.setFont(new Font("Tahoma", 1, 25));
		tittle.setForeground(new Color(255, 255, 255));
		tittle.setBounds(230, 10, 400, 30);
		pn1.add(tittle);

		btnAdd = new JButton();
		btnAdd.setBounds(758, 10, 32, 32);
		btnAdd.setIcon(new ImageIcon("Images/add_w_32px.png"));
		btnAdd.setToolTipText("ThÃªm mÃ£ Ä‘á»�");
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAdd.setRequestFocusEnabled(false);
		pn1.add(btnAdd);
		pn1.setBounds(0, 40, 800, 50);
		pn1.setBackground(new Color(110, 115, 199));
		add(pn1);

//		row 3 list TableManager
		pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setPreferredSize(new Dimension(800, 500));

//		add TableManager to button
		listTableManager(tableControl.findListTableAllByHide(), pn3);
		
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 90, 800, 510);
		add(pn3);
		
//		setting
		this.getContentPane().setBackground(new Color(255,255,255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(800, 600);
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
//		button add new TableManager and answer
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
	}

	public void addActionPerformed(ActionEvent evt) {
		new AddTableManagerView(this.user, this);
	}

	public void backActionPerformed(ActionEvent avt) {
		new HomeView(this.user);
		this.dispose();
	}

	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

//	add TableManager in button
	public void listTableManager(List<TableDTO> listTable, JPanel panel) {
		int stepRow = 0;
		if (listTable.isEmpty()) {
			JLabel jlb = new JLabel("Chưa có bảng chấm điểm nào!");
			jlb.setBounds(300, 20, 300, 50);
			panel.add(jlb);
		} else {
			for (TableDTO table : listTable) {
				JButton btn = new JButton(table.getTableName());
				btn.setBackground(new Color(110, 115, 199));
				btn.setForeground(new Color(255, 255, 255));
				btn.addActionListener(this);
				btn.setName(String.valueOf(table.getId()));

				btn.setFont(new Font("Tahoma", 1, 25));
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
				btn.setBounds(225, 30 + stepRow, 300, 50);
				panel.add(btn);
				
				JButton btnx = new JButton();
				btnx.setIcon(new ImageIcon("Images/delete1_40px.png"));
				btnx.addActionListener(this);
				btnx.setName(String.valueOf(table.getId()));
				btnx.setFocusPainted(false);
				btnx.setContentAreaFilled(false);
				btnx.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
				btnx.setRequestFocusEnabled(false);
				btnx.setBounds(525, 30 + stepRow, 50, 50);
				panel.add(btnx);
				removeTableManager.add(btnx);
				stepRow += 80;
			}
		}

	}

//	click TableManager
	@Override
	public void actionPerformed(ActionEvent e) {
		int tableId = 0;
		for (JButton btnx : removeTableManager) {
			if (e.getSource() == btnx) {
				tableId = Integer.parseInt(btnx.getName());
//				System.out.println(tableId);
			}
		}
		int result = JOptionPane.showConfirmDialog(pn3, "Bạn muốn xóa bảng chấm điểm?", "",
				JOptionPane.WARNING_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			boolean checkRemove = new TableController().removeTableManagerByID(tableId);
			reload();
			if (checkRemove) {
				JOptionPane.showMessageDialog(pn3, "Xóa thành công bảng chấm điểm!");
			} else {
				JOptionPane.showMessageDialog(pn3, "Xóa thất bại!");
			}
		}

	}

//	reload panel 3
	public void reload() {
		pn3.removeAll();
		listTableManager(tableControl.findListTableAllByHide(), pn3);

	}
}
