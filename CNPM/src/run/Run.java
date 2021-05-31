package run;

import view.LoginAndRegisterView;
import view.ManagerCodeView;

import java.awt.Dimension;
import java.awt.Toolkit;


import model.AnswerDAO;
import view.AddCodeView;

public class Run {
	public static void main(String[] args) {
//		AddCodeView add = new AddCodeView();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		LoginAndRegisterView sign = new LoginAndRegisterView();
		ManagerCodeView sign = new ManagerCodeView();
//		sign.setSize(910, 620);
		int w = sign.getSize().width;
		int h = sign.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		sign.setLocation(x, y);
		sign.setVisible(true);

		
	}

}
