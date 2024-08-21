package com.spring.sample.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ROOMS")
public class Room extends BaseEntity implements Serializable {

    @Id
    @Column(name = "RoomID")
    @GenericGenerator(name = "assigned-generator", strategy = "assigned")
    @GeneratedValue(generator = "assigned-generator")
    private String id;

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

    public Room(String roomID, String roomName, String note, int status, RoomType roomType) {
        this.id = roomID;
        this.name = roomName;
        this.note = note;
        this.status = status;
        this.roomType = roomType;
    }

    // Getters and Setters
    public String getRoomID() {
        return id;
    }

    public void setRoomID(String roomID) {
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

    public RoomType getRoomType() { // Thay đổi kiểu trả về thành RoomType
        return roomType;
    }

    public void setRoomType(RoomType roomType) { // Thay đổi kiểu tham số thành RoomType
        this.roomType = roomType;
    }

}
