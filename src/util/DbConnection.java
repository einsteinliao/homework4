package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Connection getDbConnection()
	{
		String url="jdbc:mysql://localhost:3306/homework4";
		String user="root";
		String password="my123";	
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection(url, user, password);
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
