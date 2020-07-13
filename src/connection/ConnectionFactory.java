package connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CrudJbdc;user=pedro;password=catolica123";
		
		try {
			return DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection connection) {
		try {
			if(connection != null) 
				connection.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, Statement stmt) {
		close(connection);
		try {
			if(stmt != null) 
				stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, Statement stmt, ResultSet rs) {
		close(connection);
		close(connection, stmt);
		try {
			if(rs != null) 
				rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
