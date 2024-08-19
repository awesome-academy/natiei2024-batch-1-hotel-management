package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class RentalReceiptDetail extends BaseEntity implements Serializable {

    private String rentalReceiptID;
    private String customerName;
    private java.util.Date issueDate;
    private java.util.Date paymentDate;
    private Float totalAmount;
    private String invoicePaymentStatusText;
    private java.util.Date checkInDate;
    private java.util.Date checkOutDate;
    private Float dailyRate;
    private String rentalPaymentStatusText;
    private String rentalCustomerName;
    private String rentalCustomerAddress;
    private String rentalCustomerIDNumber;
    private String customerTypeName;
    private Float surchargeRate;
    private Float totalInvoiceAmount;
    private Integer totalRentalDays;

    // Getters and Setters
    public String getRentalReceiptID() {
        return rentalReceiptID;
    }

    public void setRentalReceiptID(String rentalReceiptID) {
        this.rentalReceiptID = rentalReceiptID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public java.util.Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(java.util.Date issueDate) {
        this.issueDate = issueDate;
    }

    public java.util.Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(java.util.Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getInvoicePaymentStatusText() {
        return invoicePaymentStatusText;
    }

    public void setInvoicePaymentStatusText(String invoicePaymentStatusText) {
        this.invoicePaymentStatusText = invoicePaymentStatusText;
    }

    public java.util.Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(java.util.Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public java.util.Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(java.util.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getRentalPaymentStatusText() {
        return rentalPaymentStatusText;
    }

    public void setRentalPaymentStatusText(String rentalPaymentStatusText) {
        this.rentalPaymentStatusText = rentalPaymentStatusText;
    }

    public String getRentalCustomerName() {
        return rentalCustomerName;
    }

    public void setRentalCustomerName(String rentalCustomerName) {
        this.rentalCustomerName = rentalCustomerName;
    }

    public String getRentalCustomerAddress() {
        return rentalCustomerAddress;
    }

    public void setRentalCustomerAddress(String rentalCustomerAddress) {
        this.rentalCustomerAddress = rentalCustomerAddress;
    }

    public String getRentalCustomerIDNumber() {
        return rentalCustomerIDNumber;
    }

    public void setRentalCustomerIDNumber(String rentalCustomerIDNumber) {
        this.rentalCustomerIDNumber = rentalCustomerIDNumber;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Float getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(Float surchargeRate) {
        this.surchargeRate = surchargeRate;
    }

    public Float getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalInvoiceAmount(Float totalInvoiceAmount) {
        this.totalInvoiceAmount = totalInvoiceAmount;
    }

    public Integer getTotalRentalDays() {
        return totalRentalDays;
    }

    public void setTotalRentalDays(Integer totalRentalDays) {
        this.totalRentalDays = totalRentalDays;
    }
}