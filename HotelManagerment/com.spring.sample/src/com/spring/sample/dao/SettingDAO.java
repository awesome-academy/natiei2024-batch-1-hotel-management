package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.Setting;

public interface SettingDAO {
    List<Setting> getAllSettings();

    void updateByName(String name, float value);
}
