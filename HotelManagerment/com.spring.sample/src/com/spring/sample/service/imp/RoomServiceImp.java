package com.spring.sample.service.imp;

import org.springframework.stereotype.Service;

import com.spring.sample.service.RoomService;

@Service
public class RoomServiceImp extends BaseServiceImpl implements RoomService {

	private RoomServiceImp() {
	}

	@Override
	public Long loadCCountRecord() {
		return roomDAO.getCountRecord();
	}

}
