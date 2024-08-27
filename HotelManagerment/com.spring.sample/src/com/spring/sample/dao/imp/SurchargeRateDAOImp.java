package com.spring.sample.dao.imp;

import com.spring.sample.dao.SurchargeRateDAO;
import com.spring.sample.entity.SurchargeRate;

public class SurchargeRateDAOImp extends GenericDAOImp<SurchargeRate, Integer> implements SurchargeRateDAO {
	public SurchargeRateDAOImp() {
		super(SurchargeRate.class);
	}
}
