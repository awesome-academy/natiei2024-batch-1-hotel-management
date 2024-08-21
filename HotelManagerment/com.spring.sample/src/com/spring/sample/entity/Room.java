package com.spring.sample.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ROOMS")
public class Room extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomID")
    private Integer id;

    @Column(name = "RoomName", unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "Note", length = 100)
    private String note;

    @Column(name = "Status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "RoomTypeID", nullable = false)
    private RoomType roomType;

    // Constructors
    public Room() {
        System.out.println("Da khoi tao thanh cong room");
    }

    public Room(Integer roomID, String roomName, String note, int status, RoomType roomType) {
        this.id = roomID;
        this.name = roomName;
        this.note = note;
        this.status = status;
        this.roomType = roomType;
    }

    // Getters and Setters
    public Integer getRoomID() {
        return id;
    }

    public void setRoomID(Integer roomID) {
        this.id = roomID;
    }

    public String getRoomName() {
        return name;
    }

    public void setRoomName(String roomName) {
        this.name = roomName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

}
