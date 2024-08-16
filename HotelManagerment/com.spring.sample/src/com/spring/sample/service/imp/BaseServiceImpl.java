package com.spring.sample.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sample.dao.MicropostDAO;
import com.spring.sample.dao.UserDAO;

public class BaseServiceImpl {

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected MicropostDAO micropostDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public MicropostDAO getMicropostDAO() {
		return micropostDAO;
	}

	public void setMicropostDAO(MicropostDAO micropostDAO) {
		this.micropostDAO = micropostDAO;
	}

}
