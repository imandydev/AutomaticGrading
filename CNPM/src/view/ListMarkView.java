package view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import DTO.MarkDTO;
import DTO.TableDTO;
import config.AllSetting;
import controller.MarkController;
import controller.TableController;
import interf.InterView;

public class ListMarkView extends JFrame implements ActionListener, InterView {
	private JButton btnBack, btnCancel, btnMinus;
	private List<JButton> removeMarkManager;
	private JPanel pn3, pn4;
	private TableDTO table;
	private MarkController markController;

	public ListMarkView(TableDTO table) {
		this.table = table;
		markController = new MarkController();
		removeMarkManager = new ArrayList<JButton>();
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
		pn1.setBounds(0, 40, 800, 50);
		pn1.setBackground(new Color(110, 115, 199));
		add(pn1);

		btnBack = new JButton();
		btnBack.setBounds(10, 10, 32, 32);
		btnBack.setIcon(new ImageIcon("Images/back_to_w_32px.png"));
		btnBack.setToolTipText("Trá»Ÿ vá»�");
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setRequestFocusEnabled(false);
		pn1.add(btnBack);

		JLabel tittle = new JLabel("DANH SÁCH BÀI ĐÃ CHẤM");
		tittle.setFont(new Font("Tahoma", 1, 25));
		tittle.setForeground(new Color(255, 255, 255));
		tittle.setBounds(230, 10, 400, 30);
		pn1.add(tittle);

		pn4 = new JPanel();
		pn4.setLayout(null);
		pn4.setPreferredSize(new Dimension(800, 500));
		
		
//		add TableManager to button
		List<MarkDTO> listMark = markController.findListMarkAllByTableId(this.table.getId());
		if (checkListSize(listMark)==0) {
			showListMarkIsEmpty();
		} else {
			showListMark(listMark, pn4);
		}
		pn4.setBackground(new Color(255, 255, 255));
		pn4.setBounds(0, 90, 800, 510);
		add(pn4);

//		setting
		this.getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setSize(AllSetting.widthLMView, AllSetting.heightLMView);
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

	}

	public void backActionPerformed(ActionEvent avt) {
		new DetailTableView(this.table);
		this.dispose();
	}

	public void btnMinusActionPerformed(ActionEvent evt) {
		this.setState(ICONIFIED);
	}

	public void btnCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	public int checkListSize(List<MarkDTO> listMark) {
		return listMark.size();
	}

//	add TableManager in button
	public void showListMark(List<MarkDTO> listMark, JPanel panel) {
		int stepRow = 0;
		pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setPreferredSize(new Dimension(800, listMark.size() * 60 + 60));
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 90, 800, 510);
		JLabel jLabel = new JLabel();
		jLabel.setText("Mã số");
		jLabel.setFont(new Font("Tahoma", 1, 20));
		jLabel.setBounds(95, 25 + stepRow, 80, 40);
		jLabel.setForeground(new Color(110, 115, 199));

		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Mã đề");
		jLabel1.setFont(new Font("Tahoma", 1, 20));
		jLabel1.setBounds(240, 25 + stepRow, 150, 40);
		jLabel1.setForeground(new Color(110, 115, 199));

		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Số câu đúng");
		jLabel2.setFont(new Font("Tahoma", 1, 20));
		jLabel2.setBounds(390, 25 + stepRow, 250, 40);
		jLabel2.setForeground(new Color(110, 115, 199));

		JLabel jLabel3 = new JLabel();
		jLabel3.setText("Điểm");
		jLabel3.setFont(new Font("Tahoma", 1, 20));
		jLabel3.setBounds(580, 25 + stepRow, 250, 40);
		jLabel3.setForeground(new Color(110, 115, 199));

		pn3.add(jLabel);
		pn3.add(jLabel1);
		pn3.add(jLabel2);
		pn3.add(jLabel3);
		
		for (MarkDTO mark : listMark) {
			JButton btn = new JButton(mark.getImgStudentID());
			btn.setBackground(new Color(110, 115, 199));
			btn.setForeground(new Color(255, 255, 255));
//			btn.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					detailMarkActionPerformed(e);
//				}
//
//				private void detailMarkActionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//
//				}
//			});
			btn.setName(String.valueOf(mark.getMarkID()));
			btn.setFont(new Font("Tahoma", 1, 18));
			btn.setFocusPainted(false);
			btn.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btn.setBounds(70, 70 + stepRow, 110, 30);

			JLabel jLabel5 = new JLabel();
			jLabel5.setText(mark.getImgCode());
			jLabel5.setFont(new Font("Tahoma", 1, 18));
			jLabel5.setBounds(260, 65 + stepRow, 150, 40);

			JLabel jLabel6 = new JLabel();
			jLabel6.setText(mark.getNumberAnswerCorrect() + "/" + table.getNumberQuestionUse());
			jLabel6.setFont(new Font("Tahoma", 1, 18));
			jLabel6.setBounds(425, 65 + stepRow, 250, 40);

			JLabel jLabel7 = new JLabel();
			jLabel7.setText(String.valueOf(mark.getGrade()));
			jLabel7.setFont(new Font("Tahoma", 1, 18));
			jLabel7.setBounds(590, 65 + stepRow, 100, 40);

			pn3.add(jLabel7);
//				pn3.add(jLabel4);
			pn3.add(jLabel5);
			pn3.add(jLabel6);
			pn3.add(btn);

			JButton btnx = new JButton();
			btnx.setIcon(new ImageIcon("Images/delete1_40px.png"));
			btnx.addActionListener(this);
			btnx.setName(String.valueOf(mark.getMarkID()));
			btnx.setFocusPainted(false);
			btnx.setContentAreaFilled(false);
			btnx.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
			btnx.setRequestFocusEnabled(false);
			btnx.setBounds(720, 70 + stepRow, 30, 30);
			pn3.add(btnx);
			removeMarkManager.add(btnx);
			stepRow += 60;
		}
		JScrollPane talkPane = new JScrollPane(pn3, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		talkPane.setBounds(0, 0, 800, 510);
		pn4.add(talkPane, BorderLayout.CENTER);

	}

	public void showListMarkIsEmpty() {
		JLabel jlb = new JLabel("Chưa có bài chấm điểm nào!");
		jlb.setBounds(300, 20, 300, 50);
		pn4.add(jlb);
	}
	
//	click TableManager
	@Override
	public void actionPerformed(ActionEvent e) {
		int markId = 0;
		for (int i = 0; i < removeMarkManager.size(); i++) {
			JButton btnx = removeMarkManager.get(i);
			if (e.getSource() == btnx) {
				markId = Integer.parseInt(btnx.getName());
//				System.out.println(tableId);
			}
		}
		int result = JOptionPane.showConfirmDialog(pn4, "Bạn muốn xóa bài chấm không?", "",
				JOptionPane.WARNING_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			boolean checkRemove = markController.removeMarkByID(markId);
			if (checkRemove) {
				JOptionPane.showMessageDialog(pn4, "Xóa thành công bài chấm!");
				reload();
			} else {
				JOptionPane.showMessageDialog(pn4, "Xóa thất bại!");
			}
		}

	}

//	reload panel 3
	public void reload() {
		pn3.removeAll();
		pn4.removeAll();
		pn3.hide();
		pn4.hide();
		showListMark(markController.findListMarkAllByTableId(this.table.getId()), pn4);
		pn3.show();
		pn4.show();

	}
}
