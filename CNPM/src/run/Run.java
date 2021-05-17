package run;

import view.LoginAndRegisterView;

import java.awt.Dimension;
import java.awt.Toolkit;

import view.IntroView;

public class Run {
	public static void main(String[] args) {
		IntroView screen = new IntroView();
		LoginAndRegisterView sign = new LoginAndRegisterView();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		screen.setSize(800, 500);
		sign.setSize(910, 620);
		int w = screen.getSize().width;
		int h = screen.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		screen.setLocation(x, y);
		screen.setVisible(true);
		try {
			for (int row = 0; row <= 100; row++) {
				Thread.sleep(30);
				screen.loadingnumber.setText(Integer.toString(row) + "%");
				screen.loadingprogress.setValue(row);
				if (row == 100) {
					w = sign.getSize().width;
					h = sign.getSize().height;
					x = (dim.width - w) / 2;
					y = (dim.height - h) / 2;
					sign.setLocation(x, y);
					screen.setVisible(false);
					sign.setVisible(true);
				}
			}
		} catch (Exception e) {
		}
	}

}
