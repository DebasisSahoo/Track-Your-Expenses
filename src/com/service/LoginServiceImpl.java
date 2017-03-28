package com.service;

import com.bean.Login;

import com.factory.ClassFactory;

import java.util.logging.Logger;

public class LoginServiceImpl implements LoginService {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public Login authorize(Login login) throws Exception {
		// TODO Auto-generated method stub
		
		Login log= ClassFactory.createLoginDAO().authorize(login);
		if(login.getPassword().equals(log.getPassword()))
		{
			logger.severe("Success");
		}
		else
		{
			log.setPassword(null);
		}
		
		return log;
	}

}
