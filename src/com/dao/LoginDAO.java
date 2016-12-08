package com.dao;

import com.bean.Login;


public interface LoginDAO {
	
	public Login authorize(Login login) throws Exception;

}
