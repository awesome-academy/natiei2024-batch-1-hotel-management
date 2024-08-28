package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.SurchargeRate;

public interface SurchargeRateDAO {
    List<SurchargeRate> getAllSurchargeRates();

    void updateRate(int id, float value);

    void deleteRate(int id);

    void createRate(int id, float value);
}
