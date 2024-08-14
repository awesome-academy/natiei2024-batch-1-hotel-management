package com.spring.sample.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.sample.entity.RoomType;
import com.spring.sample.service.RoomTypeService;

@Service
public class RoomTypeServiceImp extends BaseServiceImpl implements RoomTypeService {
	@Override
	public Long loadCCountRecord() {
		return roomTypeDAO.getCountRecord();
	}
	
	@Override
	public List<RoomType> getAllTypeRooms() {
		return roomTypeDAO.getAllTypeRooms();
	}
}	
