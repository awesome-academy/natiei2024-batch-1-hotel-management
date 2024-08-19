package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.query.Query;

import com.spring.sample.dao.RoomDAO;
import com.spring.sample.entity.Room;

public class RoomDAOImp extends GenericDAOImp<Room, Integer> implements RoomDAO {

	public RoomDAOImp() {
		super(Room.class);
	}

	@Override
	public List<Room> getAllRooms() {
		String hql = "SELECT r FROM Room r LEFT JOIN FETCH r.roomType t";
		// String hql = "SELECT r FROM Room r";
		Query<Room> query = getSession().createQuery(hql, Room.class);
		return query.getResultList();
	}

}