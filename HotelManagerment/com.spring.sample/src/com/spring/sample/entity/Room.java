package com.spring.sample.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Room extends BaseEntity implements Serializable {

    private String roomID;
    private String roomName;
    private String note;
    private int status;
    //private String roomType;

    // Constructors
    public Room() {}

    public Room(String roomID, String roomName, String note, int status, String roomType) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.note = note;
        this.status = status;
        //this.roomType = roomType;
    }

    // Getters and Setters
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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
    /*
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }*/
}