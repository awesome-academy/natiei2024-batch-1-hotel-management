package com.spring.sample.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RentalReceiptSummary")
public class RentalReceiptDetail extends BaseEntity implements Serializable {

    @Id
    @Column(name = "RentalReceiptID")
    private int id;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "IssueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name = "PaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Column(name = "TotalAmount")
    private Float totalAmount;

    @Column(name = "InvoicePaymentStatusText")
    private String invoicePaymentStatusText;

    @Column(name = "CheckInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;

    @Column(name = "CheckOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    @Column(name = "DailyRate")
    private Float dailyRate;

    @Column(name = "RentalPaymentStatusText")
    private String rentalPaymentStatusText;

    @Column(name = "RentalCustomerName")
    private String rentalCustomerName;

    @Column(name = "RentalCustomerAddress")
    private String rentalCustomerAddress;

    @Column(name = "RentalCustomerIDNumber")
    private String rentalCustomerIDNumber;

    @Column(name = "CustomerTypeName")
    private String customerTypeName;

    @Column(name = "SurchargeRate")
    private Float surchargeRate;

    @Column(name = "TotalInvoiceAmount")
    private Float totalInvoiceAmount;

    @Column(name = "TotalRentalDays")
    private Integer totalRentalDays;

    // Getters and Setters

    public String getRentalReceiptID() {
        return id;
    }

    public void setRentalReceiptID(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
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
