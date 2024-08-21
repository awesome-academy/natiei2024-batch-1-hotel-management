package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.query.Query;

import com.spring.sample.dao.RoomTypeDAO;
import com.spring.sample.entity.RoomType;

public class RoomTypeDAOImp extends GenericDAOImp<RoomType, Integer> implements RoomTypeDAO {

	public RoomTypeDAOImp() {
		super(RoomType.class);
	}

	@Override
	public List<RoomType> getAllTypeRooms() {
		String hql = "SELECT r FROM ROOM_TYPES r";
		Query<RoomType> query = getSession().createQuery(hql, RoomType.class);
		return query.getResultList();
	}

	@Override
	public RoomType findById(Integer roomTypeID) {
		String hql = "FROM ROOM_TYPES r WHERE r.id = :roomTypeID";
		Query<RoomType> query = getSession().createQuery(hql, RoomType.class);
		query.setParameter("roomTypeID", roomTypeID);
		return query.uniqueResult();
	}

}
