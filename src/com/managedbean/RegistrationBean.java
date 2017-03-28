package com.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.bean.Registration;
import com.factory.ClassFactory;

import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class RegistrationBean {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private String uname;
	private String email;
	private String password;

	private String message;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String registerUser()
	{
		try
		{
			Registration rto=new Registration();
			rto.setUname(uname);
			rto.setEmail(email);
			rto.setPassword(password);
			
			this.message = ClassFactory.createRegistrationService().registerNewMember(rto);
			logger.info(message);
			return message;
		}
		catch(Exception e)
		{
			logger.severe(e.getMessage());
			return null;
		}
		
	}
	

}
