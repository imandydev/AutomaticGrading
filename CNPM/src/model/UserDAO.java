package model;

import DTO.UserDTO;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionDB;

public class UserDAO {
//	kiem tra tai khoan mat khau co ton tai trong DB hay khong
	public static UserDTO checkUserExist(String username, String pass)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ResultSet rs = null;
		String passEncode = passwordSHA512(pass);
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from user_info where user_name = ? and pass = ?";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setString(1, username);
			s.setString(2, passEncode);
			rs = s.executeQuery();
			UserDTO user = null;
			if (rs.next())
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

	public static String passwordSHA512(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String code = "";
		MessageDigest msd = MessageDigest.getInstance("SHA-512");
		byte[] srcTextBytes = pass.getBytes("UTF-8");
		byte[] endTextBytes = msd.digest(srcTextBytes);
		BigInteger bigInt = new BigInteger(1, endTextBytes);
		code = bigInt.toString(16);
		return code;
	}

	// tim user theo id
	public static UserDTO findUserById(int userId) {
		UserDTO userDTO = new UserDTO();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from user_info where user_id = ?;";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setInt(1, userId);
			rs = s.executeQuery();
			while (rs.next()) {
				userDTO.setId(rs.getInt("user_id"));
				userDTO.setName(rs.getString("user_name"));
			}
		} catch (SQLException throwables) {
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (s != null)
					s.close();
				if (con != null)
					con.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return userDTO;
	}

//	Mai
	// Kiem tra username da ton tai hay chua
	public static boolean checkUserName(String username) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String user = "";
			String sql = "select * from user_info where user_name = ?";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setString(1, username);
			rs = s.executeQuery();
			if (rs.next())
				user = rs.getString(2);
			if (user.equals(""))
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

//	Mai
	// Kiem tra email da duoc dang ki bang tai khoan khac chua
	public static boolean checkEmail(String email) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String rsEmail = "";
			String sql = "select * from user_info where email = ?";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setString(1, email);
			rs = s.executeQuery();
			if (rs.next())
				rsEmail = rs.getString(2);
			if (rsEmail.equals(""))
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

//	Mai
	// insert User
	public static boolean insertUser(UserDTO user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		PreparedStatement s = null;
		try {
			String sql = "INSERT INTO user_info VALUES (null,?,?,?,?,?,?);";

			s = ConnectionDB.createConnection().prepareStatement(sql);
			s.setString(1, user.getName());
			s.setString(2, user.getEmail());
			s.setString(3, passwordSHA512(user.getPass()));
			s.setInt(4, user.getRole());
			s.setString(5, user.getKey());
			s.setInt(6, user.getHide());

			s.executeUpdate();

			s.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
