package com.spring.sample.dao.imp;

import java.util.List;

import com.spring.sample.dao.SurchargeRateDAO;
import com.spring.sample.entity.SurchargeRate;

public class SurchargeRateDAOImp extends GenericDAOImp<SurchargeRate, Integer> implements SurchargeRateDAO {
	public SurchargeRateDAOImp() {
		super(SurchargeRate.class);
	}

	@Override
	public List<SurchargeRate> getAllSurchargeRates() {
		return getSession().createQuery("from SurchargeRate", SurchargeRate.class).getResultList();
	}

	@Override
	public void updateRate(int id, float value) {
		SurchargeRate obj = getSession().get(SurchargeRate.class, id);
		if (obj != null)
			obj.setSurchargeRate(value);
	}

	@Override
	public void deleteRate(int id) {
		SurchargeRate obj = getSession().get(SurchargeRate.class, id);
		getSession().remove(obj);
	}

	@Override
	public void createRate(int id, float value) {
		SurchargeRate newObj = new SurchargeRate();
		newObj.setExtraGuestCount(id);
		newObj.setSurchargeRate(value);
		getSession().save(newObj);
	}
}
