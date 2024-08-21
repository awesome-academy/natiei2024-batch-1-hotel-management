package com.spring.sample.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PERMISSIONS")
public class Permission extends BaseEntity implements Serializable {

    @Id
    @Column(name = "PermissionID")
    private int permissionID;

    @Column(name = "PermissionName")
    private String permissionName;

    @Column(name = "RoomManagement")
    private int roomManagement;

    @Column(name = "RentalReceiptManagement")
    private int rentalReceiptManagement;

    @Column(name = "RoomLookup")
    private int roomLookup;

    @Column(name = "InvoiceManagement")
    private int invoiceManagement;

    @Column(name = "RevenueReport")
    private int revenueReport;

    @Column(name = "UserManagement")
    private int userManagement;

    @Column(name = "RegulationManagement")
    private int regulationManagement;

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
