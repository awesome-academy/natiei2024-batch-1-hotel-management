package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SURCHARGE_RATES") // TI LE PHU THU
public class SurchargeRate extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ExtraGuestCount")
    private int extraGuestCount; // KHACH THU MAY? (KHI SO LUONG KHACH VUOT QUA SO KHACH TOI DA 1 PHONG)

    @Column(name = "SurchargeRate")
    private float surchargeRate; // TI LE PHU THU

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
