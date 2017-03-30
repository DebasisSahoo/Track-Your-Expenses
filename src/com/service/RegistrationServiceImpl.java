package com.service;

import com.bean.Registration;
import com.factory.ClassFactory;
import src.com.exception.ExceptionUtility;

import java.util.logging.Logger;

public class RegistrationServiceImpl implements RegistrationService{
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public String registerNewMember(Registration rto) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			return ClassFactory.createRegistrationDAO().registerNewMember(rto);
		}
		catch(Exception e)
		{
			logger.severe(ExceptionUtility.getStacktrace(e));
			throw e;
		}
	}

}
