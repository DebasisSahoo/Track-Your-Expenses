package com.factory;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;




public class JDBCConnection {
  private static Connection getConnection() throws URISyntaxException, SQLException {
		 
		 System.out.println("Inside Connection");
	    /*    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();*/
		 try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String username = "postgres";
	        String password = "correct.*";
	        String dbUrl = "jdbc:postgresql://localhost:5432/Student";
		 
		 
		 
		 

	        return DriverManager.getConnection(dbUrl, username, password);
	    }
  public static Connection jdbcConnection() throws URISyntaxException, SQLException
  {
	  return getConnection();
  }
  

}
