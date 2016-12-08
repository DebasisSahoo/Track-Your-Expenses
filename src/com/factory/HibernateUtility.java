package com.factory;


import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


public class HibernateUtility {

	//private static final String CONFIGURATION_LOCATION ="hibernate.cfg.xml";
	private static SessionFactory sessionFactory = null;
	//private static ServiceRegistry serviceRegistry;

	public synchronized static SessionFactory createSessionFactory() {
		if (sessionFactory == null) {
			try {
				System.out.println(org.hibernate.Version.getVersionString());
				// Step1 : Loading the configuration details from
				// hibernate.cfg.xml
				/*Configuration configuration = new Configuration()
						.configure(CONFIGURATION_LOCATION);

				// Step2 : Creating ServiceRegistry using the
				// StandardServiceRegistryBuilder and Configuration defined in
				// Step 1
				serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				// Step3 : Creating the SessionFactory using the Configuration
				// and serviceRegistry.
				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);*/
				
				
				 sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
				 System.out.println("print");
			} catch (Exception e) {
				
					System.out.println(e.getMessage());
			}
		}
		return sessionFactory;
	}
	public static void closeSessionFactory()
	{
		if(sessionFactory!=null)
		{
			sessionFactory.close();
		}
	}

}
