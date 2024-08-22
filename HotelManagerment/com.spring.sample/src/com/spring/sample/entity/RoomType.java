package com.spring.sample.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ROOM_TYPES")
public class RoomType extends BaseEntity implements Serializable {
	@Id
	@Column(name = "RoomTypeID")
	@GenericGenerator(name = "assigned-generator", strategy = "assigned")
	@GeneratedValue(generator = "assigned-generator")
	private Integer id;

	@Column(name = "RoomTypeName", unique = true, nullable = false)
	private String name;

	@Column(name = "Price", nullable = false)
	private Integer price;

	@OneToMany(mappedBy = "roomType")
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
