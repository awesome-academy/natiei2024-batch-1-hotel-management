package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS") // BANG THAM SO
public class Setting extends BaseEntity implements Serializable {

    @Id
    @Column(name = "SettingName", length = 20)
    private String settingName; // TEN THAM SO

    @Column(name = "Value")
    private float value; // GIA TRI

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
