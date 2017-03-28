package com.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Login;

import com.entity.RegistrationEntity;
import com.factory.HibernateUtility;
import com.factory.JDBCConnection;

public class LoginDAOImpl implements LoginDAO{
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
			re=(RegistrationEntity)session.get(RegistrationEntity.class,login.getUname());
			System.out.println("REg. Entity"+re.getEmail());
			log.setUname(re.getUname());
			log.setPassword(re.getPwd());
		}*/
		 Connection connection = JDBCConnection.jdbcConnection();
		        
		       // Statement stmt = connection.createStatement();
		        try
				{
					 
		       // System.out.println("outside of prepare stmt");
		        String sql="select uname,pwd from register where uname=?";
		        PreparedStatement ps=connection.prepareStatement(sql);
		        logger.info(login.getUname());
		        ps.setString(1, login.getUname());
		        ResultSet rs=ps.executeQuery();
		        while(rs.next())
		        {
		        	String name=rs.getString("uname");
		        	String password=rs.getString("pwd");
		        	log.setUname(name);
		        	log.setPassword(password);
		        }
		}
		 catch (Exception e) {
				logger.severe(e.getMessage());
			}
		finally{
		      //finally block used to close resources
		      
		      try{
		         if(connection!=null)
		        	 connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		
		return log;
		
	}
	
	/* private static Connection getConnection() throws URISyntaxException, SQLException {
		 
		 System.out.println("Inside Connection");
	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		 
		 

	        return DriverManager.getConnection(dbUrl, username, password);
	    }*/

}
