package controller;

import DTO.UserDTO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import model.UserDAO;

public class UserController {
//	Kiem tra ten tai khoan va mat khau co ton tai hay khong thong qua UserDAO
	public UserDTO checkUser(String username, String pass)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return UserDAO.checkUserExist(username, pass);
	}

// tim user theo id
	public UserDTO findUserById(int userId) {
		return UserDAO.findUserById(userId);
	}

//	Dang ki user moi
	public String register(String userName, String email, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String result = "";
		if (UserDAO.checkUserName(userName) == true)
			result += "T";
		else
			result += "F";
		if (UserDAO.checkEmail(email) == true)
			result += "T";
		else
			result += "F";
		if (result.equals("TT")) {
			UserDTO user = new UserDTO(0, userName, email, password, 0, null, 0);
			UserDAO.insertUser(user);
		}
		return result;
	}

}
