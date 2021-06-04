package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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


//	Mai
	// TÃ¬m ra Ä‘Ã¡p Ã¡n cá»§a 1 mÃ£ Ä‘á»� tá»« DB dá»±a vÃ o codeID
	public static HashMap<Integer, String> findAnswer(int codeID) {
		PreparedStatement s = null;
		HashMap<Integer, String> listAnswer = new HashMap<Integer, String>();
		try {
			String sql = "select * from answer where code_id = ?";
			s = ConnectionDB.createConnection().prepareStatement(sql);
			s.setInt(1, codeID);

			int key;
			String value;

			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				key = rs.getInt(3);
				value = rs.getString(4);
				listAnswer.put(key, value);
			}

			rs.close();
			s.close();
			return listAnswer;
		} catch (SQLException e) {
			e.printStackTrace();
			return listAnswer;
		}
	}

//	Mai
	// test
	public static void main(String[] args) {
		System.out.println(findAnswer(1));

	}
}
