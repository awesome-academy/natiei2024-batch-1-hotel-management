package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SURCHARGE_RATES")
public class SurchargeRate extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ExtraGuestCount")
    private int extraGuestCount;

    @Column(name = "SurchargeRate")
    private float surchargeRate;

    // Getters and Setters

    public int getExtraGuestCount() {
        return extraGuestCount;
    }

    public void setExtraGuestCount(int extraGuestCount) {
        this.extraGuestCount = extraGuestCount;
    }

    public float getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(float surchargeRate) {
        this.surchargeRate = surchargeRate;
    }
}
