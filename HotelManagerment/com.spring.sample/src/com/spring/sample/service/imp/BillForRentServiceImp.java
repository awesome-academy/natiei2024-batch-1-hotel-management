package com.spring.sample.service.imp;

import java.util.List;

import com.spring.sample.dao.RoomDAO;
import com.spring.sample.entity.Room;
import com.spring.sample.service.BillForRentService;

public class BillForRentServiceImp extends BaseServiceImpl implements BillForRentService{
	
	private BillForRentServiceImp() {
	}
	
	@Override
	public List<Room> getAvailableRooms() {
		return null;
//		return roomDAO.getAvailableRooms();
	}
}
