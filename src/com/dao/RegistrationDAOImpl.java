package com.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Registration;
import com.entity.RegistrationEntity;
import com.factory.HibernateUtility;
import com.factory.JDBCConnection;

public class RegistrationDAOImpl implements RegistrationDAO {

	//private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public String registerNewMember(Registration rto) throws URISyntaxException, SQLException {
		// TODO Auto-generated method stub
		//Session session = sessionFactory.openSession();
		//session.beginTransaction();
		Connection connection = JDBCConnection.jdbcConnection();
		try
		{
			/*System.out.println();
			RegistrationEntity re=new RegistrationEntity();
			re.setUname(rto.getUname());
			re.setEmail(rto.getEmail());
			re.setPwd(rto.getPassword());
			session.save(re);
			session.flush();
			session.close(); */
			
			
			String sql="insert into register values(?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, rto.getUname());
			ps.setString(2, rto.getPassword());
			ps.setString(3, rto.getEmail());
			
			int i=ps.executeUpdate();
			System.out.println(i+" row(s) inserted");
			
			return "mon";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
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
		/*finally
		{
			session.close(); 
		}*/
		
	}
	
}
