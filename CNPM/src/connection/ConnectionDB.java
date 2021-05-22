package connection;


import java.sql.*;
	// connection database
public class ConnectionDB {
    static Connection con;
    public static PreparedStatement createConnection(String sql) throws SQLException, ClassNotFoundException {
        String username = "ulkrz8rktdioet9c";
        String password = "MVpk8pgHDjWSmPkia9UW";
        String url = "jdbc:mysql://ulkrz8rktdioet9c:MVpk8pgHDjWSmPkia9UW@bkrnar34plberh3l0eof-mysql.services.clever-cloud.com:3306/bkrnar34plberh3l0eof";
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username,password);
            return con.prepareStatement(sql);
        } else {
            return con.prepareStatement(sql);
        }
    }
}
