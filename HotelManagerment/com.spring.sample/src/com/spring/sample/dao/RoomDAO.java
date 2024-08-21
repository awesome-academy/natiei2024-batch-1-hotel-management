package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.Room;
import com.spring.sample.entity.RoomType;

public interface RoomDAO {
	List<Room> getAllRooms();

	public void deleteRoomById(Integer roomID);

	void UpdateRoom(Integer roomID, String nameRoom, String note, RoomType roomType);

	void save(Room newRoom);
}
