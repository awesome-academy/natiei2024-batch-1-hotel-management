package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "USERS") // BANG TAI KHOAN NGUOI DUNG
public class Users extends BaseEntity implements Serializable {

    @Id
    @Column(name = "Username", length = 50)
    private String username;

    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "FullName", length = 50)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "PermissionID")
    private Permission permission;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
