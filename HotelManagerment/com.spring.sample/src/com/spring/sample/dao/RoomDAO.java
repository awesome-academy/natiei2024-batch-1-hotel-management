package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.Room;

public interface RoomDAO {
	Long getCountRecord();

	List<Room> getAllRooms();
}
