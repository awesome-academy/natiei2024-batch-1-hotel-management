package com.spring.sample.dao.imp;

import java.util.List;

import com.spring.sample.dao.GuestTypesDAO;
import com.spring.sample.entity.GuestTypes;

public class GuestTypesDAOImp extends GenericDAOImp<GuestTypes, Integer> implements GuestTypesDAO {

    public GuestTypesDAOImp() {
        super(GuestTypes.class);
    }

    @Override
    public void createGuestType(String name, Float surchargeRate) {
        GuestTypes newObj = new GuestTypes();
        newObj.setTypeName(name);
        newObj.setSurchargeRate(surchargeRate);
        getSession().save(newObj);
    }

    @Override
    public void updateGuestType(Integer id, String name, Float surchargeRate) {
        GuestTypes obj = getSession().get(GuestTypes.class, id);
        if (obj != null) {
            obj.setTypeName(name);
            obj.setSurchargeRate(surchargeRate);
        }
    }

    @Override
    public void deleteGuestType(Integer id) {
        GuestTypes obj = getSession().get(GuestTypes.class, id);
        getSession().remove(obj);
    }

    @Override
    public GuestTypes getGuestTypeByID() {
        throw new UnsupportedOperationException("Unimplemented method 'getGuestTypeByID'");
    }

    @Override
    public List<GuestTypes> getAllGuestTypes() {
        return getSession().createQuery("from GuestTypes", GuestTypes.class).getResultList();
    }

}
