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
}
