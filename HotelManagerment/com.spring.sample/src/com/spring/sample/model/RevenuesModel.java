package com.spring.sample.model;

import javax.validation.constraints.NotNull;
import com.spring.sample.validator.NullOrNotBlank;

public class RevenuesModel extends BaseModel {

    private Integer month; // Month từ RevenueID

    private Integer year; // Year từ RevenueID

    @NotNull(message = "{revenues.validation.typeRoomId.required}")
    private Integer typeRoomId; // RoomTypeID từ RevenueID

    private String typeRoomName; // RoomTypeName từ RoomType entity

    @NotNull(message = "{revenues.validation.revenueAmount.required}")
    private Float revenueAmount; // RevenueAmount từ Revenues entity

    @NotNull(message = "{revenues.validation.rate.required}")
    private Float rate; // Rate từ Revenues entity

    @NullOrNotBlank(message = "{revenues.validation.annualTime.required}")
    private String annualTime; // annualTime nếu có

    public RevenuesModel() {
    }
    
    public RevenuesModel(Integer month, Integer year, Integer typeRoomId, String typeRoomName, Float revenueAmount, Float rate) {
        this.month = month;
        this.year = year;
        this.typeRoomId = typeRoomId;
        this.typeRoomName = typeRoomName;
        this.revenueAmount = revenueAmount;
        this.rate = rate;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTypeRoomId() {
        return typeRoomId;
    }

    public void setTypeRoomId(Integer typeRoomId) {
        this.typeRoomId = typeRoomId;
    }

    public String getTypeRoomName() {
        return typeRoomName;
    }

    public void setTypeRoomName(String typeRoomName) {
        this.typeRoomName = typeRoomName;
    }

    public Float getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(Float revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getAnnualTime() {
        return annualTime;
    }

    public void setAnnualTime(String annualTime) {
        this.annualTime = annualTime;
    }

    @Override
    public String toString() {
        return "RevenuesModel{" +
                "month=" + month +
                ", year=" + year +
                ", typeRoomId=" + typeRoomId +
                ", typeRoomName='" + typeRoomName + '\'' +
                ", revenueAmount=" + revenueAmount +
                ", rate=" + rate +
                ", annualTime='" + annualTime + '\'' +
                '}';
    }
}

