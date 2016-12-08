package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Login;

import com.entity.RegistrationEntity;
import com.factory.HibernateUtility;

public class LoginDAOImpl implements LoginDAO{
	private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public Login authorize(Login login) throws Exception {
		// TODO Auto-generated method stub
		Login log=new Login();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			
			RegistrationEntity re=null;
			System.out.println("Hii "+login.getUname());
			
			re=(RegistrationEntity)session.get(RegistrationEntity.class,login.getUname());
			System.out.println("REg. Entity"+re.getEmail());
			log.setUname(re.getUname());
			log.setPassword(re.getPwd());
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		return log;
	}

}
