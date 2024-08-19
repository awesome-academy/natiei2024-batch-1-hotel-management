package com.spring.sample.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.sample.dao.ReceiptDAO;
import com.spring.sample.dao.RentalReceiptDetailDAO;
import com.spring.sample.dao.RoomDAO;
import com.spring.sample.dao.RoomTypeDAO;
import com.spring.sample.dao.UserDAO;

public class BaseServiceImpl {

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected RoomDAO roomDAO;

	@Autowired
	protected RoomTypeDAO roomTypeDAO;

	@Autowired
	protected ReceiptDAO receiptDAO;
	 
	@Autowired
	protected RentalReceiptDetailDAO rentalReceiptDetailDAO;
	
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
