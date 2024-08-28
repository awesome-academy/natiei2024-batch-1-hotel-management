package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.GuestTypes;

public interface GuestTypesDAO {

    void createGuestType(String name, Float surchargeRate);

    void updateGuestType(Integer id, String name, Float surchargeRate);

    void deleteGuestType(Integer id);

    GuestTypes getGuestTypeByID();

    List<GuestTypes> getAllGuestTypes();
}
