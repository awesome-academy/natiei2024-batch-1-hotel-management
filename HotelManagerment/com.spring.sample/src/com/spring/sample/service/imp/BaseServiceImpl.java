package com.spring.sample.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sample.dao.ReceiptDAO;
import com.spring.sample.dao.RentalReceiptDetailDAO;
import com.spring.sample.dao.GuestTypesDAO;
import com.spring.sample.dao.PermissionDAO;
import com.spring.sample.dao.RoomDAO;
import com.spring.sample.dao.RoomTypeDAO;
import com.spring.sample.dao.SettingDAO;
import com.spring.sample.dao.SurchargeRateDAO;
import com.spring.sample.dao.RevenuesDAO;
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
	protected GuestTypesDAO guestTypesDAO;

	@Autowired
	protected RoomTypeDAO roomTypeDAO;

	@Autowired
	protected SettingDAO settingDAO;

	@Autowired
	protected ReceiptDAO receiptDAO;
	 
	@Autowired
	protected RentalReceiptDetailDAO rentalReceiptDetailDAO;
	
	public GuestTypesDAO getGuestTypesDAO() {
		return guestTypesDAO;
	}

	public void setGuestTypesDAO(GuestTypesDAO guestTypesDAO) {
		this.guestTypesDAO = guestTypesDAO;
	}

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

	@Autowired
	protected RevenuesDAO revenuesDAO;

	public RevenuesDAO getRevenuesDAO() {
		return revenuesDAO;
	}

	public void setRevenuesDAO(RevenuesDAO revenuesDAO) {
		this.revenuesDAO = revenuesDAO;
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

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public RentalReceiptDetailDAO getRentalReceiptDetailDAO() {
		return rentalReceiptDetailDAO;
	}

	public void setRentalReceiptDetailDAO(RentalReceiptDetailDAO rentalReceiptDetailDAO) {
		this.rentalReceiptDetailDAO = rentalReceiptDetailDAO;
	}
}
