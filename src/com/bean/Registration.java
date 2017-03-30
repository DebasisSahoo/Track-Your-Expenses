package com.bean;



public class Registration {

	private String uname;

	public Registration() {
	}

	public Registration(String uname, String email, String password) {
		this.uname = uname;
		this.email = email;
		this.password = password;
	}

	private String email;
	private String password;
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
	
}
