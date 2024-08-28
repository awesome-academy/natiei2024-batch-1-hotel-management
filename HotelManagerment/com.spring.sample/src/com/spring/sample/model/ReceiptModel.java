package com.spring.sample.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class ReceiptModel extends BaseModel {

    private Integer id;  // Thay đổi kiểu dữ liệu từ Long thành Integer

    @NotNull(message = "{receipt.validation.roomID.required}")
    private Long roomID;

    @NotNull(message = "{receipt.validation.checkInDate.required}")
    private Date checkInDate;

    @NotNull(message = "{receipt.validation.checkOutDate.required}")
    private Date checkOutDate;

    @NotNull(message = "{receipt.validation.dailyRate.required}")
    @Positive(message = "{receipt.validation.dailyRate.positive}")
    private Double dailyRate;

    @NotEmpty(message = "{receipt.validation.paymentStatus.required}")
    @Size(max = 20, message = "{receipt.validation.paymentStatus.max}")
    private String paymentStatus;

    // Constructors
    public ReceiptModel() {
    }

    public ReceiptModel(Integer id) {
        this.id = id;
    }

    public ReceiptModel(Long roomID, Date checkInDate, Date checkOutDate, Double dailyRate, String paymentStatus) {
        this.roomID = roomID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.dailyRate = dailyRate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
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

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
