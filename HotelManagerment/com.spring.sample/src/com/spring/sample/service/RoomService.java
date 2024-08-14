package com.spring.sample.service;
import java.util.List;


import com.spring.sample.entity.Room;

public interface RoomService {

	Long loadCCountRecord();

	List<Room> getAllRooms();

}
