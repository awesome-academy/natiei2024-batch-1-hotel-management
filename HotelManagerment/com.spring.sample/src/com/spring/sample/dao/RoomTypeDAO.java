package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.RoomType;

public interface RoomTypeDAO {
	List<RoomType> getAllTypeRooms();

	RoomType findById(Integer typeRoomId);
}
