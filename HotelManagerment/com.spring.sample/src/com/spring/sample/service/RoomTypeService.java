package com.spring.sample.service;

import java.util.List;

import com.spring.sample.entity.RoomType;

public interface RoomTypeService {
	Long loadCCountRecord();
	
	List<RoomType> getAllTypeRooms();
}
