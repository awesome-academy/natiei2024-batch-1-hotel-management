package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS")
public class Setting extends BaseEntity implements Serializable {

    @Id
    @Column(name = "SettingName")
    private String settingName;

    @Column(name = "Value")
    private float value;

    // Getters and Setters

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
