package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            String sql = "select * from code_submissions where code_content = ? and table_id = ?";
            con = ConnectionDB.createConnection();
            s = con.prepareStatement(sql);
            s.setInt(1, code);
//            s.setInt(2, table.getID());
            rs = s.executeQuery();
            if (rs.next()) {
            	rs.close();
                s.close();
            	return true;
            }
            return false;
        } catch ( SQLException e) {
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
            String sql = "INSERT INTO code_submissions VALUES (null,?,?,?);";
            con = ConnectionDB.createConnection();
            con.setAutoCommit(false);
            s = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            s.setInt(2, code.getTableID());
            s.setInt(3, code.getCode());
            s.setInt(4, code.getHide());
            s.executeUpdate();
            rs = s.getGeneratedKeys();
            if (rs.next()) {
				codeNew = new CodeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				con.commit();
			}
            return codeNew;
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

       return null;
    }
//    get new code has insert

////    remove code = set hide = 1, 1 = hide | 0 not hide
    public static boolean removeCodeByID(int id, int hide) {
//    	PreparedStatement s = null;
//    	CodeDTO codeDTO = null;
//        try {
//            String sql = "update code_submissions set hide = ? where id = ?";
//            s = ConnectionDB.createConnection(sql);
//            s.setInt(1, hide);
//            s.setInt(2, id);
//            s.close();
//            return true;
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
            return false;
        }
//    }
}
