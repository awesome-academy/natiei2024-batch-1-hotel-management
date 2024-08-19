package com.spring.sample.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Room extends BaseEntity implements Serializable {

    private String roomID;
    private String roomName;
    private String note;
    private int status;
    private RoomType roomType; 

    // Constructors
    public Room() {
    	System.out.println("Da khoi tao thanh cong room");
    }

    public Room(String roomID, String roomName, String note, int status, RoomType roomType) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.note = note;
        this.status = status;
        this.roomType = roomType;
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

    public RoomType getRoomType() { // Thay đổi kiểu trả về thành RoomType
        return roomType;
    }

    public void setRoomType(RoomType roomType) { // Thay đổi kiểu tham số thành RoomType
        this.roomType = roomType;
    }
}
