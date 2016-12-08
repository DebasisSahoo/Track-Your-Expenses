package com.service;

import com.bean.Login;

import com.factory.Factory;

public class LoginServiceImpl implements LoginService {

	@Override
	public Login authorize(Login login) throws Exception {
		// TODO Auto-generated method stub
		
		Login log=Factory.createLoginDAO().authorize(login);
		if(login.getPassword().equals(log.getPassword()))
		{
			System.out.println("Success");
		}
		else
		{
			log.setPassword(null);
		}
		
		return log;
	}

}
