package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

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
				s.setString(3, answerDTO.getListAnswerByCode().get(key));
				s.executeUpdate();
			}
			con.commit();
			return true;
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e.printStackTrace();
				}
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (s != null)
					s.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

//	Mai
	// Tim ra dap an 1 ma de tu DB dua vao code_id
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
//	Tim ra so cau dung
	public static int getNumberAnswerCorrect(HashMap<Integer, String> listAnswerImg, int codeID) {
		int count = 0;
		HashMap<Integer, String> listAnswer = findAnswer(codeID);
		System.out.println(listAnswer);
		Set<Integer> key = listAnswer.keySet();
		for (int number : key) {
			if (listAnswer.get(number).equalsIgnoreCase(listAnswerImg.get(number))
					|| listAnswer.get(number).equalsIgnoreCase("F"))
				count++;
		}
		return count;
	}

}
