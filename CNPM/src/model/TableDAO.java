package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.TableDTO;
import connection.ConnectionDB;

public class TableDAO {

	public static boolean checkTableExist(String name) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from table_manager where table_name = ? and hide = 0";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			s.setString(1, name);
			rs = s.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException throwables) {
            return false;
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
		return false;
	}
	
	
	public static List<TableDTO> findListTableAllByHide() {
		List<TableDTO> listTableDTO = new ArrayList<TableDTO>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		try {
			String sql = "select * from table_manager where hide = 0 order by table_id desc;";
			con = ConnectionDB.createConnection();
			s = con.prepareStatement(sql);
			rs = s.executeQuery();
			while (rs.next()) {
				TableDTO tableDTO =  new TableDTO();
				tableDTO.setId(rs.getInt("table_id"));
				tableDTO.setUserId(rs.getInt("user_id"));
				tableDTO.setTableName(rs.getString("table_name"));
				tableDTO.setNumberQuestionUse(rs.getInt("number_question_use"));
				tableDTO.setHide(rs.getInt("hide"));
				listTableDTO.add(tableDTO);
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
		return listTableDTO;
	}
	
//	public static boolean checkTableExist(String name, UserDTO userDTO) {
//		ResultSet rs = null;
//		Connection con = null;
//		PreparedStatement s = null;
//		try {
//			String sql = "select * from table_manager where table_name = ? and user_id = ?";
//			con = ConnectionDB.createConnection();
//			s = con.prepareStatement(sql);
//			s.setString(1, name);
//			s.setInt(2, userDTO.getId());
//			rs = s.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (SQLException throwables) {
//            return false;
//        } finally {
//            try {
//                if (rs != null)
//                    rs.close();
//                if (s != null)
//                    s.close();
//                if (con != null)
//                    con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//		return false;
//	}

//    insert code
	public static int insertTable(TableDTO table) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement s = null;
		int id = 0;
		try {
//        	2. code.getidtable
			String sql = "INSERT INTO table_manager (user_id, table_name, number_question_use, hide) VALUES (?,?,?,?);";
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			s = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setInt(1, table.getUserId());
			s.setString(2, table.getTableName());
			s.setInt(3, table.getNumberQuestionUse());
			s.setInt(4, table.getHide());
			s.executeUpdate();
			rs = s.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			con.commit();
			return id;
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

//    remove table = set hide = 1, 1 = hide | 0 not hide
	public static boolean removeTableManagerByID(int id) {
		Connection con = null;
		PreparedStatement s = null;
		int row = 0;
		try {
			String sql = "update table_manager set hide = 1 where table_id = ?";
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
