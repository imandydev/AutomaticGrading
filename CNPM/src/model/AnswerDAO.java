package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DTO.AnswerDTO;
import DTO.TableDTO;
import connection.ConnectionDB;

public class AnswerDAO {
	public static boolean insertAnswer(AnswerDTO answerDTO) {
		PreparedStatement s = null;
		try {
			for (int key : answerDTO.getListAnswerByCode().keySet()) {
				String sql = "INSERT INTO answer VALUES (null,?,?,'?');";
				s = ConnectionDB.createConnection().prepareStatement(sql);
				s.setInt(2, answerDTO.getCodeID());
				s.setInt(3, key);
				s.setString(4, answerDTO.getListAnswerByCode().get(key));
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

//	Mai
	// Tìm ra đáp án của 1 mã đề từ DB dựa vào codeID
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
