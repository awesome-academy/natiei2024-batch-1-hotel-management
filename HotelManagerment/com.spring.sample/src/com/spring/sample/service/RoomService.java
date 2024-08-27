package com.spring.sample.service;

import java.util.List;

import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;

public interface RoomService {
	List<Room> getAllRooms();

	void deleteRoomById(Integer roomID);

	void updateRoom(Integer roomID, String nameRoom, String note, RoomType roomType);

	void save(Room newRoom);
	
	List<Room> filterRoom(Integer roomID, String roomType, Integer roomStatus);
}
