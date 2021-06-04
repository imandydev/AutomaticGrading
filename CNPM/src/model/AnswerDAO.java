package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.AnswerDTO;
import DTO.TableDTO;
import connection.ConnectionDB;

public class AnswerDAO {
	 public static boolean insertAnswer(AnswerDTO answerDTO) {
		 	ResultSet rs = null;
	        Connection con = null;
	        PreparedStatement s = null;
	        try {
	        	for (int key : answerDTO.getListAnswerByCode().keySet()) {
	        		String sql = "INSERT INTO answer VALUES (null,?,?,?)";
	        		con = ConnectionDB.createConnection();
	        		con.setAutoCommit(false);
	        		s = con.prepareStatement(sql);
	 	            s.setInt(1, answerDTO.getCodeID());
	 	            s.setInt(2, key);
	 	            s.setString(3,answerDTO.getListAnswerByCode().get(key));
	 	            s.executeUpdate();
				}
	        	con.commit();
	        	return true;
	        } catch (SQLException e) {
	        	if (con != null) {
					try {
						con.rollback();
					} catch(SQLException e1) {
						e.printStackTrace();
					}
				}
	        } finally {
	        	try {
	        		if(rs != null)
	        			rs.close();
	        		if(s != null)
	        			s.close();
	        		if(con != null)
	        			con.close();
	        	} catch(SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        return false;
	    }
}
