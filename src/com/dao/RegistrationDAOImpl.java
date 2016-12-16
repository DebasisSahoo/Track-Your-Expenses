package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Registration;
import com.entity.RegistrationEntity;
import com.factory.HibernateUtility;

public class RegistrationDAOImpl implements RegistrationDAO {

	//private SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
	@Override
	public String registerNewMember(Registration rto) {
		// TODO Auto-generated method stub
		//Session session = sessionFactory.openSession();
		//session.beginTransaction();
		try
		{
			System.out.println();
			RegistrationEntity re=new RegistrationEntity();
			re.setUname(rto.getUname());
			re.setEmail(rto.getEmail());
			re.setPwd(rto.getPassword());
			/*session.save(re);
			session.flush();
			session.close(); */
			return "mon";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		/*finally
		{
			session.close(); 
		}*/
		
	}
	
}
