package com.factory;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.dao.LoginSuccessDAO;
import com.dao.LoginSuccessDAOImpl;
import com.dao.RegistrationDAO;
import com.dao.RegistrationDAOImpl;
import com.service.LoginService;
import com.service.LoginServiceImpl;
import com.service.LoginSuccessService;
import com.service.LoginSuccessServiceImpl;
import com.service.RegistrationService;
import com.service.RegistrationServiceImpl;

public class Factory {

	public static RegistrationService createRegistrationService()
	{
		return new RegistrationServiceImpl();
	}
	public static RegistrationDAO createRegistrationDAO()
	{
		return new RegistrationDAOImpl();
	}
	public static LoginService createLoginService()
	{
		return new LoginServiceImpl();
	}
	public static LoginDAO createLoginDAO()
	{
		return new LoginDAOImpl();
	}
	public static LoginSuccessDAO createLoginSuccessDAO()
	{
		return new LoginSuccessDAOImpl();
	}
	public static LoginSuccessService createLoginSuccessService()
	{
		return new LoginSuccessServiceImpl();
	}
}
