package com.spring.sample.dao.imp;

import com.spring.sample.dao.SettingDAO;
import com.spring.sample.entity.Setting;

public class SettingDAOImp extends GenericDAOImp<Setting, Integer> implements SettingDAO {
	public SettingDAOImp() {
		super(Setting.class);
	}
}
