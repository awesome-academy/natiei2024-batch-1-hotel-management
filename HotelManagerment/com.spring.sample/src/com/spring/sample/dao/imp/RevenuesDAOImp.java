package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.RevenuesDAO;
import com.spring.sample.entity.Revenues;
import com.spring.sample.model.RevenuesModel;
@Repository
public class RevenuesDAOImp extends GenericDAOImp<Revenues, Integer> implements RevenuesDAO {

	public RevenuesDAOImp() {
		super(Revenues.class);
	}

	    @Override
	    public List<Integer> getMonths() {
	        String sql = "SELECT DISTINCT month FROM Revenues";
	        return getSession().createQuery(sql, Integer.class).getResultList();
	    }

	    @Override
	    public List<Integer> getYears() {
	        String sql = "SELECT DISTINCT year FROM Revenues";
	        return getSession().createQuery(sql, Integer.class).getResultList();
	    }

	    @Override
	    public List<RevenuesModel> getRevenueList(int month, int year) {
	        // Tạo câu lệnh HQL với ánh xạ vào constructor của DTO
	        StringBuilder hql = new StringBuilder("SELECT new com.spring.sample.model.RevenuesModel("
	                + "r.id.month, r.id.year, r.id.roomTypeID, tr.name, r.revenueAmount, r.rate * 100) "
	                + "FROM Revenues r JOIN r.roomType tr WHERE 1=1");

	        // Thêm điều kiện dựa trên month và year
	        if (month != -1) {
	            hql.append(" AND r.id.month = :month");
	        }
	        if (year != -1) {
	            hql.append(" AND r.id.year = :year");
	        }

	        hql.append(" ORDER BY r.id.month ASC, r.id.year ASC");

	        // Tạo truy vấn
	        Query<RevenuesModel> query = getSession().createQuery(hql.toString(), RevenuesModel.class);

	        // Gán giá trị cho các tham số nếu có
	        if (month != -1) {
	            query.setParameter("month", month);
	        }
	        if (year != -1) {
	            query.setParameter("year", year);
	        }

	        return query.getResultList();
	    }
	    
	    @Override
	    public List<RevenuesModel> getRevenueListByMonth(int month) {
	        String hql = "SELECT new com.spring.sample.model.RevenuesModel("
	                   + "r.id.month, r.id.year, r.id.roomTypeID, tr.name, r.revenueAmount, r.rate * 100) "
	                   + "FROM Revenues r JOIN r.roomType tr WHERE r.id.month = :month "
	                   + "ORDER BY r.id.year ASC";

	        Query<RevenuesModel> query = getSession().createQuery(hql, RevenuesModel.class);
	        query.setParameter("month", month);
	        return query.getResultList();
	    }

	    @Override
	    public List<RevenuesModel> getRevenueListByYear(int year) {
	        String hql = "SELECT new com.spring.sample.model.RevenuesModel("
	                   + "r.id.month, r.id.year, r.id.roomTypeID, tr.name, r.revenueAmount, r.rate * 100) "
	                   + "FROM Revenues r JOIN r.roomType tr WHERE r.id.year = :year "
	                   + "ORDER BY r.id.month ASC";

	        Query<RevenuesModel> query = getSession().createQuery(hql, RevenuesModel.class);
	        query.setParameter("year", year);
	        return query.getResultList();
	    }
}


