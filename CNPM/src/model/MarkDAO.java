package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.MarkDTO;
import connection.ConnectionDB;

public class MarkDAO {

//	Mai
	// insert kết quả chấm điểm của 1 bài kiểm tra
	public static boolean insertMark(MarkDTO mark) {
		PreparedStatement s = null;
		try {
			String sql = "INSERT INTO exam_been_graded VALUES (null,?,?,?,?,?,?,?);";

			s = ConnectionDB.createConnection().prepareStatement(sql);
			s.setInt(1, mark.getTableID());
			s.setInt(2, mark.getNumberAnswerCorrect());
			s.setString(3, mark.getImgCode());
			s.setString(4, mark.getImgStudentID());
			s.setString(5, mark.getImgFull());
			s.setDouble(6, mark.getGrade());
			s.setInt(7, mark.getHide());

			s.executeUpdate();

			s.close();
			System.out.println("Insert Mark thành công");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Mark thất bại");
			return false;
		}
	}

//	Mai
//	test
	public static void main(String[] args) {
		MarkDTO mark = new MarkDTO(0, 1, 6, "123", "123456", "text.jpg", 6, 0);
		insertMark(mark);
	}
}
