package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Date;

public class Receipt extends BaseEntity implements Serializable {

    private String rentalReceiptID; // Updated from Long to String
    private String roomID; // Updated from Long to String
    private Date checkInDate;
    private Date checkOutDate;
    private Float dailyRate; // Updated from Double to Float
    private Integer paymentStatus; // Updated from String to Integer

    // Getters and Setters

    public String getRentalReceiptID() {
        return rentalReceiptID;
    }

    public void setRentalReceiptID(String rentalReceiptID) {
        this.rentalReceiptID = rentalReceiptID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
