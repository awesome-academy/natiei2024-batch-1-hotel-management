package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.RoomType;

public interface RoomTypeDAO {
	List<RoomType> getAllTypeRooms();

	RoomType findById(Integer typeRoomId);

	void updateRoomType(Integer id, String name, Integer price);

	void deleteRoomType(Integer id);

	void createRoomType(String name, Integer price);
}
