package com.spring.sample.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;


import com.spring.sample.entity.Revenues;
import com.spring.sample.model.RevenuesModel;
import com.spring.sample.service.RevenuesService;
@Service
public class RevenuesServiceImp extends BaseServiceImpl implements RevenuesService {

	private RevenuesServiceImp() {
	}
//	 @Override
//	    public Long loadCCountRecord() {
//	        return revenuesDAO.getCountRecord();
//	    }

	    @Override
	    public List<Integer> getMonths() {
	        return revenuesDAO.getMonths();
	    }

	    @Override
	    public List<Integer> getYears() {
	        return revenuesDAO.getYears();
	    }

	    @Override
	    public List<RevenuesModel> getRevenueList(int month, int year) {
	        return revenuesDAO.getRevenueList(month, year);
	    }
	    
	    @Override
	    public List<RevenuesModel> getRevenueListByMonth(int month){
	        return revenuesDAO.getRevenueListByMonth(month);
	    }

	    @Override
	    public List<RevenuesModel> getRevenueListByYear(int year){
	        return revenuesDAO.getRevenueListByYear(year);
	    }
	    
}
