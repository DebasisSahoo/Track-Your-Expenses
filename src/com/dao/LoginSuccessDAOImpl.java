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

public class LoginSuccessDAOImpl implements LoginSuccessDAO{

	private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public String calculate(LoginSuccess loginSuccess) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
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
			
			
			LoginSuccessEntity lse1=new LoginSuccessEntity();
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
			session.close(); 
			return "mon";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		
		
	}
	@Override
	public Integer daily_calculate(Calendar daily_date,String uname) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("uname :"+uname);
		Integer total_expenditure=0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<LoginSuccess> list=new ArrayList<LoginSuccess>();
		Query q=session.createQuery("select c from LoginSuccessEntity c where dateofdata=? and uname=?");
		q.setParameter(0, daily_date);
		q.setParameter(1, uname);
		List<LoginSuccessEntity> successEntities=q.list();
		
		for(LoginSuccessEntity lse:successEntities)
		{
			total_expenditure=total_expenditure+lse.getBook()+lse.getBus()+lse.getFood()+lse.getHome()+lse.getMobile()+
					lse.getParty()+lse.getWifi()+lse.getShopping();
		}
		
		return total_expenditure;
	}
	@Override
	public Integer monthly_calculate(Calendar start_date, Calendar end_date,String uname) throws Exception {
		// TODO Auto-generated method stub
		Integer total_expenditure=0;
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
	}

}
