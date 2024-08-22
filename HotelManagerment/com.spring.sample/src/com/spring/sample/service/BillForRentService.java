package com.spring.sample.service;

import java.util.List;
import com.spring.sample.entity.Room;


public interface BillForRentService {
	List<Room> getAvailableRooms();
	
}