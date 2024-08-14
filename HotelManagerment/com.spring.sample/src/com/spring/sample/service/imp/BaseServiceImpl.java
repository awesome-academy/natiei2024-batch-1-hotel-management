package com.spring.sample.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sample.dao.RoomDAO;
import com.spring.sample.dao.UserDAO;

public class BaseServiceImpl {

	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected RoomDAO roomDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
}
