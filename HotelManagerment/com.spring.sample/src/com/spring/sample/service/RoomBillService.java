package com.spring.sample.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.sample.entity.RoomBill;
import com.spring.sample.dao.RoomBillDAO;
import com.spring.sample.entity.Room;


public interface RoomBillService {
	
	List<Room> getAvailableRooms() throws SQLException;
	List<RoomBill> getAllRoomBills() throws SQLException;
}