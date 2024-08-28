package com.spring.sample.service.imp;

import java.util.List;

import com.spring.sample.entity.GuestTypes;
import com.spring.sample.entity.RoomType;
import com.spring.sample.entity.Setting;
import com.spring.sample.entity.SurchargeRate;
import com.spring.sample.service.RegulationsPageService;

public class RegulationsPageServiceImp extends BaseServiceImpl implements RegulationsPageService {

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeDAO.getAllTypeRooms();
    }

    @Override
    public List<GuestTypes> getAllGuestTypes() {
        return guestTypesDAO.getAllGuestTypes();
    }

    @Override
    public List<SurchargeRate> getAllSurchargeRates() {
        return surchargeRateDAO.getAllSurchargeRates();
    }

    @Override
    public List<Setting> getAllSettings() {
        return settingDAO.getAllSettings();
    }

    @Override
    public void updateRoomType(Integer id, String name, Integer price) {
        roomTypeDAO.updateRoomType(id, name, price);
    }

    @Override
    public void deleteRoomType(Integer id) {
        roomTypeDAO.deleteRoomType(id);
    }

    @Override
    public void createRoomType(String name, Integer price) {
        roomTypeDAO.createRoomType(name, price);
    }

    @Override
    public void updateSettingByName(String name, float value) {
        settingDAO.updateByName(name, value);
    }

    @Override
    public void updateSurchargeRate(int id, float value) {
        surchargeRateDAO.updateRate(id, value);
    }

    @Override
    public void deleteSurchargeRate(int id) {
        surchargeRateDAO.deleteRate(id);
    }

    @Override
    public void createSurchargeRate(int id, float value) {
        surchargeRateDAO.createRate(id, value);
    }

    @Override
    public void updateGuestType(Integer id, String name, Float surchargeRate) {
        guestTypesDAO.updateGuestType(id, name, surchargeRate);
    }

    @Override
    public void createGuestType(String name, Float surchargeRate) {
        guestTypesDAO.createGuestType(name, surchargeRate);
    }

    @Override
    public void deleteGuestType(Integer id) {
        guestTypesDAO.deleteGuestType(id);
    }

}
