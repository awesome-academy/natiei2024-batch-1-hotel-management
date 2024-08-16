package com.spring.sample.dao.imp;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.MicropostDAO;
import com.spring.sample.entity.Micropost;

@Repository
public class MicropostDAOImp extends GenericDAOImp<Micropost, Integer> implements MicropostDAO {

	public MicropostDAOImp() {
		super(Micropost.class);
	}

	@Override
	public Long getCountRecord() {

		String countSql = "SELECT COUNT(*) FROM Micropost";
		Query<Long> queryCount = getSession().createQuery(countSql, Long.class);
		Long count = queryCount.uniqueResult();
		return count;
	}

}
