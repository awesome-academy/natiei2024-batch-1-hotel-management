package com.spring.sample.service.imp;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.sample.entity.Room;
import com.spring.sample.service.RoomService;

@Service
public class RoomServiceImp extends BaseServiceImpl implements RoomService {

	private RoomServiceImp() {
	}

	@Override
	public List<Room> getAllRooms() {
		return roomDAO.getAllRooms();
	}

}
