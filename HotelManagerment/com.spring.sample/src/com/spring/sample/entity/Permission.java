package com.spring.sample.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PERMISSIONS") // PHAN QUYEN
public class Permission extends BaseEntity implements Serializable {

    @Id
    @Column(name = "PermissionID")
    private int permissionID; // MA PHAN QUYEN

    @Column(name = "PermissionName")
    private String permissionName; // TEN PHAN QUYEN

    @Column(name = "RoomManagement")
    private int roomManagement; // QUYEN QUAN LY DANH MUC PHONG

    @Column(name = "RentalReceiptManagement")
    private int rentalReceiptManagement; // QUYEN QUAN LY PHIEU THUE PHONG

    @Column(name = "RoomLookup")
    private int roomLookup; // QUYEN TRA CUU PHONG

    @Column(name = "InvoiceManagement")
    private int invoiceManagement; // QUYEN LAP HOA DON THANH TOAN

    @Column(name = "RevenueReport")
    private int revenueReport; // QUYEN LAP BAO CAO DOANH THU

    @Column(name = "UserManagement")
    private int userManagement; // QUYEN QUAN LY TAI KHOAN

    @Column(name = "RegulationManagement")
    private int regulationManagement; // QUYEN LAP QUY DINH

    @OneToMany(mappedBy = "permission")
    private Set<Users> users;

    // Getters and Setters

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

    public int getRoomManagement() {
        return roomManagement;
    }

    public void setRoomManagement(int roomManagement) {
        this.roomManagement = roomManagement;
    }

    public int getRentalReceiptManagement() {
        return rentalReceiptManagement;
    }

    public void setRentalReceiptManagement(int rentalReceiptManagement) {
        this.rentalReceiptManagement = rentalReceiptManagement;
    }

    public int getRoomLookup() {
        return roomLookup;
    }

    public void setRoomLookup(int roomLookup) {
        this.roomLookup = roomLookup;
    }

    public int getInvoiceManagement() {
        return invoiceManagement;
    }

    public void setInvoiceManagement(int invoiceManagement) {
        this.invoiceManagement = invoiceManagement;
    }

    public int getRevenueReport() {
        return revenueReport;
    }

    public void setRevenueReport(int revenueReport) {
        this.revenueReport = revenueReport;
    }

    public int getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(int userManagement) {
        this.userManagement = userManagement;
    }

    public int getRegulationManagement() {
        return regulationManagement;
    }

    public void setRegulationManagement(int regulationManagement) {
        this.regulationManagement = regulationManagement;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
