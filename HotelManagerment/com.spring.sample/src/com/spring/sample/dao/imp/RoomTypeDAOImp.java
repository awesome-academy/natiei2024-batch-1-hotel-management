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
		String hql = "SELECT r FROM RoomType r";
		Query<RoomType> query = getSession().createQuery(hql, RoomType.class);
		return query.getResultList();
	}

	@Override
	public RoomType findById(Integer roomTypeID) {
		String hql = "FROM RoomType r WHERE r.id = :roomTypeID";
		Query<RoomType> query = getSession().createQuery(hql, RoomType.class);
		query.setParameter("roomTypeID", roomTypeID);
		return query.uniqueResult();
	}

	@Override
	public void updateRoomType(Integer id, String name, Integer price) {
		RoomType obj = getSession().get(RoomType.class, id);
		if (obj != null) {

			obj.setRoomTypeName(name);
			obj.setPrice(price);
		}
	}

	@Override
	public void deleteRoomType(Integer id) {
		RoomType obj = getSession().get(RoomType.class, id);
		getSession().remove(obj);
	}

	@Override
	public void createRoomType(String name, Integer price) {
		RoomType newObj = new RoomType();
		newObj.setRoomTypeName(name);
		newObj.setPrice(price);
		getSession().save(newObj);
	}

}
