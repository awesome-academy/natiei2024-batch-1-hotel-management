package com.spring.sample.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RECEIPTS")
public class Receipt extends BaseEntity implements Serializable {

    @Id
    @Column(name = "RentalReceiptID")
    private String rentalReceiptID;

    @Column(name = "RoomID")
    private String roomID;

    @Column(name = "CheckInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;

    @Column(name = "CheckOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    @Column(name = "DailyRate")
    private Float dailyRate;

    @Column(name = "PaymentStatus")
    private Integer paymentStatus;

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
