package com.spring.sample.service;

import java.util.List;

import com.spring.sample.entity.GuestTypes;
import com.spring.sample.entity.RoomType;
import com.spring.sample.entity.Setting;
import com.spring.sample.entity.SurchargeRate;

public interface RegulationsPageService {

    List<RoomType> getAllRoomTypes();

    List<GuestTypes> getAllGuestTypes();

    List<SurchargeRate> getAllSurchargeRates();

    List<Setting> getAllSettings();

    void updateRoomType(Integer id, String name, Integer price);

    void deleteRoomType(Integer id);

    void createRoomType(String name, Integer price);

    void updateSettingByName(String name, float value);

    void updateSurchargeRate(int id, float value);

    void deleteSurchargeRate(int id);

    void createSurchargeRate(int id, float value);

    void updateGuestType(Integer id, String name, Float surchargeRate);

    void createGuestType(String name, Float surchargeRate);

    void deleteGuestType(Integer id);

}
