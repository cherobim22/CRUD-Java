package model.dao;
import javax.management.RuntimeErrorException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.logging.Logger;
	
	public class ConnectionFactory {
		
		public static Connection getConnection(){
			
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbteste?useTimezone=true&serverTimezone=UTC","root","");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
