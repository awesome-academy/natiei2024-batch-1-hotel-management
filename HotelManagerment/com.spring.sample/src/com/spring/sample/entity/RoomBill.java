package com.spring.sample.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomBill extends BaseEntity implements Serializable {
	private String roomBillId;
	private String roomId;
	private String roomName;
	private String roomDateRent;
	private String roomDateReturn;
	private float roomPriceDay;
	private int roomPaymentStatus;

	public float getRoomPriceDay() {
		return this.roomPriceDay;
	}

	public void setRoomPriceDay(float roomPriceDay) {
		this.roomPriceDay = roomPriceDay;
	}

	public String getRoomDateReturn() {
		return this.roomDateReturn;
	}

	public void setRoomDateReturn(String roomDateReturn) {
		this.roomDateReturn = roomDateReturn;
	}

	public RoomBill(String roomBillId, String roomId, String roomName, String roomDateRent, String roomDateReturn,
			int roomPaymentStatus) {
		this.roomBillId = roomBillId;
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomDateRent = roomDateRent;
		this.roomDateReturn = roomDateReturn;
		this.roomPaymentStatus = roomPaymentStatus;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomBillId() {
		return this.roomBillId;
	}

	public void setRoomBillId(String roomBillId) {
		this.roomBillId = roomBillId;
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomDateRent() {
		return this.roomDateRent;
	}

	public void setRoomDateRent(String roomDateRent) {
		this.roomDateRent = roomDateRent;
	}

	public int getRoomPaymentStatus() {
		return this.roomPaymentStatus;
	}

	public void setRoomPaymentStatus(int roomPaymentStatus) {
		this.roomPaymentStatus = roomPaymentStatus;
	}

	public RoomBill(String roomBillId, String roomId, String roomName, String roomDateRent, int roomPaymentStatus) {
		this.roomBillId = roomBillId;
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomDateRent = roomDateRent;
		this.roomPaymentStatus = roomPaymentStatus;
	}

	public RoomBill(String roomBillId, String roomName, String roomDateRent) {
		this.roomBillId = roomBillId;
		this.roomName = roomName;
		this.roomDateRent = roomDateRent;
	}

	public RoomBill(String roomBillId, String roomName, String roomDateRent, int roomPaymentStatus) {
		this.roomBillId = roomBillId;
		this.roomName = roomName;
		this.roomDateRent = roomDateRent;
		this.roomPaymentStatus = roomPaymentStatus;
	}

	public RoomBill(String roomId, String roomDateRent) {
		this.roomId = roomId;
		this.roomDateRent = roomDateRent;
	}

	public RoomBill() {
	}

	public String toString() {
		return "RoomBill [roomBillId=" + this.roomBillId + ", roomId=" + this.roomId + ", roomName=" + this.roomName
				+ ", roomDateRent=" + this.roomDateRent + ", roomPaymentStatus=" + this.roomPaymentStatus + "]";
	}

}
