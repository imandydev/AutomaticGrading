package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.AnswerDTO;
import DTO.TableDTO;
import connection.ConnectionDB;

public class AnswerDAO {
	 public static boolean insertAnswer(AnswerDTO answerDTO) {
	        PreparedStatement s = null;
	        try {
	        	for (int key : answerDTO.getListAnswerByCode().keySet()) {
	        		String sql = "INSERT INTO answer VALUES (null,?,?,'?');";
	 	            s = ConnectionDB.createConnection(sql);
	 	            s.setInt(2, answerDTO.getCodeID());
	 	            s.setInt(3, key);
	 	            s.setString(4,answerDTO.getListAnswerByCode().get(key));
				}
	        	  return true;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
