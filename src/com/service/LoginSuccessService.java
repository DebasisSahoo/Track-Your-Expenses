package com.service;


import java.util.Calendar;

import com.bean.LoginSuccess;

public interface LoginSuccessService {
	
	public String calculate(LoginSuccess loginSuccess) throws Exception;
	//public Integer daily_calculate(Calendar daily_date) throws Exception;
	public Integer monthly_calculate(Calendar start_date,Calendar end_date,String uname) throws Exception;
	Integer daily_calculate(Calendar daily_date, String uname) throws Exception;

}
