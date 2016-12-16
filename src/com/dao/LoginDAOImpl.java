package com.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Login;

import com.entity.RegistrationEntity;
import com.factory.HibernateUtility;

public class LoginDAOImpl implements LoginDAO{
	//private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public Login authorize(Login login) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside authorize");
		Login log=new Login();
		
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			
			RegistrationEntity re=null;
			System.out.println("Hii "+login.getUname());
			
			re=(RegistrationEntity)session.get(RegistrationEntity.class,login.getUname());
			System.out.println("REg. Entity"+re.getEmail());
			log.setUname(re.getUname());
			log.setPassword(re.getPwd());
		}*/
		 Connection connection = getConnection();
		        
		        Statement stmt = connection.createStatement();
		        try
				{
					 
		        
		        String sql="select uname,pwd from registration where uname='d'";
		        ResultSet rs=stmt.executeQuery(sql);
		        while(rs.next())
		        {
		        	String name=rs.getString("uname");
		        	String password=rs.getString("pwd");
		        	log.setUname(name);
		        	log.setPassword(password);
		        }
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		        	 connection.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(connection!=null)
		        	 connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		
		return log;
		
	}
	
	 private static Connection getConnection() throws URISyntaxException, SQLException {
		 
		 System.out.println("Inside Connection");
	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		 
		 

	        return DriverManager.getConnection(dbUrl, username, password);
	    }

}
