package com.spring.sample.dao.imp;

import org.hibernate.query.Query;

import com.spring.sample.dao.RoomDAO;
import com.spring.sample.entity.Room;

public class RoomDAOImp extends GenericDAOImp<Room, Integer> implements RoomDAO {

	public RoomDAOImp() {
		super(Room.class);
	}

	@Override
	public Long getCountRecord() {

		String countSql = "SELECT COUNT(*) FROM Room";
		Query<Long> queryCount = getSession().createQuery(countSql, Long.class);
		Long count = queryCount.uniqueResult();
		return count;
	}

}