package com.spring.sample.dao.imp;

import java.util.List;

import com.spring.sample.dao.SettingDAO;
import com.spring.sample.entity.Setting;

public class SettingDAOImp extends GenericDAOImp<Setting, Integer> implements SettingDAO {
	public SettingDAOImp() {
		super(Setting.class);
	}

	@Override
	public List<Setting> getAllSettings() {
		return getSession().createQuery("from Setting", Setting.class).getResultList();
	}

	@Override
	public void updateByName(String name, float value) {
		Setting obj = getSession().get(Setting.class, name);
		if (obj != null)
			obj.setValue(value);
	}
}
