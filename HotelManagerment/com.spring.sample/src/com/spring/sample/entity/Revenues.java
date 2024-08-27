package com.spring.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.spring.sample.entity.compositePrimaryKeys.RevenueID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "REVENUES") // DOANH THU
public class Revenues extends BaseEntity implements Serializable {

    @EmbeddedId
    private RevenueID id; // ID

    @Column(name = "RevenueAmount")
    private Float revenueAmount; // DOANH THU

    @Column(name = "Rate")
    private Float rate; // TI LE MA DOANH THU CHIEM TRONG MOT KHOANG THOI GIAN NAO DO

    @ManyToOne
    @MapsId("roomTypeID") // Maps the roomTypeID from RevenueID to the RoomType entity
    @JoinColumn(name = "RoomTypeID")
    private RoomType roomType;

	public RevenueID getId() {
		return id;
	}

	public void setId(RevenueID id) {
		this.id = id;
	}

	public Float getRevenueAmount() {
		return revenueAmount;
	}

	public void setRevenueAmount(Float revenueAmount) {
		this.revenueAmount = revenueAmount;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public Revenues(RevenueID id, Float revenueAmount, Float rate, RoomType roomType) {
	    this.id = id;
	    this.revenueAmount = revenueAmount;
	    this.rate = rate;
	    this.roomType = roomType;
	}
    
}
