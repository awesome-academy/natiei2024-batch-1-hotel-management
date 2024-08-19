package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class RoomType extends BaseEntity implements Serializable{
	private String roomTypeID;
    private String roomTypeName;
    private Integer price;
    Set<Room> rooms;
    
    
 public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	// Constructors
    public RoomType() {
    	System.out.println("Da khoi tao thanh cong roomtype");
    }
    
    public RoomType(String roomTypeID,String roomTypeName,Integer price) {
    	this.roomTypeID = roomTypeID;
    	this.roomTypeName = roomTypeName;
    	this.price = price;
    }
    
    // Getters and Setters
	public String getRoomTypeID() {
		return roomTypeID;
	}
	public void setRoomTypeID(String roomTypeID) {
		this.roomTypeID = roomTypeID;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
