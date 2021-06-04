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
     public static UserDTO checkUserExist(String username, String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException {
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
            rs =   s.executeQuery();
            UserDTO user = null;
            if (rs.next())
                user = new UserDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
            return user;
        } catch ( SQLException e) {
        	return null;
        }
    }
     // ma hoa data
     public static String passwordSHA512(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String code = "";
        MessageDigest msd = MessageDigest.getInstance("SHA-512");
        byte[] srcTextBytes = pass.getBytes("UTF-8");
        byte[] endTextBytes = msd.digest(srcTextBytes);
        BigInteger bigInt = new BigInteger(1,endTextBytes);
        code = bigInt.toString(16);
        return code;
    }
    
    
}
