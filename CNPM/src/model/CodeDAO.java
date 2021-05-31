package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.CodeDTO;
import DTO.TableDTO;
import DTO.UserDTO;
import connection.ConnectionDB;

public class CodeDAO {
	// where table.id
    public static boolean checkCodeExist(int code,TableDTO table) {
        PreparedStatement s = null;
        try {
            String sql = "select * from code_submissions where code_content = ? and table_id = ?";
            s = ConnectionDB.createConnection(sql);
            s.setInt(1, code);
//            s.setInt(2, table.getID());
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
            	rs.close();
                s.close();
            	return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//    insert code
    public static boolean insertCode(CodeDTO code) {
        PreparedStatement s = null;
        try {
//        	2. code.getidtable
            String sql = "INSERT INTO code_submissions VALUES (null,?,?,?);";
            s = ConnectionDB.createConnection(sql);
            ResultSet rs = s.executeQuery();
            s.setInt(2, code.getTableID());
            s.setInt(3, code.getCode());
            s.setInt(4, code.getHide());
            rs.close();
            s.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//    get new code has insert
    public static CodeDTO getCodeNewInsert() {
    	PreparedStatement s = null;
    	CodeDTO codeDTO = null;
        try {
            String sql = "select * from code_submissions where order by code_id desc limit 1";
            s = ConnectionDB.createConnection(sql);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
            	codeDTO = new CodeDTO(rs.getInt(0), rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
            rs.close();
            s.close();
            return codeDTO;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
//    remove code = set hide = 1, 1 = hide | 0 not hide
    public static boolean removeCodeByID(int id, int hide) {
    	PreparedStatement s = null;
    	CodeDTO codeDTO = null;
        try {
            String sql = "update code_submissions set hide = ? where id = ?";
            s = ConnectionDB.createConnection(sql);
            s.setInt(1, hide);
            s.setInt(2, id);
            s.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
