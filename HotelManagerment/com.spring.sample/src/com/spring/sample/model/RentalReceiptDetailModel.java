package com.spring.sample.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RentalReceiptDetailModel extends BaseModel {

    @NotEmpty(message = "{rentalReceiptDetail.validation.rentalReceiptID.required}")
    private String rentalReceiptID;

    @NotEmpty(message = "{rentalReceiptDetail.validation.customerName.required}")
    @Size(max = 30, message = "{rentalReceiptDetail.validation.customerName.max}")
    private String customerName;

    @NotEmpty(message = "{rentalReceiptDetail.validation.address.required}")
    @Size(max = 50, message = "{rentalReceiptDetail.validation.address.max}")
    private String address;

    @NotEmpty(message = "{rentalReceiptDetail.validation.idNumber.required}")
    @Size(max = 20, message = "{rentalReceiptDetail.validation.idNumber.max}")
    private String idNumber;

    @NotEmpty(message = "{rentalReceiptDetail.validation.customerTypeName.required}")
    private String customerTypeName;

    @NotNull(message = "{rentalReceiptDetail.validation.surchargeRate.required}")
    private Float surchargeRate;

    @NotNull(message = "{rentalReceiptDetail.validation.totalInvoiceAmount.required}")
    private Float totalInvoiceAmount;

    @NotNull(message = "{rentalReceiptDetail.validation.totalRentalDays.required}")
    private Integer totalRentalDays;

    // Constructors
    public RentalReceiptDetailModel() {
    }

    public RentalReceiptDetailModel(String rentalReceiptID, String customerName, String address, String idNumber,
                                    String customerTypeName, Float surchargeRate, Float totalInvoiceAmount, Integer totalRentalDays) {
        this.rentalReceiptID = rentalReceiptID;
        this.customerName = customerName;
        this.address = address;
        this.idNumber = idNumber;
        this.customerTypeName = customerTypeName;
        this.surchargeRate = surchargeRate;
        this.totalInvoiceAmount = totalInvoiceAmount;
        this.totalRentalDays = totalRentalDays;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
