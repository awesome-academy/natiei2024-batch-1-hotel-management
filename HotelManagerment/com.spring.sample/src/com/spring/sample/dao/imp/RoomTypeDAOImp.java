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
	public Long getCountRecord() {
		String countSql = "SELECT COUNT(*) FROM RoomType";
		Query<Long> queryCount = getSession().createQuery(countSql, Long.class);
		Long count = queryCount.uniqueResult();
		return count;
	}

	@Override
	public List<RoomType> getAllTypeRooms() {
		String hql = "SELECT r FROM RoomType r";
		Query<RoomType> query = getSession().createQuery(hql, RoomType.class);
		return query.getResultList();
	}

}
