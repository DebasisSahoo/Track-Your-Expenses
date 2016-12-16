package com.dao;

import java.net.URISyntaxException;
import java.sql.SQLException;

import com.bean.Registration;

public interface RegistrationDAO {
	public String registerNewMember(Registration rto) throws URISyntaxException, SQLException;

}
