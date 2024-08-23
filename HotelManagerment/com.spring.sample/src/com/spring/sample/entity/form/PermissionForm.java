package com.spring.sample.entity.form;

public class PermissionForm {
    private int permissionID;
    private String permissionName;
    private Boolean roomManagement;
    private Boolean rentalReceiptManagement;
    private Boolean roomLookup;
    private Boolean invoiceManagement;
    private Boolean revenueReport;
    private Boolean userManagement;
    private Boolean regulationManagement;

    // Getters và Setters
    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Boolean getRoomManagement() {
        return roomManagement;
    }

    public void setRoomManagement(Boolean roomManagement) {
        this.roomManagement = roomManagement;
    }

    public Boolean getRentalReceiptManagement() {
        return rentalReceiptManagement;
    }

    public void setRentalReceiptManagement(Boolean rentalReceiptManagement) {
        this.rentalReceiptManagement = rentalReceiptManagement;
    }

    public Boolean getRoomLookup() {
        return roomLookup;
    }

    public void setRoomLookup(Boolean roomLookup) {
        this.roomLookup = roomLookup;
    }

    public Boolean getInvoiceManagement() {
        return invoiceManagement;
    }

    public void setInvoiceManagement(Boolean invoiceManagement) {
        this.invoiceManagement = invoiceManagement;
    }

    public Boolean getRevenueReport() {
        return revenueReport;
    }

    public void setRevenueReport(Boolean revenueReport) {
        this.revenueReport = revenueReport;
    }

    public Boolean getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(Boolean userManagement) {
        this.userManagement = userManagement;
    }

    public Boolean getRegulationManagement() {
        return regulationManagement;
    }

    public void setRegulationManagement(Boolean regulationManagement) {
        this.regulationManagement = regulationManagement;
    }
}

