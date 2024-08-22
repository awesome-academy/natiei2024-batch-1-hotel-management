package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_TYPES") // LOAI PHONG
public class RoomType extends BaseEntity implements Serializable {
	@Id
	@Column(name = "RoomTypeID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // MA LOAI PHONG

	@Column(name = "RoomTypeName")
	private String name; // TEN LOAI PHONG

	@Column(name = "Price")
	private Integer price; // GIA CA

	@OneToMany(mappedBy = "roomType")
	Set<Room> rooms;

	@OneToMany(mappedBy = "roomType")
	Set<Revenues> revenues;

	public Set<Revenues> getRevenues() {
		return revenues;
	}

	public void setRevenues(Set<Revenues> revenues) {
		this.revenues = revenues;
	}

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

	public RoomType(Integer roomTypeID, String roomTypeName, Integer price) {
		this.id = roomTypeID;
		this.name = roomTypeName;
		this.price = price;
	}

	// Getters and Setters
	public Integer getRoomTypeID() {
		return id;
	}

	public void setRoomTypeID(Integer roomTypeID) {
		this.id = roomTypeID;
	}

	public String getRoomTypeName() {
		return name;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.name = roomTypeName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
