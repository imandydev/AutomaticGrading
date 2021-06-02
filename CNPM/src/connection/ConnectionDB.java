package connection;

import java.sql.*;

// connection database
public class ConnectionDB {
	private static Connection con = null;

	public static Connection createConnection() {
		try {
			String username = "ulkrz8rktdioet9c";
			String password = "MVpk8pgHDjWSmPkia9UW";
			String url = "jdbc:mysql://ulkrz8rktdioet9c:MVpk8pgHDjWSmPkia9UW@bkrnar34plberh3l0eof-mysql.services.clever-cloud.com:3306/bkrnar34plberh3l0eof";
			if (con == null || con.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				return con;
			}

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}
		return con;

	}
}
