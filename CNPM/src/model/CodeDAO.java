package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.CodeDTO;
import DTO.TableDTO;
import DTO.UserDTO;
import connection.ConnectionDB;

public class CodeDAO {
	// where table.id
	public static boolean checkCodeExist(int code, TableDTO table) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from code_exam where code_content = ? and table_id = ? and hide = 0";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setInt(1, code);
			s.setInt(2, table.getId());
			rs = s.executeQuery();
			if (rs.next()) {
				rs.close();
				s.close();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

//    insert code
	public static CodeDTO insertCode(CodeDTO code) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		CodeDTO codeNew = null;
		try {
			String sql = "INSERT INTO code_exam VALUES (null,?,?,?)";
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			s = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setInt(1, code.getTableID());
			s.setInt(2, code.getCode());
			s.setInt(3, code.getHide());
			s.execute();
			rs = s.getGeneratedKeys();
			if (rs.next())
				codeNew = new CodeDTO(rs.getInt(1));
			con.commit();
			return codeNew;
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

		return null;
	}

	public static boolean removeCodeByID(int id) {
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "delete from code_exam where code_id = ?";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean hideCodeByID(int id, int hide) {
		Connection con = null;
		PreparedStatement s = null;
		int row = 0;
		try {
			String sql = "update code_exam set hide = ? where code_id = ?";
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			s = con.prepareStatement(sql);
			s.setInt(1, hide);
			s.setInt(2, id);
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
	public static List<CodeDTO> loadCodeByIDTable(TableDTO table) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		List<CodeDTO> listCode = new ArrayList<CodeDTO>();
		try {
			String sql = "select * from code_exam where table_id = ? and hide = 0";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setInt(1, table.getId());
			rs = s.executeQuery();
			while (rs.next()) {
				listCode.add(new CodeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			rs.close();
			s.close();
			return listCode;
		} catch (SQLException e) {
			e.printStackTrace();
			return listCode;
		}
	}
//	Mai
	// Tim code_id dua vao table_id va code_content
	public static int findCodeID(int tableID, int code) {
		PreparedStatement s = null;
		int codeID = 0;
		try {
//			loc hide=0 de chac chan rang code chua bi xoa
			String sql = "select * from code_exam where table_id = ? and code_content = ? and hide=0";
			s = ConnectionDB.createConnection().prepareStatement(sql);
			s.setInt(1, tableID);
			s.setInt(2, code);

			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				codeID = rs.getInt(1);
			}
			rs.close();
			s.close();
			return codeID;
		} catch (SQLException e) {
			e.printStackTrace();
			return codeID;
		}
	}
	
}
