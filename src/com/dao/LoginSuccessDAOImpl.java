package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.LoginSuccess;
import com.entity.LoginSuccessEntity;
import com.factory.HibernateUtility;
import com.factory.JDBCConnection;
import java.sql.*;

public class LoginSuccessDAOImpl implements LoginSuccessDAO{

	//private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public String calculate(LoginSuccess loginSuccess) throws Exception {
		// TODO Auto-generated method stub
		//Session session = sessionFactory.openSession();
		//session.beginTransaction();
		Connection connection=JDBCConnection.jdbcConnection();
		try
		{
			/*System.out.println();
			LoginSuccessEntity lse=new LoginSuccessEntity();
			lse.setUname(loginSuccess.getUname());
			lse.setBook(loginSuccess.getBook());
			lse.setBus(loginSuccess.getBus());
			lse.setDateOfData(loginSuccess.getDateOfData());
			lse.setFood(loginSuccess.getFood());
			lse.setHome(loginSuccess.getHome());
			lse.setMobile(loginSuccess.getMobile());
			lse.setOther(loginSuccess.getOther());
			lse.setParty(loginSuccess.getParty());
			lse.setShopping(loginSuccess.getShopping());
			lse.setWifi(loginSuccess.getWifi());
			
			session.save(lse);
			
			loginSuccess.setId(lse.getId());*/
			
			
			/*LoginSuccessEntity lse1=new LoginSuccessEntity();
			Query q=session.createQuery("select c from LoginSuccessEntity c where dateofdata=? and uname=?");
			q.setParameter(0, loginSuccess.getDateOfData());
			q.setParameter(1, loginSuccess.getUname());
			
			List<LoginSuccessEntity> successEntities=q.list();
			System.out.println("Succ Entity : "+successEntities);
			if(successEntities.isEmpty())
			{
				
					
					lse1.setUname(loginSuccess.getUname());
					lse1.setBook(loginSuccess.getBook());
					lse1.setBus(loginSuccess.getBus());
					lse1.setDateOfData(loginSuccess.getDateOfData());
					lse1.setFood(loginSuccess.getFood());
					lse1.setHome(loginSuccess.getHome());
					lse1.setMobile(loginSuccess.getMobile());
					lse1.setOther(loginSuccess.getOther());
					lse1.setParty(loginSuccess.getParty());
					lse1.setShopping(loginSuccess.getShopping());
					lse1.setWifi(loginSuccess.getWifi());
					
					session.save(lse1);
					
					loginSuccess.setId(lse1.getId());
				
			
			}
			else
			{
				for(LoginSuccessEntity lse:successEntities)
				{
					//lse.setUname(lsloginSuccess.getUname());
					lse.setBook(lse.getBook()+loginSuccess.getBook());
					lse.setBus(lse.getBus()+loginSuccess.getBus());
					//lse.setDateOfData(loginSuccess.getDateOfData());
					lse.setFood(lse.getFood()+loginSuccess.getFood());
					lse.setHome(lse.getHome()+loginSuccess.getHome());
					lse.setMobile(lse.getMobile()+loginSuccess.getMobile());
					lse.setOther(lse.getOther()+loginSuccess.getOther());
					lse.setParty(lse.getParty()+loginSuccess.getParty());
					lse.setShopping(lse.getShopping()+loginSuccess.getShopping());
					lse.setWifi(lse.getWifi()+loginSuccess.getWifi());
					
					
					session.save(lse);
					
					loginSuccess.setId(lse.getId());
				}
				
				
			}
			session.flush();
			session.close(); */
			
			
			String sql="select max(id) max_id from data";
			//PreparedStatement ps=connection.prepareStatement(sql);
	       // System.out.println("date - Value "+ loginSuccess.getDateOfData());
	        //ps.setDate(1, Date.valueOf(loginSuccess.getDateOfData().toString()));
	        System.out.println("here");
	        //ps.setString(1, loginSuccess.getUname());
	        Statement statement=connection.createStatement();
	        ResultSet rs=statement.executeQuery(sql);
	        System.out.println("RS :"+rs);
	        
	        int max_id=0;
	        if(rs.next())
	        {
	        	max_id=rs.getInt("max_id");
	        }
	       // System.out.println("rs "+rs.getInt(1));
	        /*System.out.println("value of rs "+rs);
	        if(!rs.next())
	        {
	        	System.out.println("no data");
	        }
	       
	        System.out.println(rs.next());
	        if(!rs.next())
	        {*/
	        	String sql1="insert into data values(?,?,?,?,?,?,?,?,?,?,?,?)";
	        	System.out.println("inside if");
	        	PreparedStatement ps1 = connection.prepareStatement(sql1);
	        	//System.out.println("after conn");
	        	//System.out.println("Book");
				ps1.setInt(1, loginSuccess.getBook());
				System.out.println("2");
				ps1.setInt(2, loginSuccess.getBus());
				System.out.println("3");
				ps1.setInt(3, loginSuccess.getHome());
				System.out.println("4");
				ps1.setInt(4, loginSuccess.getShopping());
				System.out.println("5");
				ps1.setInt(5, loginSuccess.getFood());
				System.out.println("6");
				ps1.setInt(6, loginSuccess.getParty());
				System.out.println("7");
				ps1.setInt(7, loginSuccess.getOther());
				System.out.println("8");
				ps1.setInt(8, loginSuccess.getMobile());
				System.out.println("9");
				ps1.setInt(9, loginSuccess.getWifi());
				System.out.println("10");
				System.out.println("date : "+new java.sql.Date(loginSuccess.getDateOfData().getTimeInMillis()));
				ps1.setDate(10, new java.sql.Date(loginSuccess.getDateOfData().getTimeInMillis()));
				ps1.setInt(11, max_id+1);
				//ps1.setDate(parameterIndex, x, cal);
				System.out.println("12");
				ps1.setString(12, loginSuccess.getUname());
				System.out.println("acha");
				int i=ps1.executeUpdate();
				System.out.println(i+" row(s) inserted");
				
	        	
	        
			
			return "mon";
			
		}
		catch(SQLException se){
			System.out.println("hr");
			System.out.println(se.getMessage());
	         se.printStackTrace();
	         return null;
	      }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("here "+e.getMessage());
			System.out.println("ebe kuade joba");
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
		
		
		
		
	}
	//@Override
	public Integer daily_calculate(Calendar daily_date,String uname) throws Exception {
		// TODO Auto-generated method stub
		/*System.out.println("uname :"+uname);
		Integer total_expenditure=0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//List<LoginSuccess> list=new ArrayList<LoginSuccess>();
		Query q=session.createQuery("select c from LoginSuccessEntity c where dateofdata=? and uname=?");
		q.setParameter(0, daily_date);
		q.setParameter(1, uname);
		List<LoginSuccessEntity> successEntities=q.list();
		
		for(LoginSuccessEntity lse:successEntities)
		{
			total_expenditure=total_expenditure+lse.getBook()+lse.getBus()+lse.getFood()+lse.getHome()+lse.getMobile()+
					lse.getParty()+lse.getWifi()+lse.getShopping();
		}
		
		return total_expenditure;*/
		
		
		Connection connection=JDBCConnection.jdbcConnection();
		
		try
		{
			String sql="select * from data where uname=? and dateofdata=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setDate(2, new java.sql.Date(daily_date.getTimeInMillis()));
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("try "+rs.next());
			}
			
		}
		catch(SQLException se){
			//System.out.println("hr");
			System.out.println(se.getMessage());
	         se.printStackTrace();
	         return null;
	      }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("here "+e.getMessage());
			//System.out.println("ebe kuade joba");
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
	    
		return null ;
	
	}
	@Override
	public Integer monthly_calculate(Calendar start_date, Calendar end_date,String uname) throws Exception {
		// TODO Auto-generated method stub
	/*	Integer total_expenditure=0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<LoginSuccess> list=new ArrayList<LoginSuccess>();
		System.out.println("Hiiii dar");
		Query q=session.createQuery("select c from LoginSuccessEntity c where dateofdata>? and dateofdata<? and uname=?");
		q.setParameter(0, start_date);
		q.setParameter(1, end_date);
		q.setParameter(2, uname);
		List<LoginSuccessEntity> successEntities=q.list();
	
		
		for(LoginSuccessEntity lse:successEntities)
		{
			total_expenditure=total_expenditure+lse.getBook()+lse.getBus()+lse.getFood()+lse.getHome()+lse.getMobile()+
					lse.getParty()+lse.getWifi()+lse.getShopping();
			
		}
		System.out.println("total expenditure :"+total_expenditure);
		
		return total_expenditure;
	*/
	return null;
	}

}
