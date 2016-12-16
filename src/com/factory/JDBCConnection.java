package com.factory;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;


public class JDBCConnection {
  private static Connection getConnection() throws URISyntaxException, SQLException {
		 
		 System.out.println("Inside Connection");
	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		 
		 

	        return DriverManager.getConnection(dbUrl, username, password);
	    }
  public static Connection jdbcConnection() throws URISyntaxException, SQLException
  {
	  return getConnection();
  }
  

}
