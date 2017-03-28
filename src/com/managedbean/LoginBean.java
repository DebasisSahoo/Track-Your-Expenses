package com.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import com.bean.Login;

import com.factory.ClassFactory;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String uname;
	private String password;
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin()
	{
		 String path="";
		
		 Login login=new Login();
		 login.setUname(uname);
		 login.setPassword(password);
		 
		 try {
			Login s= ClassFactory.createLoginService().authorize(login);
			
			if(s.getPassword()==null)
			{
				path="Error";
			}
			else
			{
				path="LoginSuccess";
			}
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return path;
	}
	
	public String doLogout()
	{
		String path="";
		FacesContext ftx = FacesContext.getCurrentInstance();
		ExternalContext etx = ftx.getExternalContext();
		HttpSession session = (HttpSession) etx.getSession(true);
		
		session.invalidate();
		
		path="Logout";
		return path;
	}
	

}
