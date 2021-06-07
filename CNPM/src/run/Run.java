package run;

import DTO.UserDTO;
import view.AddTableManagerView;
import view.HomeView;
import view.LoginAndRegisterView;
import view.TableManagerView;

public class Run {
	public static void main(String[] args) {
		UserDTO user = new UserDTO();
		user.setRole(1);
		user.setId(1);
		HomeView home = new HomeView(user);
//		LoginAndRegisterView g = new LoginAndRegisterView();
	}

}
