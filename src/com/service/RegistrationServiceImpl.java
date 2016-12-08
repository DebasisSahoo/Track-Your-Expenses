package com.service;

import com.bean.Registration;
import com.factory.Factory;

public class RegistrationServiceImpl implements RegistrationService{
	@Override
	public String registerNewMember(Registration rto) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			return Factory.createRegistrationDAO().registerNewMember(rto);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}

}
