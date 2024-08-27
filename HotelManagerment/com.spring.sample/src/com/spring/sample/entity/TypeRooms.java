package com.spring.sample.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class TypeRooms extends BaseEntity implements Serializable {
	private String typeRoomID;
	private String nameTypeRoom;
	private int price;
	
	public TypeRooms(String nameTypeRoom, int price) {
		this.nameTypeRoom = nameTypeRoom;
		this.price = price;
	}
	
	public TypeRooms(String typeRoomID, String nameTypeRoom, int price) {
		this.typeRoomID = typeRoomID;
		this.nameTypeRoom = nameTypeRoom;
		this.price = price;
	}
	
	public TypeRooms() {
		// TODO Auto-generated constructor stub
	}

	public String getTypeRoomID() {
		return typeRoomID;
	}
	public void setTypeRoomID(String typeRoomID) {
		this.typeRoomID = typeRoomID;
	}
	public String getNameTypeRoom() {
		return nameTypeRoom;
	}
	public void setNameTypeRoom(String nameTypeRoom) {
		this.nameTypeRoom = nameTypeRoom;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
