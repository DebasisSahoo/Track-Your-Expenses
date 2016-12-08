package com.service;

import com.bean.Login;



public interface LoginService {

	public Login authorize(Login login) throws Exception;
}
