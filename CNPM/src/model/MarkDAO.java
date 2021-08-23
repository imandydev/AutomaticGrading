package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//			System.out.println("Insert Mark thành công");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("Insert Mark thất bại");
			return false;
		}
	}
	
	// tim list mark theo tableid
	public static List<MarkDTO> findListMarkAllByTableId(int tableId) {
		List<MarkDTO> listMarkDTO = new ArrayList<MarkDTO>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from exam_been_graded where hide = 0 and table_id = ?;";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setInt(1, tableId);
			rs = s.executeQuery();	
			while (rs.next()) {
				MarkDTO markDTO = new MarkDTO();
				markDTO.setMarkID(rs.getInt("sub_id"));
				markDTO.setTableID(rs.getInt("table_id"));
				markDTO.setImgStudentID(rs.getString("img_student_id"));
				markDTO.setImgCode(rs.getString("img_code"));
				markDTO.setNumberAnswerCorrect(rs.getInt("number_ans_correct"));
				markDTO.setGrade(rs.getDouble("grade"));
				listMarkDTO.add(markDTO);
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
		return listMarkDTO;
	}
	
	
	
	// t�m mark theo mark id
	public static boolean removeMarkByID(int id) {
		Connection con = null;
		PreparedStatement s = null;
		int row = 0;
		try {
			String sql = "update exam_been_graded set hide = 1 where sub_id = ?";
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			s = con.prepareStatement(sql);
			s.setInt(1, id);
		    row = s.executeUpdate();
            con.commit();
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
				if (s != null)
					s.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
        return row > 0 ? true : false;
	}
	
}
