package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TableConnector {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/new_schema","root","root");
	}
}

