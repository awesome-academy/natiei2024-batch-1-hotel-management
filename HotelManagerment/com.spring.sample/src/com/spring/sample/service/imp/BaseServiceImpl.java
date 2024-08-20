package com.spring.sample.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sample.dao.PermissionDAO;
import com.spring.sample.dao.RoomDAO;
import com.spring.sample.dao.RoomTypeDAO;
import com.spring.sample.dao.SettingDAO;
import com.spring.sample.dao.SurchargeRateDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.dao.UsersDAO;

public class BaseServiceImpl {

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected RoomDAO roomDAO;
	
	@Autowired
	protected UsersDAO usersDAO;
	
	@Autowired
	protected PermissionDAO permissionDAO;
	
	@Autowired
	protected SurchargeRateDAO surchargeRateDAO;
	

	@Autowired
	protected RoomTypeDAO roomTypeDAO;
	
	@Autowired
	protected SettingDAO settingDAO;

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

	public RoomTypeDAO getRoomTypeDAO() {
		return roomTypeDAO;
	}

	public void setRoomTypeDAO(RoomTypeDAO roomTypeDAO) {
		this.roomTypeDAO = roomTypeDAO;
	}
	
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}
	
	public SurchargeRateDAO getsurchargeRateDAO() {
		return surchargeRateDAO;
	}

	public void setSurchargeRateDAO(SurchargeRateDAO surchargeRateDAO) {
		this.surchargeRateDAO = surchargeRateDAO;
	}
	
	public SettingDAO getsettingDAO() {
		return settingDAO;
	}

	public void setSettingDAO(SettingDAO settingDAO) {
		this.settingDAO = settingDAO;
	}

}
