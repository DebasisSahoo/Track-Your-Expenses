package com.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.bean.Registration;
import com.factory.Factory;

@ManagedBean
@RequestScoped
public class RegistrationBean {
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
			System.out.println("hehe");
			Registration rto=new Registration();
			rto.setUname(uname);
			rto.setEmail(email);
			rto.setPassword(password);
			
			this.message =Factory.createRegistrationService().registerNewMember(rto);
			System.out.println("he");
			System.out.println(message);
			return message;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	

}
