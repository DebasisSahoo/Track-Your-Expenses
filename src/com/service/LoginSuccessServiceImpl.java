package com.service;

import java.util.Calendar;

import com.bean.LoginSuccess;
import com.factory.Factory;

public class LoginSuccessServiceImpl implements LoginSuccessService{

	@Override
	public String calculate(LoginSuccess loginSuccess) throws Exception {
		// TODO Auto-generated method stub
		
		
		return Factory.createLoginSuccessDAO().calculate(loginSuccess);
	}

	@Override
	public Integer daily_calculate(Calendar daily_date,String uname) throws Exception {
		// TODO Auto-generated method stub
		return Factory.createLoginSuccessDAO().daily_calculate(daily_date,uname);
	}

	@Override
	public Integer monthly_calculate(Calendar start_date, Calendar end_date,String uname) throws Exception {
		// TODO Auto-generated method stub
		return Factory.createLoginSuccessDAO().monthly_calculate(start_date, end_date,uname);
	}


	

}
